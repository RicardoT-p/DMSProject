package cn.ylcto.dms.dao.impl;

import cn.ylcto.dms.dao.IRoleDAO;
import cn.ylcto.dms.vo.Groups;
import cn.ylcto.dms.vo.Role;
import cn.ylcto.utils.dao.AbstractDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RoleDAOImpl extends AbstractDAOImpl implements IRoleDAO{
    @Override
    public Integer getId() throws SQLException {
        String sql  = "SELECT LAST_INSERT_ID()";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doCreateByRoleAndGroups(Role vo) throws SQLException {
        String sql = "INSERT INTO role_groups(rid,gid)VALUES(?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        Iterator<Groups> iter = vo.getGroups().iterator();
        while (iter.hasNext()){
            super.pstmt.setInt(1,vo.getRid());
            super.pstmt.setInt(2,iter.next().getGid());
            super.pstmt.addBatch();
        }
        int result[] = super.pstmt.executeBatch(); //批处理
        for(int x = 0;x < result.length;x++){
            if(result[x] == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean doRemoveByRole(Integer rid) throws SQLException {
        String sql = "DELETE FROM role_groups WHERE rid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,rid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Integer rid) throws SQLException {
        String sql  = "DELETE FROM role WHERE rid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,rid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doCreate(Role vo) throws SQLException {
        String sql  = "INSERT INTO role(title,note)VALUES(?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setString(2,vo.getNote());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Role vo) throws SQLException {
        String sql  = "UPDATE role SET title=?,note=? WHERE rid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getTitle());
        super.pstmt.setString(2,vo.getNote());
        super.pstmt.setInt(3,vo.getRid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Role findById(Integer id) throws SQLException {
        Role role = new Role();
        String sql = "SELECT rid,title,note FROM role WHERE rid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            role.setRid(rs.getInt(1));
            role.setTitle(rs.getString(2));
            role.setNote(rs.getString(3));
        }
        return role;
    }

    @Override
    public List<Role> findAll() throws SQLException {
        List<Role> all = new ArrayList<>();
        String sql = "SELECT rid,title,note FROM role";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next()){
            Role role = new Role();
            role.setRid(rs.getInt(1));
            role.setTitle(rs.getString(2));
            role.setNote(rs.getString(3));
            all.add(role);
        }
        return all;
    }

    @Override
    public List<Role> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
