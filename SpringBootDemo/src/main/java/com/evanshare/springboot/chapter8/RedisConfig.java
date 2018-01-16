package com.evanshare.springboot.chapter8;

import com.evanshare.springboot.chapter8.Serializer.ObjectRedisSerializer;
import com.evanshare.springboot.chapter8.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
*
 * Created by liangyh on 2018/1/16.
 * Email:10856214@163.com
*/

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setDatabase(0);
        connectionFactory.setHostName("192.168.129.128");
        connectionFactory.setPort(6379);
        return connectionFactory;
    }
    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new ObjectRedisSerializer());
        return template;
    }

}
