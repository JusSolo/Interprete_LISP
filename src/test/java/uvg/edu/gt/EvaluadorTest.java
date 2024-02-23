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
}