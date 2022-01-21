

public interface Stack 
{ 
    // postcondition: returns true if stack is empty, false otherwise 
  boolean isEmpty();
  
    // precondition:  stack is [e1, e2, ..., en] with n >= 0 
    // postcondition: stack is [e1, e2, ..., en, x] 
  void push(Object x); 

    // precondition:  stack is [e1, e2, ..., en] with n >= 1 
    // postcondition: stack is [e1, e2, ..., e(n-1)]; returns en 
    //                 throws an unchecked exception if the stack is empty 
  Object pop();

    // precondition:  stack is [e1, e2, ..., en] with n >= 1 
    // postcondition: returns en 
    //                 throws an unchecked exception if the stack is empty 
  Object peekTop(); 
} 
