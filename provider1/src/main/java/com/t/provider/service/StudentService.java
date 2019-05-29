package com.t.provider.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.t.model.Student;
import com.t.provider.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class StudentService implements IService<Student> {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean save(Student entity) {
        if (entity.getCreateTime() == null) {
            entity.setCreateTime(new Date());
        }
        return studentMapper.insert(entity) > 0;
    }

    @Override
    public boolean saveBatch(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return studentMapper.deleteById(id) > 0;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Student> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(Student entity) {
        return studentMapper.updateById(entity) > 0;
    }

    @Override
    public boolean update(Student entity, Wrapper<Student> updateWrapper) {
        return studentMapper.update(entity, updateWrapper) > 0;
    }

    @Override
    public boolean updateBatchById(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Student entity) {
        if (entity.getId() != null) {
            return updateById(entity);
        } else {
            return save(entity);
        }
    }

    @Override
    public Student getById(Serializable id) {
        return studentMapper.selectById(id);
    }

    @Override
    public Collection<Student> listByIds(Collection<? extends Serializable> idList) {
        return studentMapper.selectBatchIds(idList);
    }

    @Override
    public Collection<Student> listByMap(Map<String, Object> columnMap) {
        return studentMapper.selectByMap(columnMap);
    }

    @Override
    public Student getOne(Wrapper<Student> queryWrapper, boolean throwEx) {
        return studentMapper.selectOne(queryWrapper);
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Student> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<Student> queryWrapper) {
        return studentMapper.selectCount(queryWrapper);
    }

    @Override
    public List<Student> list(Wrapper<Student> queryWrapper) {
        return studentMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<Student> page(IPage<Student> page, Wrapper<Student> queryWrapper) {
        return studentMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Student> queryWrapper) {
        return studentMapper.selectMaps(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<Student> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Student> page, Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<Student> getBaseMapper() {
        return studentMapper;
    }
}
