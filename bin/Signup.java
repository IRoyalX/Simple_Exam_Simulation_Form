import javax.swing.*;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Signup extends JFrame implements ActionListener {
	String name,phone,address,birth,gender;

	JFrame Fsignup = new JFrame("آزمون جاوا - ثبت نام");

	JLabel Ltitle = new JLabel  ("فرم ثبت نام");
	JLabel Lname = new JLabel   ("نام و نام خانوادگی :");
	JLabel Lphone = new JLabel  ("شماره همراه :       ");
	JLabel Lgender = new JLabel ("جنسیت :             ");
	JLabel Lbirth = new JLabel  ("تاریخ تولد :        ");
	JLabel Laddress = new JLabel("آدرس :              ");
	
	JLabel Lerror1 = new JLabel("* وارد کردن این فیلد الزامی است !");
	JLabel Lerror2 = new JLabel("* شماره همراه را وارد کنید !");
	JLabel Lerror3 = new JLabel("* فیلد آدرس نمی تواند خالی باشد !");

	JTextField TFname = new JTextField();
	JTextField TFphone = new JTextField();

	JRadioButton RBmale = new JRadioButton("مرد");
	JRadioButton RBfemale = new JRadioButton("زن");
	ButtonGroup RB = new ButtonGroup();

	JComboBox<String> CBday;
	JComboBox<String> CBmonth;
	JComboBox<String> CByear;

	JTextArea TAaddress = new JTextArea();

	JButton Bnext = new JButton("شروع آزمون");
	JButton Bclear = new JButton("پاکسازی فیلد ها");

	Signup() {
		int i;
		
		String[] day = new String[31];
		String[] month = {"فروردین","اردیبهشت","خرداد","تیر","مرداد","شهریور","مهر","آبان","آذر","دی","بهمن","اسفند"};
		String[] year = new String[70];
		
		for(i = 0;i < 31;i++)
			day[i] = Integer.toString(i+1);
		for(i = 0;i < 70;i++)
			year[i] = Integer.toString(i+1330);
			
		CBday = new JComboBox<String>(day);
		CBmonth = new JComboBox<String>(month);
		CByear = new JComboBox<String>(year);
	
		RB.add(RBmale);
		RB.add(RBfemale);
		RBmale.setSelected(true);
		
		Fsignup.setSize(385,600);
		Fsignup.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - Fsignup.getSize().width)/2 , (Toolkit.getDefaultToolkit().getScreenSize().height - Fsignup.getSize().height)/2);
		
		Ltitle.setBounds(150, 30, 100, 30);Ltitle.setFont(new Font("Arial",Font.BOLD,20));
		Lname.setBounds(225, 90, 100, 30);
		Lphone.setBounds(225, 150, 100, 30);
		Lgender.setBounds(225, 210, 100, 30);
		Lbirth.setBounds(225, 270, 100, 30);
		Laddress.setBounds(225, 330, 100, 30);
		
		Lerror1.setBounds(75, 115, 150, 20);
		Lerror2.setBounds(97, 175, 150, 20);
		Lerror3.setBounds(77, 310, 150, 20);
		Lerror1.setVisible(false);
		Lerror2.setVisible(false);
		Lerror3.setVisible(false);
		Lerror1.setForeground(Color.RED);
		Lerror2.setForeground(Color.RED);
		Lerror3.setForeground(Color.RED);
		
		TFname.setBounds(65, 95, 150, 20);TFname.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		TFphone.setBounds(65, 155, 150, 20);TFphone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		RBmale.setBounds(160, 215, 50, 20);
		RBfemale.setBounds(80, 215, 50, 20);
		
		CBday.setBounds(185, 275, 40, 20);
		CBmonth.setBounds(120, 275, 65, 20);
		CByear.setBounds(65, 275, 55, 20);
		
		TAaddress.setBounds(65, 335, 165, 100);TAaddress.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		Bnext.setBounds(65, 475, 100, 30);
		Bclear.setBounds(200, 475, 100, 30);
		
		Fsignup.add(Ltitle);Fsignup.add(Lname);Fsignup.add(Lphone);Fsignup.add(Lgender);
		Fsignup.add(Lbirth);Fsignup.add(Laddress);Fsignup.add(TFname);Fsignup.add(TFphone);
		Fsignup.add(RBmale);Fsignup.add(RBfemale);Fsignup.add(RBfemale);
		Fsignup.add(CBday);Fsignup.add(CBmonth);Fsignup.add(CByear);Fsignup.add(TAaddress);
		Fsignup.add(Bnext);Fsignup.add(Bclear);Fsignup.add(Lerror1);Fsignup.add(Lerror2);
		Fsignup.add(Lerror3);
		
		Bnext.addActionListener(this);
		Bclear.addActionListener(this);
		
		Fsignup.setLayout(null);
		Fsignup.setVisible(true);
		Fsignup.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Bnext) {
			if(TFname.getText().toString().isEmpty())
				Lerror1.setVisible(true);
			else
				Lerror1.setVisible(false);
			if(TFphone.getText().toString().isEmpty())
				Lerror2.setVisible(true);
			else
				Lerror2.setVisible(false);
			if(TAaddress.getText().toString().isEmpty())
				Lerror3.setVisible(true);
			else
				Lerror3.setVisible(false);
			if(!Lerror1.isVisible() && !Lerror2.isVisible() && !Lerror3.isVisible()) {
				name = TFname.getText().toString();
				phone = TFphone.getText().toString();
				address = TAaddress.getText().toLowerCase();
				birth = CBday.getSelectedItem().toString() + " / " + CBmonth.getSelectedItem().toString() + "(" + (CBmonth.getSelectedIndex()+1) + ")" + " / " + CByear.getSelectedItem().toString();
				if(RBmale.isSelected())
					gender = "آقای";
				else
					gender = "خانم";
				Fsignup.dispose();
				new Questions(name,phone,address,birth,gender);
			}
		}
		else if (e.getSource() == Bclear) {
			Lerror1.setVisible(false);
			Lerror2.setVisible(false);
			Lerror3.setVisible(false);
			
			TFname.setText("");
			TFphone.setText("");
			
			RBmale.setSelected(true);
			
			TAaddress.setText("");
			
			CBday.setSelectedIndex(0);
			CBmonth.setSelectedIndex(0);
			CByear.setSelectedIndex(0);
		}
	}
	public static void main(String arg[]) {
		new Signup();
	}
}

