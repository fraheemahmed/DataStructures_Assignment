package Stack;
import java.util.*;

public class stackUndoRedo {
    static Stack<String> stack1 = new Stack<>();
    static Stack<String> stack2 = new Stack<>();

    public void add(String ch) {
        stack1.push(ch);
    }

    public void delete() {
        stack2.push(stack1.pop());
    }

    public String undo() {
        if (stack1.isEmpty()) {
            return "No action to undo";
        }
        String lastAction = stack1.pop();
        stack2.push(lastAction);
        return "undo " + lastAction;
    }

    public String redo() {
        if (stack2.isEmpty()) {
            return "No action to redo";
        }
        String lastRemoveAction = stack2.pop();
        stack1.push(lastRemoveAction);
        return "redo " + lastRemoveAction;
    }


    public static void main(String[] args) {
        stackUndoRedo q = new stackUndoRedo();
        q.add("agy");
        q.add("jgr");
        q.add("rf");

        System.out.println(q.undo());
        System.out.println(q.redo());
        System.out.println(q.undo());
        System.out.println(q.undo());


    }
}

