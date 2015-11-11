package com.cei37.dealer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SumUpKey {

	/**
	 * @author: Vicente Villegas Larios
	 * @mail: cei37@hotmail.com
	 * Program to sum up keys in a text file.
	 */
	public static void main(String[] args) {
		SumUpKey sum = new SumUpKey();
		try {
			Map<String,Integer> result = sum.sumUpKeys();
			for(Map.Entry<String, Integer> elem : result.entrySet()) {
				System.out.println(elem.getKey() + " --> " + elem.getValue());
			}
		} catch (SumUpException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String,Integer> sumUpKeys() throws SumUpException {
		File file = new File("/file.txt");
		FileReader fileReader = null;
		
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			throw new SumUpException(String.format("The file %s is not available.", file.getAbsolutePath()));
		}
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Map<String,Integer> map = new HashMap<String, Integer>();
		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				String arr[] = line.split(",");
				if (map.get(arr[0])!=null) {
					map.put(arr[0], map.get(arr[0]) + Integer.valueOf(arr[1]));
				} else {
					map.put(arr[0], Integer.valueOf(arr[1]));
				}
			}
		} catch (NumberFormatException e) {
			throw new SumUpException("Number format exception "+e.getMessage());
		} catch (IOException e) {
			throw new SumUpException(e);
		} finally {
			try {
				if (bufferedReader!=null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				/*
				 * do nothing for now
				 */
			}
			try {
				if (fileReader!=null) {
					fileReader.close();
				}
			} catch (IOException e) {
				/*
				 * do nothing for now
				 */
			}
		}
		return map;
	}
}

class SumUpException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SumUpException(String message, Throwable cause) {
		super(message, cause);
	}

	public SumUpException(String message) {
		super(message);
	}

	public SumUpException(Throwable cause) {
		super(cause);
	}
}