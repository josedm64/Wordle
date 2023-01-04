/*
package es.unileon.prg1.wordle;

import static es.unileon.prg1.wordle.Colors.GREEN;
import static es.unileon.prg1.wordle.Colors.YELLOW;
import static org.junit.Assert.*;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;
import org.junit.Before;
import org.junit.Test;

public class WordleTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void creation() throws WordleException{
        Wordle newGame = new Wordle("Diccionario", 5, 5);
    }

    @Test
    public void intentoLetraPresenteMalColocada() throws WordleException {
        Wordle newGame = new Wordle("Diccionario", 5, 5);

        Word secretWord = new Word("OLAAA");
        Word tryWord = new Word("LIBRO");

        newGame.setSecretWord(secretWord);
        newGame.newTry(tryWord);

        Word intentoColor= new Word("LIBRO");
        intentoColor.getWord()[4].setColor(YELLOW);

        assertEquals(intentoColor, newGame.board.getAttemptedWordAt(1));
    }

    @Test
    public void intentoLetraPresenteBienColocada() throws WordleException{
        Wordle newGame = new Wordle("Diccionario", 5, 5);

        Word secretWord = new Word("OLAAA");
        Word tryWord = new Word("LIBRO");

        newGame.setSecretWord(secretWord);
        newGame.newTry(tryWord);

        Word intentoColor= new Word("LIBRO");
        intentoColor.getWord()[4].setColor(GREEN);

        assertEquals(intentoColor, newGame.getBoard[1]);
    }



    @Test (expected = WordleException.class)
    public void intentoNumero() throws WordleException{
        Wordle newGame= new Wordle("Diccionario", 5, 5);
        newGame.intento(5);
    }

    @Test (expected = WordleException.class)
    public void intentoMuchasLetras() throws WordleException{
        Wordle newGame= new Wordle("Diccionario", 5, 5);
        newGame.newTry("AIREOS");
    }


    @Test
    public void winTest() throws WordleException {
        Board board = new Board(6);
        Wordle wordle = new Wordle("hola", 6, 5);
        wordle.loseGame = false;
        assertEquals("Enhorabuena", board.endGame());
    }

    //Comprobar que funciona la derrota
    @Test
    public void loseTest() throws WordleException {
        Board board = new Board(6);
        Wordle wordle = new Wordle("hola", 6, 5);
        wordle.loseGame = true;
        assertEquals("Has perdido porque no te quedan más intentos y no has encontrado la palabra secreta: ", board.endGame());
    }

    //Comprobar que funciona el abandono
    @Test
    public void abandonTest() throws WordleException {
        Board board = new Board(6);
        Wordle wordle = new Wordle("hola", 6, 5);
        wordle.abandonGame = true;
        assertEquals("Hasta la próxima", board.endGame());
    }



    //Comprobar que funciona el método que comprueba si la palabra está en el diccionario
    @Test
    public void dictionaryWordTest() throws WordleException {
        Wordle wordle = new Wordle("hola", 6, 5);
        Word word = new Word("reloj");

        assertEquals("La palabra " + wordle.getAttemptedWord() + "  no está incluida en el diccionario", word.notInDictionary());
    }
}

 */
