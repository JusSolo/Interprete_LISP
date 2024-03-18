package uvg.edu.gt;

import java.util.Stack;

public class Print implements Operador{
    @Override
    public void operar(Stack<String> valores) {
        String a0 =  valores.pop();
        // llamo al vocabulario (Esto incluye a variables)
        Vocabulario vocabulario = Vocabulario.obtenerInstancia();
        // Buscamos los valores en el vocabulario
        String a1 =  vocabulario.interpretar(a0).toString();
        System.out.println(a1);
    }
}
