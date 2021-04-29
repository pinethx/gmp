package gmp.service;

import java.util.List;

import gmp.dao.SubjectDao;
import gmp.dao.impl.ScoreDaoImpl;
import gmp.dao.impl.SubjectDaoImpl;
import gmp.dto.Score;
import gmp.dto.Student;
import gmp.dto.Subject;

public class ScoreService {
	private ScoreDaoImpl dao = ScoreDaoImpl.getInstance();
	private SubjectDao subdao = SubjectDaoImpl.getInstance();
	
	public List<Subject> showSubjectAll(){
		return subdao.selectSubjectByAll();
	}
	
	public List<Score> showScoreAll() {
		return dao.selectScoreByAll();
	}
	
	public void showScoreSubcode(Score score) {
		dao.selectScoreByNo(score);
	}
	
	public void createScore(Score score) {
		dao.insertScore(score);
	}
	
	public void delScore(Student student, Subject subject) {
		dao.deleteScore(student, subject);
	}
	
	public void upScore(Score score) {
		dao.updateScore(score);
	}
}
