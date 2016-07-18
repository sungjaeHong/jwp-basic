package core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class JdbcUtils {
	PreparedStatement pstmt = null;

	public <T> List<T> select(String sql){
		try(Connection con = ConnectionManager.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)){	//connection이나 pstmt 초기화

		}catch(Exception E){

		}
		return null;
	}

}
