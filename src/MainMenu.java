import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
    private void initComponents() {

        //======== this ========
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Black-Jack by Nibar & Raman");
        var contentPane = getContentPane();
        contentPane.setLayout(null);
    }
    
    
}