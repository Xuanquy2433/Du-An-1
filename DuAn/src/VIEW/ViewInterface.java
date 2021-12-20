/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;



import Controller.AbsController;
import java.util.List;
import net.sf.oval.ConstraintViolation;

/**
 * Lớp đại diện cho các hành động của view có thể thưc hiện
 * @author vanbi
 */
public interface ViewInterface {
    
    // Hiển thị các dòng ra table
    public void viewList(List<Object[]> rows);
    
    // set column name
    public void setColumnNames(String[] columnNames);
    
    public void setController(AbsController controller);

    public void showErrors(List<ConstraintViolation> errorList);
}