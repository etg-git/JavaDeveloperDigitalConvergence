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
			System.out.println("더이상 업글 못함");
			return getPower();
		}
		else {
			setPower(getPower() + 1);
			System.out.println("업글완료");
			return getPower();
		}
	}
	//overroading
	public void attack(AttackUnit au) {
		System.out.println(getName() + "가(이) "+ au.getName() + "을(를) 공격력" + getPower() + "로 공격합니다.");
		if(au.getHp() <= MIN_HP) {
			System.out.println(au.getName() + "가 죽음");
			au.setHp(MIN_HP);
		} else {
			au.setHp(au.getHp() - getPower());
		}
	}
	@Override
	public String toString() {
		return "뮤탈 스텟 \n" + super.toString() + "\n미네랄 : " + MINERAL + "\n가스 : " + GAS;
	}

}