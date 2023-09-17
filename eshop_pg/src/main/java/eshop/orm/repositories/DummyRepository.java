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
            st.executeUpdate("INSERT INTO dummy_entities VALUES('"
            + entity.getUuid() + "', '"
            + entity.getName() + "')");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @Override
    public DummyEntity read(String uuid) {
        DummyEntity dummyEntity = new DummyEntity();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT d.uuid, d.name, e.created_at, e.read_at, e.updated_at, e.deleted_at FROM dummy_entities d INNER JOIN entities e ON d.uuid = e.uuid WHERE e.uuid = '" + uuid + "'");
            rs.next();
            dummyEntity.setUuid(rs.getString(1));
            dummyEntity.setName(rs.getString(2));
            dummyEntity.setCreatedAt(rs.getString(3));
            dummyEntity.setReadAt(rs.getString(4));
            dummyEntity.setUpdatedAt(rs.getString(5));
            dummyEntity.setDeletedAt(rs.getString(6));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.read(dummyEntity);
    }

    @Override
    public void update(DummyEntity entity) {
        
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE dummy_entities SET name = '"
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
            st.executeUpdate("DELETE FROM dummy_entities WHERE uuid = '" + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.delete(entity);
    }

    

    
    
}
