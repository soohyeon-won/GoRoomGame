package week7.zuul13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import week7.zuul13.Item;
import week7.zuul13.Room;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * <p>
 * Room은 게임 내 세상에서 어느 한 지점을 나타낸다.
 * Room은 exit(출구)를 통해 다른 Room과 연결된다.
 * Exit은 north, east, south, west 중 어느 하나의 방향을 갖는다.
 * <p>
 * Rooom은 동서남북 각 방향마다 
 * 그 방향으로 이웃한 방을 가리키는 참조변수를 갖는다.
 * 만약 어느 방향으로 방이 이웃해 있지 않다면 
 * 그 방향의 참조변수는 null을 저장한다. 
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
	private String description;  
	
	/**   private Room northExit;      
   private Room southExit;
   private Room eastExit;
   private Room westExit;*/
	Map<String, Room> exits = new HashMap<String, Room>();
	private ArrayList<Item> items;
	/**
	 * @param description 
	 */
	public Room(String description) 
	{
		exits = new HashMap<String, Room>();
		this.description = description;
		items = new ArrayList<Item>();
	}
	
	/**
	 * Room에서 아이템 제거
	 * @param name 제거될 아이템 이름
	 * @return 제거된 아이템(제거성공), null(제거실패)
	 */
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
	 * 현재 방에 아이템을 넣음
	 * @param item 넣을 아이템
	 */
	public void addItem(Item item){
		items.add(item);
	}


	//방의 모든 정보 표시
	public String getLongDescription(){
		String returnString = description + "\n" + getExitString();
		if ( items.size() > 0){
			returnString += "\n" + "<아이템>" + "\n";
			returnString += getItemString();
		}
		return returnString;

	}
	
	public String getItemString() {
		String returnString = "";
		for(Item item : items)
			returnString += item.getLongDescription() + "\n";
		return returnString;
	}
	/**
	 * 방의 출구들을 알려주는 문자열을 반환한다.
	 * 문자열 예 : "Exit : north west"
	 * 
	 * @return 출구가 있는 방향들을 알려주는 문자열
	 */
	public String getExitString(){
		StringBuilder s = new StringBuilder("Exit : ");

		//Map에 있는 key들을 모두 읽어냄
		Set<String> keys = exits.keySet();

		//Set에 들어 있는 문자열들을 읽어냄
		Iterator<String> it= keys.iterator();
		while(it.hasNext())
			s = s.append(it.next()+" ");

		return s.toString();
	}

	/**
	 * 지정된 방향으로 나가려고 할 때 연결되는 Room을 알려준다
	 * 
	 * @param direction 나가려고 하는 방향
	 * @return 나가려고 하는 방향으로 연결된 Room.출구X면 null
	 */
	public Room getExit(String direction){

		return exits.get(direction);

	}    

	/**
	 * @param north The north exit.
	 * @param east The east east.
	 * @param south The south exit.
	 * @param west The west exit.
	 */

	public void setExit(String direction, Room neighbor){
		if(neighbor != null)
			exits.put(direction, neighbor);
	}

	/**
	 * @return The description of the room.
	 */
	public String getDescription()
	{
		return description;
	}

}
