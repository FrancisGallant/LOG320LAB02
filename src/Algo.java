import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Francis on 2017-02-09.
 */
public class Algo {

    char[][] gameArray;
    int numberOfFilledSpace;
    int maxDepth;
    ArrayList possibleDirection;
    int numberOfNodesVisited;
    LinkedList solutionBoard;
    ArrayList badBoard;
    ArrayList<Move> allPossibleMoves;


    public Algo(char[][] array){
        numberOfNodesVisited = 0;
        gameArray = array;
        countFilledHole();
        maxDepth = numberOfFilledSpace-1;
        solutionBoard = new LinkedList();
        badBoard = new ArrayList();
        possibleDirection = new ArrayList();
        allPossibleMoves = new ArrayList<>();
        possibleDirection.add('l');
        possibleDirection.add('r');
        possibleDirection.add('u');
        possibleDirection.add('d');

    }


    public void countFilledHole(){
        for(int i = 0 ; i < 7 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                if(gameArray[i][j] == '1'){
                    numberOfFilledSpace++;
                }
            }
        }
    }

    public boolean recursiveAlgo(int depth, LinkedList solutionBoard){

        if(numberOfFilledSpace == 1){
            return true;
        }

        for(int i = 0 ; i < 7 && depth <= maxDepth ; i++){
            for( int j = 0 ; j < 7 ; j++ ){
                for(int k = 0 ; k < 4 ; k++){
                    if(isValidMove(i,j,(char)possibleDirection.get(k))){
                        move(i,j,(char)possibleDirection.get(k));
                        numberOfNodesVisited++;
                        solutionBoard.add(gameArray);
                        if(depth <= maxDepth && numberOfFilledSpace > 1 ){
                            if( recursiveAlgo(depth+1, solutionBoard)){
                                return true;
                            }
                            else{
                                unmove(i,j,(char)possibleDirection.get(k));
                                solutionBoard.removeLast();
                                //badBoard.add(gameArray);
                            }
                        }
                        else{
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }


    public void move(int currX, int currY, char direction){
        if(direction == 'u'){
            gameArray[currX][currY] = '2';
            gameArray[currX-1][currY] = '2';
            gameArray[currX-2][currY] = '1';
            numberOfFilledSpace -=1;
        }
        if(direction == 'd'){
            gameArray[currX][currY] = '2';
            gameArray[currX+1][currY] = '2';
            gameArray[currX+2][currY] = '1';
            numberOfFilledSpace -=1;
        }
        if(direction == 'l'){
            gameArray[currX][currY] = '2';
            gameArray[currX][currY-1] = '2';
            gameArray[currX][currY-2] = '1';
            numberOfFilledSpace -=1;
        }
        if(direction == 'r'){
            gameArray[currX][currY] = '2';
            gameArray[currX][currY+1] = '2';
            gameArray[currX][currY+2] = '1';
            numberOfFilledSpace -=1;
        }

    }

    public void printArr(char[][] arr){
        for (int i = 0 ; i < 7 ; i++){
            for( int j = 0 ; j < 7 ; j++){
                System.out.print(arr[i][j]);
            }
            System.out.print('\n');
        }

    }

    public void printAllBoard(){
        for(int i = 0 ; i < solutionBoard.size(); i++){
            for (int j = 0 ; j < 7 ; j++){
                for( int k = 0 ; k < 7 ; k++){
                    System.out.print(((char[][]) solutionBoard.get(i))[j][k]);
                }
                System.out.print('\n');
            }
            System.out.println('\n');
        }

        System.out.println("solutionBoardSize: " + solutionBoard.size());
    }

    public void unmove(int currX,int currY,char direction){
        //System.out.println("IN UNNNNNNMOVOOOOOVEEE");
        if(direction == 'u'){
            gameArray[currX][currY] = '1';
            gameArray[currX-1][currY] = '1';
            gameArray[currX-2][currY] = '2';
            numberOfFilledSpace +=1;
        }
        if(direction == 'd'){
            gameArray[currX][currY] = '1';
            gameArray[currX+1][currY] = '1';
            gameArray[currX+2][currY] = '2';
            numberOfFilledSpace +=1;
        }
        if(direction == 'l'){
            gameArray[currX][currY] = '1';
            gameArray[currX][currY-1] = '1';
            gameArray[currX][currY-2] = '2';
            numberOfFilledSpace +=1;
        }
        if(direction == 'r'){
            gameArray[currX][currY] = '1';
            gameArray[currX][currY+1] = '1';
            gameArray[currX][currY+2] = '2';
            numberOfFilledSpace +=1;
        }

    }

    public int randomDirection(int max){
        if(max > 0)
            return ThreadLocalRandom.current().nextInt(0, max + 1);
        else
            return 0;
    }
    /*
    public ArrayList<Move> findAllValidMoves(char[][] board){
        ArrayList<Move> arr = new ArrayList<>();
        for(int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                if(board[i][j] == '1'){
                    if(i < 5 && board[i+2][j] == '2' && board[i+1][j] == '1'){
                        arr.add(new Move(2,0));
                    }
                    else if( i >= 2 && board[i-2][j] == '2' && board[i-1][j] == '1'){
                        arr.add(new Move(-2,0));
                    }
                    else if(j < 5 && board[i][j+2] == '2' && board[i][j+1] == '1'){
                        arr.add(new Move(0,2));
                    }
                    else if(j >= 2 && board[i][j-2] == '2' && board[i][j-1] == '1'){
                        arr.add(new Move(0,-2));
                    }
                }
            }
        }
        return arr;
    }
    */


    public boolean isValidMove(int currX, int currY, char direction){
        if(gameArray[currX][currY] != '1'){
            return false;
        }
        //UP
        if(direction == 'u'){
            //outOfBound
            if(currX-2 < 0){
                return false;
            }
            //System.out.println("moveUp");
            if(gameArray[currX-1][currY] == '1' ){
                if(gameArray[currX-2][currY] == '2'){
                    return true;
                }
            }
            return false;
        }
        //DOWN
        else if(direction == 'd'){
            //outOfBound
            if(currX+2 >= 7 ){
                return false;
            }
            //System.out.println("moveDown");
            if(gameArray[currX+1][currY] == '1' ){
                if(gameArray[currX+2][currY] == '2'){
                    return true;
                }
            }
            return false;

        }
        //LEFT
        else if(direction == 'l'){
            //outOfBound
            if(currY-2 <0){
                return false;
            }
            //System.out.println("moveLeft");
            if(gameArray[currX][currY-1] == '1' ){
                if(gameArray[currX][currY-2] == '2'){
                    return true;
                }
            }
            return false;
        }
        //RIGHT
        else if(direction == 'r'){
            //outOfBound
            if(currY+2 >= 7){
                return false;
            }
            //System.out.println("moveRight");
            if(gameArray[currX][currY+1] == '1' ){
                if(gameArray[currX][currY+2] == '2'){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
