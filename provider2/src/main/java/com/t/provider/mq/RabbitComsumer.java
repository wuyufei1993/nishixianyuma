package com.t.provider.mq;

import com.t.provider.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.TEST_QUEUE)
public class RabbitComsumer {

    @RabbitHandler
    public void process(String str) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + str);
    }

}
