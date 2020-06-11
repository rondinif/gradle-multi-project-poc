package foo;

import java.net.URL;
import java.net.URLClassLoader;

public class Classic {
    public static void main(String[] args) {
        String advancedClassName = "foo.Bar";
        try {
            System.out.println("Classic lookup for class :"+advancedClassName );
            Class.forName(advancedClassName);
            System.out.println("Classic: OK");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            System.out.println("SystemClassLoader current paths:");
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            URL[] urls = ((URLClassLoader)cl).getURLs();
            for(URL url: urls){
                System.out.println(url.getFile());
            }
            System.out.println("---------------------------------");
        }
    }
}