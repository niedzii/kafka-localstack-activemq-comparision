package pl.producer.integration.activemq;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
@RequiredArgsConstructor
public class Producer {
  private final JmsTemplate jmsTemplate;

  private static final String topicName = "test";

  public void sendMessage(String message) {
    jmsTemplate.send(topicName, new MessageCreator() {
      @Override
      public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(message);
      }
    });
  }
}
