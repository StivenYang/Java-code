package top.hengshare.interview.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

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


}
