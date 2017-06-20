package Controller;

import javax.swing.tree.DefaultMutableTreeNode;
import java.text.ParseException;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

import static Controller.FunctionsAndOperators.operators;

/**
 * Created by Asus on 14.06.2017.
 */

public class Parser {

    public CalculatorController controller;

    public Parser(CalculatorController controller) {
        this.controller = controller;
    }

    private byte getPrecedence(String token) {
        if (token.equals("+") || token.equals("-")) {
            return 1;
        }
        return 2;
    }

    public void parse(String expression) throws ParseException {
        controller.getStackOperations().clear();
        controller.getStackRPN().clear();

        expression = expression.replace(" ", "").replace("(-", "(0-")
                .replace(",-", ",0-").replace("--","+").replace("-+","-").replace("+-","-");
        if (expression.charAt(0) == '-') {
            expression = "0" + expression;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(expression,
                operators + "()", true);

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (controller.isOpenBracket(token)) {
                controller.getStackOperations().push(token);
            } else if (controller.isCloseBracket(token)) {

                while (!controller.getStackOperations().empty()
                        && !controller.isOpenBracket(controller.getStackOperations().lastElement())) {
                    controller.getStackRPN().push(controller.getStackOperations().pop());

                }
                controller.getStackOperations().pop();

                if (!controller.getStackOperations().empty()
                        && controller.isFunction(controller.getStackOperations().lastElement())) {
                    controller.getStackRPN().push(controller.getStackOperations().pop());
                }
            } else if (controller.isNumber(token)) {
                controller.getStackRPN().push(token);

            } else if (controller.isOperator(token)) {

                while (!controller.getStackOperations().empty()
                        && controller.isOperator(controller.getStackOperations().lastElement())
                        && getPrecedence(token) <= getPrecedence(controller.getStackOperations().lastElement())) {
                    controller.getStackRPN().push(controller.getStackOperations().pop());
                }

                controller.getStackOperations().push(token);
            } else if (controller.isFunction(token)) {
                controller.getStackOperations().push(token);
            }
        }
        while (!controller.getStackOperations().empty()) {
            controller.getStackRPN().push(controller.getStackOperations().pop());
        }

        Collections.reverse(controller.getStackRPN());
    }


    public void newComputation(Stack<String> stack) {

        while (!stack.empty()) {
            if (controller.isNumber(stack.lastElement())) {

                DefaultMutableTreeNode node = new DefaultMutableTreeNode(stack.lastElement());
                controller.getStackTree().push(node);

                controller.getStackAnswer().push(stack.pop());

            } else if (controller.isOperator(stack.lastElement())) {
                String operation = stack.lastElement();

                DefaultMutableTreeNode node1 = controller.getStackTree().pop();
                double one = Double.parseDouble(controller.getStackAnswer().pop());


                DefaultMutableTreeNode node2 = controller.getStackTree().pop();
                double two = Double.parseDouble(controller.getStackAnswer().pop());


                switch (operation) {
                    case "+": {
                        controller.getStackAnswer().push(String.valueOf(two + one));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("+");
                        node.add(node2);
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }
                    case "-": {
                        controller.getStackAnswer().push(String.valueOf(two - one));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("-");
                        node.add(node2);
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }
                    case "*": {
                        controller.getStackAnswer().push(String.valueOf(two * one));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("*");
                        node.add(node2);
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }
                    case "/": {
                        controller.getStackAnswer().push(String.valueOf(two / one));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("/");
                        node.add(node2);
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }
                }
                controller.getStackRPN().pop();
            } else if (controller.isFunction(stack.lastElement())) {
                String operation = stack.lastElement();

                DefaultMutableTreeNode node1 = controller.getStackTree().pop();

                double one = Double.parseDouble(controller.getStackAnswer().pop());

                switch (operation) {
                    case "sqrt": {
                        controller.getStackAnswer().push(String.valueOf(Math.sqrt(one)));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("sqrt");
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }

                    case "sin": {
                        controller.getStackAnswer().push(String.valueOf(Math.sin(one)));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("sin");
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }

                    case "cos": {
                        controller.getStackAnswer().push(String.valueOf(Math.cos(one)));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("cos");
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }

                    case "tg": {
                        controller.getStackAnswer().push(String.valueOf(Math.tan(one)));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("tg");
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }

                    case "ctg": {
                        controller.getStackAnswer().push(String.valueOf(Math.tanh(one)));
                        DefaultMutableTreeNode node = new DefaultMutableTreeNode("ctg");
                        node.add(node1);
                        controller.getStackTree().push(node);
                        break;
                    }
                }
                stack.pop();
            }
        }
    }

    public Stack<String> newStack(String str) throws ParseException {

        parse(str);

        Stack<String> stack = new Stack<String>();

        while (!controller.getStackRPN().lastElement().isEmpty()) {
            if (controller.isNumber(controller.getStackRPN().lastElement())) {
                stack.push(controller.getStackRPN().pop());
            } else if (controller.isOperator(controller.getStackRPN().lastElement())) {
                String operation = controller.getStackRPN().pop();

                double one = Double.parseDouble(stack.pop());

                double two = Double.parseDouble(stack.pop());

                switch (operation) {
                    case "+": {
                        stack.push(String.valueOf(two + one));
                        break;
                    }

                    case "-": {
                        stack.push(String.valueOf(two - one));
                        break;
                    }

                    case "*": {
                        stack.push(String.valueOf(two * one));
                        break;
                    }

                    case "/": {
                        stack.push(String.valueOf(two / one));
                        break;
                    }
                }
                while (!stack.isEmpty())
                    controller.getStackRPN().push(stack.pop());
                break;
            } else if (controller.isFunction(controller.getStackRPN().lastElement())) {
                String operation = controller.getStackRPN().pop();

                double one = Double.parseDouble(stack.pop());

                switch (operation) {
                    case "sqrt": {
                        stack.push(String.valueOf(Math.sqrt(one)));
                        break;
                    }

                    case "sin": {
                        stack.push(String.valueOf(Math.sin(one)));
                        break;
                    }

                    case "cos": {
                        stack.push(String.valueOf(Math.cos(one)));
                        break;
                    }

                    case "tg": {
                        stack.push(String.valueOf(Math.tan(one)));
                        break;
                    }

                    case "ctg": {
                        stack.push(String.valueOf(Math.tanh(one)));
                        break;
                    }

                }
                while (!stack.isEmpty())
                    controller.getStackRPN().push(stack.pop());
                break;
            }
        }
        return controller.getStackRPN();
    }

    public String newString(Stack<String> stackRPN) {
        String string = "";

        Stack<String> newStack = new Stack<String>();

        while(!stackRPN.isEmpty())
        {
            if(controller.isOperator(stackRPN.lastElement()))
            {
                String operator = stackRPN.lastElement();

                String b = newStack.pop();
                String a = newStack.pop();

                newStack.push("("+ a + operator +b + ")");
            }
            else if(controller.isFunction(stackRPN.lastElement()))
            {
                String operator = stackRPN.lastElement();

                String a = newStack.pop();

                //newStack.push(  "(" + operator + "(" + a + ")" + ")");

                newStack.push("("+operator + "(" + a + ")"+ ")");
            }

            else {
                newStack.push(stackRPN.lastElement());
            }
            stackRPN.pop();
        }


        for(int i = 0; i < newStack.size(); i++)
        {
            string+=newStack.get(i);
        }


        return string;
    }

}
