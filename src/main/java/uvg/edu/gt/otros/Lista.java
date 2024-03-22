package uvg.edu.gt.otros;

import java.util.*;

/**
 * Esto es casi un operador, por lo mismo se trata casi como a un operdaor
 */
public class Lista {
    /**
     *
     * @param valores la pila que contine los valores de la lista
     * @param iterador el tamaño de la lista
     */
    public static void operar(Stack<String> valores, int iterador) {

        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < iterador; i++) {
            lista.add(valores.pop());
        }
        Collections.reverse(lista);
        valores.add(lista.toString());
    }

}
