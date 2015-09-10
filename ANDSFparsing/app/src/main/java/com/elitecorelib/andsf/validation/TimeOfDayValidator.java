package com.elitecorelib.andsf.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;

import android.util.Log;

import com.elitecorelib.andsf.api.DeviceDetail;
import com.elitecorelib.andsf.exception.InvalidDataException;
import com.elitecorelib.andsf.pojo.Policy;
import com.elitecorelib.andsf.pojo.TimeOfDay;
import com.elitecorelib.andsf.utility.CustomConstant;

public class TimeOfDayValidator implements IValidationHandler {

	private IValidationHandler nextValidator;
	
	public void setNextValidator(IValidationHandler nextValidationHandler) {
		this.nextValidator = nextValidationHandler;
	}

	public int validate(Policy policy){
		
		int validationStatus = CustomConstant.NOT_MATCHED;
		
		DeviceDetail devicelocation = DeviceDetail.getInstance();
				
		Log.d(CustomConstant.ApplicationTag,"Policy Time of Day validation started : "+policy.timeOfDay);
						
		if(policy.timeOfDay==null || policy.timeOfDay.isEmpty()){
			Log.d(CustomConstant.ApplicationTag,"Time of Day is not Found into Policy.");
			validationStatus = CustomConstant.NOT_FOUND_IN_POLICY;
			return validationStatus;
		}
		
		for(TimeOfDay timeOfDay : policy.timeOfDay){
			
			boolean isTimeStart = true;
			boolean isDateStart = true;;
			boolean isTimeStop = true;;
			boolean isDateStop = true;;
			
			if(timeOfDay.timeStart == null || "".equals(timeOfDay.timeStart)){
				isTimeStart = false;
			}
			
			if(timeOfDay.timeStop == null || "".equals(timeOfDay.timeStop)){
				isTimeStop = false;
			}
			
			if(timeOfDay.dateStart == null || "".equals(timeOfDay.dateStart)){
				isDateStart = false;
			}
			
			if(timeOfDay.dateStop== null || "".equals(timeOfDay.dateStop)){
				isDateStop = false;
			}
			
			try{
				timeOfDay.validate(isTimeStart,isTimeStop,isDateStart,isDateStop);
			}catch(InvalidDataException ide){
				Log.e(CustomConstant.ApplicationTag,"Time of day is not proper into Policy "+timeOfDay+ide,ide);
				continue;
			}
			
			SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			
			Date startDate = null;
			Date stopDate = null;
			Calendar currentCal = new GregorianCalendar();
			Calendar tempCal = new GregorianCalendar();
			
			try {
				
				
				if(isDateStart && isTimeStart){									
					startDate = dateTimeFormat.parse(timeOfDay.dateStart+" "+timeOfDay.timeStart);
				}else if(isDateStart && !isTimeStart){
					startDate = dateFormat.parse(timeOfDay.dateStart);
				}else if(!isDateStart && isTimeStart){
					startDate = timeFormat.parse(timeOfDay.timeStart);					
					tempCal.setTime(startDate);
					tempCal.set(Calendar.YEAR,currentCal.get(Calendar.YEAR));
					tempCal.set(Calendar.MONTH,currentCal.get(Calendar.MONTH));
					tempCal.set(Calendar.DAY_OF_MONTH,currentCal.get(Calendar.DAY_OF_MONTH));
					startDate = tempCal.getTime();
				}else{
					startDate = null;
				}			
				
				if(isDateStop && isTimeStop){									
					stopDate = dateTimeFormat.parse(timeOfDay.dateStop+" "+timeOfDay.timeStop);
				}else if(isDateStop && !isTimeStop){
					stopDate = dateFormat.parse(timeOfDay.dateStop);
					tempCal.clear();
					tempCal.setTime(stopDate);
					tempCal.set(Calendar.HOUR,23);
					tempCal.set(Calendar.MINUTE,59);
					tempCal.set(Calendar.SECOND,59);
					stopDate = tempCal.getTime();					
				}else if(!isDateStop && isTimeStop){
					stopDate = timeFormat.parse(timeOfDay.timeStop);
					tempCal.clear();
					tempCal.setTime(stopDate);
					tempCal.set(Calendar.YEAR,currentCal.get(Calendar.YEAR));
					tempCal.set(Calendar.MONTH,currentCal.get(Calendar.MONTH));
					tempCal.set(Calendar.DAY_OF_MONTH,currentCal.get(Calendar.DAY_OF_MONTH));
					stopDate = tempCal.getTime();
				}else{
					stopDate = null;
				}		
			
				Log.d(CustomConstant.ApplicationTag,"After parsing Startdate : "+startDate+ " and stop date:"+stopDate);
								
			} catch (ParseException e) {
				Log.e(CustomConstant.ApplicationTag,"Exceptiion While parsing Dates"+e,e);
				continue;
			}
			boolean timeStopBeforeTimeStart = false;
			
			if(startDate !=null && stopDate!=null){
				timeStopBeforeTimeStart = stopDate.before(startDate);
				Log.d(CustomConstant.ApplicationTag,"Stop Date is before time start");				
			}
			Date currDate = currentCal.getTime();
			
			
			Log.d(CustomConstant.ApplicationTag,"Current Date : "+currDate);			
			Log.d(CustomConstant.ApplicationTag,"Start Date : "+startDate);
			Log.d(CustomConstant.ApplicationTag,"Stop Date : "+stopDate);
			
			//Implementation is start from Here
			if(startDate!=null && stopDate!=null && currDate.after(startDate) && currDate.before(stopDate)){
				validationStatus = CustomConstant.MATCHED;
				break;
			}else if(startDate!=null && stopDate==null && currDate.after(startDate)){
				validationStatus = CustomConstant.MATCHED;
				break;
			}else if(startDate == null && stopDate!=null && currDate.before(stopDate)){
				validationStatus = CustomConstant.MATCHED;
				break;
			}
									
		}
										
		return validationStatus;		
	}
	
	

}
