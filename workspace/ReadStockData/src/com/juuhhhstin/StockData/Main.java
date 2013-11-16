package com.juuhhhstin.StockData;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;


public class Main {
	public static void main(String[] args) throws Exception{
		// array for 
		ArrayList<String> stocksList = new ArrayList<String>(); // array for list of stocks
		StockInfo StockInfo = new StockInfo(); // create StockInfo object to retrieve data from yahoo finance
		String symbol = "";
		int noErrors = 1;
		
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
		//while(noErrors == 1){
			
		//}
		// call "getCurrentPrice" function and display
		try{
			for(int i = 0; i < stocksList.size(); i++){
				System.out.println(stocksList.get(i).toUpperCase() + ": " 
						+ StockInfo.getCurrentPrice(stocksList.get(i)) + ": " // print current price for each stock
						+ StockInfo.getStockName(stocksList.get(i)));  // print full name of each stock
			}
		} catch (NumberFormatException e){
			System.out.println("Number format exception");
		} catch (TimeoutException ex){
			System.out.println("Timeout Exception");
		} catch (SocketTimeoutException STE){
			System.out.println("Socket Timeout Exception");
		} catch (UnknownHostException UHE){
			System.out.println("Unknown Host Exception: Not connected to internet");
		}
		
		System.out.println("Done retrieving data");
		
		//Stock.getCurrentPrice(stocksList.get(0));
		
	}
}
