package main;

import main.Links;
import main.Loader;

import java.util.Map.Entry;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		System.out.println("App started");
		
		try {
			Links links = new Links("C:/Bitig/links.txt");
			Loader loader = new Loader();
			
			for (Entry<String, String> link : links.getLinks().entrySet()) {
				System.out.println(link.getKey() + " " + link.getValue());
				loader.writeData(link.getKey(), link.getValue());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Thread t = Thread.currentThread();
		
		Thread someT = new Thread(new SomeThread(), "some");
		
		someT.start();
		
		System.out.println(t);
		
		System.out.println("End...");
	 */
	
	/**
	 * try {
			URL url = new URL("http://habrahabr.ru");
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			
			http.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 */
	
	/**
	 * try {
			URL url = new URL("http://habrahabr.ru");
			URLConnection conn = url.openConnection();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String data;
			
			while ((data = bf.readLine()) != null) {
				System.out.println(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 */

}
