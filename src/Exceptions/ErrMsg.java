package Exceptions;
import lombok.Getter;
@Getter
public enum ErrMsg {
    WRONG_ADMIN_LOGIN("username or password incorrect"),
    ID_NOT_FOUND("id not found...."),
    COUPON_DOES_NOT_EXIST("this coupon does not exist"),
    COUPON_IS_EXPIRED("this coupon is expired... sorry!"),
    CUSTOMER_ALREADY_EXISTS("this customer email already exists"),
    CUSTOMER_DOES_NOT_EXIST("this customer does not exist"),
    COMPANY_ALREADY_EXISTS("Id already exists..."),
    COMPANY_DOES_NOT_EXIST("this company does not exist");

    private String msg;
    ErrMsg(String msg){this.msg=msg;}
}
