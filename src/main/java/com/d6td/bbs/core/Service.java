package com.d6td.bbs.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 *
 * @author xuxinlong
 */
public interface Service<T> {
    /**
     * 插入数据
     *
     * @param model
     */
    void insert(T model);

    /**
     * 批量插入数据
     *
     * @param models
     */
    void insert(List<T> models);

    /**
     * 主键刪除
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 主键批量刪除
     *
     * @param ids ids -> “1,2,3,4”
     */
    void deleteByIds(String ids);

    /**
     * 更新数据
     *
     * @param model
     */
    void update(T model);

    /**
     * 主键查询
     *
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     *
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找
     *
     * @param ids ids -> “1,2,3,4”
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查找
     *
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);

    /**
     * 查询所有数据
     *
     * @return
     */
    List<T> findAll();
}
