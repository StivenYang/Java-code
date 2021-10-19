package top.hengshare.interview.algorithm.interview;

import java.util.Date;

/**
 * Student
 *
 * @author yjh
 * @since 2021/1/7 8:11 下午
 **/
public class Student {

	private String username;

	private Date birthday;

	public Student(String username, Date birthday) {
		this.username = username;
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		final Student student = (Student) obj;
		if (this == student) {
			return true;
		} else {
			return (this.username.equals(student.username) && this.birthday == student.birthday);
		}
	}

	@Override
	public int hashCode() {
		int hashno = 7;
		hashno = 13 * hashno + (username == null ? 0 : username.hashCode());
		return hashno;
	}

	@Override
	public String toString() {
		return "Student{" + "username='" + username + '\'' + ", birthday=" + birthday + '}';
	}
}