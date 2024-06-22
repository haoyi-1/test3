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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;

public class Stuselectclass extends JFrame {

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
					Stuselectclass frame = new Stuselectclass();
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
	public Stuselectclass() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 780);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\background.jpg").getImage();
		contentPane = new Beijing(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("学生界面-选课");
		JLabel lblNewLabel = new JLabel("\u641C\u7D22\u67E5\u8BE2");
		lblNewLabel.setForeground(new Color(70, 130, 180));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label_1 = new JLabel("\u9662\u7CFB");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label_2 = new JLabel("\u5B66\u5E74");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button = new JButton("\u67E5\u8BE2");
		button.setFont(new Font("宋体", Font.PLAIN, 20));

		JScrollPane scrollPane = new JScrollPane();
		JTable Table = new JTable();
		Table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null } },
				new String[] { "课程号", "课程名", "学分", "学年", "所属院系", "教师工号", "教师姓名" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane.setViewportView(Table);
		JComboBox comboBox = new JComboBox();

		JComboBox comboBox_1 = new JComboBox();
		JComboBox comboBox_2 = new JComboBox();
		JComboBox comboBox_3 = new JComboBox();

		connect o1 = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S1[] = new String[23];
		try {

			o1.init();
			ResultSet rs1 = o1.query("select distinct cdept from course");
			int j = 0;
			while (rs1.next()) {
				S1[j] = rs1.getString("cdept");
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
			ResultSet rs2 = o2.query("select distinct year from course");
			int j = 0;
			while (rs2.next()) {
				S2[j] = rs2.getString("year");
				j++;

			}
			for (int i = 0; i < S2.length; i++) {
				comboBox_1.addItem(S2[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}
		// ============================================================================
		connect o3 = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S3[] = new String[23];
		try {

			o3.init();
			ResultSet rs3 = o3.query("select distinct cno  from course");
			int j = 0;
			while (rs3.next()) {
				S3[j] = rs3.getString("cno");
				j++;

			}
			for (int i = 0; i < S3.length; i++) {
				comboBox_2.addItem(S3[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}
		// ============================================================================
		connect o4 = new connect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
		String S4[] = new String[23];
		try {

			o4.init();
			ResultSet rs4 = o4.query("select distinct tno  from  teacher");
			int j = 0;
			while (rs4.next()) {
				S4[j] = rs4.getString("tno");
				j++;

			}
			for (int i = 0; i < S4.length; i++) {
				comboBox_3.addItem(S4[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				String[] data = new String[7];
				int numT;
				DefaultTableModel model = (DefaultTableModel) Table.getModel();
				numT = model.getRowCount();// 获取当前已有行数
				while (numT > 0) {// 如果是全体刷新表格需要移除之前的所有数据行
					model.removeRow(0);
					numT--;
				}
				try {
					String l = comboBox.getSelectedItem().toString();

					String l1 = comboBox_1.getSelectedItem().toString();
					o1.init();
					ResultSet rset = o1
							.query("select course.cno,cname,credit,year,cdept,teach.tno,teacher.tname from course,teach,teacher where cdept='"
									+ l + "' and year='" + l1 + "'and course.cno=teach.cno and teach.tno=teacher.tno");
					while (rset.next()) {
						data[0] = rset.getString(1).trim();
						data[1] = rset.getString(2).trim();
						data[2] = rset.getString(3).trim();
						data[3] = rset.getString(4).trim();
						data[4] = rset.getString(5).trim();
						data[5] = rset.getString(6).trim();
						data[6] = rset.getString(7).trim();
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

		JLabel label_3 = new JLabel("\u8BFE\u7A0B\u53F7");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label_4 = new JLabel("\u6559\u5E08\u53F7");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_1 = new JButton("\u9009\u8BFE");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JButton button_2 = new JButton("\u53D6\u6D88");
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));

		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");

				try {
					String l2 = comboBox_2.getSelectedItem().toString();
					String l3 = comboBox_3.getSelectedItem().toString();
					o1.init();
					ResultSet rs3 = o1.query("select cno from Grade where cno='" + l2 + "'and sno='" + Login.suser + "' ");
					try {
						if (rs3.next()) {
							JOptionPane.showMessageDialog(null, "已选择此课程，不可重复！");
						} else {
							o1.insert("insert into Grade (sno,cno,tno) values('" + Login.suser + "','" + l2 + "','"
									+ l3 + "')");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 827, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(340)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(167)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(54)
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
							.addGap(65)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(66)
									.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addComponent(label_1)
							.addGap(40)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(76)
							.addComponent(button))
						.addComponent(lblNewLabel))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(181)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(113))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
