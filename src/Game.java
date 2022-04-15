import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

    public Game(String name, int balance) {
        isDealerTurn = false;
        betAmount = 0;
        board = new Board(name, balance);
        main_pnl = new JPanel();
        display_pnl = new JPanel() {
            public void paint(Graphics graphics) {
                paintCards(graphics);
            }
        };
    }
}