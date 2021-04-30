package gmp.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gmp.dto.ClassR;
import gmp.dto.Subject;
import gmp.service.ClassRService;
import gmp.service.GradeService;
import gmp.service.SubjectService;
import gmp.ui.list.GradeTotalList;

@SuppressWarnings("serial")
public class ConfirmAllGradeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tFTotal;
	private JTextField tFKor;
	private JTextField tFEng;
	private JTextField tFMath;
	private JTextField tFSoc;
	private JTextField tFAvg;
	private JTextField tFSie;
	private GradeTotalList pMain;
	private DefaultComboBoxModel<Subject> model;
	private GradeService service;
	private SubjectService subservice;

	public ConfirmAllGradeFrame() {
		service = new GradeService();
		subservice = new SubjectService();
		initialize();
	}

	private void initialize() {
		setTitle("전체 성적 확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblTitle = new JLabel("전체성적확인");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitle);
		
		JPanel pSpace = new JPanel();
		panel.add(pSpace);
		
		JLabel lblTotal = new JLabel("전체 인원수");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTotal);
		
		tFTotal = new JTextField();
		panel.add(tFTotal);
		tFTotal.setColumns(10);
		
		JLabel lblSub = new JLabel("과목명");
		lblSub.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSub);
		
		JComboBox cmbSub = new JComboBox();
		panel.add(cmbSub);
		
		Subject sub = new Subject();
		List<Subject> subList = subservice.showSubjectAll();

		subList.add(sub);
		model = new DefaultComboBoxModel<>(new Vector<>(subList));
		cmbSub.setModel(model);
		
		JButton btnConfirm = new JButton("정렬");
		panel.add(btnConfirm);
		
		JPanel pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblAvg = new JLabel("과목별 평균 점수");
		pBottom.add(lblAvg);

		pMain = new GradeTotalList();
		contentPane.add(pMain, BorderLayout.CENTER);
		pMain.setService(service);
		pMain.loadData();

		tFKor = new JTextField();
		pBottom.add(tFKor);
		tFKor.setColumns(10);
		tFKor.setText(String.format("%.1f", pMain.getKoravg()));
		tFKor.setEditable(false);
		
		tFEng = new JTextField();
		pBottom.add(tFEng);
		tFEng.setColumns(10);
		tFEng.setText(String.format("%.1f", pMain.getEngavg()));
		tFEng.setEditable(false);
		
		tFMath = new JTextField();
		pBottom.add(tFMath);
		tFMath.setColumns(10);
		tFMath.setText(String.format("%.1f", pMain.getMathavg()));
		tFMath.setEditable(false);
		
		tFSoc = new JTextField();
		pBottom.add(tFSoc);
		tFSoc.setColumns(10);
		tFSoc.setText(String.format("%.1f", pMain.getSocavg()));
		tFSoc.setEditable(false);
		
		tFSie = new JTextField();
		pBottom.add(tFSie);
		tFSie.setColumns(10);
		tFSie.setText(String.format("%.1f", pMain.getSieavg()));
		tFSie.setEditable(false);
		
		tFAvg = new JTextField();
		pBottom.add(tFAvg);
		tFAvg.setColumns(10);
		tFAvg.setText(String.format("%.1f", pMain.getAvgAvg()));
		tFAvg.setEditable(false);
	}

}
