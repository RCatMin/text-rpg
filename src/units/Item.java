package units;

public class Item {
	static final int WEAPON = 1; // 무기
	static final int ARMOR = 2; // 갑옷
	static final int RING = 3; // 장신구
	int type;
	String rarity; // 희귀도
	String name; // 이름
	int power; // 능력
	int price; // 가격

	// 아이템 설정 메서드
	public Item(int type, String rarity, String name, int power, int price) {
		this.type = type;
		this.rarity = rarity;
		this.name = name;
		this.power = power;
		this.price = price;
	}
	
	public int getType() {
		return type;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getPrice() {
		return price;
	}

}
