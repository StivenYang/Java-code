package top.hengshare.interview.pattern.templateMethod.mapper;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: 针对UserModel的增、查接口
 * @author: Steven Yang
 * @create: 2019-10-15 20:42
 **/
public class UserModelMapper {
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?" +
                "user=root&password=root");
    }

    /**
     * 新增数据
     *
     * @param userModel 要新增的数据对象
     */
    public void create(UserModel userModel) {
        Connection conn = null;
        try {
            conn = this.getConnection();
            String sql = "insert into test values (?,?,?)";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, userModel.getUuid());
            pstat.setString(2, userModel.getName());
            pstat.setInt(3, userModel.getAge());

            pstat.executeUpdate();
            pstat.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过条件查询
     *
     * @param queryModel 条件查询使用的对象
     * @return 查询到的结果集
     */
    public Collection getByCondition(UserModel queryModel) {
        Collection col = Lists.newArrayList();
        Connection conn = null;
        try {
            conn = this.getConnection();
            String sql = "select * from test where 1=1";
            sql = this.prepareSql(sql, queryModel);
            PreparedStatement pstat = conn.prepareStatement(sql);
            this.setValue(pstat, queryModel);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                col.add(this.rs2Obj(rs));
            }
            rs.close();
            pstat.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return col;
    }

    /**
     * 把查询的结果集转换成为对象
     *
     * @param rs 查询返回的结果集
     * @return 查询返回的结果集转换成的对象
     * @throws SQLException sql异常
     */
    private UserModel rs2Obj(ResultSet rs) throws SQLException {
        UserModel userModel = new UserModel();
        String uuid = rs.getString("uuid");
        String name = rs.getString("name");
        int age = rs.getInt("age");

        userModel.setUuid(uuid);
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;
    }

    /**
     * 为通用查询的sql动态设置条件的值
     *
     * @param pstat      预处理查询sql的对象
     * @param queryModel 封装查询条件的数据模型
     */
    private void setValue(PreparedStatement pstat, UserModel queryModel) throws SQLException {
        int count = 1;
        if (StringUtils.isNotEmpty(queryModel.getUuid())) {
            pstat.setString(count, queryModel.getUuid());
            count++;
        }
        if (StringUtils.isNotEmpty(queryModel.getName())) {
            pstat.setString(count, queryModel.getName());
            count++;
        }
        if (queryModel.getAge() > 0) {
            pstat.setInt(count, queryModel.getAge());
            count++;
        }
    }

    private String prepareSql(String sql, UserModel queryModel) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(sql);
        //绝对匹配
        if (StringUtils.isNotEmpty(queryModel.getUuid())) {
            buffer.append(" and uuid=? ");
        }
        //模糊匹配
        if (StringUtils.isNotEmpty(queryModel.getName())) {
            buffer.append(" and name like ?");
        }
        //区间匹配
        if (queryModel.getAge() > 0) {
            buffer.append(" and age <=?");
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        UserModelMapper mapper = new UserModelMapper();
        UserModel userModel = new UserModel();
        userModel.setUuid("001");
        userModel.setName("user01");
        userModel.setAge(20);

        //插入数据
        mapper.create(userModel);
        userModel.setUuid("002");
        mapper.create(userModel);
        userModel.setUuid("003");
        mapper.create(userModel);

        //查询数据
        UserModel query = new UserModel();
        query.setName("user01");
        mapper.getByCondition(query).forEach(System.out::println);
    }
}
