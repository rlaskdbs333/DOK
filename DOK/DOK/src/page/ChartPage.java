package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DB_User.User;
import page.DOKPage.EventHandler;

public class ChartPage extends JFrame{
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 50;
	private final static int PanelHeight = Main.SCREEN_HEIGHT * 2 ;
	
	
	private User user;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();
	
	
	private JPanel jp = new JPanel();
	
	// size
	private Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
	
	JLabel jlGenre = new JLabel("장르");
	String[] genre = {"공포", "드라마", "로맨스", "스릴러", "애니메이션", "액션", "SF"};
	JComboBox jcbGenre = new JComboBox(genre);
	
	JButton jbtnRating = new JButton("평점");
	JButton jbtnTaste = new JButton("취향");
	
	JLabel[][] jlPoster = new JLabel[4][2];
	JButton[][] jbtnTicket = new JButton[4][2];
	
	public ChartPage() {
		
	}
	
	public ChartPage(User user) {
		super("영화 차트");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 센테에서 나오도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);
		
		
		this.user = user;
		//카테고리 Panel
		c1 = new CategoryPanel(user);	//카테고리 panel
		for(int i=0; i<c1.jbtnCategory.length; i++) {
			c1.jbtnCategory[i].addActionListener(new EventHandler());
		}
		add(c1);
	
		
		
		//장르
		jlGenre.setBounds(PaddingLeft, PaddingTop, 75, 40);
		jlGenre.setOpaque(true);
		jlGenre.setBackground(Color.RED);
		jp.add(jlGenre);
		
		jcbGenre.setBounds(PaddingLeft + 75, PaddingTop, 200, 40);
		jp.add(jcbGenre);
		
		//평점
		jbtnRating.setBounds(PaddingLeft + 375, PaddingTop, 100, 40);
		jbtnRating.setOpaque(true);
		jbtnRating.setBackground(Color.YELLOW);
		jp.add(jbtnRating);
		
		//취향
		jbtnTaste.setBounds(PaddingLeft + 525, PaddingTop, 100, 40);
		jbtnTaste.setOpaque(true);
		jbtnTaste.setBackground(Color.BLUE);
		jp.add(jbtnTaste);
		
		for(int i = 0; i < jlPoster.length; i++) {
			for(int j = 0; j < jlPoster[i].length; j++) {
				jlPoster[i][j] = new JLabel();
				
				jlPoster[i][j].setBounds(PaddingLeft + (i * 325), PaddingTop + 100 + (j * 400), 200, 300);
				jlPoster[i][j].setOpaque(true);
				jlPoster[i][j].setBackground(Color.GRAY);
				jp.add(jlPoster[i][j]);
			}
		}
		
		for(int i = 0; i < jbtnTicket.length; i++) {
			for(int j = 0; j < jbtnTicket[i].length; j++) {
				jbtnTicket[i][j] = new JButton("예매");
				
				jbtnTicket[i][j].setBounds(PaddingLeft + (i * 325), PaddingTop + 415 /*(j * 350)*/, 200, 40);
				jbtnTicket[i][j].setOpaque(true);
				jbtnTicket[i][j].setBackground(Color.GREEN);
				jp.add(jbtnTicket[i][j]);
			}
		}
		
		
		
		//Panel
		size.setSize(Main.SCREEN_WIDTH, PanelHeight);
		jp.setBackground(Color.WHITE);
		jp.setPreferredSize(size);
		//jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		
		JScrollPane sp = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, (int) (Main.SCREEN_HEIGHT*0.25), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(sp);
		
		
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==c1.jbtnCategory[0]) {//홈
				new DOKPage(user);
			}else if(e.getSource()==c1.jbtnCategory[1]) {//영화
				new ChartPage(user);
			}else if(e.getSource()==c1.jbtnCategory[2]) {//예매
				new Reservation_start_page(user);
			}else if(e.getSource()==c1.jbtnCategory[3]) {//마이 페이지
				new MyPage(user);
			}
			dispose();
			
		}
		
	}
}
