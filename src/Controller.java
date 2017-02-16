import java.io.IOException;

/**
 * Created by Francis on 2017-02-07.
 */
public class Controller {

    public static void main (String [] args) {
        char[][] arr = new char[7][7];
        boolean found;
        float initTime= 0;
        float finalTime=0;
        try {
            arr = MyFileReader.getInstance().returnArray(args[0]);
        } catch (IOException e) {
        e.printStackTrace();
    }
        /*
        Algo gameCtrl = new Algo(arr);
        gameCtrl.printArr(gameCtrl.gameArray);
        found = gameCtrl.recursiveAlgo(1,gameCtrl.solutionBoard);
        System.out.println(found);
        gameCtrl.printArr(gameCtrl.gameArray);
        //System.out.println(gameCtrl.numberOfNodesVisited);
        System.out.println(gameCtrl.numberOfNodesVisited);
        */


        Algo3 al = new Algo3(arr);
        //al.printArr(al.gameBoard);
        initTime = System.nanoTime();
        found = al.solvePuzzle(al.gameBoard,al.solutionMoves);
        finalTime = System.nanoTime() - initTime;
        System.out.println(found);
        for(int i = 0 ; i < al.solutionMoves.size() ; i++){
            System.out.println(i + ". : origin: " + al.solutionMoves.get(i).getOriginX() + " " + al.solutionMoves.get(i).getOriginY() + " movement: " + al.solutionMoves.get(i).getX() + " " +
                    al.solutionMoves.get(i).getY());
            System.out.println(" ");
        }
        System.out.println(al.solutionMoves.size());
        //al.printArr(arr);
        al.printAllBoard();
        //al.printArr(al.gameBoard);
        System.out.println(finalTime/1000000000.0f + " secondes");

        System.out.println("Number of nodes visited: " + al.nbrVisitedNodes);
        System.out.println("number of badBoards " + al.badBoard.size());

        /*
        for(Move m : al.solutionMoves){
            System.out.println(m.getOriginX() + " , " + m.getOriginY());
        }
        */





    }

}
