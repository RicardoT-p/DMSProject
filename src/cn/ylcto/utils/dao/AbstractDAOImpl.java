package cn.ylcto.utils.dao;

import cn.ylcto.util.dbc.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

/**
 * 可以在此类中扩展基础的操作（CRUD）
 */
public class AbstractDAOImpl {
    protected Connection conn;
    protected PreparedStatement pstmt;

    public AbstractDAOImpl(){
        this.conn = DatabaseConnection.get();
    }

    /**
     * 数据批量删除功能
     * @param tabName
     * @param gid
     * @param ids
     * @return
     * @throws SQLException
     */
    public boolean handRemove(String tabName,String gid,Set<?> ids)throws SQLException{
        StringBuffer  sbf = new StringBuffer();
        // DELETE FROM groups WHERE gid IN (?,?,?);
        sbf.append("DELETE FROM ").append(tabName).append(" WHERE ").append(gid).append(" IN(");
        Iterator<?> iter = ids.iterator();
        while (iter.hasNext()){
            sbf.append(iter.next()).append(",");
        }
        sbf.delete(sbf.length() -1,sbf.length()).append(")");
        this.pstmt = this.conn.prepareStatement(sbf.toString());
        return this.pstmt.executeUpdate() == ids.size();
    }
}
