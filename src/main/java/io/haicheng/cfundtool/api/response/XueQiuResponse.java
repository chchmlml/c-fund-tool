package io.haicheng.cfundtool.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>Title: DjResponse</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/10/4 10:47 下午
 */
@Data
public class XueQiuResponse<T> {

    private T data;

    @JsonProperty(value = "error_code")
    private Integer errorCode;

    @JsonProperty(value = "error_description")
    private String errorDescription;
}
