class Mutallisk extends AirUnit implements IAllAttack, IPowerUpgrade {
    // 100 100
    public final int MAX_POWER = 12;
    public final int MINERAL = 100;
    public final int GAS = 100;
    private int power;
    public final static int MUTALLISK_MAX_HP = 100;

    public Mutallisk(String name, int hp, double moveSpeed, String tribe, int power) {
        super(name, hp, moveSpeed, tribe);
        setPower(power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void powerUpgrade() {
        if (MAX_POWER <= getPower()) {
            System.out.println("더이상 업글 못함");
        } else {
            setPower(getPower() + 1);
            System.out.println("업글완료");
        }
    }

    @Override
    public void attack(Unit u) {
        System.out.println(getName() + "가(이) " + u.getName() + "을(를) 공격력" + getPower() + "로 공격합니다.");
        if (isAlive() == false) {
            System.out.println(u.getName() + "가 죽음");
        } else {
            u.setHp(u.getHp() - getPower());
        }
    }
    @Override
    public void attack(Building b) {
        if(b instanceof Command) {
            if(b.isDestroy() == false) {
                System.out.println(getName() + "은" + b.getName() + "을 공격하고있습니다");
                b.setHp(b.getHp() - getPower());
            }
            if(b.isDestroy()){
                System.out.println(b.getName() + "가 파괴되었습니다.");
            }
        }
    }
    @Override
    public String toString() {
        return "<<<뮤탈 스텟>>> \n" + super.toString() + "\n미네랄 : " + MINERAL + "\n가스 : " + GAS;
    }

}