package uvg.edu.gt;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Funcion implements Operador{
    private String name;

    private List<String> varNames ;


    private List<String> instrucciones;

    public Funcion(String name, List<String> varNames, List<String> instrucciones) {
        this.name = name;
        this.varNames = varNames;
        this.instrucciones = instrucciones;

    }

    @Override
    public void operar(Stack<String> valores) {
        Stack<String> operaciones = new Stack<String>();
        Stack<String> parentesis = new Stack<String>();
        HashMap<String, String> variables = new HashMap<String,String>();
        Vocabulario vocabulario = Vocabulario.obtenerInstancia();
        // tomo de la pila los valores a operar
        for (int i = 0; i < varNames.size(); i++){
            variables.put(varNames.get(i),valores.pop());
        }
        // se evalua tomando el nombre de las variables
        boolean precedQuote = false;
        for (String V: instrucciones){
            String v;
            // revisa si v es una variable local
            if (variables.containsKey(V))
                v = variables.get(V);
            else
                v = V;
            switch (v){
                case "(":
                    //algo
                    parentesis.add("-");
                    break;
                case ")":
                    parentesis.pop();
                    String op0 = operaciones.pop();
                    Operador op = (Operador) vocabulario.interpretar(op0);
                    op.operar(valores);
                    break;
                case "quote":
                    precedQuote = true;
                    operaciones.add(v);
                    break;
                default:
                    //algo
                    if (precedQuote) {
                        precedQuote = false;
                        if (variables.containsKey(v))
                            valores.add(variables.get(v));
                        valores.add(v);
                    }
                    else if (vocabulario.isOperador(v))
                        operaciones.add(v);

                    else
                        valores.add(v);
                    break;

            }
        }




    }
}