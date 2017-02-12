import java.util.*;

/**
 * Created by Francis on 2017-02-11.
 */
public class Algo3 {

    public char[][] gameBoard;
    public ArrayList<Move> allPossibleMove;
    public ArrayList<Move> solutionMoves;
    public int numberOfPegs;
    public int maxNumOfPegs;
    public Hashtable badBoard;
    public int nbrVisitedNodes;
    public int val = 0;

    public Algo3(char[][] arr){
        gameBoard = arr;
        nbrVisitedNodes = 0;

        countNumberOfPegs();
        allPossibleMove = new ArrayList<>();
        solutionMoves = new ArrayList<>();
        badBoard = new Hashtable();
    }


    public ArrayList<Move> findAllPossibleMove(char[][] gameBoard){
        ArrayList<Move> arr = new ArrayList<>();
        for(int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                if(gameBoard[i][j] == '1'){
                    if(j < 5 && gameBoard[i][j+2] == '2' && gameBoard[i][j+1] == '1'){
                        arr.add(new Move(0,2,i,j));
                    }
                    else if(i < 5 && gameBoard[i+2][j] == '2' && gameBoard[i+1][j] == '1'){
                        arr.add(new Move(2,0,i,j));
                    }
                    else if( i >= 2 && gameBoard[i-2][j] == '2' && gameBoard[i-1][j] == '1'){
                        arr.add(new Move(-2,0,i,j));
                    }
                    else if(j >= 2 && gameBoard[i][j-2] == '2' && gameBoard[i][j-1] == '1'){
                        arr.add(new Move(0,-2,i,j));
                    }
                }
            }
        }
        //Collections.shuffle(arr);
        return arr;
    }

    public boolean solvePuzzle(char[][] currenGameBoard, Hashtable badBoard , int depth , ArrayList<Move> solution ){
        if(checkSolution(currenGameBoard) && solution.size() <=maxNumOfPegs){
            return true;
        }

        allPossibleMove = findAllPossibleMove(currenGameBoard);
        for(Move move : allPossibleMove){
            currenGameBoard = move(currenGameBoard,move);
            if(!badBoard.containsValue(currenGameBoard)) {
                nbrVisitedNodes++;
                solution.add(move);
                if (solvePuzzle(currenGameBoard, badBoard, depth + 1, solution)) {
                    return true;
                }
                else {
                    //System.out.println("GOING IN BADBOARD");
                    //badBoard.put(val++,currenGameBoard);
                    currenGameBoard = unmove(currenGameBoard, move);
                    solution.remove(solution.size() - 1);
                }
            }
            currenGameBoard = unmove(currenGameBoard,move);
        }
        return false;
    }


    public boolean checkSolution(char[][] currBoard){
        int count = 0;
        for(int i = 0 ; i < 7 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                if(currBoard[i][j] == '1'){
                    count++;
                }
            }
        }
        if(count == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public char[][] move(char[][]currentGameBoard , Move m){
        // devrais pas avoir de OutOfBound cause checked in findAllPossiblesMoves
        //UP
        if(m.getX() == -2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '2';
            currentGameBoard[m.getOriginX() -1][m.getOriginY()] = '2';
            currentGameBoard[m.getOriginX() -2][m.getOriginY()] = '1';
        }
        //DOWN
        if(m.getX() == 2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '2';
            currentGameBoard[m.getOriginX() + 1][m.getOriginY()] = '2';
            currentGameBoard[m.getOriginX() + 2][m.getOriginY()] = '1';
        }
        //LEFT
        if(m.getY() == -2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '2';
            currentGameBoard[m.getOriginX()][m.getOriginY() -1] = '2';
            currentGameBoard[m.getOriginX()][m.getOriginY() -2] = '1';
        }
        //RIGHT
        if(m.getY() == +2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '2';
            currentGameBoard[m.getOriginX()][m.getOriginY() +1] = '2';
            currentGameBoard[m.getOriginX()][m.getOriginY() +2] = '1';
        }
        //numberOfPegs --;
        return currentGameBoard;
    }

    public char[][] unmove(char[][]currentGameBoard , Move m){
        // devrais pas avoir de OutOfBound cause checked in findAllPossiblesMoves
        //UP
        if(m.getX() == -2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '1';
            currentGameBoard[m.getOriginX() -1][m.getOriginY()] = '1';
            currentGameBoard[m.getOriginX() -2][m.getOriginY()] = '2';
        }
        //DOWN
        if(m.getX() == 2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '1';
            currentGameBoard[m.getOriginX() + 1][m.getOriginY()] = '1';
            currentGameBoard[m.getOriginX() + 2][m.getOriginY()] = '2';
        }
        //LEFT
        if(m.getY() == -2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '1';
            currentGameBoard[m.getOriginX()][m.getOriginY() -1] = '1';
            currentGameBoard[m.getOriginX()][m.getOriginY() -2] = '2';
        }
        //RIGHT
        if(m.getY() == +2){
            currentGameBoard[m.getOriginX()][m.getOriginY()] = '1';
            currentGameBoard[m.getOriginX()][m.getOriginY() +1] = '1';
            currentGameBoard[m.getOriginX()][m.getOriginY() +2] = '2';
        }
        //numberOfPegs ++;
        return currentGameBoard;
    }


    public void countNumberOfPegs(){
        for(int i = 0 ; i < 7 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                if(gameBoard[i][j] == '1'){
                    numberOfPegs++;
                    maxNumOfPegs++;
                }
            }
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



}
