package com.anasiangangster.aomall001.service.impl;

import com.anasiangangster.aomall001.entity.ProductCategory;
import com.anasiangangster.aomall001.mapper.ProductCategoryMapper;
import com.anasiangangster.aomall001.service.ProductCategoryService;
import com.anasiangangster.aomall001.vo.ProductCategoryVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 奥博
 * @since 2021-07-23
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    //mapper注入
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategoryVO> getAllProductCategoryVO() {
        //一级分类
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type", 1);
        List<ProductCategory> levelOne = productCategoryMapper.selectList(wrapper);
        List<ProductCategoryVO> levelOneVO = levelOne.stream()
                .map(e -> new ProductCategoryVO(e.getId(), e.getName(), null, null, null))
                .collect(Collectors.toList());

        for (int i = 0; i < levelOneVO.size(); i++) {
            levelOneVO.get(i).setBannerImg("/images/banner"+i+".png");
            levelOneVO.get(i).setTopImg("/images/top"+i+".png");
        }

        //二级
        for (ProductCategoryVO levelOneProductCategoryVO : levelOneVO) {
            wrapper = new QueryWrapper();
            wrapper.eq("type", 2);
            wrapper.eq("parent_id", levelOneProductCategoryVO.getId());
            List<ProductCategory> levelTwo = productCategoryMapper.selectList(wrapper);
            List<ProductCategoryVO> levelTwoVO = levelTwo.stream()
                    .map(e -> new ProductCategoryVO(e.getId(), e.getName(), null, null, null))
                    .collect(Collectors.toList());
            levelOneProductCategoryVO.setChildren(levelTwoVO);
            //三级
            for (ProductCategoryVO levelTwoProductCategoryVO : levelTwoVO) {
                wrapper = new QueryWrapper();
                wrapper.eq("type", 3);
                wrapper.eq("parent_id", levelTwoProductCategoryVO.getId());
                List<ProductCategory> levelThree = productCategoryMapper.selectList(wrapper);
                List<ProductCategoryVO> leveThreeVO = levelThree.stream()
                        .map(e -> new ProductCategoryVO(e.getId(), e.getName(), null, null, null))
                        .collect(Collectors.toList());
                levelTwoProductCategoryVO.setChildren(leveThreeVO);
            }
        }

        return levelOneVO;
    }
}
