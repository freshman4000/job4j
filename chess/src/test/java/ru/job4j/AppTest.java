package ru.job4j;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposibleMoveException;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//TODO add other figures on board and make some tests with occupied exception.
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void before() {
        System.setOut(new PrintStream(out));
    }

    public void after() {
        System.setOut(stdout);
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Testing PawnBlack all moves.
     */
    public void testPawnBlackAllMoves() {
        }
    }

