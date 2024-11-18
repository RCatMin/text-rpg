package units;

import controlManage.IOControl;

public class Player extends Unit{

	String name; // 이름
	int level; // 레벨
	int hp;
	int maxHp; // 최대 HP
	int att; // 공격
	int def; // 방어
	int exp; // 경험치
	boolean party; // 파티 가입 여부

	public Player() {
		
	}

	public Player(String name, int level, int maxHp, int att, int def, int exp) {
		super (name, level, maxHp, att, def, exp);
	}

	public Player(String name, int level, int maxHp, int att, int def, int exp, boolean party) {
		super (name, level, maxHp, att, def, exp, party);
	}
	
	public void printPlayer() {
		String info = String.format("이름 : %10s\n레벨 : %3d\n체력 : %5d/%5d\n공격력/방어력 : %3d/%3d", name, level, hp, maxHp, att, def);
		IOControl.printString(info);
	}
}
