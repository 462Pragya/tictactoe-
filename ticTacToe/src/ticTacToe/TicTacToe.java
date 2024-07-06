package ticTacToe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener  {
	Random random = new Random();
	JFrame frame =new JFrame();
	//JPanel title_panel1= new JPanel();
	JPanel title_panel= new JPanel();
    JPanel button_panel =new JPanel();
	JLabel textfield =new JLabel();
	JLabel title =new JLabel();
	JButton[] buttons=new JButton[9];
	JButton resetButton = new JButton();
	boolean player1_turn;
	boolean draw;
	
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,800);
		frame.getContentPane().setBackground(new Color (50,50,50));
		//frame.setLayout(null);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel,BorderLayout.CENTER);
		frame.add(resetButton,BorderLayout.SOUTH);
		//frame.add(title_panel1);
		
		    title.setBackground(new Color(244, 172, 183));
	        title.setForeground(new Color(84, 11, 14));
	        title.setFont(new Font("Ink Free", Font.BOLD,75));
	        title.setHorizontalAlignment(JLabel.CENTER);
	        //title.setVerticalAlignment(JLabel.CENTER);
	        title.setText("Tic-Tac-Toe");
	        title.setOpaque(true);
	        
	        //title_panel1.setLayout(new BorderLayout());
	        //title_panel1.setBounds(0, 0, 1000, 100);
	        //title_panel1.add(title);
		
        textfield.setBackground(new Color(255, 202, 212));
        textfield.setForeground(new Color(84, 11, 14));
        textfield.setFont(new Font("Ink Free", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setVerticalAlignment(JLabel.CENTER);
       // textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        
        title_panel.setLayout(new BorderLayout());
        //title_panel.setBounds(0, 100, 1000, 100);
        //title_panel.add(textfield);
        title_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        title_panel.add(title, BorderLayout.NORTH);
        title_panel.add(textfield, BorderLayout.SOUTH);
       
        button_panel.setLayout(new GridLayout(3,3,10,10));
        button_panel.setBackground(new Color(216, 226, 220));
        //button_panel.setBounds(0, 200, 1000, 400);
        button_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for(int i=0;i<9;i++) {
        	buttons[i]= new JButton();
        	button_panel.add(buttons[i]); 
        	buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
        	buttons[i].setFocusable(false);
        	buttons[i].addActionListener(this);
        	buttons[i].setBackground(new Color(242, 225, 225));
        	buttons[i].setBorder(BorderFactory.createEtchedBorder()); 
        	}
        
        resetButton.setFont(new Font("Ink Free", Font.BOLD,50));
        resetButton.setFocusable(false);
    	resetButton.addActionListener(this);
    	resetButton.setBackground(new Color(255, 229, 217));
    	resetButton.setForeground(new Color(84, 11, 14));
    	//resetButton.setBounds(0, 600, 1000, 100);
        resetButton.setText("Reset");
        resetButton.setHorizontalTextPosition(JButton.CENTER);
        resetButton.setBorder(BorderFactory.createEtchedBorder()); 
        
        firstTurn();
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			resetGame();
			return;
		}
		
		for(int i=0;i<9;i++) 
		{
			if(e.getSource() == buttons[i]) 
			{
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(230, 2, 2));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
					
				}
			
			else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(2, 230, 59));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
				    }
			    }
			}
		}	
	}
	public void firstTurn() {
		 try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn ");
			title.setText("Tic-Tac-Toe");
		}else {
			player1_turn=false;
			textfield.setText("O turn ");
			 title.setText("Tic-Tac-Toe");
		}
	}
	public void resetGame() {
		for(int i=0;i<9;i++) {
			buttons[i].setText("");
			buttons[i].setEnabled(true);
			buttons[i].setBackground(new Color(242, 225, 225));
		}
		firstTurn();
	}
	public void check() {
		// checks X win conditions
		if(
				(buttons[0].getText()=="X")&&
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")
		   ) 
		{
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X")
		   ) 
		{
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X")&&
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")
		   ) 
		{
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X")&&
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X")
		   ) 
		{
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X")
		   ) 
		{
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X")&&
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X")
		   ) 
		{
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[8].getText()=="X")
		   ) 
		{
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X")
		   ) 
		{
			xWins(2,4,6);
		}
		// checks O win conditions 
		if(
				(buttons[0].getText()=="O")&&
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O")
		   ) 
		{
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[5].getText()=="O")
		   ) 
		{
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O")&&
				(buttons[7].getText()=="O")&&
				(buttons[8].getText()=="O")
		   ) 
		{
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O")&&
				(buttons[3].getText()=="O")&&
				(buttons[6].getText()=="O")
		   ) 
		{
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[7].getText()=="O")
		   ) 
		{
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O")&&
				(buttons[5].getText()=="O")&&
				(buttons[8].getText()=="O")
		   ) 
		{
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[8].getText()=="O")
		   ) 
		{
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[6].getText()=="O")
		   ) 
		{
			oWins(2,4,6);
		}
		//checking for a tie
	    if (checkXWins()==true) {
	        
	    } else if (checkOWins()==true) {
	        
	    } else {
	        // Check for draw condition
	        boolean draw = true;
	        for (int i = 0; i < 9; i++) {
	            if (buttons[i].getText().equals("")) {
	                draw = false;
	                break;
	            }
	        }
	        if (draw) {
	            draw();
	        }
	    }
    }
		
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(new Color(2, 247, 145));
		buttons[b].setBackground(new Color(2, 247, 145));
		buttons[c].setBackground(new Color(2, 247, 145));
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			
		}
		textfield.setText("X wins");
		
	}
    public void oWins(int a,int b,int c) {
    	buttons[a].setBackground(new Color(2, 247, 145));
		buttons[b].setBackground(new Color(2, 247, 145));
		buttons[c].setBackground(new Color(2, 247, 145));
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			
		}
		textfield.setText("O wins");
		
		
	}
    public void draw() {
    	for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
			
		}
		textfield.setText("TIE");
		
		
	}
    public boolean checkXWins() {
    	if (
    	        (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) ||
    	        (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) ||
    	        (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) ||
    	        (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) ||
    	        (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) ||
    	        (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) ||
    	        (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) ||
    	        (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X"))
    	  )   {
    	        
    	        return true;
    	    }
    	    return false;
    	}
    public boolean checkOWins() {
    	if (
    			 (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) ||
    	            (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) ||
    	            (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) ||
    	            (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) ||
    	            (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) ||
    	            (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) ||
    	            (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) ||
    	            (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O"))
    	  )   {
    	        
    	        return true;
    	    }
    	    return false;
    	}
    }

