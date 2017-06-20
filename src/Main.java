import Model.CalculatorBase;
import Controller.CalculatorController;
import View.MyFrame;

import java.awt.*;

/**
 * Created by Asus on 06.06.2017.
 */
public class Main {

    public static void main(String args[])
    {
        CalculatorBase calculatorBase = new CalculatorBase();
        CalculatorController calculatorController = new CalculatorController(calculatorBase);
        MyFrame frame = new MyFrame("Калькулятор",new Dimension(700,700),calculatorController);
        frame.init();
    }

}
