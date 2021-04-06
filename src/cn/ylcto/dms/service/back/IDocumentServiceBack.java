package cn.ylcto.dms.service.back;

import cn.ylcto.dms.vo.Document;

import java.util.Date;
import java.util.Map;

public interface IDocumentServiceBack {
    /**
     * 增加文档数据
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean insert(Document vo)throws Exception;

    /**
     * 数据分页实现
     * @param currentPage
     * @param lineSize
     * @param status
     * @return
     * @throws Exception
     */
    public Map<String,Object> listByStatus(int currentPage, int lineSize, int status)throws Exception;

    /**
     * 根据id查询数据行中的所有数据
     * @param id
     * @return
     * @throws Exception
     */
    public Document show(int id)throws Exception;

    /**
     *根据id更新状态
     * @param dcid
     * @param status
     * @return
     * @throws Exception
     */
    public boolean updateByStatys(Integer dcid, Integer status)throws Exception;
    public boolean update(Document vo)throws Exception;
    public Map<String,Object> listByStatus(int currentPage, int lineSize, String aid)throws Exception;
    public Map<String,Object> listByDid(int currentPage, int lineSize, int did)throws Exception;
    public boolean delete(int dcid)throws Exception;
}
