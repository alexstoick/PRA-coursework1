package com.alexstoick.PRA.coursework1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

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

	public JPanel getRightPanel () {
		return rightPanel;
	}

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

	private void createUIComponents () {
		raceResultsTable = new JTable (new DefaultTableModel ()) {

			@Override
			public Component prepareRenderer (TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer (renderer, row, column);

				if ( raceResultsTable.getColumnCount () > 0 ) {
					String gender = (String) getModel ().getValueAt (row, 3);
					if ( gender.equals ("M") ) {
						component.setBackground (new Color (255, 163, 0));
					} else {
						component.setBackground (new Color (0, 0, 250));
						component.setForeground (new Color (255, 255, 255));
						//component.setFont ( new Font ( ));
					}
				}
				return component;
			}
		};
	}
}
