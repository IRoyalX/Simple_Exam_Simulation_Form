import javax.swing.*;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Result extends JFrame implements ActionListener {
	JFrame Fresult = new JFrame("آزمون جاوا - نتیجه");
	
	JLabel Lgender_name;
	JLabel Lphone;
	JLabel Laddress;
	JLabel Lbirth;
	JLabel Lta;
	JLabel Lna;
	JLabel Lfa;
	JLabel Ln;
	
	JButton Bexit = new JButton("خروج");
	JButton Breset = new JButton("شروع مجدد");
	
	Result(String name, String phone, String address, String birth, String gender, int trueanswered, int notanswered, int counter) {
		
		Fresult.setSize(300, 300);
		Fresult.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - Fresult.getSize().width)/2 , (Toolkit.getDefaultToolkit().getScreenSize().height - Fresult.getSize().height)/2);
		
		Lgender_name = new JLabel("نام:                " + gender + " " + name);
		Lgender_name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Lgender_name.setBounds(-25, 10, 300, 30);
		
		Lbirth = new JLabel("تاریخ تولد:       " + birth);
		Lbirth.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Lbirth.setBounds(-25, 30, 300, 30);
		
		Laddress = new JLabel("آدرس:            " + address);
		Laddress.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Laddress.setBounds(-25, 50, 300, 30);
		
		Lphone = new JLabel("شماره تماس:    " + phone);
		Lphone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Lphone.setBounds(-25, 70, 300, 30);
		
		JSeparator Sep = new JSeparator();
		Sep.setBackground(Color.BLACK);
		Sep.setBounds(0,110,999,10);
		
		Ln = new JLabel("کل سوالات:    " + counter);
		Ln.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Ln.setBounds(175, 130, 100, 30);
		
		Lta = new JLabel("پاسخ های درست:    " + trueanswered);
		Lta.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Lta.setBounds(25, 130, 100, 30);
		
		Lfa = new JLabel("پاسخ های غلط:       " + (counter - (trueanswered + notanswered)));
		Lfa.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Lfa.setBounds(25, 160, 100, 30);
		
		Lna = new JLabel("بدون پاسخ:    " + notanswered);
		Lna.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Lna.setBounds(175, 160, 100, 30);
		
		Bexit.setBounds(170, 220, 100, 30);
		Breset.setBounds(15, 220, 100, 30);
		
		Fresult.add(Lgender_name);Fresult.add(Lbirth);Fresult.add(Laddress);
		Fresult.add(Lphone);Fresult.add(Lgender_name);Fresult.add(Lgender_name);
		Fresult.add(Sep);
		Fresult.add(Ln);Fresult.add(Lta);Fresult.add(Lfa);Fresult.add(Lna);
		Fresult.add(Bexit);Fresult.add(Breset);
		
		Bexit.addActionListener(this);
		Breset.addActionListener(this);
		
		Fresult.setLayout(null);
		Fresult.setVisible(true);
		Fresult.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Breset) {
			Fresult.dispose();
			new Signup();
		}
		if(e.getSource() == Bexit) {
			Fresult.dispose();
			System.exit(1);
		}
	}
}