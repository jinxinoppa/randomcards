package com.mzm.firephoenix.cardutils;

public class CardResult {
	private int winType = 0;
	private boolean win = false;
	private byte[] cards = null;
	private byte[] keepCards = null;
	private int physicalNumberOfRow;
	// private byte[] sortedCards = null;
	private int score = 0;

	public int getWinType() {
		return winType;
	}

	public void setWinType(int winType) {
		this.winType = winType;
	}

	protected boolean isWin() {
		return win;
	}

	protected void setWin(boolean win) {
		this.win = win;
	}

	public byte[] getCards() {
		return cards;
	}

	public void setCards(byte[] cards) {
		this.cards = cards;
	}

	public byte[] getKeepCards() {
		return keepCards;
	}

	public void setKeepCards(byte[] keepCards) {
		this.keepCards = keepCards;
	}

	public void setAfterWin(boolean win, byte[] keepCards) {
		this.win = win;
		this.keepCards = keepCards;
	}

	protected int getPhysicalNumberOfRow() {
		return physicalNumberOfRow;
	}

	protected void setPhysicalNumberOfRow(int physicalNumberOfRow) {
		this.physicalNumberOfRow = physicalNumberOfRow;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
