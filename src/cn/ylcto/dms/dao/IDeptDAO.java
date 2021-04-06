package cn.ylcto.dms.dao;

import cn.ylcto.dms.vo.Dept;
import cn.ylcto.utils.dao.IDAO;

import java.sql.SQLException;

public interface IDeptDAO extends IDAO<Integer,Dept> {
    /**
     * 根据编号删除数据
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doRemove(Integer id)throws SQLException;
}
