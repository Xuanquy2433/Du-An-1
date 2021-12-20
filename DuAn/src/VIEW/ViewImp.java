/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.oval.ConstraintViolation;

/**
 * Lớp thực thi các phương thưc của ViewInterface
 *
 * @author vanbi
 */
public class ViewImp {

    public static void viewList(List<Object[]> rows, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        // xóa tất cả các dòng khỏi bảng
        for (int rowIndex = tableModel.getRowCount() - 1; rowIndex >= 0; rowIndex--) {
            tableModel.removeRow(rowIndex);
        }

        // thêm các dòng vào bảng
        for (Object[] row : rows) {
            tableModel.addRow(row);
        }
    }

    public static void setColumnNames(String[] columnNames, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(columnNames);
    }

    public static void showError(List<ConstraintViolation> errorList, JLabel errorLB) {
        String errors = "";
        for (ConstraintViolation constraintViolation : errorList) {
            errors += constraintViolation.getMessage() + " | ";
        }
        errorLB.setText(errors);
    }

    public ViewImp() {
    }

}
