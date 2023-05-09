package com.gary.messaging.standaloneactivemqexample.resource;

import com.gary.messaging.standaloneactivemqexample.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message")
                          final String message) {

        jmsTemplate.convertAndSend(queue, message);

        return "Published Successfully";
    }

    @PostMapping
    public String publishObject(@RequestBody final Notification notification) {

        jmsTemplate.convertAndSend(queue, notification);

        return "Published Successfully";
    }
}
