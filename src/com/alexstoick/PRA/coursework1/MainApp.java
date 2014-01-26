package com.alexstoick.PRA.coursework1;

import runningdata.RunningAPI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexstoick on 1/21/14.
 */
public class MainApp {

	public static void main ( String args[]) {

		//System.out.println ( WorldRecordsTimes.getRecordForAgeGroupAndGender ( "JW15-19" , "M" ) ) ;

		Race test = new Race ( "bla" , 123 ) ;

		test.addRunner (new Runner ("00:15:20", "M", "10",
				"JW10-14", "5", "12321")) ;

		test.addRunner ( new Runner ( "00:14:20", "M", "10" ,
				"JW10-14", "4", "12321" ) ) ;

		test.orderRunners ();

		test.printRunners ();

		MainFrame mainFrame = new MainFrame() ;

		RunningAPI server = Server.getInstance () ;

		JFrame frame = new JFrame ("MainFrame");
		frame.setContentPane (mainFrame.getRootPanel ());
		frame.setMinimumSize(new Dimension (500, 300));
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.pack ();
		frame.setVisible (true);

		SearchController searchController = new SearchController (mainFrame.getSearchTextField ()) ;
		ListController listController = new ListController( mainFrame.getRaceList () ) ;

		searchController.addObserver ( listController );

		JButton goButton = mainFrame.getGoButton () ;
		goButton.addActionListener ( searchController);

		JTextField searchTextField = mainFrame.getSearchTextField () ;
		searchTextField.addActionListener ( searchController );

	}
}
