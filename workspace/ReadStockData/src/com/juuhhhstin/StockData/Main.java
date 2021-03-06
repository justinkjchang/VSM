package com.juuhhhstin.StockData;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception{
		// array for 
		ArrayList<String> stocksList = new ArrayList<String>(); // array for list of stocks
		StockInfo StockInfo = new StockInfo(); // create StockInfo object to retrieve data from yahoo finance
		String symbol = "";
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("List the companies you would like to get stock info for.");
		System.out.println("Enter 0 to exit");
		
		while(true){
			symbol = in.nextLine();
			if(String.valueOf(symbol).equals("")){
				break;
			}
			stocksList.add(symbol); // add stock symbol to array
		}

		// call "getCurrentPrice" function and display
		for(int i = 0; i < stocksList.size(); i++){
			//stocksList.get(i).toUpperCase();
			StockInfo.getCurrentPrice(stocksList.get(i).toUpperCase()); // print current price for each stock symbol
			StockInfo.getStockName(stocksList.get(i).toUpperCase()); // print stock name of each stock symbol
		}
		
		System.out.println("Done retrieving data");
		
		//Stock.getCurrentPrice(stocksList.get(0));
		
	}
}
