package vn.myclass.core.service.impl;

import vn.myclass.core.dto.CheckLogin;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.utils.SingletonDaoUtil;

import java.util.Map;

public class UserServiceImpl implements UserService {
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return new Object[0];
    }

    public UserDTO findById(Integer userId) {
        return null;
    }

    public void saveUser(UserDTO userDTO) {

    }

    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    public CheckLogin checkLogin(String name, String password) {
        CheckLogin checkLogin = new CheckLogin();
        if(name != null && password != null) {
            Object[] objects = SingletonDaoUtil.getUserDaoInstance().checkLogin(name,password);
            checkLogin.setUserExist((Boolean) objects[0]);
            if(checkLogin.isUserExist()) {
                checkLogin.setRoleName(objects[1].toString());
            }
        }
        return checkLogin;
    }
}
