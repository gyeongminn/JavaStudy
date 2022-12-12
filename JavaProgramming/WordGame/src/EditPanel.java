import javax.swing.*;
import java.awt.*;

public class EditPanel extends JPanel {
    
    private JTextField textField = new JTextField(20);
    private JButton saveBtn = new JButton("Save");

    public EditPanel() {
        setBackground(new Color(37, 37, 37));
        add(textField);
        add(saveBtn);
    }
}
