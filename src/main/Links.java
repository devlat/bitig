package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * 
 * @author Ilyas
 *
 * Класс парсит файл со ссылками и хранит их в HashMap
 */
public class Links {
	private File srcFile; // исходный файл со ссылками
	private BufferedReader freader;
	
	private HashMap<String, String> linksData = new HashMap<String, String>();
	
	/**
	 * Инициализируем BufferedReader
	 * @param filePath путь к файлу со списком ссылок
	 * @throws FileNotFoundException
	 */
	public Links(String filePath) throws FileNotFoundException {
		this.srcFile = new File(filePath);
		
		if (!this.srcFile.isFile()) {
			throw new FileNotFoundException("Файл со списком ссылок не найден!");
		}
		
		this.freader = new BufferedReader(new FileReader(this.srcFile));
		
		this.parseFile();
	}
	
	/**
	 * Парсинг файла со ссылками.
	 */
	private void parseFile() {
		String line; // строка
		String[] linkData; // массив с ссылкой и файлом сохранения
		
		try {
			while ((line = this.freader.readLine()) != null) {
				linkData = line.split(" ");
				
				this.linksData.put(linkData[0], linkData[1]);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				this.freader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Возвращает коллекцию со ссылками
	 * @return HashMap<String, String>
	 */
	public HashMap<String, String> getLinks() {
		return this.linksData;
	}
}
