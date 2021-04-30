package gmp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gmp.service.GradeService;
import gmp.ui.ConfirmAllGradeFrame;
import gmp.ui.ConfirmClassGradeFrame;
import gmp.ui.InsertInfo;
import gmp.ui.list.GradeTotalList;

@SuppressWarnings("serial")
public class GmpMain extends JFrame {

	private JPanel contentPane;
	private JButton btnInfo;
	private JButton btnViewClass;
	private JButton btnViewAll; 
	private GradeService service;
	private JPanel pBottom;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GmpMain frame = new GmpMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GmpMain() {
		setTitle("성적관리프로그램");
		service = new GradeService();
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		GradeTotalList pMain = new GradeTotalList();
		pMain.setService(service);
		pMain.loadData();
		contentPane.add(pMain);
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		
		
		btnInfo = new JButton("입력정보관리");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertInfo frame = new InsertInfo();
				frame.setVisible(true);
			}
		});
		pTop.add(btnInfo);
		
		btnViewClass = new JButton("분반별성적확인");
		btnViewClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmClassGradeFrame frame = new ConfirmClassGradeFrame();
				frame.setVisible(true);
			}
		});
		pTop.add(btnViewClass);
		
		btnViewAll = new JButton("전체성적확인");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmAllGradeFrame frame = new ConfirmAllGradeFrame();
				frame.setVisible(true);
			}
		});
		pTop.add(btnViewAll);
		
		pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);
	}

}
