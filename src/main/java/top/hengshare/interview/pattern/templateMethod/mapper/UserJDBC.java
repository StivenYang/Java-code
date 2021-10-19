package top.hengshare.interview.pattern.templateMethod.mapper;

import org.apache.commons.lang3.StringUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @program: Java-Interview
 * @description: 具体的实现用户管理的增删改查功能
 * @author: Steven Yang
 * @create: 2019-10-15 21:39
 **/
public class UserJDBC extends JDBCTemplate {
	@Override
	protected String getMainSql(int type) {
		String sql = "";
		if (type == TYPE_CREATE) {
			sql = "insert into test values(?,?,?)";
		} else if (type == TYPE_DELETE) {
			sql = "delete from test where uuid = ?";
		} else if (type == TYPE_UPDATE) {
			sql = "update test set name=?,age=? where uuid=?";
		} else if (type == TYPE_SELECT) {
			sql = "select * from test where 1=1 ";
		}
		return sql;
	}

	@Override
	protected void setUpdateSqlValue(int type, PreparedStatement pstmt, Object object) throws Exception {
		if (type == TYPE_CREATE) {
			this.setCreateValue(pstmt, (UserModel) object);
		} else if (type == TYPE_UPDATE) {
			this.setUpdateValue(pstmt, (UserModel) object);
		} else if (type == TYPE_DELETE) {
			this.setDeleteValue(pstmt, (UserModel) object);
		}
	}

	private void setDeleteValue(PreparedStatement pstmt, UserModel object) throws Exception {
		pstmt.setString(1, object.getUuid());
	}

	private void setUpdateValue(PreparedStatement pstmt, UserModel object) throws Exception {
		pstmt.setString(1, object.getName());
		pstmt.setInt(2, object.getAge());
		pstmt.setString(3, object.getUuid());
	}

	private void setCreateValue(PreparedStatement pstmt, UserModel object) throws Exception {
		pstmt.setString(1, object.getUuid());
		pstmt.setString(2, object.getName());
		pstmt.setInt(3, object.getAge());
	}

	@Override
	protected String prepareQuerySql(String sql, Object query) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(sql);
		if (query == null) {
			return buffer.toString();
		}
		UserModel queryModel = (UserModel) query;

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

	@Override
	protected void setQuerySqlValue(PreparedStatement pstmt, Object query) throws Exception {
		if (query == null) {
			return;
		}
		UserModel queryModel = (UserModel) query;
		int count = 1;
		if (StringUtils.isNotEmpty(queryModel.getUuid())) {
			pstmt.setString(count, queryModel.getUuid());
			count++;
		}
		if (StringUtils.isNotEmpty(queryModel.getName())) {
			pstmt.setString(count, queryModel.getName());
			count++;
		}
		if (queryModel.getAge() > 0) {
			pstmt.setInt(count, queryModel.getAge());
			count++;
		}
	}

	@Override
	protected Object rs2Object(ResultSet rs) throws Exception {
		UserModel um = new UserModel();
		String uuid = rs.getString("uuid");
		String name = rs.getString("name");
		int age = rs.getInt("age");

		um.setName(name);
		um.setUuid(uuid);
		um.setAge(age);

		return um;
	}
}
