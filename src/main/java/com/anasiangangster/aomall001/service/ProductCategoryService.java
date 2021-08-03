package com.anasiangangster.aomall001.service;

import com.anasiangangster.aomall001.entity.ProductCategory;
import com.anasiangangster.aomall001.vo.ProductCategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 奥博
 * @since 2021-07-23
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    public List<ProductCategoryVO> getAllProductCategoryVO();
}
