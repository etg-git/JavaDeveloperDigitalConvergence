package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class JoinForm extends JDialog {
	private LoginForm loginForm;

	private InputPanel[] input;
	private PwInputPanel pwInput;
	private PwInputPanel retryInput;

	private JPanel pnlNorth;
	private JPanel pnlCenter;
	private JPanel pnlSouth;

	private JRadioButton male;
	private JRadioButton female;

	private JButton btnJoin;
	private JButton btnCancel;

	public static final int ID = 0;
	public static final int NAME = 1;
	public static final int NICKNAME = 2;

	private String pw = "";
	private String retry = "";
	
	private List<MemberInformation> membersList;
	
	public JoinForm(LoginForm loginForm) {
		super(loginForm, "Join", true);
		this.loginForm = loginForm;
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	public List<MemberInformation> getMembersList() {
		return membersList;
	}

	public void setMembersList(List<MemberInformation> membersList) {
		this.membersList = membersList;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRetry() {
		return retry;
	}

	public void setRetry(String retry) {
		this.retry = retry;
	}

	public InputPanel[] getInput() {
		return input;
	}

	public void setInput(InputPanel[] input) {
		this.input = input;
	}

	public PwInputPanel getPwInput() {
		return pwInput;
	}

	public void setPwInput(PwInputPanel pwInput) {
		this.pwInput = pwInput;
	}

	public PwInputPanel getRetryInput() {
		return retryInput;
	}

	public void setRetryInput(PwInputPanel retryInput) {
		this.retryInput = retryInput;
	}

	public JRadioButton getMale() {
		return male;
	}

	public void setMale(JRadioButton male) {
		this.male = male;
	}

	public JRadioButton getFemale() {
		return female;
	}

	public void setFemale(JRadioButton female) {
		this.female = female;
	}

	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}
	private void init() {
		loginForm = new LoginForm();

		input = new InputPanel[3];
		pwInput = new PwInputPanel();
		retryInput = new PwInputPanel();

		pnlNorth = new JPanel(new GridLayout(0, 1));
		pnlCenter = new JPanel();
		pnlSouth = new JPanel();

		male = new JRadioButton("Male");
		female = new JRadioButton("Female");

		btnJoin = new JButton("Join");
		btnCancel = new JButton("Cancel");
		
		membersList = new Vector<>();
	}

	private void setDisplay() {
		// north
		String[] name = { "ID", "NAME", "NICKNAME" };
		pwInput.getLblName().setText("Password");
		retryInput.getLblName().setText("Retry");

		for (int i = 0; i < input.length; i++) {
			input[i] = new InputPanel();
			input[i].getLblName().setText(name[i]);
		}

		// center
		ButtonGroup group = new ButtonGroup();

		group.add(male);
		group.add(female);

		pnlCenter.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Gender"));

		pnlNorth.add(new JLabel("-Input your information", JLabel.CENTER));
		pnlNorth.add(input[ID]);
		pnlNorth.add(pwInput);
		pnlNorth.add(retryInput);
		pnlNorth.add(input[NAME]);
		pnlNorth.add(input[NICKNAME]);

		pnlCenter.add(male);
		pnlCenter.add(female);

		pnlSouth.add(btnJoin);
		pnlSouth.add(btnCancel);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void addListeners() {
		btnJoin.addActionListener((ae) -> {
			join();
		});
		btnCancel.addActionListener((ae) -> {
			JoinForm.this.dispose();
		});
	}

	private void join() {
		char[] secretPw = pwInput.getPwField().getPassword();
		char[] retryPw = retryInput.getPwField().getPassword();

		for (char cha : secretPw) {
			Character.toString(cha);

			pw += (pw.equals("")) ? "" + cha + "" : "" + cha + "";
		}
		for (char cha2 : retryPw) {
			Character.toString(cha2);

			retry += (retry.equals("")) ? "" + cha2 + "" : "" + cha2 + "";
		}

		boolean flag = true;
		if (input[ID].getTxtField().getText().trim().equals("")) {
			flag = false;
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
		}
		if (flag && pw.length() < 6) {
			flag = false;
			JOptionPane.showMessageDialog(this, "비밀번호 6자리 이상 입력해주세요");
		}
		if (flag && retry.length() < 6) {
			flag = false;
			JOptionPane.showMessageDialog(this, "재입력 6자리 이상 입력해주세요");
		}
		if (flag && input[NAME].getTxtField().getText().trim().equals("")) {
			flag = false;
			JOptionPane.showMessageDialog(this, "이름을 입력하세요");
		}
		if (flag && input[NICKNAME].getTxtField().getText().trim().equals("")) {
			flag = false;
			JOptionPane.showMessageDialog(this, "닉네임을 입력하세요");
		}
		if (flag && (!male.isSelected() && !female.isSelected())) {
			flag = false;
			JOptionPane.showMessageDialog(this, "성별을 선택하세요.");
		}
		if (flag && !pw.equals(retry)) {
			flag = false;
			JOptionPane.showMessageDialog(this, "비밀번호와 재입력을 동일하게 입력해주세요");
		}
		//파일안에 동일한 아이디가 있는지 여부를 판단하고, write를 할지 결정
		if (flag) {
			FileReader fr = null;
			BufferedReader br = null;
			FileWriter fw = null;
			PrintWriter prw = null;
			try {
				String line = null;
				fr = new FileReader(loginForm.getAbIdPwFile());
				br = new BufferedReader(fr);
				while ((line = br.readLine()) != null && flag) {
					if (line.contains(":")) {
						int index = line.indexOf(':');
						String id = line.substring(0, index);

						if (id.equals(input[ID].getTxtField().getText().trim())) {
							JOptionPane.showMessageDialog(this, "동일한 아이디가 있습니다");
							flag = false;
						}
					}
				}
				String str = "";
				if(male.isSelected()) {
					str += male.getText();
				} else {
					str += female.getText();
				}
				if (flag) {
					fw = new FileWriter(loginForm.getAbIdPwFile(), true);
					fw.write(input[ID].getTxtField().getText().trim() + ":" + pw + "\n");
					fw.write("Name is " + input[NAME].getTxtField().getText().trim() + "\n");
					fw.write("Nickname is " + input[NICKNAME].getTxtField().getText().trim() + "\n");
					fw.write("Gender is " +  str + "\n");
					fw.write("===================================================\n");
					
					fw.flush();

					JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다", "완료!", JOptionPane.INFORMATION_MESSAGE, null);
					dispose();
					
					membersList.add(new MemberInformation(JoinForm.this));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				MyUtils.closeAll(prw, fw, br, fr);
			}
			
		}
		pw = "";
		retry = "";
	}

	private void showFrame() {
		pack();
		setLocationRelativeTo(loginForm);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}