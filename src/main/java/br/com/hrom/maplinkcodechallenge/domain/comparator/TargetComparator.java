package br.com.hrom.maplinkcodechallenge.domain.comparator;

import java.util.Comparator;

import br.com.hrom.maplinkcodechallenge.domain.Target;

public class TargetComparator {

	public static final Comparator<Target> BY_PROBABILITY_DESC = new ByProbabilityDesc();
	
	public static class ByProbabilityDesc implements Comparator<Target>{

		@Override
		public int compare(Target t1, Target t2) {
			double difference = t2.getProbability() - t1.getProbability();
			
			if(difference < 0 )
				return -1;
			else if(difference > 0)
				return 1;
			return 0;
		}
		
	}
}
