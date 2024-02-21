package Exceptions;



public class sqlCustomException extends Exception{
    public sqlCustomException(ErrMsg errMsg){
        super (errMsg.getMsg());
    }
}
