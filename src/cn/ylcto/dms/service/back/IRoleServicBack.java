package cn.ylcto.dms.service.back;

import cn.ylcto.dms.vo.Role;

import java.util.List;
import java.util.Map;

public interface IRoleServicBack {
    public Map<String,Object> insertPre()throws Exception;
    public boolean insert(Role vo)throws Exception;
    public List<Role> list()throws Exception;

    public Map<String,Object> updatePre(int rid)throws Exception;
    public boolean update(Role vo)throws Exception;
    public boolean delete(int rid)throws Exception;
}
