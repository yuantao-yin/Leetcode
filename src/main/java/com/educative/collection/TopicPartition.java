package com.educative.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TopicPartition implements Serializable {

    private final int partition;
    private final String topic;

    public TopicPartition(int partition, String topic) {
        this.partition = partition;
        this.topic = topic;
    }

    public int getPartition() {
        return partition;
    }

    public String getTopic() {
        return topic;
    }

    public static void streamGroupBy(List<TopicPartition> list) {
        list.stream()
            .filter(tp -> tp.getTopic().startsWith("test-"))
            .collect(Collectors.groupingBy(TopicPartition::getTopic, Collectors.counting()))
            .forEach((k,v) -> System.out.println("key="+k + " v="+v));

        Set<String> topics = list.stream()
            .filter(tp -> tp.getTopic().startsWith("test-"))
            .collect(Collectors.groupingBy(TopicPartition::getTopic, Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() > 2)
            .map(entry -> entry.getKey())
            .collect(Collectors.toSet());
        System.out.println(topics);
    }

    public static void main(String[] args) {
        List<TopicPartition> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new TopicPartition(i, "test-"+i));
            list.add(new TopicPartition(i, "test-"+i*2));
            list.add(new TopicPartition(i, "test-"+i*3));
        }
        list.add(new TopicPartition(4, "test-4"));
        list.add(new TopicPartition(4, "test-4"));
        TopicPartition.streamGroupBy(list);
    }
}
