package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB_User.DBuserInfo;
import DB_User.User;

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
	private JPanel jp = new JPanel();
	private JLabel jlId = new JLabel("ID");
	private JTextField jtId = new JTextField();
	private JLabel jlPw = new JLabel("PassWord");
	private JPasswordField jtPw = new JPasswordField();
	private JButtonT jbtnLogin = new JButtonT();
	private JButtonT jbtnSingUp = new JButtonT();
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png");
	private JLabel jlLogo = new JLabel();
	
	
	
	private DBuserInfo connection = new DBuserInfo();	//DB연결 클래스
	private String userID,userPassword;
	
	//font
	private Font font1 = new Font(null,Font.BOLD,30);
	private Font font2 = new Font(null,Font.PLAIN,20);
	
	public LoginPage() {
		super("Login");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 센테에서 나오도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);	
		
		//패널
		jp.setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);
		add(jp);
		
		//로고 이미지 label
		jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(0,0,200,100);
		jp.add(jlLogo);
		
		
		//아이디 label
		jlId.setBounds(C_X,IDLable_Y,200,100);
		jlId.setFont(font1);
		jp.add(jlId);
		
		//아이디 textField
		jtId.setBounds(C_X, IDTextF_Y, 250, 50);
		jtId.setFont(font2);
		jp.add(jtId);
		
		//패스워드 label
		jlPw.setBounds(C_X,PWLable_Y,200,100);
		jlPw.setFont(font1);
		jp.add(jlPw);
		
		//패스워드 textField
		jtPw.setBounds(C_X,PWTextF_Y,250,50);
		jtPw.setFont(font2);
		jp.add(jtPw);
		
		//로그인 버튼
		jbtnLogin.setText("로그인");
		jbtnLogin.setFont(font2);
		jbtnLogin.setBounds(C_X,LoginBtn_Y,300,80);
		jp.add(jbtnLogin);
		
		//회원가입 버튼
		jbtnSingUp.setText("회원가입");
		jbtnSingUp.setBounds(C_X,LoginBtn_Y+100,300,80);
		jbtnSingUp.setFont(font2);
		jp.add(jbtnSingUp);
		
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
				setVisible(false);
			}
			
		}
	}
}


