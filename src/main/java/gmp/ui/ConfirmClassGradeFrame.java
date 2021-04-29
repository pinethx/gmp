package gmp.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ConfirmClassGradeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tFKor;
	private JTextField tFEng;
	private JTextField tFSie;
	private JTextField tFSoc;
	private JTextField tFMath;
	private JTextField tFAvg;

	public ConfirmClassGradeFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("분반별성적확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel lblTitle = new JLabel("분반별성적확인");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblTitle);
		
		JScrollBar sBClass = new JScrollBar();
		sBClass.setMaximum(2);
		sBClass.setOrientation(JScrollBar.HORIZONTAL);
		pTop.add(sBClass);
		
		JPanel panel = new JPanel();
		pTop.add(panel);
		
		JLabel lblSelect = new JLabel("과목명");
		lblSelect.setHorizontalAlignment(SwingConstants.RIGHT);
		pTop.add(lblSelect);
		
		JComboBox comboBox = new JComboBox();
		pTop.add(comboBox);
		
		JButton btn1 = new JButton("정렬");
		pTop.add(btn1);
		
		JPanel pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);
		pBottom.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblAverage = new JLabel("과목별평균점수");
		lblAverage.setHorizontalAlignment(SwingConstants.CENTER);
		pBottom.add(lblAverage);
		
		tFKor = new JTextField();
		pBottom.add(tFKor);
		tFKor.setColumns(10);
		
		tFEng = new JTextField();
		pBottom.add(tFEng);
		tFEng.setColumns(10);
		
		tFMath = new JTextField();
		pBottom.add(tFMath);
		tFMath.setColumns(10);
		
		tFSoc = new JTextField();
		pBottom.add(tFSoc);
		tFSoc.setColumns(10);
		
		tFSie = new JTextField();
		pBottom.add(tFSie);
		tFSie.setColumns(10);
		
		tFAvg = new JTextField();
		pBottom.add(tFAvg);
		tFAvg.setColumns(10);
		
		JScrollPane sPCenter = new JScrollPane();
		contentPane.add(sPCenter, BorderLayout.CENTER);
		
		JList list = new JList();
		sPCenter.setViewportView(list);
	}

}
