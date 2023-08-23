package com.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.ashokit.binding.User;

@SpringBootApplication
public class Sb06RedisCacheApiApplication {

	@Bean
	JedisConnectionFactory connectionFactory() {

		JedisConnectionFactory jcf = new JedisConnectionFactory();
		// jcf.setHostName(hostName);
		// jcf.setPassword(password);
		// jcf.setPort(port);
		return jcf;
	}

	@Bean
	RedisTemplate<String, User> redisTemplate() {

		RedisTemplate<String, User> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory());
		return template;

	}

	public static void main(String[] args) {
		SpringApplication.run(Sb06RedisCacheApiApplication.class, args);
	}

}
