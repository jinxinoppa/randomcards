package org.oppa.utils.cardutils;

import java.awt.BorderLayout;
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
		northJP.setVisible(true);
		final ConsoleTextArea cta = new ConsoleTextArea();
		jf.add(northJP, BorderLayout.NORTH);
		jf.add(new JScrollPane(cta), BorderLayout.CENTER);
		JLabel countJL = new JLabel("次数");
		final CardUtil cu = new CardUtil();
		final JTextField countjtf = new JTextField(10);
		
		JComboBox<String> cards = new JComboBox<String>();
//		cards.addItem("五鬼");
//		cards.addItem("同花大顺");
		cards.addItem("同花小顺");
//		cards.addItem("大四梅");
//		cards.addItem("小四梅");
//		cards.addItem("葫芦");
//		cards.addItem("同花");
//		cards.addItem("顺子");
//		cards.addItem("三条");
//		cards.addItem("两对");
//		cards.addItem("一对");
		final JComboBox<Integer> prefab = new JComboBox<Integer>();
		for (int i = 0; i < 8; i++) {
			prefab.addItem(i);
		}
		
		
		countjtf.setText("10000");
		countjtf.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					cta.setText("");
					cu.printAndExcel(countjtf.getText(), prefab.getSelectedIndex());
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
				cu.printAndExcel(countjtf.getText(), prefab.getSelectedIndex());
//				cu.firstAndSecond(countjtf.getText());
			}
		});
		northJP.add(countJL);
		northJP.add(countjtf);

		northJP.add(cards);
		northJP.add(prefab);

		northJP.add(jb);

		jf.setSize(400, 400);
		jf.setResizable(true);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
	}
}
