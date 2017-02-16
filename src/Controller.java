import java.io.IOException;

/**
 * Created by Francis on 2017-02-07.
 */
public class Controller {

    public static void main (String [] args) {
        char[][] arr = new char[7][7];
        float tempsInit = 0;
        float tempsFinal = 0;
        boolean found;
        try {
            arr = MyFileReader.getInstance().returnArray(args[0]);
        } catch (IOException e) {
        e.printStackTrace();
    }

        Algo3 al = new Algo3(arr);
        al.printArr(al.gameBoard);
        tempsInit = System.nanoTime();
        found = al.solvePuzzle(al.gameBoard,al.solutionMoves);
        tempsFinal = System.nanoTime() - tempsInit;
        System.out.println('\n');
        al.printArr(al.gameBoard);
        if(!found){
            System.out.println("PAS DE SOLUTIONS");
        }
        for(int i = 0 ; i < al.solutionMoves.size() ; i++){
            System.out.println(i + ". origin: " + al.solutionMoves.get(i).getOriginX() + " " +
                    al.solutionMoves.get(i).getOriginY() + " move: " + al.solutionMoves.get(i).getX() + " " + al.solutionMoves.get(i).getY() );
            System.out.println(" ");
        }
        System.out.println("Number of nodes visited: " + al.nbrVisitedNodes);
        System.out.println("number of badBoards " + al.badBoard.size());
        System.out.println("Temps(s): " + tempsFinal/1000000000.0f);
        al.printSolutionBoard(al.gameBoard);

    }

}
