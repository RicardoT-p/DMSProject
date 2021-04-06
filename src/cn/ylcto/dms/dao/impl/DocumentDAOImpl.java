package cn.ylcto.dms.dao.impl;

import cn.ylcto.dms.dao.IDocumentDAO;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.dms.vo.Dept;
import cn.ylcto.dms.vo.Document;
import cn.ylcto.utils.dao.AbstractDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class DocumentDAOImpl extends AbstractDAOImpl implements IDocumentDAO {
    @Override
    public boolean doCreate(Document vo) throws SQLException {
        String sql = "INSERT INTO document(did,aid,title,filename,credate,status)VALUES(?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, vo.getDept().getDid());
        super.pstmt.setString(2, vo.getAdmin().getAid());
        super.pstmt.setString(3, vo.getTitle());
        super.pstmt.setString(4, vo.getFilename());
        super.pstmt.setTimestamp(5, new Timestamp(vo.getCredate().getTime()));
        super.pstmt.setInt(6, vo.getStatus());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Document vo) throws SQLException {
        String sql = "UPDATE document SET filename=?,credate=?,status=? WHERE dcid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getFilename());
        super.pstmt.setTimestamp(2,new Timestamp(vo.getCredate().getTime()));
        super.pstmt.setInt(3, vo.getStatus());
        super.pstmt.setInt(4,vo.getDcid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Document findById(Integer id) throws SQLException {
        Document document = new Document();
        String sql = "SELECT dcid,did,aid,title,filename,credate FROM document WHERE dcid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            document.setDcid(rs.getInt(1));
            Dept dept = new Dept();
            dept.setDid(rs.getInt(2));
            document.setDept(dept);
            Admin admin = new Admin();
            admin.setAid(rs.getString(3));
            document.setAdmin(admin);
            document.setTitle(rs.getString(4));
            document.setFilename(rs.getString(5));
            document.setCredate(rs.getTimestamp(6));
        }
        return document;
    }

    @Override
    public List<Document> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Document> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }


    @Override
    public List<Document> findAllBySplit(Integer currentPage, Integer lineSize, Integer status) throws SQLException {
        List<Document> all = new ArrayList<Document>();
        String sql = "SELECT dcid,did,aid,title,filename,credate FROM document WHERE status=? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, status);
        super.pstmt.setInt(2, (currentPage - 1) * lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Document document = new Document();
            document.setDcid(rs.getInt(1));
            Dept dept = new Dept();
            dept.setDid(rs.getInt(2));
            document.setDept(dept);
            Admin admin = new Admin();
            admin.setAid(rs.getString(3));
            document.setAdmin(admin);
            document.setTitle(rs.getString(4));
            document.setFilename(rs.getString(5));
            document.setCredate(rs.getTimestamp(6));
            all.add(document);
        }
        return all;
    }

    @Override
    public Integer getAllCount(Integer status) throws SQLException {
        String sql = "SELECT COUNT(*) FROM document WHERE status=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,status);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public List<Document> findAllBySplit(Integer currentPage, Integer lineSize, String aid) throws SQLException {
        List<Document> all = new ArrayList<Document>();
        String sql = "SELECT dcid,did,aid,title,filename,credate,status FROM document WHERE aid=? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, aid);
        super.pstmt.setInt(2, (currentPage - 1) * lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Document document = new Document();
            document.setDcid(rs.getInt(1));
            Dept dept = new Dept();
            dept.setDid(rs.getInt(2));
            document.setDept(dept);
            Admin admin = new Admin();
            admin.setAid(rs.getString(3));
            document.setAdmin(admin);
            document.setTitle(rs.getString(4));
            document.setFilename(rs.getString(5));
            document.setCredate(rs.getTimestamp(6));
            document.setStatus(rs.getInt(7));
            all.add(document);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String aid) throws SQLException {
        String sql = "SELECT COUNT(*) FROM document WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public List<Document> findAllBySplitByDid(Integer currentPage, Integer lineSize, Integer did) throws SQLException {
        List<Document> all = new ArrayList<Document>();
        String sql = "SELECT dcid,did,aid,title,filename,credate,status FROM document WHERE did=? AND status=1 LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, did);
        super.pstmt.setInt(2, (currentPage - 1) * lineSize);
        super.pstmt.setInt(3,lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Document document = new Document();
            document.setDcid(rs.getInt(1));
            Dept dept = new Dept();
            dept.setDid(rs.getInt(2));
            document.setDept(dept);
            Admin admin = new Admin();
            admin.setAid(rs.getString(3));
            document.setAdmin(admin);
            document.setTitle(rs.getString(4));
            document.setFilename(rs.getString(5));
            document.setCredate(rs.getTimestamp(6));
            document.setStatus(rs.getInt(7));
            all.add(document);
        }
        return all;
    }

    @Override
    public Integer getAllCountByDid(Integer did) throws SQLException {
        String sql = "SELECT COUNT(*) FROM document WHERE did=? AND status=1";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,did);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doUpdateByStatus(Integer dcid, Integer status, Date date) throws SQLException {
        String sql = "UPDATE document SET status=?,credate=? WHERE dcid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,status);
        super.pstmt.setTimestamp(2,new Timestamp(date.getTime()));
        super.pstmt.setInt(3,dcid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Integer dcid) throws SQLException {
        String sql = "DELETE FROM document WHERE dcid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,dcid);
        return super.pstmt.executeUpdate() > 0;
    }
}
