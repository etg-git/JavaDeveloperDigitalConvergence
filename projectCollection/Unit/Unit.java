class Unit  {
	private String name;
	private int hp;
	private int mineral;
	private int gas;
	private double moveSpeed;
	private String powerType;
	private String tribe;
	
	public static final int MIN_HP = 0;

	public Unit(String name, int hp, int mineral, int gas, double moveSpeed, String powerType, String tribe) {
		setName(name);
		setHp(hp);
		setMineral(mineral);
		setGas(gas);
		setMoveSpeed(moveSpeed);
		setPowerType(powerType);
		setTribe(tribe);
	}
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public int getMineral() {
		return mineral;
	}
	public int getGas() {
		return gas;
	}
	public double getMoveSpeed() {
		return moveSpeed;
	}
	public String getPowerType() {
		return powerType;
	}
	public String getTribe() {
		return tribe;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMineral(int mineral) {
		this.mineral = mineral;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}
	public void setTribe(String tribe) {
		this.tribe = tribe;
	}
	//�̵��Ÿ���ȯ
	public int move(int distance) {
		System.out.println("�̵��Ÿ� " + distance + ", " + getMoveSpeed() + " �ӵ��� �̵��մϴ�");	
		return distance;
	}/*
	//��Ż����Ʈ���� ���ݵ����� �޴´�
	public int attack(Mutallisk m) {
		hp -= m.getPower();
		System.out.println(getName() + "�� " + m.getPower() + "��ŭ ������ ����");
		return hp;
	}
	//�������� ���ݵ����� �޴´�.
	public int attack(Zealot z) {
		hp -= z.getPower();
		System.out.println(getName() + "�� " + z.getPower() + "��ŭ ������ ����");
		return hp;
	}*/

	// �� ���
	public Unit heal(Unit u1, double heal, int maxHp) {
		if(u1.getHp() > 0 && u1.getHp() <= maxHp) {
			u1.hp += heal;
			System.out.println(getName() + "�� " + u1.getName() + "��(��)" + heal + "��ŭ ġ���մϴ�.");
			return u1;
		}
		else {
			System.out.println("ġ�� �� �� ����");
			return u1;
		}
	}
	// ���� ���
	public Unit attack(Unit u1, int power) {
		System.out.println(getName() + "�� "+ u1.getName() + "��(��) ���ݷ�" + power + "�� �����մϴ�.");
		if(getName() == "����") {
			System.out.println(u1.getName() + "�� ����������");
			return u1;
		}
		if(u1.getHp() <= MIN_HP) {
			System.out.println(u1.getName() + "�� ����");
			u1.hp = MIN_HP;
		} else {
			u1.hp -= power;
		}
		return u1;
	}
	@Override
	public String toString() {
		String info = "hp : " + hp + "\n";
		info += "mineral : " + mineral + "\n";
		info += "gas : " + gas + "\n";
		info += "moveSpeed : " + moveSpeed + "\n";
		info += "powerType : " + powerType + "\n";
		info += "tribe : " + tribe + "\n";
		return info;
	}
}
