package weixin.order.from;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import weixin.order.enums.ProductStatusEnum;
import weixin.order.utils.CodeEnumUtil;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
@Data
public class ProductForm {

    private String productId;

    /**
     * 名字.
     */
    private String productName;

    /**
     * 单价.
     */
    private BigDecimal productPrice;

    /**
     * 库存.
     */
    private Integer productStock;

    /**
     * 描述.
     */
    private String productDescription;

    /**
     * 小图.
     */
    private String productIcon;



    /**
     * 类目编号.
     */
    private Integer categoryType;



}
