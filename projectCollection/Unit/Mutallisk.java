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
			System.out.println("´õÀÌ»ó ¾÷±Û ¸øÇÔ");
			return getPower();
		}
		else {
			setPower(getPower() + 1);
			System.out.println("¾÷±Û¿Ï·á");
			return getPower();
		}
	}
	@Override
	public String toString() {
		return "¹ÂÅ» ½ºÅÝ \n" + super.toString() + "power : " + power + "\n";
	}

}
