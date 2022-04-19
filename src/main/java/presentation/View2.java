package presentation;

import dao.ClientDAO;
import dao.ProductDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View2 extends JFrame {
    private JLabel l4 = new JLabel("ID Produs:");
    private JLabel l5 = new JLabel("Nume produs:");
    private JLabel l6 = new JLabel("Cantitate:");
    private JLabel l7 = new JLabel("Pret:");

    private JTextField prID = new JTextField();
    private JTextField prNume = new JTextField();
    private JTextField cant = new JTextField();
    private JTextField pret = new JTextField();

    private JButton addPr = new JButton("Adauga");
    private JButton editPr = new JButton("Edit");
    private JButton delPr = new JButton("Sterge");
    private JButton showPr = new JButton("Vizualizare");

    JPanel p3 = new JPanel();

    public View2() {
        this.setTitle("Produs");

        ProductDAO pr = new ProductDAO();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);

        p1.add(l4);
        p1.add(prID);
        p1.add(l5);
        p1.add(prNume);
        p1.add(l6);
        p1.add(cant);
        p1.add(l7);
        p1.add(pret);

        JPanel p2 = new JPanel();
        //p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p2.add(addPr);
        p2.add(delPr);
        p2.add(editPr);
        p2.add(showPr);

         //panel pt butoane
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(p1);
        p3.add(p2);
        this.add(p3);


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNumePr(){
        return prNume.getText();
    }

    public int getPrID(){
        return Integer.parseInt(prID.getText());
    }

    public int getCantPr(){
        return Integer.parseInt(cant.getText());
    }

    public int getPret(){
        return Integer.parseInt(pret.getText());
    }

    public JPanel getP3(){
        return p3;
    }

    void addProdusListener(ActionListener list2) {
        addPr.addActionListener(list2);
    }
    void editPrListener(ActionListener list4) {
        editPr.addActionListener(list4);
    }
    void delPrListener(ActionListener list6) {
        delPr.addActionListener(list6);
    }
    void showPrListener(ActionListener list8) {
        showPr.addActionListener(list8);
    }

}
