package com.juuhhhstin.StockData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StockInfo {
	
	public String getStockName(String symbol) throws Exception{
		
		String url  = "http://finance.yahoo.com/q?s=" + symbol; // set string to URL
		Document document = Jsoup.connect(url).get(); // use Jsoup to connect to url & convert to document
		String text = document.toString(); // convert document to string variable
		
		int p = text.indexOf("<title>", 0); // look for <title> and change to index
		int from = text.indexOf("Summary for ", p);
		int to   = text.indexOf("- Yahoo! Finance", from);
		String name = text.substring(from + 12, to);
		
		return name;
	}
	
	public double getCurrentPrice(String symbol) throws Exception{
		
		String url  = "http://finance.yahoo.com/q?s=" + symbol; // set string to URL
		
		Document document = Jsoup.connect(url).get(); //using Jsoup to connect and parse URL
		String text = document.toString(); // convert Jsoup document to string
		
		int from = text.indexOf("yfs_l84", 0); // look for yfs_l84 and start index there to read price
		int to = text.indexOf("</span></span>", from);
		String price = text.substring(from + 10 + symbol.length(), to); // get price substring
		price = price.replace(",",""); // remove commas in price values
		
		return Double.parseDouble(price); // return price converted to a double
	}
}
