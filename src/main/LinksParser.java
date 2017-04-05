package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author Ilyas
 */
public class  LinksParser {
	private File sourceDataFile;
	private BufferedReader freader;
	
	private HashMap<String, String> links = new HashMap<String, String>(); 
	
	public LinksParser(String filePath) throws FileNotFoundException {
		this.sourceDataFile = new File(filePath);
		
		if (!this.sourceDataFile.isFile()) {
			throw new FileNotFoundException("Файл со списком ссылок не найден!");
		}
		
		this.freader = new BufferedReader(new FileReader(this.sourceDataFile));
	}
	
	/**
	 * Парсит файл и заполняет коллекцию ссылками
	 */
	public void parseData() {
		String line;
		String[] linkData;
		
		try {
			while ((line = this.freader.readLine()) != null) {
				linkData = line.split(" ");
				
				this.links.put(linkData[0], linkData[1]);
			}
			
			this.freader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Возвращает коллекцию со ссылками
	 * @return HashMap<String, String>
	 */
	public HashMap<String, String> getLinks() {
		return this.links;
	}
}
