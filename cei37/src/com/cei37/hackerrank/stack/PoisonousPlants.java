package com.cei37.hackerrank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class PoisonousPlants {
	
	public static void main(String[] args) {
		PoisonousPlants pp = new PoisonousPlants();
		pp.input();
		System.out.println(pp.getNumberDays());
	}

	private Stack<Plant> plants = new Stack<Plant>();
	
	private int getNumberDaysO() {
		int numDays = 0;
		Stack<Plant> temPlants = new Stack<Plant>();
		while(true) {
			numDays++;
			int sizeP1 = plants.size();
			while(!plants.isEmpty()) {
				Plant p = plants.pop();
				if (plants.isEmpty() || p.getPesticide()<=plants.peek().getPesticide()){
					temPlants.push(p);
				}
			}
			int sizeP2 = temPlants.size();
			if (sizeP1==sizeP2) {
				return --numDays;
			}
			while(!temPlants.isEmpty()) {
				plants.push(temPlants.pop());
			}
		}
	}
	
	private int getNumberDays() {
		int numDays = 0;
		Stack<Plant> temPlants = new Stack<Plant>();
		while(true) {
			numDays++;
			int sizeP1 = plants.size();
			while(!plants.isEmpty()) {
				Plant p = plants.pop();
				if (plants.isEmpty() || p.getPesticide()<=plants.peek().getPesticide()){
					temPlants.push(p);
				}
			}
			int sizeP2 = temPlants.size();
			if (sizeP1==sizeP2) {
				return --numDays;
			}
			while(!temPlants.isEmpty()) {
				plants.push(temPlants.pop());
			}
		}
	}
	
	private void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numPlants = 0;
        try{
        	//System.out.println("Enter the number of plants:\t");
        	numPlants = Integer.parseInt(br.readLine());
        	int i=0;
        	String values = br.readLine();
        	String arg[] = values.split(" ");
        	while(i<numPlants) {
        		Plant b = new Plant();
        		b.setIndex(i);
        		//System.out.print("Enter the pesticide for plant "+i++ +":\t");
        		b.setPesticide(Integer.parseInt(arg[i]));
        		i++;
        		plants.push(b);
        	}
        } catch(NumberFormatException e){
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class Plant {
		private int pesticide;
		private int index;
		
		public int getPesticide() {
			return pesticide;
		}
		
		public void setPesticide(int pesticide) {
			this.pesticide = pesticide;
		}
		
		public int getIndex() {
			return index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
	}
}
