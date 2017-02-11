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

        Algo gameCtrl = new Algo(arr);
        gameCtrl.printArr(gameCtrl.gameArray);
        found = gameCtrl.recursiveAlgo(1,gameCtrl.solutionBoard);
        System.out.println(found);
        gameCtrl.printArr(gameCtrl.gameArray);
        //gameCtrl.printAllBoard();
        System.out.println(gameCtrl.numberOfNodesVisited);

        /*
        Algo3 al = new Algo3(arr);
        al.printArr(al.gameBoard);
        al.allPossibleMove = al.findAllPossibleMove(al.gameBoard);
        System.out.println(al.allPossibleMove.size());

        */


    }

}
