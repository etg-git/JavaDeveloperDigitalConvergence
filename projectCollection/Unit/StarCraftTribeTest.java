class StarCraftTribeTest {
    public static void main(String[] args) {
        // 저그 String name, int hp, double moveSpeed, String tribe, int power,
        // 테란 String name, int hp, double moveSpeed, String tribe, int heal, int energy
        // 프로토스 String name, int hp, double moveSpeed, String tribe, int shield, int
        // power
        Zealot z1 = new Zealot("질럿", 100, 1.875, "프로토스", 16, 60);
        
        MovingBuilding b = new Command("커맨드", 10);
        System.out.println(z1);
        System.out.println();
        z1.move(5, 5); // 이동
        z1.moveUpgrade(); // 이동 업글
        z1.move(10, 10);
        z1.powerUpgrade();// 1단계
        z1.powerUpgrade();// 2단계
        z1.powerUpgrade();// 3단계
        z1.powerUpgrade();// 업글안됨
        System.out.println("power : " + z1.getPower());
        System.out.println();
        System.out.println();
        Medic m = new Medic("메딕", 60, 1.875, "테란", 5, 200);
        System.out.println(m);

        m.maxEnergyUpgrade();// 최대 에너지 250
        System.out.println("최대에너지 : " + m.getEnergy());

        System.out.println("hp : " + m.getHp() + ", 이동속도 : " + m.getMoveSpeed());
        System.out.println();
        Mutallisk mt = new Mutallisk("뮤탈리스크", 120, 3.126, "저그", 9);
        System.out.println(mt);
        System.out.println();
        System.out.println();
        System.out.println("power : " + mt.getPower());
        mt.powerUpgrade();// 1단계
        mt.powerUpgrade();// 2단계
        mt.powerUpgrade();// 3단계
        mt.powerUpgrade();// 업글안됨
        System.out.println("power : " + mt.getPower());

        mt.attack(z1);
        z1.attack(z1);

        m.heal(z1);
        m.heal(m);

        b.fly();
        z1.attack(b);
        mt.attack(b);

        
    }
}