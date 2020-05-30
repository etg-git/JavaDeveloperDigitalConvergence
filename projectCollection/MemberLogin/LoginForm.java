package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginForm extends JFrame {

	private InputPanel id;
	private PwInputPanel pw;
	private JButton btnLogin;
	private JButton btnJoin;
	private JPanel pnlCenter;
	private JPanel pnlSouth;

	private File idPwFile;
	private File abIdPwFile;

	private String strPw = "";


	public File getAbIdPwFile() {
		return abIdPwFile;
	}

	public InputPanel getId() {
		return id;
	}

	public PwInputPanel getPw() {
		return pw;
	}

	public void setPw(PwInputPanel pw) {
		this.pw = pw;
	}

	public void setId(InputPanel id) {
		this.id = id;
	}

	public LoginForm() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		// center
		pnlCenter = new JPanel(new GridLayout(0, 1));
		id = new InputPanel();
		pw = new PwInputPanel();

		// south
		pnlSouth = new JPanel();
		btnLogin = new JButton("Login");
		btnJoin = new JButton("Join");

		// file
		idPwFile = new File("idPw.txt");
		abIdPwFile = idPwFile.getAbsoluteFile();
	}

	private void setDisplay() {
		id.getLblName().setText("ID");
		pw.getLblName().setText("Password");

		pnlCenter.add(id);
		pnlCenter.add(pw);

		pnlSouth.add(btnLogin);
		pnlSouth.add(btnJoin);

		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners() {
		ActionListener listener = (ae) -> {
			Object src = ae.getSource();

			if (btnLogin == src) {
				login();
			} else {
				new JoinForm(LoginForm.this);
			}
		};
		btnLogin.addActionListener(listener);
		btnJoin.addActionListener(listener);
	}

	private void login() {
		FileReader fr = null;
		BufferedReader br = null;
		boolean flag = true;
		char[] secretPw = pw.getPwField().getPassword();

		for (char cha : secretPw) {
			Character.toString(cha);

			strPw += (strPw.equals("")) ? "" + cha + "" : "" + cha + "";
		}
		if (flag) {
			try {
				String line = null;
				fr = new FileReader(idPwFile);
				br = new BufferedReader(fr);

				while (!(line = br.readLine()).equals(null) && flag) {
					if (line.contains(":")) {
						int index = line.indexOf(':');
						String id = line.substring(0, index);
						String pw = line.substring(index + 1, line.length());

						if (id.equals(this.id.getTxtField().getText().trim()) && strPw.equals(pw)) {
							JOptionPane.showMessageDialog(this, "로그인 성공!", "로그인", JOptionPane.INFORMATION_MESSAGE,
									null);
							flag = false;
							new InformationForm(LoginForm.this);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(this, "아이디나 비밀번호가 틀렸습니다");
			} finally {
				MyUtils.closeAll(br, fr);
			}
			strPw = "";
		}
	}

	private void showFrame() {
		setTitle("Login");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LoginForm();
	}
}