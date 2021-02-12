package pers.common.orgstruct.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String message;

    public BusinessException(){

    }

    public BusinessException(String message){
        this.message = message;
    }

    public BusinessException(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

}
