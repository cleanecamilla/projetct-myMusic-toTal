package com.ciandt.summit.bootcamp2022.config;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import static java.util.concurrent.TimeUnit.MINUTES;

@Component
public class CacheConfig implements JCacheManagerCustomizer {

    @Override
    public void customize(CacheManager cacheManager)
    {
        cacheManager.createCache("buscarMusicas", new MutableConfiguration<>()
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(MINUTES, 10)))
                .setStoreByValue(false)
                .setStatisticsEnabled(true));
    }
}
