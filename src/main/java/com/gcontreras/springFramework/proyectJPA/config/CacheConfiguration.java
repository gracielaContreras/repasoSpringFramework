package com.gcontreras.springFramework.proyectJPA.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class CacheConfiguration {
/*    @Bean
    public CacheManager getManager(){
      return new ConcurrentMapCacheManager("users"); //para usar la memoria de la máquina local
    }*/

    /**
     * Se configura el cache manager
     */
    @Bean
    public CacheManager getCache(RedissonClient redissonClient) throws IOException {
        Map<String, CacheConfig> cacheConfig = new HashMap<>();
        cacheConfig.put("users", new CacheConfig());
        return new RedissonSpringCacheManager(redissonClient, cacheConfig);
    }

    /**
     * Se configura el cliente Redisson
     */
    @Bean(destroyMethod ="shutdown") // Se destruirá si se detiene la aplicación
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().
                setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }
}
