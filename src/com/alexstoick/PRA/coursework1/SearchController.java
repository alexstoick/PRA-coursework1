package com.alexstoick.PRA.coursework1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by alexstoick on 1/26/14.
 */
public class SearchController extends Observable implements ActionListener {

	private JTextField searchTextField ;
	private JPanel centerRightPanel;

	public SearchController ( JTextField searchTextField , JPanel panel )
	{
		this.centerRightPanel = panel ;
		this.searchTextField = searchTextField ;
		centerRightPanel.setVisible ( false );
	}

	public void actionPerformed ( ActionEvent e )
	{
		setChanged ();
		centerRightPanel.setVisible ( false );
		notifyObservers ( searchTextField.getText() );
	}
}
