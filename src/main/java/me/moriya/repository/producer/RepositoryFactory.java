package me.moriya.repository.producer;

import me.moriya.entity.Model;
import me.moriya.repository.GenericRepository;
import me.moriya.repository.Repository;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by andre on 6/7/16.
 */
@Named
public final class RepositoryFactory {

    @Produces
    public <T extends Model<ID>, ID extends Serializable> GenericRepository<T, ID> createRepository(InjectionPoint injectionPoint) {
        ParameterizedType type = (ParameterizedType) injectionPoint.getType();
        Class classe = (Class) type.getActualTypeArguments()[0];
        return new Repository<T, ID>(classe);
    }
}