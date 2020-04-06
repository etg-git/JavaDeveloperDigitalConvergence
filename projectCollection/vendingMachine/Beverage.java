//VendingMachine has-a Beverage
class Beverage {
	private String name;
	private int count;
	private int amount;

	public Beverage(String name, int amount, int count) {
		setName(name);
		setCount(count);
		setAmount(amount);
	}
	public Beverage(String name, int amount) {
		setName(name);
		setAmount(amount);
	}
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public int getAmount() {
		return amount;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String toString() {
			return  name + " �̾ҽ��ϴ�. (" + count +"�� ����)";
	}
}
