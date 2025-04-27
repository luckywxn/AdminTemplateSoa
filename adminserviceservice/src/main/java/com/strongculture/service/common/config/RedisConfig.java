package com.strongculture.service.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.text.SimpleDateFormat;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.database}")
    private int dbIndex;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.pool.max-active}")
    private int redisPoolMaxActive;
    @Value("${spring.redis.pool.max-wait}")
    private int redisPoolMaxWait;
    @Value("${spring.redis.pool.max-idle}")
    private int redisPoolMaxIdle;
    @Value("${spring.redis.pool.min-idle}")
    private int redisPoolMinIdle;

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        //ObjectMapper 指定在转成json的时候的一些转换规则
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        template.setConnectionFactory(defaultRredisConnectionFactory());
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //把自定义objectMapper设置到jackson2JsonRedisSerializer中（可以不设置，使用默认规则）
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //RedisTemplate默认的序列化方式使用的是JDK的序列化
        //设置了key的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        //设置了value的序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    /**
     * 配置redis连接工厂
     *
     * @return
     */
    public RedisConnectionFactory defaultRredisConnectionFactory() {
        return createJedisConnectionFactory(dbIndex, host, port, password, timeout);
    }

    /**
     * 创建redis连接工厂
     *
     * @param dbIndex
     * @param host
     * @param port
     * @param password
     * @param timeout
     * @return
     */
    public JedisConnectionFactory createJedisConnectionFactory(int dbIndex, String host, int port, String password, int timeout) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setDatabase(dbIndex);
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setTimeout(timeout);
        jedisConnectionFactory.setPoolConfig(setPoolConfig(redisPoolMaxIdle, redisPoolMinIdle, redisPoolMaxActive, redisPoolMaxWait));
        return jedisConnectionFactory;

    }

    /**
     * 设置连接池属性
     *
     * @param maxIdle
     * @param minIdle
     * @param maxActive
     * @param maxWait
     * @return
     */
    public JedisPoolConfig setPoolConfig(int maxIdle, int minIdle, int maxActive, int maxWait) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setTestOnBorrow(true);
        return poolConfig;
    }

    /**
     * 设置RedisTemplate的序列化方式
     *
     * @param redisTemplate
     */
    public void setSerializer(RedisTemplate redisTemplate) {
        //设置键（key）的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置值（value）的序列化方式
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();
    }
}
