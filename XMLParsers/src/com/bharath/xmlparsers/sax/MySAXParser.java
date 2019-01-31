package com.bharath.xmlparsers.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.bharath.xmlparsers.dto.DriversLicense;

public class MySAXParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"), handler);
		DriversLicense license = handler.getDriversLicense();
		System.out.println(license.getFirstName());
		System.out.println(license.getLastName());
		System.out.println(license.getNumber());
	}
}
