class StarCraftTribeTest {
	public static void main(String[] args) {
		//���� String name, int hp, double moveSpeed, String tribe, int power, String attType
		//�׶� String name, int hp, double moveSpeed, String tribe, int heal, int energy
		//�����佺 String name, int hp, double moveSpeed, String tribe, int power, String attType, int shield
		Zealot z1 = new Zealot("����", 100, 1.875, "�����佺", 16, "����", 60);
		Zealot z2 = new Zealot("����", 100, 1.875, "�����佺", 16, "����", 60);
		System.out.println(z1);
		System.out.println();		
		z1.move(5,5); //�̵�
		z1.moveUpgrade(); //�̵� ����
		z1.move(10,10);
		z1.powerUpgrade();// 1�ܰ�
		z1.powerUpgrade();// 2�ܰ�
		z1.powerUpgrade();// 3�ܰ�
		z1.powerUpgrade();// ���۾ȵ�
		System.out.println("power : " + z1.getPower());
		System.out.println();
		System.out.println();
		Medic m = new Medic("�޵�", 60, 1.875, "�׶�", 5, 200);
		System.out.println(m);
		
		m.maxEnergyUpgrade();//�ִ� ������ 250
		System.out.println("�ִ뿡���� : " + m.getEnergy());

		System.out.println("hp : " + m.getHp() + ", �̵��ӵ� : " + m.getMoveSpeed());
		System.out.println();
		Mutallisk mt = new Mutallisk("��Ż����ũ", 120, 3.126, "����", 9, "����");
		System.out.println(mt);
		System.out.println();
		System.out.println();
		System.out.println("power : " + mt.getPower());
		mt.powerUpgrade();// 1�ܰ�
		mt.powerUpgrade();// 2�ܰ�
		mt.powerUpgrade();// 3�ܰ�
		mt.powerUpgrade();// ���۾ȵ�
		System.out.println("power : " +mt.getPower());
	
		z1.attack(mt);
		mt.attack(z1);
		z1.attack(z1);

		m.heal(z1);
		m.heal(m);
	}
}
