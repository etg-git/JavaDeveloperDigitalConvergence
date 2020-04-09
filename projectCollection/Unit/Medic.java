class Medic extends Unit {
	// 한번행동 5.86 = 11.72
	// 에너지1 = hp+2
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
	// 힐 기능(overroading)
	public void heal(Zealot z) {
		if(z.getHp() != 0) {
				z.setHp(z.getHp() + heal);
				if(z.getHp() < z.ZEALOT_MAX_HP) {
					System.out.println(getName() + "가(이) " + z.getName() + "을(를)" + heal + "만큼 치유합니다.");
				}
		}else {
				System.out.println("치유 할 수 없습니다");
			}
	}
	public void heal(Medic m) {
		if(m.getHp() != 0) {
				m.setHp(m.getHp() + heal);
				if(m.getHp() < MEDIC_MAX_HP) {
					System.out.println(getName() + "가(이) " + m.getName() + "을(를)" + heal + "만큼 치유합니다.");
				}
		}else {
				System.out.println("치유 할 수 없습니다");
			}
	}
	public int maxEnergyUpgrade() {
		if(getEnergy() >= MAX_ENERGY) {
			System.out.println("더이상 업글 할 수 없습니다.");
			return getEnergy();
		}
		else {
			setEnergy(getEnergy() + 50);
			System.out.println("업글완료");
			return getEnergy();
		}
	}
	@Override
	public String toString() {
		return "메딕 스텟 \n" + super.toString() + "heal : " + heal+ "\nenergy : " + energy + "\n미네랄 : " + MINERAL + "\n가스 : " + GAS;
	}
}