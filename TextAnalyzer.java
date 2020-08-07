//***********************************************************
//  TextAnalyzer.java
//
//  Dustin Kaban T00663749
//  COMP 1231 Module 5 Assignment 5 Question 1
//  August 5th, 2020
//
//  This class is the main driver for our TextAnalyzer GUI project.
//  It creates the frame, initializes the panel, and makes it visible.
//***********************************************************

import javax.swing.JFrame;

public class TextAnalyzer
{
    public static void main(String[] args)
    {
        //Setting up the frame
        JFrame frame = new JFrame("Text Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TextAnalyzerPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
