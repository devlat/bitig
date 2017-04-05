package main;

public class Dict {
	private static Dict instance;
	
	private char[] latinAlphabet = {'a', 'b', 'ç', 'ş', 'd', 'ä', 'f', 'g', 'ğ', 'h', 'i', 'c', 'k', 'l', 'm', 'n', 'ñ', 'o', 'ö', 'p', 'q', 'r', 's', 't', 'u', 'ü', 'w', 'v', 'x', 'í', 'z', 'j', 'ı', 'e'};
	
	private Dict() {}
	
	public static Dict getInstance() {
		if (instance == null) {
			instance = new Dict();
		}
		
		return instance;
	}
	
	public char[] getAlphabet() {
		return this.latinAlphabet;
	}
}
