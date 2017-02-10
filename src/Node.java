/**
 * Created by thorminator on 2017-02-09.
 */
public class Node {
    Node right;
    Node left;
    Node top;
    Node down;
    boolean empty;
    public Node(char charempty){
        if(charempty == '1'){
            empty = false;
        }
        else{
            if(charempty == '2'){
                empty = true;
            }
        }
    }

    public Node get(Direction d){
        Node node;
        switch(d){
            case top:
                node = top;
                break;
            case down:
                node = down;
                break;
            case left:
                node = left;
                break;
            case right:
                node = right;
                break;
            default:
                node = null;
                break;
        }
        return node;
    }

    public boolean isEmpty(){
        return empty;
    }
}

