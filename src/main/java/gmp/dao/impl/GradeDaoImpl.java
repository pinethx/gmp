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
import gmp.dto.Student;
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
		String sql = "select stdno, stdname, classno, classrm" + ", 국어, 영어, 수학, 사회, 과학" + ", 합계, 평균 from vw_full_score";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				List<Grade> list = new ArrayList<>();
				do {
					list.add(getGrade(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Grade getGrade(ResultSet rs) throws SQLException {
		Student std = new Student(rs.getInt("stdno"));
		std.setStdName(rs.getString("stdName"));
		ClassR classr = new ClassR(rs.getInt("classno"));
		std.setClassR(classr);
		classr.setClassRm(rs.getString("classrm"));
		int kor = rs.getInt("국어");
		int eng = rs.getInt("영어");
		int math = rs.getInt("수학");
		int soc = rs.getInt("사회");
		int sci = rs.getInt("과학");
		int sum = rs.getInt("합계");
		double avg = rs.getDouble("평균");

		return new Grade(std, classr, kor, eng, math, soc, sci, sum, avg);
	}

	@Override
	public List<Grade> selectGradeByClassfromView(ClassR clr) {
		String sql = "select stdno, stdname, classno, classrm" + ", 국어, 영어, 수학, 사회, 과학"
				+ ", 합계, 평균 from vw_full_score where classno = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, clr.getClassNo());
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					List<Grade> list = new ArrayList<>();
					do {
						list.add(getGrade(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Grade> selectScoreByStudentfromView(int std) {
		return null;
	}

}
