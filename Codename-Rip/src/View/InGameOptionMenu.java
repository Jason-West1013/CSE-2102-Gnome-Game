package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Game;
import Main.Window;

public class InGameOptionMenu extends JFrame{
	
	JPanel contentPane;
	JButton btnResume;
	JButton btnOptions;
	JButton btnExit;
	Window window;
	
	private static final long serialVersionUID = 4647382187656153388L;
	
	public InGameOptionMenu(Window window){
		this.window = window;
		initComponents();
		createEvents();
	}
	
	private void initComponents(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1));
		
		btnResume = new JButton("Resume");
		contentPane.add(btnResume);
		
		btnOptions = new JButton("Options");
		contentPane.add(btnOptions);
		
		btnExit = new JButton("Exit");
		contentPane.add(btnExit);
		
		setResizable(false);
		setUndecorated(true);
	}
	
	private void createEvents(){
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.close();
				dispose();
				System.exit(0);
			}
		});
		
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				dispose();
			}
		});
	}
	

}
