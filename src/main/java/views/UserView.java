package views;

import dao.DataDAO;
import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class UserView {
    private String email;
    UserView(String email){
        this.email = email;
    }
    public void home() throws SQLException, IOException {
        do{
            System.out.println("Welcome" + " " +this.email);
            System.out.println("Press 1 to show hidden files");
            System.out.println("Press 2 to hide file");
            System.out.println("Press 3 to unhide a file");
            System.out.println("Press 0 to exit ");
            Scanner sc = new Scanner (System.in);
            int ch = parseInt(sc.nextLine());
            switch (ch){
             case 1 -> {
                 List<Data> files = DataDAO.getAllFiles(this.email);
                 System.out.println("ID - File name");
                 for(Data file : files){
                     System.out.println(file.getId() + "-" + file.getFileName());
                 }
             }
             case 2 -> {
                 System.out.println("Enter the file path");
                 String path = sc.nextLine();
                 File f = new File(path);
                 Data file = new Data(0, f.getName(),path, this.email);
                 try {
                     DataDAO.hideFile(file);
                 } catch (SQLException e) {
                     throw new RuntimeException(e);
                 }
             }
             case 3 -> {

                 List<Data> files = DataDAO.getAllFiles(this.email);
                 System.out.println("ID - File name");
                 for(Data file : files){
                     System.out.println(file.getId() + "-" + file.getFileName());
                 }
                 System.out.println("Enter the id of file you want to unhide");
                    int id = parseInt(sc.nextLine());
                    boolean isValid = false;
                    for(Data file : files){
                        if(file.getId() == id){
                            isValid = true;
                            break;
                        }
                    }
                    if(isValid) DataDAO.unhide(id);
                    else System.out.println("Wrong id");
             }
                case 0 -> System.exit(0);

            }
        }while(true);
    }
}
