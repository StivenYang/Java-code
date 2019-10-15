package top.hengshare.interview.pattern.templateMethod.mapper;

import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: 一个实现了简单 增删改查功能的模板
 * @author: Steven Yang
 * @create: 2019-10-15 20:46
 **/
public abstract class JDBCTemplate {

    /**
     * 增
     */
    protected final static int TYPE_CREATE = 1;
    /**
     * 删
     */
    protected final static int TYPE_DELETE = 2;
    /**
     * 改
     */
    protected final static int TYPE_UPDATE = 3;
    /**
     * 查
     */
    protected final static int TYPE_SELECT = 4;

    /***********************模板方法*****************************/

    public final void create(Object object) {
        //获取新增的SQL
        String sql = this.getMainSql(TYPE_CREATE);
        //调用通用的更新实现
        this.executeUpdate(sql, TYPE_CREATE, object);
    }

    public final void delete(Object object) {
        //获取修改的sql
        String sql = this.getMainSql(TYPE_DELETE);
        //调用通用的删除实现
        this.executeUpdate(sql, TYPE_DELETE, object);
    }

    public final void update(Object object) {
        //获取修改的SQL
        String sql = this.getMainSql(TYPE_UPDATE);
        //调用通用的更新实现
        this.executeUpdate(sql, TYPE_UPDATE, object);
    }

    public final Collection getByCondition(Object object) {
        //获取查询的SQL
        String sql = this.getMainSql(TYPE_SELECT);
        //调用通用的查询实现
        return this.getByCondition(sql, object);
    }

    /********************原语操作***************************/

    protected abstract String getMainSql(int type);

    protected abstract void setUpdateSqlValue(int type, PreparedStatement pstmt, Object object) throws Exception;

    protected abstract String prepareQuerySql(String sql, Object queryModel);

    protected abstract void setQuerySqlValue(PreparedStatement pstmt, Object queryModel) throws Exception;

    protected abstract Object rs2Object(ResultSet rs) throws Exception;

    /********************钩子操作***************************/

    /**
     * 获取连接
     *
     * @return 连接对象
     * @throws Exception
     */
    protected Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?" +
                "user=root&password=root");
    }

    /**
     * 执行查询
     *
     * @param sql
     * @param typeCreate
     * @param object
     */
    protected void executeUpdate(String sql, int typeCreate, Object object) {
        Connection conn = null;
        try {
            //调用钩子方法
            conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            this.setUpdateSqlValue(typeCreate, pstmt, object);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据条件查询数据
     *
     * @param sql
     * @param condition
     * @return
     */
    protected Collection getByCondition(String sql, Object condition) {
        Collection col = Lists.newArrayList();
        Connection conn = null;
        try {
            //调用钩子方法
            conn = this.getConnection();
            //调用原语操作，给sql设置查询查询条件
            sql = this.prepareQuerySql(sql, condition);
            //预编译sql语句
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //调用原语操作，给预编译后的SQL语句设置查询参数
            this.setQuerySqlValue(pstmt, condition);
            //执行查询
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //调用原语操作
                col.add(this.rs2Object(rs));
            }
            rs.close();
            pstmt.close();
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
}
