package com.alexstoick.PRA.coursework1;

/**
 * Created by alexstoick on 1/21/14.
 */
public class Runner {

	private String raceTime ;
	private Integer raceTimeInSeconds ;
	private String gender ;
	private Integer numberOfRuns ;
	private String category;
	private String bib ;

	public Runner ( String raceTime , String gender , String numberOfRuns , String category , String bib )
	{
		this.raceTime = raceTime ;
		setupRaceTimeInSeconds() ;
		this.gender = gender ;
		this.numberOfRuns = Integer.parseInt ( numberOfRuns ) ;
		this.category = category ;
		this.bib = bib ;
	}

	private void setupRaceTimeInSeconds ()
	{
		String[] splitRaceTime = raceTime.split(":") ;
		String minutes = splitRaceTime[0] ;
		String seconds = splitRaceTime[1] ;
		this.raceTimeInSeconds = Integer.parseInt ( minutes ) * 60 + Integer.parseInt ( seconds ) ;
	}
}
