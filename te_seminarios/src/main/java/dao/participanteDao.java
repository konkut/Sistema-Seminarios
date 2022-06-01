
package dao;

import java.util.List;
import modelo.participante;

public interface participanteDao {
    public void insert(participante participante) throws Exception;
    public void update(participante participante) throws Exception;
    public void delete(int id) throws Exception;
    public participante getById(int id) throws Exception;
    public List<participante> getAll() throws Exception;
}
