package admingui;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;

import java.awt.event.KeyAdapter;

import javax.swing.JScrollPane;

//import org.openstreetmap.gui.jmapviewer.JMapViewer;
//import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
//
public class AdminPanel {

	private JFrame frmAdminPanel;
	private JTextField searchUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
		Connect();

	}

	// Mysql connection
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private JTable table_1;
	private JTable table;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bodamatrix", "root", "");
		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

		}

	}

	private void OwnerInfo() {
		String serach = searchUser.getText();
		try {

			ps = con.prepareStatement(
					"SELECT o.*FROM owner o INNER JOIN bike b ON o.idNumber = b.id INNER JOIN rider r ON b.plate = r.plate WHERE r.idNumber = ?");
			ps.setString(1, serach);
			rs = ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void RiderInfo() {
		String search = searchUser.getText();

		try {

			ps = con.prepareStatement("SELECT * FROM rider WHERE idNumber = ?");
			ps.setString(1, search);
			rs = ps.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.getContentPane().setBackground(new Color(255, 255, 255));
		frmAdminPanel.setFont(new Font("Bodoni MT", Font.PLAIN, 15));
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 1420, 1000);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);

		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(255, 255, 255));
		SearchPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Search Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		SearchPanel.setBounds(20, 57, 323, 189);
		frmAdminPanel.getContentPane().add(SearchPanel);
		SearchPanel.setLayout(null);

		searchUser = new JTextField();
		searchUser.setToolTipText("Enter ID/plate number");
		searchUser.setFont(new Font("Bodoni MT", Font.PLAIN, 15));
		searchUser.setBounds(10, 22, 286, 42);
		SearchPanel.add(searchUser);
		searchUser.setColumns(10);

		JButton seacrhButton = new JButton("Search");
		seacrhButton.setBackground(new Color(255, 255, 255));
		seacrhButton.setForeground(new Color(0, 0, 0));
		seacrhButton.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		seacrhButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RiderInfo();
				OwnerInfo();

			}

		});
		seacrhButton.setBounds(50, 91, 101, 23);
		SearchPanel.add(seacrhButton);

		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchUser.setText("");

//				frmAdminPanel.revalidate();

			}
		});
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		btnClear.setBounds(176, 91, 89, 23);
		SearchPanel.add(btnClear);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel.setBounds(353, 57, 1025, 189);
		frmAdminPanel.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBorder(new TitledBorder(null, "Rider", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 23, 519, 155);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 499, 123);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(152, 251, 152));
		panel_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Owner",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(539, 23, 476, 155);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 456, 123);
		panel_1_1.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Location",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 139, 139)));
		panel_2.setBounds(20, 257, 1358, 652);
		frmAdminPanel.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(20, 0, 323, 44);
		frmAdminPanel.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JButton btnAddButton = new JButton("Add");
		btnAddButton.setForeground(new Color(0, 0, 0));
		btnAddButton.setBackground(new Color(255, 255, 255));
		btnAddButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAddButton.addKeyListener(new KeyAdapter() {

		});
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewUser anu = new AddNewUser();
				anu.addNewUser.setVisible(true);

			}
		});
		btnAddButton.setBounds(0, 11, 89, 23);
		panel_3.add(btnAddButton);

		JButton btnEditButton = new JButton("Edit");
		btnEditButton.setForeground(new Color(0, 0, 0));
		btnEditButton.setBackground(new Color(255, 255, 255));
		btnEditButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getUser = searchUser.getText();
				EditUser eu = new EditUser();
				eu.searchID.setText(getUser);
				eu.editUser.setVisible(true);

			}
		});
		btnEditButton.setBounds(99, 11, 89, 23);
		panel_3.add(btnEditButton);

		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.setForeground(new Color(0, 0, 0));
		btnDeleteButton.setBackground(new Color(255, 255, 255));
		btnDeleteButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDeleteButton.setBounds(198, 11, 89, 23);
		panel_3.add(btnDeleteButton);
	}
}
