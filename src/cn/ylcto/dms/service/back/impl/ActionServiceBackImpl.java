package cn.ylcto.dms.service.back.impl;

import cn.ylcto.dms.dao.IActionDAO;
import cn.ylcto.dms.dao.IGroupsDAO;
import cn.ylcto.dms.dao.impl.ActionDAOImpl;
import cn.ylcto.dms.dao.impl.GroupsDAOImpl;
import cn.ylcto.dms.service.back.IActionServiceBack;
import cn.ylcto.dms.vo.Action;
import cn.ylcto.util.factory.DAOFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActionServiceBackImpl implements IActionServiceBack {
    private IActionDAO actionDAO = DAOFactory.getInstance(ActionDAOImpl.class);
    private IGroupsDAO groupsDAO = DAOFactory.getInstance(GroupsDAOImpl.class);
    @Override
    public Map<String, Object> insertPre() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allGroups",groupsDAO.findAll());
        return map;
    }

    @Override
    public boolean insert(Action vo) throws Exception {
        return actionDAO.doCreate(vo);
    }

    @Override
    public boolean update(Action vo) throws Exception {
        return actionDAO.doUpdate(vo);
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        return actionDAO.doRemove(ids);
    }

    @Override
    public Map<String, Object> list() throws Exception {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("allGroups",groupsDAO.findAll());
        map.put("allActions",actionDAO.findAll());
        return map;
    }

    @Override
    public Action show(int actid) throws Exception {
        return actionDAO.findById(actid);
    }
}
