package gmp.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gmp.dto.ClassR;
import gmp.service.ClassRService;
import gmp.ui.form.ClassRForm;
import gmp.ui.list.ClassRList;

@SuppressWarnings("serial")
public class ClassPanel extends JPanel implements ActionListener {
	private ClassRService clrService;
	private ClassRForm pForm;
	private JPanel pBtn;
	private ClassRList pContent;
	private JButton btnAdd;
	private JButton btnCon;
	private JButton btnCan;

	public ClassPanel() {
		clrService = new ClassRService();
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pForm = new ClassRForm();
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
		
		pContent = new ClassRList();
		add(pContent);
		pContent.setService(clrService);
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
		ClassR updateClassR = pForm.getItem();
		clrService.upClassR(updateClassR);
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, updateClassR.getClassRm() + "의 정보가 수정되었습니다.");		
	}
 
	private void actionPerformedBtnAdd(ActionEvent e) {
		ClassR addClassr = pForm.getItem();
		clrService.createClassR(addClassr);
		pContent.loadData();
		pForm.clearTf();
		JOptionPane.showMessageDialog(null, addClassr.getClassRm() + "을 추가했습니다.");
	}

	private void actionPerformedBtnCan(ActionEvent e) {
		outbtn();
	}

	private void actionPerformedBtnDel(ActionEvent e) {
		ClassR delClassR = pForm.getItem();
		clrService.delClassR(delClassR.getClassNo());
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, delClassR.getClassRm() + "를 삭제했습니다.");
	}

	private void actionPerformedBtnConfirm(ActionEvent e) {
		ClassR updateClr = pContent.getItem();
		((ClassRForm)pForm).gettFClassNo().setEditable(false);
		pForm.setItem(updateClr);
		btnAdd.setText("수정");
		btnCon.setText("삭제");
	}

	private void outbtn() {
		pForm.clearTf();
		((ClassRForm)pForm).gettFClassNo().setEditable(true);
		btnAdd.setText("추가");
		btnCon.setText("확인");
	}

}
