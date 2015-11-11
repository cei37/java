package com.cei37.regex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class TestSeeker {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Pattern pattern = Pattern.compile("[^.?!\\s][^.?!\\r\\n]*(?:[.?!]['\"]?(?!\\s*['\"]|\\s+[A-Z]|$)[^.?!\\r\\n]*|(?:\\n|\\r\\n|\\n\\r|\\r)[^A-Z#<>\\/0-9\"'\\r\\n ][^.?!\\r\\n]*)*[?!.]?['\"]?");
		Pattern pattern = Pattern.compile("[^.?!\\s;][^.?!\\r\\n;]*(?:[.?!]['\"]?(?!\\s*['\"]|\\s+[A-Z]|$)[^.?!\\r\\n;]*|(?:\\n|\\r\\n|\\n\\r|\\r)[^A-Z#<>\\/0-9\"'\\r\\n \\t&;][^.?!\\r\\n;]*)*[?!.;]?['\"]?");
		//String content = getfile("/Users/IBM_ADMIN/Documents/cei37/sharedFolder/msxfiles/01 MARCH 2011 WORD.xml");
		String content = getText("/Users/IBM_ADMIN/Documents/cei37/sharedFolder/msxfiles/dcct_20e3f451-e2d7-4cdc-92ef-5120867f67a2_MATOfferLibraryReport20.xls.xml");
        Matcher matcher = pattern.matcher(content);
        //System.out.println(content);
        System.out.println("Input String matches regex - "+matcher.matches());
        String result = "";
        while(matcher.find()){
        	result = matcher.group();
        	System.out.println("****************************"+result);
        }

	}

	public static String getText(String file) {
		XMLEventReader reader = null;
		StringBuffer current = new StringBuffer();
		try{
			reader = getEventReaderInstance(file);
			boolean read = false;
			while (reader.hasNext()) {
				XMLEvent event = (XMLEvent) reader.next();
				if (event.isStartElement()) {
					StartElement element = (StartElement) event;
					if (element.getName().getLocalPart().equalsIgnoreCase("page-content")) {
						read = true;
					}
				}
				
				if (read && event.isEndElement()) {
					read = false;
				}
				if (read && event.isCharacters()) {
					Characters characters = (Characters) event;
					current.append(characters.getData());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}		
		}
		return current.toString();
	}
	
	protected static XMLEventReader getEventReaderInstance(String fileName) {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader filteredEventReader = null;
		XMLEventReader eventReader = null;		
		try {
			eventReader = factory.createXMLEventReader(new FileInputStream(fileName),"UTF-16");
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			if(eventReader != null){
				filteredEventReader = factory.createFilteredReader( eventReader, new EventFilter() {
					public boolean accept(XMLEvent event) {
						return event.isStartElement() || event.isCharacters() || event.isEndElement();
					}
				});
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		return filteredEventReader;
	}
	
	public static String getfile(String file) throws IOException{
		String everything = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            //sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        everything = sb.toString();
	    } finally {
	        br.close();
	    }
	    return everything;
	}
}
