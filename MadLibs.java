package gf;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MadLibs extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea;

	public MadLibs() {
		setTitle("Mad Libs - Wacky Paragraph Arranger");
		setSize(550, 370);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		textField = new JTextField(); // adjective
		textField.setBounds(164, 54, 101, 32);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // color
		textField_1.setBounds(404, 54, 101, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField(); // verb
		textField_2.setBounds(164, 104, 101, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField(); // noun
		textField_3.setBounds(404, 115, 101, 32);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel = new JLabel("Wacky Paragraph Arranger");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 11, 484, 21);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter an Adjective :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(21, 54, 133, 32);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Enter a Color :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(302, 53, 133, 32);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Enter a Verb :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(31, 103, 133, 32);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Enter a Noun :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(302, 103, 133, 32);
		getContentPane().add(lblNewLabel_1_3);

		JLabel lblPressHereTo = new JLabel("Press here to see your wacky arrangement!!");
		lblPressHereTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressHereTo.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPressHereTo.setBounds(31, 168, 484, 21);
		getContentPane().add(lblPressHereTo);

		textArea = new JTextArea();
		textArea.setBounds(31, 198, 476, 104);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		getContentPane().add(textArea);

		// ✅ Add a button for story generation
		JButton generateButton = new JButton("Generate Story");
		generateButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		generateButton.setBounds(190, 145, 160, 25);
		getContentPane().add(generateButton);

		// ✅ Button click logic
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adjective = textField.getText().trim();
				String color = textField_1.getText().trim();
				String verb = textField_2.getText().trim();
				String noun = textField_3.getText().trim();

				if (adjective.isEmpty() || color.isEmpty() || verb.isEmpty() || noun.isEmpty()) {
					textArea.setText("Please fill in all fields to generate your story!");
				} else {
					String story = "Today I saw a " + adjective + " animal with " + color + " spots. "
							+ "It " + verb + " over the fence and landed on a " + noun + ". "
							+ "It was a wild day at the zoo!";
					textArea.setText(story);
				}
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MadLibs frame = new MadLibs();
			frame.setVisible(true);
		});
	}
}
