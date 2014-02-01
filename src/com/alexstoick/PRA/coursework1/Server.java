package com.alexstoick.PRA.coursework1;

import runningdata.LocationNameAndKey;
import runningdata.RunningAPI;

import java.util.LinkedList;

/**
 * Created by alexstoick on 1/26/14.
 */
public class Server extends RunningAPI {
	private static RunningAPI ourInstance = new Server ();

	public static RunningAPI getInstance () {
		return ourInstance;
	}

	public static LinkedList<LocationNameAndKey> searchForRaceWithIdentifier (String searchTerm) {
		ourInstance.connectToServer (email, license_key);
		return Server.getInstance ().search ("get_address", searchTerm);
	}

	private static final String email = "alexandru.stoica";
	private static final String license_key = "3ae4b3d52a";

	private Server () {
		RunningAPI connection = new RunningAPI ();

		boolean success = connection.connectToServer (email, license_key);

		if ( success == false ) {
			System.out.println ("Fatal error: could not open connection");
			System.exit (1);
		} else {
			System.out.println ("Setup the connection");
			ourInstance = connection;
		}
	}
}
