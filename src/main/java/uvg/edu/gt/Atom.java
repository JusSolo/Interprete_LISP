package uvg.edu.gt;

import java.util.Stack;

public class Atom implements Operador{
    @Override
    public void operar(Stack<String> valores) {
        Vocabulario voc = Vocabulario.obtenerInstancia();
        String s = valores.pop();
        if (voc.isAtom(s))
            valores.add("t");
        else
            valores.add("nill");

    }
}
