/**
 * Created by Francis on 2017-02-09.
 */
public class Algo {

    char[][] gameArray;
    int numberOfFilledSpace;
    int numberOfEmptySpace;

    public Algo(char[][] array){
        gameArray = array;
    }

    public boolean eatPiece(int currX, int currY){

        //find empty space and randomly pick a node -2,+2 horizontal or -2+2 vertical
        char d = randomDirection();
        if(isValidMove(currX,currY,d)){
            modifyArray(currX,currY,d);
            if(d == 'u'){

            }
            if(d == 'd'){

            }
            if(d == 'l'){

            }
            if(d == 'r'){

            }
        }
        return false;
    }

    public void modifyArray(int currX, int currY, char direction){
        if(direction == 'u'){
            gameArray[currX][currY] = '2';
            gameArray[currX-1][currY] = '2';
            gameArray[currX-2][currY] = '1';
        }
        if(direction == 'd'){
            gameArray[currX][currY] = '2';
            gameArray[currX+1][currY] = '2';
            gameArray[currX+2][currY] = '1';
        }
        if(direction == 'l'){
            gameArray[currX][currY] = '2';
            gameArray[currX][currY-1] = '2';
            gameArray[currX][currY-2] = '1';
        }
        if(direction == 'r'){
            gameArray[currX][currY] = '2';
            gameArray[currX][currY+1] = '2';
            gameArray[currX][currY+2] = '1';
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
