package admingui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

public class EditUser {

	JFrame editUser;
	private JTextField oFirst;
	private JTextField oLast;
	private JTextField oPhone;
	private JTextField oID;
	private JTextField oKRA;
	private JTextField oAddress;
	private JPanel addRiderrPanel;
	private JLabel riderFirstName;
	private JLabel lblLastName_1;
	private JLabel lblPhoneNumber_1;
	private JLabel lblIdNumber_1;
	private JLabel lblKraPin_1;
	private JLabel lblAddress_1;
	private JTextField rFirst;
	private JTextField rLast;
	private JTextField rPhone;
	private JTextField rID;
	private JTextField rKRA;
	private JTextField rAddress;
	private JButton btnSave;
	private JTextField bPlate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUser window = new EditUser();
					window.editUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditUser() {
		initialize();
		Connect();
		populateInformation();
	}

	// Mysql connection
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bodamatrix", "root", "");
		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

		}

	}

	public void populateInformation() {

		try {

			// Rider Information
			ps = con.prepareStatement("SELECT * FROM rider WHERE idNumber = ?");
			ps.setString(1, "45567890");
			rs = ps.executeQuery();
			if (rs.next()) {

				String riderFirst = rs.getString("firstName");
				String riderLast = rs.getString("lastName");
				int riderPhone = rs.getInt(3);
				int riderID = rs.getInt(4);
				String riderKRA = rs.getString("kraPin");
				String riderAddress = rs.getString("address");
				String bikePlate = rs.getString("plate");
				rFirst.setText(riderFirst);
				rLast.setText(riderLast);
				rPhone.setText(String.valueOf(riderPhone));
				rID.setText(String.valueOf(riderID));
				rKRA.setText(riderKRA);
				rAddress.setText(riderAddress);
				bPlate.setText(bikePlate);

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		editUser = new JFrame();
		editUser.getContentPane().setBackground(Color.WHITE);
		editUser.setFont(new Font("Bodoni MT", Font.BOLD, 15));
		editUser.setTitle("Edit user");
		editUser.setBounds(100, 100, 555, 546);
		editUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		editUser.getContentPane().setLayout(null);

		JPanel addOwnerPanel = new JPanel();
		addOwnerPanel.setBackground(new Color(152, 251, 152));
		addOwnerPanel.setLayout(null);
		addOwnerPanel.setBorder(
				new TitledBorder(null, "Owner Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addOwnerPanel.setBounds(29, 22, 459, 192);
		editUser.getContentPane().add(addOwnerPanel);

		JLabel ownerFirstName = new JLabel("First name");
		ownerFirstName.setBounds(10, 23, 68, 14);
		addOwnerPanel.add(ownerFirstName);

		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(10, 48, 68, 14);
		addOwnerPanel.add(lblLastName);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(10, 73, 84, 14);
		addOwnerPanel.add(lblPhoneNumber);

		JLabel lblIdNumber = new JLabel("I.D number");
		lblIdNumber.setBounds(10, 98, 68, 14);
		addOwnerPanel.add(lblIdNumber);

		JLabel lblKraPin = new JLabel("KRA pin");
		lblKraPin.setBounds(10, 123, 68, 14);
		addOwnerPanel.add(lblKraPin);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 148, 68, 14);
		addOwnerPanel.add(lblAddress);

		oFirst = new JTextField();
		oFirst.setColumns(10);
		oFirst.setBounds(103, 20, 141, 20);
		addOwnerPanel.add(oFirst);

		oLast = new JTextField();
		oLast.setColumns(10);
		oLast.setBounds(103, 45, 141, 20);
		addOwnerPanel.add(oLast);

		oPhone = new JTextField();
		oPhone.setColumns(10);
		oPhone.setBounds(103, 70, 141, 20);
		addOwnerPanel.add(oPhone);

		oID = new JTextField();
		oID.setColumns(10);
		oID.setBounds(103, 95, 141, 20);
		addOwnerPanel.add(oID);

		oKRA = new JTextField();
		oKRA.setColumns(10);
		oKRA.setBounds(103, 120, 141, 20);
		addOwnerPanel.add(oKRA);

		oAddress = new JTextField();
		oAddress.setColumns(10);
		oAddress.setBounds(103, 145, 141, 20);
		addOwnerPanel.add(oAddress);

		addRiderrPanel = new JPanel();
		addRiderrPanel.setBackground(new Color(175, 238, 238));
		addRiderrPanel.setLayout(null);
		addRiderrPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Rider Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addRiderrPanel.setBounds(29, 244, 459, 211);
		editUser.getContentPane().add(addRiderrPanel);

		riderFirstName = new JLabel("First name");
		riderFirstName.setBounds(10, 26, 68, 14);
		addRiderrPanel.add(riderFirstName);

		lblLastName_1 = new JLabel("Last name");
		lblLastName_1.setBounds(10, 51, 68, 14);
		addRiderrPanel.add(lblLastName_1);

		lblPhoneNumber_1 = new JLabel("Phone number");
		lblPhoneNumber_1.setBounds(10, 76, 84, 14);
		addRiderrPanel.add(lblPhoneNumber_1);

		lblIdNumber_1 = new JLabel("I.D number");
		lblIdNumber_1.setBounds(10, 101, 68, 14);
		addRiderrPanel.add(lblIdNumber_1);

		lblKraPin_1 = new JLabel("KRA pin");
		lblKraPin_1.setBounds(10, 126, 68, 14);
		addRiderrPanel.add(lblKraPin_1);

		lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(10, 151, 68, 14);
		addRiderrPanel.add(lblAddress_1);

		rFirst = new JTextField();
		rFirst.setColumns(10);
		rFirst.setBounds(108, 23, 137, 20);
		addRiderrPanel.add(rFirst);

		rLast = new JTextField();
		rLast.setColumns(10);
		rLast.setBounds(108, 48, 137, 20);
		addRiderrPanel.add(rLast);

		rPhone = new JTextField();
		rPhone.setColumns(10);
		rPhone.setBounds(108, 73, 137, 20);
		addRiderrPanel.add(rPhone);

		rID = new JTextField();
		rID.setColumns(10);
		rID.setBounds(108, 98, 137, 20);
		addRiderrPanel.add(rID);

		rKRA = new JTextField();
		rKRA.setColumns(10);
		rKRA.setBounds(108, 123, 137, 20);
		addRiderrPanel.add(rKRA);

		rAddress = new JTextField();
		rAddress.setColumns(10);
		rAddress.setBounds(108, 148, 137, 20);
		addRiderrPanel.add(rAddress);

		JLabel lblAddress_1_1 = new JLabel("Bike plate no.");
		lblAddress_1_1.setBounds(10, 179, 84, 14);
		addRiderrPanel.add(lblAddress_1_1);

		bPlate = new JTextField();
		bPlate.setColumns(10);
		bPlate.setBounds(108, 176, 137, 20);
		addRiderrPanel.add(bPlate);

		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		btnSave.setBounds(208, 466, 89, 23);
		editUser.getContentPane().add(btnSave);
		// editUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//

	}
}
