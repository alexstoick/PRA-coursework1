package com.alexstoick.PRA.coursework1;

import com.alexstoick.PRA.coursework1.Runner.Runner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexstoick on 1/26/14.
 */
public class TableController implements Observer {

	private JTable table;
	private DefaultTableModel tableModel;

	public TableController (JTable table) {
		this.table = table;
		tableModel = (DefaultTableModel) this.table.getModel ();

		tableModel.addColumn ("Position");
		tableModel.addColumn ("Bib No.");
		tableModel.addColumn ("Time");
		tableModel.addColumn ("Gender");
		tableModel.addColumn ("Category");
		tableModel.addColumn ("Runs");

	}

	private void clearTable () {
		for ( int i = tableModel.getRowCount () - 1 ; i > -1 ; --i )
			tableModel.removeRow (i);
	}

	public void refreshTable (ArrayList<Runner> runners) {
		clearTable ();

		int size = Math.min (runners.size (), 10);
		for ( int i = 0 ; i < size ; ++i ) {
			Runner currentRunner = runners.get (i);
			tableModel.addRow (new Object[]{ currentRunner.getFinishPosition (), currentRunner.getBib (),
					currentRunner.getRaceTime (), currentRunner.getGender (), currentRunner.getCategory (),
					currentRunner.getNumberOfRuns () });
		}
	}

	public void update (Observable o, Object arg) {

		Object[] argument_array = (Object[]) arg;
		refreshTable ((ArrayList<Runner>) argument_array[ 0 ]);

	}
}
