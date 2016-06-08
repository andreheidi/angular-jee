package me.moriya.repository.producer;

import me.moriya.repository.GenericRepository;
import me.moriya.repository.Repository;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.ParameterizedType;

/**
 * Created by andre on 6/7/16.
 */
public final class RepositoryFactory {

    @Produces
    public GenericRepository createRepository(InjectionPoint injectionPoint) {
        ParameterizedType type = (ParameterizedType) injectionPoint.getType();
        Class classe = (Class) type.getActualTypeArguments()[0];
        return new Repository(classe);
    }
}
