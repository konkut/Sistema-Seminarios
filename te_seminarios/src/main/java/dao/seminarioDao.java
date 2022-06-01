
package dao;

import java.util.List;
import modelo.seminario;

public interface seminarioDao {
    public void insert(seminario seminario) throws Exception;
    public void update(seminario seminario) throws Exception;
    public void delete(int id) throws Exception;
    public seminario getById(int id) throws Exception;
    public List<seminario> getAll() throws Exception;
}
