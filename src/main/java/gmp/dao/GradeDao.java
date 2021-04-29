package gmp.dao;

import java.util.List;

import gmp.dto.ClassR;
import gmp.dto.Grade;
import gmp.dto.Score;
import gmp.dto.Student;

public interface GradeDao {

	List<Grade> selectGradeByAllfromView();
	List<Grade> selectGradeByClassfromView(ClassR classr);
	List<Grade> selectScoreByStudentfromView(Student std);
}
