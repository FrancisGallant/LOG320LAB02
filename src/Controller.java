import java.io.IOException;

/**
 * Created by Francis on 2017-02-07.
 */
public class Controller {

    public static void main (String [] args) {
        char[][] arr = new char[7][7];
        boolean found;
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
        al.printArr(al.gameBoard);
        found = al.solvePuzzle(al.gameBoard,al.badBoard,1,al.solutionMoves);
        System.out.println(found);
        for(int i = 0 ; i < al.solutionMoves.size() ; i++){
            System.out.println(al.solutionMoves.get(i).getX() + " " + al.solutionMoves.get(i).getY() );
            System.out.println(" ");
        }
        System.out.println(al.solutionMoves.size());
        //al.printArr(al.gameBoard);

        System.out.println("Number of nodes visited: " + al.nbrVisitedNodes);
        System.out.println("number of badBoards " + al.badBoard.size());

        /*
        for(Move m : al.solutionMoves){
            System.out.println(m.getOriginX() + " , " + m.getOriginY());
        }
        */





    }

}
