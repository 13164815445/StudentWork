package unp.student.work.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.procedure.internal.Util.ResultSetMappingResolutionContext;
import org.junit.runner.Request;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;

import unp.student.work.manager.utils.*;

import unp.student.work.manager.dao.GroupStudentDao;

public class GroupStudentDaoImpl implements GroupStudentDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	
	public boolean validate(String userName, String password) {
		// TODO Auto-generated method stub
				boolean flag=false;
				//1. ��ȡ����
				conn=JDBCUtil.getConnection();
				//2. дSql���
				String sql="select * from person_info where studentid=? and password=?";
				//3. ����PreparedStatement����
				try {
					pstmt=conn.prepareStatement(sql);
				//4. ��sql��������ֵ
					pstmt.setString(1, userName);
					pstmt.setString(2, password);
				//5. ����ִ��sql���
					rs=pstmt.executeQuery();
				//6.��ResultSet������
					if (rs.next()) {
						flag=true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	finally {
				//7. �ر���Դ
					JDBCUtil.close(rs, pstmt, conn);
				}

				return flag;
			}
	public boolean studentquanxian(String userName,String password){
		boolean flag = false;
		conn = JDBCUtil.getConnection();
		String sql = "select * from student_quanxian where studentid=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String qx =String.valueOf(rs.getString("quanxian"));
				if(qx.charAt(1) == '1'){
					flag = true;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pstmt, conn);
		}
		return flag;
	}
	public boolean teacherquanxian(String userName,String password){
		boolean flag=false;
		//1. ��ȡ����
		conn=JDBCUtil.getConnection();
		//2. дSql���
		String sql="select * from teacher_quanxian where passname=? and password=?";
		//3. ����PreparedStatement����
		try {
			pstmt=conn.prepareStatement(sql);
		//4. ��sql��������ֵ
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
		//5. ����ִ��sql���
			rs=pstmt.executeQuery();
		//6.��ResultSet������
			if (rs.next()) {
				String qx = String.valueOf(rs.getString("quanxian"));
				if(qx.charAt(1) == '1')
					flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
		//7. �ر���Դ
			JDBCUtil.close(rs, pstmt, conn);
		}
		return flag;
	}
	
	}