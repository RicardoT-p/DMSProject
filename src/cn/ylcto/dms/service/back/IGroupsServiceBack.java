package cn.ylcto.dms.service.back;

import cn.ylcto.dms.vo.Groups;

import java.util.List;
import java.util.Set;

public interface IGroupsServiceBack {
    public boolean insert(Groups vo)throws Exception;
    public boolean update(Groups vo)throws Exception;
    public boolean delete(Set<Integer> ids)throws Exception;
    public List<Groups> list()throws Exception;
    public Groups show(int id)throws Exception;
}
