package com.mzm.firephoenix.cardutils;

public class CardResult {
	private byte winType = 0;
	private boolean win = false;
	private byte[] cards = null;
	private byte[] keepCards = null;

	public byte getWinType() {
		return winType;
	}

	public void setWinType(byte winType) {
		this.winType = winType;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
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
//		this.keepCards = keepCards;
	}

	public void setAfterWin(boolean win, byte[] keepCards) {
		this.win = win;
		this.keepCards = keepCards;
	}
}
