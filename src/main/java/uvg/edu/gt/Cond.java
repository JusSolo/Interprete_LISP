package uvg.edu.gt;

import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Cond {
    public static void mod(List<String> comando, int i){

        int inicio = i+0; // el indice en donde esta cond
        i += 2;
        List<String> verda = new ArrayList<String>();
        Stack<String> parentesis = new Stack<String>();
        String v = comando.get(i);
        parentesis.add("-");
        verda.add(v);
        //extraemos la parte del codigo donde se evalua un valor de verdad
        while (!parentesis.empty()){
            i++;
            v = comando.get(i);
            verda.add(v);
            if (v.equals("("))
                parentesis.add("-");
            if (v.equals(")"))
                parentesis.pop();
        }
        Evaluador E = new Evaluador();

        String valor = E.evaluar(verda);

        List<String> instruccionB = new ArrayList<String>();

        //extraemos la parte del cadigo a extraer cualdo la condicion de verdad se cumple
        List<String> iV = new ArrayList<String>();
        parentesis.add("-");
        v = "(";
        iV.add(v);
        i++;


        while (!parentesis.empty()){
            i++;
            v = comando.get(i);

            iV.add(v);
            if (v.equals("("))
                parentesis.add("-");
            if (v.equals(")"))
                parentesis.pop();

        }



        //extraemos la parte del cadigo a extraer cualdo la condicion de verdad es falsa
        List<String> iF = new ArrayList<String>();
        parentesis.add("-");
        v = "(";
        iF.add(v);

        i++;
        while (!parentesis.empty()){
            i++;


            v = comando.get(i);
            iF.add(v);
            if (v.equals("("))
                parentesis.add("-");
            if (v.equals(")"))
                parentesis.pop();

        }

        comando.subList(inicio - 1, i+3  ).clear();

        if (valor.equals("t"))
            comando.addAll(inicio-1, iV);
        else
            comando.addAll(inicio-1, iF);


    }

    public static void mod(List<String> comando, int i, HashMap<String, String> variables) {

        int inicio = i+0; // el indice en donde esta cond
        i += 2;
        List<String> verda = new ArrayList<String>();
        Stack<String> parentesis = new Stack<String>();
        String v = comando.get(i);
        parentesis.add("-");
        verda.add(v);
        //extraemos la parte del codigo donde se evalua un valor de verdad
        while (!parentesis.empty()){
            i++;
            v = comando.get(i);
            if (variables.containsKey(v))
                v = variables.get(v);

            verda.add(v);
            if (v.equals("("))
                parentesis.add("-");
            if (v.equals(")"))
                parentesis.pop();
        }
        Evaluador E = new Evaluador();
        String valor = E.evaluar(verda);

        List<String> instruccionB = new ArrayList<String>();

        //extraemos la parte del cadigo a extraer cualdo la condicion de verdad se cumple
        List<String> iV = new ArrayList<String>();
        parentesis.add("-");
        v = "(";
        iV.add(v);
        i++;


        while (!parentesis.empty()){
            i++;
            v = comando.get(i);

            iV.add(v);
            if (v.equals("("))
                parentesis.add("-");
            if (v.equals(")"))
                parentesis.pop();

        }



        //extraemos la parte del cadigo a extraer cualdo la condicion de verdad es falsa
        List<String> iF = new ArrayList<String>();
        parentesis.add("-");
        v = "(";
        iF.add(v);

        i++;
        while (!parentesis.empty()){
            i++;


            v = comando.get(i);
            iF.add(v);
            if (v.equals("("))
                parentesis.add("-");
            if (v.equals(")"))
                parentesis.pop();

        }


        int largoC = comando.size();
        comando.subList(0, largoC ).clear();

        if (valor.equals("t"))
            comando.addAll(inicio-1, iV);
        else
            comando.addAll(inicio-1, iF);

    }
}
