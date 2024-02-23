package uvg.edu.gt;

import java.util.Stack;

public class Suma implements Operador{
    @Override
    public void operar(Stack<String> valores) {// suma es un operador binario
        // tomo de la pila los valores a operar como suma es un operador binario tomo los ultimos dos valores
        String a0 = valores.pop();
        String b0 =  valores.pop();
        // llamo al vocabulario (Esto incluye a variables)
        Vocabulario vocabulario = Vocabulario.obtenerInstancia();
        // Buscamos los valores en el vocabulario
        Integer a = (int) vocabulario.interpretar(a0);
        Integer b = (int) vocabulario.interpretar(b0);

        Integer c = a + b;
        valores.add(Integer.toString(c));
    }
}
