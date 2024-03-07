package uvg.edu.gt;

import java.util.ArrayList;
import java.util.List;

public class Defun {
    static String DefFun(List<String> instruccuines){

        String name = instruccuines.get(2) ;

        int n = 4;
        List<String> varNames = new ArrayList<String>();

        for ( int i = 4; i < instruccuines.size();i++){
            String v = instruccuines.get(i);
            n++;
            if (v.equals( ")" )){
                break ;
            }
            varNames.add(v);
        }


        List<String>  inst =   new ArrayList<String>();
        for (int i = n; i < (instruccuines.size() - 1) ; i++){
            inst.add(instruccuines.get(i));
        }


        Operador f = new Funcion(name,varNames,inst);
        Vocabulario mem = Vocabulario.obtenerInstancia();
        mem.addMemori(name,f);
        return name;
    }
}