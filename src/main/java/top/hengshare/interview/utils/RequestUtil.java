package top.hengshare.interview.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * 从请求头获取一些信息的工具类
 *
 * @author yjh
 * @since 2021/1/13 3:02 下午
 **/
public class RequestUtil {

	public static String getIpFromRequest(HttpServletRequest request) {
		String ip = null;
		//X-Forwarded-For：Squid 服务代理
		String ipAddresses = request.getHeader("X-Forwarded-For");
		if (null == ipAddresses || 0 == ipAddresses.length() || "unknown".equalsIgnoreCase(ipAddresses)) {
			//Proxy-Client-IP：apache 服务代理
			ipAddresses = request.getHeader("Proxy-Client-IP");
		}
		if (null == ipAddresses || 0 == ipAddresses.length() || "unknown".equalsIgnoreCase(ipAddresses)) {
			//WL-Proxy-Client-IP：weblogic 服务代理
			ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ipAddresses || 0 == ipAddresses.length() || "unknown".equalsIgnoreCase(ipAddresses)) {
			//HTTP_CLIENT_IP：有些代理服务器
			ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		}
		if (null == ipAddresses || 0 == ipAddresses.length() || "unknown".equalsIgnoreCase(ipAddresses)) {
			//X-Real-IP：nginx服务代理
			ipAddresses = request.getHeader("X-Real-IP");
		}
		//有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
		if (ipAddresses != null && ipAddresses.length() != 0) {
			ip = ipAddresses.split(",")[0];
		}
		//还是不能获取到，最后再通过request.getRemoteAddr();获取
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ipAddresses)) {
			ip = request.getRemoteAddr();
		}
		return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
	}

	public static Map<String, Object> getParameters(HttpServletRequest request) {
		Map<?, ?> parameterMap = request.getParameterMap();
		Map<String, Object> map = new HashMap<>();

		for (Object o : parameterMap.keySet()) {
			String key = (String) o;
			String[] values = (String[]) parameterMap.get(key);
			map.put(key, values[0]);
		}

		return map;
	}
}
