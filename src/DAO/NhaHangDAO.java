package DAO;

import java.util.List;

public abstract class NhaHangDAO<EntityType, KeyType> {
    abstract public void InsertorUpdate(EntityType entity);

    abstract public void delete(KeyType id);

    abstract public EntityType selectbyID(KeyType id);

    abstract public List<EntityType> selectAll();

    abstract protected List<EntityType> selectbySQL(String sql, Object...args);

}
