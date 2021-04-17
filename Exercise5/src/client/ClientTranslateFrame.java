package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import javax.swing.Box;
import java.awt.Component;

/**
 * This class represent the window for the client side TCP application.
 * It display the date retrieve from the server.
 * 
 * @author emalianakasmuri
 *
 */
public class ClientTranslateFrame extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblServerText;
	private JLabel lblStatusValue;
	
	// Private attributes for frame size
	private int width = 700;
	private int height = 300;
	
	
	private String requestText;
	private String requestLanguage;

	 public JComboBox comboBox ;
	 public JComboBox cb;
	    
	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public ClientTranslateFrame() {
		
		// Default frame setting
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("TCP Application: Client Side");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
		lblServerText = new JLabel("-");
		lblStatusValue = new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	/**
	 * This method update the value of date on the frame
	 * 
	 * @param serverDate: Server's date
	 */
	public void updateServerText (String text) {
		
		this.lblServerText.setText(text);
		
	}
	
	/**
	 * This method update the status of connection to the server.
	 * 
	 * @param connStatus: Connection status (true/false)
	 */
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	
	/**
	 * This method creates and arrange Swing components to display status of 
	 * client's connection to the server.
	 * 
	 * @param font
	 * @return Swing components organized in a panel.
	 */
	
	
	private JPanel getConnectionStatusPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");
		
		
		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);
		
		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		
		return panel;
		
	}
	
	private JPanel middlePanel(Font font) {
		
		JPanel panel = new JPanel();
		//FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		
		String choice[] = {"Good morning","Good night","How are you?","Thank you","Goodbye","What’s up?"};
		String language[] = {"Bahasa Malayu", "Arabic", "korea"};
		    
		    Box verticalBox = Box.createVerticalBox();
		    verticalBox.setPreferredSize(new Dimension(100, 100));
		    panel.add(verticalBox);
		    JLabel lblConnStatus = new JLabel ("Choose a text: ");
		    lblConnStatus.setMaximumSize(new Dimension(100, 20));
		    verticalBox.add(lblConnStatus);
		    
		    Component verticalStrut = Box.createVerticalStrut(20);
		    verticalStrut.setMinimumSize(new Dimension(30, 20));
		    verticalStrut.setMaximumSize(new Dimension(30, 20));
		    verticalStrut.setVisible(false);
		    verticalBox.add(verticalStrut);
		    
		    JLabel lblNewLabel = new JLabel("Language");
		    verticalBox.add(lblNewLabel);
		    lblNewLabel.setPreferredSize(new Dimension(60, 20));
		    lblNewLabel.setMinimumSize(new Dimension(60, 20));
		    lblNewLabel.setMaximumSize(new Dimension(100, 20));
		    
		    Box verticalBox_1 = Box.createVerticalBox();
		    verticalBox_1.setPreferredSize(new Dimension(150, 100));
		    panel.add(verticalBox_1);
		    cb=new JComboBox(choice);    
		    cb.setMaximumSize(new Dimension(150, 20));
		    cb.setPreferredSize(new Dimension(150, 20));
		    verticalBox_1.add(cb);
		    cb.setBounds(50, 100,90,20);
		    
		    Component verticalStrut_1 = Box.createVerticalStrut(20);
		    verticalStrut_1.setMinimumSize(new Dimension(30, 20));
		    verticalStrut_1.setMaximumSize(new Dimension(30, 20));
		    verticalStrut_1.setVisible(false);
		    verticalBox_1.add(verticalStrut_1);
		    
		    comboBox = new JComboBox(language);
		    comboBox.setMaximumSize(new Dimension(150, 20));
		    verticalBox_1.add(comboBox);
		   
		    
		    JButton btnNewButton = new JButton("Translate");
		    panel.add(btnNewButton);
		    btnNewButton.addActionListener(this);	
			
			
		

		
		return panel;
		
	}
	/**
	 * This method creates and arrange Swing components to date retrieve from 
	 * the server.
 	 *
	 * @param font
	 * @return Swing components organized in panel
	 */
	private JPanel getServerDatePanel(Font font) {
		
		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblDate = new JLabel ("Translated Text (from Server): ");
		panel.add(lblDate);
		
				// Style the component
				lblDate.setFont(font);
				lblDate.setBackground(Color.WHITE);
				lblDate.setOpaque(true);
		lblServerText.setFont(font);
		lblServerText.setBackground(Color.WHITE);
		lblServerText.setOpaque(true);
		panel.add(lblServerText);
		
		return panel;
	} 
	
	
	/**
	 * This method arrange the Swing components on the frame.
	 */
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		getContentPane().add(northPanel, BorderLayout.NORTH);
		JPanel ComboPanel = this.middlePanel(font);		
		getContentPane().add(ComboPanel, BorderLayout.CENTER);
		// Get server date's panel and add to frame
		JPanel center = getServerDatePanel(font);
		getContentPane().add(center, BorderLayout.SOUTH);
		
	}
	
	
	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}
	
	//specially change font to display korean word
		public void setKoreanFont()
		{
			lblServerText.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		}
		
		
	public String getlanguage() {
		
		return this.requestLanguage;
	}
	public String gettext() {
		
		return this.requestText;
	}


	public void waitForInputs() throws InterruptedException {
	    synchronized (this) {
	        // Make the current thread waits until a notify or an interrupt
	        wait();
	    }
	}
	
	    public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 requestText = (String) cb.getSelectedItem(); 
			 requestLanguage = (String) comboBox.getSelectedItem();
			 
			 if( requestLanguage != "" && requestText != "");
				{
					//after hitting the button, frame can close by X
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
					synchronized (this) {
					 // Release the waiting threads
				        notifyAll();
				    }
	
}
	}
}
