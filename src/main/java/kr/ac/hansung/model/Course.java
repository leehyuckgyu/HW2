package kr.ac.hansung.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Course {
	private int year;
	private int semester;
	private String subjectcode;
	private String subjectname;
	private String category;
	private int credit;

	public Course(int year, int semester, String subjectcode, String subjectname, String category, int credit) {

		this.year = year;
		this.semester = semester;
		this.subjectcode = subjectcode;
		this.subjectname = subjectname;
		this.category = category;
		this.credit = credit;

	}

	public Course() {
	}
	
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getSubjectcode() {
		return subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "[year=" + year + ", semester=" + semester + ", subjectcode=" + subjectcode + ", subjectname="
				+ subjectname + ", category=" + category + ", credit=" + credit + "]";
	}

}
