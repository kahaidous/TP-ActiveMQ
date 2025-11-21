package ma.emsi.activemqproducer.controller;

import jakarta.jms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class Producer {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    private Queue queue;

    @GetMapping("/message/{msg}")
    public String sendMessageToQueue(@PathVariable String msg) {
        try {
            jmsTemplate.convertAndSend(queue, msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Hello ActiveMQ: "+msg+".";
    }
}