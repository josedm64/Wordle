package es.unileon.prg1.wordle;

import java.util.Random;

/**
 *Clase encargada de crear el diccionario y seleccionar la palabra secreta
 *
 * @author Jose Angel Mestas Diaz
 * @author Miguel Gonzalo Carvajal
 * @author Monica Montes Magalahes
 * @author David Reyero Rodriguez
 *
 * @version 0.0
 */

public class Dictionary {
    private String[] words;

    /**
     * Constructor de la clase Dictionary
     * @param fileName nombre del diccionario
     * @param nLetters número de letras del diccionario
     * @throws WordleException excepción lanzada
     */
    public Dictionary(String fileName, int nLetters) throws WordleException {
        this.setNLetters(nLetters);

        String line;

        Source source = new Source("../etc/" + fileName + ".txt");
        int size = 0;
        for (source.first(); source.hasNext();) {
            line = source.getNext();
            line = line.trim();

            if(line.length() == nLetters){
                size++;
            }
        }

        this.words = new String[size];

        int i = 0;
        for (source.first(); source.hasNext();) {
            line = source.getNext();
            line = line.trim();

            if(line.length() == nLetters){
                words[i] = line;
                i++;
            }
        }
    }

    /**
     * Setter de la variable nLetters
     * @param nLetters número de letras
     * @throws WordleException excepción lanzada
     */
    public void setNLetters(int nLetters) throws WordleException {
        if (nLetters < 2) {
            throw new WordleException("El diccionario tiene que tener mínimo 2 letras");
        }
    }

    /**
     *
     * @param index posición a comprobar
     * @return palabra en el índice elegido
     */
    public String getWordAt(int index){
        return words[index];
    }

    /**
     * Método que devuelve una palabra aleatoria
     * @return una palabra aleatoria
     */
    public String randomWord() {
        Random randomNumber = new Random();
        randomNumber.setSeed(System.currentTimeMillis());
        int index = randomNumber.nextInt(words.length + 1);

        return words[index];
    }

    /**
     * Método que devuelve si la palabra está en el array de palabras
     * @param word palabra a comparar con el array
     * @return True o False
     */
    public boolean isIncluded(String word) {
            int comparar, mitad, limiteInferior, limiteSuperior;
            boolean isIncluded = false;
            limiteInferior = 0;
            limiteSuperior = this.words.length - 1;

            while ( (limiteInferior <= limiteSuperior) && (!isIncluded)) {
                mitad = (limiteInferior + limiteSuperior) / 2 ;
                comparar = this.words[mitad].compareTo(word);

                if (comparar < 0){
                    limiteInferior = mitad + 1;
                } else if (comparar > 0) {
                    limiteSuperior = mitad - 1;
                } else
                    isIncluded = true;
            }
        return isIncluded;
    }
}

