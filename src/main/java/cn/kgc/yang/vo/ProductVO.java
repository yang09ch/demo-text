package cn.kgc.yang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    private String name;
    private Integer maxPrice;
    private  Integer minPrice;
    private Integer status;
}
