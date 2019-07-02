package com.gojek.main.application;

import com.gojek.parkinglot.userinput.builder.InputMode;
import com.gojek.parkinglot.userinput.builder.impl.FileReaderMode;
import com.gojek.parkinglot.userinput.builder.impl.InteractiveShellMode;

/**
 * Main class of the Application
 * @author shahid
 *
 */
public class Main {

	public static void main(String[] args) {
		
		InputMode inputMode;
		if(args.length >= 1){
			inputMode = new FileReaderMode(args);
		}
		else{
			inputMode = new InteractiveShellMode();
		}

		inputMode.process();
	}

}
