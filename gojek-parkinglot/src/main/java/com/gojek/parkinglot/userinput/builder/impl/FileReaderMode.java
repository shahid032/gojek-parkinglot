package com.gojek.parkinglot.userinput.builder.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.gojek.parkinglot.userinput.builder.InputMode;
import com.gojek.parkinglot.userinput.builder.Parser;

/**
 * Implementation of Input Mode as a File Reader Mode
 * File reader and use Parser to create command Line by line
 * @author shahid
 *
 */
public class FileReaderMode implements InputMode{
	
	String filePath;
	public FileReaderMode(String args[]) {
		filePath = args[0];
	}
	@Override
	public void process() {
		
		File inputFile = new File(filePath);
		BufferedReader br;
		Parser parser = new ParserImpl();
		try{
			String line;
			br =  new BufferedReader(new FileReader(inputFile));
			while((line = br.readLine()) != null){
				parser.createCommand(line);
			}
		}
		 catch (FileNotFoundException e) {
				System.out.println("Please Enter Valid File Path : \n"+e);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
