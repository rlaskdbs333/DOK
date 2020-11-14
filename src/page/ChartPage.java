package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Movie.DB_MovieInfo;
import Movie.Movie;
import User.User;


public class ChartPage extends CategoryFrame implements ActionListener, MouseListener{

	//pos
	private final static int Padding_Left = 130;
	private final static int Padding_Top = 50;
	private final static int right_Padding_Left = 25;
	private final static int right_Padding_Top = 30;
	private final static double Panel_Height = Main.SCREEN_HEIGHT * 1.4 ;
	
	// size
	private Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
	
	//객체
	private DB_MovieInfo moive_connect = new DB_MovieInfo();
	private Movie[] movies;

	
	//component
	private JPanel jpanel = new JPanel();
	private JPanel selectPanel = new JPanel();
	private JLabel jlgenre = new JLabel("장르");
	private String[] string_genre = {"전체", "공포", "드라마", "로맨스", "스릴러", "애니메이션", "액션", "SF"};
	//private JComboBox comboBox = new JComboBox(string_genre);
	private JButton btn_rating = new JButton("평점");
	private JButton btn_audience = new JButton("관객 수");
	private JButton btn_openday = new JButton("개봉 날짜");
	private JButton btn_ganada = new JButton("가나다 순");
	private JLabel[][] jlposter = new JLabel[2][4];
	private JLabel[][] jlmovie_info = new JLabel[2][4];
	private JLabel[] jlrank = new JLabel[8];
	private JLabel[] jlopen_day = new JLabel[8];
	private JLabel[] jlRaing = new JLabel[8];
	private JLabel[] jlrank_name = new JLabel[8];
	private ImageIcon imgPoster = new ImageIcon();
	
	private ButtonGroup g = new ButtonGroup();
	private JRadioButton[] radioGenre = new JRadioButton[8];
	
	//Design
	Font m_name_font = new Font("나눔바른고딕", Font.PLAIN, 25);
	Font m_rank_font = new Font("나눔바른고딕", Font.BOLD, 20);
	Font option_font = new Font("나눔바른고딕", Font.PLAIN, 15);
	Font fontMain = new Font("휴먼둥근헤드라인", Font.PLAIN, 25);
	Font fontContent = new Font("휴먼둥근헤드라인", Font.PLAIN, 17);
	
	public ChartPage() {
		
	}
	
	public ChartPage(User user) {
		super("영화 차트");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);
		
		//영화 DB연결
		this.movies = moive_connect.getMovieInfoAll("rating");
		this.user = user;
		
		
		//장르
		jlgenre.setBounds(right_Padding_Left, right_Padding_Top, 75, 40);
		jlgenre.setFont(fontMain); jlgenre.setHorizontalAlignment(JLabel.CENTER);
		selectPanel.add(jlgenre);
		
		for(int i = 0; i < string_genre.length; i++) {
			radioGenre[i] = new JRadioButton(string_genre[i]);
			radioGenre[i].setBounds(right_Padding_Left + 25, right_Padding_Top + 50 + (i * 35), 100, 30);
			radioGenre[i].setOpaque(true);
			radioGenre[i].setBackground(Color.WHITE);
			radioGenre[i].setFont(option_font);
			radioGenre[i].addActionListener(this);
			g.add(radioGenre[i]);
			selectPanel.add(radioGenre[i]);
		}
		radioGenre[0].setSelected(true);
		
		//평점
		btn_rating.setBounds(right_Padding_Left, right_Padding_Top + 375, 150, 40);
		btn_rating.setBackground(Color.WHITE);
		btn_rating.setFont(fontMain);
		btn_rating.setHorizontalAlignment(JButton.LEFT);
		btn_rating.setFocusPainted(false);
		btn_rating.setBorderPainted(false);
		btn_rating.addActionListener(this);
		selectPanel.add(btn_rating);
		
