package ht;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;


/**
 * Created by chengchengwang on 12/17/16.
 */
public class MinaPanel extends JPanel{
    int level=1;
    public final static int MAXLEVEL=3;
    private int x;
    private int y;
    //picture
    final Image pic[] = {
            new ImageIcon("pic/0.jpg").getImage(),
            new ImageIcon("pic/1.jpg").getImage(),
            new ImageIcon("pic/2.jpg").getImage(),
            new ImageIcon("pic/3.jpg").getImage(),
            new ImageIcon("pic/4.jpg").getImage(),
    };

    int temp_data[][];
    int data1[][];
    int data2[][];
    int data3[][];

    public MinaPanel(){
        level=1;
        data1 = new int[20][20];
        data2 = new int[20][20];
        data3 = new int[20][20];
        try {                                         //read file
            File file = new File("Map.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                    for (int i = 0; i < 20; i++) {
                        for (int j = 0; j < 20; j++) {
                            int a = scanner.nextInt();
                            data1[i][j]=a;
                        }
                    }

                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        int a = scanner.nextInt();
                        data2[i][j] = a;
                    }
                }
                System.out.println();
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        int a = scanner.nextInt();
                        data3[i][j] = a;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Problem reading the file. Please make sure the path is correct");
        }

        copydata(data1);
        init(level);
        x=3;
        y=4;
    }

    public void init(int level){          //switch different games
        this.level=level;
        switch (level){
            case 1:
                copydata(data1);
                break;
            case 2:
                copydata(data2);
                break;
            case 3:
                copydata(data3);
                break;
        }
        repaint();
    }

    public void copydata(int data[][]) {        //store data in a temporary two-dimentional arry
        temp_data = new int[20][20];
        int i, j;
        for (i = 0; i < 20; i++)
            for (j = 0; j < 20; j++) {
                temp_data[i][j] = data[i][j];
            }
    }
    public void select(String opr){            //change games
        x=3;
        y=4;
        if(opr.equals("First")){
            level =1;
        }
        else if(opr.equals("Prev")){
            if(level>1)
                level--;
            else
                level=1;
        }
        else if(opr.equals("Next")){
            if(level>=MAXLEVEL)
                level=MAXLEVEL;
            else
                level++;
        }
        else if(opr.equals("Last")){
            level=MAXLEVEL;
        }
        init(level);
    }

    public void move(int a){                 //mouse move
        switch (a){
            case 1:
                if(x>3&&temp_data[x-1][y]!=1){
                    x--;
                    temp_data[x+1][y]=2;
                    temp_data[x][y]=4;
                }
            break;
            case 2:
                if(y>4&&temp_data[x][y-1]!=1){
                    y--;
                    temp_data[x][y+1]=2;
                    temp_data[x][y]=4;
                }
                break;
            case 3:
                if(y<15&&temp_data[x][y+1]!=1){
                    y++;
                    temp_data[x][y-1]=2;
                    temp_data[x][y]=4;
                }
                break;
            case 4:
                if(x<14&&temp_data[x+1][y]!=1){
                    x++;
                    temp_data[x-1][y]=2;
                    temp_data[x][y]=4;
                }
                break;
            case 5:
                temp_data[x][y]=2;
                x=3;
                y=4;
                temp_data[x][y]=4;
                break;

        }
        repaint();
        if(x==14&&y==15){
            int s=JOptionPane.showConfirmDialog(null,"Congratulation!","",JOptionPane.CLOSED_OPTION);
        }

    }
    @Override
    public void paint(Graphics g){                     //paint map
        int left,top;
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                left = j*30;
                top=i*30;
                g.drawImage(pic[temp_data[i][j]],left,top,30,30,this);//picture, x, y, width, height, panel
            }
        }


    }
}
