package page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB_User.User;
import page.DOKPage.EventHandler;

public class MyPage extends JFrame implements ActionListener{
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 100;

	
	private User user = new User();
	
	//component
	private CategoryPanel c1 = new CategoryPanel();
	
	private JPanel jp = new JPanel();
	JLabel jlProfile = new JLabel("사진");
	JLabel jlName = new JLabel();
	
	JLabel jlId = new JLabel("아이디");
	JLabel jlBirthday = new JLabel("생년월일");
	JLabel jlP_number = new JLabel("전화번호");
	JLabel jlTaste = new JLabel("영화 취향");
	JButton jbtnCorrection = new JButton("개인정보수정");
	
	JLabel jlRecord_movie = new JLabel("최근 예매한 영화");
	JLabel jlRecord_movie_info = new JLabel();
	
	public MyPage() {}
	public MyPage(User user) {
		super("마이 페이지");
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
		
		this.user = user;
		
		//프로필 사진
		jlProfile.setBounds(PaddingLeft, PaddingTop, 200, 200);
		jlProfile.setOpaque(true);
		jlProfile.setBackground(Color.RED);
		jp.add(jlProfile);
		
		//사용자 이름
		jlName.setBounds(PaddingLeft, PaddingTop + 215, 200, 50);
		jlName.setOpaque(true);
		jlName.setBackground(Color.GREEN);
		jlName.setText("이름: "+user.getUserName());
		jp.add(jlName);
		
		//아이디
		jlId.setBounds(PaddingLeft + 350, PaddingTop, 250, 40);
		jlId.setOpaque(true);
		jlId.setBackground(Color.BLUE);
		jlId.setText("아이디: "+user.getUserID());
		jp.add(jlId);
		
		//생년월일 : yyyy-mm-dd
		jlBirthday.setBounds(PaddingLeft + 350, PaddingTop + 50, 250, 40);
		jlBirthday.setOpaque(true);
		jlBirthday.setBackground(Color.BLUE);
		jlBirthday.setText("생년월일: "+user.getUseryymmdd());
		jp.add(jlBirthday);
		
		//전화번호
		jlP_number.setBounds(PaddingLeft + 350, PaddingTop + 100, 250, 40);
		jlP_number.setOpaque(true);
		jlP_number.setBackground(Color.BLUE);
		jlP_number.setText("전화번호: "+user.getUserPhone());
		jp.add(jlP_number);
		
		//영화 취향
		jlTaste.setBounds(PaddingLeft + 350, PaddingTop + 150, 250, 40);
		jlTaste.setOpaque(true);
		jlTaste.setBackground(Color.BLUE);
		jlTaste.setText("영화취향-1: "+user.getUserTaste1());
		jp.add(jlTaste);
		
		//개인정보수정
		jbtnCorrection.setBounds(PaddingLeft + 350, PaddingTop + 225, 250, 40);
		jbtnCorrection.setOpaque(true);
		jbtnCorrection.setBackground(Color.GRAY);
		jbtnCorrection.addActionListener(this);
		jp.add(jbtnCorrection);
		
		//최근 예매한 영화
		jlRecord_movie.setBounds(PaddingLeft + 750, PaddingTop, 450, 40);
		jlRecord_movie.setOpaque(true);
		jlRecord_movie.setBackground(Color.YELLOW);
		jp.add(jlRecord_movie);
		
		//최근 예매한 영화
		jlRecord_movie_info.setBounds(PaddingLeft + 750, PaddingTop + 40, 450, 230);
		jlRecord_movie_info.setOpaque(true);
		jlRecord_movie_info.setBackground(Color.CYAN);
		jp.add(jlRecord_movie_info);

		
		
		//Panel
		jp.setBackground(Color.WHITE);
		jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		add(jp);
	}
	
	//내부 객체
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbtnCorrection) {
			new P_InformationPage();
		}
		
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
