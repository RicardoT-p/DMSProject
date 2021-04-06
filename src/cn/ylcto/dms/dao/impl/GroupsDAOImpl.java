package cn.ylcto.dms.dao.impl;

import cn.ylcto.dms.dao.IGroupsDAO;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.utils.dao.AbstractDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GroupsDAOImpl extends AbstractDAOImpl implements IGroupsDAO {

    @Override
    public List<Groups> findAllByRole(Integer id) throws SQLException {
        List<Groups> all = new ArrayList<Groups>();
        String sql = "SELECT gid,title,icon,note FROM groups WHERE gid IN(" +
                "SELECT gid FROM role_groups WHERE rid=?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            Groups groups = new Groups();
            groups.setGid(rs.getInt(1));
            groups.setTitle(rs.getString(2));
            groups.setIcon(rs.getString(3));
            groups.setNote(rs.getString(4));
            all.add(groups);
        }
        return all;
    }

    @Override
    public boolean doCreate(Groups vo) throws SQLException {
        String sql = "INSERT INTO groups(title,icon,note)VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setString(2,vo.getIcon());
        super.pstmt.setString(3,vo.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Groups vo) throws SQLException {
        String sql = "UPDATE groups SET title=?,icon=? ,note=? WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setString(2,vo.getIcon());
        super.pstmt.setString(3,vo.getNote());
        super.pstmt.setInt(4,vo.getGid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return super.handRemove("groups","gid",ids);
    }

    @Override
    public Groups findById(Integer id) throws SQLException {
        Groups groups = new Groups();
        String sql  = "SELECT gid,title,icon,note FROM groups WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            groups.setGid(rs.getInt(1));
            groups.setTitle(rs.getString(2));
            groups.setIcon(rs.getString(3));
            groups.setNote(rs.getString(4));
        }
        return groups;
    }

    @Override
    public List<Groups> findAll() throws SQLException {
        List<Groups> all = new ArrayList<Groups>();
        String sql  = "SELECT gid,title,icon,note FROM groups";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Groups groups = new Groups();
            groups.setGid(rs.getInt(1));
            groups.setTitle(rs.getString(2));
            groups.setIcon(rs.getString(3));
            groups.setNote(rs.getString(4));
            all.add(groups);
        }
        return all;
    }

    @Override
    public List<Groups> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
