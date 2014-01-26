package com.alexstoick.PRA.coursework1;

import javax.swing.*;

/**
 * Created by alexstoick on 1/26/14.
 */
public class MainFrame {
	private JPanel rootPanel;
	private JPanel topPanel;
	private JTextField searchTextField;
	private JButton goButton;
	private JPanel centerPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JList raceList;
	private JScrollPane raceListScrollPane;
	private JComboBox raceTypeComboBox;
	private JTable raceResultsTable;
	private JScrollPane raceResultsScrollPane;

	public JPanel getRootPanel () {
		return rootPanel;
	}

	public JTextField getSearchTextField () {
		return searchTextField;
	}

	public JComboBox getRaceTypeComboBox () {
		return raceTypeComboBox;
	}

	public JTable getRaceResultsTable () {
		return raceResultsTable;
	}

	public JList getRaceList () {
		return raceList;
	}

	public JButton getGoButton () {
		return goButton;
	}
}
