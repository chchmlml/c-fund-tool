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

        https://xueqiu.com/service/screener/screen?
        // category=CN&
        //exchange=sh_sz&
        //areacode=&
        //indcode=&
        //order_by=
        //symbol&
        //order=desc&
        //page=1&size=30&
        //only_count=0&
        //current=&
        //pct=&
        //mc=&
        //volume=&_=1604027909585

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
//        paramMap.put("pct", "");
//        paramMap.put("pettm", "-13227.76_11283.7");
//        paramMap.put("pelyr", "-7505.12_5696.04");
//        paramMap.put("pb", "-170.5_315");

//        paramMap.put("roediluted.20200630", "-488.75_192.69");
//        paramMap.put("bps.20200630", "-15.44_109.24");
//        paramMap.put("eps.20200630", "-24.78_17.99");
//        paramMap.put("netprofit.20200630", "-29986000000_148790000000");
//        paramMap.put("dy_l", "0_18.18");
//        paramMap.put("psr", "-31.05_27158.18");
//        paramMap.put("mc", "71863724_2035027874022");

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
