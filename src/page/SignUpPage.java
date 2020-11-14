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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import User.DB_userInfo;

public class SignUpPage extends JFrame {

	// DB
	DB_userInfo conection = new DB_userInfo();

	// size
	private Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
	
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
	private JScrollPane scroll;
	private JPanel panel = new JPanel();
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png"); // 로고 이미지
	private JLabel logo = new JLabel();
	private JLabel id = new JLabel("아이디*");
	private JLabel password = new JLabel("비밀번호*");
	private JLabel password_check = new JLabel("비밀번호 재확인*");
	private JLabel name = new JLabel("이름*");
	private JLabel birthday = new JLabel("생년월일(8자리)을 입력해주세요*");
	private JLabel gender = new JLabel("성별을 입력해주세요*");
	private JLabel phone = new JLabel("전화번호를 입력해주세요*");
	private JLabel jlTaste = new JLabel("취향을 선택해주세요(최대2개)");
	//private String[] hint = {"이름","생년월일(8자리)"};
	private JTextField input_id = new JTextField();
	private JPasswordField input_password = new JPasswordField();
	private JPasswordField input_passwordCheck = new JPasswordField();
	private JTextField input_name = new JTextField();
	private JTextField input_birtyday = new JTextField();
	private ButtonGroup input_gender = new ButtonGroup();
	private JRadioButton woman = new JRadioButton("여자");
	private JRadioButton man = new JRadioButton("남자");
	private JTextField input_phone = new JTextField();
	private JCheckBox[] checkbox_taste = new JCheckBox[Taste_N];
	private JButton btn_signUp = new JButton();

	
	//변수
	private String[] string_taste = new String[] { "액션", "로맨스", "공포", "판타지", "SF-공상과학", "스릴러" };
	private int n = 0;
	private String userID, userPassword, userPasswordCheck, userName,useryymmdd,userGender, userPhone,userTaste1, userTaste2;


	// font
	private Font font1 = new Font(null, Font.BOLD, 20);
	private Font font2 = new Font(null, Font.PLAIN, 20);

