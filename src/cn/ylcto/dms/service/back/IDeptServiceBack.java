package cn.ylcto.dms.service.back;

import cn.ylcto.dms.vo.Dept;

import java.util.List;

public interface IDeptServiceBack {
    public boolean insert(Dept vo)throws Exception;
    public boolean update(Dept vo)throws Exception;
    public boolean delete(int id)throws Exception;
    public Dept show(int id)throws Exception;
    public List<Dept> list()throws Exception;
}
