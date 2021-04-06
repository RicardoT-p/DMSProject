package cn.ylcto.utils.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * 此接口表示是一个公共的操作方法
 * @param <K> 表示对象主键类型
 * @param <V> 表示对象数据
 */
public interface IDAO<K,V> {
    public boolean doCreate(V vo)throws SQLException;
    public boolean doUpdate(V vo)throws SQLException;
    public boolean doRemove(Set<?> ids)throws SQLException;
    public V findById(K id)throws SQLException;
    public List<V> findAll()throws SQLException;
    public List<V> findAllBySplit(String column,String keyWord,Integer currentPage,Integer lineSize)throws SQLException;
    public Integer getAllCount(String column,String keyWord)throws SQLException;
}
