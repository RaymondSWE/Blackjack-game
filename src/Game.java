import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.*;

public class Game extends JFrame {

	private final JPanel main_pnl;
	private final JPanel display_pnl;
	private final JButton hit_btn;
	private final JButton stand_btn;
	private final JButton bet_btn;
	private final JTextField bet_txt;
	private final JButton quit_btn;
	private final JLabel balance_lbl;
	private final JLabel bet_lbl;
	private final JLabel playerName_lbl;
	private final JLabel dealerName_lbl;
	private final JLabel background_lbl;
	private final Board board;
	private int betAmount;
	private boolean isDealerTurn;
	
	

	// New game with player name and balance
	public Game(String name, int balance) {
		isDealerTurn = false;
		betAmount = 0;
		board = new Board(name, balance);
		main_pnl = new JPanel();
		// Paint cards on the panel
		display_pnl = new JPanel() {
			public void paint(Graphics graphics) {
				paintCards(graphics);
			}
		};
		hit_btn = new JButton();
		stand_btn = new JButton();
		bet_btn = new JButton();
		bet_txt = new JTextField();
		quit_btn = new JButton();
		balance_lbl = new JLabel();
		bet_lbl = new JLabel();
		background_lbl = new JLabel();
		playerName_lbl = new JLabel();
		dealerName_lbl = new JLabel();
		initComponents();
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

			// ======== display_pnl ========
			{
				display_pnl.setLayout(null);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < display_pnl.getComponentCount(); i++) {
						Rectangle bounds = display_pnl.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = display_pnl.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					display_pnl.setMinimumSize(preferredSize);
					display_pnl.setPreferredSize(preferredSize);
				}
			}
			display_pnl.setBackground(Color.black);
			main_pnl.add(display_pnl);
			display_pnl.setBounds(162, 50, 445, 400);

