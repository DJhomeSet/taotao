package com.taotao.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.utils.TaoResult;
import com.taotao.manager.mapper.ContentMapper;
import com.taotao.manager.pojo.Content;
import com.taotao.manager.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.service.impl
 * @date 2018/2/25
 */
@Service
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService{
    @Override
    public TaoResult<Content> queryContentListByPage(Long categoryId, Integer page, Integer rows) {
        TaoResult<Content> result = new TaoResult<Content>();
        PageHelper.startPage(page,rows,true);
        Content where  = new Content();
        where.setCategoryId(categoryId);
        List<Content> contents = super.queryListByWhere(where);
        result.setRows(contents);
        result.setTotal(new PageInfo<Content>(contents).getTotal());
        return result;
    }
}
