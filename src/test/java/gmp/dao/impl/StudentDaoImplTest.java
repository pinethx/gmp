package gmp.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gmp.dao.StudentDao;
import gmp.dto.ClassR;
import gmp.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoImplTest {
	private static StudentDao dao = StudentDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectStudentByAll() {
		System.out.printf("%s()%n", "test04SelectStudentByAll");
		List<Student> studentList = dao.selectStudentByAll();
		Assert.assertNotNull(studentList);

		for (Student t : studentList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectStudentByNo() {
		System.out.printf("%s()%n", "test05SelectStudentByNo");
		Student student = new Student(new ClassR(1));
		List<Student> searchStudent = dao.selectStudentByclassNo(student);
		Assert.assertNotNull(searchStudent);

		for (Student t : searchStudent) {
			System.out.println(t);
		}
	}
	
	@Test
	public void test06SelectStudentBystdNo() {
		System.out.printf("%s()%n", "test06SelectStudentBystdNo");
		Student student = new Student(20001);
		Student searchStudent = dao.selectStudentBystdNo(student);
		Assert.assertNotNull(searchStudent);
		System.out.println(searchStudent);
	}

	@Test
	public void test01InsertStudent() {
		System.out.printf("%s()%n", "test01InsertStudent");
		Student newStudent = new Student(20031, "하하하", new ClassR(1));
		int res = dao.insertStudent(newStudent);
		Assert.assertEquals(1, res);
//		System.out.println(dao.selectClassRByNo(newClassR));

		dao.selectStudentByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateStudent() {
		System.out.printf("%s()%n", "test02UpdateStudent");
		Student newStudent = new Student(20031, "하하하", new ClassR(2));
		int res = dao.updateStudent(newStudent);
		Assert.assertEquals(1, res);
//		System.out.println(dao.selectClassRByNo(newClassR));

		dao.selectStudentByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test03DeleteStudent() {
		System.out.printf("%s()%n", "test03DeleteStudent");
		int res = dao.deleteStudent(20031);
		Assert.assertEquals(1, res);
		
		dao.selectStudentByAll().stream().forEach(System.out::println);
	}

}
