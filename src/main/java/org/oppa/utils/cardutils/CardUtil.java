package org.oppa.utils.cardutils;

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
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

public class CardUtil {

	private static byte[] cards = new byte[]{
			// 方块 A - K
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
			// 梅花 A - K
			14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
			// 红桃 A - K
			27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
			// 黑桃 A - K
			40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53};

	private final static int joker = 53;

	private final static List<Byte> jqkList = new ArrayList<Byte>(5);

	static {
		jqkList.add((byte) 11);
		jqkList.add((byte) 12);
		jqkList.add((byte) 13);
	}

	public final static double[] FIVEPREFAB = new double[]{0.9, 0.91, 0.92, 0.93, 0.94, 0.95};

	public final static byte[][] WINPOOLSTRAIGHTFLUSH = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}, {6, 7, 8, 9, 10}, {7, 8, 9, 10, 11}, {8, 9, 10, 11, 12}, {9, 10, 11, 12, 13}};
	public final static byte[] WINPOOLFIVEBARS = {53, 53, 53, 53, 53};
	public final static byte[][] WINPOOLROYALFLUSH = {{10, 11, 12, 13, 1}};

	public final static byte[][] WINPOOLFOUROFAKINDJOKER = {{11, 24, 37, 50, 1}, {12, 25, 38, 51, 2}, {13, 26, 39, 52, 3}, {1, 14, 27, 40, 4}};
	public final static byte[][] WINPOOLFIVEOFAKIND = {{2, 15, 28, 41, 53}
	// {11, 24, 37, 50, 1}, {12, 25, 38, 51, 1}, {13, 26, 39, 52, 1}
	};
	public final static String[] randomNegative3 = new String[]{"40,5", "45,10", "50,15", "55,20", "60,25", "65,30", "70,35", "100,100"};
	public final static String[] randomNegative2 = new String[]{"0,0", "55,25", "55,30", "50,20", "55,20", "60,20", "65,25", "100,100"};
	public final static String[] randomNegative1 = new String[]{"0,0", "50,10", "50,15", "50,18", "50,20", "55,20", "60,20", "100,100"};
	public final static String[] random1 = new String[]{"65,25", "65,30", "70,30", "70,35", "70,40", "75,40", "75,45", "80,45"};
	public final static String[] random2 = new String[]{"60,20", "65,25", "70,25", "70,30", "75,30", "75,35", "80,35", "80,40"};
	public final static String[] random3 = new String[]{"80,23", "80,26", "85,29", "85,32", "85,35", "85,38", "85,41", "90,50"};
	public final static String[] random5 = new String[]{"55,15", "55,20", "55,25", "55,30", "55,34", "60,37", "60,40", "65,45"};
	public final static String[] random7 = new String[]{"60,10", "60,14", "60,19", "60,24", "60,29", "65,30", "65,35", "70,40"};
	public final static String[] random10 = new String[]{"95,35", "95,40", "95,45", "95,50", "95,54", "95,60", "95,65", "95,70"};
	public final static String[] random50 = new String[]{"95,50", "95,55", "95,60", "95,65", "95,70", "95,75", "95,80", "100,100"};
	public final static String[] random79 = new String[]{"95,80", "95,85", "95,87", "95,90", "95,93", "95,95", "95,97", "100,100"};
	public final static String[] random9997 = new String[]{"5,12", "5,12", "5,12", "5,12", "4,10", "4,9", "4,7", "3,6"};
	public final static String[] random9998 = new String[]{"2,5", "2,5", "2,5", "2,5", "2,5", "2,5", "2,5", "100,100"};
	public final static String[] random9999 = new String[]{"99,99", "80,80", "60,60", "40,40", "20,20", "10,10", "1,1", "100,100"};
	
	public final static List<FivepkPrefab> fivepkPrefabList = new ArrayList<FivepkPrefab>(5);
	static {
//		fivepkPrefabList.add(new FivepkPrefab(48, "20,23", "17,19", "14,16", "11,13", "8,10", "5,7", "2,4", "0"));
		fivepkPrefabList.add(new FivepkPrefab(49, "70", "60", "50", "40", "30", "20", "10", "0"));
		fivepkPrefabList.add(new FivepkPrefab(78, "50", "45", "40", "35", "30", "20", "10", "0"));
//		fivepkPrefabList.add(new FivepkPrefab(80, 5, 30, 26, 20, 16, 12, 4, 0));
		fivepkPrefabList.add(new FivepkPrefab(120, "5", "30", "26", "20", "16", "12", "4", "0"));
		fivepkPrefabList.add(new FivepkPrefab(250, "5", "16", "14", "12", "10", "6", "2", "0"));
		fivepkPrefabList.add(new FivepkPrefab(500, "5", "16", "14", "12", "10", "6", "2", "0"));
		fivepkPrefabList.add(new FivepkPrefab(1000, "5", "26", "20", "12", "10", "8", "4", "0"));
	}

	public final static Map<String, Map<Integer, Double>> RANDOMBUFF = new HashMap<String, Map<Integer, Double>>();

	private static final Map<String, Integer> forceSevenBetterMap = new HashMap<String, Integer>();
	
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
		Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
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

	public void appendCards(byte[] cardArray, XSSFSheet sheet, int columnIndex, int physicalNumberOfRow) {
		int card = 0, cardValue = 0;
		int cardColor = 0;
		String strCardValue = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < cardArray.length; i++) {
			card = cardArray[i];
			cardValue = getCardValue(card);
			switch (cardValue) {
				case 11 :
					strCardValue = "J";
					break;
				case 12 :
					strCardValue = "Q";
					break;
				case 13 :
					strCardValue = "K";
					break;
				case 1 :
					strCardValue = "A";
					break;
				default :
					strCardValue = String.valueOf(cardValue);
					break;
			}
			cardColor = getCardColor(card);
			switch (cardColor) {
				case 1 :
					sb.append(", 方块 " + strCardValue);
					break;
				case 2 :
					sb.append(", 梅花 " + strCardValue);
					break;
				case 3 :
					sb.append(", 红桃 " + strCardValue);
					break;
				case 4 :
					sb.append(", 黑桃 " + strCardValue);
					break;
				case 5 :
					sb.append(", 鬼");
					break;
				default :
					break;
			}
		}
		sb.deleteCharAt(0);
		// int physicalNumberOfRow = sheet.getPhysicalNumberOfRows();
		sheet.setDefaultColumnWidth(40);

		XSSFCell cell = null;
		XSSFRow row = sheet.getRow(physicalNumberOfRow);
		if (row == null) {
			row = sheet.createRow(physicalNumberOfRow);
		}
		cell = row.createCell(columnIndex);
		cell.setCellValue(sb.toString());
	}

	public void appendKeepCards(CardResult cr, XSSFSheet sheet, int columnIndex, int physicalNumberOfRow) {
		int card = 0, cardValue = 0, index = 0;
		int cardColor = 0;
		String strCardValue = null;
		StringBuffer sb = new StringBuffer();
		if (cr.getKeepCards() != null) {
			for (int i = 0; i < cr.getKeepCards().length; i++) {
				index = cr.getKeepCards()[i];
				card = cr.getCards()[index];
				cardValue = getCardValue(card);
				switch (cardValue) {
					case 11 :
						strCardValue = "J";
						break;
					case 12 :
						strCardValue = "Q";
						break;
					case 13 :
						strCardValue = "K";
						break;
					case 1 :
						strCardValue = "A";
						break;
					default :
						strCardValue = String.valueOf(cardValue);
						break;
				}
				cardColor = getCardColor(card);
				switch (cardColor) {
					case 1 :
						sb.append(", 方块 " + strCardValue);
						break;
					case 2 :
						sb.append(", 梅花 " + strCardValue);
						break;
					case 3 :
						sb.append(", 红桃 " + strCardValue);
						break;
					case 4 :
						sb.append(", 黑桃 " + strCardValue);
						break;
					case 5 :
						sb.append(", 鬼");
						break;
					default :
						break;
				}
			}
			sb.deleteCharAt(0);
			// int physicalNumberOfRow = sheet.getPhysicalNumberOfRows();
			sheet.setDefaultColumnWidth(40);

			XSSFCell cell = null;
			XSSFRow row = sheet.getRow(physicalNumberOfRow);
			if (row == null) {
				row = sheet.createRow(physicalNumberOfRow);
			}
			cell = row.createCell(columnIndex);
			cell.setCellValue(sb.toString());
		}
	}

	public XSSFSheet getHSSFSheet(XSSFWorkbook workbook, String sheetName) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		}
		return sheet;
	}

	public void firstAndSecond(String count) {
		int totalCount = Integer.valueOf(count);
		byte[] cardArray = null;
		XSSFWorkbook workbook = new XSSFWorkbook();
		int fullHouseCount = 0;
		int flushCount = 0;
		int straightCount = 0;
		int threeOfAKindCount = 0;
		int twoPairsCount = 0;
		int sevenBetterCount = 0;
		int smallSevenBetterCount = 0;
		int failCount = 0;
		int fourOfAKindJA = 0;
		int fourOfAKindTwoTen = 0;
		int straightFlush = 0;
		int fiveOfAKind = 0;
		int royalFlush = 0;
		int fiveBars = 0;
		int fourStraight = 0;
		int fourFlush = 0;

		int sfullHouseCount = 0;
		int sflushCount = 0;
		int sstraightCount = 0;
		int sthreeOfAKindCount = 0;
		int stwoPairsCount = 0;
		int ssevenBetterCount = 0;
		int sfailCount = 0;
		int sfourOfAKindJA = 0;
		int sfourOfAKindTwoTen = 0;
		int sstraightFlush = 0;
		int sfiveOfAKind = 0;
		int sroyalFlush = 0;
		int sfiveBars = 0;
		int sfourStraight = 0;
		int sfourFlush = 0;

		XSSFSheet sheet = null;
		int columnIndex = 0;
		int columnIndex1 = 1;
		for (int i = 0; i < totalCount; i++) {
			CardResult cr = new CardResult();
			cardArray = firstRandomCards1(cr).getCards();
			cr.setCards(cardArray);
			if (fiveBars(cardArray, cr).isWin()) {
				cr.setWin(false);
				fiveBars++;
				sheet = getHSSFSheet(workbook, "五鬼");
				appendCards(cardArray, sheet, columnIndex, fiveBars);
				cr.setPhysicalNumberOfRow(fiveBars);
				appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
			} else {
				if (royalFlush(cardArray, cr).isWin()) {
					cr.setWin(false);
					royalFlush++;
					sheet = getHSSFSheet(workbook, "同花大顺");
					appendCards(cardArray, sheet, columnIndex, royalFlush);
					cr.setPhysicalNumberOfRow(royalFlush);
					appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
				} else {
					if (fiveOfAKind(cardArray, cr).isWin()) {
						cr.setWin(false);
						fiveOfAKind++;
						sheet = getHSSFSheet(workbook, "五梅");
						appendCards(cardArray, sheet, columnIndex, fiveOfAKind);
						cr.setPhysicalNumberOfRow(fiveOfAKind);
						appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
					} else {
						if (straightFlush(cardArray, cr).isWin()) {
							cr.setWin(false);
							straightFlush++;
							sheet = getHSSFSheet(workbook, "同花小顺");
							appendCards(cardArray, sheet, columnIndex, straightFlush);
							cr.setPhysicalNumberOfRow(straightFlush);
							appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
						} else {
							if (fourOfAKindJA(cardArray, cr).isWin()) {
								cr.setWin(false);
								fourOfAKindJA++;
								sheet = getHSSFSheet(workbook, "大四梅");
								appendCards(cardArray, sheet, columnIndex, fourOfAKindJA);
								cr.setPhysicalNumberOfRow(fourOfAKindJA);
								appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
							} else {
								if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
									cr.setWin(false);
									fourOfAKindTwoTen++;
									sheet = getHSSFSheet(workbook, "小四梅");
									appendCards(cardArray, sheet, columnIndex, fourOfAKindTwoTen);
									cr.setPhysicalNumberOfRow(fourOfAKindTwoTen);
									appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
								} else {
									if (fullHouse(cardArray, cr).isWin()) {
										cr.setWin(false);
										fullHouseCount++;
										sheet = getHSSFSheet(workbook, "葫芦");
										appendCards(cardArray, sheet, columnIndex, fullHouseCount);
										cr.setPhysicalNumberOfRow(fullHouseCount);
										appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
									} else {
										if (flush(cardArray, cr).isWin()) {
											cr.setWin(false);
											flushCount++;
											sheet = getHSSFSheet(workbook, "同花");
											appendCards(cardArray, sheet, columnIndex, flushCount);
											cr.setPhysicalNumberOfRow(flushCount);
											appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
										} else {
											if (straight(cardArray, cr).isWin()) {
												cr.setWin(false);
												straightCount++;
												sheet = getHSSFSheet(workbook, "顺子");
												appendCards(cardArray, sheet, columnIndex, straightCount);
												cr.setPhysicalNumberOfRow(straightCount);
												appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
											} else {
												if (threeOfAKind(cardArray, cr).isWin()) {
													cr.setWin(false);
													threeOfAKindCount++;
													sheet = getHSSFSheet(workbook, "三条");
													appendCards(cardArray, sheet, columnIndex, threeOfAKindCount);
													cr.setPhysicalNumberOfRow(threeOfAKindCount);
													appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
												} else {
													if (twoPairs(cardArray, cr).isWin()) {
														cr.setWin(false);
														twoPairsCount++;
														sheet = getHSSFSheet(workbook, "两对");
														appendCards(cardArray, sheet, columnIndex, twoPairsCount);
														cr.setPhysicalNumberOfRow(twoPairsCount);
														appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
													} else {
														if (sevenBetter(cardArray, cr).isWin()) {
															cr.setWin(false);
															sevenBetterCount++;
															sheet = getHSSFSheet(workbook, "大一对");
															appendCards(cardArray, sheet, columnIndex, sevenBetterCount);
															cr.setPhysicalNumberOfRow(sevenBetterCount);
															appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
														} else {
															if (fourFlush(cardArray, cr).isWin()) {
																cr.setWin(false);
																fourFlush++;
																sheet = getHSSFSheet(workbook, "四张同花");
																appendCards(cardArray, sheet, columnIndex, fourFlush);
																cr.setPhysicalNumberOfRow(fourFlush);
																appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
															} else {
																if (fourStraight(cardArray, cr).isWin() || fourStraightThird(cardArray, cr).isWin() || fourStraightFourth(cardArray, cr).isWin()) {
																	cr.setWin(false);
																	fourStraight++;
																	sheet = getHSSFSheet(workbook, "四张顺");
																	appendCards(cardArray, sheet, columnIndex, fourStraight);
																	cr.setPhysicalNumberOfRow(fourStraight);
																	appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
																} else {
																	if (sevenBetterKeep(cardArray, cr).isWin()) {
																		cr.setWin(false);
																		smallSevenBetterCount++;
																		sheet = getHSSFSheet(workbook, "小一对");
																		appendCards(cardArray, sheet, columnIndex, smallSevenBetterCount);
																		cr.setPhysicalNumberOfRow(smallSevenBetterCount);
																		appendKeepCards(cr, sheet, columnIndex1, cr.getPhysicalNumberOfRow());
																	} else {
																		failCount++;
																		sheet = getHSSFSheet(workbook, "乌龙");
																		appendCards(cardArray, sheet, columnIndex, failCount);
																		cr.setPhysicalNumberOfRow(failCount);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}

			int columnIndex2 = 2;
			cardArray = secondRandomCards2(cr).getCards();
			if (fiveBars(cardArray, cr).isWin()) {
				appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
			} else {
				if (royalFlush(cardArray, cr).isWin()) {
					appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
				} else {
					if (fiveOfAKind(cardArray, cr).isWin()) {
						appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
					} else {
						if (straightFlush(cardArray, cr).isWin()) {
							appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
						} else {
							if (fourOfAKindJA(cardArray, cr).isWin()) {
								appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
							} else {
								if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
									appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
								} else {
									if (fullHouse(cardArray, cr).isWin()) {
										appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
									} else {
										if (flush(cardArray, cr).isWin()) {
											appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
										} else {
											if (straight(cardArray, cr).isWin()) {
												appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
											} else {
												if (threeOfAKind(cardArray, cr).isWin()) {
													appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
												} else {
													if (twoPairs(cardArray, cr).isWin()) {
														appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
													} else {
														if (sevenBetter(cardArray, cr).isWin()) {
															appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
														} else {
															if (fourFlush(cardArray, cr).isWin()) {
																appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
															} else {
																if (fourStraight(cardArray, cr).isWin() || fourStraightThird(cardArray, cr).isWin() || fourStraightFourth(cardArray, cr).isWin()) {
																	appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
																} else {
																	if (sevenBetterKeep(cardArray, cr).isWin()) {
																		appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
																	} else {
																		appendCards(cardArray, sheet, columnIndex2, cr.getPhysicalNumberOfRow());
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("一手二手发牌.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printAndExcel(String count, int... prefabs) {
		int totalCount = Integer.valueOf(count);
		int fullHouseCount = 0;
		int flushCount = 0;
		int straightCount = 0;

		int threeOfAKindCount = 0;
		int twoPairsCount = 0;
		int sevenBetterCount = 0;
		int smallSevenBetterCount = 0;
		int failCount = 0;
		int fourOfAKindJA = 0;
		int fourOfAKindJAJoker = 0;
		int fourOfAKindTwoTen = 0;
		int straightFlush = 0;
		// int straightFlushCount = 0;
		int fiveOfAKind = 0;
		int royalFlush = 0;
		int fiveBars = 0;
		int fourStraight = 0;
		int fourFlush = 0;
		byte[] cardArray = null;
		int winCount = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		int columnIndex = 0;

		byte keepCard = 0;
		int randomRemove = 0;
		int sameColor = 0;
		int sameColor2 = 0;
		int totalWinCount = 0;
		int plusWinCount = 0;
		String machineId = "1";
		FivepkSeoId fivepkSeoId = new FivepkSeoId();
		fivepkSeoId.setPrefabFiveBars((byte)prefabs[0]);
		fivepkSeoId.setPrefabRoyalFlush((byte)prefabs[1]);
		fivepkSeoId.setPrefabFiveOfAKind((byte)prefabs[2]);
		fivepkSeoId.setPrefabStraightFlush((byte)prefabs[3]);
		fivepkSeoId.setPrefabFourOfAKindJoker((byte)prefabs[4]);
		fivepkSeoId.setPrefabFourOfAKindJa((byte)prefabs[5]);
		fivepkSeoId.setPrefabFourOfAKindTwoTen((byte)prefabs[6]);
		fivepkSeoId.setPrefabFullHouse((byte)prefabs[7]);
		fivepkSeoId.setPrefabFlush((byte)prefabs[8]);
		fivepkSeoId.setPrefabStraight((byte)prefabs[9]);
		fivepkSeoId.setPrefabThreeOfAKind((byte)prefabs[10]);
		fivepkSeoId.setPrefabTwoPairs((byte)prefabs[11]);
		fivepkSeoId.setPrefabSevenBetter((byte)prefabs[12]);
		fivepkSeoId.setPrefabFourFlush((byte)prefabs[13]);
		fivepkSeoId.setPrefabFourStraight((byte)prefabs[14]);
		fivepkSeoId.setPrefabSevenBetterKeep((byte)prefabs[15]);
		fivepkSeoId.setPrefabJoker((byte)prefabs[16]);
		fivepkSeoId.setPrefabFourOfAKindJA((byte)prefabs[17]);
		fivepkSeoId.setPrefabFourOfAKindTT((byte)prefabs[18]);
		fivepkSeoId.setPrefabFourOfAKindTwoTenTwo((byte)prefabs[19]);
		fivepkSeoId.setPrefabForceSevenBetter((byte)prefabs[20]);
		List<CardResult> secondList = new ArrayList<CardResult>();
		int prefab = 0;
		int loseCount = 0;
		int forceSevenBetterCount = 0;
		for (int i = 1; i < totalCount + 1; i++) {
			fivepkSeoId.setSeoMachinePlayCount(fivepkSeoId.getSeoMachinePlayCount() + 1);
			CardResult cr = new CardResult();

			for (int i1 = 0; i1 < fivepkPrefabList.size(); i1++) {
				FivepkPrefab fivepkPrefab = fivepkPrefabList.get(i1);
				prefab = fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards());
				if (fivepkPrefab.getPrefabCards() == 78) {
					totalWinCount = (int) (1000 * (fivepkPrefab.getPrefabCards() + 2));
				} else if (fivepkPrefab.getPrefabCards() == 49) {
					totalWinCount = (int) (1000 * fivepkPrefab.getPrefabCards() + 1);
				} else {
					totalWinCount = (int) (1000 * fivepkPrefab.getPrefabCards());
				}
				if (fivepkPrefab.getPrefabCards() != 80 && fivepkPrefab.getPrefabCards() != 48) {
					prefab = Integer.parseInt(fivepkPrefab.getPrefab(prefab));
					if (prefab == 0) {
						continue;
					}
				} else {
					prefab = 5;
				}
				winCount = prefab;
//				if (fivepkPrefab.getPrefabCards() == 48) {
//					if (fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards()) == 7){
//						continue;
//					}
//					String[] continueArr = null;
//					if (fivepkSeoId.getPrefabFourOfAKindTwoTenContinue() == null || fivepkSeoId.getPrefabFourOfAKindTwoTenContinue().isEmpty()){
//						prefab = fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards());
//						continueArr = fivepkPrefab.getPrefab(prefab).split(",");
//						int randomQuantity = RandomUtils.nextInt(Integer.parseInt(continueArr[0]), Integer.parseInt(continueArr[1]));
//						StringBuffer sb = new StringBuffer();
//						long randomSeoMachinePlayCount = RandomUtils.nextLong(fivepkSeoId.getSeoMachinePlayCount(), fivepkSeoId.getSeoMachinePlayCount() + 20);
//						sb.append(randomSeoMachinePlayCount).append(",");
//						for (int j = 1; j < randomQuantity; j++) {
//							randomSeoMachinePlayCount = RandomUtils.nextLong(randomSeoMachinePlayCount + 1, randomSeoMachinePlayCount + 20);
//							sb.append(randomSeoMachinePlayCount).append(",");
//						}
//						sb.deleteCharAt(sb.lastIndexOf(","));
//						fivepkSeoId.setPrefabFourOfAKindTwoTenContinue(sb.toString());
//					}
//					boolean isBreak = false;
//					continueArr = fivepkSeoId.getPrefabFourOfAKindTwoTenContinue().split(",");
//					String win = null;
//					for (int j = 0; j < continueArr.length; j++) {
//						win = continueArr[j];
//						if (fivepkSeoId.getSeoMachinePlayCount() == Integer.parseInt(win)) {
//							cr.setWinType(fivepkPrefab.getPrefabCards() + 1);
//							isBreak = true;
//							if (j + 1 == continueArr.length){
//								fivepkSeoId.setPrefabFourOfAKindTwoTenContinue("");
//								fivepkSeoId.setPrefabFourOfAKindTwoTenTwo((byte)7);
//							}
//							break;
//						}
//					}
//					if (isBreak){
//						break;
//					}
//				} else 
				if (fivepkPrefab.getPrefabCards() == 49) {
					fivepkSeoId.setPrefabFourOfAKindTTCount(fivepkSeoId.getPrefabFourOfAKindTTCount() + winCount);
					if (fivepkSeoId.getPrefabFourOfAKindTTCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFourOfAKindTTCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 78) {
					fivepkSeoId.setPrefabFourOfAKindJACount(fivepkSeoId.getPrefabFourOfAKindJACount() + winCount);
					if (fivepkSeoId.getPrefabFourOfAKindJACount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFourOfAKindJACount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 80) {
					prefab = fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards());
					if (prefab == 7){
						fivepkSeoId.setPrefabFourOfAKindJokerCount(0);
						continue;
					}
					prefab = Integer.parseInt(fivepkPrefab.getPrefab(prefab).split(",")[0]);
					if (fivepkSeoId.getPrefabFourOfAKindJokerCount() == 0 && prefab != 0){
						fivepkSeoId.setPrefabFourOfAKindJokerCount(fivepkSeoId.getSeoMachinePlayCount() + 10);
					}
					if (fivepkSeoId.getPrefabFourOfAKindJokerCount() == fivepkSeoId.getSeoMachinePlayCount()) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						break;
					}
//					if (prefab == 5) {
//						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
//						if (prefabBuffMap == null) {
//							prefabBuffMap = new HashMap<Integer, Double>();
//							RANDOMBUFF.put(machineId, prefabBuffMap);
//						}
//						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
//						if (randomBuff == null) {
//							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
//							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
//							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
//							fivepkSeoId.setPrefabFourOfAKindJokerCount(plusWinCount);
//						}
//					} else {
//						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
//						if (prefabBuffMap != null) {
//							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
//						}
//					}
//					fivepkSeoId.setPrefabFourOfAKindJokerCount(fivepkSeoId.getPrefabFourOfAKindJokerCount() + winCount);
//					if (fivepkSeoId.getPrefabFourOfAKindJokerCount() >= totalWinCount) {
//						cr.setWinType(fivepkPrefab.getPrefabCards());
//						fivepkSeoId.setPrefabFourOfAKindJokerCount(0);
//						break;
//					}
				} else if (fivepkPrefab.getPrefabCards() == 120) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabStraightFlushCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabStraightFlushCount(fivepkSeoId.getPrefabStraightFlushCount() + winCount);
					if (fivepkSeoId.getPrefabStraightFlushCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabStraightFlushCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 250) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabFiveOfAKindCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabFiveOfAKindCount(fivepkSeoId.getPrefabFiveOfAKindCount() + winCount);
					if (fivepkSeoId.getPrefabFiveOfAKindCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFiveOfAKindCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 500) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabRoyalFlushCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabRoyalFlushCount(fivepkSeoId.getPrefabRoyalFlushCount() + winCount);
					if (fivepkSeoId.getPrefabRoyalFlushCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabRoyalFlushCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 1000) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabFiveBarsCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabFiveBarsCount(fivepkSeoId.getPrefabFiveBarsCount() + winCount);
					if (fivepkSeoId.getPrefabFiveBarsCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFiveBarsCount(0);
						break;
					}
				}
			} 
			if (cr.getWinType() == 49) {
				cardArray = new byte[]{2,15,28,41,3};
				cr.setWinType2(49);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 78) {
				cardArray = new byte[]{11, 24, 37, 53, 1};
				cr.setWinType2(78);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 80) {
				cardArray = Arrays.copyOf(WINPOOLFOUROFAKINDJOKER[RandomUtils.nextInt(0, WINPOOLFOUROFAKINDJOKER.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 120) {
				cardArray = Arrays.copyOf(WINPOOLSTRAIGHTFLUSH[RandomUtils.nextInt(0, WINPOOLSTRAIGHTFLUSH.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 250) {
				cardArray = Arrays.copyOf(WINPOOLFIVEOFAKIND[RandomUtils.nextInt(0, WINPOOLFIVEOFAKIND.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 500) {
				cardArray = Arrays.copyOf(WINPOOLROYALFLUSH[RandomUtils.nextInt(0, WINPOOLROYALFLUSH.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 1000) {
				cardArray = Arrays.copyOf(WINPOOLFIVEBARS, cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			}  else if (
					loseCount > forceSevenBetterCount
					){
				loseCount = 0;
				cr.setWinType(1);
				int randomSevenBetterCards = RandomUtils.nextInt(7, 14);
				int firstRandomSevenBetterCards = randomSevenBetterCards + 13 * RandomUtils.nextInt(0, 2);
				int secondRandomSevenBetterCards = randomSevenBetterCards + 13 * RandomUtils.nextInt(2, 4);
				int first = RandomUtils.nextInt(0, 2);
				int second = RandomUtils.nextInt(2, 5);
				byte[] keepRandomSevenBetterCards = new byte[]{(byte) first, (byte) second};
				cr.setKeepCards(keepRandomSevenBetterCards);
				byte[] randomSevenBetterCardsArr = new byte[5];
				randomSevenBetterCardsArr[first] = (byte) firstRandomSevenBetterCards;
				randomSevenBetterCardsArr[second] = (byte) secondRandomSevenBetterCards;
				List<Integer> list = new ArrayList<Integer>();
				for (int i1 = 0; i1 < randomSevenBetterCardsArr.length; i1++) {
					if (randomSevenBetterCardsArr[i1] == 0) {
						int randomValue = 0;
						int randomValue1 = 0;
						int randomValue2 = 0;
						while (true) {
							randomValue = RandomUtils.nextInt(1, 53);
							randomValue1 = CardUtil.getCardValue(randomValue);
							randomValue2 = CardUtil.getCardValue(firstRandomSevenBetterCards);
							if (randomValue1 != randomValue2) {
								if (!list.contains(randomValue1)){
									list.add(randomValue1);
									break;
								}
							}
						}
						randomSevenBetterCardsArr[i1] = (byte) randomValue;
					}
				}
				cr.setCards(randomSevenBetterCardsArr);
				cardArray = cr.getCards();
			} else {
				cardArray = CardUtil.firstRandomCards1(cr, prefabs[5],
						prefabs[6],prefabs[7],prefabs[8],prefabs[9],
								prefabs[10],prefabs[11],prefabs[12],
										prefabs[13],prefabs[14], prefabs[15], prefabs[16]).getCards();
			}

			secondList.add(cr);
			cr.setCards(cardArray);
			cr.setWin(false);
			if (fiveBars(cardArray, cr).isWin()) {
				cr.setWin(false);
				fiveBars++;
				cr.setWinType(1000);
//				appendCards(cardArray, getHSSFSheet(workbook, "五鬼"), columnIndex, fiveBars);
			} else if (royalFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				royalFlush++;
				cr.setWinType(500);
//				appendCards(cardArray, getHSSFSheet(workbook, "同花大顺"), columnIndex, royalFlush);
			} else if (fiveOfAKind(cardArray, cr).isWin()) {
				cr.setWin(false);
				fiveOfAKind++;
				cr.setWinType(250);
//				appendCards(cardArray, getHSSFSheet(workbook, "五梅"), columnIndex, fiveOfAKind);
			} else if (straightFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				straightFlush++;
				cr.setWinType(120);
//				appendCards(cardArray, getHSSFSheet(workbook, "同花小顺"), columnIndex, straightFlush);
			} else if (fourOfAKindJAJoker(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindJAJoker++;
				cr.setWinType(80);
//				appendCards(cardArray, getHSSFSheet(workbook, "大四梅"), columnIndex, fourOfAKindJA);
			} else if (fourOfAKindJA(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindJA++;
				cr.setWinType(79);
//				appendCards(cardArray, getHSSFSheet(workbook, "大四梅"), columnIndex, fourOfAKindJA);
			} else if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindTwoTen++;
				cr.setWinType(50);
//				appendCards(cardArray, getHSSFSheet(workbook, "小四梅"), columnIndex, fourOfAKindTwoTen);
			} else if (fullHouse(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(10);
				fullHouseCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "葫芦"), columnIndex, fullHouseCount);
			} else if (flush(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(7);
				flushCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "同花"), columnIndex, flushCount);
			} else if (straight(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(5);
				straightCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "顺子"), columnIndex, straightCount);
			} else if (threeOfAKind(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(3);
				threeOfAKindCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "三条"), columnIndex, threeOfAKindCount);
			} else if (twoPairs(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(2);
				twoPairsCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "两对"), columnIndex, twoPairsCount);
			} 
			else if (fourFlushStraightJokerNew(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount++;
				cr.setWinType(1);
				cr.setWinType2(-5);
			} else if (fourFlushJoker(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount++;
				cr.setWinType(1);
			} else if (fourStraightFourthJokerNew(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount++;
				cr.setWinType(1);
			} 
			else if (sevenBetter(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount++;
				cr.setWinType(1);
				// appendCards(cardArray, getHSSFSheet(workbook, "大一对"), columnIndex, sevenBetterCount);
			} else if (fourFlushStraightNew(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(-4);
				failCount++;
				cr.setWinType2(-5);
			} else if (fourFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(-1);
				fourFlush++;
//				appendCards(cardArray, getHSSFSheet(workbook, "四张同花"), columnIndex, fourFlush);
			} 
			else if (fourStraight(cardArray, cr).isWin() || fourStraightThird(cardArray, cr).isWin() || fourStraightFourth(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(-2);
				fourStraight++;
//				appendCards(cardArray, getHSSFSheet(workbook, "四张顺"), columnIndex, fourStraight);
			} 
			else if (sevenBetterKeep(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(-3);
				smallSevenBetterCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "小一对"), columnIndex, fourStraight);
			} else {
				cr.setWin(false);
				cr.setWinType(-4);
				failCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "乌龙"), columnIndex, failCount);
			}
		}
		System.out.println("五鬼: " + fiveBars + " | " + (fiveBars == 0 ? 0 : totalCount / fiveBars) + " | " + div(fiveBars, totalCount));
		System.out.println("同花大顺: " + royalFlush + " | " + (royalFlush == 0 ? 0 : totalCount / royalFlush) + " | " + div(royalFlush, totalCount));
		System.out.println("五梅: " + fiveOfAKind + " | " + (fiveOfAKind == 0 ? 0 : totalCount / fiveOfAKind) + " | " + div(fiveOfAKind, totalCount));
		System.out.println("同花小顺: " + straightFlush + " | " + (straightFlush == 0 ? 0 : totalCount / straightFlush) + " | " + div(straightFlush, totalCount));
		System.out.println("正宗大四梅: " + fourOfAKindJAJoker + " | " + (fourOfAKindJAJoker == 0 ? 0 : totalCount / fourOfAKindJAJoker) + " | " + div(fourOfAKindJAJoker, totalCount));
//		System.out.println("大四梅: " + (fourOfAKindJA - fourOfAKindJAJoker) + " | " + ((fourOfAKindJA - fourOfAKindJAJoker) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA - fourOfAKindJAJoker), 2)) + " | " + div((fourOfAKindJA - fourOfAKindJAJoker), totalCount));
		System.out.println("大四梅: " + (fourOfAKindJA) + " | " + ((fourOfAKindJA) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA), 2)) + " | " + div((fourOfAKindJA), totalCount));
		System.out.println("小四梅: " + fourOfAKindTwoTen + " | " + (fourOfAKindTwoTen == 0 ? 0 : div1(totalCount, fourOfAKindTwoTen, 2)) + " | " + div(fourOfAKindTwoTen, totalCount));
		System.out.println("葫芦: " + fullHouseCount + " | " + (fullHouseCount == 0 ? 0 : div1(totalCount, fullHouseCount, 2)) + " | " + div(fullHouseCount, totalCount));
		System.out.println("同花: " + flushCount + " | " + (flushCount == 0 ? 0 : div1(totalCount, flushCount, 2)) + " | " + div(flushCount, totalCount));
		System.out.println("顺子: " + straightCount + " | " + (straightCount == 0 ? 0 : div1(totalCount, straightCount, 2)) + " | " + div(straightCount, totalCount));
		System.out.println("三条: " + threeOfAKindCount + " | " + (threeOfAKindCount == 0 ? 0 : div1(totalCount, threeOfAKindCount, 2)) + " | " + div(threeOfAKindCount, totalCount));
		System.out.println("两对: " + twoPairsCount + " | " + (twoPairsCount == 0 ? 0 : div1(totalCount, twoPairsCount, 2)) + " | " + div(twoPairsCount, totalCount));
		System.out.println("大一对: " + sevenBetterCount + " | " + (sevenBetterCount == 0 ? 0 : div1(totalCount, sevenBetterCount, 2)) + " | " + div(sevenBetterCount, totalCount));
		System.out.println("小一对: " + smallSevenBetterCount + " | " + (smallSevenBetterCount == 0 ? 0 : div1(totalCount, smallSevenBetterCount, 2)) + " | " + div(smallSevenBetterCount, totalCount));
		System.out.println("四張同花: " + fourFlush + " | " + (fourFlush == 0 ? 0 : div1(totalCount, fourFlush, 2)) + " | " + div(fourFlush, totalCount));
		System.out.println("四張順: " + fourStraight + " | " + (fourStraight == 0 ? 0 : div1(totalCount, fourStraight, 2)) + " | " + div(fourStraight, totalCount));
		System.out.println("乌龙: " + failCount + " | " + (failCount == 0 ? 0 : div1(totalCount, failCount, 2)) + " | " + div(failCount, totalCount));
		System.out.println("总赢局数: " + (sevenBetterCount + twoPairsCount + threeOfAKindCount + straightCount + flushCount + fullHouseCount + fourOfAKindTwoTen + fourOfAKindJA + straightFlush + fiveOfAKind + royalFlush + fiveBars));
		System.out.println("中奖几率: " + div((sevenBetterCount + twoPairsCount + threeOfAKindCount + straightCount + flushCount + fullHouseCount + fourOfAKindTwoTen + fourOfAKindJA + straightFlush + fiveOfAKind + royalFlush + fiveBars), totalCount));
		System.out.println("游戏几率: " + div((sevenBetterCount + twoPairsCount * 2 + threeOfAKindCount * 3 + straightCount * 5 + flushCount * 7 + fullHouseCount * 10 + fourOfAKindTwoTen * 50 + fourOfAKindJA * 80 + straightFlush * 120 + fiveOfAKind * 250 + royalFlush * 500 + fiveBars * 1000) * 1000, totalCount * 1000));
		System.out.println("--------------------第一手牌结束--------------------");
		System.out.println();
		fullHouseCount = 0;
		flushCount = 0;
		straightCount = 0;
		threeOfAKindCount = 0;
		twoPairsCount = 0;
		sevenBetterCount = 0;
		smallSevenBetterCount = 0;
		failCount = 0;
		fourOfAKindJA = 0;
		fourOfAKindTwoTen = 0;
		straightFlush = 0;
		fiveOfAKind = 0;
		royalFlush = 0;
		fiveBars = 0;
		fourStraight = 0;
		fourFlush = 0;
		fourOfAKindJAJoker = 0;
		columnIndex++;
		for (int i = 1; i < secondList.size() + 1; i++) {
			CardResult cr = secondList.get(i - 1);

			cardArray = secondRandomCards2(cr, prefabs[5],
					prefabs[6],prefabs[7],prefabs[8],prefabs[9],
					prefabs[10],prefabs[11],prefabs[12],
							prefabs[13],prefabs[14],prefabs[15], prefabs[16]).getCards();

			if (fiveBars(cardArray, cr).isWin()) {
				cr.setWin(false);
				fiveBars++;
//				appendCards(cardArray, getHSSFSheet(workbook, "五鬼"), columnIndex, fiveBars);
			} else if (royalFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				royalFlush++;
//				appendCards(cardArray, getHSSFSheet(workbook, "同花大顺"), columnIndex, royalFlush);
			} else if (fiveOfAKind(cardArray, cr).isWin()) {
				cr.setWin(false);
				fiveOfAKind++;
//				appendCards(cardArray, getHSSFSheet(workbook, "五梅"), columnIndex, fiveOfAKind);
			} else if (straightFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				straightFlush++;
//				appendCards(cardArray, getHSSFSheet(workbook, "同花小顺"), columnIndex, straightFlush);
			} else if (fourOfAKindJAJoker(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindJAJoker++;
//				appendCards(cardArray, getHSSFSheet(workbook, "大四梅"), columnIndex, fourOfAKindJA);
			} else if (fourOfAKindJA(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindJA++;
//				appendCards(cardArray, getHSSFSheet(workbook, "大四梅"), columnIndex, fourOfAKindJA);
			} else if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindTwoTen++;
//				appendCards(cardArray, getHSSFSheet(workbook, "小四梅"), columnIndex, fourOfAKindTwoTen);
			} else if (fullHouse(cardArray, cr).isWin()) {
				cr.setWin(false);
				fullHouseCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "葫芦"), columnIndex, fullHouseCount);
			} else if (flush(cardArray, cr).isWin()) {
				cr.setWin(false);
				flushCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "同花"), columnIndex, flushCount);
			} else if (straight(cardArray, cr).isWin()) {
				cr.setWin(false);
				straightCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "顺子"), columnIndex, straightCount);
			} else if (threeOfAKind(cardArray, cr).isWin()) {
				cr.setWin(false);
				threeOfAKindCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "三条"), columnIndex, threeOfAKindCount);
			} else if (twoPairs(cardArray, cr).isWin()) {
				cr.setWin(false);
				twoPairsCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "两对"), columnIndex, twoPairsCount);
			} else if (sevenBetter(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "大一对"), columnIndex, sevenBetterCount);
			} else if (fourFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourFlush++;
//				appendCards(cardArray, getHSSFSheet(workbook, "四张同花"), columnIndex, fourFlush);
			} else if (fourStraight(cardArray, cr).isWin() || fourStraightThird(cardArray, cr).isWin() || fourStraightFourth(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourStraight++;
//				appendCards(cardArray, getHSSFSheet(workbook, "四张顺"), columnIndex, fourStraight);
			} else if (sevenBetterKeep(cardArray, cr).isWin()) {
				cr.setWin(false);
				smallSevenBetterCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "小一对"), columnIndex, fourStraight);
			} else {
				cr.setWin(false);
				failCount++;
//				appendCards(cardArray, getHSSFSheet(workbook, "乌龙"), columnIndex, failCount);
			}
		}

		System.out.println("五鬼: " + fiveBars + " | " + (fiveBars == 0 ? 0 : totalCount / fiveBars) + " | " + div(fiveBars, totalCount));
		System.out.println("同花大顺: " + royalFlush + " | " + (royalFlush == 0 ? 0 : totalCount / royalFlush) + " | " + div(royalFlush, totalCount));
		System.out.println("五梅: " + fiveOfAKind + " | " + (fiveOfAKind == 0 ? 0 : totalCount / fiveOfAKind) + " | " + div(fiveOfAKind, totalCount));
		System.out.println("同花小顺: " + straightFlush + " | " + (straightFlush == 0 ? 0 : totalCount / straightFlush) + " | " + div(straightFlush, totalCount));
		System.out.println("正宗大四梅: " + fourOfAKindJAJoker + " | " + (fourOfAKindJAJoker == 0 ? 0 : totalCount / fourOfAKindJAJoker) + " | " + div(fourOfAKindJAJoker, totalCount));
//		System.out.println("大四梅: " + (fourOfAKindJA - fourOfAKindJAJoker) + " | " + ((fourOfAKindJA - fourOfAKindJAJoker) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA - fourOfAKindJAJoker), 2)) + " | " + div((fourOfAKindJA - fourOfAKindJAJoker), totalCount));
		System.out.println("大四梅: " + (fourOfAKindJA) + " | " + ((fourOfAKindJA) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA), 2)) + " | " + div((fourOfAKindJA), totalCount));
		System.out.println("小四梅: " + fourOfAKindTwoTen + " | " + (fourOfAKindTwoTen == 0 ? 0 : div1(totalCount, fourOfAKindTwoTen, 2)) + " | " + div(fourOfAKindTwoTen, totalCount));
		System.out.println("葫芦: " + fullHouseCount + " | " + (fullHouseCount == 0 ? 0 : div1(totalCount, fullHouseCount, 2)) + " | " + div(fullHouseCount, totalCount));
		System.out.println("同花: " + flushCount + " | " + (flushCount == 0 ? 0 : div1(totalCount, flushCount, 2)) + " | " + div(flushCount, totalCount));
		System.out.println("顺子: " + straightCount + " | " + (straightCount == 0 ? 0 : div1(totalCount, straightCount, 2)) + " | " + div(straightCount, totalCount));
		System.out.println("三条: " + threeOfAKindCount + " | " + (threeOfAKindCount == 0 ? 0 : div1(totalCount, threeOfAKindCount, 2)) + " | " + div(threeOfAKindCount, totalCount));
		System.out.println("两对: " + twoPairsCount + " | " + (twoPairsCount == 0 ? 0 : div1(totalCount, twoPairsCount, 2)) + " | " + div(twoPairsCount, totalCount));
		System.out.println("大一对: " + sevenBetterCount + " | " + (sevenBetterCount == 0 ? 0 : div1(totalCount, sevenBetterCount, 2)) + " | " + div(sevenBetterCount, totalCount));
		System.out.println("小一对: " + smallSevenBetterCount + " | " + (smallSevenBetterCount == 0 ? 0 : div1(totalCount, smallSevenBetterCount, 2)) + " | " + div(smallSevenBetterCount, totalCount));
		System.out.println("四張同花: " + fourFlush + " | " + (fourFlush == 0 ? 0 : div1(totalCount, fourFlush, 2)) + " | " + div(fourFlush, totalCount));
		System.out.println("四張順: " + fourStraight + " | " + (fourStraight == 0 ? 0 : div1(totalCount, fourStraight, 2)) + " | " + div(fourStraight, totalCount));
		System.out.println("乌龙: " + failCount + " | " + (failCount == 0 ? 0 : div1(totalCount, failCount, 2)) + " | " + div(failCount, totalCount));
		System.out.println("总赢局数: " + (sevenBetterCount + twoPairsCount + threeOfAKindCount + straightCount + flushCount + fullHouseCount + fourOfAKindTwoTen + fourOfAKindJA + straightFlush + fiveOfAKind + royalFlush + fiveBars));
		System.out.println("中奖几率: " + div((sevenBetterCount + twoPairsCount + threeOfAKindCount + straightCount + flushCount + fullHouseCount + fourOfAKindTwoTen + fourOfAKindJA + straightFlush + fiveOfAKind + royalFlush + fiveBars), totalCount));
		System.out.println("游戏几率: " + div((sevenBetterCount + twoPairsCount * 2 + threeOfAKindCount * 3 + straightCount * 5 + flushCount * 7 + fullHouseCount * 10 + fourOfAKindTwoTen * 50 + fourOfAKindJA * 80 + straightFlush * 120 + fiveOfAKind * 250 + royalFlush * 500 + fiveBars * 1000) * 1000, totalCount * 1000));
		// try {
		// FileOutputStream out = new FileOutputStream(new File("牌型检测.xlsx"));
		// workbook.write(out);
		// out.close();
		// System.out.println("Excel written successfully..");
		//
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
	
	public void printAndExcelForceSevenBetter(String count, int... prefabs) {
		int totalCount = Integer.valueOf(count);
		int fullHouseCount = 0;
		int flushCount = 0;
		int straightCount = 0;

		int threeOfAKindCount = 0;
		int twoPairsCount = 0;
		int sevenBetterCount = 0;
		int smallSevenBetterCount = 0;
		int failCount = 0;
		int fourOfAKindJA = 0;
		int fourOfAKindJAJoker = 0;
		int fourOfAKindTwoTen = 0;
		int straightFlush = 0;
		// int straightFlushCount = 0;
		int fiveOfAKind = 0;
		int royalFlush = 0;
		int fiveBars = 0;
		int fourStraight = 0;
		int fourFlush = 0;
		
		int fullHouseCount1 = 0;
		int flushCount1 = 0;
		int straightCount1 = 0;

		int threeOfAKindCount1 = 0;
		int twoPairsCount1 = 0;
		int sevenBetterCount1 = 0;
		int smallSevenBetterCount1 = 0;
		int failCount1 = 0;
		int fourOfAKindJA1 = 0;
		int fourOfAKindJAJoker1 = 0;
		int fourOfAKindTwoTen1 = 0;
		int straightFlush1 = 0;
		// int straightFlushCount = 0;
		int fiveOfAKind1 = 0;
		int royalFlush1 = 0;
		int fiveBars1 = 0;
		int fourStraight1 = 0;
		int fourFlush1 = 0;
		
		
		byte[] cardArray = null;
		int winCount = 0;

		XSSFWorkbook workbook = new XSSFWorkbook();
		int columnIndex = 0;

		byte keepCard = 0;
		int randomRemove = 0;
		int sameColor = 0;
		int sameColor2 = 0;
		int totalWinCount = 0;
		int plusWinCount = 0;
		String machineId = "1";
		FivepkSeoId fivepkSeoId = new FivepkSeoId();
		fivepkSeoId.setPrefabFiveBars((byte)prefabs[0]);
		fivepkSeoId.setPrefabRoyalFlush((byte)prefabs[1]);
		fivepkSeoId.setPrefabFiveOfAKind((byte)prefabs[2]);
		fivepkSeoId.setPrefabStraightFlush((byte)prefabs[3]);
		fivepkSeoId.setPrefabFourOfAKindJoker((byte)prefabs[4]);
		fivepkSeoId.setPrefabFourOfAKindJa((byte)prefabs[5]);
		fivepkSeoId.setPrefabFourOfAKindTwoTen((byte)prefabs[6]);
		fivepkSeoId.setPrefabFullHouse((byte)prefabs[7]);
		fivepkSeoId.setPrefabFlush((byte)prefabs[8]);
		fivepkSeoId.setPrefabStraight((byte)prefabs[9]);
		fivepkSeoId.setPrefabThreeOfAKind((byte)prefabs[10]);
		fivepkSeoId.setPrefabTwoPairs((byte)prefabs[11]);
		fivepkSeoId.setPrefabSevenBetter((byte)prefabs[12]);
		fivepkSeoId.setPrefabFourFlush((byte)prefabs[13]);
		fivepkSeoId.setPrefabFourStraight((byte)prefabs[14]);
		fivepkSeoId.setPrefabSevenBetterKeep((byte)prefabs[15]);
		fivepkSeoId.setPrefabJoker((byte)prefabs[16]);
		fivepkSeoId.setPrefabFourOfAKindJA((byte)prefabs[17]);
		fivepkSeoId.setPrefabFourOfAKindTT((byte)prefabs[18]);
		fivepkSeoId.setPrefabFourOfAKindTwoTenTwo((byte)prefabs[19]);
		fivepkSeoId.setPrefabForceSevenBetter((byte)prefabs[20]);
		List<CardResult> secondList = new ArrayList<CardResult>();
		int prefab = 0;
		int forceSevenBetterCount = 0;
		Integer loseCount = forceSevenBetterMap.get(machineId);
		for (int i = 1; i < totalCount + 1; i++) {
			fivepkSeoId.setSeoMachinePlayCount(fivepkSeoId.getSeoMachinePlayCount() + 1);
			CardResult cr = new CardResult();

			for (int i1 = 0; i1 < fivepkPrefabList.size(); i1++) {
				FivepkPrefab fivepkPrefab = fivepkPrefabList.get(i1);
				prefab = fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards());
				if (fivepkPrefab.getPrefabCards() == 78) {
					totalWinCount = (int) (1000 * (fivepkPrefab.getPrefabCards() + 2));
				} else if (fivepkPrefab.getPrefabCards() == 49) {
					totalWinCount = (int) (1000 * fivepkPrefab.getPrefabCards() + 1);
				} else {
					totalWinCount = (int) (1000 * fivepkPrefab.getPrefabCards());
				}
				if (fivepkPrefab.getPrefabCards() != 80 && fivepkPrefab.getPrefabCards() != 48) {
					prefab = Integer.parseInt(fivepkPrefab.getPrefab(prefab));
					if (prefab == 0) {
						continue;
					}
				} else {
					prefab = 5;
				}
				winCount = prefab;
//				if (fivepkPrefab.getPrefabCards() == 48) {
//					if (fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards()) == 7){
//						continue;
//					}
//					String[] continueArr = null;
//					if (fivepkSeoId.getPrefabFourOfAKindTwoTenContinue() == null || fivepkSeoId.getPrefabFourOfAKindTwoTenContinue().isEmpty()){
//						prefab = fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards());
//						continueArr = fivepkPrefab.getPrefab(prefab).split(",");
//						int randomQuantity = RandomUtils.nextInt(Integer.parseInt(continueArr[0]), Integer.parseInt(continueArr[1]));
//						StringBuffer sb = new StringBuffer();
//						long randomSeoMachinePlayCount = RandomUtils.nextLong(fivepkSeoId.getSeoMachinePlayCount(), fivepkSeoId.getSeoMachinePlayCount() + 20);
//						sb.append(randomSeoMachinePlayCount).append(",");
//						for (int j = 1; j < randomQuantity; j++) {
//							randomSeoMachinePlayCount = RandomUtils.nextLong(randomSeoMachinePlayCount + 1, randomSeoMachinePlayCount + 20);
//							sb.append(randomSeoMachinePlayCount).append(",");
//						}
//						sb.deleteCharAt(sb.lastIndexOf(","));
//						fivepkSeoId.setPrefabFourOfAKindTwoTenContinue(sb.toString());
//					}
//					boolean isBreak = false;
//					continueArr = fivepkSeoId.getPrefabFourOfAKindTwoTenContinue().split(",");
//					String win = null;
//					for (int j = 0; j < continueArr.length; j++) {
//						win = continueArr[j];
//						if (fivepkSeoId.getSeoMachinePlayCount() == Integer.parseInt(win)) {
//							cr.setWinType(fivepkPrefab.getPrefabCards() + 1);
//							isBreak = true;
//							if (j + 1 == continueArr.length){
//								fivepkSeoId.setPrefabFourOfAKindTwoTenContinue("");
//								fivepkSeoId.setPrefabFourOfAKindTwoTenTwo((byte)7);
//							}
//							break;
//						}
//					}
//					if (isBreak){
//						break;
//					}
//				} else 
				if (fivepkPrefab.getPrefabCards() == 49) {
					fivepkSeoId.setPrefabFourOfAKindTTCount(fivepkSeoId.getPrefabFourOfAKindTTCount() + winCount);
					if (fivepkSeoId.getPrefabFourOfAKindTTCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFourOfAKindTTCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 78) {
					fivepkSeoId.setPrefabFourOfAKindJACount(fivepkSeoId.getPrefabFourOfAKindJACount() + winCount);
					if (fivepkSeoId.getPrefabFourOfAKindJACount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFourOfAKindJACount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 80) {
					prefab = fivepkSeoId.getPrefab(fivepkPrefab.getPrefabCards());
					if (prefab == 7){
						fivepkSeoId.setPrefabFourOfAKindJokerCount(0);
						continue;
					}
					prefab = Integer.parseInt(fivepkPrefab.getPrefab(prefab).split(",")[0]);
					if (fivepkSeoId.getPrefabFourOfAKindJokerCount() == 0 && prefab != 0){
						fivepkSeoId.setPrefabFourOfAKindJokerCount(fivepkSeoId.getSeoMachinePlayCount() + 10);
					}
					if (fivepkSeoId.getPrefabFourOfAKindJokerCount() == fivepkSeoId.getSeoMachinePlayCount()) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						break;
					}
//					if (prefab == 5) {
//						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
//						if (prefabBuffMap == null) {
//							prefabBuffMap = new HashMap<Integer, Double>();
//							RANDOMBUFF.put(machineId, prefabBuffMap);
//						}
//						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
//						if (randomBuff == null) {
//							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
//							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
//							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
//							fivepkSeoId.setPrefabFourOfAKindJokerCount(plusWinCount);
//						}
//					} else {
//						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
//						if (prefabBuffMap != null) {
//							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
//						}
//					}
//					fivepkSeoId.setPrefabFourOfAKindJokerCount(fivepkSeoId.getPrefabFourOfAKindJokerCount() + winCount);
//					if (fivepkSeoId.getPrefabFourOfAKindJokerCount() >= totalWinCount) {
//						cr.setWinType(fivepkPrefab.getPrefabCards());
//						fivepkSeoId.setPrefabFourOfAKindJokerCount(0);
//						break;
//					}
				} else if (fivepkPrefab.getPrefabCards() == 120) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabStraightFlushCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabStraightFlushCount(fivepkSeoId.getPrefabStraightFlushCount() + winCount);
					if (fivepkSeoId.getPrefabStraightFlushCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabStraightFlushCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 250) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabFiveOfAKindCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabFiveOfAKindCount(fivepkSeoId.getPrefabFiveOfAKindCount() + winCount);
					if (fivepkSeoId.getPrefabFiveOfAKindCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFiveOfAKindCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 500) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabRoyalFlushCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabRoyalFlushCount(fivepkSeoId.getPrefabRoyalFlushCount() + winCount);
					if (fivepkSeoId.getPrefabRoyalFlushCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabRoyalFlushCount(0);
						break;
					}
				} else if (fivepkPrefab.getPrefabCards() == 1000) {
					if (prefab == 5) {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap == null) {
							prefabBuffMap = new HashMap<Integer, Double>();
							RANDOMBUFF.put(machineId, prefabBuffMap);
						}
						Double randomBuff = prefabBuffMap.get(fivepkPrefab.getPrefabCards());
						if (randomBuff == null) {
							randomBuff = FIVEPREFAB[RandomUtils.nextInt(0, 6)];
							prefabBuffMap.put(fivepkPrefab.getPrefabCards(), randomBuff);
							plusWinCount = (int) ((1000 * fivepkPrefab.getPrefabCards() * randomBuff));
							fivepkSeoId.setPrefabFiveBarsCount(plusWinCount);
						}
					} else {
						Map<Integer, Double> prefabBuffMap = RANDOMBUFF.get(machineId);
						if (prefabBuffMap != null) {
							prefabBuffMap.remove(fivepkPrefab.getPrefabCards());
						}
					}
					fivepkSeoId.setPrefabFiveBarsCount(fivepkSeoId.getPrefabFiveBarsCount() + winCount);
					if (fivepkSeoId.getPrefabFiveBarsCount() >= totalWinCount) {
						cr.setWinType(fivepkPrefab.getPrefabCards());
						fivepkSeoId.setPrefabFiveBarsCount(0);
						break;
					}
				}
			} 
			if (cr.getWinType() == 49) {
				cardArray = new byte[]{2,15,28,41,3};
				cr.setWinType2(49);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 78) {
				cardArray = new byte[]{11, 24, 37, 53, 1};
				cr.setWinType2(78);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 80) {
				cardArray = Arrays.copyOf(WINPOOLFOUROFAKINDJOKER[RandomUtils.nextInt(0, WINPOOLFOUROFAKINDJOKER.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 120) {
				cardArray = Arrays.copyOf(WINPOOLSTRAIGHTFLUSH[RandomUtils.nextInt(0, WINPOOLSTRAIGHTFLUSH.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 250) {
				cardArray = Arrays.copyOf(WINPOOLFIVEOFAKIND[RandomUtils.nextInt(0, WINPOOLFIVEOFAKIND.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 500) {
				cardArray = Arrays.copyOf(WINPOOLROYALFLUSH[RandomUtils.nextInt(0, WINPOOLROYALFLUSH.length)], cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			} else if (cr.getWinType() == 1000) {
				cardArray = Arrays.copyOf(WINPOOLFIVEBARS, cardArray.length);
				cr.setCards(cardArray);
				cr.setKeepCards(new byte[]{0, 1, 2, 3, 4});
			}  else if (loseCount != null &&
					loseCount > forceSevenBetterCount
					){
				cr.setWinType(1);
				int randomSevenBetterCards = RandomUtils.nextInt(7, 14);
				int firstRandomSevenBetterCards = randomSevenBetterCards + 13 * RandomUtils.nextInt(0, 2);
				int secondRandomSevenBetterCards = randomSevenBetterCards + 13 * RandomUtils.nextInt(2, 4);
				int first = RandomUtils.nextInt(0, 2);
				int second = RandomUtils.nextInt(2, 5);
				byte[] keepRandomSevenBetterCards = new byte[]{(byte) first, (byte) second};
				cr.setKeepCards(keepRandomSevenBetterCards);
				byte[] randomSevenBetterCardsArr = new byte[5];
				randomSevenBetterCardsArr[first] = (byte) firstRandomSevenBetterCards;
				randomSevenBetterCardsArr[second] = (byte) secondRandomSevenBetterCards;
				List<Integer> list = new ArrayList<Integer>();
				for (int i1 = 0; i1 < randomSevenBetterCardsArr.length; i1++) {
					if (randomSevenBetterCardsArr[i1] == 0) {
						int randomValue = 0;
						int randomValue1 = 0;
						int randomValue2 = 0;
						while (true) {
							randomValue = RandomUtils.nextInt(1, 53);
							randomValue1 = CardUtil.getCardValue(randomValue);
							randomValue2 = CardUtil.getCardValue(firstRandomSevenBetterCards);
							if (randomValue1 != randomValue2) {
								if (!list.contains(randomValue1)){
									list.add(randomValue1);
									break;
								}
							}
						}
						randomSevenBetterCardsArr[i1] = (byte) randomValue;
					}
				}
				cr.setCards(randomSevenBetterCardsArr);
				cardArray = cr.getCards();
				forceSevenBetterMap.put(machineId, loseCount);
			} else {
				cardArray = CardUtil.firstRandomCards1(cr, prefabs[5],
						prefabs[6],prefabs[7],prefabs[8],prefabs[9],
								prefabs[10],prefabs[11],prefabs[12],
										prefabs[13],prefabs[14], prefabs[15], prefabs[16]).getCards();
				
				cr.setCards(cardArray);
				cr.setWin(false);
			}

			if (fiveBars(cardArray, cr).isWin()) {
				cr.setWin(false);
				fiveBars1++;
				cr.setWinType(1000);
			} else if (royalFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				royalFlush1++;
				cr.setWinType(500);
			} else if (fiveOfAKind(cardArray, cr).isWin()) {
				cr.setWin(false);
				fiveOfAKind1++;
				cr.setWinType(250);
			} else if (straightFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				straightFlush1++;
				cr.setWinType(120);
			} else if (fourOfAKindJAJoker(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindJAJoker1++;
				cr.setWinType(80);
			} else if (fourOfAKindJA(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindJA1++;
				cr.setWinType(79);
			} else if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourOfAKindTwoTen1++;
				cr.setWinType(50);
			} else if (fullHouse(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(10);
				fullHouseCount1++;
			} else if (flush(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(7);
				flushCount1++;
			} else if (straight(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(5);
				straightCount1++;
			} else if (threeOfAKind(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(3);
				threeOfAKindCount1++;
			} else if (twoPairs(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType(2);
				twoPairsCount1++;
			} 
			else if (fourFlushStraightJokerNew(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount1++;
				cr.setWinType(1);
				cr.setWinType2(-5);
			} else if (fourFlushJoker(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount1++;
				cr.setWinType(1);
			} else if (fourStraightFourthJokerNew(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount1++;
				cr.setWinType(1);
			} 
			else if (sevenBetter(cardArray, cr).isWin()) {
				cr.setWin(false);
				sevenBetterCount1++;
				cr.setWinType(1);
			} else if (fourFlushStraightNew(cardArray, cr).isWin()) {
				cr.setWin(false);
				failCount1++;
				cr.setWinType2(-5);
			} else if (fourFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType2(-1);
				fourFlush1++;
			} 
			else if (fourStraight(cardArray, cr).isWin() || fourStraightThird(cardArray, cr).isWin() || fourStraightFourth(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType2(-2);
				fourStraight1++;
			} 
			else if (sevenBetterKeep(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setWinType2(-3);
				smallSevenBetterCount1++;
			} else {
				cr.setWin(false);
				cr.setWinType2(-4);
				failCount1++;
			}
			forceSevenBetterCount = fivepkSeoId.getPrefabForceSevenBetterCount();
			loseCount = forceSevenBetterMap.get(machineId);
			if (cr.getWinType2() != 49 && cr.getWinType2() != 78 && cr.getWinType() != 80 && cr.getWinType() != 120 && cr.getWinType() != 250 && cr.getWinType() != 500 && cr.getWinType() != 1000){
				cr = secondRandomCards2(cr, prefabs[5],
						prefabs[6],prefabs[7],prefabs[8],prefabs[9],
						prefabs[10],prefabs[11],prefabs[12],
								prefabs[13],prefabs[14],prefabs[15], prefabs[16]);
				cardArray = cr.getCards();
				if (loseCount != null && loseCount > forceSevenBetterCount){
					loseCount = 0;
					fivepkSeoId.setPrefabForceSevenBetterCount((byte) 0);
				}
			}
			
			if (fiveBars(cardArray, cr).isWin()) {
				cr.setWinType(1000);
				cr.setWin(false);
				fiveBars++;
			} else if (royalFlush(cardArray, cr).isWin()) {
				cr.setWinType(500);
				cr.setWin(false);
				royalFlush++;
			} else if (fiveOfAKind(cardArray, cr).isWin()) {
				cr.setWinType(250);
				cr.setWin(false);
				fiveOfAKind++;
			} else if (straightFlush(cardArray, cr).isWin()) {
				cr.setWinType(120);
				cr.setWin(false);
				straightFlush++;
			} else if (fourOfAKindJAJoker(cardArray, cr).isWin()) {
				cr.setWinType(80);
				cr.setWin(false);
				fourOfAKindJAJoker++;
			} else if (fourOfAKindJA(cardArray, cr).isWin()) {
				cr.setWinType(80);
				cr.setWin(false);
				fourOfAKindJA++;
			} else if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
				cr.setWinType(50);
				cr.setWin(false);
				fourOfAKindTwoTen++;
			} else if (fullHouse(cardArray, cr).isWin()) {
				cr.setWinType(10);
				cr.setWin(false);
				fullHouseCount++;
			} else if (flush(cardArray, cr).isWin()) {
				cr.setWinType(7);
				cr.setWin(false);
				flushCount++;
			} else if (straight(cardArray, cr).isWin()) {
				cr.setWinType(5);
				cr.setWin(false);
				straightCount++;
			} else if (threeOfAKind(cardArray, cr).isWin()) {
				cr.setWinType(3);
				cr.setWin(false);
				threeOfAKindCount++;
			} else if (twoPairs(cardArray, cr).isWin()) {
				cr.setWinType(2);
				cr.setWin(false);
				twoPairsCount++;
			} else if (sevenBetter(cardArray, cr).isWin()) {
				cr.setWinType(1);
				cr.setWin(false);
				sevenBetterCount++;
			} else if (fourFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourFlush++;
			} else if (fourStraight(cardArray, cr).isWin() || fourStraightThird(cardArray, cr).isWin() || fourStraightFourth(cardArray, cr).isWin()) {
				cr.setWin(false);
				fourStraight++;
			} else if (sevenBetterKeep(cardArray, cr).isWin()) {
				cr.setWin(false);
				smallSevenBetterCount++;
			} else {
				cr.setWin(false);
				failCount++;
			}
			if (cr.getWinType() == 0){
				if (forceSevenBetterCount == 0){
					String[] prefabRandomArray = random9998[fivepkSeoId.getPrefabForceSevenBetter()].split(",");
					fivepkSeoId.setPrefabForceSevenBetterCount((byte) RandomUtils.nextInt(Integer.parseInt(prefabRandomArray[0]), Integer.parseInt(prefabRandomArray[1])));
					forceSevenBetterCount = fivepkSeoId.getPrefabForceSevenBetterCount();
				}
				if (loseCount == null){
					loseCount = 0;
				}
				loseCount = loseCount + 1;
				
				forceSevenBetterMap.put(machineId, loseCount);
			} else {
				forceSevenBetterMap.remove(machineId);
			}
		}
		System.out.println("五鬼: " + fiveBars1 + " | " + (fiveBars1 == 0 ? 0 : totalCount / fiveBars1) + " | " + div(fiveBars1, totalCount));
		System.out.println("同花大顺: " + royalFlush1 + " | " + (royalFlush1 == 0 ? 0 : totalCount / royalFlush1) + " | " + div(royalFlush1, totalCount));
		System.out.println("五梅: " + fiveOfAKind1 + " | " + (fiveOfAKind1 == 0 ? 0 : totalCount / fiveOfAKind1) + " | " + div(fiveOfAKind1, totalCount));
		System.out.println("同花小顺: " + straightFlush1 + " | " + (straightFlush1 == 0 ? 0 : totalCount / straightFlush1) + " | " + div(straightFlush1, totalCount));
		System.out.println("正宗大四梅: " + fourOfAKindJAJoker1 + " | " + (fourOfAKindJAJoker1 == 0 ? 0 : totalCount / fourOfAKindJAJoker1) + " | " + div(fourOfAKindJAJoker1, totalCount));
//		System.out.println("大四梅: " + (fourOfAKindJA - fourOfAKindJAJoker) + " | " + ((fourOfAKindJA - fourOfAKindJAJoker) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA - fourOfAKindJAJoker), 2)) + " | " + div((fourOfAKindJA - fourOfAKindJAJoker), totalCount));
		System.out.println("大四梅: " + (fourOfAKindJA1) + " | " + ((fourOfAKindJA1) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA1), 2)) + " | " + div((fourOfAKindJA1), totalCount));
		System.out.println("小四梅: " + fourOfAKindTwoTen1 + " | " + (fourOfAKindTwoTen1 == 0 ? 0 : div1(totalCount, fourOfAKindTwoTen1, 2)) + " | " + div(fourOfAKindTwoTen1, totalCount));
		System.out.println("葫芦: " + fullHouseCount1 + " | " + (fullHouseCount1 == 0 ? 0 : div1(totalCount, fullHouseCount1, 2)) + " | " + div(fullHouseCount1, totalCount));
		System.out.println("同花: " + flushCount1 + " | " + (flushCount1 == 0 ? 0 : div1(totalCount, flushCount1, 2)) + " | " + div(flushCount1, totalCount));
		System.out.println("顺子: " + straightCount1 + " | " + (straightCount1 == 0 ? 0 : div1(totalCount, straightCount1, 2)) + " | " + div(straightCount1, totalCount));
		System.out.println("三条: " + threeOfAKindCount1 + " | " + (threeOfAKindCount1 == 0 ? 0 : div1(totalCount, threeOfAKindCount1, 2)) + " | " + div(threeOfAKindCount1, totalCount));
		System.out.println("两对: " + twoPairsCount1 + " | " + (twoPairsCount1 == 0 ? 0 : div1(totalCount, twoPairsCount1, 2)) + " | " + div(twoPairsCount1, totalCount));
		System.out.println("大一对: " + sevenBetterCount1 + " | " + (sevenBetterCount1 == 0 ? 0 : div1(totalCount, sevenBetterCount1, 2)) + " | " + div(sevenBetterCount1, totalCount));
		System.out.println("小一对: " + smallSevenBetterCount1 + " | " + (smallSevenBetterCount1 == 0 ? 0 : div1(totalCount, smallSevenBetterCount1, 2)) + " | " + div(smallSevenBetterCount1, totalCount));
		System.out.println("四張同花: " + fourFlush1 + " | " + (fourFlush1 == 0 ? 0 : div1(totalCount, fourFlush1, 2)) + " | " + div(fourFlush1, totalCount));
		System.out.println("四張順: " + fourStraight1 + " | " + (fourStraight1 == 0 ? 0 : div1(totalCount, fourStraight1, 2)) + " | " + div(fourStraight1, totalCount));
		System.out.println("乌龙: " + failCount1 + " | " + (failCount1 == 0 ? 0 : div1(totalCount, failCount1, 2)) + " | " + div(failCount1, totalCount));
		System.out.println("总赢局数: " + (sevenBetterCount1 + twoPairsCount1 + threeOfAKindCount1 + straightCount1 + flushCount1 + fullHouseCount1 + fourOfAKindTwoTen1 + fourOfAKindJA1 + straightFlush1 + fiveOfAKind1 + royalFlush1 + fiveBars1));
		System.out.println("中奖几率: " + div((sevenBetterCount1 + twoPairsCount1 + threeOfAKindCount1 + straightCount1 + flushCount1 + fullHouseCount1 + fourOfAKindTwoTen1 + fourOfAKindJA1 + straightFlush1 + fiveOfAKind1 + royalFlush1 + fiveBars1), totalCount));
		System.out.println("游戏几率: " + div((sevenBetterCount1 + twoPairsCount1 * 2 + threeOfAKindCount1 * 3 + straightCount1 * 5 + flushCount1 * 7 + fullHouseCount1 * 10 + fourOfAKindTwoTen1 * 50 + fourOfAKindJA1 * 80 + straightFlush1 * 120 + fiveOfAKind1 * 250 + royalFlush1 * 500 + fiveBars1 * 1000) * 1000, totalCount * 1000));
		System.out.println("--------------------第一手发牌结束-----------------------");
		System.out.println();
		System.out.println("五鬼: " + fiveBars + " | " + (fiveBars == 0 ? 0 : totalCount / fiveBars) + " | " + div(fiveBars, totalCount));
		System.out.println("同花大顺: " + royalFlush + " | " + (royalFlush == 0 ? 0 : totalCount / royalFlush) + " | " + div(royalFlush, totalCount));
		System.out.println("五梅: " + fiveOfAKind + " | " + (fiveOfAKind == 0 ? 0 : totalCount / fiveOfAKind) + " | " + div(fiveOfAKind, totalCount));
		System.out.println("同花小顺: " + straightFlush + " | " + (straightFlush == 0 ? 0 : totalCount / straightFlush) + " | " + div(straightFlush, totalCount));
		System.out.println("正宗大四梅: " + fourOfAKindJAJoker + " | " + (fourOfAKindJAJoker == 0 ? 0 : totalCount / fourOfAKindJAJoker) + " | " + div(fourOfAKindJAJoker, totalCount));
//		System.out.println("大四梅: " + (fourOfAKindJA - fourOfAKindJAJoker) + " | " + ((fourOfAKindJA - fourOfAKindJAJoker) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA - fourOfAKindJAJoker), 2)) + " | " + div((fourOfAKindJA - fourOfAKindJAJoker), totalCount));
		System.out.println("大四梅: " + (fourOfAKindJA) + " | " + ((fourOfAKindJA) <= 0 ? 0 : div1(totalCount, (fourOfAKindJA), 2)) + " | " + div((fourOfAKindJA), totalCount));
		System.out.println("小四梅: " + fourOfAKindTwoTen + " | " + (fourOfAKindTwoTen == 0 ? 0 : div1(totalCount, fourOfAKindTwoTen, 2)) + " | " + div(fourOfAKindTwoTen, totalCount));
		System.out.println("葫芦: " + fullHouseCount + " | " + (fullHouseCount == 0 ? 0 : div1(totalCount, fullHouseCount, 2)) + " | " + div(fullHouseCount, totalCount));
		System.out.println("同花: " + flushCount + " | " + (flushCount == 0 ? 0 : div1(totalCount, flushCount, 2)) + " | " + div(flushCount, totalCount));
		System.out.println("顺子: " + straightCount + " | " + (straightCount == 0 ? 0 : div1(totalCount, straightCount, 2)) + " | " + div(straightCount, totalCount));
		System.out.println("三条: " + threeOfAKindCount + " | " + (threeOfAKindCount == 0 ? 0 : div1(totalCount, threeOfAKindCount, 2)) + " | " + div(threeOfAKindCount, totalCount));
		System.out.println("两对: " + twoPairsCount + " | " + (twoPairsCount == 0 ? 0 : div1(totalCount, twoPairsCount, 2)) + " | " + div(twoPairsCount, totalCount));
		System.out.println("大一对: " + sevenBetterCount + " | " + (sevenBetterCount == 0 ? 0 : div1(totalCount, sevenBetterCount, 2)) + " | " + div(sevenBetterCount, totalCount));
		System.out.println("小一对: " + smallSevenBetterCount + " | " + (smallSevenBetterCount == 0 ? 0 : div1(totalCount, smallSevenBetterCount, 2)) + " | " + div(smallSevenBetterCount, totalCount));
		System.out.println("四張同花: " + fourFlush + " | " + (fourFlush == 0 ? 0 : div1(totalCount, fourFlush, 2)) + " | " + div(fourFlush, totalCount));
		System.out.println("四張順: " + fourStraight + " | " + (fourStraight == 0 ? 0 : div1(totalCount, fourStraight, 2)) + " | " + div(fourStraight, totalCount));
		System.out.println("乌龙: " + failCount + " | " + (failCount == 0 ? 0 : div1(totalCount, failCount, 2)) + " | " + div(failCount, totalCount));
		System.out.println("总赢局数: " + (sevenBetterCount + twoPairsCount + threeOfAKindCount + straightCount + flushCount + fullHouseCount + fourOfAKindTwoTen + fourOfAKindJA + straightFlush + fiveOfAKind + royalFlush + fiveBars));
		System.out.println("中奖几率: " + div((sevenBetterCount + twoPairsCount + threeOfAKindCount + straightCount + flushCount + fullHouseCount + fourOfAKindTwoTen + fourOfAKindJA + straightFlush + fiveOfAKind + royalFlush + fiveBars), totalCount));
		System.out.println("游戏几率: " + div((sevenBetterCount + twoPairsCount * 2 + threeOfAKindCount * 3 + straightCount * 5 + flushCount * 7 + fullHouseCount * 10 + fourOfAKindTwoTen * 50 + fourOfAKindJA * 80 + straightFlush * 120 + fiveOfAKind * 250 + royalFlush * 500 + fiveBars * 1000) * 1000, totalCount * 1000));
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
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue() * 100;
	}

	public static double div1(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static CardResult firstRandomCards1(CardResult cr, int... prefabs) {
		int nextInt = 0, newCardValue = 0;
		boolean isRepeated = false;
		// long startTime = System.currentTimeMillis();
		byte[] cardArray = null;
		Random r = new Random();
		while (true) {
			cardArray = new byte[5];
			for (int i = 0; i < cardArray.length; i++) {
				CardUtil.cards = doSort(CardUtil.cards);
				int jokerRandom9999 = Integer.parseInt(random9999[prefabs[11]].split(",")[0]);
				if (jokerRandom9999 != 100 && cr.getJokerCount() <= 0 && r.nextInt(1060) < jokerRandom9999) {
					newCardValue = joker;
					cr.setJokerCount(cr.getJokerCount() + 1);
				} else {
					while (true){
						nextInt = RandomUtils.nextInt(0, CardUtil.cards.length);
						newCardValue = CardUtil.cards[nextInt];
						if (newCardValue == joker){
							continue;
						}
						break;
					}
				}

				for (int j = 0; j < i; j++) {
					if (newCardValue != CardUtil.cards.length && cardArray[j] == newCardValue) {
						isRepeated = true;
						break;
					}
				}
				if (isRepeated) {
					isRepeated = false;
					i--;
					continue;
				}
				cardArray[i] = (byte) newCardValue;
			}
			cr.setCards(cardArray);
			if (royalFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(null);
				cr.setJokerCount(0);
				continue;
			} else if (fiveOfAKind(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(null);
				cr.setJokerCount(0);
				continue;
			} else if (straightFlush(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(null);
				cr.setJokerCount(0);
				continue;
			} else if (fourOfAKindJAJoker(cardArray, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(null);
				cr.setJokerCount(0);
				continue;
			} else if (fourOfAKindJA(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random79[prefabs[0]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (fourOfAKindTwoTen(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random50[prefabs[1]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (fullHouse(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random10[prefabs[2]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (flush(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random7[prefabs[3]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (straight(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random5[prefabs[4]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (threeOfAKind(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random3[prefabs[5]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (twoPairs(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random2[prefabs[6]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (sevenBetter(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random1[prefabs[7]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (fourFlush(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(randomNegative1[prefabs[8]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (fourStraight(cardArray, cr).isWin() || fourStraightThird(cardArray, cr).isWin() || fourStraightFourth(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(randomNegative2[prefabs[9]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			} else if (sevenBetterKeep(cardArray, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(randomNegative3[prefabs[10]].split(",")[0])) {
					cr.setWin(false);
					cr.setKeepCards(null);
					cr.setJokerCount(0);
					continue;
				}
				cr.setWin(false);
			}
			break;
		}
		return cr;
	}
	
	public static byte[] doSort(byte[] sArr) {
		@SuppressWarnings("unchecked")
		List<Byte> list = CollectionUtils.arrayToList(sArr);
		Collections.shuffle(list);
		byte[] newArray = ArrayUtils.toPrimitive(list.toArray(new Byte[list.size()]));
		return newArray;
	}
	
	public static CardResult secondRandomCards2(CardResult cr, int... prefabs) {
		cr.setWin(false);
		cr.setWinType(0);
		cr.setJokerCount(0);
		int nextInt = 0, cardValue = 0, cardColor = 0, compareCardValue = 0, compareCardColor = 0, newCardValue = 0;
		boolean isRepeated = false;
		boolean isKeep = false;
		byte[] cards = cr.getCards();
		byte[] oldCards = Arrays.copyOf(cards, 5);
		byte[] oldkeepCards = null;
		byte[] keepCards = cr.getKeepCards();
		if (keepCards != null) {
			oldkeepCards = Arrays.copyOf(keepCards, 5);
		}
		Random r = new Random();
		while (true) {
			for (int i = 0; i < cards.length; i++) {
				if (keepCards != null) {
					for (int k = 0; k < keepCards.length; k++) {
						if (i == keepCards[k]) {
							isKeep = true;
							break;
						}
					}
				}
				if (isKeep) {
					isKeep = false;
					continue;
				}
				CardUtil.cards = doSort(CardUtil.cards);
				int jokerRandom9999 = Integer.parseInt(random9999[prefabs[11]].split(",")[1]);
				if (jokerRandom9999 != 100 && cr.getJokerCount() <= 0 && r.nextInt(1060) < jokerRandom9999) {
					newCardValue = joker;
					cr.setJokerCount(cr.getJokerCount() + 1);
				} else {
					while (true) {
						nextInt = RandomUtils.nextInt(0, CardUtil.cards.length);
						newCardValue = CardUtil.cards[nextInt];
						boolean isContinue = false;
						for (int j = 0; j < oldCards.length; j++) {
							if (oldCards[j] == (byte) newCardValue) {
								isContinue = true;
								break;
							}
						}
						if (isContinue || newCardValue == joker) {
							continue;
						}
						break;
					}
				}
				compareCardColor = getCardColor(newCardValue);
				compareCardValue = getCardValue(newCardValue);
				if (keepCards != null) {
					for (int j = 0; j < cards.length; j++) {
						cardColor = getCardColor(cards[j]);
						cardValue = getCardValue(cards[j]);
						if (newCardValue != CardUtil.cards.length) {
							if (cards[j] == newCardValue
							// cardColor == compareCardColor ||
							// cardValue == compareCardValue
							) {
								isRepeated = true;
								break;
							}
						}
					}
				} else {
					for (int j = 0; j < i; j++) {
						if (newCardValue != CardUtil.cards.length && cards[j] == newCardValue) {
							isRepeated = true;
							break;
						}
					}
				}
				if (isRepeated) {
					isRepeated = false;
					i--;
					continue;
				}
				cards[i] = (byte) newCardValue;
			}

			if (royalFlush(cards, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(oldkeepCards);
				keepCards = null;
				cr.setJokerCount(0);
				continue;
			} else if (fiveOfAKind(cards, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(oldkeepCards);
				keepCards = null;
				cr.setJokerCount(0);
				continue;
			} else if (straightFlush(cards, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(oldkeepCards);
				keepCards = null;
				cr.setJokerCount(0);
				continue;
			} else if (fourOfAKindJAJoker(cards, cr).isWin()) {
				cr.setWin(false);
				cr.setKeepCards(oldkeepCards);
				keepCards = null;
				cr.setJokerCount(0);
				continue;
			} else if (fourOfAKindJA(cards, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random79[prefabs[0]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					// cr.setWinType(79);
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (fourOfAKindTwoTen(cards, cr).isWin()) {
				if (r.nextInt(100) < Integer.parseInt(random50[prefabs[1]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					// cr.setWinType(50);
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (fullHouse(cards, cr).isWin()) {
				if (cr.getWinType() < 10 && r.nextInt(100) < Integer.parseInt(random10[prefabs[2]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					// cr.setWinType(10);
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (flush(cards, cr).isWin()) {
				if (cr.getWinType() < 7 && r.nextInt(100) < Integer.parseInt(random7[prefabs[3]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					// cr.setWinType(7);
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (straight(cards, cr).isWin()) {
				if (cr.getWinType() < 5 && r.nextInt(100) < Integer.parseInt(random5[prefabs[4]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					// cr.setWinType(5);
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (threeOfAKind(cards, cr).isWin()) {
				if (cr.getWinType() < 3 && r.nextInt(100) < Integer.parseInt(random3[prefabs[5]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					// cr.setWinType(3);
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (twoPairs(cards, cr).isWin()) {
				if (cr.getWinType() < 2 && r.nextInt(100) < Integer.parseInt(random2[prefabs[6]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					cr.setWin(false);
					// cr.setWinType(2);
					continue;
				}
				cr.setWin(false);
			} else if (sevenBetter(cards, cr).isWin()) {
				if (cr.getWinType() < 1 && r.nextInt(100) < Integer.parseInt(random1[prefabs[7]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					cr.setWin(false);
					// cr.setWinType(1);
					continue;
				}
				cr.setWin(false);
			} else if (fourFlush(cards, cr).isWin()) {
				if (cr.getWinType2() < -1 && cr.getWinType2() > -5 && r.nextInt(100) < Integer.parseInt(randomNegative1[prefabs[8]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
					}
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (fourStraight(cards, cr).isWin() || fourStraightThird(cards, cr).isWin() || fourStraightFourth(cards, cr).isWin()) {
				if (cr.getWinType2() < -2 && cr.getWinType2() > -5 && r.nextInt(100) < Integer.parseInt(randomNegative2[prefabs[9]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
					}
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			} else if (sevenBetterKeep(cards, cr).isWin()) {
				if (cr.getWinType2() < -3 && cr.getWinType2() > -5 && r.nextInt(100) < Integer.parseInt(randomNegative3[prefabs[10]].split(",")[1])) {
					if (cr.getWinType2() == -4) {
						cr.setKeepCards(null);
						keepCards = null;
					}
					cr.setWin(false);
					continue;
				}
				cr.setWin(false);
			}
			break;
		}
		return cr;
	}

	public static CardResult sevenBetterKeep(byte[] cards, CardResult cr) {
		int card = 0, firstCardValue = 0, secondCardValue = 0, maxValue = 0, maxIndex = 0;
		boolean hasJoker = false, isWin = false;
		List<Byte> keepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				hasJoker = true;
				keepList.add((byte) i);
				continue;
			}
			firstCardValue = getCardValue(card);
			if (firstCardValue < 7) {
				if (firstCardValue == 1) {
					maxValue = firstCardValue;
					maxIndex = i;
				} else if (maxValue != 1 && firstCardValue > maxValue) {
					maxValue = firstCardValue;
					maxIndex = i;
				}
				if (hasJoker) {
					isWin = true;
				}
				for (int j = i + 1; j < cards.length; j++) {
					card = cards[j];
					secondCardValue = getCardValue(card);
					if (card == joker) {
						isWin = true;
					}
					if (secondCardValue < 7) {
						if (firstCardValue == secondCardValue) {
							keepList.add((byte) i);
							keepList.add((byte) j);
							cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
							return cr;
						}
					}
				}
			}
		}
		if (isWin) {
			keepList.add((byte) maxIndex);
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		return cr;
	}

	public static CardResult sevenBetter(byte[] cards, CardResult cr) {
		int card = 0, firstCardValue = 0, secondCardValue = 0, maxValue = 0, maxIndex = 0;
		boolean hasJoker = false, isWin = false;
		List<Byte> keepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				hasJoker = true;
				keepList.add((byte) i);
				continue;
			}
			firstCardValue = getCardValue(card);
			if (firstCardValue >= 7 || firstCardValue == 1) {
				if (firstCardValue == 1) {
					maxValue = firstCardValue;
					maxIndex = i;
				} else if (maxValue != 1 && firstCardValue > maxValue) {
					maxValue = firstCardValue;
					maxIndex = i;
				}
				if (hasJoker) {
					isWin = true;
				}
				for (int j = i + 1; j < cards.length; j++) {
					card = cards[j];
					secondCardValue = getCardValue(card);
					if (card == joker) {
						isWin = true;
					}
					if (secondCardValue >= 7 || secondCardValue == 1) {
						if (firstCardValue == secondCardValue) {
							keepList.add((byte) i);
							keepList.add((byte) j);
							cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
							return cr;
						}
					}
				}
			}
		}
		if (isWin) {
			keepList.add((byte) maxIndex);
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		return cr;
	}

	public static CardResult twoPairs(byte[] cards, CardResult cr) {
		int card = 0, firstCardValue = 0, secondCardValue = 0, count = 0;
		List<Byte> keepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				count++;
				keepList.add((byte) i);
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
					keepList.add((byte) i);
					keepList.add((byte) j);
					count++;
				}
			}
		}
		if (count >= 2) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		return cr;
	}

	public static void main(String[] args) {
		
		System.out.println(CardUtil.cards.length - 1);
		
		
		CardResult cr = new CardResult();
		cr.setCards(new byte[]{1, 4, 3, 5, 2});// third fixed
		cr.setCards(new byte[]{1, 5, 9, 8, 2});// second fixed
		cr.setCards(new byte[]{7, 9, 10, 13, 1});// second fixed
		cr.setCards(new byte[]{1, 5, 9, 8, 2});// second fixed
		cr.setCards(new byte[]{9, 5, 8, 1, 7});// third fixed
		cr.setCards(new byte[]{10, 12, 13, 1, 1});// third fixed
		cr.setCards(new byte[]{2, 1, 3, 13, 6});// third fixed
		cr.setCards(new byte[]{5, 12, 11, 2, 6});// third fixed
		cr.setCards(new byte[]{5, 12, 2, 4, 13});// second fixed
		cr.setCards(new byte[]{10, 11, 12, 3, 1});// third fixed
		cr.setCards(new byte[]{2, 3, 5, 6, 10});// second fixed
		cr.setCards(new byte[]{4, 12, 3, 1, 13});// fixed
		cr.setCards(new byte[]{11, 13, 1, 2, 10});// fixed
		cr.setCards(new byte[]{32, 19, 20, 23, 53});// fixed
		System.out.println(fourStraight(cr.getCards(), cr).isWin());
		System.out.println(Arrays.toString(cr.getKeepCards()));
		cr.setWin(false);
		cr.setKeepCards(null);
//		 System.out.println(fourStraightSecond(cr.getCards(), cr).isWin());
//		 System.out.println(Arrays.toString(cr.getKeepCards()));
//		 cr.setWin(false);
//		 cr.setKeepCards(null);
		System.out.println(fourStraightThird(cr.getCards(), cr).isWin());
		System.out.println(Arrays.toString(cr.getKeepCards()));
		cr.setWin(false);
		cr.setKeepCards(null);
		System.out.println(fourStraightFourth(cr.getCards(), cr).isWin());
		System.out.println(Arrays.toString(cr.getKeepCards()));
		cr.setWin(false);
		cr.setKeepCards(null);
		
		System.out.println(fourStraightFourthJoker(cr.getCards(), cr).isWin());
		System.out.println(Arrays.toString(cr.getKeepCards()));
		cr.setWin(false);
		cr.setKeepCards(null);
	}

	public static CardResult threeOfAKind(byte[] cards, CardResult cr) {
		int cardValue = 0, card = 0, jokerCount = 0, doubleMaxValue = 0, singleMaxValue = 0;
		Byte count = null;
		Map<Integer, Byte> countMap = new HashMap<Integer, Byte>(5);
		Map<Integer, List<Byte>> keepCardMap = new HashMap<Integer, List<Byte>>(5);
		List<Byte> keepCardList = null;
		List<Byte> keepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				continue;
			}
			cardValue = getCardValue(card);
			count = countMap.get(cardValue);
			if (cardValue == 1) {
				singleMaxValue = cardValue;
			} else if (singleMaxValue != 1 && cardValue > singleMaxValue) {
				singleMaxValue = cardValue;
			}
			if (count == null) {
				count = 1;
			} else {
				count++;
				if (cardValue == 1) {
					doubleMaxValue = cardValue;
				} else if (doubleMaxValue != 1 && cardValue > doubleMaxValue) {
					doubleMaxValue = cardValue;
				}
			}
			countMap.put(cardValue, count);
			keepCardList = keepCardMap.get(cardValue);
			if (keepCardList == null) {
				keepCardList = new ArrayList<Byte>();
				keepCardMap.put(cardValue, keepCardList);
			}
			keepCardList.add((byte) i);
		}
		if (jokerCount == 1 && doubleMaxValue != 0) {
			keepList.addAll(keepCardMap.get(doubleMaxValue));
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		if (jokerCount == 2 && singleMaxValue != 0) {
			keepList.addAll(keepCardMap.get(singleMaxValue));
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}

		for (int key : countMap.keySet()) {
			count = countMap.get(key);
			if (count >= 3) {
				keepList.addAll(keepCardMap.get(key));
				cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
				return cr;
			}
		}
		return cr;
	}

	public static CardResult straight(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, sum = 0, jokerCount = 0, aIndex = 0, maxValue = 0;
		byte card = 0, gapArray = 0;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
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
					indexMap.put(1, i);
					indexMap.put(14, i);
				} else {
					sortedCards[i] = (byte) cardValue;
					indexMap.put(cardValue, i);
				}
				sum += cardValue;
			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 4) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = card;
			}
		}
		if (maxValue <= 5 && isA) {
			sortedCards[aIndex] = 1;
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i] != joker && sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b >= 0) {
					gapArray += b;
					if (!keepList.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
						keepList.add(indexMap.get((int) sortedCards[i]).byteValue());
					}
					if (!keepList.contains(indexMap.get((int) sortedCards[i - 1]).byteValue())) {
						keepList.add(indexMap.get((int) sortedCards[i - 1]).byteValue());
					}
				} else {
					return cr;
				}
			}
		}
		if (gapArray <= jokerCount) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		} else if (sum / 5 == 0) {
			cr.setAfterWin(true, new byte[]{0, 1, 2, 3, 4});
		}
		return cr;
	}

	public static CardResult flush(byte[] cards, CardResult cr) {
		byte cardColor = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardColorCountMap = new HashMap<Byte, Byte>(5);
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepList = new ArrayList<Byte>();
		List<Byte> keepCardList = null;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				continue;
			}
			cardColor = (byte) getCardColor(card);
			Byte count = cardColorCountMap.get(cardColor);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardColorCountMap.put(cardColor, count);
			keepCardList = keepCardMap.get(cardColor);
			if (keepCardList == null) {
				keepCardList = new ArrayList<Byte>();
				keepCardMap.put(cardColor, keepCardList);
			}
			keepCardList.add((byte) i);
		}
		for (byte key : cardColorCountMap.keySet()) {
			if (cardColorCountMap.get(key) + jokerCount >= 5) {
				keepList.addAll(keepCardList);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
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
			cr.setAfterWin(true, new byte[]{0, 1, 2, 3, 4});
			return cr;
		}
		return cr;
	}

	public static CardResult fourOfAKindTwoTen(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0, jokerCount = 0, maxCardValue = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		Byte count = 0;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepCardList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				continue;
			}
			cardValue = (byte) getCardValue(card);
			if (2 <= cardValue && cardValue <= 10) {
				if (cardValue == 1) {
					maxCardValue = cardValue;
				} else if (maxCardValue != 1 && cardValue > maxCardValue) {
					maxCardValue = cardValue;
				}
				count = cardValueCountMap.get(cardValue);
				if (count == null) {
					count = 1;
				} else {
					count++;
				}
				keepCardList = keepCardMap.get(cardValue);
				if (keepCardList == null) {
					keepCardList = new ArrayList<Byte>();
					keepCardMap.put(cardValue, keepCardList);
				}
				keepCardList.add((byte) i);
				cardValueCountMap.put(cardValue, count);
			}
		}
		if (jokerCount == 3) {
			if (maxCardValue != 0) {
				keepList.addAll(keepCardMap.get(maxCardValue));
			} else {
				return cr;
			}
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		} else {
			for (Byte key : cardValueCountMap.keySet()) {
				count = cardValueCountMap.get(key);
				if (count + jokerCount >= 4) {
					keepList.addAll(keepCardMap.get(key));
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
			}
		}
		return cr;
	}

	public static CardResult fourOfAKindJAJoker(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0, jokerCount = 0, maxCardValue = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		Byte count = 0;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepCardList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				return cr;
			}
			cardValue = (byte) getCardValue(card);
			if (1 == cardValue || cardValue > 10) {
				if (cardValue == 1) {
					maxCardValue = cardValue;
				} else if (maxCardValue != 1 && cardValue > maxCardValue) {
					maxCardValue = cardValue;
				}
				count = cardValueCountMap.get(cardValue);
				if (count == null) {
					count = 1;
				} else {
					count++;
				}
				keepCardList = keepCardMap.get(cardValue);
				if (keepCardList == null) {
					keepCardList = new ArrayList<Byte>();
					keepCardMap.put(cardValue, keepCardList);
				}
				keepCardList.add((byte) i);
				cardValueCountMap.put(cardValue, count);
			}
		}
		if (jokerCount == 3) {
			if (maxCardValue != 0) {
				keepList.addAll(keepCardMap.get(maxCardValue));
			} else {
				return cr;
			}
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		} else {
			for (Byte key : cardValueCountMap.keySet()) {
				count = cardValueCountMap.get(key);
				if (count + jokerCount >= 4) {
					keepList.addAll(keepCardMap.get(key));
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
			}
		}
		return cr;
	}
	
	public static CardResult fourOfAKindJA(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0, jokerCount = 0, maxCardValue = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		Byte count = 0;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepCardList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				continue;
			}
			cardValue = (byte) getCardValue(card);
			if (1 == cardValue || cardValue > 10) {
				if (cardValue == 1) {
					maxCardValue = cardValue;
				} else if (maxCardValue != 1 && cardValue > maxCardValue) {
					maxCardValue = cardValue;
				}
				count = cardValueCountMap.get(cardValue);
				if (count == null) {
					count = 1;
				} else {
					count++;
				}
				keepCardList = keepCardMap.get(cardValue);
				if (keepCardList == null) {
					keepCardList = new ArrayList<Byte>();
					keepCardMap.put(cardValue, keepCardList);
				}
				keepCardList.add((byte) i);
				cardValueCountMap.put(cardValue, count);
			}
		}
		if (jokerCount == 3) {
			if (maxCardValue != 0) {
				keepList.addAll(keepCardMap.get(maxCardValue));
			} else {
				return cr;
			}
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		} else {
			for (Byte key : cardValueCountMap.keySet()) {
				count = cardValueCountMap.get(key);
				if (count + jokerCount >= 4) {
					keepList.addAll(keepCardMap.get(key));
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
			}
		}
		return cr;
	}

	public static CardResult straightFlush(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, sum = 0, jokerCount = 0, cardColor = 0, aIndex = 0, maxValue = 0;
		byte card = 0, gapArray = 0;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
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
				if (cardValue > maxValue) {
					maxValue = cardValue;
				}
				if (cardValue == 1) {
					sortedCards[i] = 14;
					isA = true;
					aIndex = i;
					sum += 14;
					indexMap.put(1, i);
					indexMap.put(14, i);
				} else {
					sortedCards[i] = (byte) cardValue;
					sum += cardValue;
					indexMap.put(cardValue, i);
				}

			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 4) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = (byte) cardValue;
			}
		}
		if (maxValue <= 5 && isA) {
			sortedCards[aIndex] = 1;
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i] != joker && sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b >= 0) {
					gapArray += b;
				}
				if (!keepList.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
					keepList.add(indexMap.get((int) sortedCards[i]).byteValue());
				}
				if (!keepList.contains(indexMap.get((int) sortedCards[i - 1]).byteValue())) {
					keepList.add(indexMap.get((int) sortedCards[i - 1]).byteValue());
				}
			}
		}
		if (gapArray <= jokerCount) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		if (sum / 5 == 0) {
			cr.setAfterWin(true, new byte[]{0, 1, 2, 3, 4});
			return cr;
		}
		return cr;
	}

	public static CardResult straightFlushWithPrefab(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, sum = 0, jokerCount = 0, cardColor = 0, aIndex = 0, maxValue = 0;
		byte card = 0, gapArray = 0;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
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
				if (cardValue > maxValue) {
					maxValue = cardValue;
				}
				if (cardValue == 1) {
					sortedCards[i] = 14;
					isA = true;
					aIndex = i;
					sum += 14;
					indexMap.put(1, i);
					indexMap.put(14, i);
				} else {
					sortedCards[i] = (byte) cardValue;
					sum += cardValue;
					indexMap.put(cardValue, i);
				}

			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 4) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = (byte) cardValue;
			}
		}
		if (maxValue <= 5 && isA) {
			sortedCards[aIndex] = 1;
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i] != joker && sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b >= 0) {
					gapArray += b;
				}
				if (!keepList.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
					keepList.add(indexMap.get((int) sortedCards[i]).byteValue());
				}
				if (!keepList.contains(indexMap.get((int) sortedCards[i - 1]).byteValue())) {
					keepList.add(indexMap.get((int) sortedCards[i - 1]).byteValue());
				}
			}
		}
		if (gapArray <= jokerCount) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		if (sum / 5 == 0) {
			cr.setAfterWin(true, new byte[]{0, 1, 2, 3, 4});
			return cr;
		}
		return cr;
	}

	public static CardResult fiveOfAKind(byte[] cards, CardResult cr) {
		byte cardValue = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardValueCountMap = new HashMap<Byte, Byte>(5);
		Byte count = 0;
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepList = new ArrayList<Byte>();
		List<Byte> keepCardList = null;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				// if (count + jokerCount >= 5) {
				// cr.setAfterWin(true,
				// ArrayUtils.toPrimitive(keepList.toArray(new
				// Byte[keepList.size()])));
				// return cr;
				// }
				continue;
			}
			cardValue = (byte) getCardValue(card);
			count = cardValueCountMap.get(cardValue);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardValueCountMap.put(cardValue, count);
			keepCardList = keepCardMap.get(cardValue);
			if (keepCardList == null) {
				keepCardList = new ArrayList<Byte>();
				keepCardMap.put(cardValue, keepCardList);
			}
			keepCardList.add((byte) i);
			if (count + jokerCount >= 5) {
				keepList.addAll(keepCardList);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
				return cr;
			}
		}
		for (byte key : cardValueCountMap.keySet()) {
			if (cardValueCountMap.get(key) + jokerCount >= 5) {
				keepCardList = keepCardMap.get(key);
				keepList.addAll(keepCardList);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
				return cr;
			}
		}
		return cr;
	}

	public static CardResult royalFlush(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, sum = 0, jokerCount = 0, cardColor = 0;
		byte card = 0, gapArray = 0;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
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
					indexMap.put(14, i);
				} else if (cardValue >= 10) {
					sortedCards[i] = (byte) cardValue;
					indexMap.put(cardValue, i);
				} else {
					return cr;
				}
				sum += cardValue;
			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 4) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = card;
			}
		}
		Arrays.sort(sortedCards);
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i] != joker && sortedCards[i - 1] != 0) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (b >= 0) {
					gapArray += b;
					if (gapArray <= jokerCount) {
						if (!keepList.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
							keepList.add(indexMap.get((int) sortedCards[i]).byteValue());
						}
						if (!keepList.contains(indexMap.get((int) sortedCards[i - 1]).byteValue())) {
							keepList.add(indexMap.get((int) sortedCards[i - 1]).byteValue());
						}
					}
				}
			}
		}
		if (gapArray <= jokerCount) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		} else if (sum / 5 == 0) {
			cr.setAfterWin(true, new byte[]{0, 1, 2, 3, 4});
		}
		return cr;
	}

	public static CardResult fiveBars(byte[] cards, CardResult cr) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] != CardUtil.cards.length) {
				return cr;
			}
		}
		cr.setAfterWin(true, new byte[]{0, 1, 2, 3, 4});
		return cr;
	}

	public static CardResult fourFlush(byte[] cards, CardResult cr) {
		byte cardColor = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardColorCountMap = new HashMap<Byte, Byte>(5);
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepList = new ArrayList<Byte>();
		List<Byte> keepCardList = null;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				continue;
			}
			cardColor = (byte) getCardColor(card);
			Byte count = cardColorCountMap.get(cardColor);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardColorCountMap.put(cardColor, count);
			keepCardList = keepCardMap.get(cardColor);
			if (keepCardList == null) {
				keepCardList = new ArrayList<Byte>();
				keepCardMap.put(cardColor, keepCardList);
			}
			keepCardList.add((byte) i);
		}
		for (byte key : cardColorCountMap.keySet()) {
			if (cardColorCountMap.get(key) + jokerCount >= 4) {
				keepCardList = keepCardMap.get(key);
				keepList.addAll(keepCardList);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
				return cr;
			}
		}
		return cr;
	}

	public static CardResult fourStraight(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, jokerCount = 0, aIndex = 0, maxValue = 0;
		byte card = 0, continueCount = 0, gapArray = 0, sortedIndex = 0;;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
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
					indexMap.put(1, i);
					indexMap.put(14, i);
				} else {
					sortedCards[i] = (byte) cardValue;
					indexMap.put(cardValue, i);
				}
			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 3) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = card;
			}
		}
		if (maxValue <= 4 && isA) {
			sortedCards[aIndex] = 1;
		}
		Arrays.sort(sortedCards);

		List<Byte> keepList2 = new ArrayList<Byte>();
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i] != joker) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				sortedIndex = indexMap.get((int) sortedCards[i]).byteValue();
				if (b == 0) {
					continueCount++;
					keepList.add(sortedIndex);
					if (continueCount + 1 + jokerCount >= 4) {
						keepList.add(indexMap.get((int) sortedCards[i - 1]).byteValue());
						break;
					}
				} else {
					continueCount = 0;
				}

				byte c = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				if (c > 0) {
					gapArray += b;
					if (keepList2.size() < 4 && !keepList2.contains(sortedIndex)) {
						keepList2.add(sortedIndex);
					}
				}
				if (c == 0) {
					gapArray += b;
					if (keepList2.size() < 4 && !keepList2.contains(sortedIndex)) {
						keepList2.add(sortedIndex);
					}
					if (keepList2.size() < 4 && !keepList2.contains(indexMap.get((int) sortedCards[i - 1]).byteValue())) {
						keepList2.add(indexMap.get((int) sortedCards[i - 1]).byteValue());
					}
				}
				if (c < 0 && i == 1) {
					if (keepList2.size() < 4 && !keepList2.contains(sortedIndex)) {
						keepList2.add(sortedIndex);
					}
				}
				if (b >= 0) {
					gapArray += b;
					if (keepList2.size() < 5) {
						if (!keepList2.contains(sortedIndex)) {
							keepList2.add(sortedIndex);
						}
					}
				}
				if (b < 0 && keepList2.size() < 5) {
					if (!keepList2.contains(sortedIndex)) {
						keepList2.add(sortedIndex);
					}
					if (!keepList2.contains(indexMap.get((int) sortedCards[i - 1]).byteValue())) {
						keepList2.add(indexMap.get((int) sortedCards[i - 1]).byteValue());
					}
				}
			}
		}
		if (continueCount + 1 + jokerCount >= 4) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		if (gapArray - jokerCount <= 1) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList2.toArray(new Byte[keepList2.size()])));
			return cr;
		}
		return cr;
	}

	// public static CardResult fourStraightSecond(byte[] cards, CardResult cr)
	// {
	// byte[] sortedCards = new byte[5];
	// int cardValue = 0, jokerCount = 0;
	// byte card = 0, continueCount = 0, gapArray = 0, sortedIndex = 0;;
	// boolean isA = false;
	// List<Byte> keepList = new ArrayList<Byte>();
	// List<Integer> aIndex = new ArrayList<Integer>();
	// Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
	// for (int i = 0; i < cards.length; i++) {
	// card = cards[i];
	// if (card != joker) {
	// cardValue = getCardValue(card);
	// if (cardValue == 1) {
	// sortedCards[i] = 1;
	// isA = true;
	// aIndex.add(i);
	// indexMap.put(1, i);
	// indexMap.put(14, i);
	// } else {
	// sortedCards[i] = (byte) cardValue;
	// indexMap.put(cardValue, i);
	// }
	// } else {
	// jokerCount++;
	// keepList.add((byte) i);
	// if (jokerCount >= 3) {
	// cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new
	// Byte[keepList.size()])));
	// return cr;
	// }
	// sortedCards[i] = card;
	// }
	// }
	// int oneToFourteen = 0;
	// for (int i = 0; i < sortedCards.length; i++) {
	// if (jqkList.contains(sortedCards[i])) {
	// oneToFourteen++;
	// }
	// }
	// if (oneToFourteen >= jqkList.size() && isA) {
	// for (int i = 0; i < aIndex.size(); i++) {
	// sortedCards[aIndex.get(i)] = 14;
	// }
	// }
	// Arrays.sort(sortedCards);
	//
	// List<Byte> keepCardList = new ArrayList<Byte>(5);
	// int totalGap = 0;
	// int gapCount = 0;
	// int oneCardGap = 0;
	// int keepJokerCount = jokerCount;
	// List<Byte> notKeepCardList = new ArrayList<Byte>(5);
	// int notKeepCardListSize = 0;
	// for (int i = sortedCards.length - 1; i > 0; i--) {
	// if (sortedCards[i] != joker) {
	// byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
	// if (b == 0) {
	// if (!keepCardList.contains(sortedCards[i])) {
	// keepCardList.add(sortedCards[i]);
	// }
	// if (!keepCardList.contains(sortedCards[i - 1])) {
	// keepCardList.add(sortedCards[i - 1]);
	// }
	// } else if (b == 1) {
	// if (keepJokerCount >= b || notKeepCardListSize >= b) {
	// if (!keepCardList.contains(sortedCards[i])) {
	// keepCardList.add(sortedCards[i]);
	// }
	// if (!keepCardList.contains(sortedCards[i - 1])) {
	// keepCardList.add(sortedCards[i - 1]);
	// }
	// keepJokerCount--;
	// notKeepCardListSize--;
	// } else {
	// totalGap += b;
	// oneCardGap++;
	// if (!keepCardList.contains(sortedCards[i])) {
	// notKeepCardList.add(sortedCards[i]);
	// notKeepCardListSize++;
	// }
	// }
	// gapCount++;
	// } else {
	//
	// if (b < 0) {
	// totalGap += -b;
	// } else {
	// totalGap += b;
	// }
	// gapCount++;
	// if (!keepCardList.contains(sortedCards[i])) {
	// notKeepCardList.add(sortedCards[i]);
	// notKeepCardListSize++;
	// }
	// if (!keepCardList.contains(sortedCards[i - 1])) {
	// notKeepCardList.add(sortedCards[i - 1]);
	// notKeepCardListSize++;
	// }
	// }
	// }
	// }
	//
	// if (gapCount >= 2 && totalGap >= 3) {
	// return cr;
	// }
	//
	// int notKeepCard = 0;
	// for (int i = sortedCards.length - 1; i > 0; i--) {
	// if (sortedCards[i] != joker) {
	// byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
	// if (b - jokerCount >= 1) {
	// if (!keepCardList.contains(sortedCards[i - 1])) {
	// notKeepCardList.add(sortedCards[i - 1]);
	// notKeepCard++;
	// }
	// if (!keepCardList.contains(sortedCards[i])) {
	// notKeepCardList.add(sortedCards[i]);
	// notKeepCard++;
	// }
	// }
	// }
	// }
	// // cr.setCards(new byte[]{7,9,10,13,14});
	// // if (totalGap > notKeepCard){
	// // return cr;
	// // }
	// // if (oneCardGap > notKeepCard && totalGap - notKeepCard > 0) {
	// // return cr;
	// // }
	// List<Byte> keepList2 = new ArrayList<Byte>();
	// for (int i = sortedCards.length - 1; i > 0; i--) {
	// if (sortedCards[i] != joker) {
	// byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
	// sortedIndex = indexMap.get((int) sortedCards[i]).byteValue();
	// if (b == 0) {
	// sortedIndex = indexMap.get((int) sortedCards[i]).byteValue();
	// if (!keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// sortedIndex = indexMap.get((int) sortedCards[i - 1]).byteValue();
	// if (!keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// } else if (b == 1) {
	// if (jokerCount > 0) {
	// sortedIndex = indexMap.get((int) sortedCards[i]).byteValue();
	// if (!keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// sortedIndex = indexMap.get((int) sortedCards[i - 1]).byteValue();
	// if (!keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// jokerCount--;
	// } else if (notKeepCard > 0) {
	// sortedIndex = indexMap.get((int) sortedCards[i]).byteValue();
	// if (!notKeepCardList.contains(sortedCards[i]) &&
	// !keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// sortedIndex = indexMap.get((int) sortedCards[i - 1]).byteValue();
	// if (!notKeepCardList.contains(sortedCards[i - 1]) &&
	// !keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// notKeepCard--;
	// }
	// } else if (b == 2) {
	// if (jokerCount + notKeepCard >= 2) {
	// sortedIndex = indexMap.get((int) sortedCards[i]).byteValue();
	// if (!notKeepCardList.contains(sortedCards[i]) &&
	// !keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// sortedIndex = indexMap.get((int) sortedCards[i - 1]).byteValue();
	// if (!notKeepCardList.contains(sortedCards[i - 1]) &&
	// !keepList2.contains(sortedIndex)) {
	// keepList2.add(sortedIndex);
	// }
	// jokerCount--;
	// notKeepCard--;
	// }
	// }
	// }
	// }
	// keepList.addAll(keepList2);
	// if (keepList.size() == 4) {
	// cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new
	// Byte[keepList.size()])));
	// return cr;
	// }
	// return cr;
	// }

	public static CardResult fourStraightThird(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, jokerCount = 0;
		byte card = 0, continueCount = 0, gapArray = 0, sortedIndex = 0, sortedIndex2 = 0;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		List<Integer> aIndex = new ArrayList<Integer>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					sortedCards[i] = 1;
					isA = true;
					aIndex.add(i);
					indexMap.put(1, i);
					indexMap.put(14, i);
				} else {
					sortedCards[i] = (byte) cardValue;
					indexMap.put(cardValue, i);
				}
			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 3) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = card;
			}
		}

		int oneToFourteen = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			if (jqkList.contains(sortedCards[i])) {
				oneToFourteen++;
			}
		}
		if (oneToFourteen >= 2 && isA) {
			for (int i = 0; i < aIndex.size(); i++) {
				sortedCards[aIndex.get(i)] = 14;
			}
		}

		Arrays.sort(sortedCards);
		int maxContinueValue = 0;
		List<Byte> checkRepeatedList = new ArrayList<Byte>();
		for (int i = sortedCards.length - 1; i > 0; i--) {
			if (sortedCards[i] != joker) {
				byte b = (byte) (sortedCards[i] - sortedCards[i - 1] - 1);
				sortedIndex = indexMap.get((int) sortedCards[i]).byteValue();
				sortedIndex2 = indexMap.get((int) sortedCards[i - 1]).byteValue();
				if (b == -1) {
					continue;
				}
				if (b == 0) {
					if (!checkRepeatedList.contains(sortedCards[i])) {
						if (!keepList.contains(sortedIndex)) {
							continueCount++;
							keepList.add(sortedIndex);
						}
						checkRepeatedList.add(sortedCards[i]);
						if (maxContinueValue < sortedCards[i]) {
							maxContinueValue = sortedCards[i];
						}
						if (continueCount + 1 + jokerCount >= 3) {
							if (!keepList.contains(sortedIndex2)) {
								keepList.add(sortedIndex2);
							}
							if (maxContinueValue < sortedCards[i - 1]) {
								maxContinueValue = sortedCards[i - 1];
							}
							break;
						}
					}
				} else {
					continueCount = 0;
					keepList.clear();
				}
			}
		}
		int firstIndex = 0;
		int firstValue = 0;
		int secondIndex = 0;
		int secondValue = 0;
		int thirdValue = 0;
		byte thirdIndex = 0;
		int resultGap = 0;
		List<Byte> keepList2 = new ArrayList<Byte>();
		// 1,4,5,7,9
		// 4,3,2,1
		// 1,2,3,5,7
		// 4,3,2,1
		// 7,53,9,2,5 先保了一对9 最好保 4张顺自带一对9
		boolean isRepeated = false;
		int checkRepeatedValue = 0;
		boolean isBreak = false;
		if (keepList.size() == 3) {
			Collections.sort(keepList);
			for (byte i = 0; i < cards.length; i++) {
				if (!keepList.contains(i)) {
					thirdValue = getCardValue(cards[i]);

					for (int j = 0; j < keepList.size(); j++) {
						firstIndex = keepList.get(j);
						firstValue = getCardValue(cards[firstIndex]);
						if (maxContinueValue > 4 && isA && firstValue == 1) {
							firstValue = 14;
						}
						if (maxContinueValue > 4 && isA && thirdValue == 1) {
							thirdValue = 14;
						}
						for (int j2 = 0; j2 < keepList.size(); j2++) {
							checkRepeatedValue = getCardValue(cards[keepList.get(j2)]);
							if (maxContinueValue > 4 && isA && checkRepeatedValue == 1) {
								checkRepeatedValue = 14;
							}
							if (thirdValue == checkRepeatedValue) {
								isRepeated = true;
							}
						}
						if (isRepeated) {
							isRepeated = false;
							break;
						}
						resultGap = thirdValue - firstValue - 1;
						thirdIndex = i;
						if (resultGap == 1 || resultGap == -3) {
							if (!keepList2.contains(thirdIndex) && !keepList.contains(thirdIndex)) {
								keepList2.add(thirdIndex);
								isBreak = true;
								break;
							}
						}
					}
					if (isBreak) {
						break;
					}
				}
			}
		}
		keepList.addAll(keepList2);
		if (keepList.size() == 4) {
			cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
			return cr;
		}
		return cr;
	}

	public static CardResult fourStraightFourthJoker(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, jokerCount = 0;
		byte card = 0, continueCount = 0, gapArray = 0, sortedIndex = 0;;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		List<Integer> aIndex = new ArrayList<Integer>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					sortedCards[i] = 1;
					isA = true;
					aIndex.add(i);
					indexMap.put(1, i);
					indexMap.put(14, i);
				} else {
					sortedCards[i] = (byte) cardValue;
					indexMap.put(cardValue, i);
				}
			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 3) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = card;
				indexMap.put((int)card, i);
			}
		}
		if (jokerCount == 0){
			return cr;
		}
		int oneToFourteen = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			if (jqkList.contains(sortedCards[i])) {
				oneToFourteen++;
			}
		}
		if (oneToFourteen >= 2 && isA) {
			for (int i = 0; i < aIndex.size(); i++) {
				sortedCards[aIndex.get(i)] = 14;
			}
		}
		Arrays.sort(sortedCards);
		List<Byte> keepList2 = new ArrayList<Byte>(5);

		byte sortedValue = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			sortedValue = sortedCards[i];
			List<Byte> keepList3 = new ArrayList<Byte>(5);
			for (int j = 1; j < 5; j++) {
				for (int j2 = i + 1; j2 < sortedCards.length; j2++) {
					if (sortedValue + j == sortedCards[j2] || sortedCards[j2] == joker) {
						if (!keepList3.contains(indexMap.get((int) sortedCards[j2]).byteValue())) {
							keepList3.add(indexMap.get((int) sortedCards[j2]).byteValue());
						}
					}
				}
				if (keepList3.size() >= 3) {
					if (!keepList3.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
						keepList3.add(indexMap.get((int) sortedCards[i]).byteValue());
						cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList3.toArray(new Byte[keepList3.size()])));
						return cr;
					}
				}

			}
		}
		return cr;
	}
	
	public static CardResult fourStraightFourth(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, jokerCount = 0;
		byte card = 0, continueCount = 0, gapArray = 0, sortedIndex = 0;;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		List<Integer> aIndex = new ArrayList<Integer>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					sortedCards[i] = 1;
					isA = true;
					aIndex.add(i);
					indexMap.put(1, i);
					indexMap.put(14, i);
				} else {
					sortedCards[i] = (byte) cardValue;
					indexMap.put(cardValue, i);
				}
			} else {
				jokerCount++;
				keepList.add((byte) i);
				if (jokerCount >= 3) {
					cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
					return cr;
				}
				sortedCards[i] = card;
				indexMap.put((int)card, i);
			}
		}
		int oneToFourteen = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			if (jqkList.contains(sortedCards[i])) {
				oneToFourteen++;
			}
		}
		if (oneToFourteen >= 2 && isA) {
			for (int i = 0; i < aIndex.size(); i++) {
				sortedCards[aIndex.get(i)] = 14;
			}
		}
		Arrays.sort(sortedCards);
		List<Byte> keepList2 = new ArrayList<Byte>(5);

		byte sortedValue = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			sortedValue = sortedCards[i];
			List<Byte> keepList3 = new ArrayList<Byte>(5);
			for (int j = 1; j < 5; j++) {
				for (int j2 = i + 1; j2 < sortedCards.length; j2++) {
					if (sortedValue + j == sortedCards[j2] || sortedCards[j2] == joker) {
						if (!keepList3.contains(indexMap.get((int) sortedCards[j2]).byteValue())) {
							keepList3.add(indexMap.get((int) sortedCards[j2]).byteValue());
						}
					}
				}
				if (keepList3.size() >= 3) {
					if (!keepList3.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
						keepList3.add(indexMap.get((int) sortedCards[i]).byteValue());
						cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList3.toArray(new Byte[keepList3.size()])));
						return cr;
					}
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

	public static byte compareCard() {
		int nextInt = RandomUtils.nextInt(1, CardUtil.cards.length + 1);
		return (byte) nextInt;
	}

	public static CardResult fourFlushStraightJokerNew(byte[] cards, CardResult cr) {

		byte cardColor = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardColorCountMap = new HashMap<Byte, Byte>(5);
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepList = new ArrayList<Byte>();
		List<Byte> keepCardList = null;
		int cardValue = 0;
		boolean isA = false;
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		List<Byte> newKeepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				newKeepList.add((byte) i);
				continue;
			} else {
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					isA = true;
					indexMap.put(14, i);
				}
				indexMap.put(cardValue, i);
			}

			cardColor = (byte) getCardColor(card);
			Byte count = cardColorCountMap.get(cardColor);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardColorCountMap.put(cardColor, count);
			keepCardList = keepCardMap.get(cardColor);
			if (keepCardList == null) {
				keepCardList = new ArrayList<Byte>();
				keepCardMap.put(cardColor, keepCardList);
			}
			keepCardList.add((byte) i);
		}
		for (byte key : cardColorCountMap.keySet()) {
			if (cardColorCountMap.get(key) + jokerCount >= 4) {
				keepCardList = keepCardMap.get(key);
				keepList.addAll(keepCardList);
				break;
			}
		}
		if (jokerCount == 0) {
			return cr;
		}
		if (keepList.size() < 4) {
			return cr;
		}

		byte[] sortedCards = new byte[5];
		for (int i = 0; i < keepList.size(); i++) {
			card = cards[keepList.get(i)];
			if (card != joker) {
				cardValue = getCardValue(card);
				sortedCards[i] = (byte) cardValue;

				if (cardValue == 1) {
					isA = true;
					indexMap.put(14, (int) keepList.get(i));
				}
				indexMap.put(cardValue, (int) keepList.get(i));
			}
		}
		if (isA && keepList.contains(indexMap.get(1).byteValue())) {
			byte[] newSortedCards = new byte[6];
			System.arraycopy(sortedCards, 0, newSortedCards, 0, sortedCards.length);
			newSortedCards[5] = 14;
			sortedCards = newSortedCards;
		}
		Arrays.sort(sortedCards);
		byte straightValue = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			if (sortedCards[i] == 0) {
				byte[] newSortedCards = new byte[sortedCards.length - 1];
				System.arraycopy(sortedCards, i + 1, newSortedCards, 0, newSortedCards.length);
				sortedCards = newSortedCards;
				i--;
			}
		}
		for (int i = sortedCards.length - 1; i >= 0; i--) {
			List<Byte> keepList2 = new ArrayList<Byte>(5);
			straightValue = sortedCards[i];
			for (int j = 1; j <= 4; j++) {
				for (int j2 = i; j2 >= 0; j2--) {
					if (straightValue - j == sortedCards[j2]) {
						if (sortedCards[j2] == 0) {
							continue;
						}
						if (!keepList2.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
							keepList2.add(indexMap.get((int) sortedCards[i]).byteValue());
						}
						if (!keepList2.contains(indexMap.get((int) sortedCards[j2]).byteValue())) {
							keepList2.add(indexMap.get((int) sortedCards[j2]).byteValue());
						}
					}
				}
			}

			if (keepList2.size() >= 3) {
				newKeepList.addAll(keepList2);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(newKeepList.toArray(new Byte[newKeepList.size()])));
				return cr;
			}
		}
		return cr;
	}

	public static CardResult fourStraightFourthJokerNew(byte[] cards, CardResult cr) {
		byte[] sortedCards = new byte[5];
		int cardValue = 0, jokerCount = 0;
		byte card = 0, continueCount = 0, gapArray = 0, sortedIndex = 0;;
		boolean isA = false;
		List<Byte> keepList = new ArrayList<Byte>();
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card != joker) {
				cardValue = getCardValue(card);
				sortedCards[i] = (byte) cardValue;
				if (cardValue == 1) {
					isA = true;
					indexMap.put(14, i);
				}
				indexMap.put(cardValue, i);
			} else {
				jokerCount++;
				keepList.add((byte) i);
			}
		}
		if (jokerCount == 0) {
			return cr;
		}
		if (isA) {
			byte[] newSortedCards = new byte[6];
			System.arraycopy(sortedCards, 0, newSortedCards, 0, sortedCards.length);
			newSortedCards[5] = 14;
			sortedCards = newSortedCards;
		}
		Arrays.sort(sortedCards);
		byte straightValue = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			if (sortedCards[i] == 0) {
				byte[] newSortedCards = new byte[sortedCards.length - 1];
				System.arraycopy(sortedCards, i + 1, newSortedCards, 0, newSortedCards.length);
				sortedCards = newSortedCards;
				i--;
			}
		}
		for (int i = sortedCards.length - 1; i >= 0; i--) {
			straightValue = sortedCards[i];
			if (straightValue == 0) {
				continue;
			}
			List<Byte> keepList2 = new ArrayList<Byte>(5);
			for (int j = 1; j <= 4; j++) {
				for (int j2 = i; j2 >= 0; j2--) {
					if (straightValue - j == sortedCards[j2]) {
						if (sortedCards[j2] == 0) {
							continue;
						}
						if (!keepList2.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
							keepList2.add(indexMap.get((int) sortedCards[i]).byteValue());
						}
						if (!keepList2.contains(indexMap.get((int) sortedCards[j2]).byteValue())) {
							keepList2.add(indexMap.get((int) sortedCards[j2]).byteValue());
						}
					}
				}
			}

			if (keepList2.size() >= 3) {
				keepList.addAll(keepList2);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
				return cr;
			}
		}
		return cr;
	}

	public static CardResult fourFlushStraightNew(byte[] cards, CardResult cr) {

		byte cardColor = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardColorCountMap = new HashMap<Byte, Byte>(5);
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepList = new ArrayList<Byte>();
		List<Byte> keepCardList = null;
		int cardValue = 0;
		boolean isA = false;
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		List<Byte> newKeepList = new ArrayList<Byte>();
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				newKeepList.add((byte) i);
				continue;
			} else {
				cardValue = getCardValue(card);
				if (cardValue == 1) {
					isA = true;
					indexMap.put(14, i);
				}
				indexMap.put(cardValue, i);
			}

			cardColor = (byte) getCardColor(card);
			Byte count = cardColorCountMap.get(cardColor);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardColorCountMap.put(cardColor, count);
			keepCardList = keepCardMap.get(cardColor);
			if (keepCardList == null) {
				keepCardList = new ArrayList<Byte>();
				keepCardMap.put(cardColor, keepCardList);
			}
			keepCardList.add((byte) i);
		}
		for (byte key : cardColorCountMap.keySet()) {
			if (cardColorCountMap.get(key) + jokerCount >= 4) {
				keepCardList = keepCardMap.get(key);
				keepList.addAll(keepCardList);
				break;
			}
		}
		if (keepList.size() < 4) {
			return cr;
		}

		byte[] sortedCards = new byte[5];
		for (int i = 0; i < keepList.size(); i++) {
			card = cards[keepList.get(i)];
			if (card != joker) {
				cardValue = getCardValue(card);
				sortedCards[i] = (byte) cardValue;

				if (cardValue == 1) {
					isA = true;
					indexMap.put(14, (int) keepList.get(i));
				}
				indexMap.put(cardValue, (int) keepList.get(i));
			}
		}
		if (isA && keepList.contains(indexMap.get(1).byteValue())) {
			byte[] newSortedCards = new byte[6];
			System.arraycopy(sortedCards, 0, newSortedCards, 0, sortedCards.length);
			newSortedCards[5] = 14;
			sortedCards = newSortedCards;
		}
		Arrays.sort(sortedCards);
		byte straightValue = 0;
		for (int i = 0; i < sortedCards.length; i++) {
			if (sortedCards[i] == 0) {
				byte[] newSortedCards = new byte[sortedCards.length - 1];
				System.arraycopy(sortedCards, i + 1, newSortedCards, 0, newSortedCards.length);
				sortedCards = newSortedCards;
				i--;
			}
		}
		for (int i = sortedCards.length - 1; i >= 0; i--) {
			List<Byte> keepList2 = new ArrayList<Byte>(5);
			straightValue = sortedCards[i];
			for (int j = 1; j <= 4; j++) {
				for (int j2 = i; j2 >= 0; j2--) {
					if (straightValue - j == sortedCards[j2]) {
						if (sortedCards[j2] == 0) {
							continue;
						}
						if (!keepList2.contains(indexMap.get((int) sortedCards[i]).byteValue())) {
							keepList2.add(indexMap.get((int) sortedCards[i]).byteValue());
						}
						if (!keepList2.contains(indexMap.get((int) sortedCards[j2]).byteValue())) {
							keepList2.add(indexMap.get((int) sortedCards[j2]).byteValue());
						}
					}
				}
			}

			if (keepList2.size() >= 4) {
				newKeepList.addAll(keepList2);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(newKeepList.toArray(new Byte[newKeepList.size()])));
				return cr;
			}
		}
		return cr;
	}
	
	public static CardResult fourFlushJoker(byte[] cards, CardResult cr) {
		byte cardColor = 0, card = 0, jokerCount = 0;
		Map<Byte, Byte> cardColorCountMap = new HashMap<Byte, Byte>(5);
		Map<Byte, List<Byte>> keepCardMap = new HashMap<Byte, List<Byte>>(5);
		List<Byte> keepList = new ArrayList<Byte>();
		List<Byte> keepCardList = null;
		for (int i = 0; i < cards.length; i++) {
			card = cards[i];
			if (card == joker) {
				jokerCount++;
				keepList.add((byte) i);
				continue;
			}
			cardColor = (byte) getCardColor(card);
			Byte count = cardColorCountMap.get(cardColor);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			cardColorCountMap.put(cardColor, count);
			keepCardList = keepCardMap.get(cardColor);
			if (keepCardList == null) {
				keepCardList = new ArrayList<Byte>();
				keepCardMap.put(cardColor, keepCardList);
			}
			keepCardList.add((byte) i);
		}
		if (jokerCount == 0) {
			return cr;
		}
		for (byte key : cardColorCountMap.keySet()) {
			if (cardColorCountMap.get(key) + jokerCount >= 4) {
				keepCardList = keepCardMap.get(key);
				keepList.addAll(keepCardList);
				cr.setAfterWin(true, ArrayUtils.toPrimitive(keepList.toArray(new Byte[keepList.size()])));
				return cr;
			}
		}
		return cr;
	}
}
