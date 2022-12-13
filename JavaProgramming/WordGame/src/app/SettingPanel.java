package app;

import words.WordList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingPanel extends JPanel {

    private GamePanel gamePanel;
    private WordList wordList;

    public SettingPanel(GamePanel gamePanel, WordList wordList) {
        this.wordList = wordList;
        this.gamePanel = gamePanel;
        setLayout(null); // 레이아웃 초기화
        setBackground(new Color(37, 37, 37)); // 배경 색 설정
        initLanguageSetting(); // 단어 설정 초기화
        initLevelSetting(); // 레벨 설정 초기화
    }

    private void initLanguageSetting() {
        // 라벨 추가
        JLabel titleLabel = new JLabel("Select Language");
        titleLabel.setForeground(Color.WHITE); // 글자 색 설정
        titleLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        titleLabel.setBounds(20, 20, 200, 24);
        add(titleLabel);

        ButtonGroup group = new ButtonGroup(); // 버튼 그룹 설정

        JRadioButton clang = new JRadioButton("C/C++"); // C언어 선택 버튼
        initRadioButton(group, clang); // 라디오 버튼 초기화
        clang.setBounds(20, 50, 100, 30);
        clang.setSelected(true); // 선택 초기값으로 설정
        clang.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                    wordList.loadWordFile("clang.txt"); // 단어 파일 불러오기
            }
        });

        JRadioButton java = new JRadioButton("Java"); // JAVA 선택 버튼
        initRadioButton(group, java);
        java.setBounds(20, 80, 100, 30);
        java.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                wordList.loadWordFile("java.txt"); // 단어 파일 불러오기
            }
        });

        JRadioButton python = new JRadioButton("Python"); // Python 선택 버튼
        initRadioButton(group, python);
        python.setBounds(20, 110, 100, 30);
        python.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                wordList.loadWordFile("python.txt"); // 단어 파일 불러오기
            }
        });
    }

    private void initLevelSetting() {
        // 라벨 추가
        JLabel titleLabel = new JLabel("Select Level");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        titleLabel.setBounds(20, 170, 200, 24);
        add(titleLabel);

        ButtonGroup group = new ButtonGroup();

        JRadioButton lv1 = new JRadioButton("Level 1");
        lv1.setBounds(20, 200, 100, 30);
        lv1.setSelected(true); // 선택 초기값으로 설정
        initRadioButton(group, lv1);
        lv1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                gamePanel.setDivDelay(5); // 레벨 1 설정
            }
        });

        JRadioButton lv2 = new JRadioButton("Level 2");
        lv2.setBounds(20, 230, 100, 30);
        initRadioButton(group, lv2);
        lv2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                gamePanel.setDivDelay(3.5); // 레벨 2 설정
            }
        });

        JRadioButton lv3 = new JRadioButton("Level 3");
        lv3.setBounds(20, 260, 100, 30);
        initRadioButton(group, lv3);
        lv3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                gamePanel.setDivDelay(1); // 레벨 3 설정
            }
        });
    }

    private void initRadioButton(ButtonGroup group, JRadioButton radioButton) {
        radioButton.setForeground(Color.WHITE); // 글자 색 설정
        radioButton.setFont(new Font("consolas", Font.PLAIN, 16)); // 폰트 설정
        group.add(radioButton); // 그룹에 라디오버튼 추가
        add(radioButton); // 패널에 라디오버튼 추가
    }
}
