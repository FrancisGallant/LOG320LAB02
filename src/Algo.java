import java.util.ArrayList;

/**
 * Created by Francis on 2017-02-09.
 */
public class Algo {

    char[][] gameArray;
    int numberOfFilledSpace;
    int numberOfEmptySpace;
    boolean solutionFound = false;
    ArrayList<Position> listLegitMoves;


    public Algo(char[][] array){
        gameArray = array;
        listLegitMoves = new ArrayList<>();
        countFilledHole();

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

    public void findAvailableMoves(){
        for(int i = 0 ; i < 7 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                if(gameArray[i][j] == '1'){
                    if(i >= 2 && gameArray[i][j] == '1' &&
                            gameArray[i-1][j] == '1' && gameArray[i-2][j] == '2'){
                        listLegitMoves.add(new Position(i,j));
                    }

                    if(i < 6 && gameArray[i][j] == '1' && gameArray[i+1][j] == '1' &&
                            gameArray[i+2][j] == '2'){
                        listLegitMoves.add(new Position(i,j));
                    }
                    if(j >= 2 && gameArray[i][j] == '1' && gameArray[i][j-1] == '1' &&
                            gameArray[i][j-2] == '2'){
                        listLegitMoves.add(new Position(i,j));
                    }
                    if(j < 6 && gameArray[i][j] == '1' && gameArray[i][j+1] == '1' &&
                            gameArray[i][j+2] == '2'){
                        listLegitMoves.add(new Position(i,j));
                    }


                }
            }
        }
    }




    // WE STOP WHEN numberOfFilledSpace = 1 OR NO MORE MOVE POSSIBLE
    public boolean eatPiece(int currX, int currY, char[] possibleDir){

        //find empty space and randomly pick a node -2,+2 horizontal or -2+2 vertical
        char d = randomDirection();
        if(!solutionFound && isValidMove(currX,currY,d)){
            move(currX,currY,d);
            if(!solutionFound){
                //eatPiece(listLegitMoves.get(0).getX(),listLegitMoves.get(0).getY(),);
            }
            else{
                //print number of nodes visited, tableaux du chemin
                return true;
            }
        }
        else{
            //unmove();
            //possibleDir.remove(1);
            //eatPiece(x,y,possibleDir);
        }
        return false;
    }



    public boolean checkSolution(){
        if(numberOfFilledSpace == 1)
            return true;
        return false;
    }

    public void move(int currX, int currY, char direction){
        if(direction == 'u'){
            gameArray[currX][currY] = '2';
            gameArray[currX-1][currY] = '2';
            gameArray[currX-2][currY] = '1';
            //numberOfFilledHole -=1;
        }
        if(direction == 'd'){
            gameArray[currX][currY] = '2';
            gameArray[currX+1][currY] = '2';
            gameArray[currX+2][currY] = '1';
            //numberOfFilledHole -=1;
        }
        if(direction == 'l'){
            gameArray[currX][currY] = '2';
            gameArray[currX][currY-1] = '2';
            gameArray[currX][currY-2] = '1';
            //numberOfFilledHole -=1;
        }
        if(direction == 'r'){
            gameArray[currX][currY] = '2';
            gameArray[currX][currY+1] = '2';
            gameArray[currX][currY+2] = '1';
            //numberOfFilledHole -=1;
        }
    }

    public void unmove(int currX,int currY,char direction){
        if(direction == 'u'){
            gameArray[currX][currY] = '1';
            gameArray[currX-1][currY] = '1';
            gameArray[currX-2][currY] = '2';
            //numberOfFilledHole +=1;
        }
        if(direction == 'd'){
            gameArray[currX][currY] = '1';
            gameArray[currX+1][currY] = '1';
            gameArray[currX+2][currY] = '2';
            //numberOfFilledHole +=1;
        }
        if(direction == 'l'){
            gameArray[currX][currY] = '1';
            gameArray[currX][currY-1] = '1';
            gameArray[currX][currY-2] = '2';
            //numberOfFilledHole +=1;
        }
        if(direction == 'r'){
            gameArray[currX][currY] = '1';
            gameArray[currX][currY+1] = '1';
            gameArray[currX][currY+2] = '2';
            //numberOfFilledHole +=1;
        }
    }

    public char randomDirection(){
        int num = (int) ((Math.random() * 4) + 1);
        if(num == 1)
            return 'u';
        if(num == 2)
            return 'd';
        if(num == 3)
            return 'l';
        else
            return 'r';

    }


    public boolean isValidMove(int currX, int currY, char direction){
        //UP
        if(direction == 'u'){
            //outOfBound
            if(currX-2 < 0){
                return false;
            }
            System.out.println("moveUp");
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
            if(currX+2 > 7 ){
                return false;
            }
            System.out.println("moveDown");
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
            System.out.println("moveLeft");
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
            if(currY+2 >7){
                return false;
            }
            System.out.println("moveRight");
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
