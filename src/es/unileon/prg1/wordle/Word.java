package es.unileon.prg1.wordle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 *
 * @author Jose Angel Mestas Diaz (Logging)
 * @author Miguel Gonzalo Carvajal
 * @author Monica Montes Magalhaes (Test)
 * @author David Reyero Rodriguez (Código)
 *
 * @version 0.0
 */
public class Word {
    private Letter[] word;
    private static final Logger logger = LogManager.getLogger(Word.class);

    /**
     * Constructor de la clase Word a partir de un String.
     * @param palabra String que formará el objeto Word.
     */
    public Word(String palabra){
        this.word = new Letter[palabra.length()];

        for(int i = 0; i< palabra.length(); i++){
            word[i]= new Letter(palabra.charAt(i));
        }
        logger.debug("Palabra creada: " + word.toString());
    }

    /**
     * Constructor de la clase Word a partir de otra Word.
     * @param word Word que formará el objeto Word.
     */
    public Word(Word word){
        this.word=word.getWord();
        logger.debug("Palabra creada: " + word);
    }

    /**
     * Constructor de Word que crea un objeto Word formado unicamente por espacios.
     * @param longitud Es el número de letras que tendrá la palabra.
     */
    public Word(int longitud){
        this.word= new Letter[longitud];
        for (int i = 0; i < longitud; i++) {
            word[i]=new Letter(' ');
        }
        logger.debug("Palabra de " + longitud + " letras creada");
    }

    /**
     * Crea una word de la longitud dada y con el contenido de la String dada.
     * @param palabra Contenido de la Word.
     * @param longitud Longitud de la Word.
     */
    public Word(String palabra, int longitud){
        this.word = new Letter[longitud];

        for(int i = 0; i< palabra.length(); i++){
            word[i]= new Letter(palabra.charAt(i));
        }
        for (int i = palabra.length(); i < longitud; i++) {
            word[i]=new Letter(' ');
        }
        logger.debug("Palabra de " + longitud + " letras creada: " + word.toString());
    }
    /**
     * Getter de Word
     * @return el Word actual
     */
    public Letter[] getWord(){
        logger.debug("Accedida a la palabra " + word.toString());
        return this.word;
    }

    /**
     * Compara el caracter de una posicion determinada de dos Word.
     * @param another La palabra con la que se quiere comparar.
     * @param posicion La posición que se quiere comparar.
     * @return True si el caracter coincide.
     */
    public boolean compareCharAt(Word another, int posicion){
        logger.debug("Letra " + word[posicion] + " = " + another.getWord()[posicion].getLetter() + ": " + (word[posicion].getLetter()==another.getWord()[posicion].getLetter()));
        return word[posicion].getLetter()==another.getWord()[posicion].getLetter();
    }

    /**
     * Compara que si coinciden letras en ambas palabras, distinguiendo si están en la misma posición o npo cambiando el color de las Letter.
     * @param secretWord
     */
    public void compare(Word secretWord) {
        int longitud = secretWord.getWord().length;

        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < longitud; j++) {
                if(word[j].equals(secretWord.getWord()[i])){
                    secretWord.getWord()[i].setIncludedColor();
                    if(i==j){
                        secretWord.getWord()[i].setCorrectColor();
                    }
                }
            }
        }
        logger.debug("Comparada la palabra " + word.toString() + " con la palabra" + secretWord + " y las pinta letra por letra");
        word= secretWord.getWord();
    }

    /**
     * Compara si dos Word son iguales.
     * @param anotherWord La palabra con la que se desea comparar.
     * @return True si son iguales.
     */
    public boolean equals(Word anotherWord){
        logger.debug("La palabra " + word.toString() + " = " + anotherWord + ": " + this.word.toString().equals(anotherWord.toString()));
        return this.word.toString().equals(anotherWord.toString());
    }

    /**
     * Transforma a String un objeto de tipo Word.
     * @return Contenido de Word en String.
     */
    public String toString(){
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            salida.append(this.word[i]);
        }
        return salida.toString();
    }

    public int length() {
        return word.length;
    }
}

