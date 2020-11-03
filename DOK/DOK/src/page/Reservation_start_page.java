package page;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reservation_start_page extends JFrame{
	
	//component
	private CategoryPanel c1 = new CategoryPanel();	//카테고리 panel
	private JPanel jp = new JPanel();
	
	public Reservation_start_page() {
		
		super("예매");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 센테에서 나오도록
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);
		
		//카테고리 Panel
		add(c1);
		
		//Panel
		jp.setBackground(Color.WHITE);
		jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		add(jp);
		
	}
}
