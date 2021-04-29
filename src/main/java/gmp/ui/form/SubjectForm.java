package gmp.ui.form;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import gmp.dto.Subject;
import gmp.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class SubjectForm extends AbstractForm<Subject>{
	private JTextField tFSubNo;
	private JTextField tFSubName;

	public JTextField gettFSubNo() {
		return tFSubNo;
	}

	public void settFSubNo(JTextField tFSubNo) {
		this.tFSubNo = tFSubNo;
	}

	public JTextField gettFSubName() {
		return tFSubName;
	}

	public void settFSubName(JTextField tFSubName) {
		this.tFSubName = tFSubName;
	}

	public SubjectForm() {
		setBorder(new TitledBorder(null, "\uACFC\uBAA9 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblSubNo = new JLabel("과목코드");
		lblSubNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSubNo);
		
		tFSubNo = new JTextField();
		add(tFSubNo);
		tFSubNo.setColumns(10);
		
		JLabel lblSubName = new JLabel("과목이름");
		lblSubName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSubName);
		
		tFSubName = new JTextField();
		add(tFSubName);
		tFSubName.setColumns(10);

	}

	@Override
	public void setItem(Subject item) {
		tFSubNo.setText(item.getSubCode() + "");
		tFSubName.setText(item.getSubName());
	}

	@Override
	public Subject getItem() {
		validCheck();
		int subcode = Integer.parseInt(tFSubNo.getText().trim());
		String subName = tFSubName.getText().trim();
		return new Subject(subcode, subName);	
	}

	@Override
	public void validCheck() {
		if (tFSubNo.getText().equals("") || tFSubName.getText().equals("")) {
			throw new InvalidCheckException();
		}
	}

	@Override
	public void clearTf() {
		tFSubNo.setText("");
		tFSubName.setText("");
	}

}
