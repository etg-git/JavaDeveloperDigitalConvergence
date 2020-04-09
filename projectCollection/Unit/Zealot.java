class Zealot extends AttackUnit {
	//100,0
	private int shield;
	public final int MAX_POWER = 22;
	public final int MINERAL = 100;
	public final int GAS = 0;
	
	public final int ZEALOT_MAX_HP = 100;

	public Zealot(String name, int hp, double moveSpeed
		, String tribe, int power, String attType, int shield) {
		super(name, hp, moveSpeed, tribe, power, attType);
		setShield(shield);
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	@Override
	protected void attack(AttackUnit au) {
		if(au.getAttType()== "����") {
			System.out.println("������");
			au.getHp();
		}
		else if(au.getHp() <= MIN_HP) {
			System.out.println(au.getName() + "�� ����");
			au.setHp(MIN_HP);
		} else {
			System.out.println(getName() + "�� "+ au.getName() + "��(��) ���ݷ�" + getPower() + "�� �����մϴ�.");
			au.setHp(au.getHp() - getPower());
		}
	}
	// 1.875 -> 2.813
	public double moveUpgrade() {
		setMoveSpeed(2.813);
		System.out.println("�̼� ���� �Ϸ�," + getMoveSpeed() + "�ӵ��� �̵��մϴ�.");
		return getMoveSpeed();
	}
	//1,2,3�ܰ� ����
	@Override
	protected int powerUpgrade() {
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
		return "���� ���� \n" + super.toString() + "\nshield : " + shield + "\n"
				+ "�̳׶� : " + MINERAL + "\n���� : " + GAS;
	}
}