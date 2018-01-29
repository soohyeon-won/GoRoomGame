package week7.zuul13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Player {

	private Room currentRoom;
	private Stack<Room> pastRooms;
	private ArrayList<Item> items;
	private int maxWeight;

	/**
	 * 구성자
	 * @param startRoom 이 선수가 처음 게임을 시작할 방
	 * @param maxWeight 이선수가 들고 갈 수 있는 아이템들의 최대 무게
	 */
	public Player(Room startRoom, int maxWeight){
		currentRoom = startRoom;
		pastRooms = new Stack<Room>();
		this.maxWeight = maxWeight;
		items = new ArrayList<Item>();
	}
	

	//이전방으로 돌아감
	public void back(){
		if(!pastRooms.empty())
			currentRoom = pastRooms.pop();
	}
	/**
	 * 선수가 가지고 있는 아이템들의 ArrayList반환
	 */
	public List<Item> getItems(){
		return Collections.unmodifiableList(items);
	}

	//들 수 있는 최대 무게
	public int getMaxWeight(){
		return maxWeight;
	}

	/**
	 * 아이템을 집는다
	 * @param name 아이템 이름
	 * @return 집어든 아이템(성공시), null(실패시)
	 */
	public Item takeItem(String name){
		Item item = currentRoom.removeItem(name);
		if(item != null){
			if(pickable(item))
				items.add(item);
			else{
				currentRoom.addItem(item);
				item = null;
			}
		}
		return item;
	}
	/**
	 * 가지고 있는 아이템 중 하나를 내려 놓는다.
	 * @param name 내려놓을 아이템 이름
	 * @return 내려놓은 아이템(성공시) , null(실패시)
	 */
	public Item dropItem(String name){
		Iterator<Item> it = items.iterator();
		while (it.hasNext()){
			Item item = it.next();
			if(item.getName().equals(name)){
				it.remove();
				currentRoom.addItem(item);
				return item;
			}
		}
		return null;
	}
	
	public Item removeItem(String name){
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item item = it.next();
		if(item.getName().equals(name)){
			it.remove();
			return item;
		}
		}
		return null;
	}
	/**
	 * 주어진 방향으로 옮겨간다.
	 * 출구가 없으면 현재 위치에 머무른다.
	 * @param direction 옮겨갈 방향
	 * @return 성공 0, 실패 -1
	 */
	int moveTo(String direction){

		Room nextRoom = null;
		nextRoom = currentRoom.getExit(direction);

		if(nextRoom != null){
			return -1;
		}
		else
			pastRooms.push(currentRoom);
			currentRoom = nextRoom;
			return 0;

	}
	/*
	 * 가지고 있는 아이템들의 총 무게를 알아낸다.
	 */
	private int totalWeight(){
		Iterator<Item> it = items.iterator();
		int sum =0;
		while(it.hasNext())
			sum += it.next().getWeight();
		return sum;
	}
	/**
	 * 지정된 아이템이 집어 들 수 있는 무게인지 판별
	 * @param item 판별할 아이템
	 * @return 집어들수있으면 true 아니면 false
	 */
	boolean pickable(Item item){
		if(item.getWeight() + totalWeight()>maxWeight)
			return false;
		else
			return true;
	}



	//현재 방을 반환
	public Room getCurrentRoom(){
		return currentRoom;

	}
}
