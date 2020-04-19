package com.java.Rock_Paper_Scissors;

import java.util.Scanner;
import java.awt.Container;
import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//rock - 1
//paper - 2
//scissors - 3

//Paper beats Rock
//Rock beats Scissors
//Scissors beats Paper

public class App {
	ApplicationContext context = new ClassPathXmlApplicationContext("players.xml");
	
	Scanner sc = new Scanner(System.in);
	
	int ch1, ch2, ch3, ch4;
	int p1p2,p1p3,p1p4,p2p1,p2p3,p2p4,p3p1,p3p2,p3p4,p4p1,p4p2,p4p3;
	
	Players p1 = (Players) context.getBean("player1");
	Players p2 = (Players) context.getBean("player2");
	Players p3 = (Players) context.getBean("player3");
	Players p4 = (Players) context.getBean("player4");

	public void setChoices(JFrame f, JPanel p, int i) {		
		
		System.out.println("Choose from the following:\n->1 = Rock\n->2 = Paper\n->3 = Scissors");
		p1.setChoice(); 
		ch1=p1.choice;
		p2.setChoice();
		ch2=p2.choice;
		p3.setChoice();
		ch3=p3.choice;		
		p4.setChoice();
		ch4=p4.choice;
		p1p2 += getWinner(ch1, ch2);
		p1p3 += getWinner(ch1, ch3);
		p1p4 += getWinner(ch1, ch4);

		
		p2p1 += getWinner(ch2, ch1);
		p2p3 += getWinner(ch2, ch3);
		p2p4 += getWinner(ch2, ch4);

		
		p3p1 += getWinner(ch3, ch1);
		p3p2 += getWinner(ch3, ch2);
		p3p4 += getWinner(ch3, ch4);

	
		p4p1 += getWinner(ch4, ch1);
		p4p2 += getWinner(ch4, ch2);
		p4p3 += getWinner(ch4, ch3);

		
		Object[][] data2 = new String[5][6];
		data2[0] = new String[]{"", "", "Player 1", "Player 2", "Player 3", "Player 4"};
		data2[1] = new String[]{"Player Wins","Player 1","-", ""+p1p2, ""+p1p3, ""+p1p4};
		data2[2] = new String[]{"","Player 2",""+p2p1, "-", ""+p2p3, ""+p2p4};
		data2[3] = new String[]{"", "Player 3",""+p3p1, ""+p3p2, "-", ""+p3p4};
		data2[4] = new String[]{"", "Player 4",""+p4p1, ""+p4p2, ""+p4p3, "-"};
		
		Object[][] data1 = new String[1][4];
		data1[0] = new String[] {p1.getChoice(), p2.getChoice(), ""+p3.getChoice(), ""+p4.getChoice() };
	
		Object[] columns2 = new String[6];
		columns2[0] = "Totals";
		columns2[1] = " ";
		columns2[3] = " Against ";
		columns2[2] = "";
		columns2[4] = "";
		columns2[5] = "";

		Object columns1[] = new String[] {"Player 1", "Player 2", "Player 3", "Player 4"};
		
		JTable table1 = new JTable(data1, columns1);
		JTable table2 = new JTable(data2, columns2);
		JLabel t = new JLabel();
		if(i==1)
			t.setText("1st Iteration");
		else if(i==2) 
			t.setText("2nd Iteration");
		else if(i==3)
			t.setText("3rd Iteration");
		else 
			t.setText(i+"th Iteration");
		
		Container c = f.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(t);
		p.add(table1.getTableHeader());
		p.add(table1);
		p.add(table2.getTableHeader());
		p.add(table2);
		
		JScrollPane sp1 = new JScrollPane(p);
		c.add(sp1);
		
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
			
		
	}
	public int getWinner(int c1, int c2) {
		int res = -1;
		switch(c1) {
			case 1: switch(c2) {
				case 1: res = 0;break;
				case 2: res = 0;break;
				case 3: res = 1;break;
			}break;
			case 2: switch(c2) {
				case 1: res = 1;break;
				case 2: res = 0;break;
				case 3: res = 0;break;
			}break;
			case 3: switch(c2) {
				case 1: res = 0;break;
				case 2: res = 1;break;
				case 3: res = 0;break;
			}break;
		}
		return res;
	}
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		JFrame f = new JFrame();
		f.setTitle("Results");
		JPanel p = new JPanel();
		App a = new App();
		String ch = "y";
		for(int i=1; i<=50; i++) {
			if(i>1) {
				System.out.println("Do you want to play another round (y/n)? ");
				ch = s.nextLine();
			}
			if(ch.equalsIgnoreCase("y")) {
				a.setChoices(f, p, i);
			}
			else 
				System.exit(0);
		}
		s.close();
		 
	}
	
	
}



