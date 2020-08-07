//***********************************************************
//  TextAnalyzerPanel.java
//
//  Dustin Kaban T00663749
//  COMP 1231 Module 5 Assignment 5 Question 1
//  August 5th, 2020
//
//  Creates the GUI for the TextAnalyzer program.  Here we create the panels, labels,
//  textArea and button to allow for user input and readability.
//***********************************************************

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TextAnalyzerPanel extends Panel
{
    //Scanner class will be used to parse the text
    Scanner scanner;

    //Initialize variables to 0, and create labels, textArea and button
    private int wordCount =0 ,characterCount = 0;
    private float averageWordLength = 0;
    private JLabel wordCountLabel,
            averageWordLengthLabel,
            characterCountLabel;
    private JTextArea textArea;
    private JButton calculateStatsButton;

    public TextAnalyzerPanel()
    {
        //Create 2 Panels, one for the stats, and one main panel to contain everything plus the stats
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel statsPanel = new JPanel(new BorderLayout());
        statsPanel.setBorder(BorderFactory.createTitledBorder("Statistics:"));

        //Create all the Labels and populate their initial information
        wordCountLabel = new JLabel("Words: " + wordCount);
        averageWordLengthLabel = new JLabel("  Average Word Length: " + averageWordLength);
        characterCountLabel = new JLabel("  Characters: " + characterCount);

        //Create the text area, and set a size so it looks nicer
        textArea = new JTextArea(10,20);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));

        //Create the button to be displayed
        calculateStatsButton = new JButton("Calculate Stats");
        calculateStatsButton.addActionListener(new CalculateStatsButtonListener());

        //Add all of the labels, textArea, and Button to their corresponding panels
        statsPanel.add(wordCountLabel,BorderLayout.WEST);
        statsPanel.add(averageWordLengthLabel,BorderLayout.CENTER);
        statsPanel.add(characterCountLabel,BorderLayout.EAST);
        mainPanel.add(textArea,BorderLayout.NORTH);
        mainPanel.add(statsPanel,BorderLayout.CENTER);
        mainPanel.add(calculateStatsButton,BorderLayout.SOUTH);
        //We create a statsPanel to control the stat layout and we then add it to the main panel
        mainPanel.add(statsPanel);
        mainPanel.setBorder(BorderFactory.createTitledBorder("Type Your Message into the Box below."));
        mainPanel.setPreferredSize(new Dimension(400,300));

        //We then add the main panel to the frame
        add(mainPanel);

        //Establish a proper size and color for the GUI
        //setPreferredSize(new Dimension(400, 400));
        setBackground(Color.lightGray);
    }

    public class CalculateStatsButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            //Use the scanner to scan for each word to add to the wordCount
            scanner = new Scanner(textArea.getText());
            ArrayList<String> wordList = new ArrayList<String>();

            //Initialize all the variables to 0
            wordCount = 0;
            averageWordLength = 0;
            characterCount = 0;

            //We want to loop through the words while there is still more words
            while(scanner.hasNext())
            {
                wordCount++;
                wordList.add(scanner.next());
            }

            //Get all the text in the text area
            String text = textArea.getText();

            //We want to keep track of the character count of the words
            //So we can calculate the average
            int totalLettersInWords = 0;
            for(int i=0;i<wordList.size();i++)
            {
                totalLettersInWords += wordList.get(i).length();
            }

            //Assign variables for user display
            characterCount = text.length();
            if(totalLettersInWords > 0)
            {
                averageWordLength = (float)totalLettersInWords/wordCount;
            }
            else
            {
                averageWordLength = 0;
            }

            //Set the label text to display correct information
            wordCountLabel.setText("Words: " + wordCount);
            averageWordLengthLabel.setText("  Average Word Length: "
                    + String.format("%.2f",averageWordLength));
            characterCountLabel.setText("  Characters: " + characterCount);
        }
    }
}
