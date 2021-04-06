package cn.ylcto.dms.dao;

import cn.ylcto.dms.vo.Admin;
import cn.ylcto.utils.dao.IDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IAdminDAO extends IDAO<String,Admin> {
    /**
     * 根据用户编号更新最后一次登录日期
     * @param aid
     * @param date
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByLastdate(String aid, Date date)throws SQLException;

    /**
     * 根据用户类型查询全部数据
     * @param type
     * @return
     * @throws SQLException
     */
    public List<Admin> findAllByType(Integer type)throws SQLException;

    /**
     * 根据用户类型查询全部数据
     * @param type
     * @return
     * @throws SQLException
     */
    public List<Admin> findAllByType(Integer type,Integer did)throws SQLException;

    public boolean doUpdateByStatus(Integer status,String aid)throws SQLException;

    /**
     * 根据用户编号更新密码和照片信息
     * @param password
     * @param photo
     * @param aid
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByPasswordAndPhoto(String password,String photo,String aid)throws SQLException;
}
