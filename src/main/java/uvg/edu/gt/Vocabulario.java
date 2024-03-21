package uvg.edu.gt;

import uvg.edu.gt.operadores.*;

import java.util.HashMap;

/**
 * Esra es la clse que se encarga de manejar la memoria de el interprete, como tal es la classe que conoce el significado que cada atom de lisp
 */
public class Vocabulario {
    private static Vocabulario instancia = null;
    private HashMap<String, Object> memoria;

    private Vocabulario() {// con forme definamos las operaciones vamos llenando esto
        memoria = new HashMap<>();
        Operador o1 = new Suma();
        memoria.put("+", o1);

        Operador o2 = new Resta();
        memoria.put("-", o2);

        Operador o3 = new Div();
        memoria.put("/", o3);

        Operador o4 = new Prod();
        memoria.put("*", o4);

        Operador o5 = new Equal();
        memoria.put("=", o5);
        memoria.put("equal", o5);

        Operador o6 = new Setq();
        memoria.put("setq", o6);

        Operador o7 = new Croissant();
        memoria.put("<", o7);

        Operador o8 = new Decroissant();
        memoria.put(">", o8);

        Operador o9 = new Print();
        memoria.put("print", o9);

        Operador o10 = new listOp();
        memoria.put("list", o10);

        Operador o11 = new Atom();
        memoria.put("atom", o11);

        Operador o12 = new Quote();
        memoria.put("quote", o12);


    }

    /**
     *
     * @return devuelve la única instacia que puede haber en el programa de vocabulario o la instacia de no existir
     */
    public static Vocabulario obtenerInstancia() {
        if (instancia == null) {
            instancia = new Vocabulario();
        }
        return instancia;
    }

    /**
     *
     * @param simbolo busca el simbolo en la memoria o interpreta si es entero y cadena
     * @return devuelve el valor que representa el simbolo, si es una variable devuelve su valor, si es un entero devuelve un entero si no supone que es un string y lo devuelve talcual
     */
    public Object interpretar(String simbolo) {
        if (memoria.containsKey(simbolo)) { // el símbolo es una variable
            return memoria.get(simbolo);
        }
        else if (isInt(simbolo)) { // el símbolo es un entero
            return Integer.parseInt(simbolo);
        }
        return simbolo; // Si no es ni entero ni símbolo, debería ser una cadena
    }

    /**
     *
     * @param simbolo simbolo que se desea saber si es un operador, es decir una palabra reservada de lisp que tienen parametros y devuelve algo
     * @return booleano true si es oberador false si no
     */
    public boolean isOperador(String simbolo) {
        return memoria.containsKey(simbolo) && memoria.get(simbolo) instanceof Operador;
    }

    /**
     *
     * @param str es la cadena que se desea saber si es entero
     * @return devuelve true si la cadena representa un entero y false si no
     */
    private boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Sive para definir nuevas variables y funciones
     * @param name nombre de la variable
     * @param value valor de la variable
     */
    public void addMemori(String name, Object value){
        memoria.put(name,value);
    }

    /**
     *
     * @param simbolo cadena que se desea saber si es un atomo
     * @return boolean true si es atomo y false si no
     */
    public boolean isAtom(String simbolo){
        return   memoria.containsKey(simbolo) || isInt(simbolo) ; // tentativo || isString(simbolo)
    }

    /**
     *
     * @return devuelve la memoria con todas las variables, funciones, operadores y demas cosas que lisp entiende
     */
    public HashMap<String, Object> getMemoria() {
        return memoria;
    }
}


