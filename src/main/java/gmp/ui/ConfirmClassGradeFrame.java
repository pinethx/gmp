package gmp.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gmp.dto.ClassR;
import gmp.dto.Grade;
import gmp.dto.Subject;
import gmp.service.ClassRService;
import gmp.service.GradeService;
import gmp.service.SubjectService;
import gmp.ui.list.GradeTotalList;

@SuppressWarnings("serial")
public class ConfirmClassGradeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tFKor;
	private JTextField tFEng;
	private JTextField tFSie;
	private JTextField tFSoc;
	private JTextField tFMath;
	private JTextField tFAvg;
	private DefaultComboBoxModel<Subject> model;
	private DefaultComboBoxModel<ClassR> model2;
	private GradeService service;
	private SubjectService subservice;
	private ClassRService clsservice;
	private JPanel pTop;
	private JPanel pBottom;
	private GradeTotalList pMain;
	private JLabel lblTitle;
	private JPanel panel;
	private JLabel lblSelect;
	private JComboBox cbsub;
	private JComboBox cbcls;
	private JButton btn1;

	public ConfirmClassGradeFrame() {
		service = new GradeService();
		subservice = new SubjectService();
		clsservice = new ClassRService();
		initialize();
	}

	private void initialize() {
		setTitle("분반별성적확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 6, 0, 0));
		
		lblTitle = new JLabel("분반별성적확인");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblTitle);
		
		cbcls = new JComboBox();
		pTop.add(cbcls);

		ClassR cls = new ClassR();
		List<ClassR> clsList = clsservice.showClassRAll();

		clsList.add(cls);
		model2 = new DefaultComboBoxModel<>(new Vector<>(clsList));
		cbcls.setModel(model2);
		
		cbcls.setSelectedIndex(-1);
		
		panel = new JPanel();
		pTop.add(panel);
		
		lblSelect = new JLabel("과목명");
		lblSelect.setHorizontalAlignment(SwingConstants.RIGHT);
		pTop.add(lblSelect);
		
		cbsub = new JComboBox();
		pTop.add(cbsub);
		
		Subject sub = new Subject();
		List<Subject> subList = subservice.showSubjectAll();

		subList.add(sub);
		model = new DefaultComboBoxModel<>(new Vector<>(subList));
		cbsub.setModel(model);
		
		cbsub.setSelectedIndex(-1);
		
		btn1 = new JButton("정렬");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pTop.add(btn1);
		
		pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblAverage = new JLabel("과목별평균점수");
		lblAverage.setHorizontalAlignment(SwingConstants.CENTER);
		pBottom.add(lblAverage);

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
