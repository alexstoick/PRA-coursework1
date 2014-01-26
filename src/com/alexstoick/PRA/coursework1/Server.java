package com.alexstoick.PRA.coursework1;

import runningdata.RunningAPI;

/**
 * Created by alexstoick on 1/26/14.
 */
public class Server extends RunningAPI {
	private static RunningAPI ourInstance = new Server ();

	public static RunningAPI getInstance () {
		return ourInstance;
	}

	private static final String  email = "alexandru.stoica" ;
	private static final String license_key = "3ae4b3d52a"  ;

	private Server () {
		ourInstance = new RunningAPI () ;

		boolean success = ourInstance.connectToServer ( email , license_key ) ;

		if (success == false) {
			System.out.println("Fatal error: could not open connection");
			System.exit(1);
		}
	}
}
