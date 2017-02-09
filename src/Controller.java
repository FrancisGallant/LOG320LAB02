import java.io.IOException;

/**
 * Created by Francis on 2017-02-07.
 */
public class Controller {

    public static void main (String [] args) {
        char[][] arr = new char[7][7];
        try {
            arr = MyFileReader.getInstance().returnArray(args[0]);
        } catch (IOException e) {
        e.printStackTrace();
    }

        Algo gameCtrl = new Algo(arr);
        System.out.println(gameCtrl.isValidMove(0,0,'l'));



    }

}
