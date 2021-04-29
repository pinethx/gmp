package gmp.ui.list;

import java.awt.Font;

import javax.swing.SwingConstants;

import gmp.dto.ClassR;
import gmp.dto.Student;
import gmp.service.StudentService;
import gmp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class StdList extends AbstractCustomList<Student> {
	
	public StdList() {
		table.setFont(new Font("돋움", Font.PLAIN, 14));
		table.setRowHeight(30);
		}
	
	private StudentService service;

	@Override
	public Student getItem() {
		int row = table.getSelectedRow();
		Student std = list.get(row);
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(std));
	}

	@Override
	protected void initList() {
		list = service.showStudentAll();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"학번", "이름", "분반"};
	}
	
	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		setTableCellWidth(200, 400, 100);
	}
	
	public void setService(StudentService service) {
		this.service = service;
	}

	@Override
	protected Object[] toArray(Student t) {
		return new Object[] {t.getStdNo(), t.getStdName(), t.getClassR().getClassRm() };
	}

	@Override
	protected void initList2(ClassR cls) {
	}
}
