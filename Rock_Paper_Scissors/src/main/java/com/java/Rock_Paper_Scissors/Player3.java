package com.java.Rock_Paper_Scissors;

import java.util.Scanner;

public class Player3 extends Players {
	Scanner sc = new Scanner(System.in);
	public void setChoice() {
		System.out.println("Enter your choice- player#3:");
		choice=sc.nextInt();
		if(choice < 1 || choice > 3) {
			System.out.println("Invalid choice. Choose again");
			setChoice();
		}
	}
	public String getChoice() {
		setMap();
		return map.get(choice);		
	}
}
