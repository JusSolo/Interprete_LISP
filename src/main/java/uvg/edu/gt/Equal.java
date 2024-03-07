package uvg.edu.gt;

import java.util.Objects;
import java.util.Stack;

public class Equal implements Operador{
    @Override
    public void operar(Stack<String> valores) {
        // tomo de la pila los valores a operar como suma es un operador binario tomo los ultimos dos valores
        String a0 = valores.pop();
        String b0 =  valores.pop();
        if (Objects.equals(a0, b0)){
            valores.add("t");
        }
        else {
            valores.add("nil");
        }
    }
}
