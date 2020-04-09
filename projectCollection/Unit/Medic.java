class Medic extends Unit {
	// �ѹ��ൿ 5.86 = 11.72
	// ������1 = hp+2
	// 50 25
	private int heal;
	private int energy;
	public final int MAX_ENERGY = 250;
	public final int MINERAL = 50;
	public final int GAS = 25;

	public final int MEDIC_MAX_HP = 60;
	public Medic(String name, int hp, double moveSpeed, String tribe, int heal, int energy) {
		super(name, hp, moveSpeed, tribe);
		setHeal(heal);
		setEnergy(energy);
	}
	public int getHeal() {
		return heal;
	}
	public int getEnergy() {
		return energy;
	}
	public void setHeal(int heal) {
		this.heal = heal;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	// �� ���(overroading)
	public void heal(Zealot z) {
		if(z.getHp() != 0) {
				z.setHp(z.getHp() + heal);
				if(z.getHp() < z.ZEALOT_MAX_HP) {
					System.out.println(getName() + "��(��) " + z.getName() + "��(��)" + heal + "��ŭ ġ���մϴ�.");
				}
		}else {
				System.out.println("ġ�� �� �� �����ϴ�");
			}
	}
	public void heal(Medic m) {
		if(m.getHp() != 0) {
				m.setHp(m.getHp() + heal);
				if(m.getHp() < MEDIC_MAX_HP) {
					System.out.println(getName() + "��(��) " + m.getName() + "��(��)" + heal + "��ŭ ġ���մϴ�.");
				}
		}else {
				System.out.println("ġ�� �� �� �����ϴ�");
			}
	}
	public int maxEnergyUpgrade() {
		if(getEnergy() >= MAX_ENERGY) {
			System.out.println("���̻� ���� �� �� �����ϴ�.");
			return getEnergy();
		}
		else {
			setEnergy(getEnergy() + 50);
			System.out.println("���ۿϷ�");
			return getEnergy();
		}
	}
	@Override
	public String toString() {
		return "�޵� ���� \n" + super.toString() + "heal : " + heal+ "\nenergy : " + energy + "\n�̳׶� : " + MINERAL + "\n���� : " + GAS;
	}
}