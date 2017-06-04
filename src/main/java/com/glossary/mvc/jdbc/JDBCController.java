package com.glossary.mvc.jdbc;

import com.glossary.mvc.bean.DBLog;
import com.glossary.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Alona on 31.05.2017.
 */
@Controller
public class JDBCController {

    @Autowired UserRepository userRepository;

    @RequestMapping(value="/jdbcQueryAllUsers", method= RequestMethod.GET)
    public ModelAndView jdbcSelectAllUsers() {
        System.out.println("JDBCController jdbcSelectAllUsers() is called");
        List<User> users =  userRepository.queryAllUsers();
        return new ModelAndView("/jdbc/jdbc", "resultObject", users);
    }

    @RequestMapping(value = "/jdbcInsert/logstring/{logstring}", method=RequestMethod.GET)
    public ModelAndView jdbcInsert(@PathVariable(value="logstring") String logstring) {
        System.out.println("JDBCController jdbcInsert is called");
        DBLog dblog = new DBLog();
        dblog.setLOGSTRING(logstring);
        boolean result = userRepository.insertLog(dblog);
        return new ModelAndView("/jdbc/jdbc", "resultObject", result);
    }

    @RequestMapping(value = "/jdbcSelectLogs", method=RequestMethod.GET)
    public ModelAndView jdbcSelect() {
        System.out.println("JDBCController jdbcSelect is called");
        List<DBLog> dbLogs =  userRepository.queryAllLogs();
        return new ModelAndView("/jdbc/jdbc", "resultObject", dbLogs);

    }

    @RequestMapping(value = "/jdbcDelete/user/{iduser}", method=RequestMethod.GET)
    public ModelAndView jdbcDelete( @PathVariable(value="iduser") int iduser) {
        System.out.println("JDBCController jdbcDelete is called");
        boolean result = userRepository.deleteUSER(iduser);
        return new ModelAndView("/jdbc/jdbc", "resultObject", result);

    }

    @RequestMapping(value = "/jdbcUpdate/user/username/{username}/enabled/{enabled}", method=RequestMethod.GET)
    public ModelAndView jdbcUpdate(@PathVariable(value="username") String username, @PathVariable(value="enabled") boolean enabled) {
        System.out.println("JDBCController jdbcUpdate is called");
        User user = new User();
        user.setLogin(username);
        boolean result = userRepository.updateUserEnable(user, enabled);
        return new ModelAndView("/jdbc/jdbc", "resultObject", result);

    }
}




