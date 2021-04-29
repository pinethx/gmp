package gmp.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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

	public ConfirmAllGradeFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("전체 성적 확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
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
		
		JButton btnConfirm = new JButton("조회");
		panel.add(btnConfirm);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 8, 0, 0));
		
		JLabel lblAvg = new JLabel("과목별 평균 점수");
		panel_1.add(lblAvg);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		tFKor = new JTextField();
		panel_1.add(tFKor);
		tFKor.setColumns(10);
		
		tFEng = new JTextField();
		panel_1.add(tFEng);
		tFEng.setColumns(10);
		
		tFMath = new JTextField();
		panel_1.add(tFMath);
		tFMath.setColumns(10);
		
		tFSoc = new JTextField();
		panel_1.add(tFSoc);
		tFSoc.setColumns(10);
		
		tFSie = new JTextField();
		panel_1.add(tFSie);
		tFSie.setColumns(10);
		
		tFAvg = new JTextField();
		panel_1.add(tFAvg);
		tFAvg.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}
