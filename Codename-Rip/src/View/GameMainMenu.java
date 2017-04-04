package View;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Main.Game;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameMainMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JButton btnNewGame;
	private JButton btnOptions;
	private JButton btnHelp;
	private JButton btnAbout;
	private JButton btnExit;
	private JLabel lblTitle;
	private JPanel contentPane;

	public GameMainMenu() {
		setResizable(false);
		initComponents();
		createEvents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 232);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(6, 1));
		setContentPane(contentPane);

		lblTitle = new JLabel("Shift");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);

		btnNewGame = new JButton("New Game");
		contentPane.add(btnNewGame);

		btnOptions = new JButton("Options");
		contentPane.add(btnOptions);

		btnHelp = new JButton("Help");
		contentPane.add(btnHelp);

		btnAbout = new JButton("About");
		contentPane.add(btnAbout);

		btnExit = new JButton("Exit");
		contentPane.add(btnExit);
	}

	private void createEvents() {
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Game();
				dispose();
			}
		});

		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame optionMenu = new OptionMenu();
				optionMenu.setLocationRelativeTo(null);
			}
		});

		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMainMenu frame = new GameMainMenu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}