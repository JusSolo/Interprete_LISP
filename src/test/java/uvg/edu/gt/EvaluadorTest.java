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

    @Test
    void evaluarResta() {// probando defun

        List<String> L1 =  Arrays.asList("(- 56 6)");
        List<List<String>> cod = Snippets.romperCodigo(L1);
        Evaluador evaluador = new Evaluador();
        String resp = evaluador.evaluar(cod.get(0));

        assertEquals("50",resp);

    }
    @Test
    void evaluarEquals() {// probando defun

        List<String> L1 =  Arrays.asList("(= 56 6)");
        List<List<String>> cod = Snippets.romperCodigo(L1);
        Evaluador evaluador = new Evaluador();
        String resp = evaluador.evaluar(cod.get(0));

        assertEquals("nil",resp);

    }

    @Test
    void evaluarSetq() {// probando setq

        List<String> L1 =  Arrays.asList("(setq x 6)","(+ x 8)");
        List<List<String>> cod = Snippets.romperCodigo(L1);
        Evaluador evaluador = new Evaluador();
        Vocabulario voc = Vocabulario.obtenerInstancia();
        String set = evaluador.evaluar(cod.get(0));
        String eq = evaluador.evaluar(cod.get(1));

        assertEquals("14",eq);

    }
}