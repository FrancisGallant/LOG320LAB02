import java.util.ArrayList;

/**
 * Created by thorminator on 2017-02-09.
 */
public class NodeList {
    ArrayList<Node> liNode;
    int numberOfFull;
    public NodeList(ArrayList<Node> nodes){
        liNode = nodes;
        for(int i=0; i<liNode.size();i++){
            if(!liNode.get(i).isEmpty()){
                numberOfFull++;
            }
        }
    }



}
