package stage;

import java.util.HashMap;
import java.util.Map;

import controlManage.IOControl;

public class Inventory implements Stage{

	Map <String, inventory.Inventory> inventoryMenu;
	Map <String, Stage> stageMenu;
	
	// 인벤토리 기능 저장 위치 설정
	public Inventory() {
		inventoryMenu = new HashMap<String, inventory.Inventory>();
	}
	
	// 메인 메뉴 뒤돌아가기
	public void CheckBack() {
		stageMenu = new HashMap<String, Stage>();
		stageMenu.put("뒤로가기", (Stage) new Lobby());
	}
	
	public void activate() {
		inventoryMenu();
		while (true) {
			// 장비 착용, 판매, 강화가 입력되면 해당 기능이 activate
			String selectMenu = IOControl.inputString("\n여기에 입력하세요 : ");
			if (inventoryMenu.containsKey(selectMenu)) {
				inventoryMenu.get(selectMenu).activate();
			}
			
			// 뒤로가기가 입력되면 Lobby로 돌아감
			if (stageMenu.containsKey(selectMenu)) {
				stageMenu.get(selectMenu).activate();
			}
		}
	}
	
	public void inventoryMenu() {
		String message = """
				============================================
									메인 로비
			
				[장비 착용]	[장비 판매]	[장비 강화]	[뒤로가기]
				
				============================================
				""";
		IOControl.printString(message);
	}

}
