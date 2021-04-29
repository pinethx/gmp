package gmp.ui.form;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import gmp.dto.ClassR;
import gmp.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class ClassRForm extends AbstractForm<ClassR>{
	private JTextField tFClassRm;
	private JTextField tFClassNo;
	
	public JTextField gettFClassRm() {
		return tFClassRm;
	}

	public void settFClassRm(JTextField tFClassRm) {
		this.tFClassRm = tFClassRm;
	}

	public JTextField gettFClassNo() {
		return tFClassNo;
	}

	public void settFClassNo(JTextField tFClassNo) {
		this.tFClassNo = tFClassNo;
	}

	public ClassRForm() {
		setBorder(new TitledBorder(null, "\uBD84\uBC18 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblClassCode = new JLabel("분반코드");
		lblClassCode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblClassCode);
		
		tFClassNo = new JTextField();
		add(tFClassNo);
		tFClassNo.setColumns(10);
		
		JLabel lblClassRm = new JLabel("분반");
		lblClassRm.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblClassRm);
		
		tFClassRm = new JTextField();
		add(tFClassRm);
		tFClassRm.setColumns(10);

	}

	@Override
	public void setItem(ClassR item) {
		tFClassNo.setText(item.getClassNo() + "");
		tFClassRm.setText(item.getClassRm());
	}

	@Override
	public ClassR getItem() {
		validCheck();
		int classNo = Integer.parseInt(tFClassNo.getText().trim());
		String className = tFClassRm.getText().trim();
		return new ClassR(classNo, className);	
	}

	@Override
	public void validCheck() {
		if (tFClassNo.getText().equals("") || tFClassRm.getText().equals("")) {
			throw new InvalidCheckException();
		}
	}

	@Override
	public void clearTf() {
		tFClassNo.setText("");
		tFClassRm.setText("");
	}

}
