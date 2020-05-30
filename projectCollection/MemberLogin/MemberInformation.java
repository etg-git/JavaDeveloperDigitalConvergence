package kr.ac.green;

public class MemberInformation {
	private String id;
	private String pw;
	private String nickName;
	private String name;
	private String gender;
	
	private JoinForm join;
	
	public MemberInformation(JoinForm join) {
		this.join = join;
		
		id = join.getInput()[0].getTxtField().getText();
		pw = join.getPw();
		name = join.getInput()[1].getTxtField().getText();
		nickName = join.getInput()[2].getTxtField().getText();
		String str = "";
		if(join.getMale().isSelected()) {
			str += join.getMale().getText();
		} else {
			str += join.getFemale().getText();
		}
		gender = str;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public JoinForm getJoin() {
		return join;
	}
	public void setJoin(JoinForm join) {
		this.join = join;
	}
	@Override
	public String toString() {
		return "[" + id + "," + pw + "," + name + "," + nickName + "," + gender + "]";
	}
}