import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Francis on 2017-02-07.
 */
public class MyFileReader {

    private static MyFileReader instance ;
    private static int ARR_HEIGHT = 7;
    private static int ARR_WIDTH = 7;
    Scanner scanner;

    private MyFileReader(){

    }

    public static MyFileReader getInstance(){
        if(instance == null){
            instance = new MyFileReader();
        }
        return instance;
    }


    public char[][] returnArray(String fileName) throws IOException {

        char[][] arr = new char[ARR_HEIGHT][ARR_WIDTH];
        BufferedReader buffer = new BufferedReader(
                new FileReader(fileName));
        String s;
        for(int i =0; i < ARR_HEIGHT ; i++){
            if( (s = buffer.readLine()) != null){
                for(int j = 0 ; j < ARR_WIDTH ; j++){
                    arr[i][j] = s.charAt(j);
                }
            }
        }
        return arr;
    }



}
