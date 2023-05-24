package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.apache.groovy.json.internal.Chr.add;
import static org.apache.groovy.json.internal.Chr.contains;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberOfButton = new JButton[10];
    JButton[] fuctionOfButon = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton , negButton;
    JPanel panel;

    Font myfont = new Font("Ink free", Font.BOLD, 30);

    Double num1 = 0.0, num2 = 0.0, result = 0.0;
    String operator;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myfont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        fuctionOfButon[0] = addButton;
        fuctionOfButon[1] = subButton;
        fuctionOfButon[2] = mulButton;
        fuctionOfButon[3] = divButton;
        fuctionOfButon[4] = decButton;
        fuctionOfButon[5] = equButton;
        fuctionOfButon[6] = delButton;
        fuctionOfButon[7] = clrButton;
        fuctionOfButon[8] = negButton;

        for (int i = 0; i < 9; i++) {
            fuctionOfButon[i].addActionListener(this);
            fuctionOfButon[i].setFont(myfont);
            fuctionOfButon[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberOfButton[i] = new JButton(String.valueOf(i));
            numberOfButton[i].addActionListener(this);
            numberOfButton[i].setFont(myfont);
            numberOfButton[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberOfButton[1]);
        panel.add(numberOfButton[2]);
        panel.add(numberOfButton[3]);
        panel.add(addButton);
        panel.add(numberOfButton[4]);
        panel.add(numberOfButton[5]);
        panel.add(numberOfButton[6]);
        panel.add(subButton);
        panel.add(numberOfButton[7]);
        panel.add(numberOfButton[8]);
        panel.add(numberOfButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(delButton);
        panel.add(numberOfButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);


    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberOfButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case "+":
                result = num1 + num2;
                break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));

            }
    }
}
