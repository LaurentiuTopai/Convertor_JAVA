import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        this.setTitle("Convertor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.add(new Panel());
        this.setVisible(true);
    }
}
