package com.alexstoick.PRA.coursework1;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by alexstoick on 1/26/14.
 */
public class ListController implements Observer {

	private JList list ;

	public ListController ( JList list )
	{
		this.list = list ;
	}

	public void update (Observable o, Object arg) {
		String searchTerm = (String)arg ;

		System.out.println(searchTerm);


	}
}
