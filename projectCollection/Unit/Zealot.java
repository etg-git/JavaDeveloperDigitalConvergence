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