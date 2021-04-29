package gmp.ui.list;

import javax.swing.SwingConstants;

import gmp.dto.Score;
import gmp.dto.Student;
import gmp.dto.Subject;
import gmp.service.ScoreService;
import gmp.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class TotalScoreList extends AbstractCustomList<Score> {
	
	public TotalScoreList() {}

	private ScoreService service;

	@Override
	public Score getItem() {
		int row = table.getSelectedRow();
		Student stdNo = (Student) table.getValueAt(row, 1);
		Subject subNo = (Subject) table.getValueAt(row, 2);
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Score((Student) stdNo, (Subject) subNo)));
	}

	@Override
	protected void initList() {
		list = service.showScoreAll();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"번호", "학번", "이름", "국어", "영어", "수학", "사회", "과학", "합계", "평균"};
	}
	
	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		setTableCellWidth(50, 200, 200, 100, 100, 100, 100, 100, 100, 100);
	}
	
	public void setService(ScoreService service) {
		this.service = service;
	}

	@Override
	protected Object[] toArray(Score t) {
		return new Object[] {t.getNo(), t.getStdNo(), t.getStdNo().getStdName(), t.getSubCode().getSubName(), t.getSubScore()};
	}
}
