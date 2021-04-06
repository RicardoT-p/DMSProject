package cn.ylcto.dms.dao.impl;

import cn.ylcto.dms.dao.IAdminDAO;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.dms.vo.Dept;
import cn.ylcto.dms.vo.Role;
import cn.ylcto.utils.dao.AbstractDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AdminDAOImpl extends AbstractDAOImpl implements IAdminDAO {
    @Override
    public boolean doCreate(Admin vo) throws SQLException {
        String sql = "INSERT INTO admin(aid,did,password,type,status,rid)VALUES(?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getAid());
        super.pstmt.setInt(2,vo.getDept().getDid());
        super.pstmt.setString(3,vo.getPassword());
        super.pstmt.setInt(4,vo.getType());
        super.pstmt.setInt(5,vo.getStatus());
        super.pstmt.setInt(6,vo.getRole().getRid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Admin vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Admin findById(String id) throws SQLException {
        Admin admin = new Admin();
        String sql = "SELECT aid,password,photo,lastdate,type,status,rid,did FROM admin WHERE aid=? AND status=1";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            admin.setAid(rs.getString(1));
            admin.setPassword(rs.getString(2));
            admin.setPhoto(rs.getString(3));
            admin.setLastdate(rs.getTimestamp(4));
            admin.setType(rs.getInt(5));
            admin.setStatus(rs.getInt(6));
            Role role = new Role();
            role.setRid(rs.getInt(7));
            admin.setRole(role);
            Dept dept = new Dept();
            dept.setDid(rs.getInt(8));
            admin.setDept(dept);
        }
        return admin;
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Admin> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public boolean doUpdateByLastdate(String aid, Date date) throws SQLException {
        String sql = "UPDATE admin SET lastdate=? WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setTimestamp(1,new Timestamp(date.getTime()));
        super.pstmt.setString(2,aid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public List<Admin> findAllByType(Integer type) throws SQLException {
        List<Admin> all = new ArrayList<>();
        String sql = "SELECT aid,password,photo,lastdate,type,status,rid FROM admin WHERE type=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,type);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            Admin admin = new Admin();
            admin.setAid(rs.getString(1));
            admin.setPassword(rs.getString(2));
            admin.setPhoto(rs.getString(3));
            admin.setLastdate(rs.getTimestamp(4));
            admin.setType(rs.getInt(5));
            admin.setStatus(rs.getInt(6));
            Role role = new Role();
            role.setRid(rs.getInt(7));
            admin.setRole(role);
            all.add(admin);
        }
        return all;
    }

    @Override
    public List<Admin> findAllByType(Integer type, Integer did) throws SQLException {
        List<Admin> all = new ArrayList<>();
        String sql = "SELECT aid,password,photo,lastdate,type,status,rid FROM admin WHERE type=? AND did=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,type);
        super.pstmt.setInt(2,did);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            Admin admin = new Admin();
            admin.setAid(rs.getString(1));
            admin.setPassword(rs.getString(2));
            admin.setPhoto(rs.getString(3));
            admin.setLastdate(rs.getTimestamp(4));
            admin.setType(rs.getInt(5));
            admin.setStatus(rs.getInt(6));
            Role role = new Role();
            role.setRid(rs.getInt(7));
            admin.setRole(role);
            all.add(admin);
        }
        return all;
    }

    @Override
    public boolean doUpdateByStatus(Integer status,String aid)throws SQLException {
        String sql = "UPDATE admin SET status=? WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,status);
        super.pstmt.setString(2,aid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdateByPasswordAndPhoto(String password, String photo, String aid) throws SQLException {
        String sql = "UPDATE admin SET password=?,photo=? WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,password);
        super.pstmt.setString(2,photo);
        super.pstmt.setString(3,aid);
        return super.pstmt.executeUpdate() > 0;
    }
}
