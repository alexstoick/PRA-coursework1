package com.alexstoick.PRA.coursework1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexstoick on 1/26/14.
 */
public class ListController extends Observable implements Observer,ListSelectionListener {

	private JList list ;
	private RaceDataSource raceDataSource ;

	public ListController ( JList list )
	{
		this.list = list ;
		list.addListSelectionListener ( this );
	}

	public void valueChanged (ListSelectionEvent e) {

		System.out.println ( "Selected stuff" ) ;
		setChanged();
		notifyObservers( raceDataSource.raceAtIndex ( list.getSelectedIndex () ) );

	}


	public void update (Observable o, Object arg) {
		String searchTerm = (String)arg ;

		System.out.println(searchTerm);

		raceDataSource = new RaceDataSource () ;

		raceDataSource.queryWithString ( searchTerm ) ;
		DefaultListModel listModel = (DefaultListModel)list.getModel () ;
		listModel.removeAllElements ();
		if ( raceDataSource.races != null )
			for ( Race currentRace : raceDataSource.races )
			{
				System.out.println ( currentRace.getName());
				listModel.addElement ( currentRace.getName () );
			}
	}
}
