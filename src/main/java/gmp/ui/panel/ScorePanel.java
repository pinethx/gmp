package gmp.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gmp.dto.Score;
import gmp.service.ScoreService;
import gmp.ui.form.ScoreForm;
import gmp.ui.list.ScoreList;

@SuppressWarnings("serial")
public class ScorePanel extends JPanel implements ActionListener {
	private ScoreService scrservice;
	private ScoreForm pForm;
	private JPanel pBtn;
	private JButton btnAdd;
	private JButton btnCon;
	private JButton btnCan;
	private ScoreList pContent;

	public ScorePanel() {
		scrservice = new ScoreService();
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pForm = new ScoreForm();
		pForm.setService(scrservice);
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
		
		pContent = new ScoreList();
		add(pContent);
		pContent.setService(scrservice);
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
		Score updateScore = pForm.getItem();
		scrservice.upScore(updateScore);
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, updateScore.getStdNo().getStdNo() + "의 " + updateScore.getSubCode().getSubName() + " 점수가 수정되었습니다.");		
	}
 
	private void actionPerformedBtnAdd(ActionEvent e) {
		Score addScore = pForm.getItem();
		scrservice.createScore(addScore);
		pContent.loadData();
		pForm.clearTf();
		JOptionPane.showMessageDialog(null, addScore.getStdNo().getStdNo() + "의 " + addScore.getSubCode().getSubName() + " 점수를 추가했습니다.");
	}

	private void actionPerformedBtnCan(ActionEvent e) {
		outbtn();
	}

	private void actionPerformedBtnDel(ActionEvent e) {
		Score delScr = pForm.getItem();
		scrservice.delScore(delScr.getStdNo(), delScr.getSubCode());
		pContent.loadData();
		outbtn();
		JOptionPane.showMessageDialog(null, delScr.getStdNo().getStdNo() + "의" + delScr.getSubCode().getSubName() + "를 삭제했습니다.");
	}

	private void actionPerformedBtnConfirm(ActionEvent e) {
		Score updateScr = pContent.getItem();
		((ScoreForm)pForm).gettFNo().setEditable(false);
		((ScoreForm)pForm).gettFstdNo().setEditable(false);
		pForm.setItem(updateScr);
		btnAdd.setText("수정");
		btnCon.setText("삭제");
	}

	private void outbtn() {
		pForm.clearTf();
		((ScoreForm)pForm).gettFNo().setEditable(true);
		((ScoreForm)pForm).gettFstdNo().setEditable(true);
		btnAdd.setText("추가");
		btnCon.setText("확인");
	}

}
