package edu.alma.muzzin1jv.CSC230Project;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//This is my main class that will run the gui as well as declare what my URL is
public class GUI {
	//declaring the static url will help with the control.java
	public static String url;

	public static void main(String[] args) throws IOException {
		
		//making the frame of the gui here
		JFrame frame = new JFrame("Current data from covidtracking.org");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//url for the future usage of clientbuilder
		url = ("https://api.covidtracking.com");

		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.getContentPane().add(new Control());
			}
		});
		frame.setPreferredSize(new Dimension(800,200));
		frame.pack();
		frame.setVisible(true);
		
		

	}

}
