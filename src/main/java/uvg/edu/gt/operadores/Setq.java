package uvg.edu.gt.operadores;

import uvg.edu.gt.Vocabulario;
import uvg.edu.gt.operadores.Operador;

import java.util.Stack;

public class Setq implements Operador {
    @Override
    public void operar(Stack<String> valores) {
        // tomo de la pila el valor a ser seteado (val) y el nombre de la variable (ref)
        String val = valores.pop();
        String ref = valores.pop();
        //Instancia de vocabulario
        Vocabulario vocabulario = Vocabulario.obtenerInstancia();
        //Variable se agrega a memoria
        vocabulario.addMemori(ref,val);
        //valores.add(val);
    }
}
