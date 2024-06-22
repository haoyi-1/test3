import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manaddstu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manaddstu frame = new Manaddstu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manaddstu() {
		setTitle("\u5B66\u751F\u5F55\u5165");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 580);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 20));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JComboBox comboBox = new JComboBox();
		String kemu[] = { "男", "女" };
		for (int i = 0; i < 2; i++) {
			comboBox.addItem(kemu[i]);
		}

		JLabel label_3 = new JLabel("\u4E13\u4E1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel label_4 = new JLabel("\u9662\u7CFB");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JButton button = new JButton("\u5F55\u5165");
		button.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String s = textField.getText();
					int l = Integer.parseInt(s);
					String l1 = textField_1.getText();
					String l2 = textField_2.getText();
					String l3 = textField_3.getText();
					String l5 = comboBox.getSelectedItem().toString();
					o1.init();
					if (!(textField.getText().matches("\\d{9}"))) {
						Component pan = null;
						JOptionPane.showMessageDialog(pan, "学号必须为九位数字！");
					} else {
						o1.insert("insert into Student values('" + l + "','" + l1 + "','" + l5 + "','" + l3 + "','" + l2 + "','" + l + "')");
					}
					o1.close();
					 setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					// jdbchelper.close();
				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup().addGap(92).addGroup(gl_contentPane
										.createParallelGroup(
												Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addGap(217)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(4)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_3,
																				GroupLayout.PREFERRED_SIZE, 40,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(button_1)))
														.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE))
												.addGap(36)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 62,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(button)
																.addComponent(textField, GroupLayout.PREFERRED_SIZE,
																		132, GroupLayout.PREFERRED_SIZE)
																.addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
																		132, GroupLayout.PREFERRED_SIZE)))))
								.addGap(8)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE))
								.addGap(86)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(109)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(67)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(57).addComponent(comboBox,
								GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
				.addGap(65)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(button).addComponent(button_1))
				.addGap(84)));
		contentPane.setLayout(gl_contentPane);
	}

}
