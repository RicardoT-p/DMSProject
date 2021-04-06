package cn.ylcto.dms.service.back.impl;

import cn.ylcto.dms.dao.IActionDAO;
import cn.ylcto.dms.dao.IAdminDAO;
import cn.ylcto.dms.dao.IGroupsDAO;
import cn.ylcto.dms.dao.ILogsDAO;
import cn.ylcto.dms.dao.impl.ActionDAOImpl;
import cn.ylcto.dms.dao.impl.AdminDAOImpl;
import cn.ylcto.dms.dao.impl.GroupsDAOImpl;
import cn.ylcto.dms.dao.impl.LogsDAOImpl;
import cn.ylcto.dms.service.back.IAdminServiceBack;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.dms.vo.Logs;
import cn.ylcto.util.factory.DAOFactory;

import java.util.*;

public class AdminServiceBackImpl implements IAdminServiceBack {
    IAdminDAO adminDAO = DAOFactory.getInstance(AdminDAOImpl.class);
    ILogsDAO logsDAO = DAOFactory.getInstance(LogsDAOImpl.class);
    IGroupsDAO groupsDAO = DAOFactory.getInstance(GroupsDAOImpl.class);
    IActionDAO actionDAO = DAOFactory.getInstance(ActionDAOImpl.class);

    @Override
    public Map<String, Object> login(Admin vo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Admin admin = adminDAO.findById(vo.getAid());
        if (admin != null) {
            if (vo.getPassword().equals(admin.getPassword())) {
                Date date = new Date(); // 保存当前操作日期
                if (adminDAO.doUpdateByLastdate(admin.getAid(), date)) {
                    // 登录日志保存
                    Logs logs = new Logs();
                    logs.setAdmin(admin);
                    logs.setIndate(date);
                    logs.setIp(vo.getIp()); // 取得客服端ip
                    if (logsDAO.doCreate(logs)) {
                        // 查询所有的权限组信息
                        List<Groups> allGroups = groupsDAO.findAllByRole(admin.getRole().getRid());
                        Iterator<Groups> iter = allGroups.iterator();
                        while (iter.hasNext()) {
                            Groups groups = iter.next();
                            groups.setActions(actionDAO.findAllByGroups(groups.getGid()));
                        }
                        admin.getRole().setGroups(allGroups);
                    }
                }
                map.put("admin", admin);
                map.put("flag", true); // 表示登录成功
            } else {
                map.put("flag", false); // 表示登录成功
            }
        } else {
            map.put("flag", false); // 表示登录成功
        }
        return map;
    }

    @Override
    public boolean insert(Admin vo) throws Exception {
        return adminDAO.doCreate(vo);
    }

    @Override
    public List<Admin> list(int type) throws Exception {
        return adminDAO.findAllByType(type);
    }

    @Override
    public List<Admin> list(int type, int did) throws Exception {
        return adminDAO.findAllByType(type,did);
    }

    @Override
    public boolean updateByStatus(Integer status,String aid) throws Exception {
        return adminDAO.doUpdateByStatus(status,aid);
    }

    @Override
    public boolean updateByPasswordAndPhoto(String password, String photo, String aid) throws Exception {
        return adminDAO.doUpdateByPasswordAndPhoto(password,photo,aid);
    }
}
