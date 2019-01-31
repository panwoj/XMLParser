package com.bharath.xmlparsers.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.bharath.xmlparsers.dto.DriversLicense;
import com.bharath.xmlparsers.dto.Weather;

public class MySAXParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		MySAXHandler driverLicenseHandler = new MySAXHandler();
		SAXWeatherHandler weatherHandler = new SAXWeatherHandler();
		
		parser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"), driverLicenseHandler);
		DriversLicense license = driverLicenseHandler.getDriversLicense();
		System.out.println(license.getFirstName());
		System.out.println(license.getLastName());
		System.out.println(license.getNumber() + "\n");
		
		parser.parse(ClassLoader.getSystemResourceAsStream("xml/weather.xml"), weatherHandler);
		Weather weather = weatherHandler.getWeather();
		System.out.println(weather.getCity());
		System.out.println(weather.getTemp());
	}
}
