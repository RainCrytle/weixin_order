package weixin.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weixin.order.dataobject.SellerInfo;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openId);
}
