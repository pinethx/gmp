package gmp.service;

import java.util.List;

import gmp.dao.impl.SubjectDaoImpl;
import gmp.dto.Subject;

public class SubjectService {
	private SubjectDaoImpl dao = SubjectDaoImpl.getInstance();

	public SubjectService() {
		dao = SubjectDaoImpl.getInstance();
	}
	
	public List<Subject> showSubjectAll() {
		return dao.selectSubjectByAll();
	}
	
	public void showSubjectSubcode(Subject subject) {
		dao.selectSubjectByNo(subject);
	}
	
	public void createSubject(Subject subject) {
		dao.insertSubject(subject);
	}
	
	public void delSubject(int subNo) {
		dao.deleteSubject(subNo);
	}
	
	public void upSubject(Subject newsubject) {
		dao.updateSubject(newsubject);
	}
	
}
