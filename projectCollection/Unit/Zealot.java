class Zealot extends GroundUnit implements IMoveUpgrade, IGroundAttack, IPowerUpgrade {
    // 100,0
    private int power;
    private int shield;
    public final int MAX_POWER = 22;
    public final int MINERAL = 100;
    public final int GAS = 0;

    public final static int ZEALOT_MAX_HP = 100;

    public Zealot(String name, int hp, double moveSpeed, String tribe, int power, int shield) {
        super(name, hp, moveSpeed, tribe);
        setShield(shield);
        setPower(power);
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

    @Override
    public void attack(GroundUnit g) {
        if (isAlive() == false) {
            System.out.println(g.getName() + " (이)가 죽음");
        } else {
            System.out.println(getName() + "가 " + g.getName() + " 을(를) 공격력" + getPower() + "로 공격합니다.");
            g.setHp(g.getHp() - getPower());
        }
    }

    @Override
    public void attack(MovingBuilding b) {
        if(b instanceof Command) {
            if(b.isFlying() == false && b.isDestroy() == false) {
                System.out.println(getName() + "은 " + b.getName() + " 을 공격하고있습니다");
                b.setHp(b.getHp() - getPower());

                if(b.isDestroy()){
                    System.out.println(b.getName() + "가 파괴되었습니다.");
                }
            }else {
                System.out.println(getName() + "은 " + b.getName() + " 공격할 수 없습니다.");
            }
        }
    }
    @Override
    public void attack(Building b) {

    }
    // 1.875 -> 2.813
    @Override
    public void moveUpgrade() {
        setMoveSpeed(2.813);
        System.out.println("이속 업글 완료," + getMoveSpeed() + " 속도로 이동합니다.");
    }

    // 1,2,3단계 업글
    @Override
    public void powerUpgrade() {
        if (MAX_POWER <= getPower()) {
            System.out.println("더이상 업글 할 수 없습니다.");
        } else {
            System.out.println("업글 완료");
            setPower(getPower() + 2);
        }
    }

    @Override
    public String toString() {
        return "<<질럿 스탯>>\n" + super.toString() + "\nshield : " + shield + "\n" + "미네랄 : " + MINERAL + "\n가스 : " + GAS;
    }
}