package com.alexstoick.PRA.coursework1;

/**
 * Created by alexstoick on 1/21/14.
 */
public class WorldRecordsTimes {

	private static final int[] ageGroups = { 19 , 34, 39,44 , 49,54,59,64,69,74,79,84,89,94,1000 } ;

	private static final Integer[] menRaceTimes = { 757,767,775,823,866,896,931,975,1000,1097,
													1147,1261,1494,1885,3014 } ;
	private static final Integer[] womenRaceTimes = { 851,871,876,921,957,1013,1076,1129,1216,
														1297,1445,1618,1973,2489,3974 } ;

	/**
	 *
	 * @param ageGroup The age group of a runner, as given by the API.
	 * @param gender The gender of the runner.
	 * @return Returns the world record for the age group and gender of the given runner.
	 */
	public static int getRecordForAgeGroupAndGender ( String ageGroup, String gender )
	{
		int ageGroupTopBound = 0 ;
		if ( ageGroup.length () == 4 )
			ageGroupTopBound = Integer.parseInt ( ageGroup.substring (2) ) ;
		else
			ageGroupTopBound = Integer.parseInt (ageGroup.substring (5)) ;
		int size = ageGroups.length ;
		int index = 0 ;

		for ( int i = 0 ; i < size ; ++ i )
		{
			if ( ageGroupTopBound <= ageGroups[i] )
			{
				index = i ;
				break ;
			}
		}
		if ( gender.equals ("M") )
			return menRaceTimes[index] ;

		return womenRaceTimes[index] ;
	}

}
