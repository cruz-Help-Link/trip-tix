package org.dafe.tripTix.configs;

import org.dafe.tripTix.caching.CustomCacheEventLogger;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.core.EhcacheManager;
import org.ehcache.jsr107.EhcacheCachingProvider;
import org.ehcache.xml.model.TimeUnit;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.FactoryBuilder;
import javax.cache.configuration.MutableCacheEntryListenerConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

import java.net.URISyntaxException;
import java.util.Objects;

import static javax.cache.expiry.Duration.*;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() throws URISyntaxException {
        CachingProvider cachingProvider = Caching.getCachingProvider(EhcacheCachingProvider.class.getName());
        return cachingProvider.getCacheManager(
                Objects.requireNonNull(getClass().getResource("/ehcache.xml")).toURI(),
                getClass().getClassLoader()
        );
    }

//    @Bean
//    public EhcacheManager ehcacheManager() {
//        return new JCacheManagerCustomizer() {
//            @Override
//            public void customize(CacheManager cacheManager) {
//                cacheManager.createCache("bookings", CacheConfigurationBuilder.newCacheConfigurationBuilder(
//                                Long.class, Object.class, ResourcePoolsBuilder.newResourcePoolsBuilder()
//                                        .heap(100, EntryUnit.ENTRIES)
//                                        .offheap(100, MemoryUnit.MB)
//                                        .disk(200, MemoryUnit.MB, true))
//                        .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(10)))
//                        .build());
//            }
//        };
//    }
}
