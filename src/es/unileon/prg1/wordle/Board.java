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
    private Dictionary dictionary;
    private int tries;
    private boolean developerMode;

    /**
     *
     * @return diccionario usado
     */
    public Dictionary getDictionary() {
        return dictionary;
    }

    /**
     *
     * @param dictionary diccionario por el que se modifica el atributo dictionary
     */
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     *
     * @return numero de intentos
     */
    public int getTries() {
        return tries;
    }

    /**
     *
     * @param tries intentos maximos
     */
    public void setTries(int tries) {
        if(tries<1){
            throw new WordleException("El número de intentos debe ser mínimo 1")
        }
        this.tries = tries;
    }

    /**
     *
     * @return boolean diciendo si esta en developerMode
     */
    public boolean isDeveloperMode() {
        return developerMode;
    }

    /**
     *
     * @param developerMode boolean que enciende/apaga el developerMode
     */
    public void setDeveloperMode(boolean developerMode) {
        this.developerMode = developerMode;
    }

    public String developerMode() {

    }
}
