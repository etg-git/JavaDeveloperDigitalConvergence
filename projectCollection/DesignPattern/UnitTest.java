interface IMoveUpgrade {
	void moveUpgrade();
}
interface IGroundMove {
	void move(Point move);
}
interface IAirMove {
	void move(Point move);
}
//mark interface
interface IBiology {
}
interface IAttackable {
	void attack(Unit unit);
	int getPower();
}
class GroundAttackable implements IAttackable {
	private int power;
	
	public GroundAttackable(int power) {
		setPower(power);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public void attack(Unit u) {
		if(u instanceof IGroundMove) {
			if(u.isAlive()) {
				u.setCurrentHp(u.getCurrentHp() - getPower());
			}
			if(u.isAlive() == false) {
				u.setCurrentHp(0);
				System.out.println("죽었습니다.");
			}
		}
		else {
			System.out.println("공격할 수 없습니다.");
		}
	}
	@Override
	public String toString() {
		return "power : " + power + "\n";
	}
}
class AirAttackable implements IAttackable {
	private int power;
	
	public AirAttackable(int power) {
		setPower(power);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public void attack(Unit u) {
		if(u instanceof IAirMove) {
			if(u.isAlive()) {
				u.setCurrentHp(u.getCurrentHp() - getPower());
			}
			if(u.isAlive() == false) {
				u.setCurrentHp(0);
				System.out.println("죽었습니다.");
			}
		}
		else {
			System.out.println("공격할 수 없습니다.");
		}
	}
	@Override
	public String toString() {
		return "power : " + power + "\n";
	}
}
class AllAttackable implements IAttackable {
	private int power;
	
	public AllAttackable(int power) {
		setPower(power);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public void attack(Unit u) {
		if(u.isAlive()) {
			u.setCurrentHp(u.getCurrentHp() - getPower());
		}
		if(u.isAlive() == false) {
			u.setCurrentHp(0);
			System.out.println("죽었습니다.");
		}
	}
	@Override
	public String toString() {
		return "power : " + power + "\n";
	}
}
class NoAttackable implements IAttackable {
	
	@Override
	public int getPower() {
		return 0;
	}
	@Override
	public void attack(Unit unit) {
		System.out.println("공격할수없다");
	}
	
}
abstract class Unit {
	private int currentHp;
	private String name;
	private Point location;
	private double moveSpeed;
	private boolean alive;
	public String tribe;
	private IAttackable attackable;
	
	public final int MAX_HP;
	
	public Unit(int currentHp, String name, Point location, double moveSpeed, String tribe, int max_hp) {
		setCurrentHp(currentHp);
		setName(name);
		setLocation(location);
		setMoveSpeed(moveSpeed);
		setTribe(tribe);
		MAX_HP = max_hp;
		setAlive(true);
	}
	public void performAttack(Unit unit) {
		attackable.attack(unit);
	}
	public int performPower() {
		return attackable.getPower();
	}
	public IAttackable getAttackable() {
		return attackable;
	}
	public void setAttackable(IAttackable attackable) {
		this.attackable = attackable;
	}
	public int getCurrentHp() {
		return currentHp;
	}
	public String getName() {
		return name;
	}
	public Point getLocation() {
		return location;
	}
	public double getMoveSpeed() {
		return moveSpeed;
	}
	public String getTribe() {
		return tribe;
	}
	public boolean isAlive() {
		if(currentHp <= 0) {
			return alive = false;
		}
		else {
			return alive = true;
		}
	}
	public void setCurrentHp(int currentHp) {
		if(getCurrentHp() > MAX_HP) {
			this.currentHp = MAX_HP;
		} else {
			this.currentHp = currentHp;
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public void setTribe(String tribe) {
		this.tribe = tribe;
	}
	public void setAlive(boolean alive) {
		if(currentHp <= 0) {
			setAlive(false);
			this.currentHp = 0;
		}else {
			this.currentHp = currentHp;
		}
	}
	@Override
	public String toString() {
		String info = "현재체력 : " + currentHp + "\n";
		info += "name : " + name + "\n";
		info += "location : " + location + "\n";
		info += "moveSpeed : " + moveSpeed + "\n";
		info += "tribe : "  + tribe  + "\n";
		info += "최대체력 : " + MAX_HP + "\n";
		return info;
	}
}
class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		setLocation(x,y);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")에 있음";
	}
}
class Medic extends Unit implements IBiology, IGroundMove {
	private int mana;
	private int healAmount;
	
	public Medic(int currentHp) {
		super(currentHp, "메딕", new Point(2,2) , 1.875, "테란", 50);
		setMana(200);
		setHealAmount(6);
	}
	public int getMana() {
		return mana;
	}
	private int getHealAmount() {
		return healAmount;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	@Override
	public void move(Point move) {
		setLocation(move);

		System.out.println("(" + move.getX() + "," + move.getY() + ")로 이동");
	}
	public void heal(Unit u) {
		if(u instanceof IBiology) {
			if(u.isAlive() && u.MAX_HP > u.getCurrentHp()) {
				u.setCurrentHp(u.getCurrentHp() + getHealAmount());
				setMana(getMana() - 7);

				if(u.getCurrentHp() >= u.MAX_HP) {
					u.setCurrentHp(u.MAX_HP);
					System.out.println("최대체력입니다");
				}
			}
		}
		else {
			System.out.println("힐 할 수 없는 상대입니다");
		}
	}
	@Override
	public String toString() {
		return super.toString() + "mana : " + mana + "\n" + "heaAmount : " + healAmount + "\n";
	}
}
class Zealot extends Unit implements IGroundMove, IMoveUpgrade, IBiology {
	private int shield;
	
	public Zealot(int currentHp) {
		super(currentHp, "질럿", new Point(2,2), 1.875, "프로토스", 100);
		setShield(60);
		setAttackable(new GroundAttackable(18)); 
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	@Override
	public void move(Point move) {
		setLocation(move);

		System.out.println("(" + move.getX() + "," + move.getY() + ")로 이동");
	}
	@Override
	public void moveUpgrade() {
		setMoveSpeed(2.725);

		System.out.println("발업 완료");
	}
	@Override
	public String toString() {
		return super.toString() + "shield : " + shield + "\n";
	}
}
class Mutallisk extends Unit implements IAirMove {
	public final int RECOVERY = 5;
	
	public Mutallisk(int currentHp) {
		super(currentHp, "뮤탈", new Point(2,2), 3.21, "저그", 150);
		setAttackable(new AllAttackable(18));
	}
	@Override
	public void move(Point move) {
		setLocation(move);

		System.out.println("(" + move.getX() + "," + move.getY() + ")로 이동");
	}
	@Override 
	public String toString() {
		return super.toString() + "자가힐량 : " + RECOVERY + "\n";
	}
}
class UnitTest {
	public static void main(String[] args) {
		Point zealotMove = new Point(3,3);
		
		Unit m = new Medic(50);

		//최대체력 100
		Unit z = new Zealot(90);
		
		Unit mt = new Mutallisk(90);
		System.out.println(z.performPower());

		Medic m2 = (Medic)m;
		System.out.println(z.getCurrentHp());
		m2.heal(z);
		System.out.println(z.getCurrentHp());
		m2.heal(z);
		System.out.println(z.getCurrentHp());
	
	}
}
