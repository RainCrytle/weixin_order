package weixin.order.service;

import weixin.order.dataobject.SellerInfo;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
public interface BaseSellerUserService {

    SellerInfo findByOpenId(String openId);
}
