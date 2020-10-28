package io.haicheng.cfundtool.Api;

import io.haicheng.cfundtool.CFundToolApplication;
import io.haicheng.cfundtool.api.XueQiuApi;
import io.haicheng.cfundtool.api.response.XueQiuResponse;
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
public class XueQiuApiTest {

    @Autowired
    private XueQiuApi api;


    @Test
    public void testGetList() {
        XueQiuResponse lists = api.getIndustries();
        log.info("list {}", lists);

        Assert.assertNotNull(lists);
    }


    @Test
    public void testGetStocks() {
        XueQiuResponse lists = api.getStocks(1, 100);
        log.info("list {}", lists);

        Assert.assertNotNull(lists);
    }

}

