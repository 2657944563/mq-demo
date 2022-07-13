package cn.itcast.mq.helloworld;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqp {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @SneakyThrows
    @Test
    public void test1() {
        for (Integer i = 0; i < 50; i++) {
            Thread.sleep(10);
            rabbitTemplate.convertAndSend("simple", LocalTime.now() + "____" + i.toString());
        }
    }

    @SneakyThrows
    @Test
    public void test2() {
        String exchangeName = "itcast.fanout";
        String msg = "hello every one!";
        rabbitTemplate.convertAndSend(exchangeName, "", msg);
    }

    @SneakyThrows
    @Test
    public void test3() {
        String exchangeName = "itcast.direct";
        String msg = "hello every one!";
        rabbitTemplate.convertAndSend(exchangeName, "red", msg);
    }

    @SneakyThrows
    @Test
    public void test4() {
        String exchangeName = "objectQueue";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("zs", "12");
        rabbitTemplate.convertAndSend(exchangeName, hashMap);
    }
}
