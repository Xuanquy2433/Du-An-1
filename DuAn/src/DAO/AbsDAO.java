package DAO;



import Interface.TableInterface;
import java.awt.Frame;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vanbi
 * @param <T> dto type
 */
public abstract class AbsDAO<T extends TableInterface> {

   public void insert(T obj) {
        /*
        insert into table {DanhMuc, BanAn} values (?,?,?)
        */
        String query = "insert into " + obj.getTableName();
        query += " values (";
        for (String column : obj.getColumnNames()) {
            query += "?,";
        }
        //"insert into DanhMuc values (?,"
        query = query.substring(0, query.length() - 1);
        //"insert into DanhMuc values (?"
        query += ")";
        //"insert into DanhMuc values (?)
        System.out.println("Cháº¡y lá»‡nh sql: " + query);
        DBConnection.executeUpdate(query, obj.getValues());
    }
    
    /**
     * Viet them ham edit
     * @param dto Ä‘á»‘i tÆ°á»£ng chá»‰nh sá»­a
     */
    public void edit(T dto) {
        // cÃ¢u lá»‡nh edit
        // update {tableName} set {column1} = ?, {column2} = ?, {column3} = ? where {idColumn} = ?
        String query = "update " + dto.getTableName() + " set ";
        // táº¡o Ä‘oáº¡n {column1} = ?, {column2} = ?, {column3} = ?
        for (String column : dto.getColumnNames()) {
            query += column + "=?,";
        }
        // xÃ³a dáº¥u , cuá»‘i cÃ¹ng
        query = query.substring(0, query.length() - 1);
        // thÃªm doáº¡n where {idColumn} = ?
        query += " where " + dto.getIdName() + " = ?";
        // táº¡o danh sÃ¡ch giÃ¡ trá»‹ thÃªm vÃ o cÃ¢u query
        Object[] values = new Object[dto.getValues().length + 1];
        // copy dá»¯ liá»‡u tá»« object qua values
        System.arraycopy(dto.getValues(), 0, values, 0, dto.getValues().length);
        // thÃªm id vÃ o cuá»‘i dá»¯ liá»‡u
        values[values.length - 1] = dto.getId();
        // cháº¡y cÃ¢u query
        System.out.println("Cau lenh edit: " + query);
        DBConnection.executeUpdate(query, values);
    }
    
    
    /**
     * Viet them ham delete
     * @param id Ä‘á»‹nh danh Ä‘á»‘i tÆ°á»£ng
     */
    public void delete(Integer id) {
        T dto = this.createDto();
        // cÃ¢u lá»‡nh delete
        // delete {tableName} where {idColumn} = ?
        String query = "delete " + dto.getTableName() + " where " + dto.getIdName() + "=?";
        // cháº¡y cÃ¢u query
        System.out.println("Cháº¡y lá»‡nh sql: " + query);
        DBConnection.executeUpdate(query, id);
    }
    
    /**
     * Tao lop MonAnDAO
     */
    
    /***
     * Get all object on database
     * @return all object
     */
    public List<T> getAll() {
        return getWithWhereClause(null);
    }
    
    /***
     * Láº¥y má»™t Ä‘á»‘i tÆ°á»£ng tá»« database tá»« dto
     * @param id
     * @return giÃ¡ trá»‹ theo id náº¿u khÃ´ng tá»“n táº¡i thÃ¬ tráº£ vá»� null
     */
    public T getById(int id) {
        T dto = createDto();
        List<T> dtos = getWithWhereClause( dto.getIdName() + " = ?", id);
        if (dtos.isEmpty()) {
            return null;
        }
        return dtos.get(0);
    }
    
    /***
     * Láº¥y má»™t Ä‘á»‘i tÆ°á»£ng tá»« database tá»« dto
     * @param whereClause CÃ¢u Ä‘iá»�u kiÃªn
     * @param parameters cÃ¡c tham sá»‘ truyá»�n vÃ o
     * @return giÃ¡ trá»‹ theo id náº¿u khÃ´ng tá»“n táº¡i thÃ¬ tráº£ vá»� null
     */
    public List<T> getWithWhereClause(String whereClause, Object ...parameters) {
        try {
            T tempDto = createDto();
            String query = "Select * from %s";
            if (whereClause != null) {
                query += " where " + whereClause;
            }
            query = String.format(query, tempDto.getTableName());
            ResultSet rs = DBConnection.executeQuery(query, parameters);
            
            // máº£ng dá»¯ liá»‡u tráº£ vá»�
            List<T> returnData = new ArrayList<>();
            while(rs.next()) {
                returnData.add(getDtoFromResultSet(rs));
            }
            return returnData;
        } catch (SQLException ex) {
            Logger.getLogger(AbsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Object[]> getRawValues(String sql, Object ...parameters) {
        try {
            List<Object[]> data = new ArrayList<>();
            ResultSet rs = DBConnection.executeQuery(sql, parameters);
            
            while(rs.next()) {
                List<Object> values = new ArrayList<>();
                ResultSetMetaData rsmd = rs.getMetaData();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    values.add(rs.getObject(i + 1));
                }
                data.add(values.toArray());
            }
            return data;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    /***
     * Láº¥y giÃ¡ trá»‹ dto tá»« resulset láº¥y tá»« database
     * @return tráº£ vá»� giÃ¡ trá»‹ cá»§a Ä‘á»‘i tÆ°á»£ng
     */
    private T getDtoFromResultSet(ResultSet rs) {
        try {
            // láº¥y Ä‘á»‘i tÆ°á»£ng dto
            T tempDto = createDto();
            // láº¥y danh sÃ¡ch cá»™t
            String[] columns = tempDto.getColumnNames();
            // Chá»©a dá»¯ liá»‡u
            Object[] values = new Object[columns.length + 1];
            
            values[0] = rs.getObject(tempDto.getIdName());
            // duyá»‡t qua danh cá»™t
            for (int i = 0; i < columns.length; i++) {
                values[i + 1] = rs.getObject(columns[i]);
            }
            tempDto.setValue(values);
            return tempDto;
        } catch (SQLException ex) {
            Logger.getLogger(AbsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /***
     * Táº¡o Ä‘á»‘i tÆ°á»£ng dto á»Ÿ Ä‘Ã¢y cÃ³ thá»ƒ lÃ  bÃ n Äƒn, danh má»¥c, mÃ³n Äƒn phÃ¹ há»£p cho tá»«ng loáº¡i DAO
     * @return dto Ä‘á»‘i tÆ°á»£ng Ä‘Æ°á»£c táº¡o
     */
    public T createDto() {
        try {
            // láº¥y class dto tá»« generic type T
            Class dtoType = ((Class) ((ParameterizedType) getClass()
                    .getGenericSuperclass())
                    .getActualTypeArguments()[0]);
            // vÃ­ dá»¥ á»Ÿ Ä‘Ã¢y lá»›p DanhMucDao sáº½ lÃ  DanhMuc
            // Láº¥y contructor (phuong thá»©c khá»Ÿi táº¡o) khÃ´ng cÃ³ tham sá»‘
            Constructor constructor = dtoType.getConstructor();
            // táº¡o Ä‘á»‘i tÆ°á»£ng tá»« contructor Ä‘Ã£ táº¡o
            T dto = (T) constructor.newInstance();
            return dto;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(AbsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
