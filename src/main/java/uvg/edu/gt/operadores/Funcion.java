package uvg.edu.gt.operadores;

import uvg.edu.gt.otros.Cond;
import uvg.edu.gt.Vocabulario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Al final las funciones son operadores que el programador programa
 */
public class Funcion implements Operador {
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
        List<String> instruccionesL = new ArrayList<>(instrucciones) ;
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
        for (int j = 0; j < instruccionesL.size(); j++){
            String V = instruccionesL.get(j);
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
                    if (!operaciones.isEmpty()) {
                        String op0 = operaciones.pop();
                        Operador op = (Operador) vocabulario.interpretar(op0);
                        // System.out.println(valores);
                        op.operar(valores);
                    }
                    else{
                     boolean totototototo = true;
                    }
                    break;
                case "quote":
                    precedQuote = true;
                    operaciones.add(v);
                    break;
                case "cond":
                    Cond.mod(instruccionesL,j,variables);
                    //System.out.println(instrucciones);
                    j--;
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