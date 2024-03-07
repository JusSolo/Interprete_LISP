package uvg.edu.gt;

import java.util.Stack;

public class Resta implements Operador{
    @Override
    public void operar(Stack<String> valores) {// suma es un operador binario
        // tomo de la pila los valores a operar como suma es un operador binario tomo los ultimos dos valores
        String a0 = valores.pop();
        String b0 =  valores.pop();

        // llamo al vocabulario (Esto incluye a variables)
        Vocabulario vocabulario = Vocabulario.obtenerInstancia();
        // Buscamos los valores en el vocabulario
        //System.out.println(a0);
        String a1 =  vocabulario.interpretar(a0).toString();
        //System.out.println("a = " + a1);
        String b1 = vocabulario.interpretar(b0).toString();
        //System.out.println("b = " + b1);
        Integer a = Integer.parseInt(a1);
        Integer b = Integer.parseInt(b1);

        Integer c = b - a;
        valores.add(Integer.toString(c));
    }
}
