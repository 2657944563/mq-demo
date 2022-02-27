package cn.itcast.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublisherApplicatioin {
    public static void main(String[] args) {
        SpringApplication.run(PublisherApplicatioin.class, args);
    }
}
