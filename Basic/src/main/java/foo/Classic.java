package foo;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Classic {
    public static void main(String[] args) {
        String advancedClassName = "foo.Bar";
        try {
            System.out.println("Classic lookup for class :"+advancedClassName );
            Class.forName(advancedClassName );
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
            System.out.println("Class lookup again for class:"+advancedClassName );

            URLClassLoader urlClassLoader = (URLClassLoader) cl;
            DynamicURLClassLoader dynamicURLClassLoader = new DynamicURLClassLoader(urlClassLoader);
            
            try {
                dynamicURLClassLoader.addURL(new URL(
                    "file:///Users/ronda/projects/so-test/62213471/Advanced/build/classes/java/main/"));
                System.out.println("dynamicURLClassLoader current paths:");
                URL[] dynamicUrls = ((URLClassLoader)dynamicURLClassLoader).getURLs();
                for(URL url: dynamicUrls){
                    System.out.println(url.getFile());
                }
                System.out.println("---------------------------------");
                Class.forName(advancedClassName ,true, dynamicURLClassLoader);
                System.out.println("Classic: OK");
            } catch (MalformedURLException m) {
                m.printStackTrace();    
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    static class DynamicURLClassLoader extends URLClassLoader {
        public DynamicURLClassLoader(URLClassLoader classLoader) {
            super(classLoader.getURLs());
        }

        @Override
        public void addURL(URL url) {
            super.addURL(url);
        }
    }
}