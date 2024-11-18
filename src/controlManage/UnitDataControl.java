package controlManage;

import java.util.ArrayList;

import units.Item;
import units.Player;

public class UnitDataControl {
	private static int money;
	private static ArrayList <Player> playerList;
	private static ArrayList <Player> partyList;
	private static ArrayList <Item> itemsList;
	
	private UnitDataControl() {
		playerList = new ArrayList <Player>();
		partyList = new ArrayList <Player>();
		itemsList = new ArrayList <Item>();
		money = 1000;
	}
	
	private static UnitDataControl instance = new UnitDataControl();
	
	public static UnitDataControl getInstance() {
		return instance;
	}
	
	public static void setPlayerData(int money, ArrayList <Item> itemList) {
		UnitDataControl.money = money;
		UnitDataControl.itemsList = itemList;
	}
	
	public static void addItemList (Item item) {
		UnitDataControl.itemsList.add(item);
	}
	
	public static ArrayList<Item> getItemList(){
		return itemsList;
	}
	
	public static int getMoney() {
		return money;
	}
	
	public static void setMoney(int money) {
		UnitDataControl.money = money;
	}
	
}
