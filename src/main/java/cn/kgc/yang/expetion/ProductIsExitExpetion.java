package cn.kgc.yang.expetion;


import cn.kgc.yang.expetion.code.ExpetionCode;
import cn.kgc.yang.expetion.code.ExpetionType;
import cn.kgc.yang.expetion.code.ServiceExpetion;

@ExpetionType(ExpetionCode.PRODUCT_IS_EXITS)
public class ProductIsExitExpetion extends ServiceExpetion {

    public ProductIsExitExpetion() {
    }

    public ProductIsExitExpetion(String message) {
        super(message);
    }

    public ProductIsExitExpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductIsExitExpetion(Throwable cause) {
        super(cause);
    }

    public ProductIsExitExpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
