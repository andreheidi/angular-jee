package me.moriya.repository;

import me.moriya.entity.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andre on 6/4/16.
 */
public interface GenericRepository<T extends Model<ID>, ID extends Serializable> {

    T find(ID id);

    List<T> list();

    T save(T entity);

    void delete(T entity);
}
