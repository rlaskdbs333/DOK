package page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPage extends JFrame implements ActionListener {
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 100;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();	//카테고리 panel
	private JPanel jp = new JPanel();
	
	JLabel jlProfile = new JLabel("사진");
	JLabel jlName = new JLabel("이름");
	
	JLabel jlId = new JLabel("아이디");
	JLabel jlBirthday = new JLabel("생년월일");
	JLabel jlP_number = new JLabel("전화번호");
	JLabel jlTaste = new JLabel("영화 취향");
	JButton jbtnCorrection = new JButton("개인정보수정");
	
	JLabel jlRecord_movie = new JLabel("최근 예매한 영화");
	JLabel jlRecord_movie_info = new JLabel();
	
	public MyPage() {
		super("마이 페이지");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 센테에서 나오도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);
		
		//프로필 사진
		jlProfile.setBounds(PaddingLeft, PaddingTop, 200, 200);
		jlProfile.setOpaque(true);
		jlProfile.setBackground(Color.RED);
		jp.add(jlProfile);
		
		//사용자 이름
		jlName.setBounds(PaddingLeft, PaddingTop + 215, 200, 50);
		jlName.setOpaque(true);
		jlName.setBackground(Color.GREEN);
		jp.add(jlName);
		
		//아이디
		jlId.setBounds(PaddingLeft + 350, PaddingTop, 250, 40);
		jlId.setOpaque(true);
		jlId.setBackground(Color.BLUE);
		jp.add(jlId);
		
		//생년월일 : yyyy-mm-dd
		jlBirthday.setBounds(PaddingLeft + 350, PaddingTop + 50, 250, 40);
		jlBirthday.setOpaque(true);
		jlBirthday.setBackground(Color.BLUE);
		jp.add(jlBirthday);
		
		//전화번호
		jlP_number.setBounds(PaddingLeft + 350, PaddingTop + 100, 250, 40);
		jlP_number.setOpaque(true);
		jlP_number.setBackground(Color.BLUE);
		jp.add(jlP_number);
		
		//영화 취향
		jlTaste.setBounds(PaddingLeft + 350, PaddingTop + 150, 250, 40);
		jlTaste.setOpaque(true);
		jlTaste.setBackground(Color.BLUE);
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

		//카테고리 Panel
		add(c1);
		
		//Panel
		jp.setBackground(Color.WHITE);
		jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		add(jp);
	}

	//액션 리스터 내부 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbtnCorrection) {
			
		}
	}
}
