package com.alexstoick.PRA.coursework1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexstoick on 1/26/14.
 */
public class ListController extends Observable implements Observer, ListSelectionListener {

	private JList list;
	private RaceDataSource raceDataSource;
	private JPanel centerRightPanel;


	public ListController (JList list, JPanel panel) {
		this.centerRightPanel = panel;
		this.list = list;
		list.addListSelectionListener (this);
	}

	public void valueChanged (ListSelectionEvent e) {
		setChanged ();
		int selectedIndex = list.getSelectedIndex ();
		if ( selectedIndex == -1 )
			return;
		centerRightPanel.setVisible (true);
		notifyObservers (new Object[]{ raceDataSource.runnersForRaceAtIndex (selectedIndex),
				raceDataSource.ageGroupsForRaceAtIndex (selectedIndex),
				selectedIndex });
	}


	public void update (Observable o, Object arg) {
		String searchTerm = (String) arg;

		System.out.println (searchTerm);

		raceDataSource = new RaceDataSource ();

		raceDataSource.queryWithString (searchTerm);
		DefaultListModel listModel = (DefaultListModel) list.getModel ();
		listModel.removeAllElements ();
		for ( int i = 0 ; i < raceDataSource.getRacesCount () ; ++i ) {
			listModel.addElement (raceDataSource.getNameForRaceAtIndex (i));
		}
	}
}
