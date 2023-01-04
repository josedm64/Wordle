package es.unileon.prg1.wordle;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class BoardTest {
    Board board;

    @Before
    public void setup() throws WordleException {
        board = new Board(6);
    }

    //Comprobar que se crea el tablero correctamente
    @Test (expected = WordleException.class)
    public void constructorZeroTest() throws WordleException {
        Board boardZero = new Board(0);
    }

    //Comprobar que se crea el tablero correctamente
    @Test (expected = WordleException.class)
    public void constructorNegativeTest() throws WordleException {
        Board boardNegative = new Board(-1);
    }

    //Comprobar que el tablero funciona correctamente vacío
    @Test
    public void emptyTest() throws WordleException {
        Word word = new Word(6);

        for (int i = 0; i <= 6; i++) {
            assertEquals(word.toString(), board.getAttemptedWordAt(i));
        }

        Board otherBoard = new Board(6);
        for (int i = 0; i <= 6; i++) {
            assertEquals(word.toString(), otherBoard.getAttemptedWordAt(i));
        }
    }

    //Comprobar que el tablero funciona correctamente con palabras
    @Test
    public void notEmptyTest() throws WordleException {
        Board board = new Board(6);

        Word word = new Word("sorbo");
        Word otherWord = new Word("tiros");
        Word emptyWord = new Word(6);

        board.setAttempts(word, 0);
        board.setAttempts(otherWord, 1);

        assertEquals(word.toString(), board.getAttemptedWordAt(0));
        assertEquals(otherWord.toString(), board.getAttemptedWordAt(1));

        for (int i = 2; i <= 6; i++) {
            assertEquals(emptyWord.toString(), board.getAttemptedWordAt(i));
        }
    }
}
