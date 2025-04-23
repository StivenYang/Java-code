package top.hengshare.interview.redis;

import cn.hutool.json.JSONObject;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 使用spring模板操作redis
 *
 * @author yangjh
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TemplateController {

	private final StringRedisTemplate redisTemplate;

	@GetMapping("/redis/list/set")
	public String setList() {
		List<String> result = Lists.newArrayList();
		for (int i = 0; i < 10; i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", "yangjh" + i);
			jsonObject.put("age", i);
			result.add(jsonObject.toString());
		}
		redisTemplate.opsForList().rightPushAll("list", result);
		return "success";
	}
}
