package es.unileon.prg1.wordle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    Word word;

    @Before
    public void setUp(){
        word = new Word("Aires");
    }

    @Test
    public void lengthTest(){
        assertEquals(5, word.length());
    }

    @Test
    public void compareCharAtTest(){
        Word another = new Word("Alien");
        assertTrue(word.compareCharAt(another, 0));
        assertFalse(word.compareCharAt(another, 1));
    }
}
