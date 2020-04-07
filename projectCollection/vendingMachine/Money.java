//VendingMachine has-a Money
import java.util.Scanner;
class Money {
	private int tenThousandM;
	private int fiveThousandM;
	private int oneThousandM;
	private int fiveHundredC;
	private int oneHundredC;
	
	//지폐 생성
	public Money(int tenThousandM, int fiveThousandM, int oneThousandM) {
		setTenThousandM(tenThousandM);
		setFiveThousandM(fiveThousandM);
		setOneThousandM(oneThousandM);
	}
	//동전 생성
	public Money(int fiveHundredC, int oneHundredC) {
		setFiveHundredC(fiveHundredC);
		setOneHundredC(oneHundredC);
	}
	
	public int getTenThousandM() {
		return tenThousandM;
	}

	public void setTenThousandM(int tenThousandM) {
		this.tenThousandM = tenThousandM;
	}

	public int getFiveThousandM() {
		return fiveThousandM;
	}

	public void setFiveThousandM(int fiveThousandM) {
		this.fiveThousandM = fiveThousandM;
	}

	public int getOneThousandM() {
		return oneThousandM;
	}

	public void setOneThousandM(int oneThousandM) {
		this.oneThousandM = oneThousandM;
	}

	public int getFiveHundredC() {
		return fiveHundredC;
	}

	public void setFiveHundredC(int fiveHundredC) {
		this.fiveHundredC = fiveHundredC;
	}

	public int getOneHundredC() {
		return oneHundredC;
	}

	public void setOneHundredC(int oneHundredC) {
		this.oneHundredC = oneHundredC;
	}
	
	public int moneySum() { //지폐 합산
		int M_10000 = 10000 * getTenThousandM();
		int M_5000 = 5000 * getFiveThousandM();
		int M_1000 = 1000 * getOneThousandM();
		
		return M_10000 + M_5000 + M_1000;
	}
	public int coinSum() { //동전 합산
		int C_500 = 500 * getFiveHundredC();
		int C_100 = 100 * getOneHundredC();
		
		return C_500 + C_100;
	}
	public String toString() {
		if(moneySum() !=0) {
			return "지폐 : " + moneySum() + "원 투입";
		}
		else return "동전 : " + coinSum() + "원 투입";
	}
}
