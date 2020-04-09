class Mutallisk extends AttackUnit {
	//100 100
	public final int MAX_POWER = 12;
	public final int MINERAL = 100;
	public final int GAS = 100;

	public final int MUTALLISK_MAX_HP = 100;

	public Mutallisk(String name, int hp, double moveSpeed, String tribe, int power, String attType) {
		super(name, hp, moveSpeed, tribe, power, attType);
	}
	@Override
	protected int powerUpgrade() {
		if(MAX_POWER <= getPower()) {
			System.out.println("���̻� ���� ����");
			return getPower();
		}
		else {
			setPower(getPower() + 1);
			System.out.println("���ۿϷ�");
			return getPower();
		}
	}
	//overroading
	public void attack(AttackUnit au) {
		System.out.println(getName() + "��(��) "+ au.getName() + "��(��) ���ݷ�" + getPower() + "�� �����մϴ�.");
		if(au.getHp() <= MIN_HP) {
			System.out.println(au.getName() + "�� ����");
			au.setHp(MIN_HP);
		} else {
			au.setHp(au.getHp() - getPower());
		}
	}
	@Override
	public String toString() {
		return "��Ż ���� \n" + super.toString() + "\n�̳׶� : " + MINERAL + "\n���� : " + GAS;
	}

}