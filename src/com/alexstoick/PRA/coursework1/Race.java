package com.alexstoick.PRA.coursework1;

import java.util.ArrayList;

/**
 * Created by alexstoick on 1/21/14.
 */
public class Race {
	private String name ;
	private Integer ID ;
	private ArrayList<Runner> runners ;

	public Race ( String name , Integer ID )
	{
		this.name = name ;
		this.ID = ID ;
	}

	public void addRunner ( Runner r )
	{
		runners.add ( r ) ;
	}

	public void orderRunners ( )
	{

	}
}
