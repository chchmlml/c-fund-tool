package io.haicheng.cfundtool.service;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Fund;
import io.haicheng.cfundtool.utils.DateTimeUtil;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
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

    /**
     *
     */
    @Test
    public void testSave() {
        Fund fund = new Fund();
        fund.setScope("10000");
        fund.setBuildDate(DateTimeUtil.getCurrentDateStr());

        fundService.save(fund);

        fund.setId(1);
        fundService.save(fund);
    }

    @Test
    public void testGetFundList() {
        Map<String, Object> lists = fundService.list(1, 20, null);
        log.info("list {}", lists);
    }

    @Test
    public void testGetFund() {
        ServiceVO data = fundService.get(1);
        log.info("data {}", data);
    }
}

