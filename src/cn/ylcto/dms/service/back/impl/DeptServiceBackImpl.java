package cn.ylcto.dms.service.back.impl;

import cn.ylcto.dms.dao.IDeptDAO;
import cn.ylcto.dms.dao.impl.DeptDAOImpl;
import cn.ylcto.dms.service.back.IDeptServiceBack;
import cn.ylcto.dms.vo.Dept;
import cn.ylcto.util.factory.DAOFactory;

import java.util.List;

public class DeptServiceBackImpl implements IDeptServiceBack {
    IDeptDAO deptDAO = DAOFactory.getInstance(DeptDAOImpl.class);
    @Override
    public boolean insert(Dept vo) throws Exception {
        return deptDAO.doCreate(vo);
    }

    @Override
    public boolean update(Dept vo) throws Exception {
        return deptDAO.doUpdate(vo);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return deptDAO.doRemove(id);
    }

    @Override
    public Dept show(int id) throws Exception {
        return deptDAO.findById(id);
    }

    @Override
    public List<Dept> list() throws Exception {
        return deptDAO.findAll();
    }
}
