package com.example.demo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Properties;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/3/2017:10
 */
public class KafkaDemo {

    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put("bootstrap","localhost:9090");
        prop.put("acks", "all");
        prop.put("retries", 0);
        prop.put("batch.size", 16384);
        prop.put("linger.ms", 1);
        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(prop);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String,String>("test",Integer.toString(i),Integer.toString(i)));
        }
        producer.close();

    }
}
