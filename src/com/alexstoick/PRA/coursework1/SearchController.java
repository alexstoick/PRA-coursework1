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

	public SearchController ( JTextField searchTextField)
	{
		this.searchTextField = searchTextField ;
	}

	public void actionPerformed ( ActionEvent e )
	{
		setChanged ();
		notifyObservers ( searchTextField.getText() );
	}
}