		//관객 수
		btn_audience.setBounds(right_Padding_Left, right_Padding_Top + 440, 150, 40);
		btn_audience.setBackground(Color.WHITE);
		btn_audience.setFont(fontMain);
		btn_audience.setHorizontalAlignment(JButton.LEFT);
		btn_audience.setFocusPainted(false);
		btn_audience.setBorderPainted(false);
		btn_audience.addActionListener(this);
		selectPanel.add(btn_audience);
		
		//개봉날짜
		btn_openday.setBounds(right_Padding_Left, right_Padding_Top + 505, 150, 40);
		btn_openday.setBackground(Color.WHITE);
		btn_openday.setFont(fontMain);
		btn_openday.setHorizontalAlignment(JButton.LEFT);
		btn_openday.setFocusPainted(false);
		btn_openday.setBorderPainted(false);
		btn_openday.addActionListener(this);
		selectPanel.add(btn_openday);
	
		//가나다
		btn_ganada.setBounds(right_Padding_Left, right_Padding_Top + 570, 150, 40);
		btn_ganada.setBackground(Color.WHITE);
		btn_ganada.setFont(fontMain);
		btn_ganada.setHorizontalAlignment(JButton.LEFT);
		btn_ganada.setFocusPainted(false);
		btn_ganada.setBorderPainted(false);
		btn_ganada.addActionListener(this);
		selectPanel.add(btn_ganada);
		
		int n=0;
		
		//영화 포트터
		for(int i = 0; i < jlposter.length; i++) {
			for(int j = 0; j < jlposter[i].length; j++) {
				String src = "src/imges/"+movies[n].getM_name()+".jpg";
				//String src = "src/imges/겨울 왕국.jpg";
				imgPoster = new ImageIcon(src);
				jlposter[i][j] = new JLabel(imgPoster);
				jlposter[i][j].setBounds(Padding_Left - 10 + (j * 260), Padding_Top + (i * 500), 230, 330);
				jlposter[i][j].setOpaque(true);
				jlposter[i][j].setBackground(Color.GRAY);
				jlposter[i][j].addMouseListener(this);
				jpanel.add(jlposter[i][j]);
				n++;
			}
		}
		
		//영화 정보 출력(마우스 올렸을때)
		  for(int i = 0; i < jlmovie_info.length; i++) {
			  for(int j = 0; j <jlmovie_info[i].length; j++) {
				  jlmovie_info[i][j] = new JLabel();
				  jlmovie_info[i][j].setBounds(Padding_Left - 10 + (j * 260), Padding_Top + (i * 500), 230, 330); 
				  jlmovie_info[i][j].setOpaque(true);
				  jlmovie_info[i][j].setBackground(Color.RED);
				  jlmovie_info[i][j].addMouseListener(this);
				  jlmovie_info[i][j].setVisible(false);
				  jpanel.add(jlmovie_info[i][j]); 
			  }
		 }
		 
		for(int i = 0; i < jlrank_name.length; i++) {
			jlrank_name[i] = new JLabel();
			jlRaing[i] = new JLabel();
			jlopen_day[i] = new JLabel();
			if(i < 4) {
				jlrank_name[i].setBounds(5+Padding_Left - 10 + (i * 260), Padding_Top+330, 225, 40);
				jlRaing[i].setBounds(5+Padding_Left - 10 + (i * 260), Padding_Top+370, 60, 40);
				jlopen_day[i].setBounds(65+Padding_Left - 10 + (i * 260), Padding_Top+370, 160, 40);
			}else {
				jlrank_name[i].setBounds(10+Padding_Left -10 +((i-(jlrank.length/2)) * 260), Padding_Top+500+330 ,225, 40);
				jlRaing[i].setBounds(10+Padding_Left -10 +((i-(jlrank.length/2)) * 260), Padding_Top+500+370, 60, 40);
				jlopen_day[i].setBounds(70+Padding_Left -10 +((i-(jlrank.length/2)) * 260), Padding_Top+500+370, 160, 40);
			}
			//이름
			jlrank_name[i].setText((i+1)+". "+movies[i].getM_name());
			jlrank_name[i].setFont(m_name_font);
			jpanel.add(jlrank_name[i]);
			//평점
			jlRaing[i].setText("평점"+movies[i].getRating());
			jlRaing[i].setFont(option_font);
			jpanel.add(jlRaing[i]);
			//개봉일
			jlopen_day[i].setText("  개봉일"+movies[i].getOpen_day());
			jlopen_day[i].setFont(option_font);
			jpanel.add(jlopen_day[i]);
			
		}
		 
		
		//Panel_movie
		size.setSize(Main.SCREEN_WIDTH, Panel_Height);
		jpanel.setBackground(Color.WHITE);
		jpanel.setPreferredSize(size);
		jpanel.setLayout(null);
		
