package org.oppa.utils.cardutils;

import java.util.Date;

public class FivepkSeoId {
	private long autoId;
	private String seoId;
	private String seoMachineId;
	private int seoMachineType;
	private long accountId;
	private Date seoMachineStayTime;

	private byte prefabFiveBars = 7;
	private int prefabFiveBarsCount;
	private byte prefabRoyalFlush = 6;
	private int prefabRoyalFlushCount;
	private byte prefabFiveOfAKind = 6;
	private int prefabFiveOfAKindCount;
	private byte prefabStraightFlush = 4;
	private int prefabStraightFlushCount;
	private byte prefabFourOfAKindJOKER = 5;
	private int prefabFourOfAKindJOKERCount;
	private long seoMachinePlayCount;

	public byte getPrefab(int prefabCards) {
		switch (prefabCards) {
			case 80 :
				return prefabFourOfAKindJOKER;
			case 120 :
				return prefabStraightFlush;
			case 250 :
				return prefabFiveOfAKind;
			case 500 :
				return prefabRoyalFlush;
			case 1000 :
				return prefabFiveBars;
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
	public byte getPrefabFourOfAKindJOKER() {
		return prefabFourOfAKindJOKER;
	}
	public void setPrefabFourOfAKindJOKER(byte prefabFourOfAKindJOKER) {
		this.prefabFourOfAKindJOKER = prefabFourOfAKindJOKER;
	}
	public long getSeoMachinePlayCount() {
		return seoMachinePlayCount;
	}
	public void setSeoMachinePlayCount(long seoMachinePlayCount) {
		this.seoMachinePlayCount = seoMachinePlayCount;
	}

	public int getPrefabFiveBarsCount() {
		return prefabFiveBarsCount;
	}

	public void setPrefabFiveBarsCount(int prefabFiveBarsCount) {
		this.prefabFiveBarsCount = prefabFiveBarsCount;
	}

	public int getPrefabRoyalFlushCount() {
		return prefabRoyalFlushCount;
	}

	public void setPrefabRoyalFlushCount(int prefabRoyalFlushCount) {
		this.prefabRoyalFlushCount = prefabRoyalFlushCount;
	}

	public int getPrefabFiveOfAKindCount() {
		return prefabFiveOfAKindCount;
	}

	public void setPrefabFiveOfAKindCount(int prefabFiveOfAKindCount) {
		this.prefabFiveOfAKindCount = prefabFiveOfAKindCount;
	}

	public int getPrefabStraightFlushCount() {
		return prefabStraightFlushCount;
	}

	public void setPrefabStraightFlushCount(int prefabStraightFlushCount) {
		this.prefabStraightFlushCount = prefabStraightFlushCount;
	}

	public int getPrefabFourOfAKindJOKERCount() {
		return prefabFourOfAKindJOKERCount;
	}

	public void setPrefabFourOfAKindJOKERCount(int prefabFourOfAKindJOKERCount) {
		this.prefabFourOfAKindJOKERCount = prefabFourOfAKindJOKERCount;
	}
}
