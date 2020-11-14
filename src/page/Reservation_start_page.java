package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Area.Area;
import Area.DB_Area;
import Movie.DB_MovieArea;
import Movie.DB_MovieInfo;
import Movie.Movie;
import Movie.MovieArea;
import User.User;
import theater.DB_Theater;
import theater.Theater;


public class Reservation_start_page extends CategoryFrame implements ActionListener{
	private final static int PaddingLeft = 40;
	private final static int PaddingTop = 100;
	private final static double Panel_Height = 700;
	
	//��¥
	private Calendar cal = Calendar.getInstance();
	private int date = cal.get(Calendar.DATE);
	private int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
	private String[] weeks_name = {"","��","��","ȭ","��","��","��","��"};
	
	
	// size
	private Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����
	
	//component
	private JPanel jpanel = new JPanel();
	private JPanel m_panel = new JPanel();
	private JPanel a_panel = new JPanel();
	private JPanel t_panel = new JPanel();
	
	//��ȭ
	private JLabel jlmovie = new JLabel("��ȭ");
	private JPanel movielist_panel = new JPanel();
	private JLabel[] jlposter = new JLabel[3];

	//����
	private JLabel jlarea = new JLabel("����");
	private JButton btn_seoul = new JButton();
	private JButton btn_gyeonggi = new JButton("���");
	private JButton[] btn_seoullist = new JButton[4];
	private JButton[] btn_gyeonggilist = new JButton[4];
	private JLabel[] jlselectArea = new JLabel[2];
	
	//�ð�
	private JButton[] btn_timetable = new JButton[4];
	private JLabel jlcontent = new JLabel();
	
	//DB
	private DB_MovieInfo movie_connect = new DB_MovieInfo();
	private DB_MovieArea moviearea_connect = new DB_MovieArea();
	private DB_Theater theater_connect = new DB_Theater();
	private DB_Area area_connect = new DB_Area();
	
	//
	private Movie[] movie;
	private MovieArea[] movieArea;
	private Theater[] theater;
	private Area[] area;
	private int movie_key;
	private String area_key;
	private String country_key;
	
	
	//count
	private int movie_count = 0; 
	private int country_count = 0; 
	
	//Design
	Font font1 = new Font("�޸յձ�������", Font.PLAIN, 25);
	Font font2 = new Font("�޸յձ�������", Font.PLAIN, 20);
	
	public Reservation_start_page() {}

	public Reservation_start_page(User user) {
		super("����");
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);
		setBackground(Color.WHITE);
		
		area = area_connect.getArea();
		theater = theater_connect.getTheater("����");
		this.user = user;
		area_key = "����";
		
		//��ȭ �г�
		m_panel.setBounds(PaddingLeft, PaddingTop, 400, 600);
		m_panel.setOpaque(true);
		m_panel.setBackground(Color.LIGHT_GRAY);
		m_panel.setLayout(null);
		jpanel.add(m_panel);
		
		jlmovie.setBounds(5, 5, 60, 40);
		jlmovie.setFont(font1);
		jlmovie.setHorizontalAlignment(JLabel.CENTER);
		m_panel.add(jlmovie);
		
		
		
		//��ȭ �г�
		movielist_panel.setOpaque(true);
		movielist_panel.setBackground(Color.DARK_GRAY);
		movielist_panel.setLayout(null);
		movielist_panel.setPreferredSize(size);
		
		//��ȭ �߰�
		movie = movie_connect.getMovieInfoAll("open_day");
		int movieNum = movie_connect.countMovie();
		size.setSize(400, movieNum*50);
		JMovieButton[] btn_movie= new JMovieButton[movieNum];
		for(int i=0; i<movieNum; i++){
			btn_movie[i] = new JMovieButton();
			btn_movie[i].setHorizontalAlignment(JButton.LEFT);
			btn_movie[i].setText(movie[i].getM_name());
			btn_movie[i].setBounds(0, 50*i, 400, 50);
			btn_movie[i].addActionListener(this);
			btn_movie[i].setMovieKey(movie[i].get_key());
			movielist_panel.add(btn_movie[i]);
		}
		
		
		JScrollPane sp = new JScrollPane(movielist_panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, 75, 400, 350);
		m_panel.add(sp);
		
		for(int i = 0; i < jlposter.length; i++) {
			jlposter[i] = new JLabel();
			jlposter[i].setBounds(20 + (i * 130), 440, 100, 140);
			jlposter[i].setOpaque(true);
			jlposter[i].setBackground(Color.ORANGE);
			m_panel.add(jlposter[i]);
		}
		
		
		//����d
		a_panel.setBounds(PaddingLeft + 425, PaddingTop, 450, 600);
		a_panel.setOpaque(true);
		a_panel.setBackground(Color.LIGHT_GRAY);
		a_panel.setLayout(null);
		jpanel.add(a_panel);
		
		jlarea.setBounds(5, 5, 60, 40);
		jlarea.setFont(font1);
		jlarea.setHorizontalAlignment(JLabel.CENTER);
		a_panel.add(jlarea);
		
