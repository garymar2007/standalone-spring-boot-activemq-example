package com.gary.messaging.standaloneactivemqexample.listener;

import com.gary.messaging.standaloneactivemqexample.notification.Notification;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

//    @JmsListener(destination = "standalone.queue")
//    public void consume(String message) {
//        System.out.println("Received Message: " + message);
//    }

    @JmsListener(destination = "standalone.queue")
    public void consume(Notification notification) {
        System.out.println("Received Message: " + notification);
    }

}
