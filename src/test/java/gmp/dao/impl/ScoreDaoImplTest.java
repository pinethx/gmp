package gmp.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import gmp.dao.ScoreDao;
import gmp.dto.Score;
import gmp.dto.Student;
import gmp.dto.Subject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScoreDaoImplTest {
	private static ScoreDao dao = ScoreDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test04SelectScoreByAll() {
		System.out.printf("%s()%n", "test04SelectScoreByAll");
		List<Score> scoreList = dao.selectScoreByAll();
		Assert.assertNotNull(scoreList);

		for (Score t : scoreList) {
			System.out.println(t);
		}
	}

	@Test
	public void test05SelectScoreByNo() {
		System.out.printf("%s()%n", "test05SelectScoreByNo");
		Score score = new Score(new Student(20001));
		List<Score> searchScore = dao.selectScoreByNo(score);
		Assert.assertNotNull(searchScore);

		for (Score t : searchScore) {
			System.out.println(t);
		}
	}

	@Test
	public void test01InsertScore() {
		System.out.printf("%s()%n", "test01InsertScore");
		Score newScore = new Score(31, new Student(20031), new Subject(01), 99);
		int res = dao.insertScore(newScore);
		Assert.assertEquals(1, res);

		dao.selectScoreByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test02UpdateScore() {
		System.out.printf("%s()%n", "test02UpdateScore");
		Score newScore = new Score(31, new Student(20031), new Subject(01), 100);
		int res = dao.updateScore(newScore);
		Assert.assertEquals(1, res);

		dao.selectScoreByAll().stream().forEach(System.out::println);
	}

	@Test
	public void test03DeleteScore() {
		System.out.printf("%s()%n", "test03DeleteStudent");
		int res = dao.deleteScore(new Student(20031), new Subject(01));
		Assert.assertEquals(1, res);
		
		dao.selectScoreByAll().stream().forEach(System.out::println);
	}

}
