package uvg.edu.gt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnippetsTest {

    @org.junit.jupiter.api.Test
    void romperCodigo() {
        List<String> codigo =  Arrays.asList("(","+ ","1 2",")","(* 1 23 45)","(+ (* ( + 1 2) 5", ")6)");
        List<String> s1 = Arrays.asList("(","+","1" , "2",")");
        List<String> s2 = Arrays.asList("(","*", "1", "23", "45",")");
        List<String> s3 = Arrays.asList("(","+", "(","*", "(", "+", "1","2",")" ,"5", ")","6",")");
        List<List<String>> esperado = new ArrayList<>();
        esperado.add(s1);
        esperado.add(s2);
        esperado.add(s3);
        List<List<String>> actual = Snippets.romperCodigo(codigo);
        String x1 = actual.toString();
        String x2 = esperado.toString();
        assertEquals(x2,x1);
    }
}