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
class Zealot extends Unit {
	private int power;
	private int shield;
	public static final int MAX_POWER = 22;

	public Zealot(String name, int hp, int mineral, int gas, double moveSpeed
		, String powerType, String tribe, int shield, int power) {
		super(name, hp, mineral, gas, moveSpeed, powerType, tribe);
		setPower(power);
		setShield(shield);
	}
	
	public int getPower() {
		return power;
	}
	public int getShield() {
		return shield;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	// 1.875 -> 2.813
	public double moveUpgrade() {
		setMoveSpeed(2.813);
		System.out.println("�̼� ���� �Ϸ�," + getMoveSpeed() + "�ӵ��� �̵��մϴ�.");
		return getMoveSpeed();
	}
	//1,2,3�ܰ� ����
	public int attackUpgrade() {
		if(MAX_POWER <= getPower()) {
			System.out.println("���̻� ���� �� �� �����ϴ�.");

			return getPower();
		}
		else {
			System.out.println("���� �Ϸ�");
			setPower(getPower() + 2);
			return getPower();
		}
	}
	@Override
	public String toString() {
		return "���� ���� \n" + super.toString() + "power : " + power + "\nshield : " + shield + "\n";
	}
}
class Medic extends Unit {
	// �ѹ��ൿ 5.86 = 11.72
	// ������1 = hp+2
	private double heal;
	private int maxEnergy;
	public static final int MAX_ENERGY = 250; 
	public Medic(String name,int hp, int mineral, int gas, double moveSpeed, 
				String powerType, String tribe, double heal, int maxEnergy) {
		super(name, hp, mineral, gas, moveSpeed, powerType, tribe);
		setHeal(heal);
		setMaxEnergy(maxEnergy);
	}
	public double getHeal() {
		return heal;
	}
	public int getMaxEnergy() {
		return maxEnergy;
	}
	public void setHeal(double heal) {
		this.heal = heal;
	}
	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public void stimPack() {
		setHp(getHp() - 10);
		setMoveSpeed(2.813);
		System.out.println("������");
	}
	public int maxEnergyUpgrade() {
		if(getMaxEnergy() >= MAX_ENERGY) {
			System.out.println("���̻� ���� �� �� �����ϴ�.");
			return getMaxEnergy();
		}
		else {
			setMaxEnergy(getMaxEnergy() + 50);
			System.out.println("���ۿϷ�");
			return getMaxEnergy();
		}
	}
	@Override
	public String toString() {
		return "�޵� ���� \n" + super.toString() + "heal : " + heal+ "\nenergy : " + maxEnergy + "\n";
	}
}
class Mutallisk extends Unit {
	private int power;
	public static final int MAX_POWER2 = 12;
	public Mutallisk(String name, int hp, int mineral, int gas, double moveSpeed,
		String powerType, String tribe, int power) {
		super(name, hp, mineral, gas, moveSpeed, powerType, tribe);
		setPower(power);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int powerUpgrade() {
		if(MAX_POWER2 <= getPower()) {
			System.out.println("���̻� ���� ����");
			return getPower();
		}
		else {
			setPower(getPower() + 1);
			System.out.println("���ۿϷ�");
			return getPower();
		}
	}
	@Override
	public String toString() {
		return "��Ż ���� \n" + super.toString() + "power : " + power + "\n";
	}

}
class StarCraftTribeTest {
	public static void main(String[] args) {
		Zealot z1 = new Zealot("����", 100, 100, 0, 1.875, "��������", "�����佺", 60, 16);
		Zealot z2 = new Zealot("����", 100, 100, 0, 1.875, "��������", "�����佺", 60, 16);
		System.out.println(z1);

		z1.move(5); //�̵�
		z1.moveUpgrade(); //�̵� ����
		z1.move(10);
		z1.attackUpgrade();// 1�ܰ�
		z1.attackUpgrade();// 2�ܰ�
		z1.attackUpgrade();// 3�ܰ�
		z1.attackUpgrade();// ���۾ȵ�
		System.out.println("power : " + z1.getPower());
		System.out.println();
		System.out.println();
		Medic m = new Medic("�޵�", 60, 50, 25, 1.875, "���� ��", "�׶�", 5.86, 200);
		System.out.println(m);
		
		m.maxEnergyUpgrade();//�ִ� ������ 250
		System.out.println("�ִ뿡���� : " + m.getMaxEnergy());
		m.stimPack();//ü�� 10�� ���̰�, �̵��ӵ��� ����
		System.out.println("hp : " + m.getHp() + "�̵��ӵ� : " + m.getMoveSpeed());

		Mutallisk mt = new Mutallisk("��Ż����ũ", 120, 100, 100, 3.126, "���Ÿ� ���� ����", "����", 9);
		System.out.println(mt);
		System.out.println();
		System.out.println();
		System.out.println("power : " + mt.getPower());
		mt.powerUpgrade();// 1�ܰ�
		mt.powerUpgrade();// 2�ܰ�
		mt.powerUpgrade();// 3�ܰ�
		mt.powerUpgrade();// ���۾ȵ�
		System.out.println("power : " +mt.getPower());
	
		mt.attack(z1, mt.getPower()); //��Ż����ũ�� ������ ����
		System.out.println(z1.getHp());

		m.heal(z1, m.getHeal(), z2.getHp()); //�޵��� ������ ġ��
		System.out.println(z2.getHp());
		
	}
}
