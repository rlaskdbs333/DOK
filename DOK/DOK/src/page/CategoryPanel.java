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

public class CategoryPanel extends JPanel{

	//위치
	private final static int loginBtn_X = (int) (Main.SCREEN_WIDTH*0.7);
	private final static int SigUpBtn_X = loginBtn_X+160;
	private final static int LSbtn_Y = 70;

	//component
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png");	//로고 이미지
	private JLabel jlLogo = new JLabel();
	private JButtonT jbtnLogin = new JButtonT();
	private JButtonT jbtnSignUp = new JButtonT();
	JButtonT[] jbtnCategory = new JButtonT[4]; 
	private String[] category = {"홈","영화","예매","마이 페이지"};
	
	
	private User user = new User();
	
	//font
	private Font font1 = new Font(null,Font.PLAIN,20);
	private Font font2 = new Font(null,Font.PLAIN,40);
	
	public CategoryPanel() {}
	public CategoryPanel(User user) {
		setBackground(Color.YELLOW);
		setBounds(0, 0, Main.SCREEN_WIDTH, (int) (Main.SCREEN_HEIGHT*0.25));
		setLayout(null);
		
		this.user = user;
		
		//Logo 
		jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(Main.SCREEN_WIDTH/2 -100 ,30,200,100);
		add(jlLogo);
		

		/*
		 * //로그인 jbtnLogin.setText("로그인"); jbtnLogin.setFont(font1);
		 * jbtnLogin.setBounds(loginBtn_X, LSbtn_Y, 150, 50); add(jbtnLogin);
		 * 
		 * //회원가입 jbtnSignUp.setText("회원가입"); jbtnSignUp.setFont(font1);
		 * jbtnSignUp.setBounds(SigUpBtn_X, LSbtn_Y, 150, 50); add(jbtnSignUp);
		 */
		
		//카테고리 
		for(int i=0; i<4; i++) {
			jbtnCategory[i] = new JButtonT();
			jbtnCategory[i].setText(category[i]);
			jbtnCategory[i].setFont(font2);
			jbtnCategory[i].setBounds(i*Main.SCREEN_WIDTH/4, 180, Main.SCREEN_WIDTH/4, 80);
			add(jbtnCategory[i]);
			//jbtnCategory[i].addActionListener(new EventHandler());
			
		}
		
	}
}



	//button 
	class JButtonT extends JButton{
		public JButtonT() {
			//선 X
			setFocusPainted(false);
			setBorderPainted(false);
			setBackground(Color.PINK);
			//jbtLogin.setContentAreaFilled(false);
		}
}
