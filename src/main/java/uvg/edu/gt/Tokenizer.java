package uvg.edu.gt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tokenizer {
    public  List<> tokenisation(List<String> comandoI){
        List<> ComandoS = new ArrayList<>();
        for( String V : comandoI){
            switch (v){
                case "(":
                    //Algo
                break;

                case ")":
                    //otra cosa
                    //
                break;

                case "+":
                    // algo
                break;

                case "-":
                    // algo
                break;

                case "*":
                    // algo
                    break;
                case "/":
                    // algo
                    break;

                case "print":
                    // algo
                    break;
                case "defun":
                    // algo
                    break;

                case "cond":
                    // algo
                    break;
                case "<":
                    // algo
                    break;

                case ">":
                    // algo
                    break;
                case "quote":
                    /**
                     * Función: QUOTE
                     * Número de argumentos: 1
                     * Argumentos: Un término cualquiera.
                     * Retorna: El argumento.
                     * > (quote (+ (- 5 2) (* 3 3)))
                     * (+ (- 5 2) (* 3 3))
                     */
                    break;

                case "list":
                    // algo
                    break;

                case "car":
                    /**
                     * Función: CAR
                     * Número de argumentos: 1
                     * Argumentos: Lista no vacía.
                     * Retorna: El primer término de la lista.
                     */
                    break;
                case "cdr":
                    /**
                     * Función: CDR
                     * Número de argumentos: 1
                     * Argumentos: Lista no vacía.
                     * Retorna: El resto de la lista que queda después de borrar el primer término.
                     */
                break;


                case "t":// true el valor de verdad
                    // algo
                    break;
                case "nil": // es como false
                    // algo
                    break;

                case "quote": // funcion identidad
                    /**
                     * Función: quote
                     * Número de argumentos: 1
                     * Argumentos: Un término cualquiera.
                     * Retorna: El argumento.
                     */
                    break;

                case "setq": // funcion de creacion de variables
                    // algo
                    break;
                case "atom":
                    /**
                     * Función: atom
                     * Número de argumentos: 1
                     * Argumentos: Cualquier término.
                     * Retorna: T si el argumento es un átomo; NIL en otro caso.
                     */
                    break;

                case "equal":
                    /**
                     * Función: equal
                     * Número de argumentos: 2
                     * Argumentos: Dos términos.
                     * Retorna: T si ambos átomos son iguales; NIL en otro caso.
                     */
                    break;






            }
        }
    }

}
