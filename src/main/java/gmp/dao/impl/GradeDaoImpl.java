package gmp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gmp.dao.GradeDao;
import gmp.dto.ClassR;
import gmp.dto.Grade;
import gmp.dto.Score;
import gmp.dto.Student;
import gmp.dto.Subject;
import gmp.util.JdbcUtil;

public class GradeDaoImpl implements GradeDao {
	
	private static final GradeDaoImpl instance = new GradeDaoImpl();
	
	public static GradeDaoImpl getInstance() {
		return instance;
	}

	private Connection con = JdbcUtil.getConnection();
	
	public void setCon(Connection con) {
		this.con = con;
	}


	@Override
	public List<Grade> selectGradeByAllfromView() {
		String sql = "select no, stdno, stdname, classrm"
				+ ", sub1, subn1, 국어, sub2, subn2, 영어, sub3, subn3, 수학, sub4, subn4, 사회, sub5, subn5"
				+ ", 과학, 합계, 평균 from vw_full_score";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				List<Grade> list = new ArrayList<>();
				do {list.add(getGrade(rs));} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Grade getGrade(ResultSet rs) throws SQLException {
		Score no = new Score(rs.getInt("no"));
		Student std = new Student(rs.getInt("stdno"));
		std.setStdName(rs.getString("stdName"));
		ClassR classr = new ClassR(rs.getString("classrm"));
		List<Score> grade = new ArrayList<Score>();
		grade.add(new Score(rs.getInt("no"), new Student(rs.getInt("stdno")), new Subject(rs.getInt("sub1"), rs.getString("subn1")), rs.getInt("국어")));
		grade.add(new Score(rs.getInt("no"), new Student(rs.getInt("stdno")), new Subject(rs.getInt("sub2"), rs.getString("subn2")), rs.getInt("수학")));
		grade.add(new Score(rs.getInt("no"), new Student(rs.getInt("stdno")), new Subject(rs.getInt("sub3"), rs.getString("subn3")), rs.getInt("사회")));
		grade.add(new Score(rs.getInt("no"), new Student(rs.getInt("stdno")), new Subject(rs.getInt("sub4"), rs.getString("subn4")), rs.getInt("과학")));
		grade.add(new Score(rs.getInt("no"), new Student(rs.getInt("stdno")), new Subject(rs.getInt("sub5"), rs.getString("subn5")), rs.getInt("영어")));
		int sum = rs.getInt("합계");
		double  avg = rs.getDouble("평균");
		
		return new Grade(no, std, classr, grade, sum, avg);
	}


	@Override
	public List<Grade> selectGradeByClassfromView(ClassR classr) {
		return null;
	}

	@Override
	public List<Grade> selectScoreByStudentfromView(Student std) {
		return null;
	}

}
