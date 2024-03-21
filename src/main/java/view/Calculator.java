package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.Logic;
import model.Polynomial;

public class Calculator extends JFrame {
    private JTextField polinom1Field;
    private JTextField polinom2Field;
    private JTextField rezultatField;
    private final Logic calculatorLogic;
    //Cream butaone
    JButton additionButton = new JButton("Addition");
    JButton subtractionButton = new JButton("Subtraction");
    JButton multiplicationButton = new JButton("Multiplication");
    JButton divisionButton = new JButton("Division");
    JButton derivativeButton = new JButton("Derivation");
    JButton integrationButton = new JButton("Integration");

    Polynomial poly1 = new Polynomial();
    Polynomial poly2 = new Polynomial();
    Polynomial rezPoly = new Polynomial();
    String rez = null;

    public Calculator() {
        setTitle("Calculator Polinoame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calculatorLogic = new Logic();
        initComponents();
    }
    //Initiem si plasam componentele GUI
   private void initComponents() {
        polinom1Field = new JTextField(20);
        polinom2Field = new JTextField(20);
        rezultatField = new JTextField(20);
        rezultatField.setEditable(false);

       additionButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        class ListenAddition implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {

                poly1.text = polinom1Field.getText();
                poly2.text = polinom2Field.getText();

                Pattern pattern = Pattern.compile("(-?\\d+)[x]\\^(-?\\d+)");

                Matcher matcher = pattern.matcher(poly1.text);
                while (matcher.find()) {
                    poly1.addTerm(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                }

                Matcher matcher1 = pattern.matcher(poly2.text);
                while (matcher1.find()) {
                    poly2.addTerm(Integer.parseInt(matcher1.group(1)), Integer.parseInt(matcher1.group(2)));
                }

                rezPoly = calculatorLogic.additionPolynomial(poly1, poly2);
                rez = rezPoly.toString();
                rezultatField.setText(rez);

                rez = null;
                rezPoly.freeP();
                poly1.freeP();
                poly2.freeP();
            }
        }

        subtractionButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        class ListenSubtraction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                poly1.text = polinom1Field.getText();
                poly2.text = polinom2Field.getText();

                Pattern pattern = Pattern.compile("(-?\\d+)[x]\\^(-?\\d+)");

                Matcher matcher = pattern.matcher(poly1.text);
                while (matcher.find()) {
                    poly1.addTerm(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                }

                Matcher matcher1 = pattern.matcher(poly2.text);
                while (matcher1.find()) {
                    poly2.addTerm(Integer.parseInt(matcher1.group(1)), Integer.parseInt(matcher1.group(2)));
                }

                rezPoly = calculatorLogic.subtractionPolynomial(poly1, poly2);
                rez = rezPoly.toString();
                rezultatField.setText(rez);

                rez = null;
                rezPoly.freeP();
                poly1.freeP();
                poly2.freeP();
            }
        }

        multiplicationButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        class ListenMultiplication implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

                poly1.text = polinom1Field.getText();
                poly2.text = polinom2Field.getText();

                Pattern pattern = Pattern.compile("(-?\\d+)[x]\\^(-?\\d+)");

                Matcher matcher = pattern.matcher(poly1.text);
                while (matcher.find()) {
                    poly1.addTerm(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                }

                Matcher matcher1 = pattern.matcher(poly2.text);
                while (matcher1.find()) {
                    poly2.addTerm(Integer.parseInt(matcher1.group(1)), Integer.parseInt(matcher1.group(2)));
                }

                rezPoly = calculatorLogic.multiplicationPolynomial(poly1, poly2);
                rez = rezPoly.toString();
                rezultatField.setText(rez);

                rez = null;
                rezPoly.freeP();
                poly1.freeP();
                poly2.freeP();
            }
        }

        divisionButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        class ListenDivision implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }

        derivativeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        class ListenDerivative implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                poly1.text = polinom1Field.getText();

                Pattern pattern = Pattern.compile("(-?\\d+)[x]\\^(-?\\d+)");

                Matcher matcher = pattern.matcher(poly1.text);
                while (matcher.find()) {
                    poly1.addTerm(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                }

                rezPoly = calculatorLogic.derivativePolynomial(poly1);
                rez = rezPoly.toString();
                rezultatField.setText(rez);

                rez = null;
                rezPoly.freeP();
                poly1.freeP();
            }
        }

        integrationButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        class ListenIntegration implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                poly1.text = polinom1Field.getText();

                Pattern pattern = Pattern.compile("(-?\\d+)[x]\\^(-?\\d+)");

                Matcher matcher = pattern.matcher(poly1.text);
                while (matcher.find()) {
                    poly1.addTerm(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                }

                rezPoly = calculatorLogic.integrationPolynomial(poly1);
                rez = rezPoly.toString();
                rezultatField.setText(rez);

                rez = null;
                rezPoly.freeP();
                poly1.freeP();
            }
        }

        JLabel polinom1Label = new JLabel("Polynomial 1:");
        polinom1Label.setHorizontalAlignment(SwingConstants.CENTER);
        polinom1Label.setFont(polinom1Label.getFont().deriveFont(Font.BOLD));
        polinom1Field.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel polinom2Label = new JLabel("Polynomial 2:");
        polinom2Label.setHorizontalAlignment(SwingConstants.CENTER);
        polinom2Label.setFont(polinom1Label.getFont().deriveFont(Font.BOLD));
        polinom2Field.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel rezultatLabel = new JLabel("Result:");
        rezultatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rezultatLabel.setFont(polinom1Label.getFont().deriveFont(Font.BOLD));
        rezultatField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel panel = new JPanel(new GridLayout(6, 3, 5, 5));
        panel.add(polinom1Label);
        panel.add(polinom1Field);
        panel.add(polinom2Label);
        panel.add(polinom2Field);
        panel.add(rezultatLabel);
        panel.add(rezultatField);
        panel.add(additionButton);
        panel.add(subtractionButton);
        panel.add(multiplicationButton);
        panel.add(divisionButton);
        panel.add(derivativeButton);
        panel.add(integrationButton);

        this.ListenAdd(new ListenAddition());
        this.ListenSub(new ListenSubtraction());
        this.ListenMul(new ListenMultiplication());
        this.ListenDiv(new ListenDivision());
        this.ListenDer(new ListenDerivative());
        this.ListenInte(new ListenIntegration());

        getContentPane().add(panel);
    }

    void ListenAdd(ActionListener ListenButon) {
        additionButton.addActionListener(ListenButon);
    }
    void ListenSub(ActionListener ListenButon) {
        subtractionButton.addActionListener(ListenButon);
    }
    void ListenMul(ActionListener ListenButon) {
        multiplicationButton.addActionListener(ListenButon);
    }
    void ListenDiv(ActionListener ListenButon) {
        divisionButton.addActionListener(ListenButon);
    }
    void ListenDer(ActionListener ListenButon) {
        derivativeButton.addActionListener(ListenButon);
    }
    void ListenInte(ActionListener ListenButon) {
        integrationButton.addActionListener(ListenButon);
    }
}
