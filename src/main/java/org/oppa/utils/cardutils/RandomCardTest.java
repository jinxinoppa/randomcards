package org.oppa.utils.cardutils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RandomCardTest {
	public static void main(String[] args) throws IOException {
		JFrame jf = new JFrame("随机发牌检测工具");

		BorderLayout bl = new BorderLayout();
		jf.setLayout(bl);
		JPanel northJP = new JPanel();
		northJP.setPreferredSize(new Dimension(800, 100));
		northJP.setVisible(true);
		final ConsoleTextArea cta = new ConsoleTextArea();
		cta.setEditable(false);
		jf.add(northJP, BorderLayout.NORTH);
		jf.add(new JScrollPane(cta), BorderLayout.CENTER);
		JLabel countJL = new JLabel("次数");
		final CardUtil cu = new CardUtil();
		final JTextField countjtf = new JTextField(10);
		JLabel fiveBarsJL = new JLabel("五鬼");
		JLabel royalFlushJL = new JLabel("同花大顺");
		JLabel fiveOfAKindJL = new JLabel("五梅");
		JLabel straightFlushJL = new JLabel("同花小顺");
		JLabel fourOfAKindJAJokerJL = new JLabel("正宗大四梅");
		JLabel fourOfAKindjaJL = new JLabel("大四梅出现率");
		JLabel fourOfAKindJAJL = new JLabel("大四梅累积率");
		JLabel fourOfAKindTwoTenJL = new JLabel("小四梅出现率");
		JLabel fourOfAKindTTJL = new JLabel("小四梅累积率");
		JLabel fullHouseJL = new JLabel("葫芦");
		JLabel flushJL = new JLabel("同花");
		JLabel straightJL = new JLabel("顺子");
		JLabel threeOfAKindJL = new JLabel("三条");
		JLabel twoPairsJL = new JLabel("两对");
		JLabel sevenBetterJL = new JLabel("一对");
		JLabel fourFlushJL = new JLabel("四张同花");
		JLabel fourStraightJL = new JLabel("四张顺");
		JLabel sevenBetterKeepJL = new JLabel("小对");
		JLabel jokerJL = new JLabel("鬼牌");
//		JLabel fourOfAKindTwoTenTwoJL = new JLabel("小四梅连庄");
		JLabel forceSevenBetterJL = new JLabel("强制一对");
		final JComboBox<Integer> prefab = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab.addItem(i);
		}
		prefab.setSelectedIndex(6);
		final JComboBox<Integer> prefab1 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab1.addItem(i);
		}
		prefab1.setSelectedIndex(6);
		final JComboBox<Integer> prefab2 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab2.addItem(i);
		}
		prefab2.setSelectedIndex(6);
		final JComboBox<Integer> prefab3 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab3.addItem(i);
		}
		prefab3.setSelectedIndex(5);
		final JComboBox<Integer> prefab4 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab4.addItem(i);
		}
		prefab4.setSelectedIndex(7);
		final JComboBox<Integer> prefab5 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab5.addItem(i);
		}
		prefab5.setSelectedIndex(3);
		final JComboBox<Integer> prefab6 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab6.addItem(i);
		}
		prefab6.setSelectedIndex(5);
		final JComboBox<Integer> prefab7 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab7.addItem(i);
		}
		prefab7.setSelectedIndex(4);
		final JComboBox<Integer> prefab8 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab8.addItem(i);
		}
		prefab8.setSelectedIndex(4);
		final JComboBox<Integer> prefab9 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab9.addItem(i);
		}
		prefab9.setSelectedIndex(4);
		final JComboBox<Integer> prefab10 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab10.addItem(i);
		}
		prefab10.setSelectedIndex(4);
		final JComboBox<Integer> prefab11 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab11.addItem(i);
		}
		prefab11.setSelectedIndex(4);
		final JComboBox<Integer> prefab12 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab12.addItem(i);
		}
		prefab12.setSelectedIndex(4);
		final JComboBox<Integer> prefab13 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab13.addItem(i);
		}
		prefab13.setSelectedIndex(4);
		final JComboBox<Integer> prefab14 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab14.addItem(i);
		}
		prefab14.setSelectedIndex(4);
		final JComboBox<Integer> prefab15 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab15.addItem(i);
		}
		prefab15.setSelectedIndex(4);
		final JComboBox<Integer> prefab16 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab16.addItem(i);
		}
		prefab16.setSelectedIndex(4);
		final JComboBox<Integer> prefab17 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab17.addItem(i);
		}
		prefab17.setSelectedIndex(4);
		final JComboBox<Integer> prefab18 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab18.addItem(i);
		}
		prefab18.setSelectedIndex(4);
		final JComboBox<Integer> prefab19 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab19.addItem(i);
		}
