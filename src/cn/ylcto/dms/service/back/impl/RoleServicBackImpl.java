package cn.ylcto.dms.service.back.impl;

import cn.ylcto.dms.dao.IGroupsDAO;
import cn.ylcto.dms.dao.IRoleDAO;
import cn.ylcto.dms.dao.impl.GroupsDAOImpl;
import cn.ylcto.dms.dao.impl.RoleDAOImpl;
import cn.ylcto.dms.service.back.IRoleServicBack;
import cn.ylcto.dms.vo.Role;
import cn.ylcto.util.factory.DAOFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleServicBackImpl implements IRoleServicBack {
    private IGroupsDAO groupsDAO = DAOFactory.getInstance(GroupsDAOImpl.class);
    private IRoleDAO roleDAO = DAOFactory.getInstance(RoleDAOImpl.class);

    @Override
    public Map<String, Object> insertPre() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allGroups", groupsDAO.findAll());
        return map;
    }

    @Override
    public boolean insert(Role vo) throws Exception {
        // 1、向role表中增加数据
        if (roleDAO.doCreate(vo)) {
            vo.setRid(roleDAO.getId()); // 取得增长后的id
            return roleDAO.doCreateByRoleAndGroups(vo); // 这个vo中包括vo.getRid() vo.getGroups().getGid()
        }
        return false;
    }

    @Override
    public List<Role> list() throws Exception {
        return roleDAO.findAll();
    }

    @Override
    public Map<String, Object> updatePre(int rid) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Role role = roleDAO.findById(rid);
        if (role != null) {
            map.put("allGroups", groupsDAO.findAll());
            role.setGroups(groupsDAO.findAllByRole(rid));
        }
        map.put("role", role);
        return map;
    }

    @Override
    public boolean update(Role vo) throws Exception {
        if(roleDAO.doUpdate(vo)){
            if(roleDAO.doRemoveByRole(vo.getRid())){
                return roleDAO.doCreateByRoleAndGroups(vo);
            }
        }
        return false;
    }

    @Override
    public boolean delete(int rid) throws Exception {
        return roleDAO.doRemove(rid);
    }
}
