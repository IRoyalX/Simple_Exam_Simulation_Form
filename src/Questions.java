import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.*;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Questions extends JFrame implements ActionListener {
		String name,phone,address,birth,gender;
		int trueanswered = 0,notanswered = 0,trueanswer = 0,counter = 0;
		
		FileReader FR;
		BufferedReader get;
		
		{
			try {
				FR = new FileReader("questions.dat",StandardCharsets.UTF_8);
				get = new BufferedReader(FR);
			} 
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, "ERR: question file not found.", "ERROR", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		JFrame Fquestions = new JFrame("آزمون جاوا - سوالات");

		JLabel Lquestion = new JLabel();
		JLabel Lo1 = new JLabel("الف) ");
		JLabel Lo2 = new JLabel("ب) ");
		JLabel Lo3 = new JLabel("ج) ");
		JLabel Lo4 = new JLabel("د) ");
		
		JCheckBox o1 = new JCheckBox();
		JCheckBox o2 = new JCheckBox();
		JCheckBox o3 = new JCheckBox();
		JCheckBox o4 = new JCheckBox();
		
		ButtonGroup CB = new ButtonGroup();
		
		JButton Bnext = new JButton("سوال بعد");
		JButton Bclear = new JButton("پاک کردن پاسخ");
		
		Questions(String nameT, String phoneT, String addressT, String birthT, String genderT) {
			
			name = nameT;phone = phoneT;address = addressT;birth = birthT;gender = genderT;
			
			Reader();
			
			Fquestions.setSize(400, 400);
			Fquestions.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - Fquestions.getSize().width)/2 , (Toolkit.getDefaultToolkit().getScreenSize().height - Fquestions.getSize().height)/2);
			
			CB.add(o1);CB.add(o2);CB.add(o3);CB.add(o4);
			
			Lquestion.setFont(new Font("Arial",Font.BOLD,13));
			Lquestion.setBounds(50, 20, 300, 30);Lquestion.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			Lo1.setBounds(350, 100, 30, 20);
			Lo2.setBounds(350, 150, 30, 20);
			Lo3.setBounds(350, 200, 30, 20);
			Lo4.setBounds(350, 250, 30, 20);
			
			o1.setHorizontalTextPosition(JCheckBox.LEFT);o1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			o2.setHorizontalTextPosition(JCheckBox.LEFT);o2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			o3.setHorizontalTextPosition(JCheckBox.LEFT);o3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			o4.setHorizontalTextPosition(JCheckBox.LEFT);o4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			o1.setBounds(50, 100, 300, 20);
			o2.setBounds(50, 150, 300, 20);
			o3.setBounds(50, 200, 300, 20);
			o4.setBounds(50, 250, 300, 20);
			
			Bnext.setBounds(75, 300, 100, 30);
			Bclear.setBounds(225, 300, 100, 30);
			
			
			Fquestions.add(Lquestion);Fquestions.add(o1);Fquestions.add(o2);
			Fquestions.add(o3);Fquestions.add(o4);Fquestions.add(Lo1);Fquestions.add(Lo2);
			Fquestions.add(Lo3);Fquestions.add(Lo4);Fquestions.add(Bnext);Fquestions.add(Bclear);
			
			Bnext.addActionListener(this);
			Bclear.addActionListener(this);
			
			Fquestions.setLayout(null);
			Fquestions.setVisible(true);
			Fquestions.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Bnext) {
				if(!Bclear.isEnabled()) {
					Fquestions.dispose();
					new Result(name,phone,address,birth,gender,trueanswered,notanswered,counter);
				}
				else {
					switch(trueanswer) {
						case 1: if(o1.isSelected())trueanswered++;break;
						case 2: if(o2.isSelected())trueanswered++;break;
						case 3: if(o3.isSelected())trueanswered++;break;
						case 4: if(o4.isSelected())trueanswered++;break;
					}
					if(CB.getSelection() == null)
						notanswered++;
					CB.clearSelection();
					Reader();
				}
			}
			if(e.getSource() == Bclear) {
				CB.clearSelection();
			}
		}
		public void Reader()  {
			try {
				if(get.readLine() == null) {
					FR.close();
					get.close();
					
					Bnext.setText("مشاهده نتیجه");
					
					Bclear.setEnabled(false);
					o1.setVisible(false);o2.setVisible(false);o3.setVisible(false);o4.setVisible(false);
					Lo1.setVisible(false);Lo2.setVisible(false);Lo3.setVisible(false);Lo4.setVisible(false);
					
					Lquestion.setText("آزمون خاتمه یافته است");
					Lquestion.setForeground(Color.RED);
					Lquestion.setBounds(-25, 100, 300, 30);
					Lquestion.setFont(new Font("Arial",Font.BOLD,20));
					
					JOptionPane.showMessageDialog(null, "ازمون شما به پایان رسید.\nموفق باشید.", "پیغام سیستم", JOptionPane.INFORMATION_MESSAGE);

				}
				else {
				counter++;
				Lquestion.setText(counter + ". " + get.readLine());
				o1.setText(get.readLine());
				o2.setText(get.readLine());
				o3.setText(get.readLine());
				o4.setText(get.readLine());
				trueanswer = Integer.parseInt(get.readLine());
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}		
}