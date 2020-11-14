package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import User.DB_userInfo;
import User.User;

public class LoginPage extends JFrame{
	//위치 
	private final static int C_X = Main.SCREEN_WIDTH/2+200;
	private final static int IDLable_Y = 200;
	private final static int IDTextF_Y = 300;
	private final static int PWLable_Y = 400;
	private final static int PWTextF_Y = 500;
	private final static int LoginBtn_Y = 700;
	
	
	private  User user = new User();
	
	//component
	private JPanel jpanel = new JPanel();
	private JLabel jlId = new JLabel("ID");
	private JTextField jtId = new JTextField();
	private JLabel jlPw = new JLabel("PassWord");
	private JPasswordField jtPw = new JPasswordField();
	private JButton jbtnLogin = new JButton();
	private JButton jbtnSingUp = new JButton();
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png");
	private JLabel jlLogo = new JLabel();
	private JLabel designImg = new JLabel();
	
	
	
	private DB_userInfo connection = new DB_userInfo();	//DB연결 클래스
	private String userID,userPassword;
	
	//font
	private Font font1 = new Font("나눔바른고딕", Font.BOLD, 30);
	private Font font2 = new Font("나눔바른고딕", Font.PLAIN, 20);
	
	public LoginPage() {
		super("Login");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);	
		
		//패널
		jpanel.setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		jpanel.setBackground(Color.WHITE);
		jpanel.setLayout(null);
		add(jpanel);
		
		// 이미지 label
		jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(300, 125,200,100);
		jpanel.add(jlLogo);
		
		designImg.setBounds(100, 300, 600, 600);
		designImg.setOpaque(true);
		designImg.setBackground(Color.ORANGE);
		jpanel.add(designImg);
		
		
		//아이디 label
		jlId.setBounds(C_X,IDLable_Y,200,100);
		jlId.setFont(font1);
		jpanel.add(jlId);
		
		//아이디 textField
		jtId.setBounds(C_X, IDTextF_Y, 250, 50);
		jtId.setFont(font2);
		jpanel.add(jtId);
		
		//패스워드 label
		jlPw.setBounds(C_X,PWLable_Y,200,100);
		jlPw.setFont(font1);
		jpanel.add(jlPw);
		
		//패스워드 textField
		jtPw.setBounds(C_X,PWTextF_Y,250,50);
		jtPw.setFont(font2);
		jpanel.add(jtPw);
		
		//로그인 버튼
		jbtnLogin.setText("로그인");
		jbtnLogin.setFont(font1);
		jbtnLogin.setBounds(C_X,LoginBtn_Y,300,80);
		jpanel.add(jbtnLogin);
		
		//회원가입 버튼
		jbtnSingUp.setText("회원가입");
		jbtnSingUp.setBounds(C_X,LoginBtn_Y+100,300,80);
		jbtnSingUp.setFont(font1);
		jpanel.add(jbtnSingUp);
		
		jbtnLogin.addActionListener(new EventHandler());
		jbtnSingUp.addActionListener(new EventHandler());
			
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbtnLogin) {//로그인 버튼
				
				userID = jtId.getText();
				userPassword = jtPw.getText();
				//System.out.println(connection.getUserInfo(userID).getUserID());
				boolean success = connection.isUser(userID, userPassword);
				if(success) {//성공
					user = connection.getUserInfo(userID);
					new DOKPage(user);
					
					setVisible(false);
				}else {
					JOptionPane message =new JOptionPane();//메시지 박스 객체
					message.showMessageDialog(null,"아이디 또는 패스워드가 맞지 않습니다. 확인 후  입력해주세요" );
				}
				
				
			}else if(e.getSource() == jbtnSingUp) {//회원가입 버튼
				new SignUpPage();
				//dispose();
				//setVisible(false);
			}
			
		}
	}
}


