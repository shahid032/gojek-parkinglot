package com.gojek.parkinglot.userinput.builder;

import java.io.IOException;

/**
 * This interface is used to execute the user commands
 * @author shahid
 *
 */
public interface Command {
	
	/**
	 * 
	 * @param commandId - will define which type of commands to execute
	 * @param args - input argument for different commands
	 */
	public void call(String commandId,String[] args) throws IOException;

}
