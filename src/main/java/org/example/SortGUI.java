package org.example; /**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the class with button and main method
public class SortGUI {

	// import javax.swing.JFrame;

	//a variable that holds the amount of time for the selection sort takes to execute
	public static double selectionTime = 0.0;
	//a variable that holds the amount of time for the recursive merge sort takes to execute
	public static double rmergeTime = 0.0;
	//a variable that holds the amount of time for the iterative merge sort takes to execute
	public static double imergeTime = 0.0;
	//TODO: Add rest of algo
	//a variable that holds the amount of time for the Bubble sort takes to execute
	public static double bubbleTime = 0.0;
	//a variable that holds the amount of time for the insertion sort takes to execute
	public static double insertionTime = 0.0;
	//a variable that holds the amount of time for the shell sort takes to execute
	public static double shellTime = 0.0;
	//Boolean variable that is made to keep track whether or not the selection sort has already been used
	public boolean Selection_Done = false;
	//Boolean variable that is made to keep track whether or not the recursive merge sort has already been used
	public boolean Recersive_Merge_Done = false;
	//Boolean variable that is made to keep track whether or not the iterative merge sort has already been used
	public boolean Iterative_Merge_Done = false;
	//TODO: Add rest of algo
	//Boolean variable that is made to keep track whether or not the bubble sort has already been used
	public boolean Bubble_Done = false;
	//Boolean variable that is made to keep track whether or not the insertion sort has already been used
	public boolean Insertion_Done = false;
	//Boolean variable that is made to keep track whether or not the shell sort has already been used
	public boolean Shell_Done = false;
	//Making a object from the class SortShow
	SortShow sortArea = new SortShow();
	
	//Default constructor for SortGUI
	public SortGUI() {
		//making a MyScreen object

		// You need to adjust the following values to your Screen dimensions

		MyScreen screen = new MyScreen();
		//Setting a title to the GUI window
		screen.setTitle("Assignment-1 by Abdelnasser Ouda");
		//setting the size of the window 
		screen.setSize(975+sortArea.total_number_of_lines, 450);
		//the operation when the frame is closed
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//is set to true to display the frame
		screen.setVisible(true);
	}
	//A public class that extends JFrame
	public class MyScreen extends JFrame {
		//making a scramble button with a text "Scramble Lines" on it
		JButton scramble_button = new JButton("Scramble Lines");
		//making a selection button with a text "Selection" on it
		JRadioButton selection = new JRadioButton("Selection");
		//making a recursive merge button with a text "Scramble Lines" on it
		JRadioButton rmerge = new JRadioButton("Merge Recursive");
		//making a iterative merge button with a text "Selection" on it
		JRadioButton imerge = new JRadioButton("Merge Iterative");
		//TODO: Add rest of algo
		//making a bubble sort button with a text "Bubble" on it
 		JRadioButton bubble = new JRadioButton("Bubble");
		//making a insertion sort button with a text "Insertion" on it
		JRadioButton insertion = new JRadioButton("Insertion");
		//making a shell sort button with a text "Insertion" on it
		JRadioButton shell = new JRadioButton("Shell");
		//making a reset button with a text "Selection" on it
		JRadioButton reset = new JRadioButton("Reset");
		//A label that displays the time it took for the Selection sort took to execute 
		JLabel selection_time_label = new JLabel("Selection Time");
		JLabel selection_time_taken = new JLabel(""); 
		//A label that displays the time it took for the recursive merge sort took to execute 
		JLabel rmerge_time_label = new JLabel("Merge-Rec Time");
		JLabel rmerge_time_taken = new JLabel("");
		//A label that displays the time it took for the iterative merge sort took to execute
		JLabel imerge_time_label = new JLabel("Merge-Ita Time");
		JLabel imerge_time_taken = new JLabel("");
		//TODO: Add rest of algo
		JLabel bubble_sort_label = new JLabel("Bubble");
		//A label that displays the time it took for the bubble sort took to execute
		JLabel bubble_time_taken = new JLabel("");
		JLabel insertion_sort_label = new JLabel("Insertion");
		//A label that displays the time it took for the bubble sort took to execute
		JLabel insertion_time_taken = new JLabel("");
		JLabel shell_sort_label = new JLabel("Shell");
		//A label that displays the time it took for the shell sort took to execute
		JLabel shell_time_taken = new JLabel("");
	
		//the default constructor for the class MyScreen
		public MyScreen() {
			// Panel where sorted lines_lengths will displayed
			//The time displayed for selection sort will be the colour red
			selection_time_taken.setForeground(Color.RED);
			//The time displayed for recursive merge sort will be the colour red
			rmerge_time_taken.setForeground(Color.RED);
			//The time displayed for iterative merge sort will be the colour red
			imerge_time_taken.setForeground(Color.RED);
			//TODO: Add rest of algo
			//The time displayed for bubble sort will be the colour red
			bubble_time_taken.setForeground(Color.RED);
			//The time displayed for insertion sort will be the colour red
			insertion_time_taken.setForeground(Color.RED);
			//The time displayed for shell sort will be the colour red
			shell_time_taken.setForeground(Color.RED);
			//The selection button text will be the colour blue
			selection.setForeground(Color.BLUE);
			//The recursive merge button text will be the colour blue
			rmerge.setForeground(Color.BLUE);
			//The iterative merge button text will be the colour blue
			imerge.setForeground(Color.BLUE);
			//TODO: Add rest of algo
			//The bubble sort button text will be the colour blue
			bubble.setForeground(Color.BLUE);
			//The insertion sort button text will be the colour blue
			insertion.setForeground(Color.BLUE);
			//The shell sort button text will be the colour blue
			shell.setForeground(Color.BLUE);
			//The scramble button's text will be blue
			scramble_button.setForeground(Color.BLUE);
			//setting the font of scramble button
			scramble_button.setFont(new Font("Arial", Font.BOLD, 15));
			//A Panel to hold the radio_button_selection and set the GridLayout
			JPanel radio_button_selection_Panel = new JPanel(new GridLayout(4, 1, 3, 3));

			//Adding the selection button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(selection);
			//Adding the recursive merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(rmerge);
			//Adding the iterative merge button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(imerge);
			//TODO: Add rest of algo
			//Adding the bubble sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(bubble);
			//Adding the insertion sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(insertion);
			//Adding the shell sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(shell);
			//Adding the reset button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(reset);
			//giving the radio_button_selection_Panel a border with a title 
			radio_button_selection_Panel.setBorder(new javax.swing.border.TitledBorder("Sort Algorithms"));

			//A Panel to hold the time_Panel and set the GridLayout
			JPanel time_Panel = new JPanel(new GridLayout(6, 1, 3, 3));
			//Adding the selection_time_label to the time_Panel
			time_Panel.add(selection_time_label);
			//Adding the selection_time_taken to the time_Panel
			time_Panel.add(selection_time_taken);
			//Adding the rmerge_time_label to the time_Panel
			time_Panel.add(rmerge_time_label); 
			//Adding the rmerge_time_taken to the time_Panel
			time_Panel.add(rmerge_time_taken);
			//Adding the imerge_time_label to the time_Panel
			time_Panel.add(imerge_time_label);
			//Adding the imerge_time_taken to the time_Panel
			time_Panel.add(imerge_time_taken);
			//TODO: Add rest of algo
			//Adding the buuble_sort_time_label to the time_Panel
			time_Panel.add(bubble_sort_label);
			//Adding the bubble_time_taken to the time_Panel
			time_Panel.add(bubble_time_taken);
			//Adding the insertion_sort_time_label to the time_Panel
			time_Panel.add(insertion_sort_label);
			//Adding the insertion_time_taken to the time_Panel
			time_Panel.add(insertion_time_taken);
			//Adding the shell_sort_time_label to the time_Panel
			time_Panel.add(shell_sort_label);
			//Adding the shell_time_taken to the time_Panel
			time_Panel.add(shell_time_taken);


			//A Panel to hold the buttons_area_Panel and set the GridLayout
			//This buttons_area_Panel will hold scrambleButton, radio_button_selection and the time_Panel
			JPanel buttons_area_Panel = new JPanel(new GridLayout(5, 1, 5, 5));
			//adding scramble_button to the buttons_area_Panel
			buttons_area_Panel.add(scramble_button);
			//adding radio_button_selection_Panel to the buttons_area_Panel
			buttons_area_Panel.add(radio_button_selection_Panel);
			//adding time_Panel to the buttons_area_Panel
			buttons_area_Panel.add(time_Panel);

			//placing the buttons_area_Panel to the east side of the window
			add(buttons_area_Panel, BorderLayout.EAST);
			//placing the sortArea object in the center of the window
			add(sortArea, BorderLayout.CENTER);
			//setting all booleans to false
			Set_Available_Chooses(false, false, false, false,false,false,false);

			//The following code is for creating a listener for each GUI element 

			//Creating an action listener for scramble button
			//This button will be used to scramble the lines in a random way
			//this same scrambled lines will be used for all threes sort methods used in this program
			scramble_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Scrambling the lines_lengths array
					sortArea.scramble_the_lines(); 
					//Since it has already been clicked, it will no longer be enabled
					scramble_button.setEnabled(false); 
					//setting all booleans true except for reset
					Set_Available_Chooses(true, true, true, true,true,true,false);
				}
			});

			//Creating an action listener for selection button
			selection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the selection sort method
					sortArea.SelectionSort(); 
					//Selection sort has finished/been clicked
					Selection_Done = true;
					//The amount of time taken for selection sort took
					selection_time_taken.setText(selectionTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					enableResetButton();
				}
			});

			//Creating an action listener for recursive merge button
			rmerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the recursive merge sort method
					sortArea.R_MergeSort();
					//The amount of time taken for recursive merge sort took
					rmerge_time_taken.setText((rmergeTime / 1000) + " Seconds");
					//recursive merge sort has finished/been clicked
					Recersive_Merge_Done = true;
					//setting all booleans false except for reset
					enableResetButton();
				}
			});
			
			//Creating an action listener for iterative merge button
			imerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the iterative merge sort method
					sortArea.I_MergeSort();
					//The amount of time taken for iterative merge sort took
					imerge_time_taken.setText((imergeTime / 1000) + " Seconds");
					//iterative merge sort has finished/been clicked
					Iterative_Merge_Done = true;
					//setting all booleans false except for reset
					enableResetButton();
				}
			});
			//TODO: Add rest of algo
			bubble.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//sorting array using bubble sort
					sortArea.BubbleSort();
					//The amount of time taken for bubble sort took
					bubble_time_taken.setText((bubbleTime / 1000) + " Seconds");
					//Bubble sort has finished/been clicked
					Bubble_Done = true;
					//setting all booleans false except for reset
					enableResetButton();
				}
			});

			insertion.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//sorting array using insertion sort
					sortArea.InsertionSort();
					//The amount of time taken for insertion sort took
					insertion_time_taken.setText((insertionTime / 1000) + " Seconds");
					//shell sort has finished/been clicked
					Insertion_Done = true;
					//setting all booleans false except for reset
					enableResetButton();

				}
			});

			shell.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//sorting array using shell sort
					sortArea.ShellSort();
					//The amount of time taken for shell sort took
					shell_time_taken.setText((shellTime / 1000) + " Seconds");
					//shell sort has finished/been clicked
					Shell_Done = true;
					//setting all booleans false except for reset
					enableResetButton();

				}
			});

			//TODO: Add rest of algo
			//Creating an action listener for reset button
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//disabling reset since it was clicked
					reset.setEnabled(false);
					//reseting the lines_lengths to its scrambled lines
					sortArea.reset();

					//There are many different combinations of what could be clicked 
					//The following code below covers all possibilities
					//FOr the following use the same comments as above 
					if (Selection_Done && Recersive_Merge_Done && Iterative_Merge_Done && Bubble_Done && Insertion_Done && Shell_Done) {
						//
						scramble_button.setEnabled(true);
						Recersive_Merge_Done = false;
						Iterative_Merge_Done = false;
						Selection_Done = false;
						Bubble_Done=false;
						Insertion_Done=false;
						Shell_Done=false;

						Set_Available_Chooses(false, false, false, false,false,false,false);

						selection_time_taken.setText("");
						rmerge_time_taken.setText("");
						imerge_time_taken.setText("");
						bubble_time_taken.setText("");
						insertion_time_taken.setText("");
						shell_time_taken.setText("");
					// if recursive_merge and iterative_merge done then disable those and enable selection and bubble
					}
					else{
						selection.setEnabled(!Selection_Done);
						rmerge.setEnabled(!Recersive_Merge_Done);
						imerge.setEnabled(!Iterative_Merge_Done);
						bubble.setEnabled(!Bubble_Done);
						insertion.setEnabled(!Insertion_Done);
					}



//					else if (Recersive_Merge_Done && Iterative_Merge_Done) {
//						Set_Available_Chooses(true, false, false, true,false);
//
//					} else if (Selection_Done && Recersive_Merge_Done) {
//
//						Set_Available_Chooses(false, false, true, false,false);
//
//					} else if (Selection_Done && Iterative_Merge_Done) {
//						Set_Available_Chooses(false, true, false, false,false);
//
//					} else if (Selection_Done) {
//						Set_Available_Chooses(false, true, true, false,false);
//
//					} else if (Recersive_Merge_Done) {
//						Set_Available_Chooses(true, false, true, false,false);
//
//					} else {
//						Set_Available_Chooses(true, true, false, false,false);
//
//					}
				}
			});

		}

		//TODO: Add rest of algo
		//A method that sets if the button are enabled or disabled
		public void Set_Available_Chooses(boolean selection_state, boolean rmerge_state, boolean imerge_state,
				boolean bubble_state,
				boolean insertion_state,
				boolean shell_state,
				boolean reset_state) {
			this.selection.setEnabled(selection_state);
			this.rmerge.setEnabled(rmerge_state);
			this.imerge.setEnabled(imerge_state);
			this.bubble.setEnabled(bubble_state);
			this.insertion.setEnabled(insertion_state);
			this.shell.setEnabled(shell_state);
			this.reset.setEnabled(reset_state);
		}

		public void enableResetButton(){
			Set_Available_Chooses(false, false, false, false,false,false,true);
		}
	}


	//The main method
	public static void main(String[] args) {
		//initialize the class
		SortGUI sort_GUI = new SortGUI();

	}

}


