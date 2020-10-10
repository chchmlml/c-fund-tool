package io.haicheng.cfundtool.service;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.domain.ServiceVO;
import io.haicheng.cfundtool.pojo.Asset;
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
public class AssetServiceTest {

    @Autowired
    private AssetService service;


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
        Asset asset = new Asset();
        asset.setDate("2020-10-01");
        asset.setItemName("ceshi");
        asset.setItemAmount(1000.0);
        service.save(asset);
        Assert.assertNotNull(asset.getId());

        String updateFundName = "ceshi-fund-update";
        asset.setItemName(updateFundName);
        service.save(asset);

        ServiceVO updateFund = service.get(asset.getId());
        Asset fundGetOne = (Asset) updateFund.getInfo();
        Assert.assertEquals(fundGetOne.getItemName(), updateFundName);
    }

    @Test
    public void testDelete() {

        String ids = "30";
        ServiceVO fund = service.delete(ids);
        Assert.assertNotNull(fund);
        Assert.assertEquals(fund.getCode(), 100);
    }

}

