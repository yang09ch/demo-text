package cn.kgc.yang.controller;

import cn.kgc.yang.constans.Constans;
import cn.kgc.yang.entity.Product;
import cn.kgc.yang.expetion.ProductIsExitExpetion;
import cn.kgc.yang.service.ProductService;
import cn.kgc.yang.util.R;
import cn.kgc.yang.vo.ProductVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pro")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/update")
    public R update(@Validated @RequestBody Product product) throws ProductIsExitExpetion {
        productService.modify(product);
        return R.success("修改成功");
    }

    @RequestMapping("/del/{id}")
    public R del(@PathVariable("id") Integer id) {
        productService.deleteByid(id);
        return R.success("删除成功");
    }

    @RequestMapping("/add")
    public R add(@Validated @RequestBody Product product) throws ProductIsExitExpetion {
        productService.addProduct(product);
        return R.success("新增成功");

    }

    @RequestMapping("/disable/{productId}")
    public R disable(@PathVariable Integer productId) {
        productService.disable(productId);
        return R.success("下架成功");
    }

    @RequestMapping("/enable/{productId}")
    public R enable(@PathVariable Integer productId) {
        productService.enable(productId);
        return R.success("上架成功");
    }

    @RequestMapping("/list")
    public R page(ProductVO productVO,
                  @RequestParam(value = "page", required = false, defaultValue = Constans.Page.DEFAULT_PAGE) Integer page,
                  @RequestParam(value = "row", required = false, defaultValue = Constans.Page.DEFAULT_ROW) Integer row) {
        PageInfo<Product> pageList = productService.getPageList(productVO, page, row);
        return R.success(pageList);
    }

  /*  //该方法仅在本controller中处理异常
    @ExceptionHandler(ProductIsExitExpetion.class)//异常处理器
    public R handelProductIsExitExpetion(ProductIsExitExpetion e){
        return R.fail(e.getMessage());
    }*/
}
