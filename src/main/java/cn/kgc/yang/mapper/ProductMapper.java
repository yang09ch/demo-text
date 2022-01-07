package cn.kgc.yang.mapper;

import cn.kgc.yang.entity.Product;
import cn.kgc.yang.vo.ProductVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> selectProduct(ProductVO productVO);

    @Insert("insert into t_product(name,price,info,product_date,status) values(#{name},#{price},#{info},#{productDate},#{status})")
    void insert(Product product);

    @Delete("delete from t_product where  id=#{id}")
    void delete(@Param("id") Integer id);

    void update(Product product);

    @Select("select id,name,price,info,product_date,status from t_product where name = #{name}")
    Product getProductByName(@Param("name") String name);
}
