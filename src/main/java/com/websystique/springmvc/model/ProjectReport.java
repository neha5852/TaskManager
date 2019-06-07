package com.websystique.springmvc.model;

import java.util.Date;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ProjectReport {

	String projectName;
	float scheduleVariance;
	float effortVariance;
	float delivered;
	float production;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public float getScheduleVariance() {
		return scheduleVariance;
	}

	public void setScheduleVariance(float scheduleVariance) {
		this.scheduleVariance = scheduleVariance;
	}

	public float getEffortVariance() {
		return effortVariance;
	}

	public void setEffortVariance(float effortVariance) {
		this.effortVariance = effortVariance;
	}

	public float getDelivered() {
		return delivered;
	}

	public void setDelivered(float delivered) {
		this.delivered = delivered;
	}

	public float getProduction() {
		return production;
	}

	public void setProduction(float production) {
		this.production = production;
	}



	public static float scheduleVariance(Date actualEndDate, Date startDate, Date raiseEndDate) {
	    long diff =(actualEndDate.getTime() - startDate.getTime())/
	  			     (raiseEndDate.getTime() - startDate.getTime());
	    float days = (diff / (1000*60*60*24));
	    return days;
	}
	
		public static float effortsVariance(int actualEfforts, int plannedEfforts) {
	    float diff =(actualEfforts - plannedEfforts)/plannedEfforts;
	   
	    return diff;
	}
	
	public static float delivered(int actualEfforts, int plannedEfforts, int definiteUat) {
	    float diff =definiteUat/(actualEfforts - plannedEfforts);
	   
	    return diff;
	}
	
	public static float production(int actualEfforts, int plannedEfforts, int definitePostProduction) {
	    float diff =definitePostProduction/(actualEfforts - plannedEfforts);
	   
	    return diff;
	}
	
	
}



