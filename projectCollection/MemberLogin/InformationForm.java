package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class InformationForm extends JFrame {
	private JTextArea area;

	private LoginForm loginForm;
	private JButton btnLogout;
	private JButton btnWithdraw;
	private JPanel pnlSouth;
	private JPanel pnlCenter;
	
	
	public InformationForm(LoginForm loginForm) {
		this.loginForm = loginForm;
		init();
		setDisplay();
		getRead();
		addListeners();
		showFrame();
	}

	private void init() {
		area = new JTextArea(6, 30);
		btnLogout = new JButton("Logout");
		btnWithdraw = new JButton("Withdraw");
		pnlSouth = new JPanel();
		pnlCenter = new JPanel(new BorderLayout());
	}

	private void setDisplay() {
		pnlCenter.add(area);
		pnlCenter.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Check your Information"));
		pnlCenter.setBackground(Color.WHITE);

		pnlSouth.add(btnLogout);
		pnlSouth.add(btnWithdraw);

		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void getRead() {
		String str = "";
		FileReader fr = null;
		BufferedReader br = null;
		boolean flag = true;
		try {
			fr = new FileReader(loginForm.getAbIdPwFile());
			br = new BufferedReader(fr);

			String line = null;
			while ((line = br.readLine()) != null && flag) {
				if (line.contains(":")) {
					int index = line.indexOf(":");
					String id = line.substring(0, index);
					if (id.equals(loginForm.getId().getTxtField().getText())) {
						str += "아이디:비밀번호 ---> " + line + "\n";
						flag = false;
					}
				}
			}

			str += "이름 ---> " + line + "\n";
			line = br.readLine();
			str += "닉네임 ---> " + line + "\n";
			line = br.readLine();
			str += "성별 ---> " + line + "\n";

			area.setText(str);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addListeners() {
		ActionListener listener = (ae) -> {
			Object src = ae.getSource();

			if (src == btnLogout) {
				result();
			} else {
				withdraw();
			}
		};

		btnLogout.addActionListener(listener);
		btnWithdraw.addActionListener(listener);
	}

	private void result() {
		int result = JOptionPane.showConfirmDialog(this, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			dispose();
			loginForm.getId().getTxtField().setText("");
			loginForm.getPw().getPwField().setText("");
		}
	}

	private void withdraw() {
		int result = JOptionPane.showConfirmDialog(this, "회원탈퇴 하시겠습니까?", "탈퇴", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			dispose();
			
			String line = "";
			String noDummy = "";
			FileReader fr = null;
			BufferedReader br = null;
			FileWriter fw = null;
			try {
				fr = new FileReader(loginForm.getAbIdPwFile());
				br = new BufferedReader(fr);

				while ((line = br.readLine()) != null) {
					if (line.contains(":")) {
						int index = line.indexOf(":");
						
						String id = line.substring(0, index);
						if (id.equals(loginForm.getId().getTxtField().getText())) {
							br.readLine();
							br.readLine();
							br.readLine();
							br.readLine();
						}
						else {
							noDummy += line + "\n";
						}
					} else {
						noDummy += line + "\n";
					}
				}
				fw = new FileWriter(loginForm.getAbIdPwFile());
				fw.write(noDummy);
				loginForm.getId().getTxtField().setText("");
				loginForm.getPw().getPwField().setText("");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				MyUtils.closeAll(fw, br, fr);
			}
		}
		
	}

	private void showFrame() {
		setTitle("Information");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}