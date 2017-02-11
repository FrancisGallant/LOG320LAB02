import java.util.ArrayList;

/**
 * Created by Francis on 2017-02-11.
 */
public class Algo3 {

    public char[][] gameBoard;
    public ArrayList<Move> allPossibleMove;

    public Algo3(char[][] arr){
        gameBoard = arr;
        allPossibleMove = new ArrayList<>();
    }

    public ArrayList<Move> findAllPossibleMove(char[][] gameBoard){
        ArrayList<Move> arr = new ArrayList<>();
        for(int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                if(gameBoard[i][j] == '1'){
                    if(i < 5 && gameBoard[i+2][j] == '2' && gameBoard[i+1][j] == '1'){
                        System.out.println("toto");
                        arr.add(new Move(2,0));
                    }
                    else if( i >= 2 && gameBoard[i-2][j] == '2' && gameBoard[i-1][j] == '1'){
                        arr.add(new Move(-2,0));
                    }
                    else if(j < 5 && gameBoard[i][j+2] == '2' && gameBoard[i][j+1] == '1'){
                        arr.add(new Move(0,2));
                    }
                    else if(j >= 2 && gameBoard[i][j-2] == '2' && gameBoard[i][j-1] == '1'){
                        arr.add(new Move(0,-2));
                    }
                }
            }
        }
        return arr;
    }


    public void printArr(char[][] arr){
        for (int i = 0 ; i < 7 ; i++){
            for( int j = 0 ; j < 7 ; j++){
                System.out.print(arr[i][j]);
            }
            System.out.print('\n');
        }

    }



}
