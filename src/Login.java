import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int suser;
	private JTextField textField;
	private JLabel label_2;
	private JPasswordField passwordField;
   //170801201  170001
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 580);
		contentPane = new JPanel();

		Image image = new ImageIcon("E:\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setForeground(Color.BLUE);
		setTitle("学生课程管理系统-登录");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u8D26\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 22));

		textField = new JTextField();
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));

		label_2 = new JLabel("\u5B66\u751F\u8bfe\u7a0b\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setForeground(new Color(70, 130, 180));
		label_2.setFont(new Font("宋体", Font.PLAIN, 38));

		JButton button = new JButton("\u767B\u5F55");
		button.setFont(new Font("宋体", Font.PLAIN, 22));

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 22));
		JLabel label_3 = new JLabel("\u8EAB\u4EFD");
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));

		JComboBox comboBox = new JComboBox();
		String kemu[] = { "学生", "教师", "管理员" };
		for (int i = 0; i < 3; i++) {
			comboBox.addItem(kemu[i]);
		}

		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				connect i = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					i.init();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rSet = null;
				String password;
				String a;
				a = textField.getText();
				suser = Integer.parseInt(a);
				password = passwordField.getText();
				String l = comboBox.getSelectedItem().toString();
				if (l.equals("学生")) {
					rSet = i.query("select sno,spassword from student  where sno='" + suser + "' and spassword='"
							+ password + "' ");
					try {
						if (rSet.next()) {
							Student s = new Student();
							setVisible(false);
							s.setVisible(true);
							// this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "所输入账号或密码或身份错误！");
							JOptionPane.showMessageDialog(null, "请输入正确的9位学号或密码！");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// ====================================================
				if (l.equals("教师")) {
					rSet = i.query("select tno,tpassword from teacher  where tno='" + suser + "' and tpassword='"
							+ password + "' ");
					try {
						if (rSet.next()) {
							Teacher t = new Teacher();
							t.setVisible(true);
							setVisible(false);
							// this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "所输入账号或密码错误或身份不符！");
							JOptionPane.showMessageDialog(null, "请输入正确的6位工号或密码！");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// ==========================================================
				else if (l.equals("管理员")) {
					rSet = i.query("select id,password from id  where id='" + suser + "' and password='" + password + "' ");
					try {
						if (rSet.next()) {
							Manager m = new Manager();
							setVisible(false);
							m.setVisible(true);
							// this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "所输入账号或密码错误或身份错误不符！");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
														.createSequentialGroup().addContainerGap(232, Short.MAX_VALUE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(label)
																.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 44,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(label_3)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addGap(9).addComponent(button,
																				GroupLayout.PREFERRED_SIZE, 88,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addGap(8).addGroup(gl_contentPane
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(textField,
																						GroupLayout.DEFAULT_SIZE, 160,
																						Short.MAX_VALUE)
																				.addComponent(passwordField)
																				.addComponent(comboBox,
																						GroupLayout.PREFERRED_SIZE, 132,
																						GroupLayout.PREFERRED_SIZE)))
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addGap(129).addComponent(button_1,
																				GroupLayout.PREFERRED_SIZE, 89,
																				GroupLayout.PREFERRED_SIZE))))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(222)
														.addComponent(label_2)))
												.addContainerGap(205, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(64).addComponent(label_2).addGap(65)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(45)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addGap(56)));
		contentPane.setLayout(gl_contentPane);
	}
}
