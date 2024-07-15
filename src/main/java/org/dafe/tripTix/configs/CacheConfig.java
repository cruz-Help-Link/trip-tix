package org.dafe.tripTix.configs;

import lombok.SneakyThrows;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.DiskStorePathManager;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

@EnableCaching
@org.springframework.context.annotation.Configuration
public class CacheConfig {

    @Bean
    public CacheManager ehCacheManager() throws IOException, URISyntaxException {
        Configuration config = new Configuration();
        config.addCache(getDefaultCacheConfiguration());

        // Load configuration from ehcache.xml
        CacheManager cacheManager = CacheManager.create(getClass().getResource("/ehcache.xml"));
        cacheManager.getDiskStorePathManager().getFile(getDiskStore());

        return cacheManager;
    }

    // Example: Default cache configuration
    private net.sf.ehcache.config.CacheConfiguration getDefaultCacheConfiguration() throws IOException {
        net.sf.ehcache.config.CacheConfiguration cacheConfiguration = new net.sf.ehcache.config.CacheConfiguration();
        cacheConfiguration.setName("defaultCache");
        cacheConfiguration.setMaxEntriesLocalHeap(1000);
        cacheConfiguration.setTimeToLiveSeconds(3600);
        return cacheConfiguration;
    }



    public String getDiskStore() throws IOException {
        String tmpdir = Files.createTempDirectory("tmpDirPrefix").toFile().getAbsolutePath();
        String tmpDirsLocation = System.getProperty("java.io.tmpdir");
//        assertThat(tmpdir).startsWith(tmpDirsLocation);
        return  tmpDirsLocation;
    }


    @Bean
    public org.springframework.cache.CacheManager cacheManager(CacheManager cacheManager) throws IOException {
        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
        jCacheCacheManager.getCacheManager();

        return jCacheCacheManager;
    }
}
