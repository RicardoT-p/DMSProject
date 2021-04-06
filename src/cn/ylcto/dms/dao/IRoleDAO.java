package cn.ylcto.dms.dao;

import cn.ylcto.dms.vo.Role;
import cn.ylcto.utils.dao.IDAO;

import java.sql.SQLException;

public interface IRoleDAO extends IDAO<Integer,Role> {
    /**
     * 取得最后一次增长id
     * @return
     * @throws SQLException
     */
    public Integer getId()throws SQLException;

    /**
     * 增加数据到中间表中进行保存
     * @param vo
     * @return
     * @throws SQLException
     */
    public boolean doCreateByRoleAndGroups(Role vo)throws SQLException;

    /**
     * 删除中间表的数据，根据rid编号删除数据
     * @param rid
     * @return
     * @throws SQLException
     */
    public boolean doRemoveByRole(Integer rid)throws SQLException;
    public boolean doRemove(Integer rid)throws SQLException;
}
