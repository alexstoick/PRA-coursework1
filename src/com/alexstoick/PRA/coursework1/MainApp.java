package com.alexstoick.PRA.coursework1;

/**
 * Created by alexstoick on 1/21/14.
 */
public class MainApp {

	private static final String  email = "alexandru.stoica" ;
	private static final String license_key = "3ae4b3d52a"  ;

	public static void main ( String args[]) {

		//System.out.println ( WorldRecordsTimes.getRecordForAgeGroupAndGender ( "JW15-19" , "M" ) ) ;

		Race test = new Race ( "bla" , 123 ) ;

		test.addRunner (new Runner ("00:15:20", "M", "10",
				"JW10-14", "5", "12321")) ;

		test.addRunner ( new Runner ( "00:14:20", "M", "10" ,
				"JW10-14", "4", "12321" ) ) ;

		test.orderRunners ();

		test.printRunners ();

//      RunningAPI server = new RunningAPI () ;
//
//		boolean success = server.connectToServer ( email , license_key ) ;
//
//
//		if (success == false) {
//			System.out.println("Fatal error: could not open connection");
//			System.exit(1);
//		}
	}
}
