package com.t.provider.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.t.model.Clazz;
import com.t.provider.mapper.ClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class ClazzService implements IService<Clazz> {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public boolean save(Clazz entity) {
        return clazzMapper.insert(entity) > 0;
    }

    @Override
    public boolean saveBatch(Collection<Clazz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Clazz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return clazzMapper.deleteById(id) > 0;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return clazzMapper.deleteByMap(columnMap) == columnMap.size();
    }

    @Override
    public boolean remove(Wrapper<Clazz> queryWrapper) {
        return clazzMapper.delete(queryWrapper) > 0;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return clazzMapper.deleteBatchIds(idList) == idList.size();
    }

    @Override
    public boolean updateById(Clazz entity) {
        return clazzMapper.updateById(entity) > 0;
    }

    @Override
    public boolean update(Clazz entity, Wrapper<Clazz> updateWrapper) {
        return clazzMapper.update(entity, updateWrapper) > 0;
    }

    @Override
    public boolean updateBatchById(Collection<Clazz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Clazz entity) {
        if (entity.getId() != null) {
            return updateById(entity);
        }else {
            return save(entity);
        }
    }

    @Override
    public Clazz getById(Serializable id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public Collection<Clazz> listByIds(Collection<? extends Serializable> idList) {
        return clazzMapper.selectBatchIds(idList);
    }

    @Override
    public Collection<Clazz> listByMap(Map<String, Object> columnMap) {
        return clazzMapper.selectByMap(columnMap);
    }

    @Override
    public Clazz getOne(Wrapper<Clazz> queryWrapper, boolean throwEx) {
        return clazzMapper.selectOne(queryWrapper);
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Clazz> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Clazz> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<Clazz> queryWrapper) {
        return clazzMapper.selectCount(queryWrapper);
    }

    @Override
    public List<Clazz> list(Wrapper<Clazz> queryWrapper) {
        return clazzMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<Clazz> page(IPage<Clazz> page, Wrapper<Clazz> queryWrapper) {
        return clazzMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Clazz> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<Clazz> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Clazz> page, Wrapper<Clazz> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<Clazz> getBaseMapper() {
        return clazzMapper;
    }
}
