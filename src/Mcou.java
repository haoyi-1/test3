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

public class Mcou extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mcou frame = new Mcou();
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
	public Mcou() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 780);
		setTitle("管理员界面-课程信息管理");
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u8BFE\u7A0B\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u540D");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JComboBox comboBox = new JComboBox();

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		String sex[] = { "男", "女" };

		JComboBox comboBox_2 = new JComboBox();
		String zc[] = { "2019-2020-1", "2019-2020-2" };
		for (int i = 0; i < 2; i++) {
			comboBox_2.addItem(zc[i]);
		}
		JLabel label_3 = new JLabel("\u5B66\u5E74");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label_4 = new JLabel("\u9662\u7CFB");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label_5 = new JLabel("\u5B66\u5206");
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));

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
		Table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "课程号", "课程名", "学分", "学年", "开课院系" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane.setViewportView(Table);
		// ===========================================================
		connect o = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S1[] = new String[23];
		try {

			o.init();
			ResultSet rs1 = o.query("select cno from course ");
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

		// ===========================================================
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manaddcourse mtluru = new Manaddcourse();
				mtluru.setVisible(true);
			}
		});
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String l4 = comboBox.getSelectedItem().toString();// 课程号
					o1.init();
					ResultSet rs3 = o.query("select cno from teach where cno='" + l4 + "' ");
					try {
						if (rs3.next()) {
							JOptionPane.showMessageDialog(null, "此课程已被选课！");
						} else {
							o1.delete("delete from course where cno= '" + l4 + "' ");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

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
					String l1 = textField_1.getText();// 院系
					String l2 = textField_2.getText(); // 课程名
					String l3 = textField_3.getText();// 学分
					String l4 = comboBox.getSelectedItem().toString();// 课程号
					String l = comboBox_2.getSelectedItem().toString();// 学年
					o1.init();
					o1.update("update course set cname= '" + l2 + "',credit= '" + l3 + "',year= '" + l + "' ,cdept= '"
							+ l1 + "'where cno= '" + l4 + "' ");
					JOptionPane.showMessageDialog(null, "修改成功！");
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
				String[] data = new String[5];
				int numT;
				DefaultTableModel model = (DefaultTableModel) Table.getModel();
				numT = model.getRowCount();// 获取当前已有行数
				while (numT > 0) {// 如果是全体刷新表格需要移除之前的所有数据行
					model.removeRow(0);
					numT--;
				}
				try {
					o1.init();
					ResultSet rset = o1.query("select *from course ");
					while (rset.next()) {
						data[0] = rset.getString(1);
						data[1] = rset.getString(2);
						data[2] = rset.getString(3);
						data[3] = rset.getString(4);
						data[4] = rset.getString(5);

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
			ResultSet rs5 = o.query("select cno from course ");
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(239)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
									.addGap(87))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(252)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(64)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(62)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(16)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
									.addComponent(button_4)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(button_4)))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
