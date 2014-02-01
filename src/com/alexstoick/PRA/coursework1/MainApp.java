package com.alexstoick.PRA.coursework1;

import runningdata.RunningAPI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexstoick on 1/21/14.
 */
public class MainApp {

	public static void main (String args[]) {

		MainFrame mainFrame = new MainFrame ();

		RunningAPI server = Server.getInstance ();

		JFrame frame = new JFrame ("MainFrame");
		frame.setContentPane (mainFrame.getRootPanel ());
		frame.setMinimumSize (new Dimension (800, 300));
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.pack ();
		frame.setVisible (true);

		SearchController searchController = new SearchController (mainFrame.getSearchTextField (), mainFrame.getRightPanel ());
		ListController listController = new ListController (mainFrame.getRaceList (), mainFrame.getRightPanel ());
		TableController tableController = new TableController (mainFrame.getRaceResultsTable ());
		ComboBoxController comboBoxController = new ComboBoxController (mainFrame.getRaceTypeComboBox ());

		listController.addObserver (tableController);
		searchController.addObserver (listController);
		listController.addObserver (comboBoxController);
		comboBoxController.addObserver (tableController);

		JButton goButton = mainFrame.getGoButton ();
		goButton.addActionListener (searchController);

		JTextField searchTextField = mainFrame.getSearchTextField ();
		searchTextField.addActionListener (searchController);

	}
}
