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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Stuquitclass extends JFrame {

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
					Stuquitclass frame = new Stuquitclass();
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
	public Stuquitclass() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 780);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\background.jpg").getImage();
		contentPane = new Beijing(image);
		setTitle("学生界面-退课");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JComboBox comboBox = new JComboBox();
		JLabel label_2 = new JLabel("\u9000\u8BFE\u8BFE\u7A0B\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		JButton button_3 = new JButton("\u53D6\u6D88");
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
				{ null, null, null, null, null }, }, new String[] { "课程号", "课程名", "学分", "学年", "教师姓名" }) {
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
		// ================================================================
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
				comboBox.addItem(S3[i]);
			}
		} catch (Exception e1) {

			e1.printStackTrace();

		}

		JButton button = new JButton("\u9009\u8BFE\u7ED3\u679C");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.addActionListener(new ActionListener() {

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
					ResultSet rset = o1
							.query("select course.cno,cname,credit,year,teacher.tname from course,Grade,teacher where sno='"
									+ Login.suser + "' and course.cno=Grade.cno and Grade.tno=teacher.tno");
					while (rset.next()) {
						data[0] = rset.getString(1).trim();
						data[1] = rset.getString(2).trim();
						data[2] = rset.getString(3).trim();
						data[3] = rset.getString(4).trim();
						data[4] = rset.getString(5).trim();
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
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		JButton button_2 = new JButton("\u786E\u8BA4");
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect o1 = new connect("com.mysql.cj.jdbc.Driver",
						"jdbc:mysql://localhost:3306/grade?serverTimezone=GMT%2B8", "root", "123456");
				try {
					String l1 = comboBox.getSelectedItem().toString();
					o1.init();
					ResultSet rset1 = o1.query("select * from student where sno='" + Login.suser + "'");
					o1.delete("delete from Grade where  sno='" + Login.suser + "' and cno='" + l1 + "'");
					o1.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 759, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(button)
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(295)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addGap(375))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(111))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(268)
					.addComponent(button)
					.addContainerGap(422, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
