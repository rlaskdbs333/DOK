package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import User.User;
import theater.theaterInfo;
import theater.DB_Theater;


public class Reservation_start_page extends CategoryFrame{
	
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 125;
	private final static double Panel_Height = Main.SCREEN_HEIGHT * 1.4 ;
	
	// size
	private Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
	
	//DB
	private DB_Theater connect_area = new DB_Theater();
	
	//component
	private JPanel jpanel = new JPanel();
	private JButton btn_movie = new JButton("영화");
	private JButton btn_hall = new JButton("상영관");
	private JLabel jlmovieContent = new JLabel();
	private JLabel jlhallContent = new JLabel();
	private JLabel jlmovieDate = new JLabel("어디 상영시간표");
	private JLabel jlmovieDateTime = new JLabel("날짜 적힐 구역 나중에 버튼이 될 수 있음");
	private JLabel jlmovieTable = new JLabel("선택한 날짜에 대한 영화 목록");
	private JButton[] btn_area = new JButton[4]; 
	
	private theaterInfo[] areas;
	
	public Reservation_start_page() {}
	public Reservation_start_page(User user) {
		super("예매");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);
		
		//데이터 
		areas = connect_area.getTheater();
		this.user = user;
		
		
		//버튼으로 선택
		btn_hall.setBounds(PaddingLeft, PaddingTop, 125, 150);
		btn_hall.setBackground(Color.GREEN);
		btn_hall.addActionListener(new ReservationEvent());
		jpanel.add(btn_hall);
		
		btn_movie.setBounds(PaddingLeft, PaddingTop + 150, 125, 150);
		btn_movie.setBackground(Color.BLUE);
		btn_movie.addActionListener(new ReservationEvent());
		jpanel.add(btn_movie);
		
		//버튼에 따른 내용
		jlhallContent.setBounds(PaddingLeft + 125, PaddingTop, 1050, 300);
		jlhallContent.setOpaque(true);
		jlhallContent.setBackground(Color.GREEN);
		jpanel.add(jlhallContent);
		
		jlmovieContent.setVisible(false);
		jlmovieContent.setBounds(PaddingLeft + 125, PaddingTop, 1050, 300);
		jlmovieContent.setOpaque(true);
		jlmovieContent.setBackground(Color.BLUE);
		jpanel.add(jlmovieContent);
		
		//상영 날짜 시간표
		jlmovieDate.setBounds(PaddingLeft, PaddingTop + 400, 150, 50);
		jlmovieDate.setOpaque(true);
		jlmovieDate.setBackground(Color.ORANGE);
		jpanel.add(jlmovieDate);
		
		jlmovieDateTime.setBounds(PaddingLeft, PaddingTop + 465, 1175, 50);
		jlmovieDateTime.setOpaque(true);
		jlmovieDateTime.setBackground(Color.LIGHT_GRAY);
		jpanel.add(jlmovieDateTime);
		
		jlmovieTable.setBounds(PaddingLeft, PaddingTop + 520, 1175, 350);
		jlmovieTable.setOpaque(true);
		jlmovieTable.setBackground(Color.YELLOW);
		jpanel.add(jlmovieTable);
		
		//Panel
		size.setSize(Main.SCREEN_WIDTH, Panel_Height);
		jpanel.setBackground(Color.WHITE);
		jpanel.setPreferredSize(size);
		jpanel.setLayout(null);
		
		JScrollPane sp = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, (int) (Main.SCREEN_HEIGHT*0.25), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(sp);
		
		
	}
	
	
	/*
	 * public static void main(String[] args) { new Reservation_start_page(); }
	 */
	class ReservationEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn_movie) {
				jlmovieContent.setVisible(true);
				jlhallContent.setVisible(false);
				
			}else if(e.getSource() == btn_hall) {
				jlmovieContent.setVisible(false);
				jlhallContent.setVisible(true);
			}
		}	
	}
}
