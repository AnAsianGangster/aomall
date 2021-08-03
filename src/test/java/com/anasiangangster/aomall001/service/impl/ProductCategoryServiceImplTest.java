package com.anasiangangster.aomall001.service.impl;

import com.anasiangangster.aomall001.service.ProductCategoryService;
import com.anasiangangster.aomall001.vo.ProductCategoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryServiceImplTest {

    //注入service,IoC
    @Autowired
    private ProductCategoryService service;

    @Test
    void getAllProductCategoryVO() {
        //目标数据
        List<ProductCategoryVO> targetList = new ArrayList<>();
        targetList.add(new ProductCategoryVO(548,"化妆品",null, null, null));
        targetList.add(new ProductCategoryVO(628,"家用商品",null, null, null));
        targetList.add(new ProductCategoryVO(654,"面部护理",null, null, null));
        targetList.add(new ProductCategoryVO(655,"少女派",null, null, null));
        targetList.add(new ProductCategoryVO(656,"餐具",null, null, null));
        //访问数据库数据
        List<ProductCategoryVO> productCategoryVOList = service.getAllProductCategoryVO();
        System.out.println(productCategoryVOList);
//        assertIterableEquals(targetList, productCategoryVOList);
    }
}
