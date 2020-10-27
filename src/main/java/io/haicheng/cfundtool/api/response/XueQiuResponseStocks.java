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
public class XueQiuResponseStocks {

    @JsonProperty(value = "count")
    private Integer count;

    @JsonProperty(value = "list")
    private List<Item> list;

    @Data
    public static class Item {

        @JsonProperty(value = "pct")
        private Double pct;
        //股票代码
        @JsonProperty(value = "symbol")
        private String symbol;
        @JsonProperty(value = "pettm")
        private Double pettm;
        @JsonProperty(value = "pelyr")
        private Double pelyr;
        @JsonProperty(value = "type")
        private Integer type;
        @JsonProperty(value = "areacode")
        private String areacode;
        @JsonProperty(value = "tick_size")
        private Double tick_size;
        @JsonProperty(value = "has_follow")
        private Boolean has_follow;
        @JsonProperty(value = "current")
        private Double current;
        @JsonProperty(value = "pb")
        private Double pb;
        @JsonProperty(value = "name")
        private String name;
        @JsonProperty(value = "exchange")
        private String exchange;
        @JsonProperty(value = "indcode")
        private String indcode;
    }
}
