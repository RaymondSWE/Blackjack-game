import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

	private final JPanel main_pnl;
	private final JLabel Name_lbl;
	private final JLabel Balance_lbl;
	private final JTextField Name_txt;
	private final JTextField Balance_txt;
	private final JButton start_btn;
	private final JLabel title_lbl;

	public MainMenu() {
		main_pnl = new JPanel();
		Name_lbl = new JLabel();
		Balance_lbl = new JLabel();
		Name_txt = new JTextField();
		Balance_txt = new JTextField();
		start_btn = new JButton();
		title_lbl = new JLabel();
		initComponents();
	}
	/*
	 * When start mouse button is pressed then get the name and balance from the
	 * text fields. if name or balance is empty filed then show the error message.
	 * If the balance value was not an integer then show the error message otherwise
	 * set this window's visibility to false and start a new Game()
	 */

	private void start_btnMousePressed() {
		String name = this.Name_txt.getText();
		String balance = this.Balance_txt.getText();
		String errorMessage = "Fill all the Fields!";
		if ((!name.isEmpty() && !balance.isEmpty()) || (!name.isBlank() && !balance.isBlank())) {
			try {
				int balanceValue = Integer.parseInt(balance);
				this.setVisible(false);
				new Game(name, balanceValue).setVisible(true);
				return;
			} catch (NumberFormatException ignored) {
				errorMessage = "Please enter integer balance value!";
			}
		}
		JOptionPane.showMessageDialog(rootPane, errorMessage, "Error Message", JOptionPane.ERROR_MESSAGE);
	}

	private void initComponents() {

		// ======== this ========
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Black-Jack by Nibar & Raman");
		var contentPane = getContentPane();
		contentPane.setLayout(null);

		// ======== main_pnl ========
		{
			main_pnl.setBackground(new Color(0, 153, 0));
			main_pnl.setLayout(null);

			// ---- Name_lbl ----
			Name_lbl.setText("Name :");
			Name_lbl.setBackground(Color.black);
			Name_lbl.setForeground(Color.lightGray);
			Name_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			Name_lbl.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
			main_pnl.add(Name_lbl);
			Name_lbl.setBounds(150, 205, 100, 25);

			// ---- Balance_lbl ----
			Balance_lbl.setText("Balance $ : ");
			Balance_lbl.setBackground(Color.black);
			Balance_lbl.setForeground(Color.lightGray);
			Balance_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			Balance_lbl.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
			main_pnl.add(Balance_lbl);
			Balance_lbl.setBounds(150, 250, 100, 25);

			// ---- Name_txt ----
			Name_txt.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			main_pnl.add(Name_txt);
			Name_txt.setBounds(245, 200, 210, 30);

			// ---- Balance_txt ----
			Balance_txt.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			main_pnl.add(Balance_txt);
			Balance_txt.setBounds(245, 245, 210, 30);

			// ---- start_btn ----
			start_btn.setText("START");
			start_btn.setFont(new Font("Segoe UI", Font.BOLD, 20));
			start_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			start_btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					start_btnMousePressed();
				}
			});
			main_pnl.add(start_btn);
			start_btn.setBounds(205, 340, 300, 40);

			// ---- title_lbl ----
			title_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			title_lbl.setForeground(Color.black);
			title_lbl.setFont(new Font("Roboto Slab", Font.BOLD, 30));
			title_lbl.setIcon(new ImageIcon("Images\\title"));
			main_pnl.add(title_lbl);
			title_lbl.setBounds(205, 15, 300, 150);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for (int i = 0; i < main_pnl.getComponentCount(); i++) {
					Rectangle bounds = main_pnl.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = main_pnl.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				main_pnl.setMinimumSize(preferredSize);
				main_pnl.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(main_pnl);
		main_pnl.setBounds(0, 0, 685, 420);

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for (int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(null);
	}

}