		//panel_select
		selectPanel.setBounds((int)(Main.SCREEN_WIDTH*0.8), (int) (Main.SCREEN_HEIGHT*0.25), (int)(Main.SCREEN_WIDTH*0.2), Main.SCREEN_HEIGHT);
		selectPanel.setBackground(Color.WHITE);
		selectPanel.setLayout(null);
		add(selectPanel);
		
		JScrollPane sp = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, (int) (Main.SCREEN_HEIGHT*0.25), (int)(Main.SCREEN_WIDTH*0.8), Main.SCREEN_HEIGHT);
		add(sp);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String calumn = null;
		
		
		if(e.getSource() == btn_rating) {
			calumn = "rating";
		}else if(e.getSource()==btn_audience) {
			calumn = "audience";
		}else if(e.getSource()==btn_openday) {
			calumn = "open_day";
		}else if(e.getSource()==btn_ganada) {
			calumn ="m_name";
		}else {
			calumn = "rating";
		}
		
		if(radioGenre[0].isSelected() == true) {//all
			movies = moive_connect.getMovieInfoAll(calumn);
		}else {
			for(int i=1; i<string_genre.length; i++) {//나머지
				if(radioGenre[i].isSelected() == true) {
					movies = moive_connect.getMovieInfo(string_genre[i],calumn);
				}	
			}
		}
		
		
		
		//poster 이미지 set
		int n=0;
		for(int i=0; i<jlposter.length; i++) {
			for(int j=0; j<jlposter[i].length; j++) {
				String src = "src/imges/"+movies[n].getM_name()+".jpg";
				//String src = "src/imges/겨울 왕국.jpg";
				imgPoster = new ImageIcon(src);
				jlposter[i][j].setIcon(imgPoster);
				n++;
			}
		}
		//영호 이름,영화 정보  set
				for(int i=0; i<jlrank_name.length; i++) {
					jlrank_name[i].setText((i+1)+". "+movies[i].getM_name());
					jlRaing[i].setText("평점"+movies[i].getRating());
					jlRaing[i].setFont(option_font);
					//개봉일
					jlopen_day[i].setText("  개봉일"+movies[i].getOpen_day());
					jlopen_day[i].setFont(option_font);
			
				}
		 
	}//actionlistener

	@Override//때었다가 떨어지면?
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked"+e.getX()+","+e.getY());
	}

	@Override//마우스가 들어가면
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override//마우스가 나가지면
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override//마우스가 눌리면
	public void mousePressed(MouseEvent e) { 
		// TODO Auto-generated method stub
		JLabel movielabel = (JLabel)e.getSource();
		for(int i = 0; i < jlposter.length; i++) {
			for(int j = 0; j < jlposter[i].length; j++) {
				if(e.getSource() == jlposter[i][j]) {
					jlposter[i][j].setVisible(false);
					jlmovie_info[i][j].setVisible(true);
				}else {
					jlposter[i][j].setVisible(true);
					jlmovie_info[i][j].setVisible(false);
				}
			}
		}
	}

	@Override//눌리는동안?
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
}