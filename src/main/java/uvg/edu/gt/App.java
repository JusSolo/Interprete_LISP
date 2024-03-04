package uvg.edu.gt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //String programa = "(cond\n((= x 0) 'x is zero')\n((> x 0) 'x is positive')\n((< x 0) 'x is negative')\n(t 'x is not a number'))";
        String programa = "(+ 4 3)";
        List<String> programaSnip = Snippets.fullLPL(Arrays.asList(programa.split("\n")));
        System.out.println(programaSnip);

        Evaluador evaluador = new Evaluador();
        String resultado = evaluador.evaluar(programaSnip);
        System.out.println(evaluador.valores);
        System.out.println(resultado);
    }
}
