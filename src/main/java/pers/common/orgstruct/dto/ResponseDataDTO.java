package pers.common.orgstruct.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用rest数据返回对象.
 */
@Getter
@Setter
@JsonPropertyOrder({"statusCode", "message", "total", "result"})
public class ResponseDataDTO<T> {
    private static final String SUCCESS = "SUCCESS";

    /**
     * 返回状态编码
     */
    private String statusCode = "SUCCESS";

    /**
     * 返回信息
     */
    @JsonInclude(Include.NON_NULL)
    private String message;

    /**
     * 数据
     */
    @JsonInclude(Include.NON_EMPTY)
    private  T result;

    /**
     * 总数
     */
    @JsonInclude(Include.NON_NULL)
    private long total;

    public ResponseDataDTO() {
    }

    public ResponseDataDTO(T body){
        this.statusCode = SUCCESS;
        this.result = body;
    }

    public ResponseDataDTO(T body, long total){
        this.statusCode = SUCCESS;
        this.result = body;
        this.total = total;
    }

    public ResponseDataDTO(T body, String code, String message){
        this.result = body;
        this.statusCode = code;
        this.message = message;
    }

    public static ResponseDataDTO ok(){
        return new ResponseDataDTO();
    }

    public static <T> ResponseDataDTO ok(T body){
        if(body instanceof Page){
            return new ResponseDataDTO(((Page) body).getRecords(),((Page) body).getTotal());
        }
        return new ResponseDataDTO(body);
    }

    public static <T> ResponseDataDTO ok(T body,long total){
        return new ResponseDataDTO(body,total);
    }

    /**
     * 部分成功
     * @param body
     * @param total
     * @param <T>
     * @return
     */
    public static <T> ResponseDataDTO partialOk(T body, String message){
        return new ResponseDataDTO(body,"PARTIAL_SUCCESS",message);
    }


    public static <T> ResponseDataDTO<T> error(String code, String message){
        return new ResponseDataDTO(null,code,message);
    }

    public static <T> ResponseDataDTO<T> error(T result, String code, String message){
        return new ResponseDataDTO(result,code,message);
    }

    @JsonIgnore
    public boolean isSuccess(){
        return "SUCCESS".equalsIgnoreCase(this.statusCode);
    }

    @JsonIgnore
    public boolean isFailed(){
        return !"SUCCESS".equalsIgnoreCase(this.statusCode) && !"PARTIAL_SUCCESS".equalsIgnoreCase(this.statusCode);
    }

    /**
     * 部分成功
     * @return
     */
    @JsonIgnore
    public boolean isPartialSuccess(){
        return "PARTIAL_SUCCESS".equalsIgnoreCase(this.statusCode);
    }

}
