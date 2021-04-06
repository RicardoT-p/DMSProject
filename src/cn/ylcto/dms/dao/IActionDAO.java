package cn.ylcto.dms.dao;

import cn.ylcto.dms.vo.Action;
import cn.ylcto.utils.dao.IDAO;

import java.sql.SQLException;
import java.util.List;

public interface IActionDAO extends IDAO<Integer,Action> {
    /**
     * 通过权限组信息查询数据
     * @param gid 表示要执行查询的权限组编号
     * @return
     * @throws SQLException
     */
    public List<Action> findAllByGroups(int gid)throws SQLException;
}
