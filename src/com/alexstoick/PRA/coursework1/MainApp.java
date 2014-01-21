package com.alexstoick.PRA.coursework1;

import runningdata.DataTable;
import runningdata.LocationNameAndKey;
import runningdata.RunningAPI;

import java.util.LinkedList;

/**
 * Created by alexstoick on 1/21/14.
 */
public class MainApp {

	private static final String  email = "alexandru.stoica" ;
	private static final String license_key = "3ae4b3d52a"  ;

	public static void main ( String args[]) {

		System.out.println ( WorldRecordsTimes.getRecordForAgeGroupAndGender ( "JW15-19" , "M" ) ) ;

//		RunningAPI server = new RunningAPI () ;
//
//		boolean success = server.connectToServer ( email , license_key ) ;
//
//
//		if (success == false) {
//			System.out.println("Fatal error: could not open connection");
//			System.exit(1);
//		}
//
//		String searchFor = "Preston" ;
//		String searchIn = "get_address" ;
//
//		LinkedList results = server.search (searchIn,searchFor) ;
//
//		LocationNameAndKey firstResult = (LocationNameAndKey) results.get(0);
//		DataTable data = server.getDataFor(firstResult);
//		int rowCount = data.getRowCount();
//
//		for (int row = 0; row < rowCount; ++row) {
//			for (int col = 0; col < 6; ++col) {
//				System.out.print("  " + data.getCell(row,col));
//			}
//			System.out.println();
//		}
	}
}
