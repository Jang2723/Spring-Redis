package com.example.redis.config;

import com.example.redis.dto.ItemDto;
import com.example.redis.dto.PersonDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10) // session을 얼마나 오래 유지할 것이지에 대한 설정
public class RedisConfig {
    @Bean
    public RedisTemplate<String, PersonDto> personDtoRedisTemplate(
            RedisConnectionFactory connectionFactory
    ) {
        RedisTemplate<String, PersonDto> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // 주어진 데이터의 직렬화 방식을 결정
        // Redis의 Value는 결국 문자열 형식이니까,
        // 주어진 데이터(DTO)를 어떻게 문자열로 바꿀 것인지
//        template.setDefaultSerializer(RedisSerializer.json());
        // 미리 만들어진 String 변횐기를 설정
        template.setKeySerializer(RedisSerializer.string());
        // 미리 만들어진 JSON 변환기를 설정
        template.setValueSerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisTemplate<Long, ItemDto> cacheRedisTemplate(
            RedisConnectionFactory connectionFactory
    ) {
        RedisTemplate<Long, ItemDto> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
//        template.setKeySerializer(RedisSerializer.string());
//        template.setValueSerializer(RedisSerializer.json());
        template.setDefaultSerializer(RedisSerializer.json());
        return template;
    }
}