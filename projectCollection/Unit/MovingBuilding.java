abstract class MovingBuilding extends Building{
    private boolean flying;
    private int x;
    private int y;

    public MovingBuilding(String name, int hp) {
        super(name, hp);
        setFlying(false);
    } 
    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void fly() {
        if(isFlying() == false) {
            setFlying(true);
            System.out.println(getName() + " 공중으로 띄움");
        } 
    }
    public void move(int x, int y) {
        if(isFlying()) {
            setX(x);
            setY(y);

            System.out.println("(" + this.x  + "," + this.y + ") 로 이동");
        }
        else {
            System.out.println("건물을 띄우세요");
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }
}