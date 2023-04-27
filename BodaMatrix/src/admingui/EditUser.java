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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.lang.StackWalker.Option;
import java.awt.event.ActionEvent;

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
	public JTextField rID;
	private JTextField rKRA;
	private JTextField rAddress;
	private JButton btnSave;
	private JTextField bPlate;
	public JTextField searchID;

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
//		populateInformation();

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

// Check if owner exists in the databse
	private String checkOwner(int ownerID) {

		try {

			ps = con.prepareStatement("SELECT * FROM owner WHERE idNumber = ?");
			ps.setInt(1, ownerID);
			rs = ps.executeQuery();
			if (rs.next()) {
				return "ID located";

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "ID Not located";
	}

//Checks if rider exists in the database
	private String checkRider(int riderID) {
		try {

			ps = con.prepareStatement("SELECT * FROM rider WHERE idNumber = ?");
			ps.setInt(1, riderID);
			rs = ps.executeQuery();
			if (rs.next()) {
				return "ID located";

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "ID Not located";

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
		addOwnerPanel.setBounds(29, 48, 459, 192);
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
		addRiderrPanel.setBounds(29, 251, 459, 211);
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ownerFirst, ownerLast, ownerKRA, ownerAddress, riderFirst, riderLast, riderAddress, bikePlate,
						riderKRA;

				int ownerPhone, ownerID, riderPhone, riderID;
//				int ownerID = Integer.parseInt(oID.getText());
				// int riderID = Integer.parseInt(rID.getText());

				ownerFirst = oFirst.getText();
				ownerLast = oLast.getText();
				ownerPhone = Integer.parseInt(oPhone.getText());
				ownerID = Integer.parseInt(oID.getText());
				ownerKRA = oKRA.getText();
				ownerAddress = oAddress.getText();

				// Get riders information from text entered
				riderFirst = rFirst.getText();
				riderLast = rLast.getText();
				riderPhone = Integer.parseInt(rPhone.getText());
				riderID = Integer.parseInt(rID.getText());
				riderKRA = rKRA.getText();
				riderAddress = rAddress.getText();
				bikePlate = bPlate.getText();

				// If owner and rider exists then message will show that the information already
				// exists

				if (checkOwner(ownerID).equals("ID located") && checkRider(riderID).equals("ID located")) {
					JOptionPane.showMessageDialog(null, "Owner and Rider Already Exist");

					// If owner exists and the rider does not exist then add the rider information
				} else if (checkOwner(ownerID).equals("ID located") && checkRider(riderID).equals("ID Not located")) {
					try {
						PreparedStatement ps = con.prepareStatement(
								"UPDATE rider SET firstName=?, lastName=?, phone=?, idNumber=?, kraPin=?, address=? WHERE plate=?");
						ps.setString(1, riderFirst);
						ps.setString(2, riderLast);
						ps.setInt(3, riderPhone);
						ps.setInt(4, riderID);
						ps.setString(5, riderKRA);
						ps.setString(6, riderAddress);
						ps.setString(7, bikePlate);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Rider Information Updated!");

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// checks id the rider exists and the owner does not exists, then add the new
					// owner
				} else if (checkOwner(ownerID).equals("ID Not located") && checkRider(riderID).equals("ID located")) {

					try {
						// Insert the new owner into the Owner table
						PreparedStatement ps = con.prepareStatement(
								"INSERT INTO owner (firstName, lastName, phone, idNumber, kraPin, address) VALUES (?, ?, ?, ?, ?, ?)");
						ps.setString(1, ownerFirst);
						ps.setString(2, ownerLast);
						ps.setInt(3, ownerPhone);
						ps.setInt(4, ownerID);
						ps.setString(5, ownerKRA);
						ps.setString(6, ownerAddress);
						ps.executeUpdate();

						// Update the Bike table with the new owner's ID as the foreign key
						PreparedStatement ps3 = con.prepareStatement("UPDATE bike SET id = ? WHERE plate = ?");
						ps3.setInt(1, ownerID);
						ps3.setString(2, bikePlate);
						ps3.executeUpdate();
						JOptionPane.showMessageDialog(null, "Owner Information Updated!");

					} catch (SQLException ex) {
						ex.printStackTrace();
					}

				} else if (checkOwner(ownerID).equals("ID Not located")
						&& checkRider(riderID).equals("ID Not located")) {
					try {
						// Insert the new owner into the Owner table
						PreparedStatement ps = con.prepareStatement(
								"INSERT INTO owner (firstName, lastName, phone, idNumber, kraPin, address) VALUES (?, ?, ?, ?, ?, ?)");
						ps.setString(1, ownerFirst);
						ps.setString(2, ownerLast);
						ps.setInt(3, ownerPhone);
						ps.setInt(4, ownerID);
						ps.setString(5, ownerKRA);
						ps.setString(6, ownerAddress);
						ps.executeUpdate();

						// Update the Bike table with the new owner's ID as the foreign key
						PreparedStatement ps3 = con.prepareStatement("UPDATE bike SET id = ? WHERE plate = ?");
						ps3.setInt(1, ownerID);
						ps3.setString(2, bikePlate);
						ps3.executeUpdate();

						// Update the Rider table with new rider
						ps = con.prepareStatement(
								"INSERT INTO rider(firstName,lastName,phone,idNumber,kraPin,address,plate)VALUES(?,?,?,?,?,?,?)");
						ps.setString(1, riderFirst);
						ps.setString(2, riderLast);
						ps.setInt(3, riderPhone);
						ps.setInt(4, riderID);
						ps.setString(5, riderKRA);
						ps.setString(6, riderAddress);
						ps.setString(7, bikePlate);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Owner and Rider Information Updated!");

					} catch (SQLException ex) {
						ex.printStackTrace();
					}

				}

			}
		});

		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		btnSave.setBounds(211, 473, 89, 23);
		editUser.getContentPane().add(btnSave);

		searchID = new JTextField();
		searchID.setBounds(20, 17, 371, 20);
		editUser.getContentPane().add(searchID);
		searchID.setColumns(10);

		JButton searchIDButton = new JButton("Search");
		searchIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					// Rider Information
					String getID = searchID.getText();

					ps = con.prepareStatement("SELECT * FROM rider WHERE idNumber = ?");
					ps.setString(1, getID);
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

						// Owners information
						ps = con.prepareStatement(
								"SELECT o.*FROM owner o INNER JOIN bike b ON o.idNumber = b.id INNER JOIN rider r ON b.plate = r.plate WHERE r.idNumber = ?");
						ps.setString(1, getID);
						rs = ps.executeQuery();
						if (rs.next()) {
							String ownerFirst = rs.getString("firstName");
							String ownerLast = rs.getString("lastName");
							int ownerPhone = rs.getInt(3);
							int ownerID = rs.getInt(4);
							String ownerKRA = rs.getString("kraPin");
							String ownerAddress = rs.getString("address");

							oFirst.setText(ownerFirst);
							oLast.setText(ownerLast);
							oPhone.setText(String.valueOf(ownerPhone));
							oID.setText(String.valueOf(ownerID));
							oKRA.setText(ownerKRA);
							oAddress.setText(ownerAddress);

						}

					}

				} catch (SQLException ex) {
					ex.printStackTrace();

				}

			}
		});
		searchIDButton.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		searchIDButton.setBounds(399, 14, 101, 23);
		editUser.getContentPane().add(searchIDButton);
		// editUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
