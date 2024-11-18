package units;

public abstract class Unit {
	String name; // 이름
	int level; // 레벨
	int hp; // 체력
	int maxHp; // 최대 HP
	int att; // 공격
	int def; // 방어
	int exp; // 경험치
	boolean party; // 파티 가입 여부
	Item weapon; // 무기
	Item armor; // 갑옷
	Item ring; // 장신구
	String rarity = "일반";

	Unit() {
		
	}

	public Unit(String name, int level, int hp, int att, int def, int exp) {
		
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		party = false;
		weapon = null;
		armor = null;
		ring = null;
	}

	// 생성자 오버로딩
	public Unit(String name, int level, int hp, int att, int def, int exp, boolean party) {
		super();
		this.name = name;
		this.level = level;
		this.maxHp = hp;
		this.hp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.party = party;
		weapon = null;
		armor = null;
		ring = null;
	}
}