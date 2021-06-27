import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class panel1 extends JPanel implements ActionListener {

    private JTextField t1,t2,result; // objectvariable to three textfields
    private JComboBox regneart; // dropdown list
    private JLabel lighedstegn; // label for equal sign
    private JButton beregn; // button to calculate
    private JButton clear; // button to reset
    private JTextArea info; // text area to show information
    

    // constructor
    public panel1() {
        setLayout(new FlowLayout()); // layout manager, flowlayout is default
        t1 = new JTextField(); // textfield for number 1
        t1.setColumns(10); // size of text field
        this.add(t1); // adds t1 to the panel

        regneart = new JComboBox(); // creates a dropdownmenu
        regneart.addItem(" + ");
        regneart.addItem(" - ");
        regneart.addItem(" * ");
        regneart.addItem(" / ");
        this.add(regneart);

        t2 = new JTextField(); // text field for second number
        t2.setColumns(10);
        this.add(t2); 

        lighedstegn = new JLabel(" = ");
        this.add(lighedstegn);

        result = new JTextField();
        result.setColumns(16);
        result.setEditable(false);
        this.add(result);

        beregn = new JButton("Calculate");
        beregn.addActionListener(this); // register listener to calculate button
        beregn.setName("Calculate"); // sets a name so you can recognize which button it is
        this.add(beregn);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setName("Clear");
        this.add(clear);

        info = new JTextArea();
        info.setName("Info");
        info.setText("Remember decimanl is . \ndot ");
        this.add(info);
    }

    // listener for panel1 makes an action when the button is activated
    public void actionPerformed(ActionEvent e) { // this NEEDS to be implemenbted when actionlistener is implemented

        JButton knap = (JButton)e.getSource(); // gets the source for the event (of the type JButton)
        String s = knap.getName();

        switch(s){
            case "Clear":
                t1.setText("");
                t2.setText("");
                result.setText("");
                info.setText("Rememver decimal is . \ndot ");
                break;
            case "Calculate":
                double number1 = 0, number2 = 0, resultat;
                try {
                    number1 = Double.parseDouble(t1.getText());
                    number2 = Double.parseDouble(t2.getText());
                    // checks which form of calculation needs to be done + - * or /

                    switch(regneart.getSelectedIndex()) {
                        case 0: // + is chosen
                            resultat = number1 + number2;
                            result.setText("" + resultat);
                            break;
                        case 1: // - is chosen
                            resultat = number1 - number2;
                            result.setText("" + resultat);
                            break;
                        case 2: // * is chosen
                            resultat = number1 * number2;
                            result.setText("" + resultat);
                            break;
                        case 3: // / is chosen
                            resultat = number1 / number2;
                            result.setText("" + resultat);
                            break;
                        default:
                    }

                } catch (Exception u) {
                    info.setText("Error in the input of number\nPress Clear");
                }
            default:
        }
    }
}
