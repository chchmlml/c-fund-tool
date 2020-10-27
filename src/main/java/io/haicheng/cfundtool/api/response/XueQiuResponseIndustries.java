package io.haicheng.cfundtool.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class XueQiuResponseIndustries {

    @JsonProperty(value = "industries")
    private List<Item> industries;

    @Data
    public static class Item {

        @JsonProperty(value = "encode")
        private String encode;
        @JsonProperty(value = "name")
        private String name;
        @JsonProperty(value = "pinyin")
        private String pinyin;
    }
}
