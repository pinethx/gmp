package gmp.ui.form;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import gmp.dto.Score;
import gmp.dto.Student;
import gmp.dto.Subject;
import gmp.service.ScoreService;
import gmp.ui.exception.InvalidCheckException;

@SuppressWarnings("serial")
public class ScoreForm extends AbstractForm<Score>{
	private JTextField tFNo;
	private JTextField tFstdNo;
	private JTextField tFsubScore;
	private JLabel lblNo;
	private JLabel lblstdNo;
	private JLabel lblsubcode;
	private JComboBox<Subject> cbsubcode;
	private DefaultComboBoxModel<Subject> model;
	private JLabel lblsubScore;
	
	private ScoreService service;
	
	public JTextField gettFNo() {
		return tFNo;
	}

	public void settFNo(JTextField tFNo) {
		this.tFNo = tFNo;
	}

	public JTextField gettFstdNo() {
		return tFstdNo;
	}

	public void settFstdNo(JTextField tFstdNo) {
		this.tFstdNo = tFstdNo;
	}

	public JTextField gettFsubScore() {
		return tFsubScore;
	}

	public void settFsubScore(JTextField tFsubScore) {
		this.tFsubScore = tFsubScore;
	}

	public ScoreForm() {
		initialize();
	}
	
	public void setService(ScoreService service) {
		this.service = service;
		
		Subject sub = new Subject();
		List<Subject> subList = service.showSubjectAll();

		subList.add(sub);
		model = new DefaultComboBoxModel<>(new Vector<>(subList));
		cbsubcode.setModel(model);
		
		cbsubcode.setSelectedIndex(-1);
	}

	private void initialize() {
		setBorder(new TitledBorder(null, "\uC810\uC218 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 4, 0, 0));
		
		lblNo = new JLabel("번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tFNo = new JTextField();
		add(tFNo);
		tFNo.setColumns(10);
		
		lblstdNo = new JLabel("학번");
		lblstdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblstdNo);
		
		tFstdNo = new JTextField();
		add(tFstdNo);
		tFstdNo.setColumns(10);
		
		lblsubcode = new JLabel("과목코드");
		lblsubcode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblsubcode);
		
		cbsubcode = new JComboBox<Subject>();
		add(cbsubcode);
		
		lblsubScore = new JLabel("점수");
		lblsubScore.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblsubScore);
		
		tFsubScore = new JTextField();
		add(tFsubScore);
		tFsubScore.setColumns(10);
	}

	@Override
	public void setItem(Score item) {
		tFNo.setText(item.getNo() + "");
		tFstdNo.setText(item.getStdNo().getStdNo() + "");
		cbsubcode.setSelectedItem(new Subject(item.getSubCode().getSubCode()));
		tFsubScore.setText(item.getSubScore() + "");
	}

	@Override
	public Score getItem() {
		validCheck();
		int no = Integer.parseInt(tFNo.getText().trim());
		int stdNo = Integer.parseInt(tFstdNo.getText().trim());
		Subject subcode = (Subject) cbsubcode.getSelectedItem();
		int subscore = Integer.parseInt(tFsubScore.getText().trim());
		return new Score(no, new Student(stdNo), subcode, subscore);	
	}

	@Override
	public void validCheck() {
		if(tFNo.getText().equals("")||tFstdNo.getText().equals("")||tFsubScore.getText().equals("")||cbsubcode.getSelectedIndex() == -1) {
			throw new InvalidCheckException();
		}
	}

	@Override
	public void clearTf() {
		tFNo.setText("");
		tFstdNo.setText("");
		cbsubcode.setSelectedIndex(-1);
		tFsubScore.setText("");
	}

}
