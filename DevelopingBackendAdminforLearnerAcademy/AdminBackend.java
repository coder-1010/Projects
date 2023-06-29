package com.testannotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminBackend {
	static int select;
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/Projects";
            String username = "root";
            String password = "def97AWS$^";
            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();
            
            while(true) {
            		String sql = getQuery();
            		if(sql.equals("exit"))
            			break;
            		if(sql.equals(""))
            			continue;
            		resultSet = statement.executeQuery(sql);
            		switch(select) {
            			case 1: while (resultSet.next()) {
            						String subjectName = resultSet.getString("subjects");
	                            String className = resultSet.getString("classes");
	
	                            System.out.println("subjects: " + subjectName + ", classes: " + className);
            					}
            					break;
            					
            			case 2: System.out.println("Inserted values");
            					break;
            			case 3: while (resultSet.next()) {
		    						String teacherName = resultSet.getString("teachers");
		
		                        System.out.println("teachers: " + teacherName	);
		        				}
            					break;
            					
            			case 4: System.out.println("Inserted values");
            					break;
            					
            			case 5: while (resultSet.next()) {
		    						String className = resultSet.getString("classes");
		
		                        System.out.println("classes: " + className);
		        				}
            					break;
            					
            			case 6: System.out.println("Inserted values");
            					break;
            					
            			case 7: while (resultSet.next()) {
		    						String subjectName = resultSet.getString("subjects");
		                        String className = resultSet.getString("classes");
		
		                        System.out.println("subjects: " + subjectName + ", classes: " + className);
		        				}
            					break;
            					
            			case 8: System.out.println("Inserted values");
            					break;
            					
            			case 9: while (resultSet.next()) {
            						String teacherName = resultSet.getString("teachers");
	    							String subjectName = resultSet.getString("subjects");
	                            String className = resultSet.getString("classes");
	
	                            System.out.println("teachers: " + teacherName + ", subjects: " + subjectName + ", classes: " + className);
	        					}
            					break;
            					
            			case 10: System.out.println("Inserted values");
            					 break;
            					
            			case 11: while (resultSet.next()) {
	    							String studentName = resultSet.getString("students");
	    						
	    							System.out.println("students: " + studentName);
		        				 }
            					 break;
            					 
            			case 12: while (resultSet.next()) {
            						String studentName = resultSet.getString("students");
            						String subjectName = resultSet.getString("subjects");
            						String teacherName = resultSet.getString("teachers");
		
            						System.out.println("students: " + studentName + ", subjects: " + subjectName + ", teachers: " + teacherName);
		    					 }
            					 break;
            					 
            			default: System.out.println("default");
            		}
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getQuery() {
    		String query,sub,cls,teach;
	    	System.out.println("\n\nSelect:\n"
	    			+ "1. View master list of all the subjects for all the classes\n"
	    			+ "2. Add to master list of all the subjects for all the classes\n"
	    			+ "3. View master list of all the teachers\n"
	    			+ "4. Add to master list of all the teachers\n"
	    			+ "5. View master list of all the classes\n"
	    			+ "6. Add to master list of all the classes\n"
	    			+ "7. View classes for subjects from the master list\n"
	    			+ "8. Assign classes for subjects from the master list\n"
	    			+ "9. View teachers to a class for a subject\n"
	    			+ "10. Assign teachers to a class for a subject\n"
	    			+ "11. Get a master list of students\n"
	    			+ "12. Get class report\n"
	    			+ "13. Exit");
	    	Scanner input=new Scanner(System.in);
	    	int selection=input.nextInt();
	    	input.nextLine();
	    	select=selection;
	    	switch(select) {
	    		case 1: query="SELECT * FROM SubjectsAvailable;";
	    				break;
	    		
	    		case 2: System.out.print("Subject: ");
	    				sub=input.nextLine();
	    				System.out.print("Class: ");
	    				cls=input.nextLine();
	    				query="INSERT INTO SubjectsAvailable VALUES ('"+sub+"','"+cls+"');";
	    				break;
	    				
	    		case 3: query="SELECT * FROM TeachersAvailable;";
	    				break;
	    		
	    		case 4: System.out.print("Teacher: ");
	    				teach=input.nextLine();
	    				query="INSERT INTO TeachersAvailable VALUES ('"+teach+"');";
	    				break;
	    		
	    		case 5: query="SELECT * FROM ClassesAvailable;";
	    				break;
	    		
	    		case 6: System.out.print("Class: ");
	    				cls=input.nextLine();
	    				query="INSERT INTO ClassesAvailable VALUES ('"+cls+"');";
	    				break;
	    		
	    		case 7: query="SELECT * FROM SubjectsAvailable;";
	    				break;
	    		
	    		case 8: System.out.print("Subject: ");
	    				sub=input.nextLine();
	    				System.out.print("Class: ");
	    				cls=input.nextLine();
	    				query="INSERT INTO SubjectsAvailable VALUES ('subject 1','class 1');";
	    				break;
	    		
	    		case 9: query="SELECT * FROM AssignClasses;";
	    				break;
	    		
	    		case 10: System.out.print("Teacher: ");
	    				 teach=input.nextLine();
	    				 System.out.print("Subject: ");
	    				 sub=input.nextLine();
	    				 System.out.print("Class: ");
	    				 cls=input.nextLine();
	    				 query="INSERT INTO AssignClasses VALUES ('"+teach+"','"+sub+"','"+cls+"');";
	    				 break;
	    		
	    		case 11: query="SELECT students FROM AssignStudents;";
	    				 break;
	    		
	    		case 12: System.out.print("Class: ");
	    				 cls=input.nextLine();
	    				 query="SELECT\n"
	    				+ "  s.students,\n"
	    				+ "  sa.subjects,\n"
	    				+ "  ta.teachers\n"
	    				+ "FROM\n"
	    				+ "  AssignStudents AS s\n"
	    				+ "  JOIN AssignClasses AS ac ON s.classes = ac.classes\n"
	    				+ "  JOIN SubjectsAvailable AS sa ON ac.subjects = sa.subjects\n"
	    				+ "  JOIN TeachersAvailable AS ta ON ac.teachers = ta.teachers\n"
	    				+ "WHERE\n"
	    				+ "  s.classes = '"+cls+"';";
	    				 break;
	    				 
	    		case 13: query="exit";
	    				 break;
	    				 
	    		default: System.out.println("Enter between 1 and 13");
	    				 query="";
	    		
	    	}
	    	return query;
	}
}
