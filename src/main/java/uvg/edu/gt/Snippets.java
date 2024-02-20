package uvg.edu.gt;

<<<<<<< HEAD
=======
import org.jetbrains.annotations.NotNull;

>>>>>>> origin/master
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
<<<<<<< HEAD
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
=======
        String l = "";
        for (int i = 0; i < programa.size(); i++){
            String linea = programa.get(i);
            for (int j=0; j < linea.length(); j++ ){
                char car = linea.charAt(j);
                switch (car){
                    case '(':
                        parentesis.add("-");
                        l = l + "( ";
                        break;
                    case ')':
                        parentesis.pop();
                        l = l + " )";
                        break;
                    default:
                        l = l + car;
                }


                }
            if (parentesis.isEmpty()){
                prog2.add(l);
                l = "";
>>>>>>> origin/master
            }
        }
        return prog2;

    }

    public static List<List<String>> romperCodigo(List<String> programa){
        programa = fullLPL(programa);
        List<List<String>> pedasos = new ArrayList<>();
<<<<<<< HEAD
        for (String s : programa) {
            String[] linea = s.split(" ");
            pedasos.add(Arrays.asList(linea));
        }
=======
        for (int i = 0; i < programa.size(); i++){
            String[] linea = programa.get(i).split(" ");
            pedasos.add(Arrays.asList(linea));
            }
>>>>>>> origin/master
        return pedasos;
        }
}

