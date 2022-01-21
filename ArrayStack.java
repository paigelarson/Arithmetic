
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ArrayStack implements Stack 
{
    ArrayList list= new ArrayList();
   
    public boolean isEmpty() {
        return list.isEmpty(); //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }


    public void push(Object x) 
    {
       list.add(x);
       //String push=JOptionPane.showInputDialog("please tell me what you would like to add to the stack");
    }


    public Object pop()
    {
        Object abc=list.get(list.size()-1);
        
        if(isEmpty()==true)
        throw new IllegalStateException("This stack is empty.");
        else
        {
            list.remove(abc);
            return abc;
            
        }
    }


    public Object peekTop() {
       
        Object ab;
        ab=list.get(list.size()-1);
        if(isEmpty()==true)
        throw new IllegalStateException("This stack is empty."); //To change body of generated methods, choose Tools | Templates.
        else
        {
            return ab;
        }    
    }

   public static void main(String[] args){
        
       ArrayStack branch= new ArrayStack();
   
       
       
       
       String abc;
       do
       {
        abc = JOptionPane.showInputDialog("Please choose and option:\n 1:check if stack is empty. \n 2:push (add to stack) \n 3:pop (return the last element in the stack then remove it) \n 4:peekTop (return the last element of the stack) ");
       boolean empty = branch.isEmpty();
    
       //while(abc.compareTo("5")<0)
       //{
      
        if (abc.equals("1") && empty==true)
                {
                    System.out.println( "I'm sorry, this stack is empty.Please use push to add to the stack.");
                }
        else if (abc.equals("1") && empty !=true)
        {
            System.out.println( "This stack is not empty.");
        }
        else if(abc.equals("2"))
               {
                  String push=JOptionPane.showInputDialog("please tell me what you would like to add to the stack");
                  branch.push(push);
                  System.out.println(push+ " is now the last element in the list");
               }
         else if(abc.equals("3") && empty==false)
               {
                   Object ap=branch.pop();
                   System.out.println("The last element in this stack was "+ap+". It has been removed");
               }  
         else if(abc.equals("3") && empty==true)
         {
             System.out.println( "I'm sorry, this stack is empty.Please use push to add to the stack.");
         }
         else if(abc.equals("4") && empty==false)
         {
             Object ab=branch.peekTop();
             System.out.println( "The last element in this stack is "+ab);
         }
         else if (abc.equals("4") && empty==true)
                {
                    System.out.println( "I'm sorry, this stack is empty.Please use push to add to the stack.");
   
       }
       }
        while(true);
      
      
      
      
      
       
  }
   }
         

