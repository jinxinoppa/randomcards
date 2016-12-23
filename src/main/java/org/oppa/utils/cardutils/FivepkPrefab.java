package org.oppa.utils.cardutils;

public class FivepkPrefab {

	private int prefabCards;
//	private String prefab0;
//	private String prefab1;
//	private String prefab2;
//	private String prefab3;
//	private String prefab4;
//	private String prefab5;
//	private String prefab6;
//	private String prefab7;
	private int prefab0;
	private int prefab1;
	private int prefab2;
	private int prefab3;
	private int prefab4;
	private int prefab5;
	private int prefab6;
	private int prefab7;

//	public FivepkPrefab(int prefabCards, String prefab0, String prefab1, String prefab2, String prefab3, String prefab4, String prefab5, String prefab6, String prefab7) {
//		this.prefabCards = prefabCards;
//		this.prefab0 = prefab0;
//		this.prefab1 = prefab1;
//		this.prefab2 = prefab2;
//		this.prefab3 = prefab3;
//		this.prefab4 = prefab4;
//		this.prefab5 = prefab5;
//		this.prefab6 = prefab6;
//		this.prefab7 = prefab7;
//	}
	public FivepkPrefab(int prefabCards, int prefab0, int prefab1, int prefab2, int prefab3, int prefab4, int prefab5, int prefab6, int prefab7) {
		this.prefabCards = prefabCards;
		this.prefab0 = prefab0;
		this.prefab1 = prefab1;
		this.prefab2 = prefab2;
		this.prefab3 = prefab3;
		this.prefab4 = prefab4;
		this.prefab5 = prefab5;
		this.prefab6 = prefab6;
		this.prefab7 = prefab7;
	}

	public int getPrefab(int prefab) {
		switch (prefab) {
			case 0 :
				return prefab0;
			case 1 :
				return prefab1;
			case 2 :
				return prefab2;
			case 3 :
				return prefab3;
			case 4 :
				return prefab4;
			case 5 :
				return prefab5;
			case 6 :
				return prefab6;
			case 7 :
				return prefab7;
			default :
				throw new RuntimeException();
		}
	}
	public int getPrefabCards() {
		return prefabCards;
	}
	public void setPrefabCards(int prefabCards) {
		this.prefabCards = prefabCards;
	}

	public int getPrefab0() {
		return prefab0;
	}

	public void setPrefab0(int prefab0) {
		this.prefab0 = prefab0;
	}

	public int getPrefab1() {
		return prefab1;
	}

	public void setPrefab1(int prefab1) {
		this.prefab1 = prefab1;
	}

	public int getPrefab2() {
		return prefab2;
	}

	public void setPrefab2(int prefab2) {
		this.prefab2 = prefab2;
	}

	public int getPrefab3() {
		return prefab3;
	}

	public void setPrefab3(int prefab3) {
		this.prefab3 = prefab3;
	}

	public int getPrefab4() {
		return prefab4;
	}

	public void setPrefab4(int prefab4) {
		this.prefab4 = prefab4;
	}

	public int getPrefab5() {
		return prefab5;
	}

	public void setPrefab5(int prefab5) {
		this.prefab5 = prefab5;
	}

	public int getPrefab6() {
		return prefab6;
	}

	public void setPrefab6(int prefab6) {
		this.prefab6 = prefab6;
	}

	public int getPrefab7() {
		return prefab7;
	}

	public void setPrefab7(int prefab7) {
		this.prefab7 = prefab7;
	}

}
