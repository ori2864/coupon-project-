package Exceptions;
import lombok.Getter;
@Getter
public enum ErrMsg {
    WRONG_ADMIN_LOGIN("username or password incorrect"),
    ID_NOT_FOUND("id not found...."),
    COMPANY_ALREADY_EXISTS("Id already exists..."),
    CUSTOMER_ALREADY_EXISTS("this customer email already exists");

    private String msg;
    ErrMsg(String msg){this.msg=msg;}
}
