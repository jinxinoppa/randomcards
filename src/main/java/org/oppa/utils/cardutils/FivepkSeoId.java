package org.oppa.utils.cardutils;

import java.util.Date;

public class FivepkSeoId {
	private long autoId;
	private String seoId;
	private String seoMachineId;
	private int seoMachineType;
	private long accountId;
	private Date seoMachineStayTime;

	private byte prefabFiveBars;
	private double prefabFiveBarsCount;
	private byte prefabRoyalFlush;
	private double prefabRoyalFlushCount;
	private byte prefabFiveOfAKind;
	private double prefabFiveOfAKindCount;

	private int prefabFiveOfAKindCompare;

	private byte prefabStraightFlush;
	private double prefabStraightFlushCount;
	private byte prefabFourOfAKindJoker;
	private double prefabFourOfAKindJokerCount;

	private int prefabFourOfAKindJokerTwoFourteen;

	private byte prefabFourOfAKindJA;
	private double prefabFourOfAKindJACount;
	private byte prefabFourOfAKindJa;

	private byte prefabFourOfAKindTT;
	private double prefabFourOfAKindTTCount;

	private byte prefabFourOfAKindTwoTen;
	
	private byte prefabFourOfAKindTwoTenTwo;
	private String prefabFourOfAKindTwoTenContinue;
	
	private byte prefabFullHouse;
	private byte prefabFlush;
	private byte prefabStraight;
	private byte prefabThreeOfAKind;
	private byte prefabTwoPairs;
	private byte prefabSevenBetter;
	private byte prefabFourFlush;
	private byte prefabFourStraight;
	private byte prefabSevenBetterKeep;
	
	private byte prefabJoker;

	private long seoMachinePlayCount;
	private int machineAuto;
	private String compareHistoryCards;

	private byte prefabForceSevenBetter;
	private byte prefabForceSevenBetterCount;
	
	
	private int prefabCompareBuff;
	private byte prefabCompareCutDown;
	private byte prefabCompareCutDownCount;
	private byte prefabCompareSevenJoker;
	
	public int getMachineAuto() {
		return machineAuto;
	}

	public void setMachineAuto(int machineAuto) {
		this.machineAuto = machineAuto;
	}

	public byte getPrefab(int prefabCards) {
		switch (prefabCards) {
			case -3 :
				return prefabSevenBetterKeep;
			case -2 :
				return prefabFourStraight;
			case -1 :
				return prefabFourFlush;
			case 1 :
				return prefabSevenBetter;
			case 2 :
				return prefabTwoPairs;
			case 3 :
				return prefabThreeOfAKind;
			case 5 :
				return prefabStraight;
			case 7 :
				return prefabFlush;
			case 10 :
				return prefabFullHouse;
			case 48 :
				return prefabFourOfAKindTwoTenTwo;	
			case 49 :
				return prefabFourOfAKindTT;
			case 50 :
				return prefabFourOfAKindTwoTen;
			case 78 :
				return prefabFourOfAKindJA;
			case 79 :
				return prefabFourOfAKindJa;
			case 80 :
				return prefabFourOfAKindJoker;
			case 120 :
				return prefabStraightFlush;
			case 250 :
				return prefabFiveOfAKind;
			case 500 :
				return prefabRoyalFlush;
			case 1000 :
				return prefabFiveBars;
			case 9997 :
				return prefabCompareCutDown;
			case 9998 :
				return prefabForceSevenBetter;
			case 9999 :
				return prefabJoker;
			default :
				throw new NoSuchFieldError("no such field :[" + prefabCards + "]");
		}
	}

