package cn.kgc.yang.constans;
//常量接口
public interface Constans {

    interface PorductStatus {
        Integer ENABLE = 1;//上架
        Integer DISABLE = 0;//下架
    }

    interface Page {
        String DEFAULT_PAGE = "0";
        String DEFAULT_ROW = "3";
    }

    interface DateFormat {
        String FORMAT = "yyyy-MM-dd ";
    }
}
