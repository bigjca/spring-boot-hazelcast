package bigjca.sandbox;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    Config config() {
        Config config = new Config();
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getKubernetesConfig().setEnabled(true)
                .setProperty("namespace", "jsandbox")
                .setProperty("service-name", "hazelcast-service");
        return config;
    }

    @Bean
    CacheManager cacheManager() {
        return new HazelcastCacheManager(Hazelcast.newHazelcastInstance());
    }
}
