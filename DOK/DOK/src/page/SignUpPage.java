package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import DB_User.DBuserInfo;

public class SignUpPage extends JFrame {

	// DB
	DBuserInfo coneection = new DBuserInfo();

	// 위치
	private final static int C_X = Main.SCREEN_WIDTH / 2 - 250;
	private final static int ID_Y = 150;
	private final static int PW_Y = ID_Y+150;
	private final static int PWCheck_Y = PW_Y+150;
	private final static int Name_Y = PWCheck_Y+150;
	private final static int Birth_Y = Name_Y+150;
	private final static int Gender_Y = Birth_Y+150;
	private final static int Phone_Y = Gender_Y+150;
	private final static int Taste_Y = Phone_Y+150;
	// private final static int TasteCB_Y = 1300;
	private final static int SignUP_Y = 1850;

	private final static int TopMargin_Y = 80;
	private final static int Taste_N = 6;

	private final static int PanelHeight = Main.SCREEN_HEIGHT * 2 ;

	// component
	private JScrollPane jscroll;
	private JPanel jp = new JPanel();
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png"); // 로고 이미지
	private JLabel jlLogo = new JLabel();

	private JLabel jlID = new JLabel("아이디*");
	private JLabel jlPw = new JLabel("비밀번호*");
	private JLabel jlPwCheck = new JLabel("비밀번호 재확인*");
	private JLabel jlName = new JLabel("이름*");
	private JLabel jlBirth = new JLabel("생년월일(8자리)을 입력해주세요*");
	private JLabel jlGender = new JLabel("성별을 입력해주세요*");
	private JLabel jlPhone = new JLabel("전화번호를 입력해주세요*");
	private JLabel jlTaste = new JLabel("취향을 선택해주세요(최대2개)");

	//private String[] hint = {"이름","생년월일(8자리)"};
	
	private JTextField jtID = new JTextField();
	private JPasswordField jtPw = new JPasswordField();
	private JPasswordField jtPwCheck = new JPasswordField();
	private JTextField jtName = new JTextField();
	private JTextField jtBirth = new JTextField();
	private ButtonGroup groundGender = new ButtonGroup();
	private JRadioButton jrw = new JRadioButton("여자");
	private JRadioButton jrm = new JRadioButton("남자");
	private JTextField jtPhone = new JTextField();
	private JCheckBox[] jcTaste = new JCheckBox[Taste_N];
	private JButtonT jbtnSignUP = new JButtonT();

	// 취향
	private String[] taste = new String[] { "액션", "로맨스", "공포", "판타지", "SF-공상과학", "스릴러" };

	private int n = 0;
	// 데이터 저장
	private String userID, userPassword, userPasswordCheck, userName,useryymmdd,userGender="", userPhone,userTaste1, userTaste2;

	// size
	private Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성

	// font
	private Font font1 = new Font(null, Font.BOLD, 20);
	private Font font2 = new Font(null, Font.PLAIN, 20);

