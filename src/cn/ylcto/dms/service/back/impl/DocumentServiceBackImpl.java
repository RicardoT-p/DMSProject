package cn.ylcto.dms.service.back.impl;

import cn.ylcto.dms.dao.IDocumentDAO;
import cn.ylcto.dms.dao.impl.DocumentDAOImpl;
import cn.ylcto.dms.service.back.IDocumentServiceBack;
import cn.ylcto.dms.vo.Document;
import cn.ylcto.util.factory.DAOFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DocumentServiceBackImpl implements IDocumentServiceBack {
    IDocumentDAO documentDAO = DAOFactory.getInstance(DocumentDAOImpl.class);

    @Override
    public boolean insert(Document vo) throws Exception {
        return documentDAO.doCreate(vo);
    }

    @Override
    public Map<String, Object> listByStatus(int currentPage, int lineSize, int status) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("allDocuments",documentDAO.findAllBySplit(currentPage,lineSize,status));
        map.put("allCounts",documentDAO.getAllCount(status));
        return map;
    }

    @Override
    public Document show(int id) throws Exception {
        return documentDAO.findById(id);
    }

    @Override
    public boolean updateByStatys(Integer dcid, Integer status) throws Exception {
        return documentDAO.doUpdateByStatus(dcid,status,new Date());
    }

    @Override
    public boolean update(Document vo) throws Exception {
        return documentDAO.doUpdate(vo);
    }

    @Override
    public Map<String, Object> listByStatus(int currentPage, int lineSize, String aid) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("allDocuments",documentDAO.findAllBySplit(currentPage,lineSize,aid));
        map.put("allCounts",documentDAO.getAllCount(aid));
        return map;
    }

    @Override
    public Map<String, Object> listByDid(int currentPage, int lineSize, int did) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("allDocuments",documentDAO.findAllBySplit(currentPage,lineSize,did));
        map.put("allCounts",documentDAO.getAllCount(did));
        return map;
    }

    @Override
    public boolean delete(int dcid) throws Exception {
        return documentDAO.doRemove(dcid);
    }
}
