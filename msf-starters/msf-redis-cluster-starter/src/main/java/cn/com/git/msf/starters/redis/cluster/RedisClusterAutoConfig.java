package cn.com.git.msf.starters.redis.cluster;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by serj on 2016/2/25.
 */
@Configuration
@EnableConfigurationProperties(RedisClusterProperties.class)
public class RedisClusterAutoConfig {
    @Autowired
    private RedisClusterProperties properties;

    private Set<HostAndPort> parseHostAndPort() throws Exception {
        try {
            String[] addressString = properties.getHosts().trim().split(",");
            Set<HostAndPort> haps = new HashSet<HostAndPort>();
            for (String anAddressString : addressString) {
                String val = anAddressString.trim();
                String[] ipAndPort = val.split(":");
                HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
                haps.add(hap);
            }
            return haps;
        } catch (IllegalArgumentException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new Exception("解析 jedis 配置文件失败", ex);
        }
    }

    @Bean
    public JedisCluster jedisCluster() throws Exception {
        Set<HostAndPort> haps = parseHostAndPort();
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(properties.getMaxTotal());
        genericObjectPoolConfig.setMaxWaitMillis(properties.getMaxWaitMillis());
        genericObjectPoolConfig.setMaxIdle(properties.getMaxIdle());
        genericObjectPoolConfig.setTestOnBorrow(properties.isTestOnBorrow());
        return new JedisCluster(haps, properties.getTimeout(), properties.getMaxRedirections(), genericObjectPoolConfig);
    }
}
