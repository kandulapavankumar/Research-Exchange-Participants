package db;

import java.util.ArrayList;
import java.util.List;
import model.Study;
import db.DBUtil;
import model.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

public class StudyDB {

    
    ArrayList<Study> studieslist = new ArrayList<Study>();
    private static StudyDB instance = new StudyDB();
    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss"); 
        Date date = new Date();
        
        String creation_date = ft.format(date);
   
    
    public Study getStudy(String studyCode) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        System.out.println(studyCode);
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "SELECT * from Study WHERE code = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, studyCode);
            ResultSet resultSet = ps.executeQuery();
            Study study = new Study();
            if (resultSet.next()) {
                study.setName(resultSet.getString("name"));
                study.setCode(resultSet.getString("code"));
                study.setDescription(resultSet.getString("description"));
                study.setEmail(resultSet.getString("Email"));
                study.setDatecreated(resultSet.getString("Datecreated"));
                study.setQuestion(resultSet.getString("question"));
                study.setGetImage(resultSet.getString("getImage"));
                study.setRequestedparticipants(resultSet.getString("requestedparticipants"));
                study.setNumberofparticipants(resultSet.getString("numberofparticipants"));
                study.setStatus(resultSet.getString("status"));
            }
            return study;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }
   
    

    
    public List<Study> getStudies(String email){
       List<Study> studies = new ArrayList<>();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "SELECT * from Study WHERE Email = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Study study = new Study();
                study.setName(resultSet.getString("name"));
                study.setCode(resultSet.getString("code"));
                study.setDescription(resultSet.getString("description"));
                study.setEmail(resultSet.getString("Email"));
                study.setDescription(resultSet.getString("description"));
                study.setQuestion(resultSet.getString("question"));
                study.setGetImage(resultSet.getString("getImage"));
                study.setRequestedparticipants(resultSet.getString("requestedparticipants"));
                study.setNumberofparticipants(resultSet.getString("numberofparticipants"));
                study.setStatus(resultSet.getString("status"));
                studies.add(study);
            }
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public List<Study> getStudies()
            {
            List<Study> studies = new ArrayList<>();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "SELECT * from Study";

        try {
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Study study = new Study();
                study.setName(resultSet.getString("name"));
                study.setCode(resultSet.getString("code"));
                study.setDescription(resultSet.getString("description"));
                study.setEmail(resultSet.getString("Email"));
                study.setDescription(resultSet.getString("description"));
                study.setQuestion(resultSet.getString("question"));
                study.setGetImage(resultSet.getString("getImage"));
                study.setRequestedparticipants(resultSet.getString("requestedparticipants"));
                study.setNumberofparticipants(resultSet.getString("numberofparticipants"));
                study.setStatus(resultSet.getString("status"));
                studies.add(study);
            }
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
            
            }
    
    
    public List<Study> getStudiesParticipate(String email) {
        List<Study> studies = new ArrayList<>();

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "SELECT * from Study WHERE email = ? and status='start' and "
                + "code not in (SELECT Code from Answer WHERE Email = ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, email);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Study study = new Study();
                study.setName(resultSet.getString("name"));
                study.setCode(resultSet.getString("code"));
                study.setDescription(resultSet.getString("description"));
                study.setEmail(resultSet.getString("Email"));
                study.setDescription(resultSet.getString("description"));
                study.setQuestion(resultSet.getString("question"));
                study.setGetImage(resultSet.getString("getImage"));
                study.setRequestedparticipants(resultSet.getString("requestedparticipants"));
                study.setNumberofparticipants(resultSet.getString("numberofparticipants"));
                study.setStatus(resultSet.getString("status"));
                studies.add(study);
            }
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    
    
    
    
    
    public int addstudy(Study study){
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query
                = "INSERT INTO Study (name, code, description, Email, Datecreated, "
                + "Question, getImage,requestedparticipants, numberofparticipants, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, study.getName());
            ps.setString(2, study.getCode());
            ps.setString(3, study.getDescription());
            ps.setString(4, study.getEmail());
            ps.setString(5, creation_date);
            ps.setString(6, study.getQuestion());
            ps.setString(7, study.getGetImage());
            ps.setString(8, study.getRequestedparticipants());
            ps.setString(9, study.getNumberofparticipants());
            ps.setString(10, study.getStatus());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public int editStudy(Study study) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = null;
        String query;
        if(study.getGetImage() != null){
            query = "UPDATE Study SET "
                + "name = ?, question = ?, requestedparticipants = ?, description = ? , getImage = ?  WHERE code = ?";
        } else {
            query = "UPDATE Study SET "
                + "name = ?, question = ?, requestedparticipants = ?, description = ? WHERE code = ?";
        }
        
        
        System.out.println("Study code is ------"+study.getCode());

        /**String query
                = "INSERT INTO Study (SName, SCode, Description, Email, DateCreated, "
                + "Question, ImageURL,ReqParticipants, ActParticipants, SStatus) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";**/
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, study.getName());
            ps.setString(2, study.getQuestion());
            ps.setString(3, study.getRequestedparticipants());
            ps.setString(4, study.getDescription());            
            
            if(study.getGetImage() != null){
                ps.setString(5, study.getGetImage());
                ps.setString(6, study.getCode()); 
            } else {
                ps.setString(5, study.getCode());
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public int editStatus(Study study) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE Study SET "
                + "status = ? WHERE code = ?";

        /**String query
                = "INSERT INTO Study (SName, SCode, Description, Email, DateCreated, "
                + "Question, ImageURL,ReqParticipants, ActParticipants, SStatus) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";**/
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, study.getStatus());           
            ps.setString(2, study.getCode());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public int submitAnswer(String Code, String answer, String email){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query
                = "INSERT INTO Answer (Email, Choice, Code, DateSubmitted) "
                + "VALUES (?, ?, ?, now())";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, answer);
            ps.setString(3, Code);
            int status = ps.executeUpdate();
            if(status == 1){
                return updateParticipants(Code);
            }
            return 0;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public int updateParticipation(String email){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE User SET participation = participation + 1, coins = coins + 1  "
                + "WHERE email = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);           
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public int updateParticipants(String sCode){
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE Study SET numberofparticipants = numberofparticipants + 1 "
                + "WHERE SCode = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, sCode);           
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
//    public void updatestudy(Study updatedstudy){
//        for(Study study:studieslist){
//            if(study.getCode().equalsIgnoreCase(updatedstudy.getCode())){
//                int index = studieslist.indexOf(study);
//                studieslist.set(index, updatedstudy);
//            }
//        }
//    }
}
