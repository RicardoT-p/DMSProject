package cn.ylcto.dms.service.back;

import cn.ylcto.dms.vo.Admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IAdminServiceBack {
    /**
     * 用户登录检查操作：
     *  <li>此操作会调用IAdminDAO.findById()</li>
     * @param vo 包括用户名和密码
     * @return
     * @throws SQLException
     */
    public Map<String,Object> login(Admin vo)throws Exception;

    /**
     * 增加用户数据
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean insert(Admin vo)throws Exception;

    /**
     * 列表
     * @param type
     * @return
     * @throws Exception
     */
    public List<Admin> list(int type)throws Exception;

    /**
     * 查询数据
     * @param type
     * @param did
     * @return
     * @throws Exception
     */
    public List<Admin> list(int type,int did)throws Exception;
    /**
     * 更新用户状态
     * @param status
     * @return
     */
    public boolean updateByStatus(Integer status,String aid)throws Exception;

    public boolean updateByPasswordAndPhoto(String password,String photo,String aid)throws Exception;
}
