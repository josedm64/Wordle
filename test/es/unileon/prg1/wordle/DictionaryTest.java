package es.unileon.prg1.wordle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class DictionaryTest {
    Dictionary dictionary;
    @Before
    public void setup() throws WordleException{
        dictionary = new Dictionary("smalldictionary.txt",5);
    }

    @Test
    public void testDictionaryWordLength(){
        assertEquals(5,dictionary.getWordAt(4).length());
    }
    @Test(expected = WordleException.class)
    public void testDictionaryLessThanTwoLetters() throws WordleException{
        dictionary.setNLetters(1);
    }
    @Test(expected = WordleException.class)
    public void testDictionaryMoreThan23Letters()throws WordleException{
        dictionary.setNLetters(24);
    }
    @Test
    public void testRandomWordLength(){
        assertEquals(5,dictionary.randomWord().length());
    }
    @Test
    public void testisIncludedTrue(){
        assertTrue(dictionary.isIncluded("febrero"));
    }
    @Test
    public void testisIncludedFalse(){
        assertFalse(dictionary.isIncluded("luffy"));
    }
    @Test
    public void testRandomWordInDictionary(){
        assertTrue(dictionary.isIncluded(dictionary.randomWord()));
    }

}