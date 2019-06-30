package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class ArrayDuplicateTest {
    /**
     * Testing.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicates() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] incomingArray = {"hi", "go", "go", "my", "name", "hi", "name", "my", "fork"};
        String[] result = arrayDuplicate.remove(incomingArray);
        String[] expected = {"hi", "go", "my", "name", "fork"};
        assertThat(result, is(expected));
        }
    }

