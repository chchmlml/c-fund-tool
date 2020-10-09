package io.haicheng.cfundtool.service;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Index;
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
public class IndexServiceTest {

    @Autowired
    private IndexService service;


    @Test
    public void testGetList() {
        Map<String, Object> lists = service.list(null, null, null);
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
        Index index = new Index();
        index.setName("ceshiindex");
        index.setCode("CS111");
        service.save(index);
        Assert.assertNotNull(index.getId());

        String updateFundName = "ceshi-fund-update";
        index.setName(updateFundName);
        service.save(index);

        ServiceVO updateFund = service.get(index.getId());
        Index fundGetOne = (Index) updateFund.getInfo();
        Assert.assertEquals(fundGetOne.getName(), updateFundName);
    }

    @Test
    public void testDelete() {

        String ids = "30";
        ServiceVO fund = service.delete(ids);
        Assert.assertNotNull(fund);
        Assert.assertEquals(fund.getCode(), 100);
    }


    @Test
    public void testGetByCode() {

        String outSideCode = "CS111";
        Index fund = service.getByCode(outSideCode);
        Assert.assertNotNull(fund);
        Assert.assertEquals(fund.getCode(), outSideCode);
    }
}

