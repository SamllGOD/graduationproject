package com.example.graduationproject.config;


//import jakarta.annotation.Resource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//
//@Configuration
//public class MyRedisConfig {
//
//    @Resource
//    private RedisConnectionFactory factory;
//    @Bean
//    public RedisTemplate redisTemplate(){
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        //redis序列化处理
//        // 设置key序列化方式string，RedisSerializer.string() 等价于 new StringRedisSerializer()
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        //对象存入String类型中需要将对象转换为json
//        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        redisTemplate.setValueSerializer(serializer);
//        // 设置hash的key的序列化方式
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        // 设置hash的value的序列化方式
//        redisTemplate.setHashValueSerializer(serializer);
//        // 使配置生效
//        redisTemplate.afterPropertiesSet();
//
//        return redisTemplate;
//    }
//}


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class MyRedisConfig {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        // 自定义 String Object
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        // ObjectMapper 转译
        ObjectMapper objectMapper = createObjectMapper();

        // Json 序列化配置
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);

        // String 的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key 采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash 的key也采用 String 的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value 序列化方式采用 jackson
        template.setValueSerializer(objectJackson2JsonRedisSerializer);
        // hash 的 value 采用 jackson
        template.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        template.setConnectionFactory(redisConnectionFactory);
        template.afterPropertiesSet();

        return template;
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY
        );
        return mapper;
    }
}
