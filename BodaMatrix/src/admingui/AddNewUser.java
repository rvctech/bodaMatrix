package admingui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddNewUser {

	JFrame addNewUser;
	private JTextField oFirst;
	private JTextField oLast;
	private JTextField oPhone;
	private JTextField oID;
	private JTextField oKRA;
	private JTextField oAddress;
	private JTextField rFirst;
	private JTextField rLast;
	private JTextField rPhone;
	private JTextField rID;
	private JTextField rKRA;
	private JTextField rAddress;
	private JTextField make;
	private JTextField model;
	private JTextField cc;
	private JTextField chasis;
	private JTextField plateNo;
	private JTextField year;
	private JTextField fuel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewUser window = new AddNewUser();
					window.addNewUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddNewUser() {
		initialize();
		Connect();

	}

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

	// Check if owner exists in the database
	private String checkOwner(int ownerID) {
		try {

			ps = con.prepareStatement("SELECT * FROM owner WHERE idNumber = ?");
			ps.setInt(1, ownerID);
			rs = ps.executeQuery();
			if (rs.next()) {
				return "ID located";
//				String ownerFirst = rs.getString("firstName");
//				String ownerLast = rs.getString("lastName");
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
		addNewUser = new JFrame();
		addNewUser.getContentPane().setBackground(Color.WHITE);
		addNewUser.setTitle("Add new");
		addNewUser.setBounds(100, 100, 1000, 546);
		// addNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//
		addNewUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addNewUser.getContentPane().setLayout(null);

		JPanel addOwnerPanel = new JPanel();
		addOwnerPanel.setBackground(new Color(152, 251, 152));
		addOwnerPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Owner Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addOwnerPanel.setBounds(30, 23, 459, 192);
		addNewUser.getContentPane().add(addOwnerPanel);
		addOwnerPanel.setLayout(null);

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
		oFirst.setBounds(103, 20, 141, 20);
		addOwnerPanel.add(oFirst);
		oFirst.setColumns(10);

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

		JPanel addRiderrPanel_1 = new JPanel();
		addRiderrPanel_1.setBackground(new Color(175, 238, 238));
		addRiderrPanel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Rider Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addRiderrPanel_1.setBounds(30, 244, 459, 208);
		addNewUser.getContentPane().add(addRiderrPanel_1);
		addRiderrPanel_1.setLayout(null);

		JLabel riderFirstName_1 = new JLabel("First name");
		riderFirstName_1.setBounds(10, 26, 68, 14);
		addRiderrPanel_1.add(riderFirstName_1);

		JLabel lblLastName_1 = new JLabel("Last name");
		lblLastName_1.setBounds(10, 51, 68, 14);
		addRiderrPanel_1.add(lblLastName_1);

		JLabel lblPhoneNumber_1 = new JLabel("Phone number");
		lblPhoneNumber_1.setBounds(10, 76, 84, 14);
		addRiderrPanel_1.add(lblPhoneNumber_1);

		JLabel lblIdNumber_1 = new JLabel("I.D number");
		lblIdNumber_1.setBounds(10, 101, 68, 14);
		addRiderrPanel_1.add(lblIdNumber_1);

		JLabel lblKraPin_1 = new JLabel("KRA pin");
		lblKraPin_1.setBounds(10, 126, 68, 14);
		addRiderrPanel_1.add(lblKraPin_1);

		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(10, 151, 68, 14);
		addRiderrPanel_1.add(lblAddress_1);

		rFirst = new JTextField();
		rFirst.setColumns(10);
		rFirst.setBounds(108, 23, 137, 20);
		addRiderrPanel_1.add(rFirst);

		rLast = new JTextField();
		rLast.setColumns(10);
		rLast.setBounds(108, 48, 137, 20);
		addRiderrPanel_1.add(rLast);

		rPhone = new JTextField();
		rPhone.setColumns(10);
		rPhone.setBounds(108, 73, 137, 20);
		addRiderrPanel_1.add(rPhone);

		rID = new JTextField();
		rID.setColumns(10);
		rID.setBounds(108, 98, 137, 20);
		addRiderrPanel_1.add(rID);

		rKRA = new JTextField();
		rKRA.setColumns(10);
		rKRA.setBounds(108, 123, 137, 20);
		addRiderrPanel_1.add(rKRA);

		rAddress = new JTextField();
		rAddress.setColumns(10);
		rAddress.setBounds(108, 148, 137, 20);
		addRiderrPanel_1.add(rAddress);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// The owners, rider and bike informations should not be blank
				if (oFirst.getText().equals("") || oLast.getText().equals("") || oPhone.getText().equals("")
						|| oID.getText().equals("") || oKRA.getText().equals("") || oAddress.getText().equals("")
						|| rFirst.getText().equals("") || rLast.getText().equals("") || rPhone.getText().equals("")
						|| rID.getText().equals("") || rKRA.getText().equals("") || rAddress.getText().equals("")
						|| make.getText().equals("") || model.getText().equals("") || cc.getText().equals("")
						|| chasis.getText().equals("") || plateNo.getText().equals("") || year.getText().equals("")
						|| fuel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in the complete form");

				}

				else {
					insertInformation();

				}
			}

//			// Check if owner exists in the database
//			private String checkOwner(int ownerID) {
//				try {
//
//					ps = con.prepareStatement("SELECT * FROM owner WHERE idNumber = ?");
//					ps.setInt(1, ownerID);
//					rs = ps.executeQuery();
//					if (rs.next()) {
//						return "ID located";
////						String ownerFirst = rs.getString("firstName");
////						String ownerLast = rs.getString("lastName");
//					}
//
//				} catch (SQLException ex) {
//					ex.printStackTrace();
//				}
//				return "ID Not located";
//
//			}

			private void insertInformation() {
				String ownerFirst, ownerLast, ownerKRA, ownerAddress, riderFirst, riderLast, riderAddress, bikePlate,
						riderKRA, bikeMake, bikeModel, bikeChasis, bikeFuel;

				int ownerPhone, ownerID, riderPhone, riderID, bikecc, bikeYear;

				// Get owners information from text entered
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

				// Get bike information from text entered
				bikeMake = make.getText();
				bikeModel = model.getText();
				bikecc = Integer.parseInt(cc.getText());
				bikeChasis = chasis.getText();
				bikePlate = plateNo.getText();
				bikeFuel = fuel.getText();
				bikeYear = Integer.parseInt(year.getText());

				try {

					// If the owner exists in the database then add bike and rider information

					if (checkOwner(ownerID).equals("ID located")) {
						ps = con.prepareStatement(
								"INSERT INTO bike(make,model,cc,chasis,plate,manufacture,fuel,id)VALUES(?,?,?,?,?,?,?,?)");
						ps.setString(1, bikeMake);
						ps.setString(2, bikeModel);
						ps.setInt(3, bikecc);
						ps.setString(4, bikeChasis);
						ps.setString(5, bikePlate);
						ps.setInt(6, bikeYear);
						ps.setString(7, bikeFuel);
						ps.setInt(8, ownerID);
						ps.executeUpdate();

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

						JOptionPane.showMessageDialog(null, "Rider and Bike Successfully Added");

					} else {

						// If owner doesn't exist then add the owner, rider and bike information

						ps = con.prepareStatement(
								"INSERT INTO owner(firstName,lastName,phone,idNumber,kraPin,address)VALUES(?,?,?,?,?,?)");
						ps.setString(1, ownerFirst);
						ps.setString(2, ownerLast);
						ps.setInt(3, ownerPhone);
						ps.setInt(4, ownerID);
						ps.setString(5, ownerKRA);
						ps.setString(6, ownerAddress);
						ps.executeUpdate();

						ps = con.prepareStatement(
								"INSERT INTO bike(make,model,cc,chasis,plate,manufacture,fuel,id)VALUES(?,?,?,?,?,?,?,?)");
						ps.setString(1, bikeMake);
						ps.setString(2, bikeModel);
						ps.setInt(3, bikecc);
						ps.setString(4, bikeChasis);
						ps.setString(5, bikePlate);
						ps.setInt(6, bikeYear);
						ps.setString(7, bikeFuel);
						ps.setInt(8, ownerID);
						ps.executeUpdate();

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

						JOptionPane.showMessageDialog(null, "Information Successfully Added");

					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		btnNewButton.setBounds(479, 463, 106, 23);
		addNewUser.getContentPane().add(btnNewButton);

		JPanel addRiderrPanel = new JPanel();
		addRiderrPanel.setBackground(new Color(255, 248, 220));
		addRiderrPanel.setLayout(null);
		addRiderrPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Bike Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addRiderrPanel.setBounds(499, 23, 459, 232);
		addNewUser.getContentPane().add(addRiderrPanel);

		JLabel lblMake = new JLabel("Make");
		lblMake.setBounds(10, 26, 68, 14);
		addRiderrPanel.add(lblMake);

		JLabel lblLastName_1_1 = new JLabel("Model");
		lblLastName_1_1.setBounds(10, 51, 68, 14);
		addRiderrPanel.add(lblLastName_1_1);

		JLabel lblPhoneNumber_1_1 = new JLabel("CC");
		lblPhoneNumber_1_1.setBounds(10, 76, 84, 14);
		addRiderrPanel.add(lblPhoneNumber_1_1);

		JLabel lblIdNumber_1_1 = new JLabel("Chasis");
		lblIdNumber_1_1.setBounds(10, 101, 68, 14);
		addRiderrPanel.add(lblIdNumber_1_1);

		JLabel lblKraPin_1_1 = new JLabel("Licence Plate");
		lblKraPin_1_1.setBounds(10, 126, 99, 14);
		addRiderrPanel.add(lblKraPin_1_1);

		JLabel lblAddress_1_2 = new JLabel("Year of manufacture");
		lblAddress_1_2.setBounds(10, 151, 128, 14);
		addRiderrPanel.add(lblAddress_1_2);

		make = new JTextField();
		make.setColumns(10);
		make.setBounds(176, 20, 137, 20);
		addRiderrPanel.add(make);

		model = new JTextField();
		model.setColumns(10);
		model.setBounds(176, 45, 137, 20);
		addRiderrPanel.add(model);

		cc = new JTextField();
		cc.setColumns(10);
		cc.setBounds(176, 70, 137, 20);
		addRiderrPanel.add(cc);

		chasis = new JTextField();
		chasis.setColumns(10);
		chasis.setBounds(176, 95, 137, 20);
		addRiderrPanel.add(chasis);

		plateNo = new JTextField();
		plateNo.setColumns(10);
		plateNo.setBounds(176, 120, 137, 20);
		addRiderrPanel.add(plateNo);

		year = new JTextField();
		year.setColumns(10);
		year.setBounds(176, 145, 137, 20);
		addRiderrPanel.add(year);

		JLabel lblFuelType = new JLabel("Fuel type");
		lblFuelType.setBounds(10, 175, 68, 14);
		addRiderrPanel.add(lblFuelType);

		fuel = new JTextField();
		fuel.setColumns(10);
		fuel.setBounds(176, 169, 137, 20);
		addRiderrPanel.add(fuel);
	}
}
