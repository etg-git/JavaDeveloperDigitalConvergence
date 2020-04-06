//VendingMachine has-a Beverage
//VendingMachine has-a Money

import java.util.Scanner;
public class VendingTest {
	public static void main(String[] args) {

		Beverage coke = new Beverage("��ī�ݶ�", 800, 3);
		Beverage pepsi = new Beverage("����", 800);
		Beverage powerAde = new Beverage("�Ŀ����̵�", 1000, 3);
		Beverage sprite = new Beverage("��������Ʈ", 1500, 5);
		Beverage cider = new Beverage("ĥ�����̴�", 1200, 1);

		Money money = new Money(0, 1, 3);
		Money coin = new Money(2, 5);

		System.out.println(money);
		System.out.println(coin);
		VendingMachine me = new VendingMachine("������", "���������Ǳ�", coke, pepsi, powerAde, sprite, cider, money, coin);
		me.inputMoneySum();

		System.out.println(me.choicePick());

		me.returnMoney();
	}
}
