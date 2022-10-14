package com.pulsardeveloper.pulsarhazelcastairquality;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.jet.*;
import com.hazelcast.jet.config.JobConfig;
import com.hazelcast.jet.contrib.pulsar.PulsarSources;
import com.hazelcast.jet.pipeline.*;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import com.pulsardeveloper.pulsarhazelcastairquality.Event;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.hazelcast.jet.aggregate.AggregateOperations.counting;
import static com.hazelcast.jet.pipeline.WindowDefinition.sliding;

public class JetJob {
    static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public static void main(String[] args) {
        String topicName = "hz-jet-topic";

        StreamSource<Event> source = PulsarSources.pulsarReaderBuilder(
                topicName,
                () -> PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build(),
                () -> Schema.JSON(Event.class),
                Message::getValue).build();

        Pipeline p = Pipeline.create();
        p.readFrom(source)
         .withNativeTimestamps(0)
         .groupingKey(Event::getUser)
         .window(sliding(TimeUnit.SECONDS.toMillis(60), TimeUnit.SECONDS.toMillis(30)))
         .aggregate(counting())
         .writeTo(Sinks.logger(wr -> String.format(
                 "At %s Pulsar got %,d messages in the previous minute from %s.",
                 TIME_FORMATTER.format(LocalDateTime.ofInstant(
                         Instant.ofEpochMilli(wr.end()), ZoneId.systemDefault())),
                 wr.result(), wr.key())));

        JobConfig cfg = new JobConfig()
                .setName("pulsar-message-counter");
        HazelcastInstance hz = Hazelcast.bootstrappedInstance();
        hz.getJet().newJob(p, cfg);
    }
}
