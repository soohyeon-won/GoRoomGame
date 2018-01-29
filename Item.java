package week7.zuul13;
/**
 * 게임에서 나오는 아이템을 생성할 클래스
 * 이름, 설명, 무게를 필드로 가진다.
 * @author 원수현
 *
 */
public class Item {

	private String name; //아이템의 이름
	private String description; //아이템의 설명
	private int weight; //아이템의 무게
	
	//class Item의 구성자
	public Item(String name, String description, int weight){
	this.name=name;
	this.description = description;
	this.weight=weight;
	}
	/**
	 * 아이템의 이름 반환
	 * @return 아이템이름
	 */
	public String getName(){
		return name;
	}
	/**
	 * 아이템의 설명 반환
	 * @return 아이템 설명
	 */
	public String getDescriotion(){
		return description;
	}
	/**
	 * 아이템의 무게 반환
	 * @return 아이템 무게
	 */
	public int getWeight(){
		return weight;
	}
	/**
	 * Room에 있는 Item에 대한 설명문
	 */
	public String getLongDescription(){
		return name + "(무게" + weight + "," + description+")";
	}
	
}
