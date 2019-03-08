
import java.util.Properties;

public class Env {
   
    public static void main(String[] args) {
	Properties props = System.getProperties();
	props.list(System.out);
	
    }
}
