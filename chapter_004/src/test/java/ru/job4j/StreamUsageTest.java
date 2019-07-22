package ru.job4j;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Test class for Stream API.
 */
public class StreamUsageTest {
    /**
     * Testing filtering.
     */
    @Test
    public void whenBugThenAllBugsInList() {
        List<StreamUsage.Task> tasks = Arrays.asList(
                new StreamUsage.Task("Bug #1", 100),
                new StreamUsage.Task("Task #2", 100),
                new StreamUsage.Task("Bug #3", 100)
        );
        List<StreamUsage.Task> result = tasks.stream()
                .filter(task -> task.getName().contains("Bug"))
                .collect(Collectors.toList());
        Assert.assertThat(result, Is.is(Arrays.asList(tasks.get(0), tasks.get(2))));
    }

    /**
     * Testing List of names generating.
     */
    @Test
    public void whenListOfTasksThenListOfNames() {
        List<StreamUsage.Task> tasks = Arrays.asList(
                new StreamUsage.Task("Bug #1", 100),
                new StreamUsage.Task("Task #2", 100),
                new StreamUsage.Task("Bug #3", 100)
        );
        List<String> result = tasks.stream()
                .map(StreamUsage.Task::getName)
                .collect(Collectors.toList());
        Assert.assertThat(result, Is.is(Arrays.asList("Bug #1", "Task #2", "Bug #3")));
    }

    /**
     * Testing summation of fields in streamed Objects.
     */
    @Test
    public void when3bY100Then300() {
        List<StreamUsage.Task> tasks = Arrays.asList(
                new StreamUsage.Task("Bug #1", 100),
                new StreamUsage.Task("Task #2", 100),
                new StreamUsage.Task("Bug #3", 100)
        );
        long result = tasks.stream()
                .map(StreamUsage.Task::getSpent)
                .reduce(0L, (spent1, spent2) -> spent1 + spent2);
        Assert.assertThat(result, Is.is(300L));
    }
}
