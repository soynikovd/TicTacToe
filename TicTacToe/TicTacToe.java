package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    Boolean playerOneTurn;

    public TicTacToe() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
        firstTurn();
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2) == 0) {
            playerOneTurn = true;
            textField.setText("X turn");
        } else {
            playerOneTurn = false;
            textField.setText("0 turn");
        }

    }

    public void checked() {
        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }

        if ((buttons[0].getText().equals("0")) && (buttons[1].getText().equals("0") && (buttons[2].getText().equals("0")))) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("0")) && (buttons[4].getText().equals("0") && (buttons[5].getText().equals("0")))) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("0")) && (buttons[7].getText().equals("0") && (buttons[8].getText().equals("0")))) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("0")) && (buttons[3].getText().equals("0") && (buttons[6].getText().equals("0")))) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("0")) && (buttons[4].getText().equals("0") && (buttons[7].getText().equals("0")))) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("0")) && (buttons[5].getText().equals("0") && (buttons[8].getText().equals("0")))) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("0")) && (buttons[4].getText().equals("0") && (buttons[8].getText().equals("0")))) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("0")) && (buttons[4].getText().equals("0") && (buttons[6].getText().equals("0")))) {
            oWins(2, 4, 6);
        }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            if (i != a && i != b && i != c) {
                buttons[i].setEnabled(false);
            }
        }
        textField.setText("Player X wins!");
    }
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            if (i != a && i != b && i != c) {
                buttons[i].setEnabled(false);
            }
        }
        textField.setText("Player O wins!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == buttons [i]) {
                if (playerOneTurn) {
                    if(buttons[i].getText() == ""){
                        buttons [i].setForeground(new Color(255, 0, 0));
                        buttons [i].setText("X");
                        playerOneTurn = false;
                        textField.setText("0 turn");
                        checked();
                    }
                }
                else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("0");
                        playerOneTurn = true;
                        textField.setText("X turn");
                        checked();
                    }
                }
            }
        }

    }
}
