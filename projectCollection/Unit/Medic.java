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
