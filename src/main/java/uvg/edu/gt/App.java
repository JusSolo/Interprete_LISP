package uvg.edu.gt;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        HashMap<String,Object> memoire = new HashMap<>();
        Integer x = 5;
        memoire.put("x", x);
        Integer toto = (int) memoire.get("x");
        toto = 9;
        System.out.println(memoire.get("x"));
    }
}
