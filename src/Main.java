package io.calculus.logic;
public class Main
{
    void main()
    {
        display ob=new display();
        ob.displayrules();
        operations ob1= new operations();
        

        switch (ob.option)
        {
            case 1:       
                ob1.integration();
                break;
            case 2:
                ob1.differentiation();
                break;
             

        
        }

    }


    
}