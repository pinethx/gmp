package gmp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gmp.dao.ClassRDao;
import gmp.dto.ClassR;
import gmp.util.JdbcUtil;

public class ClassRDaoImpl implements ClassRDao {
	private static final ClassRDaoImpl instance = new ClassRDaoImpl();
	
	public static ClassRDaoImpl getInstance() {
		return instance;
	}

	private ClassRDaoImpl() {
	}
	
	@Override
	public List<ClassR> selectClassRByAll() {
		String sql = "select classno, classrm from classr";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if (rs.next()) {
				List<ClassR> list = new ArrayList<>();
				do {
					list.add(getClassR(rs));
				}while(rs.next());
//				System.out.println(list.size());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ClassR getClassR(ResultSet rs) throws SQLException {
		int classNo = rs.getInt("classNo");
		String classRm = rs.getString("ClassRm");
		return new ClassR(classNo, classRm);
	}

	@Override
	public ClassR selectClassRByNo(ClassR classR) {
		String sql = "select classno, classrm from classr where classno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, classR.getClassNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getClassR(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertClassR(ClassR classR) {
		String sql = "insert into ClassR value (?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, classR.getClassNo());
			pstmt.setString(2, classR.getClassRm());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateClassR(ClassR newclassR) {
		String sql = "update ClassR set classRm = ? where classNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, newclassR.getClassRm());
			pstmt.setInt(2, newclassR.getClassNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteClassR(int classNo) {
		String sql = "delete from ClassR where classNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, classNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
