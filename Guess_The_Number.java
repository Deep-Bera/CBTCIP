package CipherByte;

import java.util.*;
import javax.swing.*;

public class Guess_The_Number
{
    public static void main(String[] args)
    {

        Random rand=new Random();
        int a=rand.nextInt(101);
        int c=1,b;
        do
        {
            b=Integer.parseInt(JOptionPane.showInputDialog("Enter your Guessed Number: "));
            if(b>a)
            {
                JOptionPane.showMessageDialog(null,"Please Enter Some Less Number");
            }
            else if(b<a)
            {
                JOptionPane.showMessageDialog(null,"Please Enter Some Greater Number");
            }
            else {
                JOptionPane.showMessageDialog(null, "Congratulations!!!!! You successfully" +
                        " guess the correct number \n Total Attempt taken:  " + c);
            }
            c++;
        }while((c!=15) && (b!=a));
        if(c==15)
        {
            JOptionPane.showMessageDialog(null,"SORRY!!!!!!!!!!!YOU Fail to guess the number " +
                    "within the Maximum attempts");
        }
    }
}
