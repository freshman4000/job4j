package ru.job4j.collections.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

    public class SimpleLinkedListTest {

        private SimpleLinkedList<Integer> list;

        @Before
        public void beforeTest() {
            list = new SimpleLinkedList<>();
            list.add(1);
            list.add(2);
            list.add(3);
        }

        /**
         * Testing get().
         */
        @Test
        public void whenAddThreeElementsThenUseGetOneResultTwo() {
            assertThat(list.get(1), is(2));
        }

        /**
         * Testing size().
         */
        @Test
        public void whenAddThreeElementsThenUseGetSizeResultThree() {
            assertThat(list.getSize(), is(3));
        }

        /**
         * Testing delete().
         */
        @Test
        public void whenDeletOneElementThenGetResultThisElementGetSizeResultTwoFirstElementTwo() {
            assertThat(list.delete(), is(3));
            assertThat(list.getSize(), is(2));
            assertThat(list.get(0), is(2));
        }
    }