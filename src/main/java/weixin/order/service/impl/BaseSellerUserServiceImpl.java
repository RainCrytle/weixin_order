package weixin.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weixin.order.dataobject.SellerInfo;
import weixin.order.repository.SellerInfoRepository;
import weixin.order.service.BaseSellerUserService;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
@Service
public class BaseSellerUserServiceImpl implements BaseSellerUserService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;
    @Override
    public SellerInfo findByOpenId(String openId) {
        return sellerInfoRepository.findByOpenid(openId);
    }
}
