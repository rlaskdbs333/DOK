package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB_User.User;

public class DOKPage extends JFrame {
	
	
	//pos
	private final static int movieN = 4;
	
	private User user;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();
	
	
	private JPanel jp = new JPanel();
	private JLabel jlBoxoffice = new JLabel();	//박스오피스
	private JButtonT jbtnPlusMovie = new JButtonT();	//더 많은 영화보기
	private JButtonT[] jbtnMovies = new JButtonT[movieN];
	private ImageIcon[] imgLogo = new ImageIcon[movieN];	//로고 이미지
	
	public DOKPage() {
		
	}
	
	public DOKPage(User user) {
		super("DOK");
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
		
		//Panel
		jp.setBackground(Color.WHITE);
		jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		add(jp);
		
		//박스 오피스 Label
		jlBoxoffice.setText("박스오피스");
		jlBoxoffice.setFont(new Font(null,Font.BOLD,20));
		jlBoxoffice.setBackground(Color.GREEN);
		jlBoxoffice.setOpaque(true);
		//jlBoxoffice.setOpaque(false);
		jlBoxoffice.setBounds(Main.SCREEN_WIDTH/2-(110/2),70,110,50);
		jp.add(jlBoxoffice);
		
		//더 많은 영화 보기 Lable
		jbtnPlusMovie.setText("더 많은 영화보기");
		jbtnPlusMovie.setFont(new Font(null,Font.PLAIN,20));
		jbtnPlusMovie.setBackground(Color.GREEN);
		jbtnPlusMovie.setOpaque(true);
		//jbtnPlusMovie.setOpaque(false);
		jbtnPlusMovie.setBounds(Main.SCREEN_WIDTH-300,70,200,50);
		jp.add(jbtnPlusMovie);
		
		
		
		//영화 차트 버튼
		for(int i=0; i<movieN; i++) {
			int x = 300*(i)+ 180;
			jbtnMovies[i] = new JButtonT();
			jbtnMovies[i].setText("test");
			jbtnMovies[i].setBounds(x, 150, 250, 400);
			jp.add(jbtnMovies[i]);
			
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
