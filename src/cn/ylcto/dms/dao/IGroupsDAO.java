package cn.ylcto.dms.dao;

import cn.ylcto.dms.vo.Groups;
import cn.ylcto.utils.dao.IDAO;
import jdk.nashorn.internal.ir.IdentNode;

import java.sql.SQLException;
import java.util.List;

public interface IGroupsDAO extends IDAO<Integer,Groups> {
    /**
     * 通过角色编号重新所有的权限组信息
     * @param id 角色编号
     * @return
     * @throws SQLException
     */
    public List<Groups> findAllByRole(Integer id)throws SQLException;
}
