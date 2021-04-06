package cn.ylcto.dms.dao.impl;

import cn.ylcto.dms.dao.ILogsDAO;
import cn.ylcto.dms.vo.Admin;
import cn.ylcto.dms.vo.Logs;
import cn.ylcto.utils.dao.AbstractDAOImpl;
import sun.rmi.runtime.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LogsDAOImpl extends AbstractDAOImpl implements ILogsDAO {
    @Override
    public boolean doCreate(Logs vo) throws SQLException {
        String sql = "INSERT INTO logs(aid,indate,ip)VALUES(?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getAdmin().getAid());
        super.pstmt.setTimestamp(2, new Timestamp(vo.getIndate().getTime()));
        super.pstmt.setString(3, vo.getIp());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Logs vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Logs findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Logs> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Logs> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Logs> all = new ArrayList<Logs>();
        String sql = "SELECT logid,aid,indate,ip FROM logs WHERE " + column + " LIKE ? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        super.pstmt.setInt(2, (currentPage - 1) * lineSize);
        super.pstmt.setInt(3, lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Logs logs = new Logs();
            logs.setLogid(rs.getInt(1));
            Admin admin = new Admin();
            admin.setAid(rs.getString(2));
            logs.setAdmin(admin);
            logs.setIndate(rs.getTimestamp(3));
            logs.setIp(rs.getString(4));
            all.add(logs);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM logs WHERE " + column + "  LIKE ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
