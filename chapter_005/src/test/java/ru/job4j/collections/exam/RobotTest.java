package ru.job4j.collections.exam;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.core.Is;

/**
 * Test.
 */
public class RobotTest {
    /**
     * Testing array pattern1.
     */
    @Test
    public void when0022then11115() {
        int[][] array = {
                {1, 2, 3},
                {1, 3, 6},
                {1, 1, 5}
        };
        Robot robot = new Robot(array);
        Assert.assertThat(robot.getBestPath(0, 0, 2, 2), Is.is(new int[]{1, 1, 1, 1, 5}));
    }

    /**
     * Testing array pattern2.
     */
    @Test
    public void when0002then1421463() {
        int[][] array = {
                {1, 30, 3},
                {4, 80, 6},
                {2, 1, 4}
        };
        Robot robot = new Robot(array);
        Assert.assertThat(robot.getBestPath(0, 0, 0, 2), Is.is(new int[]{1, 4, 2, 1, 4, 6, 3}));
    }

    /**
     * Testing array pattern2 with single middle cell.
     */
    @Test
    public void when1111then80() {
        int[][] array = {
                {1, 30, 3},
                {4, 80, 6},
                {2, 1, 4}
        };
        Robot robot = new Robot(array);
        Assert.assertThat(robot.getBestPath(1, 1, 1, 1), Is.is(new int[]{80}));
    }
}

