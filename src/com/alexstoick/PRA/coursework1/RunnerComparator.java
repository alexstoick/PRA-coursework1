package com.alexstoick.PRA.coursework1;

import java.util.Comparator;

/**
 * Created by alexstoick on 1/21/14.
 */
public class RunnerComparator implements Comparator<Runner> {

	public int compare (Runner a, Runner b) {
		return a.getFinishPosition() - b.getFinishPosition() ;
	}
}
