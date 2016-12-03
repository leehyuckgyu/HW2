package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;

@Service
public class CoursesService {
	private CourseDAO courseDao;

	@Autowired
	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}

	public List<Course> getNewCourses() {
		return courseDao.getNewCourses();
	}

	public List<Course> getCourses(int year, int semester) {
		return courseDao.getCourses(year, semester);
	}

	public int[] getSumOfCategory() { //구분에 따른 학점 계산
		
		List<Course> courses = courseDao.getCourses();
		
		int[] sum = {0,0,0,0,0,0,0};
		for (int i = 0; i < courses.size(); i++) {
			String category = courses.get(i).getCategory();
			int credit = courses.get(i).getCredit();
			
			if (category.contains("교필")) sum[0] += credit;
			else if (category.contains("토대")) sum[1] += credit;
			else if (category.contains("인재")) sum[2] += credit;
			else if (category.contains("자율")) sum[3] += credit;
			else if (category.contains("전기")) sum[4] += credit;
			else if (category.contains("전선")) sum[5] += credit;
			else sum[6] += credit;
		}
		return sum;
	}

	public boolean insertCourse(Course course) {
		return courseDao.insert(course);
	}

	public List<Course> getSumCreditBySemester() {
		return courseDao.getSumCreditBySemester();
	}

}
