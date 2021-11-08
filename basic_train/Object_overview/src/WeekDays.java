public enum WeekDays {
	MONDAY("MON", false), TUESDAY("TUE", false),
	WEDNESDAY("WED", false), THURSDAY("THU", false),
	FRIDAY("FRI", false), SATURDAY("SAT", true),
	SUNDAY("SUN", true);

	private final String	weekDayName;
	private final boolean	isVacation;

	WeekDays(String weekDayName, boolean isVacation) {
		this.weekDayName = weekDayName;
		this.isVacation = isVacation;
	}

	public String	getWeekDayName() { return (weekDayName); }
	public boolean	getIsVacation() { return (isVacation);  }
}
