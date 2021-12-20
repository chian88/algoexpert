package CalendarMatching;

import java.util.*;

class Program {
	public static List<StringMeeting> calendarMatching(
			List<StringMeeting> calendar1,
			StringMeeting dailyBounds1,
			List<StringMeeting> calendar2,
			StringMeeting dailyBounds2,
			int meetingDuration) {
		// Write your code here.

		calendar1.add(0 , new StringMeeting("00:00", dailyBounds1.start));
		calendar1.add(new StringMeeting(dailyBounds1.end, "24:00"));

		calendar2.add(0, new StringMeeting("00:00", dailyBounds2.start));
		calendar2.add(new StringMeeting(dailyBounds2.end, "24:00"));


		List<StringMeeting> mergedCalendar = mergeCalendar(calendar1, calendar2);

		List<StringMeeting> flattenCalendar = reduceCalendar(mergedCalendar);

		List<StringMeeting> freeTime = getFreeTime(flattenCalendar, meetingDuration);

		return freeTime;
	}

	private static List<StringMeeting> getFreeTime(List<StringMeeting> flattenCalendar, int meetingDuration) {
		List<StringMeeting> freeTime = new ArrayList<>();

		for (int i = 0; i < flattenCalendar.size() - 1; i ++) {
			StringMeeting current = flattenCalendar.get(i);
			StringMeeting next = flattenCalendar.get(i+1);

			int startFree = convertTimeToMinutes(current.end);
			int endFree = convertTimeToMinutes(next.start);

			if ( (endFree - startFree) >= meetingDuration) {
				freeTime.add(new StringMeeting(current.end, next.start));
			}
		}

		return freeTime;

	}

	private static List<StringMeeting> reduceCalendar(List<StringMeeting> mergedCalendar) {
		List<StringMeeting> flattenCalendar = new ArrayList<>();

		String endTimeSoFar = mergedCalendar.get(0).end;
		int endTimeSoFarInt = convertTimeToMinutes(endTimeSoFar);

		String startTimeSoFar = mergedCalendar.get(0).start;

		for(int i = 1; i < mergedCalendar.size(); i++) {
			String currStartTime = mergedCalendar.get(i).start;
			int currStartTimeInt = convertTimeToMinutes(currStartTime);

			String currEndTime = mergedCalendar.get(i).end;
			int currEndTimeInt = convertTimeToMinutes(currEndTime);


			if (endTimeSoFarInt >= currStartTimeInt) {
				if (currEndTimeInt > endTimeSoFarInt) {
					endTimeSoFarInt = currEndTimeInt;
					endTimeSoFar = currEndTime;
				}
			} else {
				flattenCalendar.add(new StringMeeting(startTimeSoFar, endTimeSoFar));
				startTimeSoFar = currStartTime;
				endTimeSoFar = currEndTime;
				endTimeSoFarInt = convertTimeToMinutes(endTimeSoFar);
			}


		}
		flattenCalendar.add(new StringMeeting(startTimeSoFar, endTimeSoFar));


		return flattenCalendar;

	}

	private static List<StringMeeting> mergeCalendar(List<StringMeeting> calendar1, List<StringMeeting> calendar2) {
		int ptr1 = 0;
		int ptr2 = 0;

		List<StringMeeting> res = new ArrayList<>();

		while (ptr1 < calendar1.size() && ptr2 < calendar2.size()) {
			int time1 = convertTimeToMinutes(calendar1.get(ptr1).start);
			int time2 = convertTimeToMinutes(calendar2.get(ptr2).start);

			if (time1 < time2) {
				res.add(calendar1.get(ptr1));
				ptr1++;
			} else {
				res.add(calendar2.get(ptr2));
				ptr2++;
			}
		}

		while (ptr1 < calendar1.size()) {
			res.add(calendar1.get(ptr1));
			ptr1++;
		}

		while (ptr2 < calendar2.size()) {
			res.add(calendar2.get(ptr2));
			ptr2++;
		}
		return res;
	}

	private static int convertTimeToMinutes(String time) {
		String[] times = time.split(":");
		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

	}

	static class StringMeeting {
		public String start;
		public String end;

		public StringMeeting(String start, String end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		List<StringMeeting> calendar1 = new ArrayList<>();
		calendar1.add(new StringMeeting("9:00", "10:30"));
		calendar1.add(new StringMeeting("12:00", "13:00"));
		calendar1.add(new StringMeeting("16:00", "18:00"));

		StringMeeting dailyBound1 = new StringMeeting("9:00", "20:00");

		List<StringMeeting> calendar2 = new ArrayList<>();
		calendar2.add(new StringMeeting("10:00", "11:30"));
		calendar2.add(new StringMeeting("12:30", "14:30"));
		calendar2.add(new StringMeeting("14:30", "15:00"));
		calendar2.add(new StringMeeting("16:00", "17:00"));

		StringMeeting dailyBound2 = new StringMeeting("10:00", "18:30");

		int meetingDuration = 30;

		calendarMatching(calendar1, dailyBound1, calendar2, dailyBound2, meetingDuration);

	}
}