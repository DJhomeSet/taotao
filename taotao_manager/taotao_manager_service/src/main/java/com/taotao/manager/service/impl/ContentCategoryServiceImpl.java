package com.taotao.manager.service.impl;

import com.taotao.manager.pojo.ContentCategory;
import com.taotao.manager.service.ContentCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service.impl
 * @date 2018/2/25
 */
@Service
public class ContentCategoryServiceImpl extends BaseServiceImpl<ContentCategory> implements ContentCategoryService {
    @Override
    public List<ContentCategory> queryContentCategoryListByParentId(Long parentId) {
        ContentCategory contentCategory = new ContentCategory();
        contentCategory.setParentId(parentId);
        List<ContentCategory> result = super.queryListByWhere(contentCategory);
        return result;
    }

    @Override
    public ContentCategory saveContentCategory(ContentCategory contentCategory) {
        contentCategory.setIsParent(false);
        contentCategory.setStatus(1);
        super.saveSelective(contentCategory);
        ContentCategory parent = super.queryById(contentCategory.getParentId());
        if(!parent.getIsParent()){
            parent.setIsParent(true);
            super.updateByIdSelective(parent);
        }
        return contentCategory;
    }

    @Override
    public void deleteContentCategory(ContentCategory contentCategory) {
        List<Object> ids = new ArrayList<Object>();
        ids.add(contentCategory.getId());
        queryIdsByParentId(contentCategory.getId(),ids);
        super.deleteByIds(ids);
        ContentCategory where = new ContentCategory();
        where.setParentId(contentCategory.getParentId());
        Integer count = super.queryCountByWhere(where);
        if(count<1){
            ContentCategory parent = new ContentCategory();
            parent.setId(contentCategory.getParentId());
            parent.setIsParent(false);
            super.updateByIdSelective(parent);
        }
    }

    private void queryIdsByParentId(Long parentId, List<Object> ids) {
        ContentCategory where = new ContentCategory();
        where.setParentId(parentId);
        List<ContentCategory> contentCategories = super.queryListByWhere(where);
        for (ContentCategory contentCategory : contentCategories) {
            if(contentCategory.getIsParent()){
                queryIdsByParentId(contentCategory.getId(),ids);
            }
            ids.add(contentCategory.getId());
        }
    }
}
