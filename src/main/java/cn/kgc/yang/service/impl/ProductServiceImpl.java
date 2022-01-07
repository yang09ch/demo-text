package cn.kgc.yang.service.impl;

import cn.kgc.yang.constans.Constans;
import cn.kgc.yang.entity.Product;
import cn.kgc.yang.expetion.ProductIsExitExpetion;
import cn.kgc.yang.mapper.ProductMapper;
import cn.kgc.yang.service.ProductService;
import cn.kgc.yang.vo.ProductVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public PageInfo<Product> getPageList(ProductVO productVO, Integer page, Integer row) {
        PageHelper.startPage(page, row);
        List<Product> products = productMapper.selectProduct(productVO);
        return new PageInfo<>(products);
    }

    @Override
    public void addProduct(Product product) throws ProductIsExitExpetion {
        Product pro = productMapper.getProductByName(product.getName());
        if (null != pro) {
            throw new ProductIsExitExpetion();
        }
        product.setStatus(Constans.PorductStatus.ENABLE);
        productMapper.insert(product);
    }

    @Override
    public void deleteByid(Integer id) {
        productMapper.delete(id);
    }

    @Override
    public void modify(Product product) throws ProductIsExitExpetion {
        Product pro = productMapper.getProductByName(product.getName());
        //如果数据库存在相同的name 并且不是修改这条数据
        if (null != pro & !pro.getId().equals(product.getId())) {
            throw new ProductIsExitExpetion();
        }
        productMapper.update(product);
    }

    @Override
    public void enable(Integer productId) {
        Product product = new Product()
                .setId(productId)
                .setStatus(Constans.PorductStatus.ENABLE);
        productMapper.update(product);
    }

    @Override
    public void disable(Integer productId) {
        Product product = new Product()
                .setId(productId)
                .setStatus(Constans.PorductStatus.DISABLE);
        productMapper.update(product);
    }
}
