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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class TeacherGrade extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JLabel label_4;
	private JTextField textField_4;
	private JButton button_2;
	private JButton button_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherGrade frame = new TeacherGrade();
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
	public TeacherGrade() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 780);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("教师界面-成绩管理");
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 18));

		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));

		JLabel label_3 = new JLabel("\u5E73\u65F6\u6210\u7EE9");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		label_4 = new JLabel("\u8003\u8BD5\u6210\u7EE9");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JButton button = new JButton("\u5F55\u5165");
		button.setFont(new Font("宋体", Font.PLAIN, 20));

		button_2 = new JButton("\u4FEE\u6539");
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));

		button_3 = new JButton("\u67E5\u8BE2");
		button_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));

		final JComboBox comboBox = new JComboBox();
		final JComboBox comboBox_1 = new JComboBox();

		JScrollPane scrollPane = new JScrollPane();
		JTable Table = new JTable();
		Table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "学号", "姓名", "专业", "课程号", "课程名", "成绩" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane.setViewportView(Table);
		// ===========================================================
		connect o1 = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S1[] = new String[23];
		try {

			o1.init();
			ResultSet rs1 = o1.query("select distinct sno from Grade where tno='" + Login.suser + "'");
			int j = 0;
			while (rs1.next()) {
				S1[j] = rs1.getString("sno");
				j++;

			}
			for (int i = 0; i < S1.length; i++) {
				comboBox.addItem(S1[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}

		// ============================================================
		connect o2 = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S2[] = new String[23];
		try {

			o2.init();
			ResultSet rs2 = o2.query("select distinct cno from teach where  tno='" + Login.suser + "'");
			int j = 0;
			while (rs2.next()) {
				S2[j] = rs2.getString("cno");
				j++;

			}
			for (int i = 0; i < S2.length; i++) {
				comboBox_1.addItem(S2[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}
		// ========================================================================
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String  r3 = textField_3.getText();
					int l3 = Integer.parseInt(r3);
					String r4 = textField_4.getText();
					int l4 = Integer.parseInt(r4);
					
					int finalgrade = (int) (l3 * 0.4 + l4 * 0.6);
					BigDecimal b = new BigDecimal(finalgrade);
					double f1 = b.setScale(0, RoundingMode.HALF_UP).doubleValue();

					String l = comboBox.getSelectedItem().toString();
					String l1 = comboBox_1.getSelectedItem().toString();
					o1.init();
					o1.update("update Grade set grade= '" + f1 + "' where sno='" + l + "' and cno='" + l1 + "'");
					JOptionPane.showMessageDialog(null, "录入成功！");
					o1.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					// jdbchelper.close();
				}
			}
		});
		// ==============================================================================
		button_2.addActionListener(new ActionListener() {

			private char[] finalgrade;

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String r3 = textField_3.getText();
					int l3 = Integer.parseInt(r3);
					String r4 = textField_4.getText();
					int l4 = Integer.parseInt(r4);
					double finalgrade = (double) (l3 * 0.4 + l4 * 0.6);
					BigDecimal b = new BigDecimal(finalgrade);
					double f1 = b.setScale(0, RoundingMode.HALF_UP).doubleValue();
					String l = comboBox.getSelectedItem().toString();
					String l1 = comboBox_1.getSelectedItem().toString();
					o1.init();
					o1.update("update Grade set grade= '" + f1 + "' where sno='" + l + "' and cno='" + l1 + "'");
					JOptionPane.showMessageDialog(null, "修改成功！");
					o1.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					// jdbchelper.close();
				}
			}
		});
		// ===========================================================
		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				String[] data = new String[6];
				int numT;
				DefaultTableModel model = (DefaultTableModel) Table.getModel();
				numT = model.getRowCount();// 获取当前已有行数
				while (numT > 0) {// 如果是全体刷新表格需要移除之前的所有数据行
					model.removeRow(0);
					numT--;
				}
				try {
					String l1 = comboBox_1.getSelectedItem().toString();
					o1.init();
					ResultSet rset = o1.query("select Grade.sno,student.sname,szhuanye,Grade.cno,course.cname,Grade.grade from course,Grade,teach,student  where Grade.sno=student.sno and Grade.cno=course.cno and teach.tno=Grade.tno and teach.cno=grade.cno  and teach.tno='"
									+ Login.suser + "'and teach.cno='" + l1 + "'");
					while (rset.next()) {
						data[0] = rset.getString(1).trim();
						data[1] = rset.getString(2).trim();
						data[2] = rset.getString(3).trim();
						data[3] = rset.getString(4).trim();
						data[4] = rset.getString(5).trim();
						data[5] = rset.getString(6);
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

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addContainerGap().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
										.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(label).addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(button, GroupLayout.PREFERRED_SIZE, 83,
																GroupLayout.PREFERRED_SIZE)
														.addGap(36))
												.addComponent(label_1).addComponent(label_3).addComponent(label_4))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(36)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE,
																		142, GroupLayout.PREFERRED_SIZE)
																.addComponent(textField_3, GroupLayout.DEFAULT_SIZE,
																		142, Short.MAX_VALUE)
																.addComponent(textField_4, GroupLayout.DEFAULT_SIZE,
																		142, Short.MAX_VALUE)))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(11)
														.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81,
																GroupLayout.PREFERRED_SIZE)
														.addGap(51)
														.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 82,
																GroupLayout.PREFERRED_SIZE)
														.addGap(47).addComponent(button_1, GroupLayout.PREFERRED_SIZE,
																82, GroupLayout.PREFERRED_SIZE)))
										.addGap(164))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
						comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(32)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(31).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(32, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
