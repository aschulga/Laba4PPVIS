package View;

import Controller.CalculatorController;
import Controller.Parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class MyFrame {

    private Dimension d;
    private String title;
    private CalculatorController calculatorController;


    private double answer = 0;

    private JFrame frame = new JFrame();

    JTree tree;

    JTextArea display = new JTextArea(1, 20);
    JScrollPane jsp = new JScrollPane(display);

    JLabel answerLabel = new JLabel("Ответ: " + answer);
    JTextField answerTextField = new JTextField(5);


    JPanel panelTree = new JPanel();

    JScrollPane jspTree = new JScrollPane(panelTree);

    public MyFrame(String title, Dimension d, CalculatorController calculatorController) {
        this.title = title;
        this.d = d;
        this.calculatorController = calculatorController;
    }

    public void init() {
        frame.setTitle(title);
        frame.setSize(d);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        display.setFont(new Font("Dialog",Font.BOLD,30));
        display.setTabSize(10);



        jspTree.setPreferredSize(new Dimension(100,200));

        frame.add(jspTree, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4, 8));

        JButton mencheButton = new JButton("<");
        JButton bolcheButton = new JButton(">");
        JButton back = new JButton("C");
        JButton skobka1Button = new JButton("(");
        JButton skobka2Button = new JButton(")");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        JButton sumButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton sqrtButton = new JButton("sqrt");
        JButton oneButton = new JButton("1/x");
        JButton prButton = new JButton("%");
        JButton tButton = new JButton(".");
        JButton startButton = new JButton("=");
        JButton tgButton = new JButton("tg");
        JButton ctgButton = new JButton("ctg");
        JButton sinButton = new JButton("sin");
        JButton cosButton = new JButton("cos");


        buttonPanel.add(mencheButton);
        buttonPanel.add(bolcheButton);
        buttonPanel.add(skobka1Button);
        buttonPanel.add(skobka2Button);
        buttonPanel.add(mulButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(sinButton);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button0);


        buttonPanel.add(sumButton);
        buttonPanel.add(subButton);
        buttonPanel.add(cosButton);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);



        buttonPanel.add(back);
        buttonPanel.add(sqrtButton);


        buttonPanel.add(tButton);
        buttonPanel.add(tgButton);
        buttonPanel.add(button7);

        buttonPanel.add(button8);
        buttonPanel.add(button9);

        buttonPanel.add(startButton);
        buttonPanel.add(prButton);
        buttonPanel.add(oneButton);

        buttonPanel.add(ctgButton);




        startButton.addActionListener(new startButtonActionListener());

        jsp.setSize(30, 20);
        frame.add(jsp, BorderLayout.NORTH);

        //frame.add(answerTextField,BorderLayout.AFTER_LAST_LINE);
        frame.add(buttonPanel, BorderLayout.CENTER);



        frame.add(answerLabel, BorderLayout.AFTER_LAST_LINE);

        frame.setVisible(true);
        frame.pack();

        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "1/(");
            }
        });

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "0");
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "2");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "3");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "4");
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "5");
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "6");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "7");
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "8");
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "9");
            }
        });

        tButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ".");
            }
        });

        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "+");
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "-");
            }
        });

        skobka1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "(");
            }
        });

        skobka2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ")");
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "*");
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "/");
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                calculatorController.getStackAnswer().clear();
                calculatorController.getStackRPN().clear();
                calculatorController.getStackFromStack().clear();
                calculatorController.getStackTree().clear();
            }
        });

        sqrtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "sqrt" + "(");
            }
        });

        tgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "tg" + "(");
            }
        });

        ctgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "ctg" + "(");
            }
        });

        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "sin" + "(");
            }
        });

        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "cos" + "(");
            }
        });

        bolcheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Parser parser = new Parser(calculatorController);

                if (!calculatorController.getStackFromStack().isEmpty()) {

                    try {
                        parser.parse(calculatorController.getStackFromStack().lastElement());
                        parser.newComputation(calculatorController.getStackRPN());
                        display.setText(calculatorController.getStackFromStack().pop());
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }

                    panelTree.removeAll();
                    tree = new JTree(calculatorController.getStackTree().lastElement());

                    for (int i = 0; i < tree.getRowCount(); i++)
                        tree.expandRow(i);

                    tree.setEditable(true);
                    panelTree.add(tree);
                    jspTree.updateUI();
                }
                else
                    display.setText(display.getText());
            }
        });

        mencheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Parser parser = new Parser(calculatorController);

                if (!display.getText().equals(calculatorController.getStackTree().lastElement().toString())) {

                    try {
                        calculatorController.getStackFromStack().push(display.getText());

                        //System.out.println(parser.newStack(display.getText()));

                        parser.newComputation(parser.newStack(display.getText()));



                        display.setText(parser.newString(parser.newStack(display.getText())));



                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }

                    panelTree.removeAll();
                    tree = new JTree(calculatorController.getStackTree().lastElement());

                    for (int i = 0; i < tree.getRowCount(); i++)
                        tree.expandRow(i);

                    tree.setEditable(true);
                    panelTree.add(tree);
                    jspTree.updateUI();
                }

                else
                    display.setText(calculatorController.getStackTree().lastElement().toString());
            }

        });

    }

    public class startButtonActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(!display.getText().isEmpty()) {
                Parser parser = new Parser(calculatorController);
                try {
                    calculatorController.getStackAnswer().clear();
                    parser.parse(display.getText());

                    parser.newComputation(calculatorController.getStackRPN());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                answerLabel.setText("Ответ: " + calculatorController.getStackAnswer().lastElement());

                panelTree.removeAll();

                tree = new JTree(calculatorController.getStackTree().lastElement());

                for(int i = 0; i < tree.getRowCount(); i ++)
                    tree.expandRow(i);

                panelTree.add(tree);
                jspTree.updateUI();


            }
            else answerLabel.setText("Ответ: " + String.valueOf(answer));
        }
    }






}


