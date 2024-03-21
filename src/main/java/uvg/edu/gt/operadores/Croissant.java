package uvg.edu.gt.operadores;

import uvg.edu.gt.Vocabulario;

import java.util.Stack;

/**
 * Este classe coresponde al operador más pequeño que (el nobre viene del frances "croisant", mas pequeño que)
 */
public class Croissant implements Operador {

    @Override
    public void operar(Stack<String> valores) {
        // tomo de la pila los valores a operar como suma es un operador binario tomo los ultimos dos valores
        String a0 = valores.pop();
        String b0 =  valores.pop();
        // llamo al vocabulario (Esto incluye a variables)
        Vocabulario vocabulario = Vocabulario.obtenerInstancia();
        // Buscamos los valores en el vocabulario
        String a1 =  vocabulario.interpretar(a0).toString();
        String b1 = vocabulario.interpretar(b0).toString();
        Integer a = Integer.parseInt(a1);
        Integer b = Integer.parseInt(b1);
        if (a > b ){
            valores.add("t");
        }
        else {
            valores.add("nil");
        }
    }


}
