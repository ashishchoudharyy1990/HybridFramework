package fileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFileReader 
{
	private Document doc = null;
	
	public XMLFileReader()
	{
		DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dBFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			doc = db.parse(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\book.xml")));
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> getBookTitles()
	{
		List<String> bookTitles = new ArrayList<String>();
		NodeList tagName = doc.getElementsByTagName("title");
		
		for(int i =0; i < tagName.getLength();i++)
		{
			Node item = tagName.item(i);
			String textContent = item.getTextContent();
			bookTitles.add(textContent);
		}
		
		return bookTitles;
	}

}
