package com.alexstoick.PRA.coursework1;

import runningdata.DataTable;
import runningdata.LocationNameAndKey;
import runningdata.RunningAPI;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by alexstoick on 1/21/14.
 */

public class RaceDataSource {

	private RunningAPI server ;
	LinkedList<LocationNameAndKey> results ;
	ArrayList<Race> races = new ArrayList<Race> () ;

	/**
	 * Creates a new reference to the singleton class Server.
	 */
	public RaceDataSource ( )
	{
		this.server = Server.getInstance () ;
	}

	/**
	 * Using the given parameter the function queries the API and stores all the races, as well as processes the
	 * runners for each race, adding them afterwards to the races ArrayList.
	 * @param search String that is entered by the user.
	 */
	public void queryWithString ( String search )
	{
		String searchFor = "Preston" ;

		this.results = Server.searchForRaceWithIdentifier (searchFor) ;

		int size = results.size () ;

		for ( int i = 0 ; i < size ; ++ i )
		{
			LocationNameAndKey currentResult = results.get(i);
			DataTable data = server.getDataFor(currentResult);
			int rowCount = data.getRowCount();

			Race currentRace = new Race ( currentResult.the_address () , currentResult.the_number () ) ;

			for (int row = 0; row < rowCount; ++row) {
				String raceTime = data.getCell ( row , 0 ) ;
				String gender = data.getCell ( row , 1 ) ;
				String runs = data.getCell ( row , 2 ) ;
				String ageGroup = data.getCell ( row , 3 ) ;
				String finishPosition = data.getCell ( row , 4 ) ;
				String bib = data.getCell ( row , 5 ) ;

				currentRace.addRunner ( new Runner ( raceTime , gender , runs , ageGroup , finishPosition , bib ) ) ;

			}

			currentRace.orderRunners ();
			races.add ( currentRace ) ;
		}

	}

	/**
	 *
	 * @param i Index of race.
	 * @return Race at given index.
	 */
	public Race raceAtIndex ( int i )
	{
		return races.get(i) ;
	}

}
