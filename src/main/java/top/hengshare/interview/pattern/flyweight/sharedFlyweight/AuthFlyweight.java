package top.hengshare.interview.pattern.flyweight.sharedFlyweight;

import lombok.Getter;

/**
 * @program: Java-Interview
 * @description: 认证享元
 * @author: StivenYang
 * @create: 2019-10-22 11:57
 **/
public class AuthFlyweight implements Flyweight {

	/**
	 * 认证实体
	 */
	@Getter
	private String authEntity;

	/**
	 * 权限
	 */
	@Getter
	private String permit;

	/**
	 * 认证享元，初始化享元内部状态
	 * @param state 初始化享元内部状态
	 */
	public AuthFlyweight(String state) {
		String ss[] = state.split(",");
		authEntity = ss[0];
		permit = ss[1];
	}

	/**
	 * 对权限进行校验，
	 */
	@Override
	public boolean match(String entity, String permit) {
		if (entity.equals(authEntity) && permit.equals(permit)) {
			return true;
		}
		return false;
	}
}