	public long getAutoId() {
		return autoId;
	}
	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}
	public String getSeoId() {
		return seoId;
	}
	public void setSeoId(String seoId) {
		this.seoId = seoId;
	}
	public String getSeoMachineId() {
		return seoMachineId;
	}
	public void setSeoMachineId(String seoMachineId) {
		this.seoMachineId = seoMachineId;
	}
	public int getSeoMachineType() {
		return seoMachineType;
	}
	public void setSeoMachineType(int seoMachineType) {
		this.seoMachineType = seoMachineType;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public Date getSeoMachineStayTime() {
		return seoMachineStayTime;
	}
	public void setSeoMachineStayTime(Date seoMachineStayTime) {
		this.seoMachineStayTime = seoMachineStayTime;
	}
	public byte getPrefabFiveBars() {
		return prefabFiveBars;
	}
	public void setPrefabFiveBars(byte prefabFiveBars) {
		this.prefabFiveBars = prefabFiveBars;
	}
	public byte getPrefabRoyalFlush() {
		return prefabRoyalFlush;
	}
	public void setPrefabRoyalFlush(byte prefabRoyalFlush) {
		this.prefabRoyalFlush = prefabRoyalFlush;
	}
	public byte getPrefabFiveOfAKind() {
		return prefabFiveOfAKind;
	}
	public void setPrefabFiveOfAKind(byte prefabFiveOfAKind) {
		this.prefabFiveOfAKind = prefabFiveOfAKind;
	}
	public byte getPrefabStraightFlush() {
		return prefabStraightFlush;
	}
	public void setPrefabStraightFlush(byte prefabStraightFlush) {
		this.prefabStraightFlush = prefabStraightFlush;
	}
	public long getSeoMachinePlayCount() {
		return seoMachinePlayCount;
	}
	public void setSeoMachinePlayCount(long seoMachinePlayCount) {
		this.seoMachinePlayCount = seoMachinePlayCount;
	}

	public double getPrefabFiveBarsCount() {
		return prefabFiveBarsCount;
	}

	public void setPrefabFiveBarsCount(double prefabFiveBarsCount) {
		this.prefabFiveBarsCount = prefabFiveBarsCount;
	}

	public double getPrefabRoyalFlushCount() {
		return prefabRoyalFlushCount;
	}

	public void setPrefabRoyalFlushCount(double prefabRoyalFlushCount) {
		this.prefabRoyalFlushCount = prefabRoyalFlushCount;
	}

	public double getPrefabFiveOfAKindCount() {
		return prefabFiveOfAKindCount;
	}

	public void setPrefabFiveOfAKindCount(double prefabFiveOfAKindCount) {
		this.prefabFiveOfAKindCount = prefabFiveOfAKindCount;
	}

	public double getPrefabStraightFlushCount() {
		return prefabStraightFlushCount;
	}

	public void setPrefabStraightFlushCount(double prefabStraightFlushCount) {
		this.prefabStraightFlushCount = prefabStraightFlushCount;
	}

	public byte getPrefabFourOfAKindJoker() {
		return prefabFourOfAKindJoker;
	}

	public void setPrefabFourOfAKindJoker(byte prefabFourOfAKindJoker) {
		this.prefabFourOfAKindJoker = prefabFourOfAKindJoker;
	}

	public double getPrefabFourOfAKindJokerCount() {
		return prefabFourOfAKindJokerCount;
	}

	public void setPrefabFourOfAKindJokerCount(double prefabFourOfAKindJokerCount) {
		this.prefabFourOfAKindJokerCount = prefabFourOfAKindJokerCount;
	}

	public byte getPrefabFourOfAKindJa() {
		return prefabFourOfAKindJa;
	}

	public void setPrefabFourOfAKindJa(byte prefabFourOfAKindJa) {
		this.prefabFourOfAKindJa = prefabFourOfAKindJa;
	}

	public byte getPrefabFourOfAKindTwoTen() {
		return prefabFourOfAKindTwoTen;
	}

	public void setPrefabFourOfAKindTwoTen(byte prefabFourOfAKindTwoTen) {
		this.prefabFourOfAKindTwoTen = prefabFourOfAKindTwoTen;
	}

	public byte getPrefabFullHouse() {
		return prefabFullHouse;
	}

	public void setPrefabFullHouse(byte prefabFullHouse) {
		this.prefabFullHouse = prefabFullHouse;
	}

	public byte getPrefabFlush() {
		return prefabFlush;
	}

	public void setPrefabFlush(byte prefabFlush) {
		this.prefabFlush = prefabFlush;
	}

	public byte getPrefabStraight() {
		return prefabStraight;
	}

	public void setPrefabStraight(byte prefabStraight) {
		this.prefabStraight = prefabStraight;
	}

	public byte getPrefabThreeOfAKind() {
		return prefabThreeOfAKind;
	}

	public void setPrefabThreeOfAKind(byte prefabThreeOfAKind) {
		this.prefabThreeOfAKind = prefabThreeOfAKind;
	}

	public byte getPrefabTwoPairs() {
		return prefabTwoPairs;
	}

	public void setPrefabTwoPairs(byte prefabTwoPairs) {
		this.prefabTwoPairs = prefabTwoPairs;
	}

	public byte getPrefabSevenBetter() {
		return prefabSevenBetter;
	}

	public void setPrefabSevenBetter(byte prefabSevenBetter) {
		this.prefabSevenBetter = prefabSevenBetter;
	}

	public byte getPrefabFourFlush() {
		return prefabFourFlush;
	}

	public void setPrefabFourFlush(byte prefabFourFlush) {
		this.prefabFourFlush = prefabFourFlush;
	}

	public byte getPrefabFourStraight() {
		return prefabFourStraight;
	}

	public void setPrefabFourStraight(byte prefabFourStraight) {
		this.prefabFourStraight = prefabFourStraight;
	}

	public byte getPrefabSevenBetterKeep() {
		return prefabSevenBetterKeep;
	}

	public void setPrefabSevenBetterKeep(byte prefabSevenBetterKeep) {
		this.prefabSevenBetterKeep = prefabSevenBetterKeep;
	}

	public int getPrefabFiveOfAKindCompare() {
		return prefabFiveOfAKindCompare;
	}

	public void setPrefabFiveOfAKindCompare(int prefabFiveOfAKindCompare) {
		this.prefabFiveOfAKindCompare = prefabFiveOfAKindCompare;

	}

	public int getPrefabFourOfAKindJokerTwoFourteen() {
		return prefabFourOfAKindJokerTwoFourteen;
	}

	public void setPrefabFourOfAKindJokerTwoFourteen(int prefabFourOfAKindJokerTwoFourteen) {
		this.prefabFourOfAKindJokerTwoFourteen = prefabFourOfAKindJokerTwoFourteen;
	}

	public byte getPrefabFourOfAKindJA() {
		return prefabFourOfAKindJA;
	}

	public void setPrefabFourOfAKindJA(byte prefabFourOfAKindJA) {
		this.prefabFourOfAKindJA = prefabFourOfAKindJA;
	}

	public byte getPrefabFourOfAKindTT() {
		return prefabFourOfAKindTT;
	}

	public void setPrefabFourOfAKindTT(byte prefabFourOfAKindTT) {
		this.prefabFourOfAKindTT = prefabFourOfAKindTT;
	}

	public double getPrefabFourOfAKindJACount() {
		return prefabFourOfAKindJACount;
	}

	public void setPrefabFourOfAKindJACount(double prefabFourOfAKindJACount) {
		this.prefabFourOfAKindJACount = prefabFourOfAKindJACount;
	}

	public double getPrefabFourOfAKindTTCount() {
		return prefabFourOfAKindTTCount;
	}

	public void setPrefabFourOfAKindTTCount(double prefabFourOfAKindTTCount) {
		this.prefabFourOfAKindTTCount = prefabFourOfAKindTTCount;
	}

	public byte getPrefabJoker() {
		return prefabJoker;
	}

	public void setPrefabJoker(byte prefabJoker) {
		this.prefabJoker = prefabJoker;
	}

	public String getPrefabFourOfAKindTwoTenContinue() {
		return prefabFourOfAKindTwoTenContinue;
	}

	public void setPrefabFourOfAKindTwoTenContinue(String prefabFourOfAKindTwoTenContinue) {
		this.prefabFourOfAKindTwoTenContinue = prefabFourOfAKindTwoTenContinue;
	}

	public byte getPrefabFourOfAKindTwoTenTwo() {
		return prefabFourOfAKindTwoTenTwo;
	}

	public void setPrefabFourOfAKindTwoTenTwo(byte prefabFourOfAKindTwoTenTwo) {
		this.prefabFourOfAKindTwoTenTwo = prefabFourOfAKindTwoTenTwo;
	}
	
	public String getCompareHistoryCards() {
		return compareHistoryCards;
	}

	public void setCompareHistoryCards(String compareHistoryCards) {
		this.compareHistoryCards = compareHistoryCards;
	}
	public void firstInLastOut(int compareCard) {
		if (compareHistoryCards != null) {
			StringBuffer sb = new StringBuffer();
			sb.append(compareCard).append(",").append(compareHistoryCards.substring(0, compareHistoryCards.lastIndexOf(",") == -1 ? 0 : compareHistoryCards.lastIndexOf(",")));
			setCompareHistoryCards(sb.toString());
		}
	}

	public byte getPrefabForceSevenBetter() {
		return prefabForceSevenBetter;
	}

	public void setPrefabForceSevenBetter(byte prefabForceSevenBetter) {
		this.prefabForceSevenBetter = prefabForceSevenBetter;
	}

	public byte getPrefabForceSevenBetterCount() {
		return prefabForceSevenBetterCount;
	}

	public void setPrefabForceSevenBetterCount(byte prefabForceSevenBetterCount) {
		this.prefabForceSevenBetterCount = prefabForceSevenBetterCount;
	}

	public int getPrefabCompareBuff() {
		return prefabCompareBuff;
	}

	public void setPrefabCompareBuff(int prefabCompareBuff) {
		this.prefabCompareBuff = prefabCompareBuff;
	}

	public byte getPrefabCompareCutDown() {
		return prefabCompareCutDown;
	}

	public void setPrefabCompareCutDown(byte prefabCompareCutDown) {
		this.prefabCompareCutDown = prefabCompareCutDown;
	}

	public byte getPrefabCompareCutDownCount() {
		return prefabCompareCutDownCount;
	}

	public void setPrefabCompareCutDownCount(byte prefabCompareCutDownCount) {
		this.prefabCompareCutDownCount = prefabCompareCutDownCount;
	}

	public byte getPrefabCompareSevenJoker() {
		return prefabCompareSevenJoker;
	}

	public void setPrefabCompareSevenJoker(byte prefabCompareSevenJoker) {
		this.prefabCompareSevenJoker = prefabCompareSevenJoker;
	}
}
