package dao;

import conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.participante;

public class participanteDaoImplementacion extends conexionDB implements participanteDao {

    @Override
    public void insert(participante participante) throws Exception {
        try {
            this.conectar();
            String sql = "insert into participantes (nombres,apellidos,id_seminario,confirmado) values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, participante.getNombres());
            ps.setString(2, participante.getApellidos());
            ps.setInt(3, participante.getId_seminario());
            ps.setInt(4, participante.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(participante participante) throws Exception {
        try {
            this.conectar();
            String sql = "update participantes set nombres = ?, apellidos = ?, id_seminario = ?, confirmado = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, participante.getNombres());
            ps.setString(2, participante.getApellidos());
            ps.setInt(3, participante.getId_seminario());
            ps.setInt(4, participante.getConfirmado());
            ps.setInt(5, participante.getId());
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
            String sql = "delete from participantes where id = ?";
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
    public participante getById(int id) throws Exception {
        try {
            this.conectar();
            String sql = "select * from participantes where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            participante par = new participante();
            while (rs.next()) {
                par.setId(rs.getInt("id"));
                par.setNombres(rs.getString("nombres"));
                par.setApellidos(rs.getString("apellidos"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
            }
            rs.close();
            ps.close();
            return par;
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<participante> getAll() throws Exception {
        try {
            this.conectar();
            String sql = "select p.*,s.titulo  as seminario ";
            sql += "from participantes p, seminarios s ";
            sql += "where p.id_seminario = s.id;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<participante> lista = null;
            lista = new ArrayList<participante>();
            while (rs.next()) {
                participante par = new participante();
                par.setId(rs.getInt("id"));
                par.setNombres(rs.getString("nombres"));
                par.setApellidos(rs.getString("apellidos"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getInt("confirmado"));
                par.setSeminario(rs.getString("seminario"));
                lista.add(par);
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

    
}
