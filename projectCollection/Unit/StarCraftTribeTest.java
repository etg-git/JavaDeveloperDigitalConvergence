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
	//이동거리반환
	public int move(int distance) {
		System.out.println("이동거리 " + distance + ", " + getMoveSpeed() + " 속도로 이동합니다");	
		return distance;
	}/*
	//뮤탈리스트에게 공격데미지 받는다
	public int attack(Mutallisk m) {
		hp -= m.getPower();
		System.out.println(getName() + "은 " + m.getPower() + "만큼 데미지 받음");
		return hp;
	}
	//질럿에게 공격데미지 받는다.
	public int attack(Zealot z) {
		hp -= z.getPower();
		System.out.println(getName() + "은 " + z.getPower() + "만큼 데미지 받음");
		return hp;
	}*/

	// 힐 기능
	public Unit heal(Unit u1, double heal, int maxHp) {
		if(u1.getHp() > 0 && u1.getHp() <= maxHp) {
			u1.hp += heal;
			System.out.println(getName() + "이 " + u1.getName() + "을(를)" + heal + "만큼 치유합니다.");
			return u1;
		}
		else {
			System.out.println("치유 할 수 없음");
			return u1;
		}
	}
	// 공격 기능
	public Unit attack(Unit u1, int power) {
		System.out.println(getName() + "가 "+ u1.getName() + "을(를) 공격력" + power + "로 공격합니다.");
		if(getName() == "질럿") {
			System.out.println(u1.getName() + "을 때리지못함");
			return u1;
		}
		if(u1.getHp() <= MIN_HP) {
			System.out.println(u1.getName() + "가 죽음");
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
		System.out.println("이속 업글 완료," + getMoveSpeed() + "속도로 이동합니다.");
		return getMoveSpeed();
	}
	//1,2,3단계 업글
	public int attackUpgrade() {
		if(MAX_POWER <= getPower()) {
			System.out.println("더이상 업글 할 수 없습니다.");

			return getPower();
		}
		else {
			System.out.println("업글 완료");
			setPower(getPower() + 2);
			return getPower();
		}
	}
	@Override
	public String toString() {
		return "질럿 스탯 \n" + super.toString() + "power : " + power + "\nshield : " + shield + "\n";
	}
}
class Medic extends Unit {
	// 한번행동 5.86 = 11.72
	// 에너지1 = hp+2
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
		System.out.println("스팀팩");
	}
	public int maxEnergyUpgrade() {
		if(getMaxEnergy() >= MAX_ENERGY) {
			System.out.println("더이상 업글 할 수 없습니다.");
			return getMaxEnergy();
		}
		else {
			setMaxEnergy(getMaxEnergy() + 50);
			System.out.println("업글완료");
			return getMaxEnergy();
		}
	}
	@Override
	public String toString() {
		return "메딕 스텟 \n" + super.toString() + "heal : " + heal+ "\nenergy : " + maxEnergy + "\n";
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
			System.out.println("더이상 업글 못함");
			return getPower();
		}
		else {
			setPower(getPower() + 1);
			System.out.println("업글완료");
			return getPower();
		}
	}
	@Override
	public String toString() {
		return "뮤탈 스텟 \n" + super.toString() + "power : " + power + "\n";
	}

}
class StarCraftTribeTest {
	public static void main(String[] args) {
		Zealot z1 = new Zealot("질럿", 100, 100, 0, 1.875, "근접공격", "프로토스", 60, 16);
		Zealot z2 = new Zealot("질럿", 100, 100, 0, 1.875, "근접공격", "프로토스", 60, 16);
		System.out.println(z1);

		z1.move(5); //이동
		z1.moveUpgrade(); //이동 업글
		z1.move(10);
		z1.attackUpgrade();// 1단계
		z1.attackUpgrade();// 2단계
		z1.attackUpgrade();// 3단계
		z1.attackUpgrade();// 업글안됨
		System.out.println("power : " + z1.getPower());
		System.out.println();
		System.out.println();
		Medic m = new Medic("메딕", 60, 50, 25, 1.875, "근접 힐", "테란", 5.86, 200);
		System.out.println(m);
		
		m.maxEnergyUpgrade();//최대 에너지 250
		System.out.println("최대에너지 : " + m.getMaxEnergy());
		m.stimPack();//체력 10이 깎이고, 이동속도가 증가
		System.out.println("hp : " + m.getHp() + "이동속도 : " + m.getMoveSpeed());

		Mutallisk mt = new Mutallisk("뮤탈리스크", 120, 100, 100, 3.126, "원거리 공중 공격", "저그", 9);
		System.out.println(mt);
		System.out.println();
		System.out.println();
		System.out.println("power : " + mt.getPower());
		mt.powerUpgrade();// 1단계
		mt.powerUpgrade();// 2단계
		mt.powerUpgrade();// 3단계
		mt.powerUpgrade();// 업글안됨
		System.out.println("power : " +mt.getPower());
	
		mt.attack(z1, mt.getPower()); //뮤탈리스크가 질럿을 공격
		System.out.println(z1.getHp());

		m.heal(z1, m.getHeal(), z2.getHp()); //메딕이 질럿을 치유
		System.out.println(z2.getHp());
		
	}
}
