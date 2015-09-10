package com.elitecore.andsf.data;

public class TimeOfDay {
	private String dateStart;
	private String dateStop;
	private String timeStart;
	private String timeStop;
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateStop() {
		return dateStop;
	}
	public void setDateStop(String dateStop) {
		this.dateStop = dateStop;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeStop() {
		return timeStop;
	}
	public void setTimeStop(String timeStop) {
		this.timeStop = timeStop;
	}
	@Override
	public String toString() {
		return "TimeOfDay [dateStart=" + dateStart + ", dateStop=" + dateStop
				+ ", timeStart=" + timeStart + ", timeStop=" + timeStop + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result
				+ ((dateStop == null) ? 0 : dateStop.hashCode());
		result = prime * result
				+ ((timeStart == null) ? 0 : timeStart.hashCode());
		result = prime * result
				+ ((timeStop == null) ? 0 : timeStop.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeOfDay other = (TimeOfDay) obj;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (dateStop == null) {
			if (other.dateStop != null)
				return false;
		} else if (!dateStop.equals(other.dateStop))
			return false;
		if (timeStart == null) {
			if (other.timeStart != null)
				return false;
		} else if (!timeStart.equals(other.timeStart))
			return false;
		if (timeStop == null) {
			if (other.timeStop != null)
				return false;
		} else if (!timeStop.equals(other.timeStop))
			return false;
		return true;
	}	
	
	
	
}
