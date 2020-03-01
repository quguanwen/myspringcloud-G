package org.example.streamtest;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 发送消息的通道
 * */
public interface ISendService {

    /**
     * 通道绑定交换机
     * */

    @Output("talk.queue")
    MessageChannel send();

}
