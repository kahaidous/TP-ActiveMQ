package ma.emsi.activemqproducer.config;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Queue;
import jakarta.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class ActiveMQConf {
    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean //l'objet qui gère les connexions avec le broker ActiveMQ
    public ConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory
                = new ActiveMQConnectionFactory(brokerUrl);
        return activeMQConnectionFactory;
    }

    @Bean //L'utilitaire pour envoyer et recevoir les msgs
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate =
                new JmsTemplate(activeMQConnectionFactory());
        //jmsTemplate.setConnectionFactory(activeMQConnectionFactory());
        //jmsTemplate.setDefaultDestinationName("");
        //jmsTemplate.setTimeToLive(10000);
        //jmsTemplate.setPubSubDomain(true);
        //jmsTemplate.setDeliveryPersistent(true);
        return jmsTemplate;
    }
    @Bean
    Queue queue(){
        return new ActiveMQQueue("Queue-G51");
    }

    @Bean
    Topic topic(){
        return new ActiveMQTopic("Topic-G4");
    }
}
