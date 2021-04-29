package gmp.service;

import java.util.List;

import gmp.dao.impl.ClassRDaoImpl;
import gmp.dao.impl.StudentDaoImpl;
import gmp.dto.ClassR;
import gmp.dto.Student;

public class StudentService {
	private StudentDaoImpl dao = StudentDaoImpl.getInstance();
	private ClassRDaoImpl crdao = ClassRDaoImpl.getInstance();

	public StudentService() {
		dao = StudentDaoImpl.getInstance();
	}
	
	public List<Student> showStudentAll(){
		return dao.selectStudentByAll();
	}
	
	public void showStudentNo(Student student) {
		dao.selectStudentByclassNo(student);
	}
	
	public void createStudent(Student student) {
		dao.insertStudent(student);
	}
	
	public void delStudent(int stdNo) {
		dao.deleteStudent(stdNo);
	}
	
	public void upStudent(Student newstudent) {
		dao.updateStudent(newstudent);
	}

	public List<ClassR> showClassRAll() {
		return crdao.selectClassRByAll();
	}
}
