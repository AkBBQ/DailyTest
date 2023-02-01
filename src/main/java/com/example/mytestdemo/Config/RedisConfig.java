package com.example.mytestdemo.Config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * 设置Redis序列化方式，默认使用的JDKSerializer的序列化方式，效率低，这里我们使用 FastJsonRedisSerializer
     * @param redisConnectionFactory
     * @return
     */

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate();

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key序列化
        template.setKeySerializer(stringRedisSerializer);
        // value序列化
        template.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));

        // Hash key序列化
        template.setHashKeySerializer(new StringRedisSerializer());
        // Hash value序列化
        template.setHashValueSerializer(new StringRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);

        return template;
    }
}
