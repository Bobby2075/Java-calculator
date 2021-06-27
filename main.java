import javax.swing.JFrame;

class Calculator {

    public static void main(String[] args) {
        JFrame vindue = new JFrame("Calculator");
        vindue.add(new panel1());
        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vindue.setSize(500, 200);
        vindue.setResizable(false);


        vindue.setVisible(true);
    }
}
