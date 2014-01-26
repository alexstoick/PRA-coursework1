package com.alexstoick.PRA.coursework1;

import com.alexstoick.PRA.coursework1.Runner.Runner;
import com.alexstoick.PRA.coursework1.Runner.RunnerComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by alexstoick on 1/21/14.
 */
public class Race {
	private String name ;
	private Integer ID ;
	private ArrayList<Runner> runners = new ArrayList<Runner> ();
	private HashSet<String> ageGroups = new HashSet<String> () ;

	/**
	 *
	 * @param name The name of the race.
	 * @param ID The unique ID of the race.
	 */
	public Race ( String name , Integer ID )
	{
		this.name = name ;
		this.ID = ID ;
	}

	/**
	 * Getter for the name property.
	 * @return A string that represents the name of the race.
	 */
	public String getName () {
		return name;
	}

	/**
	 *
	 * @param r Adds the runner r to the ArrayList of runners for the current race.
	 */
	public void addRunner ( Runner r )
	{
		runners.add ( r ) ;
		addAgeGroup ( r.getCategory () );
	}

	public HashSet<String> getAgeGroups () {
		return ageGroups;
	}

	public Runner getRunnerAtIndex ( int i )
	{
		return runners.get(i) ;
	}

	public ArrayList<Runner> getRunners ( )
	{
		return runners ;
	}

	public ArrayList<Runner> getRunnersWithAgeCategory ( String ageCategory )
	{
		ArrayList<Runner> runnersWithProperty = new ArrayList<Runner> () ;
		for ( Runner r : runners )
		{
			if ( r.getCategory().equals ( ageCategory ) )
				runnersWithProperty.add(r) ;
		}

		return runnersWithProperty ;
	}

	/**
	 * Using the RunnerComparator class we order the runners array by their finish position.
	 */
	public void orderRunners ( )
	{
		Collections.sort (runners, new RunnerComparator ()) ;
	}

	/**
	 * Prints all the runners.
	 */
	public void printRunners ( )
	{
		int size = runners.size () ;
		for ( int i = 0 ; i < size ; ++ i )
			System.out.println ( runners.get(i).getFinishPosition () ) ;
	}

	/**
	 *
	 * @param ageGroup Adds an age group to the hash set used to show the categories.
	 */
	public void addAgeGroup ( String ageGroup )
	{
		ageGroups.add ( ageGroup ) ;
	}

	/**
	 *
	 * @param number Prints the first number runners.
	 * @throws ArrayIndexOutOfBoundsException In case the number of runners we want to print exceeds the current size of
	 *                                        the array an exception will be thrown.
	 */
	public void printRunners ( int number ) throws ArrayIndexOutOfBoundsException
	{
		int size = runners.size () ;
		if ( number > size ) {
			throw new ArrayIndexOutOfBoundsException();
		}

		for ( int i = 0 ; i < size ; ++ i )
			System.out.println ( runners.get(i).getFinishPosition () ) ;
	}
}

