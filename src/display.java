//var operation stores operation number to be performed 
//currently only supports differentiation & integration others to be added subsequently
//1=integration
//2=diff

package io.calculus.logic;
import java.util.*;
public class display
{
    int option=0;
    int displayrules()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input an option for operation to be performed:use LOWER CASE only");
        System.out.println("integration/differentiation");
        String input=sc.nextLine();
        if(input.contains("integration"))
        option=1;
        if(input.contains("differentiation"))
        option=2;
        
        if(option!=0)
        {
        System.out.println("enter expression:y=func(x)");
        System.out.println("y=");
        String expression=sc.nextLine();
        }
        else
        System.out.println("invalid input");
        
        return option;
    }
}