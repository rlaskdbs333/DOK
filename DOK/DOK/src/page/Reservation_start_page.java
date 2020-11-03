package page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import DB_User.User;
import page.DOKPage.EventHandler;

public class Reservation_start_page extends JFrame{
	
	
	private User user = new User();
	//component
	private CategoryPanel c1 = new CategoryPanel();
	
	private JPanel jp = new JPanel();
	
	
	public Reservation_start_page() {
		
	}
	public Reservation_start_page(User user) {
		
		super("예매");
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
