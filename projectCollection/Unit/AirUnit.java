abstract class AirUnit extends Unit {
    public AirUnit(String name, int hp, double moveSpeed, String tribe) {
        super(name, hp, moveSpeed, tribe);
    }

    @Override
    public String toString() {
        return "<<<공중유닛>>>\n" + super.toString();
    }
}