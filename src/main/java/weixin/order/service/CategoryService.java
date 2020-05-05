package weixin.order.service;

import weixin.order.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Rain
 * @version 1.0
 * @description
 * @date 2020/4/29
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
