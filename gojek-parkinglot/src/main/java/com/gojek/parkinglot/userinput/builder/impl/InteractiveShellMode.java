package com.gojek.parkinglot.userinput.builder.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.parkinglot.userinput.builder.InputMode;
import com.gojek.parkinglot.userinput.builder.Parser;

public class InteractiveShellMode implements InputMode{

	@Override
	public void process() {
		
		Parser parser = new ParserImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try{
				String line = br.readLine();
				parser.createCommand(line);
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
	}

}
