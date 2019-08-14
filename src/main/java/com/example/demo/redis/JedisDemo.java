package com.example.demo.redis;

import redis.clients.jedis.Jedis;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/2/2012:28
 */
public class JedisDemo {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1");

        jedis.set("hello", "world");
    }
}
