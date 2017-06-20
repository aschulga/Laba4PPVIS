package Model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Stack;

/**
 * Created by Asus on 09.06.2017.
 */
public class CalculatorBase {

    private Stack<String> stackOperations = new Stack<String>();
    private Stack<String> stackRPN = new Stack<String>();
    private Stack<String> stackAnswer = new Stack<String>();
    private Stack<DefaultMutableTreeNode> stackTree = new Stack<DefaultMutableTreeNode>();

    private Stack<String> stackFromStack = new Stack<String>();

    public Stack<String> getStackFromStack()
    {
        return stackFromStack;
    }

    public Stack<DefaultMutableTreeNode> getStackTree()
    {
        return stackTree;
    }

    public Stack<String> getStackOperations()
    {
        return stackOperations;
    }

    public Stack<String> getStackRPN()
    {
        return stackRPN;
    }

    public Stack<String> getStackAnswer()
    {
        return stackAnswer;
    }

}
