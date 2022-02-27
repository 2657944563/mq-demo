package cn.itcast.mq;

import lombok.SneakyThrows;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.lang.model.type.ExecutableType;

@Component
public class SpringConsumer {
    @SneakyThrows
    @RabbitListener(queues = "simple")
    public void te(String msg) {
//        Thread.sleep(100);
        System.out.println(msg);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void te1(String msg) {
//        Thread.sleep(100);
        System.out.println(msg + "-----fanout.queue1");
    }

    @RabbitListener(queues = "fanout.queue2")
    public void te2(String msg) {
//        Thread.sleep(100);
        System.out.println(msg + "-----fanout.queue2");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void te3(String msg) {
        System.out.println("queue1: " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void te4(String msg) {
        System.out.println("queue2: " + msg);
    }
}
