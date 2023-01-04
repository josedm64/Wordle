package es.unileon.prg1.wordle;

/**
 * La clase que se ocupa de preparar la interfaz del usuario, introducir las palabras de los intentos, llevar la cuenta de ellos y, en modo desarrollador, enseñar la palabra secreta
 *
 * @author Jose Angel Mestas Diaz
 * @author Miguel Gonzalo Carvajal
 * @author Monica Montes Magalhaes
 * @author David Reyero Rodriguez
 *
 * @version 0.0
 */
public class Board {
    private Word[] attempts;
    private int next;

    //Constructor
    public Board(int nTries) throws WordleException {
        if(nTries < 1){
            throw new WordleException("El número de intentos no puede ser menor de uno");
        }
        attempts = new Word[nTries];
    }

    public int getNext(){
        return next;
    }

    public int length(){
        return attempts.length;
    }

    public void setAttempts(Word word, int position){
        attempts[position] = word;
    }

    public String getAttemptedWordAt(int position) {
        return attempts[position].toString();
    }
}
