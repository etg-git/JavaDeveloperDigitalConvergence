abstract class Unit {
    

    private String name;
    private int hp;
    private double moveSpeed;
    private String tribe;
    private int x;
    private int y;
    private boolean alive;
    

    public Unit(String name, int hp, double moveSpeed, String tribe) {
        setName(name);
        setHp(hp);
        setMoveSpeed(moveSpeed);
        setTribe(tribe);
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
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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
        this.hp = hp;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
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
    // 이동거리반환
    public void move(int x, int y) {
        setX(x);
        setY(y);
        System.out.println("(" + this.x + "," + this.y + ") 로 이동");
        System.out.println("현재위치 도착");
    }

    @Override
    public String toString() {
        String info = "hp : " + hp + "\n";
        info += "moveSpeed : " + moveSpeed + "\n";
        info += "tribe : " + tribe + "\n";
        return info;
    }
}