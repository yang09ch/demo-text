package cn.kgc.yang.entity;

import cn.kgc.yang.constans.Constans;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {
    private Integer id;
    @NotEmpty(message = "{cn.kgc.yang.entity.name}")
    private String name;
    @Min(value = 1,message = "{cn.kgc.yang.entity.price}")
    private int price;
    private String info;
    @JSONField(format =Constans.DateFormat.FORMAT)
    @DateTimeFormat(pattern = Constans.DateFormat.FORMAT)
    private Date productDate;
    private Integer status;
}
