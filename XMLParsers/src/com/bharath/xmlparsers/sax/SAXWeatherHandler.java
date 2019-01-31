package com.bharath.xmlparsers.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.bharath.xmlparsers.dto.Weather;

public class SAXWeatherHandler extends DefaultHandler {
	private Weather weather;
	private Object content;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if(qName.equals("Weather")) {
			setWeather(new Weather());
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) {
		switch(qName) {
			case "City":
				getWeather().setCity((String)content);
				break;
			case "Temperature":
				getWeather().setTemp((int)Math.round(Double.parseDouble((String)content)));
				break;
		}		
	}
	
	@Override
	public void characters(char ch[], int start, int length) {
		content = String.copyValueOf(ch, start, length);
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}


}
