package io.haicheng.cfundtool.api;

import cn.hutool.http.HttpUtil;
import io.haicheng.cfundtool.api.response.DanjuanResponse;
import io.haicheng.cfundtool.api.response.DanjuanResponseFund;
import io.haicheng.cfundtool.api.response.DanjuanResponseFundDesc;
import io.haicheng.cfundtool.api.response.DanjuanResponseValuations;
import io.haicheng.cfundtool.utils.JsonUtil;

/**
 * <p>Title: Danjuan</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/10/4 10:29 下午
 */
public class DanjuanApi {

    private final static String urValuationsl = "https://danjuanfunds.com/djapi/fundx/activity/user/vip_valuation/show/detail?source=lsd";

    /**
     * 指数推荐页面api
     */
    public static DanjuanResponse getIndexCollect() {

        String result = HttpUtil.get(urValuationsl);
        DanjuanResponse<DanjuanResponseValuations> data = JsonUtil.string2Obj(result, DanjuanResponse.class,
                DanjuanResponseValuations.class);
        if (data.getResultCode().equals(0)) {
            return data;
        }
        return null;
    }

    private final static String urlFund = "https://danjuanfunds.com/djapi/fund/%s";

    /**
     * 基金页面api
     */
    public static DanjuanResponse<DanjuanResponseFund> getFundDetail(String code) {

        String result = HttpUtil.get(String.format(urlFund, code));
        DanjuanResponse<DanjuanResponseFund> data = JsonUtil.string2Obj(result, DanjuanResponse.class,
                DanjuanResponseFund.class);
        if (data.getResultCode().equals(0)) {
            return data;
        }
        return null;
    }

    private final static String urlFundDesc = "https://danjuanfunds.com/djapi/fund/detail/%s";

    /**
     * 基金页面api
     */
    public static DanjuanResponse<DanjuanResponseFundDesc> getFundDetailDesc(String code) {

        String result = HttpUtil.get(String.format(urlFundDesc, code));
        DanjuanResponse<DanjuanResponseFundDesc> data = JsonUtil.string2Obj(result, DanjuanResponse.class,
                DanjuanResponseFundDesc.class);
        if (data.getResultCode().equals(0)) {
            return data;
        }
        return null;
    }
}
