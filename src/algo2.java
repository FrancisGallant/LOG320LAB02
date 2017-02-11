import java.util.ArrayList;

/**
 * Created by thorminator on 2017-02-09.
 */
public class algo2 {
    NodeList noList;
    //MovementList mList;
    public algo2(NodeList list){
        noList = list;
    }

    /*
    boolean solve(NodeList list, ArrayList<Movement> finalPath){

        if(list.numberOfFull == 1){
            return true;
        }
        // GET ALL LEGIT MOVES

        // FOR EACH MOVE IN LISTLEGITMOVES
        // IF MOVEVALID
        // DO MOVE
        // AJOUTE MOVE AU finalPath
        // if( solve( list, finalPath) return true

        //else finalPath.remove(lastMove)

        return false;
    }
    */

    /*
    boolean findSolution(Node courant, DirectionList directions){
        //TODO
        if(noList.numberOfFull == 1 ){
            return true;
        }
        Movement move = noList.findValidMovement(mList);
        if(move == null){
            //move = mList.liMovement.get(mList.liMovement.size()-1);
            move.deExecute();
            //mList.remove(move);

        }
        else{
            move.execute();
            //mList.add(move);
            findSolution();
        }

    }*/



}
