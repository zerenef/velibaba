package com.velibaba.model.functions;

public class KategoriFunctions {
	
	public static String createUrl(String url) {
		url = url.toLowerCase().replace(" ", "-");
        char[] turkishChars = new char[] {0x131, 0xFC, 0xF6, 0x15F, 0xE7, 0x11F};
	    char[] englishChars = new char[] {'i', 'u', 'o', 's', 'c', 'g'};
	    for (int i = 0; i < turkishChars.length; i++) {
		    url = url.replaceAll(String.valueOf(turkishChars[i]), String.valueOf(englishChars[i]));
	    }	
		return url;
	}

	public static Long urlParser(String url) {
		String[] id = url.split("-");
		return(Long.valueOf(id[id.length-1]));
	}
	
}
