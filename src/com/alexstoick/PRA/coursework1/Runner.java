package com.alexstoick.PRA.coursework1;

/**
 * Created by alexstoick on 1/21/14.
 */
public class Runner {

	private String raceTime ;
	private Integer raceTimeInSeconds ;
	private String gender ;
	private Integer numberOfRuns ;
	private Integer finishPosition ;
	private String category;
	private String bib ;

	public Runner ( String raceTime , String gender , String numberOfRuns ,
	                    String category , String finishPosition , String bib )
	{
		this.raceTime = raceTime ;
		setupRaceTimeInSeconds() ;
		this.gender = gender ;
		this.finishPosition = Integer.parseInt ( finishPosition ) ;
		this.numberOfRuns = Integer.parseInt ( numberOfRuns ) ;
		this.category = category ;
		this.bib = bib ;
	}

	private void setupRaceTimeInSeconds ()
	{
		String[] splitRaceTime = raceTime.split(":") ;
		String hours   = splitRaceTime[0] ;
		String minutes = splitRaceTime[1] ;
		String seconds = splitRaceTime[2] ;
		this.raceTimeInSeconds = Integer.parseInt (hours) * 3600 + Integer.parseInt ( minutes ) * 60
									+ Integer.parseInt ( seconds ) ;
	}

	public int getFinishPosition ()
	{
		return finishPosition ;
	}
}
