package org.example.streamtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * 监听通道的消息,并作出处理
 */
@Slf4j
@Service
@EnableBinding(IReceiverService.class)
public class ReceiverService {

    @StreamListener("talk.queue")
    public void onReceiver(Message msg) {
        log.info("接收rabbitmq消息消费:" + msg.getPayload());
    }
}