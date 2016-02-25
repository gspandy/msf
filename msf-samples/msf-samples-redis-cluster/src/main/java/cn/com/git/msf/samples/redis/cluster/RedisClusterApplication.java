package cn.com.git.msf.samples.redis.cluster;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.JedisCluster;

/**
 * Created by serj on 2016/2/25.
 */
@SpringBootApplication
public class RedisClusterApplication {
    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new SpringApplicationBuilder(RedisClusterApplication.class).run(args);
            JedisCluster jedisCluster = (JedisCluster) ctx.getBean("jedisCluster");
            System.out.println(jedisCluster);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
