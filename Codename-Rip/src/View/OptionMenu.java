package View;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class OptionMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	public OptionMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 232);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setUndecorated(true);
		setVisible(true);
     }
}
