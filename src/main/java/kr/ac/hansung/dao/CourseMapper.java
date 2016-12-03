package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Course;


public class CourseMapper implements RowMapper<Course>{
	
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException{ //DB�� ���� �޾ƿ� DATA�� ��ü�� ����
		
		Course course = new Course();
		course.setYear(rs.getInt("year"));
		course.setSemester(rs.getInt("semester"));
		course.setSubjectcode(rs.getString("subjectcode"));
		course.setSubjectname(rs.getString("subjectname"));
		course.setCategory(rs.getString("category"));
		course.setCredit(rs.getInt("credit"));
		
		return course;
		
	}
}
