package com.bharath.xmlparsers.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.bharath.xmlparsers.dto.Weather;

public class DOMParserWeather {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document doc = docBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/Weather.xml"));
		Weather weather = new Weather();
		
		double temp = Double.parseDouble(doc.getElementsByTagName("Temperature").item(0).getTextContent());
		NodeList nodeList = doc.getDocumentElement().getElementsByTagName("Address").item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeName() == "City") {
				weather.setCity(nodeList.item(i).getTextContent());
			}
		}
		weather.setTemp((int)Math.round(temp));
		System.out.println(weather.getCity());
		System.out.println(weather.getTemp());
	}
}
