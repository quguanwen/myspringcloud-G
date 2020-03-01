package org.example.streamtest;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IReceiverService {

    /**
     * 指定交换机名称
     * */

    @Input("talk.queue")
    SubscribableChannel receiver();

}
