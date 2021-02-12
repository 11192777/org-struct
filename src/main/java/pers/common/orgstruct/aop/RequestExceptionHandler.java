package pers.common.orgstruct.aop;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.common.orgstruct.dto.ResponseDataDTO;
import pers.common.orgstruct.exception.BusinessException;

/**
 * 统一异常处理
 */
@RestControllerAdvice
public class RequestExceptionHandler {

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseDataDTO handleBusinessException(BusinessException e){
        //TODO 处理code翻译
        e.printStackTrace();
        return ResponseDataDTO.error(e.getErrorCode(),e.getMessage());
    }
}
