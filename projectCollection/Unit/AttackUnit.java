abstract class AttackUnit extends Unit {
	private String attType;
	private int power;
	public AttackUnit(String name, int hp, double moveSpeed, String tribe, int power,
		 String attType) {
		super(name, hp, moveSpeed, tribe);
		setPower(power);
		setAttType(attType);
	}
	public String getAttType() {
		return attType;
	}
	public int getPower() {
		return power;
	}
	public void setAttType(String attType) {
		this.attType = attType;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return super.toString() + "\npower : " + power + "\n공격타입 : " + attType;
	}
	protected abstract void attack(AttackUnit au);
	protected abstract int powerUpgrade();
}