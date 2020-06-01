package dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.*;
import java.io.*;
import DBUtil.DBUtil;
import bean.Student;


public class StudentDao {
   // PrintWriter out=response.getWriter();
    //System.out.println(a123);
    public static ArrayList<Student> getallstudent() {

        System.out.println("getallstudent");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Student> list = new ArrayList<Student>();
        try {
            conn= DBUtil.getConnection();
            if(conn !=null ){
                System.out.println("getallstudentconn");
            }
          //  String sql="select * form Student";
            //stmt=conn.prepareStatement(sql);
            stmt=conn.prepareStatement("select * from student");
            rs=stmt.executeQuery();
            while(rs.next())
            {
                Student stu =new Student();
                stu.setId(rs.getString("id"));
                stu.setUserName(rs.getString("userName"));
                stu.setXb(rs.getString("xb"));
                stu.setMima(rs.getString("mima"));
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally {
             if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
            return list;
    }   
    public static Student findo(String userName)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Student stu =new Student();
             stu=null;
        try {
             conn= DBUtil.getConnection();
           // String sql="select * form Student where userName=?;";
            //stmt=conn.prepareStatement(sql);
            stmt=conn.prepareStatement("select * from student where userName=?");
            stmt.setString(1,userName);
            rs=stmt.executeQuery();
            if(rs.next())
            {
                stu.setId(rs.getString("id"));
                stu.setUserName(rs.getString("userName"));
                stu.setXb(rs.getString("xb"));
                stu.setMima(rs.getString("mima"));                     
             }
            
        } catch (SQLException e) {
            e.printStackTrace();    
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
   return stu; 
    }

    public static Student find(String id,String userName,String xb,String mima)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
         Student stu =new Student();
             stu=null;
        try {
            conn= DBUtil.getConnection();
            String sql="select * from student where id=? and userName=? and xb=? and mima=?;";//SQL查找
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,id);
            stmt.setString(2,userName);
            stmt.setString(3,xb);
            stmt.setString(4,mima);
            rs=stmt.executeQuery();
            if(rs.next())
            {
                stu.setId(rs.getString("id"));
                stu.setUserName(rs.getString("userName"));
                stu.setXb(rs.getString("xb"));
                stu.setMima(rs.getString("mima"));                     
             }
        } catch (SQLException e) {
            e.printStackTrace();    
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
      return stu; 
    }
    //public static boolean insert(String id,String userName,String xb,String mima) {
      public static void insert(String id,String userName,String xb,String mima) {
      Connection conn = null;
        PreparedStatement stmt = null;
      //  boolean t=;
    try {
       conn= DBUtil.getConnection();
        stmt = conn.prepareStatement(
                "insert into student(id,userName,xb,mima)values(?,?,?,?)");
        stmt.setString(1,id);
        stmt.setString(2,userName);
        stmt.setString(3,xb);
        stmt.setString(4,mima);
        int re=stmt.executeUpdate();
     //    if(re!=0) {  t=true;  }
    } catch (Exception e) {
            e.printStackTrace();
            
        }finally {
           if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
     // return t;
  }
    public static void deletee(String id){
        Connection conn = null;
        PreparedStatement stmt = null;
            try {
                conn= DBUtil.getConnection();
                String sql = "delete from student where id=?";   
                stmt=conn.prepareStatement(sql);
                // stmt=conn.preparedStatement(" delete from Student where id =? ");
                stmt.setString(1,id);
                stmt.executeUpdate();
            } catch (Exception e) {
            e.printStackTrace();
            
        }finally {
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        }
    public static void updatee(Student stu){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
           conn= DBUtil.getConnection();
           String sql = "update student set id='"+stu.getId()+"',userName='"+stu.getUserName()+"',xb='"+stu.getXb()+"',mima='"+stu.getMima()+"'";
           stmt=conn.prepareStatement(sql);
           //stmt=conn.preparedStatement("update Student set id ='"+stu.getId()+"',userName='"+stu.getUserName()+"',xb='"+stu.getXb()+"',mima='"+stu.getMima()+"'");
           stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally {
           if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
   }
}

            
  



