package com.gojek.parkinglot.userinput.builder;

import java.io.IOException;

/**
 * Parse the input line and pass make call to command
 * @author shahid
 *
 */
public interface Parser {
	
	public void createCommand(String line) throws IOException;

}
