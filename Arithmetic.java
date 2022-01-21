import javax.swing.JOptionPane;

/** 
 * The Arithmetic class receives an arithmetic expression in the form of a String
 * and evaluates it.  For example, if the class receives the String "5-4-3" it
 * prints the result -2.
 */
public class Arithmetic 
{

    ArrayStack n;
    ArrayStack o;
    String what;
    int prece;
    int pre;
    double fi; 
    int ab;
    //String oper;
    String two;
    String par;
    int right=0;
    int left=0;

               String zxc="";
               String whelp;
               int counter;
               int fin;
               
public Arithmetic()
{
	// TO DO: use 'new' to create the 2 ArrayStacks
     o= new ArrayStack();
     n=new ArrayStack();
    


}

/**
 * Returns the precedence of a given operator: ^ * / + -
 * @param s String whose precedence is to be determined
 * @return the String's precedence (an int)
 */
public int precedence(String s)
{
    
		if((s.equals("+"))||(s.equals("-")))
        {
            prece= 0;
        }

        else if((s.equals("*"))||(s.equals("/")))
        {
               prece= 1;     
        }
        else if((s.equals("^")))
        {
             prece= 2;
        }
   
   return prece;
}	

/**
 * figures out if the parameter is an operator
 * @param s the String which may be an operator
 * @return true if the parameter is an operator
 */
public boolean isOperator(String s)
{
        if(s.equals("^")||
          (s.equals("-"))||
          (s.equals("+"))||
          (s.equals("*"))||
          (s.equals("/")))
        {
            return true;
        }
        else
        {
            return false;
        }

}

/**
 * figures out if the parameter is a number
 * @param s the String which may be a number
 * @return true if the parameter is a number
 */
public boolean isNumber(String s)
{
    if(s.equals("1")||
       s.equals("2")||
       s.equals("3")||
       s.equals("4")||
       s.equals("5")||
       s.equals("6")||
       s.equals("7")||
       s.equals("8")||
       s.equals("9")||
       s.equals("0")
            )
    {
        return true;
    }
    else
    {
        return false;
    }
}

/**
 * figures out if the parameter is a space
 * @param s the String which may be a space
 * @return true if the parameter is a space
 */
public boolean isSpace(String s)
{
	if(s.equals(" "))
                {
                    return true;
                }
        else
        {
            return false;
        }
}

/**
 * performs the appropriate math and returns the result
 * @param firstS the first number in the calculation
 * @param secondS the second number in the calculation
 * @param oper the operator in the calculation
 * @return a String that is the result of the calculation
 */
public String doCalculation(String firstS, String oper, String secondS)
{
    
 
    double f = Double.parseDouble(firstS);
    double s = Double.parseDouble(secondS);
//int op=Integer.parseInt(oper);
    String op=String.valueOf(oper);
    if(op.equals("+"))
    {
        fi=f+s;
    }
    if(op.equals("-"))
    {
        fi=f-s;
    }
    if(op.equals("*"))
    {
        fi=f*s;
    }
    if(op.equals("/"))
    {
        fi=f/s;
    }
    if(op.equals("^"))
    {
        
        
        fi = Math.pow(f, s);
    }
    String fis = Double.toString(fi);
    return fis;
}

/**
 * this main method of the class evaluates the arithmetic expression
 * @param s String to be evaluated
 * @return the result of performing the calculation, in String form
 */
public String evaluateString(String s)
{
		for(int a=0;a<s.length(); a++)
                {
                    what=s.substring(a,a+1);
                    
                

                if(isNumber(what)== true)
                {
                    n.push(what);
                }
        //String nums=s.substring(a,a+1);
        
        if(s.length()-1>a)
        {
        two=s.substring(a+1,a+2);
           
        
        while((isNumber(two)==true)&&(isNumber(what)==true)&& (s.length()-1>a))
        {
           Object current= n.pop();
           String currentS=String.valueOf(current);
           
           String numb= currentS+two;
           n.push(numb);
            a++;
            what=two;
            if(s.length()-1>a)
            {
               two=s.substring(a+1,a+2);
            }
        }  
        }
        
		
		if(isSpace(what))
        {
            continue;
        }
	            
        
	if(isOperator(what)&& o.isEmpty())
        {
            o.push(what);
        }
        else if(isOperator(what)&& o.isEmpty()==false)
        {
            pre = precedence(what);
            Object asd=o.peekTop();
            ab=precedence(String.valueOf(asd)); 
            
            if(pre>ab)
            {
                
                o.push(what);
            }
            else{
                while(pre <= ab && o.isEmpty()==false)
                {                    
            pre = precedence(what);
            asd=o.peekTop();
            ab=precedence(String.valueOf(asd)); 
                    if (pre <= ab)
                    {
                    Object second= n.pop();
                    Object first= n.pop();
                    Object oper= o.pop();
                    
                    String firstS=String.valueOf(first);
                    String secondS=String.valueOf(second);
                    String ope=String.valueOf(oper);
                  
                    String yay=doCalculation(firstS,ope,secondS);
                    n.push(yay);
                    }

                }
                o.push(what);
                
            }   		

                    
                }
  // end for loop
		//o.push(oper);
	       
         if(what.equals("("))
         {
             left++;
             String zxc="";

                while(right!=left)  
                {
                whelp=s.substring(a+1,a+2);
               
                if(whelp.equals("("))
                {  
                   left++; 
               
                } 
                else if(whelp.equals(")"))
                {
                   right++;
                  
                }
                else if(left>0 && !whelp.equals(")") && !whelp.equals("("))
                {
                  zxc+=whelp; 
                  
                }
               a++;          
                }
         par=zxc.substring(0,zxc.length()); 
         Arithmetic abc= new Arithmetic();
         String ohs= abc.evaluateString(par);
         double oh;
                        oh = Double.parseDouble(ohs);
         n.push(oh);
         
        }
                }     
                
         
			
	
	        while(!o.isEmpty()) // && !n.isEmpty()
        {
            Object secd= n.pop();
            Object ft= n.pop();
            Object opr=o.pop();
            
            String f=String.valueOf(ft);
            String sec=String.valueOf(secd);
            String op=String.valueOf(opr);
            
            String res= doCalculation(f,op,sec);
            n.push(res);
            
        }
		String fin=(String) n.pop();
                return fin;
       
} 
	
public static void main(String[] args)
{
	Arithmetic a = new Arithmetic();
	String f = JOptionPane.showInputDialog("Which expression should I evaluate? ");
	String n = a.evaluateString(f);
	JOptionPane.showMessageDialog(null, "\"" + f + "\"" + " evaluates to " + n);
	System.out.println("\"" + f + "\"" + " evaluates to " + n);
}

}



