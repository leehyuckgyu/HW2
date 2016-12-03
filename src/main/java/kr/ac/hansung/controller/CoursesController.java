package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CoursesService;

@Controller
public class CoursesController {
	private CoursesService coursesService;

	@Autowired
	public void setCoursesService(CoursesService coursesService) {
		this.coursesService = coursesService;
	}

	@RequestMapping("/sumcreditbysemester")
	public String showInfoBySemester(Model model) {
		List<Course> sumcreditbysemester = coursesService.getSumCreditBySemester();
		model.addAttribute("sumcreditbysemester", sumcreditbysemester);
		return "sumcreditbysemester";
	}

	@RequestMapping("/moreinfo")
	public String showInfoByYearSemester(Model model, @RequestParam("year") int year, @RequestParam("semester") int semester) {
		List<Course> moreinfo = coursesService.getCourses(year, semester);
		model.addAttribute("moreinfo", moreinfo);
		return "moreinfo";
	}

	@RequestMapping("/sumcreditbycategory")
	public String showInfoByClassify(Model model) {
		int[] sumcreditbycategory = coursesService.getSumOfCategory();
		model.addAttribute("sumcreditbycategory", sumcreditbycategory);
		return "sumcreditbycategory";
	}

	@RequestMapping("/newcourse")
	public String signup(Model model) {
		model.addAttribute("course", new Course());
		return "newcourse";
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String signupClass(@Valid Course course, BindingResult result) {
		coursesService.insertCourse(course);
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "newcourse";
		}
		return "home";
	}

	@RequestMapping("/newcourseinfo")
	public String showSignupClassInfo(Model model) {
		List<Course> newcourseinfo = coursesService.getNewCourses();
		model.addAttribute("newcourseinfo", newcourseinfo);
		return "newcourseinfo";
	}

}