//		prefab19.setSelectedIndex(3);
		final JComboBox<Integer> prefab20 = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab20.addItem(i);
		}
		prefab20.setSelectedIndex(4);
		countjtf.setText("20000");
		countjtf.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					cta.setText("");
					cu.printAndExcelForceSevenBetter(countjtf.getText(), prefab.getSelectedIndex(), prefab1.getSelectedIndex(), prefab2.getSelectedIndex(), prefab3.getSelectedIndex(), prefab4.getSelectedIndex(), 
							prefab5.getSelectedIndex(), prefab6.getSelectedIndex(), prefab7.getSelectedIndex(), prefab8.getSelectedIndex(), prefab9.getSelectedIndex(), prefab10.getSelectedIndex(), 
							prefab11.getSelectedIndex(), prefab12.getSelectedIndex(), prefab13.getSelectedIndex(), prefab14.getSelectedIndex(), prefab15.getSelectedIndex(), prefab16.getSelectedIndex(), 
							prefab17.getSelectedIndex(), prefab18.getSelectedIndex()
							, 
							prefab19.getSelectedIndex(), 
							prefab20.getSelectedIndex()
							);
//					cu.firstAndSecond(countjtf.getText());
				}
			}

			public void keyPressed(KeyEvent e) {
			}
		});

		JButton jb = new JButton("发牌");
		jb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cta.setText("");
				cu.printAndExcelForceSevenBetter(countjtf.getText(), prefab.getSelectedIndex(), prefab1.getSelectedIndex(), prefab2.getSelectedIndex(), prefab3.getSelectedIndex(), prefab4.getSelectedIndex(),
						prefab5.getSelectedIndex(), prefab6.getSelectedIndex(), prefab7.getSelectedIndex(), prefab8.getSelectedIndex(), prefab9.getSelectedIndex(), prefab10.getSelectedIndex(), 
						prefab11.getSelectedIndex(), prefab12.getSelectedIndex(), prefab13.getSelectedIndex(), prefab14.getSelectedIndex(), prefab15.getSelectedIndex(), prefab16.getSelectedIndex(), 
						prefab17.getSelectedIndex(), prefab18.getSelectedIndex()
						,
						prefab19.getSelectedIndex(), 
						prefab20.getSelectedIndex()
						);
//				cu.firstAndSecond(countjtf.getText());
			}
		});
		northJP.add(countJL);
		northJP.add(countjtf);

		northJP.add(fiveBarsJL);
		northJP.add(prefab);
		northJP.add(royalFlushJL);
		northJP.add(prefab1);
		northJP.add(fiveOfAKindJL);
		northJP.add(prefab2);
		northJP.add(straightFlushJL);
		northJP.add(prefab3);
		northJP.add(fourOfAKindJAJokerJL);
		northJP.add(prefab4);
		
		northJP.add(fourOfAKindjaJL);
		northJP.add(prefab5);
		northJP.add(fourOfAKindTwoTenJL);
		northJP.add(prefab6);
		northJP.add(fullHouseJL);
		northJP.add(prefab7);
		northJP.add(flushJL);
		northJP.add(prefab8);
		northJP.add(straightJL);
		northJP.add(prefab9);
		northJP.add(threeOfAKindJL);
		northJP.add(prefab10);
		northJP.add(twoPairsJL);
		northJP.add(prefab11);
		northJP.add(sevenBetterJL);
		northJP.add(prefab12);
		northJP.add(fourFlushJL);
		northJP.add(prefab13);
		northJP.add(fourStraightJL);
		northJP.add(prefab14);
		northJP.add(sevenBetterKeepJL);
		northJP.add(prefab15);
		northJP.add(jokerJL);
		northJP.add(prefab16);
		northJP.add(fourOfAKindJAJL);
		northJP.add(prefab17);
		northJP.add(fourOfAKindTTJL);
		northJP.add(prefab18);
//		northJP.add(fourOfAKindTwoTenTwoJL);
//		northJP.add(prefab19);
		northJP.add(forceSevenBetterJL);
		northJP.add(prefab20);
		
		
		northJP.add(jb);

		jf.setSize(820, 600);
		jf.setResizable(true);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
	}
}
