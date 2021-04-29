package gmp.dao;

import java.util.List;

import gmp.dto.Student;

public interface StudentDao {

	List<Student> selectStudentByAll();
	List<Student> selectStudentByclassNo(Student student);
	Student selectStudentBystdNo(Student student);
	
	int insertStudent(Student student);
	int updateStudent(Student newstudent);
	int deleteStudent(int stdNo);
}
