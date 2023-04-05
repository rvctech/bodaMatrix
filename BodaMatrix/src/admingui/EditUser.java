package admingui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

public class EditUser {

	 JFrame editUser;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
	 private JPanel addRiderrPanel;
	 private JLabel riderFirstName;
	 private JLabel lblLastName_1;
	 private JLabel lblPhoneNumber_1;
	 private JLabel lblIdNumber_1;
	 private JLabel lblKraPin_1;
	 private JLabel lblAddress_1;
	 private JTextField textField_6;
	 private JTextField textField_7;
	 private JTextField textField_8;
	 private JTextField textField_9;
	 private JTextField textField_10;
	 private JTextField textField_11;
	 private JButton btnSave;
	 private JTextField textField_12;

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
		addOwnerPanel.setBorder(new TitledBorder(null, "Owner Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(103, 20, 141, 20);
		addOwnerPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 45, 141, 20);
		addOwnerPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 70, 141, 20);
		addOwnerPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 95, 141, 20);
		addOwnerPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 120, 141, 20);
		addOwnerPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(103, 145, 141, 20);
		addOwnerPanel.add(textField_5);
		
		addRiderrPanel = new JPanel();
		addRiderrPanel.setBackground(new Color(175, 238, 238));
		addRiderrPanel.setLayout(null);
		addRiderrPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rider Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(108, 23, 137, 20);
		addRiderrPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(108, 48, 137, 20);
		addRiderrPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(108, 73, 137, 20);
		addRiderrPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(108, 98, 137, 20);
		addRiderrPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(108, 123, 137, 20);
		addRiderrPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(108, 148, 137, 20);
		addRiderrPanel.add(textField_11);
		
		JLabel lblAddress_1_1 = new JLabel("Bike plate no.");
		lblAddress_1_1.setBounds(10, 179, 84, 14);
		addRiderrPanel.add(lblAddress_1_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(108, 176, 137, 20);
		addRiderrPanel.add(textField_12);
		
		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setFont(new Font("Bodoni MT", Font.BOLD, 20));
		btnSave.setBounds(208, 466, 89, 23);
		editUser.getContentPane().add(btnSave);
		//editUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		
		
	}
}
