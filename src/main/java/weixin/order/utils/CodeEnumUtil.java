package weixin.order.utils;

import weixin.order.enums.CodeEnum;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/28
 */
public class CodeEnumUtil {
    public static  <T extends CodeEnum> T getCodeEnum(Integer code, Class<T> enumClass) {
        for (T constant : enumClass.getEnumConstants()) {
            if (code.equals(constant.getCode())){
                return constant;
            }
        }
        return null;
    }
}
