package com.taashee.training.SpringMinorProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.training.SpringMinorProject.dao.InstructorDao;
import com.taashee.training.SpringMinorProject.dao.StudentDao;
import com.taashee.training.SpringMinorProject.entity.Course;
import com.taashee.training.SpringMinorProject.entity.Instructor;
import com.taashee.training.SpringMinorProject.entity.Student;
import com.taashee.training.SpringMinorProject.entity.Student_Course_Rel;
import com.taashee.training.SpringMinorProject.repository.CourseRepository;
import com.taashee.training.SpringMinorProject.repository.InstructorRepository;
import com.taashee.training.SpringMinorProject.repository.StudentRepository;
import com.taashee.training.SpringMinorProject.repository.Student_Course_RelRepository;

@Controller
public class MainController {
	@Autowired
	  private InstructorRepository instructorRepo;
	@Autowired
	  private CourseRepository courseRepo;
	@Autowired
	  private StudentRepository studentRepo;
	@Autowired
	  private Student student;
	@Autowired
	private Student_Course_RelRepository scrRepo;
	@Autowired
	private PasswordEncoder passwordEncoder ;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private InstructorDao instructorDao;
	@GetMapping("/login")
    public String getLoginPage() {
    	return "login1";
    }
	@GetMapping("/home")
	public String getHomePage(ModelMap modelMap) {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Student s=studentRepo.getStudent(username);
		int student_id=0;
		if(s!=null) {
		student_id=s.getId();}
		if(student_id==0)
			 return "home";
		List<Course> studentCourseList=studentDao.getCourseById(student_id);
		modelMap.put("studentCourseList",studentCourseList);
		return "home";
	}
	@GetMapping("/addInstructor")
	public String getInstructor(ModelMap modelMap) {
		List<Instructor> instructorList=(List<Instructor>) instructorRepo.findAll();
		modelMap.put("instructorList",instructorList);
		return "instructor-list";
	}
	
@GetMapping("/addInstructorForm")
	public String getAddForm() {
		return "addInstructorForm";
	}
	@PostMapping("/addInst")
		public String addInstructor(@RequestParam int id,@RequestParam String iname,@RequestParam String username,@RequestParam String password,ModelMap modelMap) {
	    
		  String encoded_password=passwordEncoder.encode(password);
		   Instructor instructor=new Instructor();
		   instructor.setId(id);
		   instructor.setIname(iname);
		   instructor.setUsername(username);
		   instructor.setPassword(encoded_password);
		   instructor.setRole("INSTRUCTOR");
		   instructorRepo.save(instructor);
		   return getInstructor(modelMap);
	}	
	@GetMapping("/assignCourseForm1")
	public String getAssignForm(ModelMap modelMap) {
		List<Integer> instructorList=instructorDao.getIds();
		System.out.println(instructorList);
		List<Course> courseList=(List<Course>) courseRepo.getAll();
		modelMap.put("instructorList",instructorList);
		modelMap.put("courseList",courseList);
		return "assignCourse1";
	}
	@PostMapping("/assign1")
	public String assignCourseToIns(@RequestParam int Iid,@RequestParam int Cid,ModelMap modelMap) {
	    Instructor ins=instructorRepo.getUserById(Iid);
	    Course course=courseRepo.getCoursesById(Cid);
        Instructor ins1=new Instructor();
        ins1.setId(Iid);
	    Course c=new Course();
	    c.setId(Cid);
	    ins.setCourse(c);
	    course.setInstructor(ins1);
	    instructorRepo.save(ins);
	    courseRepo.save(course);
		return getInstructor(modelMap);
	}
	
	@GetMapping("/getCourse")
	public String getAllCourses(ModelMap modelMap) {
		List<Course> courseList=(List<Course>) courseRepo.findAll();
		modelMap.put("courseList",courseList);
		
		return "course-list";
	}
	@GetMapping("/addCourseForm")
	public String addCourseForm()
	{
		return "addCourseForm";
	}
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam String cname,@RequestParam String description,ModelMap modelMap) {
		Course c=new Course();
		c.setCname(cname);
		c.setDescription(description);
		courseRepo.save(c);
		return getAllCourses(modelMap);
		
	}
	@GetMapping("/addStudent")
	public String getAllStudents(ModelMap modelMap) {
		List<Student> studentList=(List<Student>) studentRepo.findAll();
		modelMap.put("studentList",studentList);
	
		return "student-list";
	}
	@GetMapping("/addStudentForm")
	public String addStudentForm() {
		return "addStudentForm";
	}
	@PostMapping("/addStu")
	public String addStudent(@RequestParam int id,@RequestParam String sname,@RequestParam String username,@RequestParam String password,ModelMap modelMap) {
		String encoded_password=passwordEncoder.encode(password);
		Student student=new Student();
		student.setId(id);
		student.setSname(sname);
		student.setUsername(username);
		student.setPassword(encoded_password);
		student.setRole("STUDENT");
		
		studentRepo.save(student);
		return getAllStudents(modelMap);
}
	@GetMapping("/assignCourseToStu")
	public String assignCourse(ModelMap modelMap) {
		
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		Instructor instructor=instructorRepo.getUser(username);
		modelMap.put("courseList",instructor.getCourse());
		List<Student> stuList=(List<Student>) studentRepo.findAll();
		modelMap.put("stuList",stuList);
		return "assignCourse2";
	}
	@PostMapping("/assign")
	public String assign(@RequestParam int student_id,@RequestParam int course_id,ModelMap modelMap) {
		Student_Course_Rel scr=new Student_Course_Rel();
		scr.setCourse_id(course_id);
		scr.setStudent_id(student_id);
		scrRepo.save(scr);
		return getAllStudents(modelMap);
	}

}
