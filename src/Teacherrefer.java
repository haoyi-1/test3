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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Teacherrefer extends JFrame {

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
					Teacherrefer frame = new Teacherrefer();
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
	public Teacherrefer() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 580);
		contentPane = new JPanel();
		Image image = new ImageIcon("E:\\background.jpg").getImage();
		contentPane = new Beijing(image);
		setTitle("教师界面-查询");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton button = new JButton("\u67E5\u8BE2");
		button.setFont(new Font("宋体", Font.PLAIN, 18));

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));

		JScrollPane scrollPane = new JScrollPane();
		JTable Table = new JTable();
		Table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "工号", "教师姓名", "性别", "职称", "所属院系" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane.setViewportView(Table);

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
					ResultSet rset = o1.query("select * from teacher where  tno='" + Login.suser + "'");
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
		button_1.addActionListener(new ActionListener() {

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
					.addGap(23)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(196)
							.addComponent(button)
							.addGap(44)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
