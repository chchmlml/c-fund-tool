package io.haicheng.cfundtool.api;

import cn.hutool.http.HttpUtil;
import io.haicheng.cfundtool.api.response.XueQiuResponse;
import io.haicheng.cfundtool.api.response.XueQiuResponseIndustries;
import io.haicheng.cfundtool.api.response.XueQiuResponseStocks;
import io.haicheng.cfundtool.utils.DateTimeUtil;
import io.haicheng.cfundtool.utils.JsonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * <p>Title: Danjuan</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/10/4 10:29 下午
 */
@Component("xueQiuApi")
public class XueQiuApi {

    private final static String urIndustries = "https://xueqiu.com/service/screener/industries";

    /**
     * 行业api
     */
    public static XueQiuResponse<XueQiuResponseIndustries> getIndustries() {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", "CN");
        paramMap.put("_", DateTimeUtil.getCurrentDateTimeStr());
        String result = HttpUtil.get(urIndustries, paramMap);
        XueQiuResponse<XueQiuResponseIndustries> data = JsonUtil.string2Obj(result, XueQiuResponse.class,
                XueQiuResponseIndustries.class);
        if (data.getErrorCode().equals(0)) {
            return data;
        }
        return null;
    }

    private final static String urStocks = "https://xueqiu.com/service/screener/screen";

    /**
     * 行业apis
     */
    public static XueQiuResponse<XueQiuResponseStocks> getStocks(Integer page, Integer size) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("category", "CN");
        paramMap.put("exchange", "sh_sz");
        paramMap.put("areacode", "");
        paramMap.put("indcode", "");
        paramMap.put("order_by", "symbol");
        paramMap.put("order", "desc");
        paramMap.put("page", page);
        paramMap.put("size", size);
        paramMap.put("only_count", "0");
        paramMap.put("current", "");
        paramMap.put("pct", "");
        paramMap.put("pettm", Long.MIN_VALUE + "_" + Long.MAX_VALUE);
        paramMap.put("pelyr", Long.MIN_VALUE + "_" + Long.MAX_VALUE);
        paramMap.put("pb", Long.MIN_VALUE + "_" + Long.MAX_VALUE);
        paramMap.put("netprofit.20200930", Long.MIN_VALUE + "_" + Long.MAX_VALUE);
        paramMap.put("ia.20200930", Long.MIN_VALUE + "_" + Long.MAX_VALUE);
        paramMap.put("ta.20200930", Long.MIN_VALUE + "_" + Long.MAX_VALUE);
        paramMap.put("goodwill", Long.MIN_VALUE + "_" + Long.MAX_VALUE);
        paramMap.put("_", DateTimeUtil.getCurrentDateTimeStr());
        String result = HttpUtil.get(urStocks, paramMap);
        XueQiuResponse<XueQiuResponseStocks> data = JsonUtil.string2Obj(result, XueQiuResponse.class,
                XueQiuResponseStocks.class);
        if (data.getErrorCode().equals(0)) {
            return data;
        }
        return null;
    }

}
