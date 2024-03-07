package uvg.edu.gt;

import java.util.HashMap;

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
    }

    public static Vocabulario obtenerInstancia() {
        if (instancia == null) {
            instancia = new Vocabulario();
        }
        return instancia;
    }

    public Object interpretar(String simbolo) {
        if (memoria.containsKey(simbolo)) { // el símbolo es una variable
            return memoria.get(simbolo);
        }
        else if (isInt(simbolo)) { // el símbolo es un entero
            return Integer.parseInt(simbolo);
        }
        return simbolo; // Si no es ni entero ni símbolo, debería ser una cadena
    }

    public boolean isOperador(String simbolo) {
        return memoria.containsKey(simbolo) && memoria.get(simbolo) instanceof Operador;
    }

    private boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void addMemori(String name, Object value){
        memoria.put(name,value);
    }

    public boolean isAtom(String simbolo){
        return   memoria.containsKey(simbolo) || isInt(simbolo) ; // tentativo || isString(simbolo)
    }

    public HashMap<String, Object> getMemoria() {
        return memoria;
    }
}


