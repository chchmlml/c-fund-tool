package io.haicheng.cfundtool.service;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.pojo.Stock;
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
public class StockServiceTest {

    @Autowired
    private StockService service;

    @Test
    public void testGetList() {
        Map<String, Object> lists = service.list(null, null, null, null, null, null, null, true, true);
        log.info("list {}", lists);

        Assert.assertNotNull(lists);
        Assert.assertNotNull(lists.get("total"));
        Assert.assertNotNull(lists.get("rows"));
    }

    @Test
    public void testListOfIndustry() {
        Map<String, Object> lists = service.listOfIndustry(null, null, null, null, "中药", true, true);
        log.info("list {}", lists);

        Assert.assertNotNull(lists);
        Assert.assertNotNull(lists.get("total"));
        Assert.assertNotNull(lists.get("rows"));
    }

    @Test
    public void testComboboxList() {
        List<Map> lists = service.getComboboxList("化学");
        log.info("list {}", lists);

        Assert.assertNotNull(lists);
    }

    /**
     *
     */
    @Test
    public void testSave() {
        Stock stock = new Stock();
        stock.setName("ceshi-save");
        stock.setCode("1000");
        stock.setIndustryCode("i1000");
        stock.setIndustryName("行业");
        stock.setPeDynamic(1.01);
        stock.setPeTtm(1.02);
        stock.setPeLyr(1.03);
        stock.setPb(1.04);
        service.save(stock);
        Assert.assertNotNull(stock.getId());

        String updateName = "ceshi-update";
        stock.setName(updateName);
        service.save(stock);

        Stock updateStock = service.getByCode(stock.getCode());
        Assert.assertEquals(updateStock.getName(), updateName);
    }


}

