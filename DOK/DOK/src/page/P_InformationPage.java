package page;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P_InformationPage extends JFrame {
	private final static int PaddingLeft = 50;
	private final static int PaddingTop = 200;
	
	//component
	private JPanel jp = new JPanel();
	
	JLabel jlProfile = new JLabel("프로필");
	JLabel jlName = new JLabel("이름");
	JButton jbtnChange = new JButton("+");
	
	JLabel jlId = new JLabel("아이디");
	JLabel jlBirthday = new JLabel("생년월일");
	JButton jbtnP_number = new JButton("전화번호");
	
	JLabel jlTaste = new JLabel("영화 취향");
	String[] Taste = {"공포", "드라마", "로맨스", "스릴러", "애니메이션", "액션", "SF"};
	JCheckBox[] jcTaste = new JCheckBox[7];
	
	JButton jbtnFinish = new JButton("완료");
	
	public P_InformationPage() {
		jlProfile.setBounds(PaddingLeft, PaddingTop, 200, 200);
		jlProfile.setOpaque(true);
		jlProfile.setBackground(Color.RED);
		jp.add(jlProfile);
		
		jlName.setBounds(PaddingLeft, PaddingTop + 210, 200, 50);
		jlName.setOpaque(true);
		jlName.setBackground(Color.GREEN);
		jp.add(jlName);
		
		//아이디
		jlId.setBounds(PaddingLeft + 285, PaddingTop + 50, 200, 50);
		jlId.setOpaque(true);
		jlId.setBackground(Color.BLUE);
		jp.add(jlId);
		
		//생년월일 : yyyy-mm-dd
		jlBirthday.setBounds(PaddingLeft + 285, PaddingTop + 115, 200, 50);
		jlBirthday.setOpaque(true);
		jlBirthday.setBackground(Color.BLUE);
		jp.add(jlBirthday);
		
		//전화번호
		jbtnP_number.setBounds(PaddingLeft + 285, PaddingTop + 180, 200, 50);
		jbtnP_number.setOpaque(true);
		jbtnP_number.setBackground(Color.BLUE);
		jp.add(jbtnP_number);
			
		//영화 취향
		jlTaste.setBounds(PaddingLeft + 15, PaddingTop + 280, 100, 50);
		jlTaste.setOpaque(true);
		jlTaste.setBackground(Color.BLUE);
		jp.add(jlTaste);
		
		for(int i = 0; i < jcTaste.length; i++) {
			jcTaste[i] = new JCheckBox(Taste[i]);
			
			if(i > 3) {
				jcTaste[i].setBounds(PaddingLeft + 300, PaddingTop + 190 + (i * 45), 100, 30);
			}else {
				jcTaste[i].setBounds(PaddingLeft + 100, PaddingTop + 370 + (i * 45), 100, 30);
			}
			
			
			jcTaste[i].setOpaque(true);
			jcTaste[i].setBackground(Color.LIGHT_GRAY);
			jp.add(jcTaste[i]);
		}
		
		//완료
		jbtnFinish.setBounds(PaddingLeft + 200, PaddingTop + 575, 100, 50);
		jbtnFinish.setOpaque(true);
		jbtnFinish.setBackground(Color.YELLOW);
		jp.add(jbtnFinish);
		
		add(jp);
		
		jp.setLayout(null);
		jp.setBackground(Color.WHITE);
		
		setSize(600, 900);
		setVisible(true);
	}
}
