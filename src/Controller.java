import java.io.IOException;

/**
 * Created by Francis on 2017-02-07.
 */
public class Controller {

    public static void main (String [] args) {
        System.out.println("hello world");
        char[][] arr = new char[7][7];
        try {
            arr = MyFileReader.getInstance().returnArray(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
