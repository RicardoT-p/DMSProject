package cn.ylcto.dms.service.back.impl;

import cn.ylcto.dms.dao.IGroupsDAO;
import cn.ylcto.dms.dao.impl.GroupsDAOImpl;
import cn.ylcto.dms.service.back.IGroupsServiceBack;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.util.factory.DAOFactory;

import java.util.List;
import java.util.Set;

public class GroupsServiceBackImpl implements IGroupsServiceBack {
    private IGroupsDAO groupsDAO = DAOFactory.getInstance(GroupsDAOImpl.class);
    @Override
    public boolean insert(Groups vo) throws Exception {
        return groupsDAO.doCreate(vo);
    }

    @Override
    public boolean update(Groups vo) throws Exception {
        return groupsDAO.doUpdate(vo);
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        return groupsDAO.doRemove(ids);
    }

    @Override
    public List<Groups> list() throws Exception {
        return groupsDAO.findAll();
    }

    @Override
    public Groups show(int id) throws Exception {
        return groupsDAO.findById(id);
    }
}
