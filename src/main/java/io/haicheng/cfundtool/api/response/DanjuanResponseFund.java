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
public class DanjuanResponseFund {

    @JsonProperty(value = "fd_code")
    private String fdCode;

    @JsonProperty(value = "fd_full_name")
    private String fdFullName;

    @JsonProperty(value = "found_date")
    private String foundDate;

    @JsonProperty(value = "totshare")
    private String totshare;

}
