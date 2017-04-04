package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Window;

public class InGameOptionMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton btnResume;
	private JButton btnOptions;
	private JButton btnExit;
	private JPanel contentPane;
	private Window window;
	
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
		contentPane.setLayout(new GridLayout(3, 1));
		setContentPane(contentPane);
		
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
				dispose();
			}
		});
	}
}