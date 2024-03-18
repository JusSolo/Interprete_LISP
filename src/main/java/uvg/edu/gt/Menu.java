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
            System.out.println("3 Salir ");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
Evaluador evaluador = new Evaluador() ;

            switch (opcion) {
                case 1:
                    Leo leo = new Leo() ;
                    String dirJl = "/home/juan/Documentos/education/U/Semestres/Semestre_9/Algoritmos y Estructura/Tareas/HDT/Interprete_LISP/src/main/java/uvg/edu/gt/Codigo.txt";
                    String dirPal = "C:\\Users\\gabri\\IdeaProjects\\Interprete_LISP0\\src\\main\\java\\uvg\\edu\\gt\\Codigo.txt";
                    List<String> Listainstrucciones = leo.leerArchivo(dirPal)  ;
                    List<List<String>> Listainstrucciones1 = Snippets.romperCodigo(Listainstrucciones) ;
                            for(List<String>comando:Listainstrucciones1) {
                                String salida = evaluador.evaluar(comando);
                                System.out.println(salida) ;
                            }
                    break;
                case 2:
                    System.out.println("Esta es una implmentacion de LISP Incompleta , Disfrute y espere no tener errores ");
                    System.out.print("Ingrese una expresión LISP (o \"salir\" para terminar): ");
                    while (true) {

                        System.out.print("*");
                        String comando = scanner.nextLine();

                        if (comando.equalsIgnoreCase("salir")) {
                            break;
                        }

                        if (comando.isEmpty()) {
                            System.out.println("Error: Debe ingresar una expresión LISP válida.");
                            continue;
                        }

                        List<String> L1 = Arrays.asList(comando);
                        List<List<String>> L2 = Snippets.romperCodigo(L1);

                        if (L2.isEmpty()) {
                            System.out.println("Error: La expresión LISP no se pudo analizar.");
                            continue;
                        }

                        List<String> comando0 = L2.get(0);
                        String salida = evaluador.evaluar(comando0);
                        System.out.println(salida);
                    }
                    break;
                case 3:
                    System.out.println("¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }
}