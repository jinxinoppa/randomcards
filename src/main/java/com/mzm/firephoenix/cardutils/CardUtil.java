package com.mzm.firephoenix.cardutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CardUtil {

	private final static byte[] cards = new byte[] {
			// 方块 A - K
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
			// 梅花 A - K
			14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
			// 红桃 A - K
			27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
			// 黑桃 A - K
			40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53 };

	private final static int joker = 53;

	static enum CardColor {
		Diamond(1), Club(2), Heart(3), Spade(4), Joker(5);
		private int cardColor;

		private CardColor(int cardColor) {
			this.cardColor = cardColor;
		}

		public int getCardColor() {
			return cardColor;
		}
	}

	static enum CardValue {
		Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(
				9), Ten(10), Jack(11), Queen(12), King(13);
		private int cardValue;

		private CardValue(int cardValue) {
			this.cardValue = cardValue;
		}

		public int getCardValue() {
			return cardValue;
		}
	}

	public static int getCardColor(int cardValue) {
		return (int) (Math.floor((cardValue - 1) / 13) + 1);
	}

	public static int getCardValue(int cardValue) {
		int value = cardValue % 13;
		if (value == 0) {
			value = 13;
		}
		return value;
	}

	public void appendCards(byte[] cardArray, XSSFSheet sheet) {
		int card = 0, cardValue = 0;
		int cardColor = 0;
		String strCardValue = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cardArray.length; i++) {
			card = cardArray[i];
			cardValue = getCardValue(card);
			switch (cardValue) {
			case 11:
				strCardValue = "J";
				break;
			case 12:
				strCardValue = "Q";
				break;
			case 13:
				strCardValue = "K";
				break;
			case 1:
				strCardValue = "A";
				break;
			default:
				strCardValue = String.valueOf(cardValue);
				break;
			}
			cardColor = getCardColor(card);
			switch (cardColor) {
			case 1:
				sb.append(", 方块 " + strCardValue);
				break;
			case 2:
				sb.append(", 梅花 " + strCardValue);
				break;
			case 3:
				sb.append(", 红桃 " + strCardValue);
				break;
			case 4:
				sb.append(", 黑桃 " + strCardValue);
				break;
			case 5:
				sb.append(", 鬼");
				break;
			default:
				break;
			}
		}
		sb.deleteCharAt(0);
		int physicalNumberOfRow = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.createRow(physicalNumberOfRow++);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(sb.toString());
	}

	public XSSFSheet getHSSFSheet(XSSFWorkbook workbook, String sheetName) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		}
		return sheet;
	}

	public void printAndExcel(String count) {
		int totalCount = Integer.valueOf(count);
		int fullHouseCount = 0;
		int flushCount = 0;
		int straightCount = 0;
		int threeOfAKindCount = 0;
		int twoPairsCount = 0;
		int sevenBetterCount = 0;
		int failCount = 0;
		int fourOfAKindJA = 0;
		int fourOfAKindTwoTen = 0;
		int straightFlush = 0;
		int fiveOfAKind = 0;
		int royalFlush = 0;
		int fiveBars = 0;
		int fourStraight = 0;
		int fourFlush = 0;
		byte[] cardArray = null;

		XSSFWorkbook workbook = new XSSFWorkbook();
		CardResult cr = new CardResult();
		for (int i = 0; i < totalCount; i++) {
			cardArray = randomCards();
			cr.setCards(cardArray);
			if (fiveBars(cardArray, cr).isWin()) {
				fiveBars++;
				appendCards(cardArray, getHSSFSheet(workbook, "五鬼"));
				continue;
			} else if (royalFlush(cardArray, cr).isWin()) {
				royalFlush++;
				appendCards(cardArray, getHSSFSheet(workbook, "同花大顺"));
				continue;
			} else if (fiveOfAKind(cardArray, cr).isWin()) {
				fiveOfAKind++;
				appendCards(cardArray, getHSSFSheet(workbook, "五梅"));
				continue;
			} else if (straightFlush(cardArray, cr).isWin()) {
				straightFlush++;
				appendCards(cardArray, getHSSFSheet(workbook, "同花小顺"));
				continue;
			} else if (fourOfAKindJA(cardArray, cr).isWin()) {
				fourOfAKindJA++;
				appendCards(cardArray, getHSSFSheet(workbook, "大四梅"));
				continue;
			} else if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
				fourOfAKindTwoTen++;
				appendCards(cardArray, getHSSFSheet(workbook, "小四梅"));
				continue;
			} else if (fullHouse(cardArray, cr).isWin()) {
				fullHouseCount++;
				appendCards(cardArray, getHSSFSheet(workbook, "葫芦"));
				continue;
			} else if (flush(cardArray, cr).isWin()) {
				flushCount++;
				appendCards(cardArray, getHSSFSheet(workbook, "同花"));
				continue;
			} else if (straight(cardArray, cr).isWin()) {
				straightCount++;
				appendCards(cardArray, getHSSFSheet(workbook, "顺子"));
				continue;
			} else if (threeOfAKind(cardArray, cr).isWin()) {
				threeOfAKindCount++;
				appendCards(cardArray, getHSSFSheet(workbook, "三条"));
				continue;
			} else if (twoPairs(cardArray, cr).isWin()) {
				twoPairsCount++;
				appendCards(cardArray, getHSSFSheet(workbook, "两对"));
				continue;
			} else if (sevenBetter(cardArray, cr).isWin()) {
				sevenBetterCount++;
				appendCards(cardArray, getHSSFSheet(workbook, "一对"));
				continue;
			} else if (fourStraight(cardArray, cr).isWin()) {
				fourStraight++;
				appendCards(cardArray, getHSSFSheet(workbook, "四张顺"));
				continue;
			} else if (fourFlush(cardArray, cr).isWin()) {
				fourFlush++;
				appendCards(cardArray, getHSSFSheet(workbook, "四张同花"));
				continue;
			} else {
				failCount++;
				// appendCards(cardArray, getHSSFSheet(workbook, "乌龙"));
			}
		}
		System.out.println("五鬼: " + fiveBars + " | "
				+ (fiveBars == 0 ? 0 : totalCount / fiveBars) + " | "
				+ div(fiveBars, totalCount));
		System.out.println("同花大顺: " + royalFlush + " | "
				+ (royalFlush == 0 ? 0 : totalCount / royalFlush) + " | "
				+ div(royalFlush, totalCount));
		System.out.println("五梅: " + fiveOfAKind + " | "
				+ (fiveOfAKind == 0 ? 0 : totalCount / fiveOfAKind) + " | "
				+ div(fiveOfAKind, totalCount));
		System.out.println("同花小顺: " + straightFlush + " | "
				+ (straightFlush == 0 ? 0 : totalCount / straightFlush) + " | "
				+ div(straightFlush, totalCount));
		System.out.println("大四梅: " + fourOfAKindJA + " | "
				+ (fourOfAKindJA == 0 ? 0 : totalCount / fourOfAKindJA) + " | "
				+ div(fourOfAKindJA, totalCount));
		System.out.println("小四梅: " + fourOfAKindTwoTen + " | "
				+ (fourOfAKindTwoTen == 0 ? 0 : totalCount / fourOfAKindTwoTen)
				+ " | " + div(fourOfAKindTwoTen, totalCount));
		System.out.println("葫芦: " + fullHouseCount + " | "
				+ (fullHouseCount == 0 ? 0 : totalCount / fullHouseCount)
				+ " | " + div(fullHouseCount, totalCount));
		System.out.println("同花: " + flushCount + " | "
				+ (flushCount == 0 ? 0 : totalCount / flushCount) + " | "
				+ div(flushCount, totalCount));
		System.out.println("顺子: " + straightCount + " | "
				+ (straightCount == 0 ? 0 : totalCount / straightCount) + " | "
				+ div(straightCount, totalCount));
		System.out.println("三条: " + threeOfAKindCount + " | "
				+ (threeOfAKindCount == 0 ? 0 : totalCount / threeOfAKindCount)
				+ " | " + div(threeOfAKindCount, totalCount));
		System.out.println("两对: " + twoPairsCount + " | "
				+ (twoPairsCount == 0 ? 0 : totalCount / twoPairsCount) + " | "
				+ div(twoPairsCount, totalCount));
		System.out.println("一对: " + sevenBetterCount + " | "
				+ (sevenBetterCount == 0 ? 0 : totalCount / sevenBetterCount)
				+ " | " + div(sevenBetterCount, totalCount));
		System.out.println("四張同花: " + fourFlush + " | "
				+ (fourFlush == 0 ? 0 : totalCount / fourFlush) + " | "
				+ div(fourFlush, totalCount));
		System.out.println("四張順: " + fourStraight + " | "
				+ (fourStraight == 0 ? 0 : totalCount / fourStraight) + " | "
				+ div(fourStraight, totalCount));
		System.out.println("乌龙: " + failCount + " | "
				+ (failCount == 0 ? 0 : totalCount / failCount) + " | "
				+ div(failCount, totalCount));
		try {
			FileOutputStream out = new FileOutputStream(new File("牌型检测.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, 10);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
	}

	// 发牌
	public static byte[] randomCards() {
		int nextInt = 0;
		boolean isRepeated = false;
		// long startTime = System.currentTimeMillis();
		byte[] cards = new byte[5];
		for (int i = 0; i < cards.length; i++) {
			nextInt = RandomUtils.nextInt(0, CardUtil.cards.length) + 1;
			for (int j = 0; j < i; j++) {
				if (nextInt != CardUtil.cards.length && cards[j] == nextInt) {
					isRepeated = true;
					break;
				}
			}
			if (isRepeated) {
				isRepeated = false;
				i--;
				continue;
			}
			cards[i] = (byte) nextInt;
		}
		return cards;
	}

	public static CardResult sevenBetter(byte[] cards, CardResult cr) {
		int card = 0, firstCardValue = 0, secondCardValue = 0;
		boolean hasJoker = false;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				hasJoker = true;
				continue;
			}
			firstCardValue = getCardValue(card);
			if (firstCardValue >= 7 || firstCardValue == 1) {
				if (hasJoker) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
				for (int j = i + 1; j < cards.length; j++) {
					card = cards[j];
					if (card == joker) {
						hasJoker = true;
						cr.setWin(true);
						cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
						return cr;
					}
					secondCardValue = getCardValue(card);
					if (secondCardValue >= 7 || secondCardValue == 1) {
						if (hasJoker || firstCardValue == secondCardValue) {
							cr.setWin(true);
							cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
							return cr;
						}
					}
				}
			}
		}
		return cr;
	}

	public static CardResult twoPairs(byte[] cards, CardResult cr) {
		int card = 0, firstCardValue = 0, secondCardValue = 0, count = 0;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				count++;
				continue;
			}
			firstCardValue = getCardValue(card);
			for (int j = i + 1; j < cards.length; j++) {
				card = cards[j];
				if (card == joker) {
					continue;
				}
				secondCardValue = getCardValue(card);
				if (firstCardValue == secondCardValue) {
					count++;
				}
			}
		}
		if (count >= 2) {
			cr.setWin(true);
			cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
			return cr;
		}
		return cr;
	}

	public static void main(String[] args) {
		System.out.println(orginalRoyalFlush(new byte[] { 23, 1, 12, 39, 11 }));
	}

	public static CardResult threeOfAKind(byte[] cards, CardResult cr) {
		int cardValue = 0, card = 0, jokerCount = 0;
		Byte count = null;
		Map<Integer, Byte> countMap = new HashMap<Integer, Byte>(5);
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				if (jokerCount >= 2) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
				continue;
			}
			cardValue = getCardValue(card);
			count = countMap.get(cardValue);
			if (count == null) {
				count = 1;
			} else {
				count++;
				if (count + jokerCount >= 3) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
			}
			countMap.put(cardValue, count);
		}

		for (int key : countMap.keySet()) {
			count = countMap.get(key);
			if (count + jokerCount >= 3) {
				cr.setWin(true);
				cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
				return cr;
			}
		}
		return cr;
	}

	public static CardResult straight(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0;
		byte card = 0;
		int sum = 0;
		int jokerCount = 0;
		byte gapArray = 0;
		boolean isA = false;
		int aIndex = 0;
		int maxValue = 0;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				cardValue = getCardValue(card);
				if (cardValue > maxValue) {
					maxValue = cardValue;
				}
				if (cardValue == 1) {
					sortedCards[i] = 14;
					isA = true;
					aIndex = i;
				} else {
					sortedCards[i] = (byte) cardValue;
				}
				sum += cardValue;
			} else {
				jokerCount++;
				if (jokerCount >= 4) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
			}
		}
		if (maxValue <= 5 && isA) {
			sortedCards[aIndex] = 1;
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b >= 0) {
					gapArray += b;
				} else {
					return cr;
				}
			}
		}
		if (gapArray <= jokerCount || sum / 5 == 0) {
			cr.setWin(true);
			cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
			return cr;
		}
		return cr;
	}

	public static CardResult flush(byte[] cards, CardResult cr) {
		byte cardColor = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardColorCountMap = new HashMap<Byte, Byte>(5);
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
			}
			cardColor = (byte) getCardColor(card);
			Byte count = cardColorCountMap.get(cardColor);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardColorCountMap.put(cardColor, count);
		}
		for (byte key : cardColorCountMap.keySet()) {
			if (cardColorCountMap.get(key) + jokerCount >= 5) {
				cr.setWin(true);
				cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
				return cr;
			}
		}
		return cr;
	}

	public static CardResult fullHouse(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		for (int i = 0; i < cards.length; i++) {
			if (cardValueCountMap.size() > 2) {
				return cr;
			}
			card = cards[i];
			if (card == joker) {
				continue;
			}
			cardValue = (byte) getCardValue(card);
			Byte count = cardValueCountMap.get(cardValue);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardValueCountMap.put(cardValue, count);
		}
		if (cardValueCountMap.size() == 2) {
			cr.setWin(true);
			cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
			return cr;
		}
		return cr;
	}

	public static CardResult fourOfAKindTwoTen(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		Byte count = 0;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				if (count + jokerCount >= 4) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
				continue;
			}
			cardValue = (byte) getCardValue(card);
			if (2 <= cardValue && cardValue <= 10) {
				count = cardValueCountMap.get(cardValue);
				if (count == null) {
					count = 1;
				} else {
					count++;
				}
				if (count + jokerCount >= 4) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
				cardValueCountMap.put(cardValue, count);
			}
		}
		return cr;
	}

	public static CardResult fourOfAKindJA(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		Byte count = 0;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				if (count + jokerCount >= 4) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
				continue;
			}
			cardValue = (byte) getCardValue(card);
			if (1 == cardValue || cardValue > 10) {
				count = cardValueCountMap.get(cardValue);
				if (count == null) {
					count = 1;
				} else {
					count++;
				}
				if (count + jokerCount >= 4) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
				cardValueCountMap.put(cardValue, count);
			}
		}
		return cr;
	}

	public static CardResult straightFlush(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0;
		byte card = 0;
		int sum = 0;
		int jokerCount = 0;
		byte gapArray = 0;
		int cardColor = 0;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				if (cardColor == 0) {
					cardColor = getCardColor(card);
				} else {
					if (cardColor != getCardColor(card)) {
						return cr;
					}
				}
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					sortedCards[i] = 14;
				} else {
					sortedCards[i] = (byte) cardValue;
				}
			} else {
				jokerCount++;
				if (jokerCount >= 4) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
			}
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b > 0) {
					gapArray += b;
				}
			}
		}
		if (gapArray <= jokerCount) {
			cr.setWin(true);
			cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
			return cr;
		}
		for (int i = 0, j = sortedCards.length - 1; i < sortedCards.length
				&& j > 0; i++, j--) {
			cardValue = sortedCards[i];
			sum += cardValue;
		}
		if (sum / 5 == 0) {
			cr.setWin(true);
			cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
			return cr;
		}
		return cr;
	}

	public static CardResult fiveOfAKind(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		Byte count = 0;
		List<Byte> keepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				if (count + jokerCount >= 5) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
				continue;
			}
			cardValue = (byte) getCardValue(card);
			count = cardValueCountMap.get(cardValue);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			if (count + jokerCount >= 5) {
				cr.setWin(true);
				cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
				return cr;
			}
			cardValueCountMap.put(cardValue, count);
		}
		return cr;
	}

	public static CardResult royalFlush(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0;
		byte card = 0;
		int sum = 0;
		int jokerCount = 0;
		byte gapArray = 0;
		int cardColor = 0;
		List<Byte> keepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				if (cardColor == 0) {
					cardColor = getCardColor(card);
				} else {
					if (cardColor != getCardColor(card)) {
						return cr;
					}
				}
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					sortedCards[i] = 14;
				} else if (cardValue >= 10) {
					sortedCards[i] = (byte) cardValue;
				} else {
					return cr;
				}
				sum += cardValue;
			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 4) {
					cr.setWin(true);
					cr.setKeepCards(ArrayUtils.toPrimitive((Byte[]) keepList
							.toArray()));
					return cr;
				}
			}
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b > 0) {
					gapArray += b;
				}
			}
		}
		if (gapArray <= jokerCount || sum / 5 == 0) {
			cr.setWin(true);
			cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
			return cr;
		}
		return cr;
	}

	public static CardResult fiveBars(byte[] cards, CardResult cr) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] != CardUtil.cards.length) {
				return cr;
			}
		}
		cr.setWin(true);
		cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
		return cr;
	}

	public static CardResult fourFlush(byte[] cards, CardResult cr) {
		byte cardColor = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardColorCountMap = new HashMap<Byte, Byte>(5);
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
			}
			cardColor = (byte) getCardColor(card);
			Byte count = cardColorCountMap.get(cardColor);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardColorCountMap.put(cardColor, count);
		}
		for (byte key : cardColorCountMap.keySet()) {
			if (cardColorCountMap.get(key) + jokerCount >= 4) {
				cr.setWin(true);
				cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
				return cr;
			}
		}
		return cr;
	}

	public static CardResult fourStraight(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0;
		byte card = 0;
		int jokerCount = 0;
		byte continueCount = 0;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					sortedCards[i] = 14;
				} else {
					sortedCards[i] = (byte) cardValue;
				}
			} else {
				jokerCount++;
				if (jokerCount >= 3) {
					cr.setWin(true);
					cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
					return cr;
				}
			}
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b == 0) {
					continueCount++;
					if (continueCount + 1 + jokerCount >= 4) {
						cr.setWin(true);
						cr.setKeepCards(new byte[] { 0, 1, 2, 3, 4 });
						return cr;
					}
				} else {
					continueCount = 0;
				}
			}
		}
		return cr;
	}

	public static boolean orginalRoyalFlush(byte[] cards) {
		int card = 0, cardValue = 0, sum = 0;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			cardValue = getCardValue(card);
			sum += cardValue;
		}
		if (sum == 47) {
			return true;
		}
		return false;
	}
}
