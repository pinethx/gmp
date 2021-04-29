package gmp.dao;

import java.util.List;

import gmp.dto.Subject;

public interface SubjectDao {

	List<Subject> selectSubjectByAll();
	Subject selectSubjectByNo(Subject subject);
	
	int insertSubject(Subject subject);
	int updateSubject(Subject newsubject);
	int deleteSubject(int subNo);
}
