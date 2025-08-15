package exception;

public class EmptyInputException extends Exception{ 
    public String message(){ 
        return "Field input tidak boleh kosong!"; 
    } 
} 
