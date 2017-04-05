package main;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Loader {
	private URL target;
	private BufferedInputStream in;
	private FileOutputStream fout;
	private File file;
	
	/**
	 * Класс загрузки файлов по ссылке.
	 */
	public Loader() {
		/**
		 * Set CNTLM local proxy for access network
		 */
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "3130");
	}
	
	/*
	public Loader(String url, String outputFileName) {
		/**
		 * Set CNTLM local proxy for access network
		 *//*
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "3130");
		
		try {
			this.target = new URL(url);
			
            this.in = new BufferedInputStream(this.target.openStream());
            
            this.file = new File("C:/" + outputFileName);
            
            if (!this.file.isFile()) {
            	throw new FileNotFoundException("Файл не найден");
            }
            
			this.fout = new FileOutputStream(this.file);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/
	
	public void loadData() {
		try {
			URL url = new URL("http://lib.ru/LONDON/lifelove.txt");
			URLConnection urlConnect = url.openConnection();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnect.getInputStream()));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void writeData(String loadUrl, String outputFile) {
		byte[] data = new byte[1];
		int count, bytesDownloaded = 0;
		
		try {
			URL url = new URL(loadUrl);
			
			BufferedInputStream in = new BufferedInputStream(url.openStream());
			
			FileOutputStream fout = new FileOutputStream(new File("C:/Users/Ilyas/" + outputFile));
			
			Thread currentThread = Thread.currentThread();
			
			/*
			 * Ограничение пока не работает.
			if ((bytesDownloaded%1048576) == 0) {
				currentThread.sleep(1000);
			}*/
			
			while ((count = in.read(data, 0, 1)) != -1) {
				fout.write(data);
				bytesDownloaded++;
			}
			
			fout.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
