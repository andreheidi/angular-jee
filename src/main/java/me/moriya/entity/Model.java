package me.moriya.entity;

import java.io.Serializable;

/**
 * Created by andre on 6/5/16.
 */
public interface Model<ID extends Serializable> extends Serializable {

    ID getId();

    void setId(ID id);
}
