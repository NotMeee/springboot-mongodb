package cn.fr13nds.impl;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: buckler
 * @Date: 2022/6/19 12:15
 * @Describe:
 */
public interface IMongoHelper<T> {

    /**
     * 增
     *
     * @param entity 实体
     * @return 结果
     */
    boolean save(T entity);

    boolean save(T entity, String collectionName);

    boolean saveList(List<T> list);

    boolean saveList(List<T> list, String collectionName);


    /**
     * 删
     *
     * @param entity 实体
     * @return 结果
     */
    boolean removeById(T entity);

    boolean removeById(T entity, String collectionName);

    /**
     * 改
     *
     * @param keys
     * @param values
     * @param id
     * @param clazz
     * @return
     */
    boolean updateById(String[] keys, Object[] values, Serializable id, Class<?> clazz);

    boolean updateById(String[] keys, Object[] values, Serializable id, String collectionName);

    boolean updateById(String[] keys, Object[] values, Serializable id, String collectionName, Class<?> clazz);

    /**
     * 查
     *
     * @param clazz
     * @return
     */
    List<T> findAll(Class<?> clazz);

    List<T> findAll(Class<?> clazz, String collectionName);

    List<T> findAll(String[] fields, Class<?> clazz);

    List<T> findAll(String[] fields, Class<?> clazz, String collectionName);

    List<T> findByMap(String[] keys, Object[] values, Class<?> clazz);

    List<T> findByMap(String[] keys, Object[] values, Class<?> clazz, String collectionName);

    List<T> findByMap(String[] keys, Object[] values, String[] fields, Class<?> clazz);

    List<T> findByMap(String[] keys, Object[] values, String[] fields, Class<?> clazz, String collectionName);

    T findById(Serializable id, Class<?> clazz);

    T findById(Serializable id, Class<?> clazz, String collectionName);

    T findById(Serializable id, String[] fields, Class<?> clazz);

    T findById(Serializable id, String[] fields, Class<?> clazz, String collectionName);
}
