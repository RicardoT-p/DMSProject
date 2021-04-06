package cn.ylcto.dms.dao.impl;

import cn.ylcto.dms.dao.IActionDAO;
import cn.ylcto.dms.vo.Action;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.utils.dao.AbstractDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionDAOImpl extends AbstractDAOImpl implements IActionDAO {
    @Override
    public List<Action> findAllByGroups(int gid) throws SQLException {
        List<Action> all = new ArrayList<Action>();
        String sql = "SELECT actid ,title,icon,url FROM action WHERE gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,gid);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Action action = new Action();
            action.setActid(rs.getInt(1));
            action.setTitle(rs.getString(2));
            action.setIcon(rs.getString(3));
            action.setUrl(rs.getString(4));
            all.add(action);
        }
        return all;
    }

    @Override
    public boolean doCreate(Action vo) throws SQLException {
        System.out.println();
        String sql = "INSERT INTO action(gid,title,icon,url)VALUES(?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getGroups().getGid());
        super.pstmt.setString(2,vo.getTitle());
        super.pstmt.setString(3,vo.getIcon());
        super.pstmt.setString(4,vo.getUrl());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Action vo) throws SQLException {
        String sql = "UPDATE action SET gid=?,title=?,icon=?,url=? WHERE actid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,vo.getGroups().getGid());
        super.pstmt.setString(2,vo.getTitle());
        super.pstmt.setString(3,vo.getIcon());
        super.pstmt.setString(4,vo.getUrl());
        super.pstmt.setInt(5,vo.getActid());
        return super.pstmt.executeUpdate() > 0;
    }


    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return super.handRemove("action","actid",ids);
    }

    @Override
    public Action findById(Integer id) throws SQLException {
        Action action = new Action();
        String sql = "SELECT actid,gid,title,icon,url FROM action WHERE actid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            action.setActid(rs.getInt(1));
            Groups groups = new Groups();
            groups.setGid(rs.getInt(2));
            action.setGroups(groups);
            action.setTitle(rs.getString(3));
            action.setIcon(rs.getString(4));
            action.setUrl(rs.getString(5));
        }
        return action;
    }

    @Override
    public List<Action> findAll() throws SQLException {
        List<Action> all = new ArrayList<>();
        String sql = "SELECT actid,gid,title,icon,url FROM action";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            Action action = new Action();
            action.setActid(rs.getInt(1));
            Groups groups = new Groups();
            groups.setGid(rs.getInt(2));
            action.setGroups(groups);
            action.setTitle(rs.getString(3));
            action.setIcon(rs.getString(4));
            action.setUrl(rs.getString(5));
            all.add(action);
        }
        return all;
    }

    @Override
    public List<Action> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
