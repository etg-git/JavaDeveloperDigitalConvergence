interface IPowerUpgrade {

    void powerUpgrade();
}
interface IMoveUpgrade {
    void moveUpgrade();
}

interface IAllAttack {
    void attack(Unit u);
    void attack(Building b);
}
interface IGroundAttack {
    void attack(GroundUnit g);
    void attack(Building b);
}

interface IAirAttack {
    void attack(AirUnit a);
    void attack(Building b);
}
interface IMove {
	void move(Point p);
}
//mark interface
interface IBiological {
}

class Point {
	private int x;
	private int y;

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")�� ����";
	}
}
abstract class Unit {
   
    private String name;
    private int hp;
    private double moveSpeed;
    private String tribe;
    private boolean alive;
    private Point location;

    public Unit(String name, int hp, double moveSpeed, String tribe, Point location) {
        setName(name);
        setHp(hp);
        setMoveSpeed(moveSpeed);
        setTribe(tribe);
		setLocation(location);
		alive = true;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public double getMoveSpeed() {
        return moveSpeed;
    }
    public String getTribe() {
        return tribe;
    }
   
    public boolean isAlive() {
        if(this.hp <= 0) {
            alive = false;
            return alive;
        } else {
            return alive = true;
        }
        
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
		if(hp <= 0) {
			setAlive(false);
			this.hp = 0;
		}else {
			this.hp = hp;
		}
	}
	 public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
    public void setTribe(String tribe) {
        this.tribe = tribe;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        String info = "hp : " + hp + "\n";
        info += "moveSpeed : " + moveSpeed + "\n";
        info += "tribe : " + tribe + "\n";
        return info;
    }
}

abstract class GroundUnit extends Unit {
    public GroundUnit(String name, int hp, double moveSpeed, String tribe, Point location) {
        super(name, hp, moveSpeed, tribe, location);
    }

    @Override
    public String toString() {
        return "<<<��������>>>\n" + super.toString();
    }
}

abstract class AirUnit extends Unit {
    public AirUnit(String name, int hp, double moveSpeed, String tribe, Point location) {
        super(name, hp, moveSpeed, tribe, location);
    }

    @Override
    public String toString() {
        return "<<<��������>>>\n" + super.toString();
    }
}


class Zealot extends GroundUnit implements IMoveUpgrade, IPowerUpgrade, IBiological, IGroundAttack, IMove {
    // 100,0
    private int power;
    private int shield;
    public final int MAX_POWER = 22;
    public final int MINERAL = 100;
    public final int GAS = 0;

    public final static int ZEALOT_MAX_HP = 100;

    public Zealot(String name, int hp, double moveSpeed, String tribe, Point location, int power, int shield) {
        super(name, hp, moveSpeed, tribe, location);
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
        if (g.isAlive() == false) {
            System.out.println(g.getName() + " (��)�� ����");
        } else {
            System.out.println(getName() + "�� " + g.getName() + " ��(��) ���ݷ�" + getPower() + "�� �����մϴ�.");
            g.setHp(g.getHp() - getPower());
        }
    }

    @Override
    public void attack(Building b) {
        if(b instanceof Command) {
			Command c = (Command) b;
            if(c.isFlying() == false && c.isDestroy() == false) {
                System.out.println(getName() + "�� " + c.getName() + " �� �����ϰ��ֽ��ϴ�");
                c.setHp(c.getHp() - getPower());

                if(c.isDestroy()){
                    System.out.println(c.getName() + "�� �ı��Ǿ����ϴ�.");
                }
            }else {
                System.out.println(getName() + "�� " + b.getName() + " ������ �� �����ϴ�.");
            }
        }
    }
	@Override
	public void move(Point p) {
		setLocation(p);
	}
    // 1.875 -> 2.813
    @Override
    public void moveUpgrade() {
        setMoveSpeed(2.813);
        System.out.println("�̼� ���� �Ϸ�," + getMoveSpeed() + " �ӵ��� �̵��մϴ�.");
    }

    // 1,2,3�ܰ� ����
    @Override
    public void powerUpgrade() {
        if (MAX_POWER <= getPower()) {
            System.out.println("���̻� ���� �� �� �����ϴ�.");
        } else {
            System.out.println("���� �Ϸ�");
            setPower(getPower() + 2);
        }
    }

    @Override
    public String toString() {
        return "<<���� ����>>\n" + super.toString() + "\nshield : " + shield + "\n" + "�̳׶� : " + MINERAL + "\n���� : " + GAS;
    }
}

class Mutallisk extends AirUnit implements IPowerUpgrade, IAllAttack, IMove {
    // 100 100
    public final int MAX_POWER = 12;
    public final int MINERAL = 100;
    public final int GAS = 100;
    private int power;
    public final static int MUTALLISK_MAX_HP = 100;

    public Mutallisk(String name, int hp, double moveSpeed, String tribe, Point location, int power) {
        super(name, hp, moveSpeed, tribe, location);
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
            System.out.println("���̻� ���� ����");
        } else {
            setPower(getPower() + 1);
            System.out.println("���ۿϷ�");
        }
    }
    @Override
    public void attack(Unit u) {
        System.out.println(getName() + "��(��) " + u.getName() + "��(��) ���ݷ�" + getPower() + "�� �����մϴ�.");
        if (u.isAlive() == false) {
            System.out.println(u.getName() + "�� ����");
        } else {
            u.setHp(u.getHp() - getPower());
        }
    }
    @Override
    public void attack(Building b) {
        if(b instanceof Command) {
            if(b.isDestroy() == false) {
                System.out.println(getName() + "��" + b.getName() + "�� �����ϰ��ֽ��ϴ�");
                b.setHp(b.getHp() - getPower());
            }
            if(b.isDestroy()){
                System.out.println(b.getName() + "�� �ı��Ǿ����ϴ�.");
            }
        }
    }
	@Override
	public void move(Point p) {
		setLocation(p);
	}
    @Override
    public String toString() {
        return "<<<��Ż ����>>> \n" + super.toString() + "\n�̳׶� : " + MINERAL + "\n���� : " + GAS;
    }
}
class Medic extends GroundUnit implements IBiological, IMove {

