package gmp.ui.list;

import java.awt.Font;

import javax.swing.SwingConstants;

import gmp.dto.ClassR;
import gmp.dto.Subject;
import gmp.service.SubjectService;
import gmp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class SubList extends AbstractCustomList<Subject> {
	
	public SubList() {
		table.setFont(new Font("돋움", Font.PLAIN, 14));
		table.setRowHeight(30);
		}
	
	private SubjectService service;

	@Override
	public Subject getItem() {
		int row = table.getSelectedRow();
		if (row == -1) {
			throw new NotSelectedException();
		}
		int subNo = (int) table.getValueAt(row, 0);
		
		return list.get(list.indexOf(new Subject(subNo)));
	}

	@Override
	protected void initList() {
		list = service.showSubjectAll();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"과목코드", "과목명"};
	}
	
	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellWidth(200, 200);
	}
	
	public void setService(SubjectService service) {
		this.service = service;
	}

	@Override
	protected Object[] toArray(Subject t) {
		return new Object[] {t.getSubCode(), t.getSubName() };
	}

	@Override
	protected void initList2(ClassR cls) {
	}
}
