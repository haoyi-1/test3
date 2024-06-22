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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Manaddteach extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manaddteach frame = new Manaddteach();
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
	public Manaddteach() {
		setTitle("\u6388\u8BFE\u5F55\u5165");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 580);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		JLabel label_3 = new JLabel("\u6559\u5E08\u53F7");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button = new JButton("\u5F55\u5165");
		button.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		// ===========================================================
		connect o = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S[] = new String[23];
		try {

			o.init();
			ResultSet rs = o.query("select cno from course ");
			int j = 0;
			while (rs.next()) {
				S[j] = rs.getString("cno");
				j++;

			}
			for (int i = 0; i < S.length; i++) {
				comboBox.addItem(S[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}
		connect o1 = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S1[] = new String[23];
		try {

			o1.init();
			ResultSet rs1 = o1.query("select tno from teacher ");
			int j = 0;
			while (rs1.next()) {
				S1[j] = rs1.getString("tno");
				j++;

			}
			for (int i = 0; i < S1.length; i++) {
				comboBox_1.addItem(S1[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}
		// ===========================================================
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String l = comboBox.getSelectedItem().toString();
					String l1 = comboBox_1.getSelectedItem().toString();
					o1.init();
					o1.insert("insert into teach values('" + l + "','" + l1 + "')");
					o1.close();
					// setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					// jdbchelper.close();
				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false).addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup().addGap(92).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(261).addComponent(button_1))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(135).addComponent(button))))
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addGap(171)
										.addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING, false).addComponent(
														label_3, Alignment.TRAILING,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(label_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(
												gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(48)
																.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE,
																		147, GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(226, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(136)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(57)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 155, Short.MAX_VALUE).addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(button).addComponent(button_1))
						.addGap(84)));
		contentPane.setLayout(gl_contentPane);
	}

}
