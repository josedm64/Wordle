package es.unileon.prg1.wordle;

/**
 * Clase que controla lo referido a la partida, tanto la palabra secreta, el número de intentos la pantalla y el diccionario
 *
 * @author Jose Angel Mestas Diaz (Documentación)
 * @author Miguel Gonzalo Carvajal (Codigo)
 * @author Mónica Montes Magalhaes
 * @author David Reyero Rodriguez (Test)
 *
 * @version 0.0
 */


public class Wordle {
    private Word secretWord;
    private int wordLength;
    public Dictionary dictionary;
    public Board board;

    /**
     * Constructor de la clase Wordle
     * @param fileName nombre del fichero del diccionario seleccionado
     * @param wordLength longitud de la palabra
     * @param tries número total de intentos
     */
    public Wordle(String fileName, int wordLength, int tries) throws WordleException {
        this.dictionary = new Dictionary(fileName,this.wordLength);
        this.setWordLength(wordLength);
        this.secretWord  = new Word(dictionary.randomWord());
        this.setBoard(tries);
    }

    /**
     * Setter de secretWord
     * @param secretWord palabra secreta
     */
    public void setSecretWord(Word secretWord) {
        this.secretWord = secretWord;
    }

    public void setWordLength(int wordLength) throws WordleException {
        if (wordLength<2){
            throw new WordleException("Las palabras tienen mínimo dos letras.");
        }
        this.wordLength = wordLength;
    }

    /**
     * Setter de tries
     * @param tries número de intentos
     */
    public void setBoard(int tries) throws WordleException {
        if (tries<0){
            throw new WordleException("Los intentos no pueden ser negativos");
        }
        this.board = new Board(tries, wordLength);
    }
    /**
     * Getter de secretWord
     * @return palabra secreta
     */
    public Word getSecretWord() {
        return secretWord;
    }

    /**
     * Clase que comprueba que el intento es válido
     * @param word palabra a validar
     */
    public void newPlay(String word){
        Word wordTry = new Word(word);
        newTry(wordTry);
        board.setAttempts(wordTry, board.getNext());
    }

    /**
     * Se ocupa de comprobar si una palabra tiene la longitud correcta
     * @param word palabra a comprobar
     * @return True o False en función si tiene una longitud válida
     */
    public boolean validLength(String word) {
        return (word.length() == this.wordLength);
    }

    /**
     * Se ocupa de comprobar si la palabra está en el diccionario
     * @param word palabra a comprobar
     * @return True o False en función de si está o no en el diccionario
     */
    public boolean validWord(String word){
        return (this.dictionary.isIncluded(word));
    }

    /**
     * Se ocupa de comparar la palabra con la palabra secreta
     * @param wordtry palabra a comprobar
     */
    public void newTry(Word wordtry){
        wordtry.compare(this.secretWord);
    }

    /**
     * Comprueba si se ha ganado la partida
     * @param word palabra a comprobar
     * @return True si se ha ganado la partida
     */
    public boolean win(String word){
        return word.equals(secretWord.toString());
    }

    /**
     * Comprueba si se ha perdido la partida
     * @return True si se ha perdido la partida
     */
    public boolean lose(){
        return board.getNext()==(board.length());
    }

    /**
     * Comprueba si se ha abandonado la partida
     * @param word palabra a comprobar
     * @return True si se abandona la partida escribiendo "Salir"
     */
    public boolean exit(String word){
        return word.equals("Salir");
    }
}