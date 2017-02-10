import java.util.Objects;

/**
 * Created by thorminator on 2017-02-09.
 */
public class Movement {
    Node startingNode;
    Direction direction;
    Node centerNode;
    Node endingNode;

    public Movement(Node n, Direction d) {
        startingNode = n;
        direction = d;
    }


    boolean isValidMove() {
        if(startingNode.isEmpty()){
            return false;
        }
        if (startingNode.get(direction) != null) {

            if (!startingNode.get(direction).isEmpty()) {
                centerNode = startingNode.get(direction);
            } else {
                return false;
            }

            if (centerNode.get(direction) != null) {

                if (centerNode.get(direction).isEmpty()) {
                    endingNode = centerNode.get(direction);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    void execute()
    {
        startingNode.empty = true;
        centerNode.empty = true;
        endingNode.empty = false;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Movement)) {
            return false;
        }

        Movement m = (Movement) o;
        if (m.startingNode == startingNode && m.direction == direction) {
            return true;

        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(startingNode, direction);
    }
}