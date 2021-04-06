package cn.ylcto.dms.dao;

import cn.ylcto.dms.vo.Document;
import cn.ylcto.utils.dao.IDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IDocumentDAO extends IDAO<Integer ,Document> {
    public List<Document> findAllBySplit(Integer currentPage,Integer lineSize,Integer status)throws SQLException;
    public Integer getAllCount(Integer status)throws SQLException;

    public List<Document> findAllBySplit(Integer currentPage,Integer lineSize,String aid)throws SQLException;
    public Integer getAllCount(String aid)throws SQLException;

    public List<Document> findAllBySplitByDid(Integer currentPage,Integer lineSize,Integer did)throws SQLException;
    public Integer getAllCountByDid(Integer did)throws SQLException;

    /**
     * 更新文档状态
     * @param dcid
     * @param status
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByStatus(Integer dcid, Integer status, Date date)throws SQLException;

    public boolean doRemove(Integer dcid)throws SQLException;
}
