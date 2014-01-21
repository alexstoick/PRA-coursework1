package com.alexstoick.PRA.coursework1;

import runningdata.DataTable;
import runningdata.LocationNameAndKey;
import runningdata.RunningAPI;

import java.util.LinkedList;

/**
 * Created by alexstoick on 1/21/14.
 */
public class RaceDataSource {

	private RunningAPI server ;
	LinkedList results ;

	public RaceDataSource ( RunningAPI server )
	{
		this.server = server ;
	}

	public void queryWithString ( String search )
	{
		String searchFor = "Preston" ;
		String searchIn = "get_address" ;

		this.results = server.search (searchIn,searchFor) ;
	}

	public Race raceAtIndex ( int i )
	{

		LocationNameAndKey currentResult = (LocationNameAndKey) results.get(i);
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

		return currentRace ;
	}

}
