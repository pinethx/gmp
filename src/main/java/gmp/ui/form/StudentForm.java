package gmp.ui.form;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import gmp.dto.ClassR;
import gmp.dto.Student;
import gmp.service.StudentService;
import gmp.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class StudentForm extends AbstractForm<Student>{
	private JTextField tFstdNo;
	private JTextField tFstdName;
	private JTextField tFNo;
	private JLabel lblstdNo;
	private JLabel lblstdName;
	private JLabel lblcR;
	private JComboBox<ClassR> cbcR;
	private DefaultComboBoxModel<ClassR> model;
	private JPanel pBlank1;
	private JPanel pBlank2;
	
	private StudentService service;

	public JTextField gettFstdNo() {
		return tFstdNo;
	}

	public void settFstdNo(JTextField tFstdNo) {
		this.tFstdNo = tFstdNo;
	}

	public JTextField gettFstdName() {
		return tFstdName;
	}

	public void settFstdName(JTextField tFstdName) {
		this.tFstdName = tFstdName;
	}

	public JTextField gettFNo() {
		return tFNo;
	}

	public void settFNo(JTextField tFNo) {
		this.tFNo = tFNo;
	}
	
	public void setService(StudentService service) {
		this.service = service;
		
		ClassR cr = new ClassR();
		List<ClassR> crList = service.showClassRAll();

		crList.add(cr);
		model = new DefaultComboBoxModel<>(new Vector<>(crList));
		cbcR.setModel(model);
		
		cbcR.setSelectedIndex(-1);
	}

	public StudentForm() {
		initialize();

	}

	private void initialize() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD559\uC0DD \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 4, 0, 0));
		
		lblstdNo = new JLabel("학번");
		lblstdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblstdNo);
		
		tFstdNo = new JTextField();
		add(tFstdNo);
		tFstdNo.setColumns(10);
		
		lblstdName = new JLabel("이름");
		lblstdName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblstdName);
		
		tFstdName = new JTextField();
		add(tFstdName);
		tFstdName.setColumns(10);
		
		pBlank1 = new JPanel();
		add(pBlank1);
		
		pBlank2 = new JPanel();
		add(pBlank2);
		
		lblcR = new JLabel("분반");
		lblcR.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblcR);
		
		cbcR = new JComboBox<ClassR>();
		add(cbcR);
	}

	@Override
	public void validCheck() {
		if (tFstdNo.getText().equals("") || tFstdName.getText().equals("") || cbcR.getSelectedIndex() == -1) {
			throw new InvalidCheckException();
		}
	}

	@Override
	public void clearTf() {
		tFstdNo.setText("");
		tFstdName.setText("");
		cbcR.setSelectedIndex(-1);
	}

	@Override
	public void setItem(Student item) {	
		tFstdNo.setText(item.getStdNo() + "");
		tFstdName.setText(item.getStdName());
		cbcR.setSelectedItem(new ClassR(item.getClassR().getClassNo()));
	}

	@Override
	public Student getItem() {
		validCheck();
		int stdNo = Integer.parseInt(tFstdNo.getText().trim());
		String stdName = tFstdName.getText().trim();
		ClassR classR = (ClassR) cbcR.getSelectedItem();
		return new Student(stdNo, stdName, classR);	
	}

}
