package com.training.service.impl;

import com.training.dto.EntityCrudDao;
import com.training.dto.EntityListIdDao;
import com.training.IEntity;
import com.training.service.EntityCrudService;
import com.training.service.EntityListIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractServiceIml<T extends IEntity> implements EntityCrudService<T>, EntityListIdService<T> {

    @Autowired
    private EntityCrudDao<T> crudDao;
    @Autowired
    private EntityListIdDao<T> listIdDao;

    @Override
    @Transactional
    public void create(T t) {
        crudDao.create(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        crudDao.update(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        crudDao.delete(t);
    }

    @Override
    public List<T> getAll() {
        return listIdDao.getAll();
    }

    @Override
    public T findById(Integer id) {
        return listIdDao.findById(id);
    }
}
