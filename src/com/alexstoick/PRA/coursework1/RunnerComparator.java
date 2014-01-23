package com.alexstoick.PRA.coursework1;

import java.util.Comparator;

/**
 * Created by alexstoick on 1/21/14.
 */
public class RunnerComparator implements Comparator<Runner> {

	/**
	 *
	 * @param a First runner object.
	 * @param b Second runner object;
	 * @return Will return the difference between the finish positions of the two, this being used to sort the array.
	 */
	public int compare (Runner a, Runner b) {
		return a.getFinishPosition() - b.getFinishPosition() ;
	}
}
