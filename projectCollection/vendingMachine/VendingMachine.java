//VendingMachine has-a Beverage
//VendingMachine has-a Money

import java.util.Scanner;
class VendingMachine {
	private String color; // ����
	private int balance;
	private String manufacture; // ������

	private Money money; //����
	private Money coin; //����

	private Beverage coke;
	private Beverage pepsi;
	private Beverage powerAde;
	private Beverage sprite;
	private Beverage cider;

	static final int d_coke = 1;
	static final int d_pepsi = 2;
	static final int d_powerAde = 3;
	static final int d_sprite = 4;
	static final int d_cider = 5;

	public VendingMachine(String color, String manufacture, Beverage coke, Beverage pepsi, Beverage powerAde, Beverage sprite, Beverage cider, Money money, Money coin) {
		setColor(color);
		setManufacture(manufacture);
		setCoke(coke);
		setPepsi(pepsi);
		setPowerAde(powerAde);
		setSprite(sprite);
		setCider(cider);
		setMoney(money);
		setCoin(coin);
	}
	public String getColor() {
		return color;
	}
	public String getManufacturer() {
		return manufacture;
	}
	public int getBalance() {
		return balance;
	}
	public Money getMoney() {
		return money;
	}
	public Money getCoin() {
		return coin;
	}
	public Beverage getCoke() {
		return coke;
	}
	public Beverage getPepsi() {
		return pepsi;
	}
	public Beverage getPowerAde() {
		return powerAde;
	}
	public Beverage getSprite() {
		return sprite;
	}
	public Beverage getCider() {
		return cider;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public void setMoney(Money money) {
		this.money = money;
	}
	public void setCoin(Money coin) {
		this.coin = coin;
	}
	public void setCoke(Beverage coke) {
		this.coke = coke;
	}
	public void setPepsi(Beverage pepsi) {
		this.pepsi = pepsi;
	}
	public void setPowerAde(Beverage powerAde) {
		this.powerAde = powerAde;
	}
	public void setSprite(Beverage sprite) {
		this.sprite = sprite;
	}
	public void setCider(Beverage cider) {
		this.cider = cider;
	}
	public void inputMoneySum() {
		int sum = money.moneySum() + coin.coinSum();
		balance += sum;
	}
	public Beverage choicePick() {

			Scanner sc = new Scanner(System.in);
			int drink;

			String info = "=====================================================\n";
				info += "||         	                                    ||\n";
				info +=	"||  1.��ī�ݶ�         2. ����         3.�Ŀ����̵� ||\n";
				info +=	"||    800��(" +soldOut(coke.getCount()) + ")    800��(" +soldOut(pepsi.getCount()) + ")      1000��(" +soldOut(powerAde.getCount()) + ") ||\n";
				info +=	"||  4.��������Ʈ            5.ĥ�����̴�            ||\n";
				info +=	"||    1500��("+soldOut(sprite.getCount())+")          1200��(" +soldOut(cider.getCount()) + ")  	    ||\n";
				info += "||         	                                    ||\n";
				info += "||                  0 : �ܵ���ȯ                    ||\n";
				info +=	"=====================================================\n";

				System.out.println(info);
				System.out.print("�������� �����ϼ��� : ");
				drink = sc.nextInt();

			if(d_coke == drink && balance >= 800 && soldOut(coke.getCount())) {
				 return result(getCoke(), balance-=800, drink);
			}
			else if(d_pepsi == drink && balance >= 800 && soldOut(pepsi.getCount())) {
				 return result(getPepsi(), balance-=800, drink);
			 }
			 else if(d_powerAde == drink &&  balance >= 1000  && soldOut(powerAde.getCount())) {
				 return result(getPowerAde(), balance-=1000, drink);
			 }
			 else if(d_sprite == drink && balance >= 1500  && soldOut(sprite.getCount())) {
				 return result(getSprite(), balance -= 1500,  drink);
			 }
			 else if(d_cider == drink &&  balance >= 1200  && soldOut(cider.getCount())) {
				 return result(getCider(), balance-=1200,  drink);
			 }
			 else if(drink == 0) {
				 return null;
			 }
			 else {
				System.out.println("�ٽû�������");
				return choicePick();
			 }
	}
	private Beverage result(Beverage beverage,int balance, int drink) {
			DrinkDecrease(drink);
			Scanner sc = new Scanner(System.in);
			System.out.print("���̱� : 1, �������ʱ� : �ƹ���ȣ  ====>  ");
			int select = sc.nextInt();

			if(select == 1) {
				System.out.println(beverage);
				return choicePick();
			}
			else return beverage;
	}
	public int returnMoney() {
		System.out.println(getBalance() + "�� ��ȯ�մϴ�");
		return getBalance();
	}
	private void DrinkDecrease(int drink) {
		if(drink == 1) {
			coke.setCount(coke.getCount()-1);
		}
		else if(drink == 2) {
			pepsi.setCount(pepsi.getCount()-1);
		}
		else if(drink == 3) {
			powerAde.setCount(powerAde.getCount()-1);
		}
		else if(drink == 4) {
			sprite.setCount(sprite.getCount()-1);
		}
		else if(drink == 5) {
			cider.setCount(cider.getCount()-1);
		}
	}
	private boolean soldOut(int number) { // ������ ������ true ������ false
		if(number <= 0) { //������ 0�϶� false
				return false;
		} else { //������ ���������� true
			return true;
		  }
	}
	public String toString() {
		String info = balance + "�� �ܾ�";

		return info;
	}
}
