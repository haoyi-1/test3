import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JSeparator;

public class Manager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 580);
		setTitle("学生课程管理系统-管理员界面");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u4FE1\u606F\u7BA1\u7406");
		menu.setForeground(new Color(70, 130, 180));
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem);

		JSeparator separator = new JSeparator();
		menu.add(separator);

		JMenuItem menuItem_1 = new JMenuItem("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(menuItem_1);

		JMenu menu_2 = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		menu_2.setForeground(new Color(70, 130, 180));
		menu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_2);

		JMenuItem menuItem_2 = new JMenuItem("\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
		menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_2.add(menuItem_2);

		JSeparator separator_1 = new JSeparator();
		menu_2.add(separator_1);

		JMenuItem menuItem_3 = new JMenuItem("\u6388\u8BFE\u4FE1\u606F\u7BA1\u7406");
		menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_2.add(menuItem_3);

		JMenu menu_3 = new JMenu("\u5176\u4ED6");
		menu_3.setForeground(new Color(70, 130, 180));
		menu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_3);

		JMenuItem menuItem_4 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_3.add(menuItem_4);

		JMenu mnNewMenu = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		mnNewMenu.setForeground(new Color(70, 130, 180));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);

		JMenuItem menuItem_5 = new JMenuItem("\u9000\u51FA");
		menuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu.add(menuItem_5);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.PLAIN, 34));
		// ===============================================================================================
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mstu ms = new Mstu();
				ms.setVisible(true);
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mtea mt = new Mtea();
				mt.setVisible(true);
			}
		});
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mcou mc = new Mcou();
				mc.setVisible(true);
			}
		});
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mteach ms = new Mteach();
				ms.setVisible(true);
			}
		});
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerChangePwd mxg = new ManagerChangePwd();
				mxg.setVisible(true);
			}
		});
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(117)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(127, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(182)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(275, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
