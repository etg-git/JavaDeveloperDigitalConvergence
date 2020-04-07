//VendingMachine has-a Beverage
//VendingMachine has-a Money

import java.util.Scanner;
public class VendingTest {
	public static void main(String[] args) {
		
		Beverage coke = new Beverage("코카콜라", 800, 3);
		Beverage pepsi = new Beverage("펩시", 800);
		Beverage powerAde = new Beverage("파워에이드", 1000, 3);
		Beverage sprite = new Beverage("스프라이트", 1500, 5);
		Beverage cider = new Beverage("칠성사이다", 1200, 1);
		
		Money money = new Money(0, 1, 3); //지폐 생성(5천원 1장, 천원 3장)
		Money coin = new Money(2, 5); //동전 생성(500원 2개, 100원 5개)
		
		System.out.println(money);
		System.out.println(coin);
		VendingMachine me = new VendingMachine("빨간색", "음료수자판기", coke, pepsi, powerAde, sprite, cider, money, coin);
		me.inputMoneySum(); // 투입한 금액 합산

		me.choicePick();
		me.returnMoney(); //금액반환
	}
}
