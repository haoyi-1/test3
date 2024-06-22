import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class Student extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 580);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		setTitle("学生界面");

		JMenu menu = new JMenu("\u67E5\u8BE2\u4FE1\u606F");
		menu.setForeground(new Color(70, 130, 180));
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F");
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem);

		JSeparator separator = new JSeparator();
		menu.add(separator);

		JMenuItem menuItem_1 = new JMenuItem("\u8BFE\u7A0B\u6210\u7EE9");
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem_1);

		JMenu menu_1 = new JMenu("\u8BFE\u7A0B\u9009\u9000");
		menu_1.setForeground(new Color(70, 130, 180));
		menu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_1);

		JMenuItem menuItem_2 = new JMenuItem("\u9009\u8BFE");
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_1.add(menuItem_2);

		JSeparator separator_1 = new JSeparator();
		menu_1.add(separator_1);

		JMenuItem menuItem_3 = new JMenuItem("\u9000\u8BFE");
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_1.add(menuItem_3);

		JMenu menu_2 = new JMenu("\u5176\u4ED6");
		menu_2.setForeground(new Color(70, 130, 180));
		menu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_2);

		JMenuItem menuItem_4 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_2.add(menuItem_4);

		JMenu mnNewMenu = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		mnNewMenu.setForeground(new Color(70, 130, 180));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);

		JMenuItem menuItem_5 = new JMenuItem("\u9000\u51FA");
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu.add(menuItem_5);
		contentPane = new JPanel();

		Image image = new ImageIcon("E:\\background.jpg").getImage();
		contentPane = new Beijing(image);

		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Studentrefer stucx = new Studentrefer();
				stucx.setVisible(true);
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stucourse stuxkjg = new Stucourse();
				stuxkjg.setVisible(true);
			}
		});
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stuselectclass stuxk = new Stuselectclass();
				stuxk.setVisible(true);
			}
		});
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stuquitclass stutk = new Stuquitclass();
				stutk.setVisible(true);
			}
		});

		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stuchangepwd stuxg = new Stuchangepwd();
				stuxg.setVisible(true);
			}
		});
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});

		JLabel label = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.PLAIN, 34));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(124, Short.MAX_VALUE).addComponent(label).addGap(120)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(187).addComponent(label).addContainerGap(267, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
