import java.awt.BorderLayout;

import java.awt.CardLayout;

import java.awt.EventQueue;

import java.awt.FlowLayout;

import java.awt.HeadlessException;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import java.awt.Color;




public class SlideShow extends JFrame {



	//Declare Variables

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel slidePane;

	private JPanel textPane;

	private JPanel buttonPane;

	private CardLayout card;

	private CardLayout cardText;

	private JButton btnPrev;

	private JButton btnNext;

	private JLabel lblSlide;

	private JLabel lblTextArea;



	/**

	 * Create the application.

	 */

	public SlideShow() throws HeadlessException {

		initComponent();

	}



	/**

	 * Initialize the contents of the frame.

	 */

	private void initComponent() {

		//Initialize variables to empty objects

		card = new CardLayout();

		cardText = new CardLayout();

		slidePane = new JPanel();

		textPane = new JPanel();
		
		// changed textPane background color to white 

		textPane.setBackground(Color.WHITE);

		textPane.setBounds(0, 460, 790, 50);

		textPane.setVisible(true);

		buttonPane = new JPanel();

		btnPrev = new JButton();

		btnNext = new JButton();

		lblSlide = new JLabel();

		lblTextArea = new JLabel();
		
		
		//Setup frame attributes

		setSize(800, 600);

		setLocationRelativeTo(null);

		setTitle("Top 5 Destinations SlideShow");
		
		//adjusted layout

		getContentPane().setLayout(new BorderLayout(10, 50));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		//Setting the layouts for the panels

		slidePane.setLayout(card);

		textPane.setLayout(cardText);

		

		//logic to add each of the slides and text

		for (int i = 1; i <= 5; i++) {

			lblSlide = new JLabel();

			lblTextArea = new JLabel();

			lblSlide.setText(getResizeIcon(i));

			lblTextArea.setText(getTextDescription(i));

			slidePane.add(lblSlide, "card" + i);

			textPane.add(lblTextArea, "cardText" + i);

		}



		getContentPane().add(slidePane, BorderLayout.CENTER);

		getContentPane().add(textPane, BorderLayout.SOUTH);



		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));



		btnPrev.setText("Previous");

		btnPrev.addActionListener(new ActionListener() {



			@Override

			public void actionPerformed(ActionEvent e) {

				goPrevious();

			}

		});

		buttonPane.add(btnPrev);



		btnNext.setText("Next");

		btnNext.addActionListener(new ActionListener() {



			@Override

			public void actionPerformed(ActionEvent e) {

				goNext();

			}

		});

		buttonPane.add(btnNext);
		
		

		getContentPane().add(buttonPane, BorderLayout.SOUTH);

	}



	/**

	 * Previous Button Functionality

	 */

	private void goPrevious() {

		card.previous(slidePane);

		cardText.previous(textPane);

	}

	

	/**

	 * Next Button Functionality

	 */

	private void goNext() {

		card.next(slidePane);

		cardText.next(textPane);

	}



	/**

	 * Method to get the images

	 */
	
	// Modified and uploaded new images to meet the new requirement 

	private String getResizeIcon(int i) {

		String image = ""; 

		if (i==1){
			
			//changed the font size of slide show text
			//added more descriptive text and images

			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Death_Valley.jpg") + "'</body></html>";

		} else if (i==2){

			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Cannabis_Fields_Morocco.jpg") + "'</body></html>";

		} else if (i==3){

			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Hike_up_@_Aberdares.jpg") + "'</body></html>";

		} else if (i==4){

			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Hikers_on_Titicaca.jpg") + "'</body></html>";

		} else if (i==5){

			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Jablanica_Mountain.jpg") + "'</body></html>";

		}

		return image;

	}

	

	/**

	 * Method to get the text values

	 */
	
 // added descriptive text 

	private String getTextDescription(int i) {

		String text = ""; 

		if (i==1){

			text = "<html><body><font size='5'> 1. Death Valley in Death Valley National Park in California, United States.</font> " + "<br>View from Zabriskie Point with people hiking.</body></html>";

		} else if (i==2){

			text = "<html><body><font size='5'> Herbs field in Morocco. </font> " +  "<br> If you enjoy herbs and plants for a sense of relaxation,  .</body></html>";

		} else if (i==3){

			text = "<html><body><font size='5'> 3. Group Hiking at Aberdares. </font> " + "<br> If you enjoy hiking and socializing with people, this is a trip for you, location in Aberdares forest.</body></html>";

		} else if (i==4){

			text = "<html><body><font size='5'> 4. Lake Titicaca. </font> " + "<br> Spectacular hiking environment for a sense of relaxation and beautiful views, this is a trip for you .</body></html>";
					
					
		} else if (i==5){

			text = "<html><body><font size='5'> 5. Jablanica Mountain. </font> " + "<br> If you enjoy hiking in cold environment for a sense of relaxation and wellness.</body></html>";

		}

		return text;

	}

	

	/**

	 * Launch the application.

	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {



			@Override

			public void run() {

				SlideShow ss = new SlideShow();

				ss.setVisible(true);

			}

		});

	}

}