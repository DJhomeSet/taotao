package com.taotao.manager.service;

import com.taotao.common.utils.TaoResult;
import com.taotao.manager.pojo.Content;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service
 * @date 2018/2/25
 */
public interface ContentService extends BaseService<Content> {
    TaoResult<Content> queryContentListByPage(Long categoryId, Integer page, Integer rows);
}
