package stage;

import java.util.ArrayList;

import controlManage.IOControl;
import controlManage.UnitDataControl;
import units.Item;

public class Store implements Stage {
	private ArrayList<Item> items;
	private final int NUMBER = 1;

	private void shop() {
		items = new ArrayList<Item>();
		initializeItem();
	}

	public void activate() {
		printShop();
		while (true) {
			int inputMenu = (int) IOControl.input("\n여기에 입력하세요 : ", NUMBER);

			if (inputMenu == 0) {
				break;
			} else if (isValidInputMenu(inputMenu)) {
				purchaseItem(inputMenu);
			}
		}
	}

	private boolean isValidInputMenu(int menu) {
		if (menu >= 1 && menu < items.size()) {
			return true;
		} else {
			return false;
		}
	}

	private void purchaseItem(int menu) {
		Item item = items.get(menu - 1);
		int itemPrice = item.getPrice();
		// 유저 정보 불러오기
		int userMoney = UnitDataControl.getMoney();

		if (itemPrice > userMoney) {
			// 구매실패 메소드
			printFailedPurchaseItem();
			return;
		}

		UnitDataControl.setMoney(userMoney - itemPrice);
		int type = item.getType();
		String rarity = item.getRarity();
		String name = item.getName();
		int power = item.getPower();
		int price = item.getPrice();

		UnitDataControl.addItemList(new Item(type, rarity, name, power, price));
		// 구매완료 메소드
		printPurchaseItem();
	}

	private void printFailedPurchaseItem() {
		String message = """
				===================================================
								아이템 구매에 실패하였습니다.
				===================================================
				""";

		IOControl.printString(message);
	}

	private void printPurchaseItem() {
		String message = """
				===================================================
									** 구매 완료 **
							상점에서 나가신 후 인벤토리를 확인하세요.
				===================================================
				""";

		IOControl.printString(message);

	}

	private void initializeItem() {
		// 무기 (power를 공격력으로)
		items.add(new Item(1, "전설", "몰락한 왕의 검", 60, 4000));
		items.add(new Item(1, "전설", "삼위일체", 33, 3333));
		items.add(new Item(1, "전설", "라바돈의 죽음모자", 130, 6000));
		items.add(new Item(1, "전설", "벤시의 장막", 105, 4500));
		items.add(new Item(1, "서사", "랜서 경의 총", 25, 1600));
		items.add(new Item(1, "서사", "야수화", 15, 1200));
		items.add(new Item(1, "서사", "마법공학 교류 발전기", 20, 1500));
		items.add(new Item(1, "서사", "에테르 환영", 12, 1100));
		// 방어구 (power를 회피율로)
		items.add(new Item(2, "전설", "얼어붙은 심장", 80, 7000));
		items.add(new Item(2, "전설", "대자연의 힘", 72, 6300));
		items.add(new Item(2, "전설", "망자의 갑옷", 77, 6700));
		items.add(new Item(2, "전설", "워모그의 갑옷", 100, 10000));
		items.add(new Item(2, "서사", "파수꾼의 갑옷", 40, 3000));
		items.add(new Item(2, "서사", "비상의 월갑", 35, 2700));
		items.add(new Item(2, "서사", "점화석", 33, 2600));
		items.add(new Item(2, "서사", "바미의 불씨", 37, 2950));
		// 장신구
		items.add(new Item(3, "서사", "월석 재생기", 10, 2200));
		items.add(new Item(3, "서사", "기사의 맹세", 25, 2700));
		items.add(new Item(3, "전설", "불타는 향로", 60, 5500));
		items.add(new Item(3, "전설", "커튼콜", 44, 4444));
	}

	public void printShop() {
		String headMessage = """
				===================================================
								 		상 점

				[아이템 번호]	[타입]	[등급]	[상품명]	 [공격력]	   [가격]
				""";
		IOControl.printString(headMessage);

		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);

			if (item.getType() == 1) {
				IOControl.printString(String.format("%d 무 기	[%2s] [%11s] [%2d] [%5d]", i + 1, item.getRarity(),
						item.getName(), item.getPower(), item.getPrice()));
			} else if (item.getType() == 2) {
				IOControl.printString(String.format("%d 방어구	[%2s] [%11s] [%2d] [%5d]", i + 1, item.getRarity(),
						item.getName(), item.getPower(), item.getPrice()));
			} else if (item.getType() == 3) {
				IOControl.printString(String.format("%d 장신구	[%2s] [%11s] [%2d] [%5d]", i + 1, item.getRarity(),
						item.getName(), item.getPower(), item.getPrice()));
			}
		}

		String endMessage = """
				===================================================
							각 아이템의 번호를 입력하시면 구매 가능
							나가시려면 [0]을 입력하세요.
				===================================================
				""";
		IOControl.printString(endMessage);
	}
}
