package eshop.orm.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eshop.orm.entities.DummyEntity;

public class DummyRepository extends Repository<DummyEntity>{

    @Override
    public void create(DummyEntity entity) {
        
        super.create(entity);
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO dummy_entity VALUES('"
            + entity.getUuid() + "', "
            + execAllStartsWithMethodsPsql(entity, "get") + ")");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public DummyEntity read(String uuid) {
        DummyEntity dummyEntity = new DummyEntity();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT d.uuid, d.name, e.created_at, e.read_at, e.updated_at, e.deleted_at FROM dummy_entity d INNER JOIN entity e ON d.uuid = e.uuid WHERE e.uuid = '" + uuid + "'");
            if (rs.next()) {
                byte i = 0;
                dummyEntity.setUuid(rs.getString(++i));
                dummyEntity.setName(rs.getString(++i));
                dummyEntity.setCreatedAt(rs.getString(++i));
                dummyEntity.setReadAt(rs.getString(++i));
                dummyEntity.setUpdatedAt(rs.getString(++i));
                dummyEntity.setDeletedAt(rs.getString(++i));
            } else {
                System.err.println("No rows found with " + uuid);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.read(dummyEntity);
    }

    @Override
    public void update(DummyEntity entity) {
        
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE dummy_entity SET name = '"
                    + entity.getName()
                    + "' WHERE uuid = '" + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.update(entity);
    }
    @Override
    public void delete(DummyEntity entity) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("DELETE FROM dummy_entity WHERE uuid = '" + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.delete(entity);
    }

    

    
    
}
