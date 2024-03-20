package uvg.edu.gt;

import java.util.*;

public class listOp implements Operador{
    @Override
    public void operar(Stack<String> valores) {
        int iterador = valores.size();
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < iterador; i++) {
            lista.add(valores.pop());
        }
        Collections.reverse(lista);
        valores.add(lista.toString());
    }

}
