
package dao;
import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.seminario;

public class seminarioDaoImplementacion extends conexionDB implements seminarioDao{
    
    @Override
    public void insert(seminario seminario) throws Exception {
        try {
            this.conectar();
            String sql = "insert into seminarios (titulo,fecha,cupo) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(seminario seminario) throws Exception {
        try {
            this.conectar();
            String sql = "update seminarios set titulo = ?, fecha = ?, cupo = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupo());
            ps.setInt(4, seminario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from seminarios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<seminario> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select * from seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<seminario> lista = null;
            lista = new ArrayList<seminario>();
            while (rs.next()) {
                seminario sem = new seminario();
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setFecha(rs.getDate("fecha"));
                sem.setCupo(rs.getInt("cupo"));
                lista.add(sem);
            }
            rs.close();
            ps.close();
            return lista;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public seminario getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from seminarios where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            seminario sem = new seminario();
            if (rs.next()) {
                sem.setId(rs.getInt("id"));
                sem.setTitulo(rs.getString("titulo"));
                sem.setFecha(rs.getDate("fecha"));
                sem.setCupo(rs.getInt("cupo"));
            }
            rs.close();
            ps.close();
            return sem;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
}
