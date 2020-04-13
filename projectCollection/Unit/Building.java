abstract class Building {
    private String name;
    private int hp;
    private boolean destroy;

    public Building(String name, int hp) {
        setHp(hp);
        setName(name);
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
        return name + "을 완성"  + "hp는 " + hp;
    }
}