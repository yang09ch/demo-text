package cn.kgc.yang.service;

import cn.kgc.yang.entity.Product;
import cn.kgc.yang.expetion.ProductIsExitExpetion;
import cn.kgc.yang.vo.ProductVO;
import com.github.pagehelper.PageInfo;

public interface ProductService {
    //进行分页查询
    PageInfo<Product> getPageList(ProductVO productVO, Integer page, Integer row);

    //新增
    void addProduct(Product product) throws ProductIsExitExpetion;

    //删除
    void deleteByid(Integer id);

    //修改
    void modify(Product product) throws ProductIsExitExpetion;

    //修改状态
    void enable(Integer productId);

    //修改状态
    void disable(Integer productId);
}
