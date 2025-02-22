package com.github.martapastuszka.tictactoe.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class GameFrame implements ActionListener {
    private JFrame frame;

    private JPanel boardPanel;

    private JButton button;

    private static Map<JButton, Boolean> buttonClickState = new HashMap<>();

    /*
    frameInitialize creates a window in which the game will take place
     */
    public void frameInitialize() {
        frame = new JFrame();

        ImageIcon titleIcon = new ImageIcon("C:\\Users\\eaarpms\\JavaProjects\\Java-TicTacToe\\tic-tac-toe.png");

        frame.setTitle("Tic-Tac-Toe");
        frame.setIconImage(titleIcon.getImage()); // Ustawienie ikony na oknie
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        initializeBoardPanel();
    }

    /*
    initialize BoardPanel creates the actual panel on which the game will take place
     */
    public void initializeBoardPanel() {
        boardPanel = new JPanel();
        boardPanel.setBackground(Color.DARK_GRAY);
//        boardPanel.setBounds(0,0,500, 500);
        boardPanel.setLayout(new GridLayout(3, 3));

        Font buttonFont;

        for (int i = 1; i < 10; i++) {
            button = new JButton(String.valueOf(i));
            buttonFont = new Font("Arial", Font.PLAIN, 20);
            button.setFont(buttonFont);
            button.setBackground(Color.GRAY);
            button.addActionListener(this);
            buttonClickState.put(button, false);
            boardPanel.add(button);
        }

        frame.add(boardPanel);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
//        System.out.println("Button " + sourceButton.getText() + " was clicked");
//        sourceButton.setText("2");

        circleCrossSwitch(e);

    }

    private boolean change = true;


    public void circleCrossSwitch(ActionEvent e) {
        if (!buttonClickState.get(button)) {
            if (change == true) {
                JButton button = (JButton) e.getSource();
                System.out.println("Button " + button.getText() + " was clicked");
                button.setText("O");
                buttonClickState.put(button, true);
                button.setEnabled(false);
                change = false;

            } else {
                JButton button = (JButton) e.getSource();
                System.out.println("Button " + button.getText() + " was clicked");
                button.setText("X");
                buttonClickState.put(button, true);
                button.setEnabled(false);
                change = true;
            }
        }
    }
}
