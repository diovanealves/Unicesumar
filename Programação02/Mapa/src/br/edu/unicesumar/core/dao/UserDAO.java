package br.edu.unicesumar.core.dao;

import br.edu.unicesumar.core.dao.connection.ConnectionJDBC;
import br.edu.unicesumar.core.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void register(User user) {
        String sql = "INSERT INTO usuario (NOME, LOGIN, SENHA, EMAIL) VALUES (?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
        }
    }

    public User login(String login, String password) {
        String sql = "SELECT id, nome, login, senha, email FROM usuario WHERE login = ? AND senha = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = ConnectionJDBC.getConnection().prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();

                user.setName(rs.getString("NOME"));
                user.setLogin(rs.getString("LOGIN"));
                user.setPassword(rs.getString("SENHA"));
                user.setEmail(rs.getString("EMAIL"));

                return user;
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {

            }
        }
    }
}
