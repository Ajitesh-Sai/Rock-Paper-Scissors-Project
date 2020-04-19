package com.java.Rock_Paper_Scissors;

import java.util.HashMap;
import java.util.Map;

abstract public class Players {
	int choice;
	Map<Integer, String> map = new HashMap<>();
	void setMap() {
		map.put(1, "Rock");
		map.put(2, "Paper");
		map.put(3, "Scissors");
	}
	abstract public void setChoice();
	abstract public String getChoice(); 
}
