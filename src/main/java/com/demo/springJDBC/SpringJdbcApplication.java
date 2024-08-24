package com.demo.springJDBC;

import com.demo.springJDBC.model.Student;
import com.demo.springJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Student s = context.getBean(Student.class);
		s.setId(104);
		s.setName("Rohit");
		s.setMarks(88);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		//System.out.println(s.toString());

		List<Student> students = service.getStudents();
		System.out.println(students);

	}

}
