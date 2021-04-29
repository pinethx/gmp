package gmp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gmp.dao.ScoreDao;
import gmp.dto.Score;
import gmp.dto.Student;
import gmp.dto.Subject;
import gmp.util.JdbcUtil;

public class ScoreDaoImpl implements ScoreDao {
	
	private static final ScoreDaoImpl instance = new ScoreDaoImpl();
	
	public static ScoreDaoImpl getInstance() {
		return instance;
	}

	private Connection con = JdbcUtil.getConnection();
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	@Override
	public List<Score> selectScoreByAll() {
		String sql = "select no, stdno, stdname, subcode, subname, subscore from vw_score";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				List<Score> list = new ArrayList<>();
				do {list.add(getScore(rs));} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Score> selectScoreBySubCode(Score score) {
		String sql = "select no, stdname, subname, subscore from vw_score where subcode = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			pstmt.setInt(1, score.getSubCode().getSubCode());
			if(rs.next()) {
				List<Score> list = new ArrayList<>();
				do {list.add(getScore(rs));} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Score getScore(ResultSet rs) throws SQLException {
		int no = rs.getInt("no");
		Student stdno = null;
		Subject subcode = null;
		int subscore = rs.getInt("subscore");

		try {
			stdno = new Student(rs.getInt("stdno"));
			stdno.setStdNo(rs.getInt("stdno"));
			stdno.setStdName(rs.getString("stdname"));
		} catch (SQLException e) {
		}

		try {
			subcode= new Subject(rs.getInt("subcode"));
			subcode.setSubCode(rs.getInt("subcode"));
			subcode.setSubName(rs.getString("subname"));
		} catch (SQLException e) {
		}
		
		return new Score(no, stdno, subcode, subscore);
	}

	@Override
	public List<Score> selectScoreByNo(Score score) {
		String sql = "select no, stdno, subcode, subscore from score where stdno = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, score.getStdNo().getStdNo());
			System.out.println(pstmt);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<Score> list = new ArrayList<>();
					do {list.add(getScore(rs));} while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertScore(Score score) {
		String sql = "insert into score values (?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, score.getNo());
			pstmt.setInt(2, score.getStdNo().getStdNo());
			pstmt.setInt(3, score.getSubCode().getSubCode());
			pstmt.setInt(4, score.getSubScore());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateScore(Score newscore) {
		String sql = "update score set subscore = ? where stdno = ? and subcode = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, newscore.getSubScore());
			pstmt.setInt(2, newscore.getStdNo().getStdNo());
			pstmt.setInt(3, newscore.getSubCode().getSubCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteScore(Student student, Subject subject) {
		String sql = "delete from score where stdno = ? and subcode = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, student.getStdNo());
			pstmt.setInt(2, subject.getSubCode());
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
