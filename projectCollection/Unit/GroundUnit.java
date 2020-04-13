abstract class GroundUnit extends Unit {
    public GroundUnit(String name, int hp, double moveSpeed, String tribe) {
        super(name, hp, moveSpeed, tribe);
    }

    @Override
    public String toString() {
        return "<<<지상유닛>>>\n" + super.toString();
    }
}