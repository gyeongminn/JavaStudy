package app;

import words.WordList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditPanel extends JPanel {

    private WordList wordList;
    private JTextField textField;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton saveBtn = new JButton("Save");

    public EditPanel(WordList wordList) {
        this.wordList = wordList;
        initEditPanel();
    }

    private void initEditPanel() {
        setLayout(null);
        setBackground(new Color(37, 37, 37));

        textField = new JTextField(20);
        textField.setBackground(new Color(30, 30, 30));
        textField.setBorder(new LineBorder(new Color(71, 71, 71)));
        textField.setBounds(10, 500, 150, 20);
        textField.setForeground(Color.WHITE);
        add(textField);

        textArea = new JTextArea();
        textArea.setBackground(new Color(37, 37, 37));
        textArea.setForeground(Color.WHITE);
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        for (String word : wordList.getAllWords()) {
            textArea.append(word + "\n");
        }
        scrollPane.setBounds(10, 50, 230, 400);
        add(scrollPane);

        saveBtn.setForeground(Color.WHITE);
        saveBtn.setBackground(new Color(71, 71, 71));
        saveBtn.setBorder(BorderFactory.createEmptyBorder());
        saveBtn.setBounds(170, 500, 70, 20);
        add(saveBtn);

        saveBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                    String word = textField.getText().trim();
                    textArea.append(word + "\n");
                    wordList.addWord(word);
                    textField.setText("");
            }
        });
    }
}
