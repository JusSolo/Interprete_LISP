package uvg.edu.gt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Snippets {
    /**
     *
     * @param programa 
     * @return
     */
    public static List<String> fullLPL( List<String> programa){
        Stack<String> parentesis = new Stack<>();
        List<String> prog2 = new ArrayList<String>();

        StringBuilder l = new StringBuilder();
        for (String linea : programa) {
            linea.toLowerCase(); // nuestro interprete solo conoce minusculas
            for (int j = 0; j < linea.length(); j++) {
                char car = linea.charAt(j);
                switch (car) {
                    case '(':
                        parentesis.add("-");
                        l.append(" ( ");
                        break;
                    case ')':
                        parentesis.pop();
                        l.append(" ) ");
                        break;
                    default:
                        l.append(car);
                }


            }
            if (parentesis.isEmpty()) {
                prog2.add(l.toString());
                l = new StringBuilder();

            }
        }
        return prog2;

    }

    public static List<List<String>> romperCodigo(List<String> programa){
        programa = fullLPL(programa);
        List<List<String>> pedasos = new ArrayList<>();
        boolean isString = false;
        for (int i = 0; i < programa.size(); i++){

            String[] linea = programa.get(i).split(" ");


            List<String> linea1  = new ArrayList<>();
            for (String str : linea) {
                if (!str.isEmpty()) {
                    linea1.add(str);
                }
            }
            List<String> linea2  = new ArrayList<>();
            StringBuilder mot = new StringBuilder();
            for (int j = 0; j < linea1.size(); j++){
                String car = linea1.get(j);
                if (car.equals("\"")) { // se entra en un string al toparse con un "  se sale de el al volverse a topar en el
                    if ( isString) {
                        mot.deleteCharAt(mot.length() - 1);
                        mot.append(" \"");
                        linea2.add(String.valueOf(mot));
                        mot = new StringBuilder();
                    }
                    isString = isString == false;
                }
                if (isString){
                    mot.append(car);
                    mot.append(' ');
                }
                else {
                    if (! car.equals("\""))
                        linea2.add(car);


                }

            }
            if (!linea2.isEmpty())
                pedasos.add(linea2);
        }

        return pedasos;
    }
}

