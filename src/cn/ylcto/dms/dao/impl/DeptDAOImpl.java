package cn.ylcto.dms.dao.impl;

import cn.ylcto.dms.dao.IDeptDAO;
import cn.ylcto.dms.vo.Dept;
import cn.ylcto.utils.dao.AbstractDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DeptDAOImpl extends AbstractDAOImpl implements IDeptDAO {
    @Override
    public boolean doRemove(Integer id) throws SQLException {
        String sql = "DELETE FROM dept WHERE did=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doCreate(Dept vo) throws SQLException {
        String sql = "INSERT INTO dept(title,note)VALUES(?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setString(2,vo.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Dept vo) throws SQLException {
        String sql = "UPDATE dept SET title=? , note=? WHERE did=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setString(2,vo.getNote());
        super.pstmt.setInt(3,vo.getDid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Dept findById(Integer id) throws SQLException {
        Dept dept = new Dept();
        String sql = "SELECT did,title,note FROM dept WHERE did=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            dept.setDid(rs.getInt(1));
            dept.setTitle(rs.getString(2));
            dept.setNote(rs.getString(3));
        }
        return dept;
    }

    @Override
    public List<Dept> findAll() throws SQLException {
        List<Dept> all = new ArrayList<Dept>();
        String sql ="SELECT did,title,note FROM dept";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Dept dept = new Dept();
            dept.setDid(rs.getInt(1));
            dept.setTitle(rs.getString(2));
            dept.setNote(rs.getString(3));
            all.add(dept);
        }
        return all;
    }

    @Override
    public List<Dept> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
