import java.util.ArrayList;

/**
 * Created by thorminator on 2017-02-09.
 */
public class MovementGenerator {
    public Movement getRandomMovement(NodeList nodes, DirectionList directions){
        ArrayList<Node> liNode = nodes.liNode;
        for(int i=0;i<liNode.size();i++){
            Node currentNode = liNode.get(i);
            if(currentNode != null){
                Movement movement;
                if(!directions.exists(Direction.top))
                {
                    movement = new Movement(currentNode, Direction.top);
                    if(movement.isValidMove()){
                        return movement;

                    }
                }
                if(!directions.exists(Direction.down))
                {
                    movement = new Movement(currentNode, Direction.down);
                    if(movement.isValidMove()){
                        return movement;

                    }
                }
                if(!directions.exists(Direction.left))
                {
                    movement = new Movement(currentNode, Direction.left);
                    if(movement.isValidMove()){
                        return movement;

                    }
                }
                if(!directions.exists(Direction.right))
                {
                    movement = new Movement(currentNode, Direction.right);
                    if(movement.isValidMove()){
                        return movement;

                    }
                }
            }
        }
        return null;

    }
}
