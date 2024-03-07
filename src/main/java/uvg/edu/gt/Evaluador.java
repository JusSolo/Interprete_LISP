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


    public  String  evaluar(List<String> comando){ //la creacion de funciones es un caso aparte, no es una operacion almenos para este interprete
        if (comando.get(1).equals("defun")){
            return Defun.DefFun(comando);
        }
        boolean precedQuote = false;
        for (int i = 0; i < comando.size(); i++) {
            String v = comando.get(i);
            switch (v){
                case "(":
                    //algo
                    parentesis.add("-");
                    break;
                case ")":

                    parentesis.pop();
                    if (!operaciones.isEmpty()) {
                        String op0 = operaciones.pop();
                        Operador op = (Operador) vocabulario.interpretar(op0);
                        op.operar(valores);
                    }
                    break;
                case "quote":
                    precedQuote = true;
                    operaciones.add(v);
                    break;
                case "cond":
                    Cond.mod(comando,i);
                    i--;
                    break;
                default:
                    //algo
                    if (precedQuote) {
                        precedQuote = false;
                        valores.add(v);
                    }
                    else if (vocabulario.isOperador(v))
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