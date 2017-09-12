package atm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class AtmGUI extends JFrame implements ActionListener {

	private JPanel contentPane,loginp,functions;
	private JTextField textField;
	private JButton btnLogin,btnDeposit,btnWithdraw,btnChangePassword,btnLogOut,btnTransferMoney,btnCheckBalance,
	btnDepConfirm, btnDepBack, btnWitConfirm, btnWitBack;
	private JLabel lblWrongIdPassword;
	private JPanel depositPane;
	private JPanel withdrawPane;
	private JPanel balancePane;
	private JPanel transferPane;
	private JPanel passPane;
	private JLabel lblCurrentDepBalance;
	private JLabel lblCurrentWitBalance;
	private JTextField depositValueField, withdrawValueField;
	private JTextArea depBalance;
	private JLabel lblInvalidDepAmmount;
	private JLabel lblInvalidWitAmmount;
	private JTextArea witBalance;
	private JPasswordField passwordField;
	private JLabel lblCheckBalance;
	private JTextArea checkBalance;
	private JButton btnCheckBack;
	private JLabel lblTransAmmount;
	private JLabel lblTransBalance;
	private JLabel lblTargetAccountNumber;
	private JTextField transAccountField;
	private JTextField transValueField;
	private JTextField transBalance;
	private JButton btnTransConfirm;
	private JButton btnTransBack;
	private JLabel lblInvalidAccountNumber;
	private JLabel lblInvalidTransferAmmount;
	private JLabel lblEnterCurrentPassword;
	private JLabel lblEnterNewPassword;
	private JLabel lblConfirmNewPassword;
	private JButton btnPassConfirm;
	private JButton btnPassBack;
	private JLabel lblWrongPassword;
	private JLabel lblPasswordDoesNot;
	private JPasswordField oldPassField;
	private JPasswordField newPassField;
	private JPasswordField conNewPassField;
	private JLabel lblPasswordContainsSpace;
	private JLabel lblWelcomeToBank;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtmGUI frame = new AtmGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AtmGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		loginp = new JPanel();
		contentPane.add(loginp, "login");
		loginp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(52, 86, 142, 48);
		loginp.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(222, 100, 223, 22);
		loginp.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(52, 147, 142, 48);
		loginp.add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogin.setBounds(207, 232, 120, 48);
		loginp.add(btnLogin);
		
		lblWrongIdPassword = new JLabel("Invalid ID/ Password");
		lblWrongIdPassword.setEnabled(true);
		lblWrongIdPassword.setBounds(254, 196, 164, 16);
		lblWrongIdPassword.setVisible(false);
		loginp.add(lblWrongIdPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 161, 223, 22);
		loginp.add(passwordField);
		
		lblWelcomeToBank = new JLabel("Welcome to Bank Of DT");
		lblWelcomeToBank.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWelcomeToBank.setBounds(173, 37, 282, 36);
		loginp.add(lblWelcomeToBank);
		
		functions = new JPanel();
		contentPane.add(functions, "funct");
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(66, 61, 175, 61);
		btnDeposit.addActionListener(this);
		functions.setLayout(null);
		btnDeposit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		functions.add(btnDeposit);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(316, 61, 175, 61);
		btnWithdraw.addActionListener(this);
		btnWithdraw.setFont(new Font("Times New Roman", Font.BOLD, 18));
		functions.add(btnWithdraw);
		
		btnCheckBalance = new JButton("Check balance");
		btnCheckBalance.setBounds(66, 149, 175, 61);
		btnCheckBalance.addActionListener(this);
		btnCheckBalance.setFont(new Font("Times New Roman", Font.BOLD, 18));
		functions.add(btnCheckBalance);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(66, 237, 175, 61);
		btnChangePassword.addActionListener(this);
		btnChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		functions.add(btnChangePassword);
		
		btnTransferMoney = new JButton("Transfer Money");
		btnTransferMoney.setBounds(316, 148, 175, 61);
		btnTransferMoney.addActionListener(this);
		btnTransferMoney.setFont(new Font("Times New Roman", Font.BOLD, 18));
		functions.add(btnTransferMoney);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(316, 237, 175, 61);
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 18));
		functions.add(btnLogOut);
		
		depositPane = new JPanel();
		depositPane.setBounds(0, 0, 548, 343);
		contentPane.add(depositPane, "depositPane");
		depositPane.setLayout(null);
		
		JLabel lblDepositValue = new JLabel("Deposit Ammount");
		lblDepositValue.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDepositValue.setBounds(55, 101, 168, 31);
		depositPane.add(lblDepositValue);
		
		lblCurrentDepBalance = new JLabel("Current Balance");
		lblCurrentDepBalance.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCurrentDepBalance.setBounds(55, 183, 168, 44);
		depositPane.add(lblCurrentDepBalance);
		
		depositValueField = new JTextField();
		depositValueField.setBounds(270, 106, 160, 22);
		depositPane.add(depositValueField);
		depositValueField.setColumns(10);
		
		depBalance = new JTextArea();
		depBalance.setBounds(270, 195, 160, 22);
		depositPane.add(depBalance);
		
		btnDepConfirm = new JButton("Confirm");
		btnDepConfirm.addActionListener(this);
		btnDepConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDepConfirm.setBounds(439, 105, 97, 25);
		depositPane.add(btnDepConfirm);
		
		btnDepBack = new JButton("Back");
		btnDepBack.addActionListener(this);
		btnDepBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDepBack.setBounds(397, 283, 97, 25);
		depositPane.add(btnDepBack);
		
		lblInvalidDepAmmount = new JLabel("Invalid Ammount");
		lblInvalidDepAmmount.setBounds(300, 141, 114, 16);
		lblInvalidDepAmmount.setVisible(false);
		depositPane.add(lblInvalidDepAmmount);
		
		withdrawPane = new JPanel();
		withdrawPane.setBounds(0, 0, 548, 343);
		contentPane.add(withdrawPane, "withdrawPane");
		withdrawPane.setLayout(null);
		
		JLabel lblWithdrawValue = new JLabel("Withdraw Ammount");
		lblWithdrawValue.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWithdrawValue.setBounds(55, 101, 168, 31);
		withdrawPane.add(lblWithdrawValue);
		
		lblCurrentWitBalance = new JLabel("Current Balance");
		lblCurrentWitBalance.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCurrentWitBalance.setBounds(55, 183, 168, 44);
		withdrawPane.add(lblCurrentWitBalance);
		
		withdrawValueField = new JTextField();
		withdrawValueField.setBounds(270, 106, 160, 22);
		withdrawPane.add(withdrawValueField);
		withdrawValueField.setColumns(10);
		
		btnWitConfirm = new JButton("Confirm");
		btnWitConfirm.addActionListener(this);
		btnWitConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnWitConfirm.setBounds(439, 105, 97, 25);
		withdrawPane.add(btnWitConfirm);
		
		btnWitBack = new JButton("Back");
		btnWitBack.addActionListener(this);
		btnWitBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnWitBack.setBounds(397, 283, 97, 25);
		withdrawPane.add(btnWitBack);
		
		lblInvalidWitAmmount = new JLabel("Invalid Ammount");
		lblInvalidWitAmmount.setBounds(302, 141, 114, 16);
		lblInvalidWitAmmount.setVisible(false);
		withdrawPane.add(lblInvalidWitAmmount);
		
		witBalance = new JTextArea();
		witBalance.setBounds(270, 195, 160, 16);
		withdrawPane.add(witBalance);
		
		balancePane = new JPanel();
		balancePane.setBounds(0, 0, 559, 343);
		contentPane.add(balancePane, "balancePane");
		balancePane.setLayout(null);
		
		lblCheckBalance = new JLabel("Current Balance");
		lblCheckBalance.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCheckBalance.setBounds(56, 127, 151, 22);
		balancePane.add(lblCheckBalance);
		
		checkBalance = new JTextArea();
		checkBalance.setBounds(298, 128, 151, 22);
		balancePane.add(checkBalance);
		
		btnCheckBack = new JButton("Back");
		btnCheckBack.addActionListener(this);
		btnCheckBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCheckBack.setBounds(396, 262, 97, 25);
		balancePane.add(btnCheckBack);
		
		transferPane = new JPanel();
		transferPane.setBounds(0, 0, 548, 343);
		contentPane.add(transferPane, "transferPane");
		transferPane.setLayout(null);
		
		lblTransAmmount = new JLabel("Transfer Ammount");
		lblTransAmmount.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTransAmmount.setBounds(35, 144, 168, 31);
		transferPane.add(lblTransAmmount);
		
		lblTransBalance = new JLabel("Current Balance");
		lblTransBalance.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTransBalance.setBounds(35, 213, 168, 31);
		transferPane.add(lblTransBalance);
		
		lblTargetAccountNumber = new JLabel("Target Account Number");
		lblTargetAccountNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTargetAccountNumber.setBounds(35, 75, 195, 31);
		transferPane.add(lblTargetAccountNumber);
		
		transAccountField = new JTextField();
		transAccountField.setColumns(10);
		transAccountField.setBounds(267, 80, 160, 22);
		transferPane.add(transAccountField);
		
		transValueField = new JTextField();
		transValueField.setColumns(10);
		transValueField.setBounds(267, 149, 160, 22);
		transferPane.add(transValueField);
		
		transBalance = new JTextField();
		transBalance.setColumns(10);
		transBalance.setBounds(267, 218, 160, 22);
		transferPane.add(transBalance);
		
		btnTransConfirm = new JButton("Confirm");
		btnTransConfirm.addActionListener(this);
		btnTransConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTransConfirm.setBounds(439, 148, 97, 25);
		transferPane.add(btnTransConfirm);
		
		btnTransBack = new JButton("Back");
		btnTransBack.addActionListener(this);
		btnTransBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTransBack.setBounds(419, 289, 97, 25);
		transferPane.add(btnTransBack);
		
		lblInvalidAccountNumber = new JLabel("Invalid Account Number");
		lblInvalidAccountNumber.setVisible(false);
		lblInvalidAccountNumber.setBounds(277, 107, 160, 16);
		transferPane.add(lblInvalidAccountNumber);
		
		lblInvalidTransferAmmount = new JLabel("Invalid Transfer Ammount");
		lblInvalidTransferAmmount.setVisible(false);
		lblInvalidTransferAmmount.setBounds(277, 174, 160, 16);
		transferPane.add(lblInvalidTransferAmmount);
		
		passPane = new JPanel();
		passPane.setBounds(0, 0, 548, 343);
		contentPane.add(passPane, "passPane");
		passPane.setLayout(null);
		
		lblEnterCurrentPassword = new JLabel("Enter Current Password");
		lblEnterCurrentPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterCurrentPassword.setBounds(30, 83, 195, 31);
		passPane.add(lblEnterCurrentPassword);
		
		lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterNewPassword.setBounds(30, 165, 195, 31);
		passPane.add(lblEnterNewPassword);
		
		lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblConfirmNewPassword.setBounds(30, 220, 195, 31);
		passPane.add(lblConfirmNewPassword);
		
		btnPassConfirm = new JButton("Confirm");
		btnPassConfirm.addActionListener(this);
		btnPassConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPassConfirm.setBounds(330, 277, 97, 25);
		passPane.add(btnPassConfirm);
		
		btnPassBack = new JButton("Back");
		btnPassBack.addActionListener(this);
		btnPassBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPassBack.setBounds(451, 277, 97, 25);
		passPane.add(btnPassBack);
		
		lblWrongPassword = new JLabel("Wrong Password");
		lblWrongPassword.setVisible(false);
		lblWrongPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWrongPassword.setBounds(318, 112, 121, 16);
		passPane.add(lblWrongPassword);
		
		lblPasswordDoesNot = new JLabel("Password Does Not Match");
		lblPasswordDoesNot.setVisible(false);
		lblPasswordDoesNot.setBounds(303, 196, 153, 16);
		passPane.add(lblPasswordDoesNot);
		
		oldPassField = new JPasswordField();
		oldPassField.setBounds(268, 88, 223, 22);
		passPane.add(oldPassField);
		
		newPassField = new JPasswordField();
		newPassField.setBounds(268, 170, 223, 22);
		passPane.add(newPassField);
		
		conNewPassField = new JPasswordField();
		conNewPassField.setBounds(268, 225, 223, 22);
		passPane.add(conNewPassField);
		
		lblPasswordContainsSpace = new JLabel("Invalid Password");
		lblPasswordContainsSpace.setVisible(false);
		lblPasswordContainsSpace.setBounds(330, 196, 121, 16);
		passPane.add(lblPasswordContainsSpace);
	}
	public String[] readFile() {
		String[] info = null;
		String line = null;
		try (BufferedReader in = new BufferedReader(new FileReader("AccInfo.txt"))) {
            while ((line = in.readLine()) != null) {
                info = line.split(" ");
            }
            in.close();
		}
		catch (IOException e) {
            e.printStackTrace();
        }
		return info;
	}
	public void writeFile(String accNum, String accPass, double accBalance) {
		 try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("AccInfo.txt"));
		        out.write(accNum+ " " + accPass + " " + accBalance);
		        out.close();
		 } 
		 catch (IOException e) {
		      	e.printStackTrace();
		 }
	}
	public void actionPerformed(ActionEvent e) {
		String accNum = textField.getText();
		String accPass = String.valueOf(passwordField.getPassword());
		
		CardLayout cardLayout = (CardLayout) contentPane.getLayout();
		if (e.getSource() == btnLogin) {
			String[] accInfo= readFile();
			if (accNum.equals(accInfo[0]) && accPass.equals(accInfo[1])) 
				cardLayout.show(contentPane, "funct");
			else
				lblWrongIdPassword.setVisible(true);
		}
		
		if (e.getSource() == btnDeposit) {
			String[] accInfo= readFile();
			depBalance.setText(accInfo[2]);
			cardLayout.show(contentPane, "depositPane" );
		}
		
		if (e.getSource() == btnDepConfirm) {
			String[] accInfo= readFile();
			try {
				   double test = Double.parseDouble(depositValueField.getText());
				} catch (Exception a) {
					lblInvalidDepAmmount.setVisible(true);
				}
			
			if (Double.parseDouble(depositValueField.getText()) < 0)
				lblInvalidDepAmmount.setVisible(true);
			else {
				lblInvalidDepAmmount.setVisible(false);
				double newBalance = Double.parseDouble(depositValueField.getText()) + Double.parseDouble(accInfo[2]) ;
				depBalance.setText(Double.toString(newBalance));
				writeFile(accInfo[0], accInfo[1], newBalance);
				accInfo=readFile();
				depBalance.setText(accInfo[2]);
				}
		}
		
		if (e.getSource() == btnDepBack) {
			depositValueField.setText("");
			cardLayout.show(contentPane, "funct");
			lblInvalidDepAmmount.setVisible(false);
		}
		
		if (e.getSource() == btnWithdraw) {
			String[] accInfo= readFile();
			witBalance.setText(accInfo[2]);
			cardLayout.show(contentPane, "withdrawPane" );
		}
		
		if (e.getSource() == btnWitConfirm) {
			String[] accInfo= readFile();
			try {
				   double test = Double.parseDouble(withdrawValueField.getText());
				} catch (Exception a) {
					lblInvalidWitAmmount.setVisible(true);
				}
			
			if (Double.parseDouble(withdrawValueField.getText()) < 0 || (- Double.parseDouble(withdrawValueField.getText()) + Double.parseDouble(accInfo[2]) < 0) )
				lblInvalidWitAmmount.setVisible(true);
			else {
				lblInvalidWitAmmount.setVisible(false);
				double newBalance = - Double.parseDouble(withdrawValueField.getText()) + Double.parseDouble(accInfo[2]) ;
				witBalance.setText(Double.toString(newBalance));
				writeFile(accInfo[0], accInfo[1], newBalance);
				accInfo=readFile();
				witBalance.setText(accInfo[2]);
				}
		}
		
		if (e.getSource() == btnWitBack) {
			withdrawValueField.setText("");
			cardLayout.show(contentPane, "funct");
			lblInvalidWitAmmount.setVisible(false);
		}
		
		if (e.getSource() == btnCheckBalance) {
			String[] accInfo= readFile();
			checkBalance.setText(accInfo[2]);
			cardLayout.show(contentPane, "balancePane" );
		}
		
		if (e.getSource() == btnCheckBack) {
			checkBalance.setText("");
			cardLayout.show(contentPane, "funct");
		}
		
		if (e.getSource() == btnTransferMoney) {
			String[] accInfo= readFile();
			transBalance.setText(accInfo[2]);
			cardLayout.show(contentPane, "transferPane");
		}
		
		if (e.getSource() == btnTransConfirm) {
			String[] accInfo= readFile();
			try {
				   double test = Double.parseDouble(transAccountField.getText());
				} catch (Exception a) {
					lblInvalidAccountNumber.setVisible(true);
				}
			try {
				   double test = Double.parseDouble(transValueField.getText());
				} catch (Exception b) {
					lblInvalidTransferAmmount.setVisible(true);
				}
			if (transAccountField.getText().matches("^[0-9]{9}$")==false)
				lblInvalidAccountNumber.setVisible(true);
			else if (Double.parseDouble(transValueField.getText()) < 0 || (- Double.parseDouble(transValueField.getText()) + Double.parseDouble(accInfo[2]) < 0) )
				lblInvalidTransferAmmount.setVisible(true);
			else {
				lblInvalidAccountNumber.setVisible(false);
				lblInvalidTransferAmmount.setVisible(false);
				double newBalance = - Double.parseDouble(transValueField.getText()) + Double.parseDouble(accInfo[2]) ;
				transBalance.setText(Double.toString(newBalance));
				writeFile(accInfo[0], accInfo[1], newBalance);
				accInfo=readFile();
				transBalance.setText(accInfo[2]);
				}
		}
		
		if (e.getSource() == btnTransBack) {
			transBalance.setText("");
			cardLayout.show(contentPane, "funct");
		}
		
		if (e.getSource() == btnChangePassword)
			cardLayout.show(contentPane, "passPane");
			
		if (e.getSource() == btnPassConfirm) {
			String[] accInfo= readFile();
			if (String.valueOf(oldPassField.getPassword()).equals(accInfo[1]) == false) 
				lblWrongPassword.setVisible(true);
			else if (String.valueOf(newPassField.getPassword()).equals(String.valueOf(conNewPassField.getPassword()))== false) {
				lblPasswordDoesNot.setVisible(true);
				lblWrongPassword.setVisible(false);
				lblPasswordContainsSpace.setVisible(false);
			}
			else if ((String.valueOf(newPassField.getPassword()).contains(" ")) || (String.valueOf(newPassField.getPassword())).length()==0) {
				lblPasswordDoesNot.setVisible(false);
				lblWrongPassword.setVisible(false);
				lblPasswordContainsSpace.setVisible(true);
			}
			else {
				lblPasswordDoesNot.setVisible(false);
				writeFile(accInfo[0], String.valueOf(newPassField.getPassword()), Double.parseDouble(accInfo[2]));
				oldPassField.setText("");
				newPassField.setText("");
				conNewPassField.setText("");
				cardLayout.show(contentPane, "funct");
			}
			
		}
		
		if (e.getSource() == btnPassBack) {
			oldPassField.setText("");
			newPassField.setText("");
			conNewPassField.setText("");
			cardLayout.show(contentPane, "funct");
		}
		
		if (e.getSource() == btnLogOut) {
			textField.setText("");
			passwordField.setText("");
			cardLayout.show(contentPane, "login");
		}
	}
}
