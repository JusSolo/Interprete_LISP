package uvg.edu.gt;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EvaluadorTest {

    @Test
    void evaluar() {
        List<String> codigo =  Arrays.asList("(","+","5","(", "+" , "3", "4",")",")");
        Evaluador evaluador = new Evaluador();
        String resp = evaluador.evaluar(codigo);
        assertEquals("12",resp);

    }

    @Test
    void evaluarDefun() {// probando defun
        List<String> L1 =  Arrays.asList("(","defun","sucesor","(", "n" , ")", "(","+","n","1",")",")");
        List<String> L2 =  Arrays.asList("(","sucesor", "4", ")");
        Evaluador evaluador = new Evaluador();
        System.out.println(evaluador.evaluar(L1));
        String resp = evaluador.evaluar(L2);

        assertEquals("5",resp);

    }
}