package com.glossary.mvc.jdbc;

import com.glossary.mvc.bean.DBLog;
import com.glossary.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alona on 31.05.2017.
 */
@Repository
public class UserRepository {
    @Autowired
    DataSource dataSource; //look to application-context.xml bean id = 'dataSource' definition

    private JdbcTemplate jdbcTemplate;
    @PostConstruct
    public void init() {
        System.out.println("UserRepository postConstruct is called. datasource = " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //JDBC TEMPLATE INSERT EXAMPLE
    public boolean insertLog(DBLog log) {
        System.out.println("JDBCExample: log(final String log) is called");
        final String INSERT_SQL = "INSERT INTO LOG (LOGSTRING) VALUES (?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
                preparedStatement.setString(1, log.getLOGSTRING());
                return preparedStatement;
            }
        });
        return true;
    }

    //JDBC TEMPLATE SELECT EXAMPLE
    public List<DBLog> queryAllLogs() {
        System.out.println("JDBCExample: queryAllLogs() is called");
        final String QUERY_SQL = "SELECT * FROM LOG ORDER BY IDLOG";
        List<DBLog> dbLogList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<DBLog>() {
            public DBLog mapRow(ResultSet resulSet, int rowNum) throws SQLException {
                System.out.println("Getting log: "+ rowNum + " content: " + resulSet.getString("LOGSTRING"));
                DBLog dbLog = new DBLog();
                dbLog.setIDLOG(resulSet.getInt("IDLOG"));
                dbLog.setLOGSTRING(resulSet.getString("LOGSTRING"));
                return dbLog;
            }
        });
        return dbLogList;
    }

    public List<User> queryAllUsers() {
        System.out.println("JDBCExample: queryAllUsers is called");
        final String QUERY_SQL = "SELECT * FROM USER ORDER BY IDUSER";
        List<User> userList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<User>() {
            public User mapRow(ResultSet resulSet, int rowNum) throws SQLException {
                User user = new User();
                user.setIdUser(resulSet.getString("_id"));
                user.setLogin(resulSet.getString("login"));
                user.setPassword(resulSet.getString("PASSWORD"));
                return user;
            }
        });
        return userList;
    }

    //JDBC TEMPLATE DELETE EXAMPLE
    public boolean deleteUSER(int iduser) {
        System.out.println("JDBCExample: deleteUSER called");
        final String DELETE_SQL = "DELETE FROM USER WHERE IDUSER LIKE ?";
        int result = jdbcTemplate.update(DELETE_SQL,new Object[]{iduser});
        System.out.println("r" + result);
        if (result > 0) {
            System.out.println("User is deleted: " + iduser);
            return true;
        } else {
            return false;
        }
    }

    //JDBC TEMPLATE UPDATE EXAMPLE
    public boolean updateUserEnable(User u, boolean enable)  {
        System.out.println("JDBCExample: updateUserEnable called");
        final String UPDATE_SQL = "UPDATE USER SET ENABLED = ? WHERE USERNAME = ?";
        int result = jdbcTemplate.update(UPDATE_SQL,new Object[]{enable, u.getLogin()});
        if (result > 0) {
            System.out.println("User is updated: " + u.getLogin());
            return true;
        } else {
            return false;
        }
    }
}
