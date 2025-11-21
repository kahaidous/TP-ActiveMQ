package ma.emsi.activemqconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class Consumer {

    @JmsListener(destination = "Queue-G51")
    public void getFromQueue(String msg){

        //Processing
        System.out.println("MSG: " + msg);
    }
}
