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
public class DanjuanResponseValuations {

    private Integer id;
    private String periods;
    private String status;
    private String time;
    private String comment;
    private String grade;
    private List<Valuations> valuations;

    @Data
    public static class Valuations {

        private Integer id;

        @JsonProperty(value = "relation_id")
        private Integer relationId;
        /**
         * 指数估值说明： 1：估值较低，适合开始定投的品种 2：估值适中，可以观望 3：估值较高，谨慎投资
         */

        @JsonProperty(value = "valuation_status")
        private String valuationStatus;
        /**
         * 指数名称
         */
        @JsonProperty(value = "index_name")
        private String indexName;
        /**
         * 指数代码
         */
        @JsonProperty(value = "index_code")
        private String indexCode;
        /**
         * 市盈率
         */
        private Double pe;
        /**
         * 市净率
         */
        private Double pb;
        /**
         * 场内基金
         */
        @JsonProperty(value = "inside_fund")
        private String insideFund;

        /**
         * 场外基金
         */
        @JsonProperty(value = "outside_fund")
        private String outsideFund;
        /**
         * 净资产收益率
         */
        private Double roe;
        /**
         * 股息率
         */
        @JsonProperty(value = "dividend_yield")
        private Double dividendYield;
        /**
         * 盈利收益率
         */
        @JsonProperty(value = "profit_yield")
        private Double profitYield;
    }

}
