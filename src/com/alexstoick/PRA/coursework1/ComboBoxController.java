package com.alexstoick.PRA.coursework1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexstoick on 1/26/14.
 */
public class ComboBoxController extends Observable implements Observer, ActionListener {

	private JComboBox<String> comboBox;
	private DefaultComboBoxModel comboBoxModel;
	private int raceIndex;

	public ComboBoxController (JComboBox comboBox) {
		this.comboBox = comboBox;
		comboBoxModel = (DefaultComboBoxModel) comboBox.getModel ();
		comboBox.addActionListener (this);
	}

	public void update (Observable o, Object arg) {

		comboBoxModel.removeAllElements ();

		Object[] arguments_array = (Object[]) arg;
		HashSet<String> ageGroups = (HashSet<String>) arguments_array[ 1 ];

		raceIndex = (Integer) arguments_array[ 2 ];

		comboBoxModel.addElement ("All");
		for ( String ageGroup : ageGroups )
			comboBoxModel.addElement (ageGroup);

	}

	public void actionPerformed (ActionEvent e) {
		if ( comboBox.getSelectedItem () == null )
			return;

		Object[] result;

		if ( comboBox.getSelectedItem ().equals ("All") )
			result = new Object[]{
					RaceDataSource.runnersForRaceAtIndex (raceIndex)
			};
		else
			result = new Object[]{
					RaceDataSource.runnersForRaceAtIndexWithAgeGroup (raceIndex, (String) comboBox.getSelectedItem ())
			};

		setChanged ();

		notifyObservers (result);
	}
}
