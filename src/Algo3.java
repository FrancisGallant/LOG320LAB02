import java.util.*;

/**
 * Created by Francis on 2017-02-11.
 */
public class Algo3 {

    public char[][] gameBoard;

    public ArrayList<Move> solutionMoves;

    public int numberOfPegs;
    public int maxNumOfPegs;
    public ArrayList<char[][]> badBoard;
    public int nbrVisitedNodes;
    public int val = 0;

    public Algo3(char[][] arr){
        gameBoard = arr;
        nbrVisitedNodes = 0;

        countNumberOfPegs();

        solutionMoves = new ArrayList<>();
        badBoard = new ArrayList<char[][]>();
    }


    public ArrayList<Move> findAllPossibleMove(char[][] gameBoard){
        ArrayList<Move> arr = new ArrayList<>();
        for(int i = 0; i < 7 ; i++) {
            for (int j = 0; j < 7; j++) {
                if(gameBoard[i][j] == '1'){
                    if(j >= 2 && gameBoard[i][j-2] == '2' && gameBoard[i][j-1] == '1')
                    {
                        arr.add(new Move(0,-2,i,j));
                    }
                    if(i < 5 && gameBoard[i+2][j] == '2' && gameBoard[i+1][j] == '1')
                    {
                        arr.add(new Move(2,0,i,j));
                    }
                    if(j < 5 && gameBoard[i][j+2] == '2' && gameBoard[i][j+1] == '1')
                    {
                        arr.add(new Move(0,2,i,j));
                    }

                    if( i >= 2 && gameBoard[i-2][j] == '2' && gameBoard[i-1][j] == '1')
                    {
                        arr.add(new Move(-2,0,i,j));
                    }






                }
            }
        }
        //Collections.shuffle(arr);
        return arr;
    }

    public boolean solvePuzzle(char[][] currenGameBoard , int depth , ArrayList<Move> solution ) {
        if (checkSolution(currenGameBoard) && solution.size() <= maxNumOfPegs) {
            return true;
        }

        ArrayList<Move> allPossibleMove = findAllPossibleMove(currenGameBoard);
        if (!contains(badBoard,currenGameBoard)) {
            for (Move move : allPossibleMove) {
                currenGameBoard = move(currenGameBoard, move);

                nbrVisitedNodes++;
                solution.add(move);
                if (solvePuzzle(currenGameBoard, depth + 1, solution)) {
                    return true;
                } else {
                    //System.out.println(allPossibleMove.size());


                    currenGameBoard = unmove(currenGameBoard, move);
                    solution.remove(solution.size() - 1);
                }
            }

            badBoard.add(val++, copy(currenGameBoard));

            //printBadboard();
            //System.out.println("");

            //currenGameBoard = unmove(currenGameBoard, move);
        }
        else {
            printArr(currenGameBoard);
        }
        return false;
    }
    public char[][] copy (char[][] charArr){
        char[][] tempBoard = new char[7][7];
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){

                tempBoard[i][j] = charArr[i][j];
            }
        }
         return tempBoard;

    }
    public void printBadboard(){
        for(int i=0;i<badBoard.size();i++){
            printArr(badBoard.get(i));
        }
    }
    public boolean contains(ArrayList<char[][]> arrayList, char[][] arr){

        for(int k=0;k<arrayList.size();k++)
        {
            char[][] arr2 = arrayList.get(k);
            boolean aresame = true;
            for(int i=0;i < arr2.length;i++){

                for(int j=0;j < arr2[i].length;j++){
                    if(arr[i][j] != arr2[i][j]){

                        aresame = false;
                    }
                }

            }
            if(aresame)
            {
                return true;
            }

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
