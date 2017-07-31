package com.neusoft.bbs.commons.util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {

	public static int update(Connection c, String sql, Object params[]) throws SQLException {
		Connection conn = c;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			return pstmt.executeUpdate();

		} finally {
			JdbcUtil_DBCP.close(rs);
			JdbcUtil_DBCP.close(pstmt);
		}
	}
	
public static Object query(Connection c,String sql,Object params[],ResultSetHandler rsh) throws SQLException{
        
        Connection conn = c;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            pstmt = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
            	pstmt.setObject(i+1, params[i]);
            }
            rs = pstmt.executeQuery();
            /**
             * 对于查询返回的结果集处理使用到了策略模式
             */
            return rsh.handler(rs);
            
        }finally{
        	JdbcUtil_DBCP.close(rs);
			JdbcUtil_DBCP.close(pstmt);
        }
    }
}
