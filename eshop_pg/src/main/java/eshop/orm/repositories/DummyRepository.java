package eshop.orm.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eshop.orm.entities.DummyEntity;
import static eshop.util.NamingConventionTransformer.*;

public class DummyRepository extends Repository<DummyEntity> {

    @Override
    public void create(DummyEntity de) {

        super.create(de);
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO " + snakeFromPascal(de.getClassSimpleName())
                    + " VALUES('"
                    + de.getUuid() + "' "
                    + execAllGetterMethodsForPsql(de) + ")");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public DummyEntity read(String uuid) {
        DummyEntity de = new DummyEntity();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(
                    "SELECT d.uuid, d.name, e.created_at, e.read_at, e.updated_at, e.deleted_at FROM "
                            + snakeFromPascal(de.getClassSimpleName())
                            + " d INNER JOIN entity e ON d.uuid = e.uuid WHERE e.uuid = '"
                            + uuid + "'");
            if (rs.next()) {
                byte i = 0;
                de.setUuid(rs.getString(++i));
                de.setName(rs.getString(++i));
                de.setCreatedAt(rs.getString(++i));
                de.setReadAt(rs.getString(++i));
                de.setUpdatedAt(rs.getString(++i));
                de.setDeletedAt(rs.getString(++i));
            } else {
                System.err.println("No rows found with " + uuid);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.read(de);
    }

    @Override
    public void update(DummyEntity de) {

        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE dummy_entity SET name = '"
                    + de.getName()
                    + "' WHERE uuid = '" + de.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.update(de);
    }

    @Override
    public void delete(DummyEntity de) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("DELETE FROM dummy_entity WHERE uuid = '" + de.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.delete(de);
    }

}