			// ---- hit_btn ----
			hit_btn.setText("HIT");
			hit_btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
			hit_btn.setBackground(new Color(236, 67, 28));
			hit_btn.setBorder(new LineBorder(new Color(221, 73, 3), 1, true));
			hit_btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					hit_btnMouseClicked();
				}
			});
			main_pnl.add(hit_btn);
			hit_btn.setBounds(165, 485, 100, 30);
			hit_btn.setEnabled(false);

			// ---- stand_btn ----
			stand_btn.setText("STAND");
			stand_btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
			stand_btn.setBackground(new Color(236, 67, 28));
			stand_btn.setBorder(new LineBorder(new Color(221, 73, 3), 1, true));
			stand_btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					stand_btnMouseClicked();
				}
			});
			main_pnl.add(stand_btn);
			stand_btn.setBounds(475, 490, 100, 30);
			stand_btn.setEnabled(false);

			// ---- bet_btn ----
			bet_btn.setText("BET");
			bet_btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
			bet_btn.setBackground(new Color(236, 67, 28));
			bet_btn.setBorder(new LineBorder(new Color(221, 73, 3), 1, true));
			bet_btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					bet_btnMouseClicked();
				}
			});
			main_pnl.add(bet_btn);
			bet_btn.setBounds(630, 515, 128, 25);
			// ---- bet_txt ----
			bet_txt.setToolTipText("Bet amount");
			main_pnl.add(bet_txt);
			bet_txt.setBounds(630, 485, 128, 25);

			// ---- quit_btn ----
			quit_btn.setText("QUIT");
			quit_btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
			quit_btn.setBackground(new Color(236, 67, 28));
			quit_btn.setBorder(new LineBorder(new Color(221, 73, 3), 1, true));
			quit_btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					quit_btnMouseClicked();
				}
			});
			main_pnl.add(quit_btn);
			quit_btn.setBounds(5, 515, 128, 25);

			// ---- balance_lbl ----
			balance_lbl.setText(Integer.toString(board.getPlayer().getBalance()));
			balance_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			balance_lbl.setFont(new Font("MOSFET", Font.BOLD, 12));
			balance_lbl.setBackground(new Color(2, 51, 153));
			balance_lbl.setOpaque(true);
			balance_lbl.setForeground(new Color(137, 137, 255));
			main_pnl.add(balance_lbl);
			balance_lbl.setBounds(320, 450, 130, 31);

			// ---- bet_lbl ----
			bet_lbl.setText("BET : 0$");
			bet_lbl.setHorizontalAlignment(SwingConstants.CENTER);
			bet_lbl.setFont(new Font("Arial Black", Font.BOLD, 12));
			bet_lbl.setOpaque(true);
			bet_lbl.setBackground(Color.BLACK);
			main_pnl.add(bet_lbl);
			bet_lbl.setBounds(315, 500, 130, 40);

			// ---- playerName_lbl ----
			playerName_lbl.setText(board.getPlayer().getName());
			playerName_lbl.setHorizontalAlignment(SwingConstants.LEFT);
			playerName_lbl.setFont(new Font("Arial Black", Font.BOLD, 12));
			playerName_lbl.setForeground(Color.WHITE);
			main_pnl.add(playerName_lbl);
			playerName_lbl.setBounds(120, 30, 130, 40);

			// ---- dealerName_lbl ----
			dealerName_lbl.setHorizontalAlignment(SwingConstants.LEFT);
			dealerName_lbl.setFont(new Font("Arial Black", Font.BOLD, 12));
			dealerName_lbl.setText("DEALER");
			dealerName_lbl.setForeground(Color.WHITE);
			main_pnl.add(dealerName_lbl);
			dealerName_lbl.setBounds(120, 0, 130, 36);

			// ---- background_lbl ----
			background_lbl.setIcon(new ImageIcon("Images\\image.png"));
			main_pnl.add(background_lbl);
			background_lbl.setBounds(0, 0, 770, 550);

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
		main_pnl.setBounds(0, 0, 770, 550);

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
		setLocationRelativeTo(getOwner());
	}
	/*
	 * If bet button is pressed then get the text of the bet If the bet text is
	 * empty or the bet is not an integer or the bet makes the balance to be a
	 * negative value then print the error message. Otherwise repaint the cards by
	 * starting the new round
	 */

	private void bet_btnMouseClicked() {

		String betValue = bet_txt.getText();
		if (!betValue.isBlank() || !betValue.isEmpty()) {
			try {
				if (Integer.parseInt(betValue) <= board.getPlayer().getBalance() && Integer.parseInt(betValue) > 0) {
					board.getPlayer()
							.setBalance(board.getPlayer().getBalance() - (betAmount = Integer.parseInt(betValue)));
					balance_lbl.setText(Integer.toString(board.getPlayer().getBalance()));
					bet_lbl.setText("BET : " + betValue + "$");
					bet_txt.setText("");
					balance_lbl.setText(Integer.toString(board.getPlayer().getBalance()));
					hit_btn.setEnabled(true);
					stand_btn.setEnabled(true);
					bet_txt.setEnabled(false);
					bet_btn.setEnabled(false);
					board.dealCards();
					playerName_lbl.setText(board.getPlayer().getName() + " : " + board.getPlayer().getScore());
					isDealerTurn = false;
					main_pnl.repaint();
					return;
				}
			} catch (NumberFormatException ignored) {

			}
		}
		JOptionPane.showMessageDialog(rootPane, "Invalid Bet Value!", "Error Message", JOptionPane.ERROR_MESSAGE);
	}

	// If quit button is pressed then return back
	// to main menu
	private void quit_btnMouseClicked() {
		this.setVisible(false);
		new MainMenu().setVisible(true);
	}

	/*
	 * When player hits then get a card and update players score and repaint the
	 * board. if the player has score > 21 then it is a bust. And for the next round
	 * if the players balance is 0 then return to the main menu and print the error
	 * for insufficient balance. However if it is 21 then it is a black jack and
	 * player wins its bet back
	 */

	private void hit_btnMouseClicked() {
		board.playerHit();
		playerName_lbl.setText(board.getPlayer().getName() + " : " + board.getPlayer().getScore());
		main_pnl.repaint();
		if (board.getPlayer().getScore() > 21) {
			processRequest(board.getPlayer().getBalance(), "BUST!");
			if (board.getPlayer().getBalance() == 0) {
				JOptionPane.showMessageDialog(rootPane, "You Lost, Your Balance is 0$!", "Error Message",
						JOptionPane.ERROR_MESSAGE);
				this.setVisible(false);
				new MainMenu().setVisible(true);
			}
		} else if (board.getPlayer().getScore() == 21)
			processRequest(
					board.getPlayer().getBalance() + betAmount + board.getDealer().getScore() != 21 ? (betAmount / 2)
							: 0,
					"BLACK-JACK!");
	}
	/*
	 * If stand button is pressed then dealer gets hit till his score is less than
	 * 21. If the dealer score is > 21 then it is a settlement if it is 21 and
	 * players score is also 21 then its a draw. If dealer is on 21 and player is
	 * under 21 then its a Bust again
	 */

	private void stand_btnMouseClicked() {
		while (board.getDealer().getScore() < 21)
			board.dealerHit();
		playerName_lbl.setText(board.getPlayer().getName() + " : " + board.getPlayer().getScore());
		main_pnl.repaint();
		if (board.getDealer().getScore() > 21)
			processRequest(board.getPlayer().getBalance() + betAmount * 2, "SETTLEMENT!");
		else if (board.getDealer().getScore() == 21) {
			if (board.getPlayer().getScore() == 21) {
				processRequest(board.getPlayer().getBalance() + betAmount, "DRAW!");
				return;
			}
			processRequest(board.getPlayer().getBalance(), "BUST!");
		}
	}

	/*
	 * As same code is repeated for each button pressed. There is  a function that
	 * gets recalled when to reset the board.
	 */

	private void processRequest(int newBalance, String roundMessage) {
		board.getPlayer().setBalance(newBalance);
		balance_lbl.setText(Integer.toString(newBalance));
		betAmount = 0;
		bet_lbl.setText("BET : 0$");
		isDealerTurn = true;
		dealerName_lbl.setText("DEALER : " + board.getDealer().getScore());
		main_pnl.repaint();
		JOptionPane.showMessageDialog(rootPane, roundMessage, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		hit_btn.setEnabled(false);
		stand_btn.setEnabled(false);
		bet_btn.setEnabled(true);
		bet_txt.setEnabled(true);
		board.resetBoard();
		dealerName_lbl.setText("DEALER");
		playerName_lbl.setText(board.getPlayer().getName());
		main_pnl.repaint();
	}

	/*
	 * Paints cards on the board
	 */

	private void paintCards(Graphics graphics) {
		int dealerCardXMargin = 0;
		int playerCardXMargin = 0;
		int cardMargin = 25;
		// Paint dealer cards
		// Draw card image with x and y
		for (Card card : board.getCurrentDealerCards()) {
			graphics.drawImage(card.getImage(),
					((display_pnl.getWidth() / 2) - (board.getCurrentDealerCards().size() * 50 / 2))
							+ dealerCardXMargin,
					display_pnl.getY() - 30, this);
			dealerCardXMargin += cardMargin;
			// if its not dealer turn then paint to back cover as 2nd
			if (!isDealerTurn) {
				graphics.drawImage(board.getDeck().getBackCover(),
						((display_pnl.getWidth() / 2) - (board.getCurrentDealerCards().size() * 50 / 2))
								+ dealerCardXMargin,
						display_pnl.getY() - 30, this);
				break;
			}
		}
		// paint player cards
		for (Card card : board.getCurrentPlayerCards()) {
			graphics.drawImage(card.getImage(),
					((display_pnl.getWidth() / 2) - (board.getCurrentPlayerCards().size() * 50 / 2))
							+ playerCardXMargin,
					display_pnl.getHeight() - 100, this);
			playerCardXMargin += cardMargin;
		}
	}

}
