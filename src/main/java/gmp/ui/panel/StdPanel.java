package gmp.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gmp.dto.Student;
import gmp.service.StudentService;
import gmp.ui.form.StudentForm;
import gmp.ui.list.StdList;

@SuppressWarnings("serial")
public class StdPanel extends JPanel implements ActionListener {
	private StudentService stdService;
	private StudentForm pForm;
	private JPanel pBtn;
	private JButton btnAdd;
	private JButton btnCon;
	private JButton btnCan;
	private StdList pContent;

	public StdPanel() {
		stdService = new StudentService();
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pForm = new StudentForm();
		pForm.setService(stdService);
		add(pForm);
		
		pBtn = new JPanel();
		add(pBtn);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);
		
		btnCon = new JButton("확인");
		btnCon.addActionListener(this);
		pBtn.add(btnCon);
		
		btnCan = new JButton("취소");
		btnCan.addActionListener(this);
		pBtn.add(btnCan);
		
		pContent = new StdList();
		add(pContent);
		pContent.setService(stdService);
		pContent.loadData();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().contentEquals("확인")) {
			actionPerformedBtnConfirm(e);
		}
		if (e.getActionCommand().contentEquals("삭제")) {
			actionPerformedBtnDel(e);
		}
		if (e.getActionCommand().contentEquals("취소")) {
			actionPerformedBtnCan(e);
		}
		if (e.getActionCommand().contentEquals("추가")) {
			actionPerformedBtnAdd(e);
		}
		if (e.getActionCommand().contentEquals("수정")) {
			actionPerformedBtnUpdate(e);
		}
	}

	private void actionPerformedBtnUpdate(ActionEvent e) {
		Student updateStd = pForm.getItem();
		stdService.upStudent(updateStd);
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, updateStd.getStdName() + " 학생의 정보가 수정되었습니다.");		
	}
 
	private void actionPerformedBtnAdd(ActionEvent e) {
		Student addStudent = pForm.getItem();
		stdService.createStudent(addStudent);
		pContent.loadData();
		pForm.clearTf();
		JOptionPane.showMessageDialog(null, addStudent.getStdName() + " 학생을 추가했습니다.");
	}

	private void actionPerformedBtnCan(ActionEvent e) {
		outbtn();
	}

	private void actionPerformedBtnDel(ActionEvent e) {
		Student delStd = pForm.getItem();
		stdService.delStudent(delStd.getStdNo());
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, delStd.getStdName() + " 학생을 삭제했습니다.");
	}

	private void actionPerformedBtnConfirm(ActionEvent e) {
		Student updateStd = pContent.getItem();
		((StudentForm)pForm).gettFstdNo().setEditable(false);
		pForm.setItem(updateStd);
		btnAdd.setText("수정");
		btnCon.setText("삭제");
	}

	private void outbtn() {
		pForm.clearTf();
		((StudentForm)pForm).gettFstdNo().setEditable(true);
		btnAdd.setText("추가");
		btnCon.setText("확인");
	}

}
