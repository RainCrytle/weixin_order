package weixin.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/27
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众平台id
     */
    public String mpAppId;
    /**
     * 公众平台密钥
     */
    public String mpAppSecret;


    /*
    * 商务号*/
    private String mchId;


    /*
    * 商务密钥*/
    private String mchKey;


    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信支付异步通知地址
     */
    private String notifyUrl;


    /*扫码登陆使用 ,微信开放平台*/
    private String openAppId;
    private String openAppSecret;

    /*消息回复模板Id*/
    private String templateId;
}
