import javax.swing.*;

public class EditPanel extends JPanel {
    private JTextField textField = new JTextField(20);
    private JButton saveBtn = new JButton("Save");

    public EditPanel() {
        add(textField);
        add(saveBtn);
    }
}
