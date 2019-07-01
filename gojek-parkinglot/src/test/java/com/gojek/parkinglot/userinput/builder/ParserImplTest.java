package com.gojek.parkinglot.userinput.builder;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gojek.parkinglot.userinput.builder.impl.ParserImpl;

public class ParserImplTest {
	
	Parser parser;
	@BeforeMethod
	public void setup(){
		parser = new ParserImpl();
	}
	
	@Test
	public void createCommandTest() throws IOException{
		
		String line = "create_parking_lot 6";
		parser.createCommand(line);
		line = "park KA-01-HH-1234 White";
		parser.createCommand(line);
		
	}
	
}
