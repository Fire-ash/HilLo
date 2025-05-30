package gg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Payne's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payne's HiLo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 56, 244, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(264, 56, 57, 23);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnNewButton = new JButton("Guess!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(154, 124, 126, 34);
		getContentPane().add(btnNewButton);
		
		lblOutput = new JLabel("Enter your Guess above!!");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 204, 401, 23);
		getContentPane().add(lblOutput);
	}
	private static final long serialVersionUID = 1L;
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	
	public void checkGuess() {
	    try {
	        String guessText = txtGuess.getText();
	        int guess = Integer.parseInt(guessText);
	        String message = "";

	        if (guess < theNumber) {
	            message = guess + " is too low. Try again.";
	        } else if (guess > theNumber) {
	            message = guess + " is too high. Try again.";
	        } else {
	            message = guess + " is correct. You win! Let's play again!";
	            newGame();
	        }

	        lblOutput.setText(message);
	    } catch (NumberFormatException e) {
	        lblOutput.setText("Please enter a valid number between 1 and 100.");
	    }
	}

	public void newGame() {
        theNumber = (int)(Math.random() * 100 + 1);
        lblOutput.setText("Enter your Guess above!!");
        txtGuess.setText("");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 GuessingGame theGame = new GuessingGame();
		 theGame.newGame();
		 theGame.setSize(new Dimension(450,300));
		 theGame.setVisible(true);
	}
}

