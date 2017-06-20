package Controller;

import Model.CalculatorBase;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Stack;

import static Controller.FunctionsAndOperators.*;

/**
 * Created by Asus on 09.06.2017.
 */

public class CalculatorController {
    CalculatorBase calculatorBase;

    public CalculatorController(CalculatorBase calculatorBase)
    {
        this.calculatorBase = calculatorBase;
    }


    public Stack<String> getStackFromStack()
    {
        return calculatorBase.getStackFromStack();
    }

    public Stack<String> getStackOperations()
    {
        return calculatorBase.getStackOperations();
    }

    public Stack<String> getStackRPN()
    {
        return calculatorBase.getStackRPN();
    }

    public Stack<String> getStackAnswer()
    {
        return calculatorBase.getStackAnswer();
    }

    public Stack<DefaultMutableTreeNode> getStackTree()
    {
        return calculatorBase.getStackTree();
    }


    public boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isFunction(String token) {
        for (String item : functions) {
            if (item.equals(token)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    public boolean isCloseBracket(String token) {
        return token.equals(")");
    }

    public boolean isOperator(String token) {
        return operators.contains(token);
    }
}
