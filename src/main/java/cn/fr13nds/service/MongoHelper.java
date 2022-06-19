package cn.fr13nds.service;

import cn.fr13nds.impl.IMongoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: buckler
 * @Date: 2022/6/19 12:18
 * @Describe: IMongoTemplate实现类
 */
@Service
public class MongoHelper<T> implements IMongoHelper<T> {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean save(T entity) {
        try {
            mongoTemplate.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(T entity, String collectionName) {
        try {
            mongoTemplate.save(entity, collectionName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveList(List<T> list) {
        try {
            mongoTemplate.insertAll(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveList(List<T> list, String collectionName) {
        try {
            mongoTemplate.insert(list, collectionName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeById(T entity) {
        try {
            mongoTemplate.remove(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeById(T entity, String collectionName) {
        try {
            mongoTemplate.remove(entity, collectionName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateById(String[] keys, Object[] values, Serializable id, Class<?> clazz) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        Update update = new Update();
        for (int i = 0; i < keys.length; i++) {
            update.set(keys[i], values[i]);
        }
        try {
            mongoTemplate.updateFirst(query, update, clazz);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateById(String[] keys, Object[] values, Serializable id, String collectionName) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        Update update = new Update();
        for (int i = 0; i < keys.length; i++) {
            update.set(keys[i], values[i]);
        }
        try {
            mongoTemplate.updateFirst(query, update, collectionName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateById(String[] keys, Object[] values, Serializable id, String collectionName, Class<?> clazz) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        Update update = new Update();
        for (int i = 0; i < keys.length; i++) {
            update.set(keys[i], values[i]);
        }
        try {
            mongoTemplate.updateFirst(query, update, clazz, collectionName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<T> findAll(Class<?> clazz) {
        List<T> list;
        try {
            list = (List<T>) mongoTemplate.findAll(clazz);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll(Class<?> clazz, String collectionName) {
        List<T> list;
        try {
            list = (List<T>) mongoTemplate.find(new Query(), clazz, collectionName);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll(String[] fields, Class<?> clazz) {
        List<T> list;
        try {
            Query query = new Query(new Criteria());
            Field field = query.fields();
            field.include(fields);
            list = (List<T>) mongoTemplate.find(query, clazz);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findAll(String[] fields, Class<?> clazz, String collectionName) {
        List<T> list;
        try {
            Query query = new Query(new Criteria());
            Field field = query.fields();
            field.include(fields);
            list = (List<T>) mongoTemplate.find(query, clazz, collectionName);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findByMap(String[] keys, Object[] values, Class<?> clazz) {
        Criteria criteria = null;
        List<T> list;
        try {
            for (int i = 0; i < keys.length; i++) {
                if (i == 0) {
                    criteria = Criteria.where(keys[i]).is(values[i]);
                } else {
                    criteria.and(keys[i]).is(values[i]);
                }
            }
            Query query = Query.query(criteria);
            list = (List<T>) mongoTemplate.find(query, clazz);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findByMap(String[] keys, Object[] values, Class<?> clazz, String collectionName) {
        Criteria criteria = null;
        List<T> list;
        try {
            for (int i = 0; i < keys.length; i++) {
                if (i == 0) {
                    criteria = Criteria.where(keys[i]).is(values[i]);
                } else {
                    criteria.and(keys[i]).is(values[i]);
                }
            }
            Query query = Query.query(criteria);
            list = (List<T>) mongoTemplate.find(query, clazz, collectionName);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findByMap(String[] keys, Object[] values, String[] fields, Class<?> clazz) {
        Criteria criteria = null;
        List<T> list;
        try {
            for (int i = 0; i < keys.length; i++) {
                if (i == 0) {
                    criteria = Criteria.where(keys[i]).is(values[i]);
                } else {
                    criteria.and(keys[i]).is(values[i]);
                }
            }
            Query query = Query.query(criteria);
            Field field = query.fields();
            field.include(fields);
            list = (List<T>) mongoTemplate.find(query, clazz);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findByMap(String[] keys, Object[] values, String[] fields, Class<?> clazz, String collectionName) {
        Criteria criteria = null;
        List<T> list;
        try {
            for (int i = 0; i < keys.length; i++) {
                if (i == 0) {
                    criteria = Criteria.where(keys[i]).is(values[i]);
                } else {
                    criteria.and(keys[i]).is(values[i]);
                }
            }
            Query query = Query.query(criteria);
            Field field = query.fields();
            field.include(fields);
            list = (List<T>) mongoTemplate.find(query, clazz, collectionName);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T findById(Serializable id, Class<?> clazz) {
        T result;
        try {
            Criteria criteria = Criteria.where("_id").is(id);
            Query query = Query.query(criteria);
            result = (T) mongoTemplate.findOne(query, clazz);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T findById(Serializable id, Class<?> clazz, String collectionName) {
        T result;
        try {
            Criteria criteria = Criteria.where("_id").is(id);
            Query query = Query.query(criteria);
            result = (T) mongoTemplate.findOne(query, clazz, collectionName);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T findById(Serializable id, String[] fields, Class<?> clazz) {
        T result;
        try {
            Criteria criteria = Criteria.where("_id").is(id);
            Query query = Query.query(criteria);
            Field field = query.fields();
            field.include(fields);
            result = (T) mongoTemplate.findOne(query, clazz);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T findById(Serializable id, String[] fields, Class<?> clazz, String collectionName) {
        T result;
        try {
            Criteria criteria = Criteria.where("_id").is(id);
            Query query = Query.query(criteria);
            Field field = query.fields();
            field.include(fields);
            result = (T) mongoTemplate.findOne(query, clazz, collectionName);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
