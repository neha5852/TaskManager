package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="PROJECT")
public class ProjectChecking implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name = "PROJECT_NAME", nullable = false)
	private String projectName;

	@NotEmpty
	@Column(name = "PROJECT_DESCRIPTION", nullable = false)
	private String projectDescription;


	@Column(name = "OWNER", unique = true, nullable = false)
	private String owner;

	@NotEmpty
	@Column(name = "TEAM", nullable = false)
	private String team;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE", nullable = false)
	private Date endDate;
	
	@NotEmpty
	@Column(name = "DEF_QA", nullable = false)
	private Integer qa;
	
	@NotEmpty
	@Column(name = "DEF_UAT", nullable = false)
	private Integer uat;
	
	@NotEmpty
	@Column(name = "DEF_POST_PROD", nullable = false)
	private Integer post;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Raised_End_Date", nullable = false)
	private Date raisedEndDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Actual_End_Date", nullable = false)
	private Date actualEndDate;
	
	@NotEmpty
	@Column(name= "Planned_Effort", nullable = false)
	private Integer plannedEfforts;
	
	@NotEmpty
	@Column(name= "Actual_Efforts", nullable = false)
	private Integer actualEfforts;

	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PROJECT_PROJECT_PROFILE", joinColumns = { @JoinColumn(name = "PROJECT_ID") },
	           inverseJoinColumns = { @JoinColumn(name = "PROJECT_PROFILE_ID") }) 

	private Set<ProjectProfile> projectProfiles = new HashSet<ProjectProfile>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getQa() {
		return qa;
	}

	public void setQa(Integer qa) {
		this.qa = qa;
	}

	public Integer getUat() {
		return uat;
	}

	public void setUat(Integer uat) {
		this.uat = uat;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public Date getRaisedEndDate() {
		return raisedEndDate;
	}

	public void setRaisedEndDate(Date raisedEndDate) {
		this.raisedEndDate = raisedEndDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Integer getPlannedEfforts() {
		return plannedEfforts;
	}

	public void setPlannedEfforts(Integer plannedEfforts) {
		this.plannedEfforts = plannedEfforts;
	}

	public Integer getActualEfforts() {
		return actualEfforts;
	}

	public void setActualEfforts(Integer actualEfforts) {
		this.actualEfforts = actualEfforts;
	}

	public Set<ProjectProfile> getProjectProfiles() {
		return projectProfiles;
	}

	public void setProjectProfiles(Set<ProjectProfile> projectProfiles) {
		this.projectProfiles = projectProfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actualEfforts == null) ? 0 : actualEfforts.hashCode());
		result = prime * result
				+ ((actualEndDate == null) ? 0 : actualEndDate.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result
				+ ((plannedEfforts == null) ? 0 : plannedEfforts.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime
				* result
				+ ((projectDescription == null) ? 0 : projectDescription
						.hashCode());
		result = prime * result
				+ ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result
				+ ((projectProfiles == null) ? 0 : projectProfiles.hashCode());
		result = prime * result + ((qa == null) ? 0 : qa.hashCode());
		result = prime * result
				+ ((raisedEndDate == null) ? 0 : raisedEndDate.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + ((uat == null) ? 0 : uat.hashCode());
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
		ProjectChecking other = (ProjectChecking) obj;
		if (actualEfforts == null) {
			if (other.actualEfforts != null)
				return false;
		} else if (!actualEfforts.equals(other.actualEfforts))
			return false;
		if (actualEndDate == null) {
			if (other.actualEndDate != null)
				return false;
		} else if (!actualEndDate.equals(other.actualEndDate))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (plannedEfforts == null) {
			if (other.plannedEfforts != null)
				return false;
		} else if (!plannedEfforts.equals(other.plannedEfforts))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (projectDescription == null) {
			if (other.projectDescription != null)
				return false;
		} else if (!projectDescription.equals(other.projectDescription))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (projectProfiles == null) {
			if (other.projectProfiles != null)
				return false;
		} else if (!projectProfiles.equals(other.projectProfiles))
			return false;
		if (qa == null) {
			if (other.qa != null)
				return false;
		} else if (!qa.equals(other.qa))
			return false;
		if (raisedEndDate == null) {
			if (other.raisedEndDate != null)
				return false;
		} else if (!raisedEndDate.equals(other.raisedEndDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (uat == null) {
			if (other.uat != null)
				return false;
		} else if (!uat.equals(other.uat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectChecking [id=" + id + ", projectName=" + projectName
				+ ", projectDescription=" + projectDescription + ", owner="
				+ owner + ", team=" + team + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", qa=" + qa + ", uat=" + uat
				+ ", post=" + post + ", raisedEndDate=" + raisedEndDate
				+ ", actualEndDate=" + actualEndDate + ", plannedEfforts="
				+ plannedEfforts + ", actualEfforts=" + actualEfforts
				+ ", projectProfiles=" + projectProfiles + "]";
	}
	
	
	

	
}