    // �ѹ��ൿ 5.86 = 11.72
    // ������1 = hp+2
    // 50 25
    private int heal;
    private int energy;
    public final int MAX_ENERGY = 250;
    public final int MINERAL = 50;
    public final int GAS = 25;

    public final static int MEDIC_MAX_HP = 60;

    public Medic(String name, int hp, double moveSpeed, String tribe, Point location, int heal, int energy) {
        super(name, hp, moveSpeed, tribe, location);
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
	@Override
	public void move(Point p) {
		setLocation(p);
	}
    // �� ���(overroading)
    public void heal(IBiological b) {
		Unit u = (Unit)b;
        if (u instanceof Zealot) {
            if (u.isAlive()) {
                u.setHp(u.getHp() + heal);
                if (u.getHp() <= Zealot.ZEALOT_MAX_HP) {
                    System.out.println(getName() + "��(��) " + u.getName() + "��(��)" + heal + "��ŭ ġ���մϴ�.");
                }
            } else {
                System.out.println("ġ�� �� �� �����ϴ�");
            }
        } else if (u instanceof Medic) {
            if (u.isAlive()) {
                u.setHp(u.getHp() + heal);
                if (u.getHp() <= Medic.MEDIC_MAX_HP) {
                    System.out.println(getName() + "��(��) " + u.getName() + "��(��)" + heal + "��ŭ ġ���մϴ�.");
                }
            } else {
                System.out.println("ġ�� �� �� �����ϴ�");
            }
        }
    }
    public int maxEnergyUpgrade() {
        if (getEnergy() >= MAX_ENERGY) {
            System.out.println("���̻� ���� �� �� �����ϴ�.");
            return getEnergy();
        } else {
            setEnergy(getEnergy() + 50);
            System.out.println("���ۿϷ�");
            return getEnergy();
        }
    }
    @Override
    public String toString() {
        return "<<�޵� ����>>\n" + super.toString() + "heal : " + heal + "\nenergy : " + energy + "\n�̳׶� : " + MINERAL
                + "\n���� : " + GAS;
    }
}
abstract class Building {
    private String name;
    private int hp;
    private boolean destroy;

    public Building(String name, int hp) {
        setHp(hp);
        setName(name);
		setDestroy(false);
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public boolean isDestroy() {
        if(hp <= 0) { 
            destroy = true;
            return destroy;
        } else{
            return destroy = false;
        }
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }
    @Override
    public String toString() {
        return name + "�� �ϼ�"  + "hp�� " + hp;
    }
}
class Command extends Building implements IMove {
    private int energy;
	
	private boolean flying;
    private Point location;
	
    public Command(String name, int hp, Point location) {
        super(name, hp);
        setFlying(false);
		setLocation(location);
   }
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
	 public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }
  
    public void fly() {
        if(isFlying() == false) {
            setFlying(true);
            System.out.println(getName() + " �������� ���");
        } 
    }
	@Override
	public void move(Point p) {
		setLocation(p);
	}
    @Override
    public String toString() {
        return super.toString();
    }
}
class UnitTest {
    public static void main(String[] args) {
        // ���� String name, int hp, double moveSpeed, String tribe, int power,
        // �׶� String name, int hp, double moveSpeed, String tribe, int heal, int energy
        // �����佺 String name, int hp, double moveSpeed, String tribe, int shield, int
        // power
       /* Zealot z1 = new Zealot("����", 100, 1.875, "�����佺", 16, 60);
        
        Building b = new Command("Ŀ�ǵ�", 10);
		
		
        System.out.println(z1);
        System.out.println();
        z1.move(5, 5); // �̵�
        z1.moveUpgrade(); // �̵� ����
        z1.move(10, 10);
        z1.powerUpgrade();// 1�ܰ�
        z1.powerUpgrade();// 2�ܰ�
        z1.powerUpgrade();// 3�ܰ�
        z1.powerUpgrade();// ���۾ȵ�
        System.out.println("power : " + z1.getPower());
        System.out.println();
        System.out.println();
        Medic m = new Medic("�޵�", 60, 1.875, "�׶�", 5, 200);
        System.out.println(m);

        m.maxEnergyUpgrade();// �ִ� ������ 250
        System.out.println("�ִ뿡���� : " + m.getEnergy());

        System.out.println("hp : " + m.getHp() + ", �̵��ӵ� : " + m.getMoveSpeed());
        System.out.println();
        Mutallisk mt = new Mutallisk("��Ż����ũ", 120, 3.126, "����", 9);
        System.out.println(mt);
        System.out.println();
        System.out.println();
        System.out.println("power : " + mt.getPower());
        mt.powerUpgrade();// 1�ܰ�
        mt.powerUpgrade();// 2�ܰ�
        mt.powerUpgrade();// 3�ܰ�
        mt.powerUpgrade();// ���۾ȵ�
        System.out.println("power : " + mt.getPower());

        
		Command c = (Command) b;
        c.fly();
        z1.attack(c);
        mt.attack(c);
		Zealot z2 = new Zealot("����", 20, 1.875, "�����佺", 16, 60);
		
        mt.attack(z2);
		mt.attack(z2);
		mt.attack(z2);
		mt.attack(z2);
		*/
    }
}