package pl.producer.infrastructure.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.producer.infrastructure.jms.JmsMessageSender;

@EnableJms
@Configuration
@EnableScheduling
public class JmsConfig {

    @Value("${jms.queue.name}")
    private String queueName;

    @Bean
    public SQSConnectionFactory connectionFactory() {
        AmazonSQSAsync build = AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("x", "y")))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localstack:4566", "default"))
                .build();

        return new SQSConnectionFactory(new ProviderConfiguration(), build);
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(SQSConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(SQSConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    public JmsMessageSender jmsMessageSender(JmsTemplate jmsTemplate) {
        return new JmsMessageSender(jmsTemplate, queueName);
    }
}
