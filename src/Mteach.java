import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Mteach extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mteach frame = new Mteach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String[] getModel(int start, int end) {
		String[] m = new String[end - start + 1];
		for (int i = 0; i < m.length; i++) {
			m[i] = String.valueOf(i + start);
		}
		return m;
	}

	/**
	 * Create the frame.
	 */
	public Mteach() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 780);
		setTitle("管理员界面-授课信息管理");
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u8BFE\u7A0B\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label_1 = new JLabel("\u6559\u5E08\u5DE5\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		JButton button = new JButton("\u5F55\u5165");
		button.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_2 = new JButton("\u4FEE\u6539");
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_3 = new JButton("\u67E5\u8BE2");
		button_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		JTable Table = new JTable();
		Table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, { null, null, null }, },
						new String[] { "教师工号", "课程号", "课程名" }));
		scrollPane.setViewportView(Table);
		// ===========================================================
		connect o = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S1[] = new String[23];
		try {

			o.init();
			ResultSet rs1 = o.query("select distinct cno from course ");
			int j = 0;
			while (rs1.next()) {
				S1[j] = rs1.getString("cno");
				j++;

			}
			for (int i = 0; i < S1.length; i++) {
				comboBox.addItem(S1[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}
		connect o2 = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S2[] = new String[23];
		try {

			o.init();
			ResultSet rs2 = o.query("select distinct tno from teacher ");
			int j = 0;
			while (rs2.next()) {
				S2[j] = rs2.getString("tno");
				j++;

			}
			for (int i = 0; i < S1.length; i++) {
				comboBox_1.addItem(S2[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}
		// ===========================================================
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manaddteach msluru = new Manaddteach();
				msluru.setVisible(true);
			}
		});
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String l4 = comboBox.getSelectedItem().toString();// 课程号
					String l3 = comboBox_1.getSelectedItem().toString();
					o1.init();
					o1.delete("delete from teach where cno= '" + l4 + "'and tno='" + l3 + "'");

				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					// jdbchelper.close();
				}
			}

		});
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String l = comboBox.getSelectedItem().toString();// 课程号
					String l1 = comboBox_1.getSelectedItem().toString();
					o1.init();
					o1.update("update teach set tno= '" + l1 + "' where cno= '" + l + "' ");
					JOptionPane.showMessageDialog(null, "修改成功！");
					o1.update("update Grade set tno= '" + l1 + "' where cno= '" + l + "' ");
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					// jdbchelper.close();
				}
			}

		});
		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				String[] data = new String[3];
				int numT;
				DefaultTableModel model = (DefaultTableModel) Table.getModel();
				numT = model.getRowCount();// 获取当前已有行数
				while (numT > 0) {// 如果是全体刷新表格需要移除之前的所有数据行
					model.removeRow(0);
					numT--;
				}
				try {
					o1.init();
					ResultSet rset = o1.query("select tno,teach.cno,cname from teach,course where course.cno=teach.cno");
					while (rset.next()) {
						data[0] = rset.getString(1);
						data[1] = rset.getString(2);
						data[2] = rset.getString(3);
						model.addRow(data);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					// jdbchelper.close();
				}
				Table.setModel(model);
			}

		});
		
		JButton button_4 = new JButton("\u5237\u65B0");
		button_4.setFont(new Font("宋体", Font.PLAIN, 20));
		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				connect o = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				String S5[] = new String[23];
				try {
					comboBox.removeAllItems();

					o.init();
					ResultSet rs5 = o.query("select distinct cno from teach ");
					int j = 0;
					while (rs5.next()) {
						S5[j] = rs5.getString("cno");
						j++;

					}
					for (int i = 0; i < S5.length; i++) {
						comboBox.addItem(S5[i]);
					}

				} catch (Exception e1) {

					e1.printStackTrace();

				}
				//=========================================
				String S6[] = new String[23];
				try {
					comboBox_1.removeAllItems();

					o.init();
					ResultSet rs6 = o.query("select distinct tno from teach ");
					int s = 0;
					while (rs6.next()) {
						S6[s] = rs6.getString("tno");
						s++;

					}
					for (int x = 0; x < S6.length; x++) {
						comboBox_1.addItem(S6[x]);
					}

				} catch (Exception e1) {

					e1.printStackTrace();

				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(252)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_4)
								.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(338)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(0, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_4)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
