package uvg.edu.gt.operadores;

import uvg.edu.gt.Vocabulario;
import uvg.edu.gt.operadores.Operador;

import java.util.Stack;

/**
 * producto de enteros
 */
public class Prod implements Operador {
    @Override
    public void operar(Stack<String> valores) {// suma es un operador binario
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

        Integer c = a * b;
        valores.add(Integer.toString(c));
    }
}
