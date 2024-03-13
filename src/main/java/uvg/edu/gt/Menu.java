package uvg.edu.gt;
import java.util.* ;
//import jdk.jshell.Snippet;

import java.util.List;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("**Menú**");
            System.out.println("1.Ejecutar archivo desde un .txt");
            System.out.println("2. Terminal LISP");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
Evaluador evaluador = new Evaluador() ;

            switch (opcion) {
                case 1:
                    Leo leo = new Leo() ;
                    List<String> Listainstrucciones = leo.leerArchivo("C:\\Users\\gabri\\IdeaProjects\\Interprete_LISP0\\src\\main\\java\\uvg\\edu\\gt\\Codigo.txt")  ;
                    List<List<String>> Listainstrucciones1 = Snippets.romperCodigo(Listainstrucciones) ;
                            for(List<String>comando:Listainstrucciones1) {
                                String salida = evaluador.evaluar(comando);
                                System.out.println(salida) ;
                            }
                    break;
                case 2:
                    System.out.println("¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 2);
    }
}
