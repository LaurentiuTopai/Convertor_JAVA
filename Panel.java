import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Panel extends JPanel{
    JComboBox<String>my_box1;
    JComboBox<String>my_box2;
    JTextField box1;
    JTextField box2;
    JButton but1;
    public Panel()
    {
        my_box1 = new JComboBox<>(new String[]{"USD","EUR","RON"});
        my_box2 = new JComboBox<>(new String[]{"USD","EUR","RON"});
       box1=new JTextField(25);
       box2=new JTextField(25);
       but1=new JButton("Convert");

        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(4,2,10,10));
       this.add(my_box1);
       this.add(my_box2);
       this.add(box1);
       this.add(box2);
       this.add(but1);

        but1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    double value = Double.parseDouble(box1.getText());
                    String from=(String)my_box1.getSelectedItem();
                    String to=(String)my_box2.getSelectedItem();
                    value=Convert(value,from,to);
                    box2.setText(String.format("%.2f",value));
                }catch(NumberFormatException nfe){
                   box2.setText("Introdu o valoare buna");
                }
            }
        });

    }
    public double Convert(double value,String from,String to)
    {
        if(from.equals(to))
        {
            return value;
        }
        switch(from + "->"+to)
        {
            case "USD -> EUR":return 0.95*value;
            case "USD->RON":return 4.73*value;
            case "EUR -> RON":return 4.97*value;
            case "EUR -> USD":return 1.05*value;
            case "RON->USD":return value*0.21;
            case "RON->EUR":return value*0.20 ;
            default:return value;
        }
    }
}
