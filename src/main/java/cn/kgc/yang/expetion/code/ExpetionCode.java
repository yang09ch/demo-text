package cn.kgc.yang.expetion.code;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ExpetionCode {

    PRODUCT_IS_EXITS("该商品已存在", 30001),
    PRODUCT_TYPE_IS_EXITS("该商品类型已存在", 30002),
    PRODUCT_ERROR("数据校验失败", 30002);
    private String message;
    private Integer code;

    ExpetionCode(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
