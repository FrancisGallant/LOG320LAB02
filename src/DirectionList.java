import java.util.ArrayList;

/**
 * Created by thorminator on 2017-02-09.
 */
public class DirectionList {
    ArrayList<Direction> directions;

    public DirectionList(){
        directions = new ArrayList<Direction>();
    }

    void add(Direction d){
        directions.add(d);
    }

    boolean exists(Direction d){
        for (int i=0; i<directions.size();i++) {
            if(directions.get(i) == d){
                return true;
            }
        }
        return false;
    }
}
