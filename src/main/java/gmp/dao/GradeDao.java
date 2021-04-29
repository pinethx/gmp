package gmp.dao;

import java.util.List;

import gmp.dto.ClassR;
import gmp.dto.Grade;

public interface GradeDao {

	List<Grade> selectGradeByAllfromView();
	List<Grade> selectScoreByStudentfromView(int std);
	List<Grade> selectGradeByClassfromView(ClassR clr);
}
