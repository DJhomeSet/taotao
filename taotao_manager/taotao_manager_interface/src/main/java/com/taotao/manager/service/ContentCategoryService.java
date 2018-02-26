package com.taotao.manager.service;

import com.taotao.manager.pojo.ContentCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service
 * @date 2018/2/25
 */
@Service
public interface ContentCategoryService extends BaseService<ContentCategory> {
    List<ContentCategory> queryContentCategoryListByParentId(Long parentId);

    ContentCategory saveContentCategory(ContentCategory contentCategory);

    void deleteContentCategory(ContentCategory contentCategory);
}