		//����
		btn_seoul.setText(area[3].getArea());
		btn_seoul.setBounds(0, 75, 225, 40);
		btn_seoul.setOpaque(true);
		btn_seoul.setFont(font2);
		btn_seoul.setHorizontalAlignment(JButton.CENTER);
		btn_seoul.addActionListener(new Reservation_area_Event());
		a_panel.add(btn_seoul);
		//���
		btn_gyeonggi.setText(area[0].getArea());
		btn_gyeonggi.setBounds(225, 75, 225, 40);
		btn_gyeonggi.setFont(font2);
		btn_gyeonggi.setHorizontalAlignment(JButton.CENTER);
		btn_gyeonggi.addActionListener(new Reservation_area_Event());
		a_panel.add(btn_gyeonggi);
		
		//���� ����
		for(int i = 0; i < btn_seoullist.length; i++) {
			//btn_seoullist[i] = new JButton(theater[i].getCountry());
			btn_seoullist[i] = new JButton();
			btn_seoullist[i].setText(theater[i].getCountry());
			btn_seoullist[i].setBounds(10, 150 + (i * 60), 100, 40);
			btn_seoullist[i].setFocusPainted(false);
			btn_seoullist[i].setBorderPainted(false);
			btn_seoullist[i].setOpaque(false);
			btn_seoullist[i].setFont(font2);
			btn_seoullist[i].addActionListener(new Reservation_country_Event());
			a_panel.add(btn_seoullist[i]);
		}
		
		//��� ����
		theater = theater_connect.getTheater("���");
		for(int i = 0; i < btn_gyeonggilist.length; i++) {
			btn_gyeonggilist[i] = new JButton();
			btn_gyeonggilist[i].setText(theater[i].getCountry());
			btn_gyeonggilist[i].setVisible(false);
			btn_gyeonggilist[i].setBounds(10, 150 + (i * 60), 100, 40);
			btn_gyeonggilist[i].setFocusPainted(false);
			btn_gyeonggilist[i].setBorderPainted(false);
			btn_gyeonggilist[i].setOpaque(false);
			btn_gyeonggilist[i].setFont(font2);
			btn_gyeonggilist[i].addActionListener(new Reservation_country_Event());
			a_panel.add(btn_gyeonggilist[i]);
		}
		
		for(int i = 0; i < jlselectArea.length; i++) {
			jlselectArea[i] = new JLabel();
			jlselectArea[i].setBounds(50 + (i * 200), 440, 150, 150);
			jlselectArea[i].setOpaque(true);
			jlselectArea[i].setBackground(Color.ORANGE);
			a_panel.add(jlselectArea[i]);
		}
		
		//�ð�ǥ
		t_panel.setBounds(PaddingLeft + 900, PaddingTop, 500, 600);
		t_panel.setOpaque(true);
		t_panel.setBackground(Color.LIGHT_GRAY);
		t_panel.setLayout(null);
		jpanel.add(t_panel);
		
		for(int i = 0; i < btn_timetable.length; i++) {
			btn_timetable[i] = new JButton(date+"*"+weeks_name[dayofweek]);			
			btn_timetable[i].setBounds(0 + (i * (500 / 7)), 0, (500 / 7), (500 / 7));
			t_panel.add(btn_timetable[i]);
			date+=1;
			dayofweek+=1;
		}
		
		jlcontent.setBounds(20, 100, 460, 125);
		jlcontent.setOpaque(true);
		jlcontent.setBackground(Color.YELLOW);
		t_panel.add(jlcontent);
		
		//Panel
		jpanel.setBackground(Color.WHITE);
		jpanel.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jpanel.setLayout(null);
		add(jpanel);
		
		
	}
	
	class Reservation_area_Event implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn_seoul) {
				for(int i = 0; i < btn_seoullist.length; i++) {
					btn_seoullist[i].setVisible(true);
					btn_gyeonggilist[i].setVisible(false);
					area_key = "����";
				}
			}else if(e.getSource() == btn_gyeonggi){
				for(int i = 0; i < btn_gyeonggilist.length; i++) {
					btn_seoullist[i].setVisible(false);
					btn_gyeonggilist[i].setVisible(true);
					area_key = "���";
				}
			}
			
		}
	}
	
	class Reservation_country_Event implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(country_count<2) {
				JButton btn = (JButton) e.getSource();
				country_key =  btn.getText();
				
				System.out.println(movie_key+","+area_key+","+country_key);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//��ȭ ��ư
		if(movie_count<3) {
			JMovieButton m = (JMovieButton) e.getSource();
			movie_key = m.getMovieKey();//��ȭ �����̸Ӹ�_key��������
			System.out.println(movie_key);
			//movieArea = moviearea_connect.getMovieArea(movie_key);//Ű�� ���� ���� ��������
			//jlposter[count].setText(m.getText());
			//count++;
		}
		
		
	}
}

class JMovieButton extends JButton{
	private int movieKey;
	public JMovieButton() {
		// TODO Auto-generated constructor stub
	}
	public JMovieButton(String str) {
		setText(str);
	}
	public int getMovieKey() {
		return movieKey;
	}
	public void setMovieKey(int movieKey) {
		this.movieKey = movieKey;
	}
}