	public SignUpPage() {

		super("회원가입");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 센테에서 나오도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // 레이아웃 null
		setVisible(true);

		// Panel 사이즈를 지정
		size.setSize(Main.SCREEN_WIDTH, PanelHeight);

		// 패널
		// jp.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT*2);
		jp.setLayout(null);
		jp.setPreferredSize(size);
		jp.setBackground(Color.WHITE);

		// 스크롤 패널
		JScrollPane scrollPanel = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(scrollPanel);

		// 로고
		jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(Main.SCREEN_WIDTH / 2 - 100, 30, 200, 100);
		jp.add(jlLogo);

		// 아이디 label
		jlID.setBounds(C_X, ID_Y, 200, 100);
		jlID.setFont(font1);
		jp.add(jlID);

		// 아이디 textField
		jtID.setBounds(C_X, ID_Y + TopMargin_Y, 500, 50);
		jtID.setFont(font2);
		jp.add(jtID);

		// 비밀번호 label
		jlPw.setBounds(C_X, PW_Y, 200, 100);
		jlPw.setFont(font1);
		jp.add(jlPw);

		// 비밀번호 textField
		jtPw.setBounds(C_X, PW_Y + TopMargin_Y, 500, 50);
		jtPw.setFont(font2);
		jp.add(jtPw);

		// 비밀번호 재확인 label
		jlPwCheck.setBounds(C_X, PWCheck_Y, 200, 100);
		jlPwCheck.setFont(font1);
		jp.add(jlPwCheck);

		// 비밀번호 재확인 textField
		jtPwCheck.setBounds(C_X, PWCheck_Y + TopMargin_Y, 500, 50);
		jtPwCheck.setFont(font2);
		jp.add(jtPwCheck);

		// 이름 label
		jlName.setBounds(C_X, Name_Y, 200, 100);
		jlName.setFont(font1);
		jp.add(jlName);

		// 이름 textField
		jtName.setBounds(C_X, Name_Y + TopMargin_Y, 500, 50);
		jtName.setFont(font2);
		jp.add(jtName);

		// 생년월일 label
		jlBirth.setBounds(C_X, Birth_Y, 500, 100);
		jlBirth.setFont(font1);
		jp.add(jlBirth);

		// 생년월일 textField
		jtBirth.setBounds(C_X, Birth_Y + TopMargin_Y, 500, 50);
		jtBirth.setFont(font2);
		jp.add(jtBirth);
		
		
		//성별 label
		jlGender.setBounds(C_X, Gender_Y,300,100);
		jlGender.setFont(font1);
		jp.add(jlGender);
		
		//성별m radio
		jrm.setBounds(C_X,Gender_Y+TopMargin_Y,100,50);
		jrm.setFont(font2);
		jrm.addItemListener(new RadioButtonEvent());
		groundGender.add(jrm);
		jp.add(jrm);
		
		//성별w radio
		jrw.setBounds(C_X+110,Gender_Y+TopMargin_Y,100,50);
		jrw.setFont(font2);
		jrw.addItemListener(new RadioButtonEvent());
		groundGender.add(jrw);
		jp.add(jrw);

		// 전화번호 label
		jlPhone.setBounds(C_X, Phone_Y, 300, 100);
		jlPhone.setFont(font1);
		jp.add(jlPhone);

		// 전화번호 textField
		jtPhone.setBounds(C_X, Phone_Y + TopMargin_Y, 500, 50);
		jtPhone.setFont(font2);
		jp.add(jtPhone);

		// 취향 label
		jlTaste.setBounds(C_X, Taste_Y, 300, 100);
		jlTaste.setFont(font1);
		jp.add(jlTaste);

		// 취향 checkbox
		for (int i = 0; i < Taste_N; i++) {
			jcTaste[i] = new JCheckBox();
			jcTaste[i].setText(taste[i]);
			jcTaste[i].setFont(font2);
			jcTaste[i].setFocusPainted(false);
			// setBorderPainted(false);
			jcTaste[i].setBackground(Color.PINK);
			jcTaste[i].setBounds(C_X, Taste_Y + (TopMargin_Y) * (i + 1), 150, 50);
			jp.add(jcTaste[i]);
			jcTaste[i].addItemListener(new CheckBoxEvent());
		}

		// 회원가입
		jbtnSignUP.setText("회원가입");
		jbtnSignUP.setFont(font1);
		jbtnSignUP.setBounds(C_X, SignUP_Y, 500, 100);
		jp.add(jbtnSignUP);

		// 회원가입 리스너
		jbtnSignUP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				userID = jtID.getText();
				userPassword = jtPw.getText();
				userPasswordCheck = jtPwCheck.getText();
				userName = jtName.getText();
				useryymmdd = jtBirth.getText();
				userPhone = jtPhone.getText();
				
				
				JOptionPane message =new JOptionPane();//메시지 박스 객체
				
				//데이터가 비어있는지 확인
				if(userID.isEmpty() || userPassword.isEmpty() || userPasswordCheck.isEmpty()|| userName.isEmpty() || useryymmdd.isEmpty()
						|| userGender.isEmpty() || userPhone.isEmpty()) {
					message.showMessageDialog(null, "입력되지 않은 정보가 있습니다.");			
				}else {//모든 데이터가 입력되었을떄 실행
					if(!(userPassword.equals(userPasswordCheck))) {
						message.showMessageDialog(null,"비밀번호가 일치 하지 않습니다." );
					}else {
						boolean success = coneection.addUser(userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2);
						if(success) {
							message.showMessageDialog(null,"회원가입에 성공했습니다!" );
							new LoginPage();
							dispose();
						}else {
							message.showMessageDialog(null,"일치하는 아이디가 있습니다." );
						}
						//System.out.println(coneection.addUser(userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2));
					}
				}
				//
				
			}
		});

	}
	

	//라디오버튼 리스너
	class RadioButtonEvent implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(jrm.isSelected()) {
				userGender = "남자";
			}else {
				userGender = "여자";
			}
		}
	
	}
	
	// 체크박스 리스너
	class CheckBoxEvent implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				n -= 1;
			} else {
				if (n < 2) {
					if (n == 0) {
						for (int i = 0; i < Taste_N; i++) {
							if (e.getItem() == jcTaste[i]) {
								userTaste1 = taste[i];
							}
						}
					} else {
						for (int i = 0; i < Taste_N; i++) {
							if (e.getItem() == jcTaste[i]) {
								userTaste2 = taste[i];
							}
						}
					}
					n += 1;
				} else {
					for (int i = 0; i < Taste_N; i++) {
						if (e.getItem() == jcTaste[i]) {
							jcTaste[i].setSelected(false);
						}
					}
					n = 2;
				}
			}
		}

	}
}
