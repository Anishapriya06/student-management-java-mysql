import java.sql.*;
import java.util.*;
public class crud {
    
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        int ch;
        while(true)
        {
            System.out.println("MENU:");
            System.out.println("1. CREATE \n2.INSERT\n 3.UPDATE marks\n 4.DELETE TABLE \n 5.READ");
            System.out.println("Enter your choice");
            ch=in.nextInt();
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Anisha@123");
                Statement statement=connection.createStatement();
                if(ch==1)
                    statement.executeUpdate("CREATE TABLE STUDENT(id int PRIMARY KEY, name varchar(50), marks int)");
                else if(ch==2)
                {
                    int k=1;
                    do{
                        System.out.println("ENTER STUDENT ID ");
                        int id=in.nextInt();
                        System.out.println("ENTER NAME");
                        String nm=in.next();
                        System.out.println("ENTER MARKS: ");
                        int m=in.nextInt();
                        statement.executeUpdate("INSERT INTO STUDENT VALUES("+id+",'"+nm+"',"+m+")");
                        System.out.println("Add more record(0/1); Yes:1 ,No:0");
                        k=in.nextInt();
                        
                    }
                    while(k==1);
                }
                else if(ch==3)
                {   System.out.println("Enter student id");
                    System.out.println("Enter marks to be updated");
                    int st_id=in.nextInt();
                    int marks=in.nextInt();
                    statement.executeUpdate("Update STUDENT SET marks="+marks+" WHERE id="+st_id);
                }
                else if(ch==4)
                {
                    statement.executeUpdate("DROP TABLE STUDENT");
                    System.out.println("TABLE DELETED SUCCESFULLY");
                }

                else if(ch==5)
                {
                    ResultSet resultSet=statement.executeQuery("SELECT * FROM STUDENT");
                    while (resultSet.next()) 
                    {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name").trim();
                    int marks = resultSet.getInt("marks");
                    System.out.println("id " + id + " | Name: " + name+ " | Marks: " + marks);
                    }
                }
                
                    System.out.println("TRY AGAIN?(y/n)");
                    char check=in.next().charAt(0);
                    if(check=='n')
                        break;
                
            }
            catch(Exception e)
            {
                System.out.println(e);

            }
        }
        in.close();
        
    }

}
