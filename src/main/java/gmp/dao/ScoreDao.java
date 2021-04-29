package gmp.dao;

import java.util.List;

import gmp.dto.Score;
import gmp.dto.Student;
import gmp.dto.Subject;

public interface ScoreDao {

	List<Score> selectScoreByAll();
	List<Score> selectScoreBySubCode(Score score);
	List<Score> selectScoreByNo(Score score);
	
	int insertScore(Score score);
	int updateScore(Score newscore);
//	int deleteScore(int stdno, int subcode);
	int deleteScore(Student student, Subject subject);
}
