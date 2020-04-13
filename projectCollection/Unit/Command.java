class Command extends MovingBuilding {
    private int energy;
   
    public Command(String name, int hp) {
        super(name, hp);
        setFlying(false);
   }
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}