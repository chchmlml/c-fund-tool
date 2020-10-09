package io.haicheng.cfundtool.service;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Deal;
import io.haicheng.cfundtool.utils.DateTimeUtil;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title: dealServiceTest</p>
 * <p>Description: </p>
 *
 * @author haicheng
 * @Email haicheng@staff.weibo.com
 * @date 2020/9/28 3:45 下午
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = CFundToolApplication.class)
public class DealServiceTest {

    @Autowired
    private DealService dealService;


    @Test
    public void testGetList() {
        Map<String, Object> lists = dealService.list(null, null, null);
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
        Deal deal = new Deal();
        deal.setFundId(1);
        deal.setDate(DateTimeUtil.getCurrentDateStr());
        deal.setAmount(1000.0);
        dealService.save(deal);
        Assert.assertNotNull(deal.getId());

        Double updateAmount = 2000.0;
        deal.setAmount(updateAmount);
        dealService.save(deal);

        ServiceVO updateFund = dealService.get(deal.getId());
        Deal fundGetOne = (Deal) updateFund.getInfo();
        Assert.assertEquals(fundGetOne.getAmount(), updateAmount);
    }

    @Test
    public void testDelete() {

        String ids = "30";
        ServiceVO fund = dealService.delete(ids);
        Assert.assertNotNull(fund);
        Assert.assertEquals(fund.getCode(), 100);
    }

    @Test
    public void testGetCombox() {

        List<Map> fund = dealService.getComboboxList("1");
        Assert.assertNotNull(fund);
        String fundName = (String) fund.get(0).get("fundName");
        Assert.assertTrue(fundName.indexOf("1") != -1);
    }
}

