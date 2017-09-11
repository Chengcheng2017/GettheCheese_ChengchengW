package ht;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by chengchengwang on 12/17/16.
 */
public class FrameMain extends JFrame implements ActionListener{

    JLabel Title;
    JButton btnReset, btnFirst, btnPrev, btnNext, btnLast, btnUp, btnRight, btnLeft, btnDown;
    JPanel eastPanel;
    MinaPanel mainPanel;
    Map a;

    public FrameMain() {
        a=new Map();
        a.write();
        Image icon = new ImageIcon("pic/blank.jpg").getImage();

        setIconImage(icon);
        setTitle("Maze Game");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        Title = new JLabel("Get the Cheese!", JLabel.CENTER);
        Title.setFont(new Font("Times new Roma", Font.BOLD, 36));
        add(Title, BorderLayout.NORTH);
        Title.setForeground(Color.DARK_GRAY);

        eastPanel = new JPanel(new GridLayout(15, 1, 10, 10));
        btnReset = new JButton("Reset");
        btnFirst = new JButton("First Game");
        btnPrev = new JButton("Preview Game");
        btnNext = new JButton("Next Game");
        btnLast = new JButton("Last Game");
        btnUp = new JButton("↑");
        btnLeft = new JButton("←");
        btnRight = new JButton("→");
        btnDown = new JButton("↓");


        eastPanel.add(btnReset);
        eastPanel.add(btnFirst);
        eastPanel.add(btnPrev);
        eastPanel.add(btnNext);
        eastPanel.add(btnLast);
        eastPanel.add(btnUp);
        eastPanel.add(btnLeft);
        eastPanel.add(btnRight);
        eastPanel.add(btnDown);

        //监听

        btnReset.addActionListener(this);
        btnFirst.addActionListener(this);
        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnLast.addActionListener(this);
        btnUp.addActionListener(this);
        btnLeft.addActionListener(this);
        btnRight.addActionListener(this);
        btnDown.addActionListener(this);

        add(eastPanel, BorderLayout.EAST);

        mainPanel = new MinaPanel();
        add(mainPanel);

        setSize(710, 660);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new FrameMain();

    }

    public void actionPerformed(ActionEvent e) {        //click button

    if(e.getSource()==btnReset)

    {
       mainPanel.move(5);
    }
        else if(e.getSource()==btnFirst)

    {
        mainPanel.select("First");
    }
        else if(e.getSource()==btnPrev)

    {
        mainPanel.select("Prev");
    }
    else if(e.getSource()==btnNext)

    {
        mainPanel.select("Next");
    }
    else if(e.getSource()==btnLast)

    {
        mainPanel.select("Last");
    }
    else if(e.getSource()==btnUp)

    {
        mainPanel.move(1);
    }
    else if(e.getSource()==btnLeft)

    {
        mainPanel.move(2);
    }
    else if(e.getSource()==btnRight)

    {
        mainPanel.move(3);
    }
    else if(e.getSource()==btnDown)

    {
        mainPanel.move(4);
    }
}

}

