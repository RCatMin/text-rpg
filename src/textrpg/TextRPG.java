package textrpg;

import controlManage.IOControl;
import stage.Lobby;

public class TextRPG {
	private Lobby lobby;
	private boolean isRun = true;
	
	private TextRPG() {
		this.lobby = new Lobby(); 
	}
	
	private static TextRPG instance = new TextRPG();
	
	public static TextRPG getInstance() {
		return instance;
	}
	
	public void run() {
		start();
		String input = IOControl.inputString("\n여기에 입력하세요 : ");
		if (input.equals("시작")) {
			isRun = lobby.activate();
		} else if (input.equals("종료")) {
			shutDown();
			isRun = false;
		}
		
		if (isRun == false) {
			return;
		}
	}
	
	private void start() {
		IOControl.printString("게임을 시작하려면 '시작' 이라고 입력하세요\n아니면 아무 키를 입력하세요");
	}

	private void shutDown() {
		IOControl.printString("게임을 종료합니다.");
	}
}