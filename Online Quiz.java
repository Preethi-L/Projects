package onlinequiz;
//importing the packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
//create class OnlineQuiz and extends by JFrame
class OnlineQuiz extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
        // create JLabel,JRadioButton,JButton on JFrame
	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext,btnBk,btnFwd,btnResult;
	ButtonGroup bg;
	int count = 0, question = 0,x=1,y=1,now=0;
        int m[] = new int[10];
	// create jFrame with radioButton and JButton
        //initializing the constructor
	OnlineQuiz(String s) {
            super(s);
             JOptionPane.showMessageDialog(this, "Welcome to online quiz\n    PANIMALAR INSTITUTE OF TECHNOLOGY\n                 Department of CSE  \n **Click OK to continue**" );
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
              
		for(int i=0 ;i<5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
                btnResult=new JButton("Submit");
                btnFwd=new JButton("<<Back");
		btnNext = new JButton("Next >>");
               btnBk = new JButton("Bookmark");
               btnFwd.addActionListener(this);
		btnNext.addActionListener(this);          
                btnBk.addActionListener(this);
                btnResult.addActionListener(this);
                add(btnFwd);
		add(btnNext);           
                add(btnBk);
                add(btnResult);
                set();
		
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
                btnFwd.setBounds(30,240,100,30);
		btnNext.setBounds(150, 240, 100, 30);
                btnBk.setBounds(270, 240, 100, 30);
                btnResult.setBounds(400,240,100,30);
                
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
        }
                    //submit button
        
	// override actionPerformed method and handle all the action performed
       @Override
       public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (choice())
				count = count + 1;
			question++;
			set();
			
                }
                if (e.getSource() == btnFwd) {
			if (choice())
				count = count - 1;
			question--;
			set();
			
                }
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = question;
			x++;
			question++;
			set();
			
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (choice())
					count = count + 1;
				now = question;
				question = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				question = now;
			}
		}
                  
		if (e.getActionCommand().equals("Submit")) {
			if (choice())
				count = count + 1;
			question++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
       }
	// set Questions with options
	void set() {
		radioButton[0].setSelected(true);
		if (question == 0) {
			label.setText("1) What are the OOPS concept in Java?");
			radioButton[0].setText("Abstraction");
			radioButton[1].setText("Encapsulation");
			radioButton[2].setText("Inheritance");
			radioButton[3].setText("All the above");
		}
		if (question == 1) {
			label.setText("2) Which of the following is not a Java features? ");
			radioButton[0].setText("Architecture neutral");
			radioButton[1].setText("Use of pointers");
			radioButton[2].setText("Dynamic");
			radioButton[3].setText("Object-oriented");
		}
		if (question == 2) {
			label.setText("3) How many layers are there in OSI model?");
			radioButton[0].setText("7");
			radioButton[1].setText("9");
			radioButton[2].setText("5");
			radioButton[3].setText("6");
		}
		if (question == 3) {
			label.setText("4) Which is used to find and fix bugs?");
			radioButton[0].setText("jre");
			radioButton[1].setText("jvm");
			radioButton[2].setText("jdb");
			radioButton[3].setText("jdk");
		}
		if (question == 4) {
			label.setText("5) Which of the following is a valid declaration of a char?");
			radioButton[0].setText("char ch = '\\utea';");
			radioButton[1].setText("char ca = 'tea';");
			radioButton[2].setText("char cr = \\u0223;");
			radioButton[3].setText("char cc = '\\itea';");
		}
		if (question == 5) {
			label.setText("6) Which of the following tool is used to generate API documentation?");
			radioButton[0].setText("javap tool");
			radioButton[1].setText("javaw command");
			radioButton[2].setText("Javadoc tool");
			radioButton[3].setText("javah command");
		}
		if (question == 6) {
			label.setText("7)  Which of the following for loop declaration is not valid?");
			radioButton[0].setText("for ( int i = 7; i <= 77; i += 7 )");
			radioButton[1].setText("for ( int i = 99; i >= 0; i / 9 )");
			radioButton[2].setText("for ( int i = 20; i >= 2; - -i )");
			radioButton[3].setText("for ( int i = 2; i <= 20; i = 2* i )");
		}
		if (question == 7) {
			label.setText("8) What is not the necessary conditions for deadlock?");
			radioButton[0].setText("Mutual Exclusion");
			radioButton[1].setText("Hold and wait");
			radioButton[2].setText("Preemption");
			radioButton[3].setText("Circular Queue");
		}
		if (question == 8) {
			label.setText("9)  Which package contains the Random class?");
			radioButton[0].setText("java.awt package");
			radioButton[1].setText("java.lang package");
			radioButton[2].setText("java.util package");
			radioButton[3].setText("java.io package");
		}
		if (question == 9) {
			label.setText("10) In System.out.print() what does System denote?");
			radioButton[0].setText("Variable");
			radioButton[1].setText("Object");
			radioButton[2].setText("Class");
			radioButton[3].setText("Method");
		}
	}
	// declaring right options
	boolean choice() {
		if (question == 0)
			return (radioButton[3].isSelected());
		if (question == 1)
			return (radioButton[1].isSelected());
		if (question == 2)
			return (radioButton[0].isSelected());
		if (question == 3)
			return (radioButton[2].isSelected());
		if (question == 4)
			return (radioButton[0].isSelected());
		if (question == 5)
			return (radioButton[3].isSelected());
		if (question == 6)
			return (radioButton[1].isSelected());
		if (question == 7)
			return (radioButton[2].isSelected());
		if (question == 8)
			return (radioButton[3].isSelected());
		if (question == 9)
			return (radioButton[2].isSelected());
		return false;
	}
        //main method
	public static void main(String s[]) {
            //calling constructor and initializing JFrame
            new OnlineQuiz("Online Quiz");  
		
	}
}
