package uvg.edu.gt.operadores;

import java.util.Stack;

/**
 * Esta interfaz engloba todas las cosas en lisp que se portan como operadores binarios o funciones con uno o varios parametros que devuelven algo
 */
public interface Operador {
    /**
     * Los operadores son las funciones que vienen de serie con lisp
     * @param valores es la pila donde estan los valores que tomaran los parametros de el operador
     */
    public void operar(Stack<String> valores);
}
