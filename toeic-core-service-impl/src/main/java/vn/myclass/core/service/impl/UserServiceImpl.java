package vn.myclass.core.service.impl;

import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.dto.CheckLogin;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.entity.UserEntity;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.UserBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = userDao.findByProperty(property, sortExpression, sortDirection, offset, limit);
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for(UserEntity item : (List<UserEntity>) objects[1]) {
            UserDTO userDTO = UserBeanUtil.toDto(item);
            userDTOList.add(userDTO);
        }
        objects[1] = userDTOList;
        return objects;
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
