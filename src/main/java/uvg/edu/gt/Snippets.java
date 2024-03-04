package uvg.edu.gt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Snippets {
    private static List<String> fullLPL( List<String> programa){
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
        for (int i = 0; i < programa.size(); i++){
            String[] linea = programa.get(i).split(" ");
            List<String> linea2  = new ArrayList<>();
            for (String str : linea) {
                if (!str.isEmpty()) {
                    linea2.add(str);
                }
            }
            if (!linea2.isEmpty())
                pedasos.add(linea2);
        }
        return pedasos;
    }
}

