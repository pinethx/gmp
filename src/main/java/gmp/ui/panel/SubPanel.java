package gmp.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gmp.dto.Subject;
import gmp.service.SubjectService;
import gmp.ui.form.SubjectForm;
import gmp.ui.list.SubList;

@SuppressWarnings("serial")
public class SubPanel extends JPanel implements ActionListener {
	private SubjectService subService;
	private JPanel pBtn;
	private SubjectForm pForm;
	private JButton btnAdd;
	private JButton btnCan;
	private SubList pContent;
	private JButton btnCon;

	public SubPanel() {
		subService = new SubjectService();
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pForm = new SubjectForm();
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
		
		pContent = new SubList();
		add(pContent);
		pContent.setService(subService);
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
		Subject updateSubject = pForm.getItem();
		subService.upSubject(updateSubject);
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, updateSubject.getSubName() + " 과목 정보가 수정되었습니다.");
	}
 
	private void actionPerformedBtnAdd(ActionEvent e) {
		Subject addSubject = pForm.getItem();
		subService.createSubject(addSubject);
		pContent.loadData();
		pForm.clearTf();
		JOptionPane.showMessageDialog(null, addSubject.getSubName() + " 과목을 추가했습니다.");
	}

	private void actionPerformedBtnCan(ActionEvent e) {
		outbtn();
	}

	private void actionPerformedBtnDel(ActionEvent e) {
		Subject delSub = pForm.getItem();
		subService.delSubject(delSub.getSubCode());
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, delSub.getSubName() + " 과목을 삭제했습니다.");
	}

	private void actionPerformedBtnConfirm(ActionEvent e) {
		Subject updateSbj = pContent.getItem();
		((SubjectForm)pForm).gettFSubNo().setEditable(false);
		pForm.setItem(updateSbj);
		btnAdd.setText("수정");
		btnCon.setText("삭제");
	}

	private void outbtn() {
		pForm.clearTf();
		((SubjectForm)pForm).gettFSubNo().setEditable(true);
		btnAdd.setText("추가");
		btnCon.setText("확인");
	}

}
