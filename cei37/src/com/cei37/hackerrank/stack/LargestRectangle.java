package com.cei37.hackerrank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
	1 2 3 4 5
 	b b b b b
   	  b b b b
        b b b
          b b
            b

Problem Statement

There are N buildings in a certain one-dimensional landscape. Each building has a height given by hi,i∈[1,N]. If you join K adjacent buildings, they will form a solid rectangle of area K×min(hi,hi+1,…,hi+k−1).

Given N buildings, find the greatest such solid area formed by consecutive buildings.

Input Format 
The first line contains N, the number of buildings altogether. 
The second line contains N space-separated integers, each representing the height of a building.

Constraints 
1≤N≤105 
1≤hi≤106
Output Format 
One integer representing the maximum area of rectangle formed.


*/
public class LargestRectangle {
	private int numBulding;
	private List<Building> buildings = new ArrayList<Building>();
	private Stack<Building> stack = new Stack<Building>();
	
	public static void main(String[] args) {
		LargestRectangle lr = new LargestRectangle();
		lr.input();
		System.out.println(lr.getLargestRectangle());
	}
	
	public int getLargestRectangle() {
		int largestRectangle=0;
		int i=0;
		for (Building b: buildings){
			if (stack.isEmpty() || b.getHeight() > stack.peek().getHeight()) {
				stack.push(b);
			} else if (b.getHeight() < stack.peek().getHeight()) {
				int lastIndex=0;
				while(!stack.isEmpty() && b.getHeight()<stack.peek().getHeight()) {
					Building tem = stack.pop();
					lastIndex = tem.getBuildingId();
					int temArea=tem.getHeight() * (i - lastIndex);
					if (largestRectangle < temArea) { 
						largestRectangle = temArea;
					}
				}
				b.setBuildingId(lastIndex);
				stack.push(b);
			}
			i++;
		}
		
		while(!stack.isEmpty()) {
			Building tem = stack.pop();
			int temArea=tem.getHeight() * (buildings.size() - tem.getBuildingId());
			if (largestRectangle < temArea) { 
				largestRectangle = temArea;
			}
		}
		
		return largestRectangle;
	}
	
	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        try{
        	//System.out.println("Enter the number of building:");
        	numBulding = Integer.parseInt(br.readLine());
        	int i=0;
        	String values = br.readLine();
        	String arg[] = values.split(" ");
        	while(i<numBulding) {
        		Building b = new Building();
        		b.setBuildingId(i);
        		//System.out.print("Enter the height for building "+i++ +"\t");
        		b.setHeight(Integer.parseInt(arg[i]));
        		i++;
            	buildings.add(b);
        	}
        } catch(NumberFormatException e){
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class Building {
		private int height;
		private int buildingId;

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getBuildingId() {
			return buildingId;
		}

		public void setBuildingId(int buildingId) {
			this.buildingId = buildingId;
		}
	}
}