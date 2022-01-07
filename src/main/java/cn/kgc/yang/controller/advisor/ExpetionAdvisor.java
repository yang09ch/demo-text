package cn.kgc.yang.controller.advisor;

import cn.kgc.yang.expetion.code.ExpetionCode;
import cn.kgc.yang.expetion.code.ExpetionType;
import cn.kgc.yang.expetion.code.ServiceExpetion;
import cn.kgc.yang.util.R;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExpetionAdvisor {


    @ExceptionHandler(BindException.class)
    public R handelBindExpetion(BindException e) {
        BindingResult result = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        return R.fail(ExpetionCode.PRODUCT_ERROR.getMessage()).setData(map).setCode(ExpetionCode.PRODUCT_ERROR.getCode());
    }

    @ExceptionHandler(ServiceExpetion.class)//异常处理器
    public R handelProductIsExitExpetion(ServiceExpetion e){
        ExpetionType type=e.getClass().getDeclaredAnnotation(ExpetionType.class);
        if (type == null){
            return R.fail();
        }
        return R.fail(type.value().getMessage(),type.value().getCode());
    }
        /*    @ExceptionHandler(Throwable.class)//异常处理器
            public R handelProductIsExitExpetion(Throwable e){
                e.getMessage();
                return R.fail("服务器内部出错");
            }*/
}
