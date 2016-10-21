package com.mzm.firephoenix.cardutils;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
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
		final JTextField countjtf = new JTextField(10);
		countjtf.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					cta.setText("");
					CardUtil cu = new CardUtil();
					cu.test(countjtf.getText());
		        }
			}
			
			public void keyPressed(KeyEvent e) {
			}
		});
		JButton jb = new JButton("发牌");
		jb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cta.setText("");
				CardUtil cu = new CardUtil();
				cu.test(countjtf.getText());
			}
		});
		northJP.add(countJL);
		northJP.add(countjtf);
		northJP.add(jb);

		jf.setSize(300, 400);
		jf.setResizable(true);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		//cardutils-0.0.1-SNAPSHOT.jar
	}
}
