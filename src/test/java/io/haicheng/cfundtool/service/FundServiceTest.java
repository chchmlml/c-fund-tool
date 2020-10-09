package io.haicheng.cfundtool.service;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Fund;
import io.haicheng.cfundtool.utils.DateTimeUtil;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title: FundServiceTest</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:45 下午
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = CFundToolApplication.class)
public class FundServiceTest {

    @Autowired
    private FundService fundService;


    @Test
    public void testGetFundList() {
        Map<String, Object> lists = fundService.list(null, null, null);
        log.info("list {}", lists);

        Assert.assertNotNull(lists);
        Assert.assertNotNull(lists.get("total"));
        Assert.assertNotNull(lists.get("rows"));
    }

    /**
     *
     */
    @Test
    public void testSave() {
        Fund fund = new Fund();
        fund.setFundName("ceshi-fund-save");
        fund.setOutsideFund("10001");
        fund.setInsideFund("10002");
        fund.setScope("1亿");
        fund.setDesc("测试desc");
        fund.setBuildDate(DateTimeUtil.getCurrentDateStr());
        fundService.save(fund);
        Assert.assertNotNull(fund.getId());

        String updateFundName = "ceshi-fund-update";
        fund.setFundName(updateFundName);
        fund.setDesc("测试desc update");
        fundService.save(fund);

        ServiceVO updateFund = fundService.get(fund.getId());
        Fund fundGetOne = (Fund) updateFund.getInfo();
        Assert.assertEquals(fundGetOne.getFundName(), updateFundName);
    }

    @Test
    public void testGetFundByOutsideFund() {

        String outSideCode = "10001";
        Fund fund = fundService.getFundByOutsideFund(outSideCode);
        Assert.assertNotNull(fund);
        Assert.assertEquals(fund.getOutsideFund(), outSideCode);
    }

    @Test
    public void testDeleteFund() {

        String ids = "30";
        ServiceVO fund = fundService.delete(ids);
        Assert.assertNotNull(fund);
        Assert.assertEquals(fund.getCode(), 100);
    }

}

