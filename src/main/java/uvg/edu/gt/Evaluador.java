package uvg.edu.gt;

import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Evaluador {
    public Stack<String> valores;
    private Stack<String> operaciones;
    private Stack<String> parentesis;
    public Vocabulario vocabulario;

    public Evaluador(){
        valores = new Stack<String>();
        operaciones = new Stack<String>();
        parentesis = new Stack<String>();
        vocabulario = Vocabulario.obtenerInstancia();
    }

    public  String  evaluar(List<String> comando){
        for (String v: comando){
            switch (v){
                case "(":
                    //algo
                    parentesis.add("-");
                    break;
                case ")":
                    parentesis.pop();
                    String op0 = operaciones.pop();
                    Operador op = (Operador) vocabulario.interpretar(v);
                    op.operar(valores);
                    break;
                default:
                    //algo
                    if (vocabulario.isOperador(v))
                        operaciones.add(v);
                    else
                        valores.add(v);
                    break;

            }
        }
        if (valores.isEmpty())
            return "";
        return valores.pop();

    }
}
