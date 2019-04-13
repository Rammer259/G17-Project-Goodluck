import java.time.LocalTime;

/**
 * This class is used for the shift feature of this program.
 * This feature uses the shift parameter from the employee class
 * to check with the system time and see if the employee is
 * at work at that moment.
 *
 * @author mimel
 */
public class Schedule{

	String morningShift = "m";// MORING
	String eveningShift = "e";// EVENING
	String overnightShift = "o";// OVERNIGHT

	LocalTime startMorning = LocalTime.parse("08:00");
	LocalTime startEvening = LocalTime.parse("16:00");
	LocalTime startOvernight = LocalTime.parse("00:00");
	

		/**
		 * A function that is used to connect the times between
		 * shifts. This way, employees that start in the morning
		 * at 8am automatically end at the time of the evening
		 * shift at 4pm, and so on.
		 *
		 * @param candidate
		 * @param start
		 * @param end
		 * @return
		 */
		public boolean isBetween(LocalTime candidate, LocalTime start, LocalTime end) {
		  return !candidate.isBefore(start) && !candidate.isAfter(end);
		}

		/**
		 * Function that takes in the employee's shift time
		 * and compares it to the local time on the system.
		 * returns true if the system time is within the range
		 * of the employee's shift.
		 *
		 * @param e
		 * @return
		 */
		public boolean isWorking(Employee e){

			LocalTime local = LocalTime.now();

			if (e.getShift().equalsIgnoreCase("m")){
				if (isBetween(local,startMorning,startEvening ) ){
					return true;
				}
			}
			if (e.getShift().equalsIgnoreCase("e")){
				if(isBetween(local,startEvening,startOvernight )){
					return true;
				}
			}
			if (e.getShift().equalsIgnoreCase("o")){
				if(isBetween(local,startOvernight,startMorning )){
					return true;
				}
			}

			return false;
		}
}
//References:
//https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
//https://stackoverflow.com/questions/2309558/time-comparison
