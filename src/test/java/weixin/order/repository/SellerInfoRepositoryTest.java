package weixin.order.repository;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import weixin.order.constant.RedisConstant;
import weixin.order.dataobject.SellerInfo;
import weixin.order.utils.IdWorker;
import weixin.order.utils.KeyUtil;

import java.net.SocketTimeoutException;

import static org.junit.Assert.*;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void testSave(){
        for (int i = 0; i < 10; i++) {
            SellerInfo sellerInfo=new SellerInfo();
            long l = new IdWorker().nextId();
            sellerInfo.setSellerId(l+"");
//        sellerInfo.setSellerId(  sellerInfo.setSellerId(KeyUtil.genUniqueKey());
            sellerInfo.setOpenid("123");
            sellerInfo.setPassword("123");
            sellerInfo.setUsername("rain");
            SellerInfo info = repository.save(sellerInfo);
            Assert.assertTrue("测试保存对象", info!=null);
        }

    }

    @Test
    public void t1(){
        String abcd = String.format(RedisConstant.TOKEN_PREFIX, "abcd");
        System.out.println(abcd);
    }
}