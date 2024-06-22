import java.awt.BorderLayout;
import java.awt.Canvas;
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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class Teacher extends JFrame {

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
					Teacher frame = new Teacher();
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
	public Teacher() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 580);
		setTitle("学生课程管理系统-教师界面");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u67E5\u8BE2\u4FE1\u606F");
		menu.setForeground(new Color(70, 130, 180));
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F");
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu.add(mntmNewMenuItem);

		JMenu menu_1 = new JMenu("\u6210\u7EE9\u7BA1\u7406");
		menu_1.setForeground(new Color(70, 130, 180));
		menu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6210\u7EE9\u7BA1\u7406");
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_1.add(mntmNewMenuItem_2);

		JSeparator separator = new JSeparator();
		menu_1.add(separator);

		JMenu menu_2 = new JMenu("\u5176\u4ED6");
		menu_2.setForeground(new Color(70, 130, 180));
		menu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_2);

		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_2.add(menuItem);

		JMenu menu_3 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		menu_3.setForeground(new Color(70, 130, 180));
		menu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		menuBar.add(menu_3);

		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menu_3.add(menuItem_1);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\background.jpg").getImage();
		contentPane = new Beijing(image);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// ===========================================================================
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacherrefer teacx = new Teacherrefer();
				teacx.setVisible(true);
			}
		});
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacherchangepwd teaxg = new Teacherchangepwd();
				teaxg.setVisible(true);
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherGrade gra = new TeacherGrade();
				gra.setVisible(true);
			}
		});
		// =======================================================================================================
		JLabel label = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.PLAIN, 34));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(125, Short.MAX_VALUE).addComponent(label).addGap(119)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(191).addComponent(label).addContainerGap(263, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
