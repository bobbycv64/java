package cv64.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ScreenMatrix extends JFrame implements ActionListener {

	public ScreenMatrix(String title) {

		super(title);
		setBackground(backgroundColor_);

		menuLayout();
		gridLayout();
	}

	public void menuLayout() {

		menuBar_.add(menu1_);
		menuBar_.add(menu2_);
		menu1_.add(menu1Item1_);
		menu2_.add(menu2Item1_);
		menu2_.add(menu2Item2_);

		menu1Item1_.addActionListener(this);
		menu2Item1_.addActionListener(this);
		menu2Item2_.addActionListener(this);

		setJMenuBar(menuBar_);
	}

	public void gridLayout() {

		//Changes the look and feel to the system defaults
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exception) {
			System.err.println("Error loading Look & Feel: " + exception);
		}

		GridBagLayout gridBagLayout = new GridBagLayout();

		JPanel panelRight = new JPanel();

		container_.setLayout(gridBagLayout);
		panelRight.setLayout(gridBagLayout);

    // Menu bar on top
//    constraint.constrain( container_, menuBar, 0, 0, 2, 1, 0.0, 0.0 );

    // Message panel on the bottom
//    constraint.constrain( container_, ( new JScrollPane( textArea ) ),  0, 3, 2, 1, 0.1, 0.1 );


    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();

//    // Setting up lowest split screen
/*    constraint.constrain( cp, ( new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,
                                ( new JScrollPane( leftPanel ) ),
                                ( new JScrollPane( rightPanel ) ) ) ), 0, 0, 2, 3 );
*/
    // Setting up leftPanel
//    constraint.constrain( leftPanel,partPanel,0,0,1,1,0.1, 0.1 );

    // Left and Right panels with split pane
//    constraint.constrain( cp,( new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,
//                                ( new JScrollPane( partPanel ) ),
//                                ( new JScrollPane( new JPanel()) ) ) ), 0, 0, 2, 2 );
////    BomPanel bomPanel = new BomPanel();
//    constraint.constrain( cp, ( new JSplitPane( JSplitPane.HORIZONTAL_SPLIT,
//                                ( new JScrollPane( panelRight ) ),
//                                ( new JScrollPane( panelRight ) ) ) ), 0, 1, 2, 2 );
//
//    Display display = new Display();
//    Routing routing = display.populateObjects();
//    RoutingDisplay routingDisplay = new RoutingDisplay( display, routing );
//
//    RoutingPanel routingPanel = new RoutingPanel();
//    routingPanel.setPreferredSize( new Dimension( 1000, 800 ) );
//


//    JScrollPane topPane =    new JScrollPane( routingDisplay,
//                                 JScrollPane.VERTICAL_SCROLLBAR_NEVER,
//                                 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
//
//    JScrollPane bottomPane = new JScrollPane( routingPanel,
//                                 JScrollPane.VERTICAL_SCROLLBAR_NEVER,
//                                 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );

//    constraint.constrain( panelRight, ( new JSplitPane( JSplitPane.VERTICAL_SPLIT,
//                                        topPane, bottomPane ) ), 0, 0, 1, 2 );
	}

	public Dimension getPreferredSize() {
		return new Dimension(900, 700);
	}

	public void actionPerformed(ActionEvent event) {

		Icon icon;
		Object object = event.getSource();

		// Exit
		if(object == menu1Item1_) System.exit(0);

		// Information - Developers
		else if(object == menu2Item1_) {
    			icon = new ImageIcon("images/java.gif");
     			String [] developers = {" Software Developers ",
			" ",
			" Robert Estey ",
			" "};

			JOptionPane.showMessageDialog(this, developers,
				getTitle(), JOptionPane.PLAIN_MESSAGE, icon );
		}

		// Information - About
		else if(object == menu2Item2_) {
    			icon = new ImageIcon("images/cv64.gif");
			String [] about = {" Demo ",
				" ",
				" cv64 ",
				" ",
				" 2001 April 25 ",
				" "};

			JOptionPane.showMessageDialog(this, about,
				getTitle(), JOptionPane.PLAIN_MESSAGE, icon);
		}
	}

	public static void main(String[] args) {

		ScreenMatrix screenMatrix = new ScreenMatrix("Frame Example");
		screenMatrix.pack();
		screenMatrix.setVisible(true);

		screenMatrix.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}

	private final Color backgroundColor_ = Color.white;
	private Container container_;
	private final JMenuBar menuBar_ = new JMenuBar();
	private final JMenu menu1_ = new JMenu("Control");
	private final JMenu menu2_ = new JMenu("Information");
	private final JMenuItem menu1Item1_ = new JMenuItem( "Exit" );
	private final JMenuItem menu2Item1_ = new JMenuItem( "Developers" );
 	private final JMenuItem menu2Item2_ = new JMenuItem( "About" );
	public static JTextArea textArea_;
}