	public SignUpPage() {

		super("회원가입");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		getContentPane().setLayout(null); // 레이아웃 null
		setVisible(true);

		// Panel 사이즈를 지정
		size.setSize(Main.SCREEN_WIDTH, PanelHeight);

		// 패널
		// jp.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT*2);
		panel.setLayout(null);
		panel.setPreferredSize(size);
		panel.setBackground(Color.WHITE);

		// 스크롤 패널
		JScrollPane scrollPanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(scrollPanel);

		// 로고
		logo.setIcon(imgLogo);
		logo.setBounds(Main.SCREEN_WIDTH / 2 - 100, 30, 200, 100);
		panel.add(logo);

		// 아이디 label
		id.setBounds(C_X, ID_Y, 200, 100);
		id.setFont(font1);
		panel.add(id);

		// 아이디 textField
		input_id.setBounds(C_X, ID_Y + TopMargin_Y, 500, 50);
		input_id.setFont(font2);
		panel.add(input_id);

		// 비밀번호 label
		password.setBounds(C_X, PW_Y, 200, 100);
		password.setFont(font1);
		panel.add(password);

		// 비밀번호 textField
		input_password.setBounds(C_X, PW_Y + TopMargin_Y, 500, 50);
		input_password.setFont(font2);
		panel.add(input_password);

		// 비밀번호 재확인 label
		password_check.setBounds(C_X, PWCheck_Y, 200, 100);
		password_check.setFont(font1);
		panel.add(password_check);

		// 비밀번호 재확인 textField
		input_passwordCheck.setBounds(C_X, PWCheck_Y + TopMargin_Y, 500, 50);
		input_passwordCheck.setFont(font2);
		panel.add(input_passwordCheck);

		// 이름 label
		name.setBounds(C_X, Name_Y, 200, 100);
		name.setFont(font1);
		panel.add(name);

		// 이름 textField
		input_name.setBounds(C_X, Name_Y + TopMargin_Y, 500, 50);
		input_name.setFont(font2);
		panel.add(input_name);

		// 생년월일 label
		birthday.setBounds(C_X, Birth_Y, 500, 100);
		birthday.setFont(font1);
		panel.add(birthday);

		// 생년월일 textField
		input_birtyday.setBounds(C_X, Birth_Y + TopMargin_Y, 500, 50);
		input_birtyday.setFont(font2);
		panel.add(input_birtyday);
		
		
		//성별 label
		gender.setBounds(C_X, Gender_Y,300,100);
		gender.setFont(font1);
		panel.add(gender);
		
		//성별m radio
		man.setBounds(C_X,Gender_Y+TopMargin_Y,100,50);
		man.setFont(font2);
		man.addItemListener(new RadioButtonEvent());
		input_gender.add(man);
		panel.add(man);
		
		//성별w radio
		woman.setBounds(C_X+110,Gender_Y+TopMargin_Y,100,50);
		woman.setFont(font2);
		woman.addItemListener(new RadioButtonEvent());
		input_gender.add(woman);
		panel.add(woman);

		// 전화번호 label
		phone.setBounds(C_X, Phone_Y, 300, 100);
		phone.setFont(font1);
		panel.add(phone);

		// 전화번호 textField
		input_phone.setBounds(C_X, Phone_Y + TopMargin_Y, 500, 50);
		input_phone.setFont(font2);
		panel.add(input_phone);

		// 취향 label
		jlTaste.setBounds(C_X, Taste_Y, 300, 100);
		jlTaste.setFont(font1);
		panel.add(jlTaste);

		// 취향 checkbox
		for (int i = 0; i < Taste_N; i++) {
			checkbox_taste[i] = new JCheckBox();
			checkbox_taste[i].setText(string_taste[i]);
			checkbox_taste[i].setFont(font2);
			checkbox_taste[i].setFocusPainted(false);
			// setBorderPainted(false);
			checkbox_taste[i].setBackground(Color.PINK);
			checkbox_taste[i].setBounds(C_X, Taste_Y + (TopMargin_Y) * (i + 1), 150, 50);
			panel.add(checkbox_taste[i]);
			checkbox_taste[i].addItemListener(new CheckBoxEvent());
		}

		// 회원가입
		btn_signUp.setText("회원가입");
		btn_signUp.setFont(font1);
		btn_signUp.setBounds(C_X, SignUP_Y, 500, 100);
		panel.add(btn_signUp);

		// 회원가입 리스너
		btn_signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				userID = input_id.getText();
				userPassword = input_password.getText();
				userPasswordCheck = input_passwordCheck.getText();
				userName = input_name.getText();
				useryymmdd = input_birtyday.getText();
				userPhone = input_phone.getText();
				
				
				JOptionPane message =new JOptionPane();//메시지 박스 객체
				
				//데이터가 비어있는지 확인
				if(userID.isEmpty() || userPassword.isEmpty() || userPasswordCheck.isEmpty()|| userName.isEmpty() || useryymmdd.isEmpty()
						|| userGender.isEmpty() || userPhone.isEmpty()) {
					message.showMessageDialog(null, "입력되지 않은 정보가 있습니다.");			
				}else {//모든 데이터가 입력되었을떄 실행
					if(!(userPassword.equals(userPasswordCheck))) {
						message.showMessageDialog(null,"비밀번호가 일치 하지 않습니다." );
					}else {
						boolean success = conection.addUser(userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2);
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
			if(man.isSelected()) {
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
							if (e.getItem() == checkbox_taste[i]) {
								userTaste1 = string_taste[i];
							}
						}
					} else {
						for (int i = 0; i < Taste_N; i++) {
							if (e.getItem() == checkbox_taste[i]) {
								userTaste2 = string_taste[i];
							}
						}
					}
					n += 1;
				} else {
					for (int i = 0; i < Taste_N; i++) {
						if (e.getItem() == checkbox_taste[i]) {
							checkbox_taste[i].setSelected(false);
						}
					}
					n = 2;
				}
			}
		}

	}
}
