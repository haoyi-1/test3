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
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Stuchangepwd extends JFrame {

	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stuchangepwd frame = new Stuchangepwd();
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
	public Stuchangepwd() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 580);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\\\background.jpg").getImage();
		contentPane = new Beijing(image);
		setTitle("学生界面-修改密码");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label_1 = new JLabel("\u4FEE\u6539\u540E\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton button = new JButton("\u786E\u8BA4");
		button.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String c2 = textField_1.getText();
					int l1 = Integer.parseInt(c2);
					o1.init();
					ResultSet rset = o1.query("select * from student where sno='" + Login.suser + "'");
					if (rset.next()) {
						o1.update("update student set spassword='" + l1 + "' where  sno='" + Login.suser + "' ");
						JOptionPane.showMessageDialog(null, "修改成功！");
					}
					o1.close();
					// setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(236, Short.MAX_VALUE)
								.addComponent(button).addGap(54)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(183).addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE).addComponent(
										textField_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
				.addGap(207)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(179)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(85)));
		contentPane.setLayout(gl_contentPane);
	}

}
