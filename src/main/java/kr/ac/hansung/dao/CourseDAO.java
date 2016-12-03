package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() { // Record ���� Count
		String sql = "select count(*) from courseinfo";
		return jdbcTemplateObject.queryForObject(sql, Integer.class);
	}

	public Course getCourse(String subjectname) {
		String sql = "select * from courseinfo where subjectname=?";
		return jdbcTemplateObject.queryForObject(sql, new Object[] { subjectname }, new CourseMapper());
	}

	public List<Course> getCourses() { // Table�� ��� Record ������
		String sql = "select * from courseinfo";
		return jdbcTemplateObject.query(sql, new CourseMapper());
	}

	public List<Course> getCourses(int year, int semester) { // Table���� Ư�� year,
																// semester ��
																// Record ������
		String sqlStatement = "select * from courseinfo where year=" + year + " and semester=" + semester;
		return jdbcTemplateObject.query(sqlStatement, new CourseMapper());
	}

	public List<Course> getNewCourses() { // ������û ���� ���̺�
		String sql = "select * from newcourseinfo";
		return jdbcTemplateObject.query(sql, new CourseMapper());
	}

	public List<Course> getSumCreditBySemester() { // �г�, �б� �� �̼� �� ����
		String sql = "select year, semester, sum(credit) from courseinfo group by year, semester";
		return jdbcTemplateObject.query(sql, new CourseMapper() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCredit(rs.getInt("sum(credit)"));
				return course;
			}
		});
	}

	public boolean insert(Course course) {
		int year = course.getYear();
		int semester = course.getSemester();
		String subjectcode = course.getSubjectcode();
		String subjectname = course.getSubjectname();
		String category = course.getCategory();
		int credit = course.getCredit();
		String sql = "insert into newcourseinfo (year, semester, subjectcode, subjectname, category, credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sql, new Object[] { year, semester, subjectcode, subjectname, category, credit }) == 1);
	}

	public boolean delete(int code) {
		String sql = "delete from courseinfo where subjectcode=?";
		return (jdbcTemplateObject.update(sql, new Object[] { code }) == 1);
	}
}
