package com.pulsardeveloper.pulsarhazelcastairquality;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DataTest {

    public static void main(String[] args) throws Exception {
        String topicName = "persistent://public/default/hz-jet-topic2";
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://pulsar1:6650")
                .build();
        String[] userArray = {"user1", "user2", "user3", "user4", "user5"};
        Producer<Event> producer = client
                .newProducer(Schema.JSON(Event.class))
                .topic(topicName)
                .batchingMaxPublishDelay(10, TimeUnit.MILLISECONDS)
                .sendTimeout(10, TimeUnit.SECONDS)
                .blockIfQueueFull(true)
                .create();

        for (long eventCount = 0; ; eventCount++) {
            String message = String.format("message-%0,4d", eventCount);
            String user = getRandomUser(userArray);
            producer.send(new Event(user, eventCount, message));
            System.out.format("Published '%s' from '%s' to Pulsar topic '%s'%n", message, user, topicName);
            Thread.sleep(20);
        }
    }

    private static String getRandomUser(String[] userArray) {
        Random r = new Random();
        return userArray[r.nextInt(userArray.length)];
    }
}