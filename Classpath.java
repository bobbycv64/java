/**
 * This program shows an example of how to compile a packaged class
 *
 * There are several ways to compile this program.  This example is
 * implying that the program is in the directory c:\classpath.
 *
 * Option 1)
 *
 *   cd c:\
 *   javac classpath/Classpath.java
 *   java classpath.Classpath
 *
 * Option 2)
 *
 *   cd c:\
 *   javac -classpath c:\ classpath/Classpath.java
 *   java -classpath c:\ classpath.Classpath   
 *
 * Option 3)
 *
 *   set classpath=c:\
 *   cd c:\
 *   javac -classpath %classpath% classpath/Classpath.java
 *   java -classpath %classpath% classpath.Classpath   
 * 
 */
package classpath;

public class Classpath {

  public static void main(String[] args) {
    System.out.println("Classpath Program");
  }
}