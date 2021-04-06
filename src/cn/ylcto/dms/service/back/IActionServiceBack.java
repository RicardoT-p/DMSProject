package cn.ylcto.dms.service.back;

import cn.ylcto.dms.vo.Action;

import java.util.Map;
import java.util.Set;

public interface IActionServiceBack {
    public Map<String,Object> insertPre()throws Exception;
    public boolean insert(Action vo)throws Exception;
    public boolean update(Action vo)throws Exception;
    public boolean delete(Set<Integer> ids)throws Exception;
    public Map<String,Object> list()throws Exception;
    public Action show(int actid)throws Exception;
}
