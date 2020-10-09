package io.haicheng.cfundtool.service;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.pojo.IndexDailyReport;
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
public class IndexDailyReportServiceTest {

    @Autowired
    private IndexDailyReportService service;


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
        IndexDailyReport index = new IndexDailyReport();
        index.setIndexId(1);
        index.setIndexCode("100");
        index.setDate(DateTimeUtil.getCurrentDateStr());
        index.setPe(1.0);
        index.setEp(1.0);
        index.setPb(1.0);
        index.setDyr(1.0);
        index.setRoe(1.0);
        service.save(index);
        Assert.assertNotNull(index.getId());

        index.setRoe(100.0);
        service.save(index);

        IndexDailyReport currentIndex = service.getReportByCodeAndDate(index.getIndexCode(), index.getDate());
        Assert.assertNotNull(currentIndex);
        Assert.assertEquals(currentIndex.getId(), index.getId());
    }

}

