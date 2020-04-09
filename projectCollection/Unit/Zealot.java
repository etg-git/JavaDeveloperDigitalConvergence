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
		if(au.getAttType()== "공중") {
			System.out.println("못때림");
			au.getHp();
		}
		else if(au.getHp() <= MIN_HP) {
			System.out.println(au.getName() + "가 죽음");
			au.setHp(MIN_HP);
		} else {
			System.out.println(getName() + "가 "+ au.getName() + "을(를) 공격력" + getPower() + "로 공격합니다.");
			au.setHp(au.getHp() - getPower());
		}
	}
	// 1.875 -> 2.813
	public double moveUpgrade() {
		setMoveSpeed(2.813);
		System.out.println("이속 업글 완료," + getMoveSpeed() + "속도로 이동합니다.");
		return getMoveSpeed();
	}
	//1,2,3단계 업글
	@Override
	protected int powerUpgrade() {
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
		return "질럿 스탯 \n" + super.toString() + "\nshield : " + shield + "\n"
				+ "미네랄 : " + MINERAL + "\n가스 : " + GAS;
	}
}