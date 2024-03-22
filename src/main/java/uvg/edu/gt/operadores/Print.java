package uvg.edu.gt.operadores;

import uvg.edu.gt.Vocabulario;
import uvg.edu.gt.operadores.Operador;

import java.util.Stack;

public class Print implements Operador {
    @Override
    public void operar(Stack<String> valores) {
       // String a0 =  valores.pop();
        String b0 = valores.pop();
        // llamo al vocabulario (Esto incluye a variables)
        Vocabulario vocabulario = Vocabulario.obtenerInstancia();
        // Buscamos los valores en el vocabulario
      //  String a1 =  vocabulario.interpretar(a0).toString();
        String b1 =  vocabulario.interpretar(b0).toString();
        System.out.println(b1);

    }
}
