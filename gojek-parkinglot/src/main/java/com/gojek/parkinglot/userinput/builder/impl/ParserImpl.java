package com.gojek.parkinglot.userinput.builder.impl;

import java.io.IOException;

import com.gojek.parkinglot.userinput.builder.Command;
import com.gojek.parkinglot.userinput.builder.Parser;

public class ParserImpl implements Parser{

	@Override
	public void createCommand(String line) throws IOException {
		Command cmd = new CommandImpl();
		String[] input = line.split(" ");
		String[] args = new String[input.length-1];
		for(int i=1; i<input.length;i++){
			args[i-1] = input[i];
		}
		cmd.call(input[0], args);
	}

}
