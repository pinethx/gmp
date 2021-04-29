package gmp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gmp.dao.StudentDao;
import gmp.dto.ClassR;
import gmp.dto.Student;
import gmp.exception.SqlConstraintException;
import gmp.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {

	private static final StudentDaoImpl instance = new StudentDaoImpl();

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	private StudentDaoImpl() {
	}

	@Override
	public List<Student> selectStudentByAll() {
		String sql = "select stdno, stdname, classno, classrm from vw_full_student";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Student> list = new ArrayList<>();
				do {
					list.add(getStudent(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> selectStudentByclassNo(Student student) {
		String sql = "select stdno, stdname, classno, classrm from vw_full_student where classno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, student.getClassR().getClassNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Student> list = new ArrayList<>();
					do {
						list.add(getStudent(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdno");
		String stdName = rs.getString("stdname");
		ClassR classNo = null;

		try {
			classNo= new ClassR(rs.getInt("classno"));
			classNo.setClassNo(rs.getInt("classno"));
			classNo.setClassRm(rs.getString("classrm"));
		} catch (SQLException e) {
		}
		
		return new Student(stdNo, stdName, classNo);
	}

	@Override
	public Student selectStudentBystdNo(Student student) {
		String sql = "select stdno, stdname, classno, classrm from vw_full_student where stdno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, student.getStdNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student value (?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getStdName());
			pstmt.setInt(3, student.getClassR().getClassNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SqlConstraintException(e.getMessage(), e);
		}
	}

	@Override
	public int updateStudent(Student newstudent) {
		String sql = "update student set stdname = ?, classno = ? where stdno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, newstudent.getStdName());
			pstmt.setInt(2, newstudent.getClassR().getClassNo());
			pstmt.setInt(3, newstudent.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(int stdNo) {
		String sql = "delete from student where stdno = ?";
		try (Connection con = JdbcUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, stdNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SqlConstraintException(e);
		}
	}
}
