/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import DAO.AbsDAO;
import Interface.TableInterface;
import VIEW.ViewInterface;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 *
 * @author vanbi
 * @param <T>
 */
public abstract class AbsController<T extends TableInterface> {

    // chuyển thành ViewInterface
    protected final ViewInterface view;
    protected final AbsDAO<T> dao;

    public abstract AbsDAO<T> getDao();

    public abstract String[] getTableColumnNames();

    private Dictionary<String, Object> viewBag;

    public Dictionary<String, Object> getViewBag() {
        return viewBag;
    }

    protected abstract void setViewBagInfo(Dictionary<String, Object> viewBag);

    public AbsController(ViewInterface view) {
        this.dao = getDao();
        this.view = view;
        loadList();
        // thực hiện cài đặt controller cho view
        viewBag = new Hashtable<>();
        setViewBagInfo(viewBag);
        this.view.setController(this);
    }

    public void loadList() {
        // Lấy danh sách bàn ăn từ database
        List<T> banAns = dao.getAll();
        // hiển thị ra view
        List<Object[]> data = banAns.stream()
                .map(q -> q.getAllValues())
                .collect(Collectors.toList());
        view.viewList(data);
        view.setColumnNames(this.getTableColumnNames());
    }

    /**
     * Insert đối tượng vào database
     *
     * @param values giá trị của các feild trong dto
     */
    public void insert(Object[] values) {
        // tạo dto
        T dto = dao.createDto();
        // set value vào dtoS
        dto.setValue(values);
        // kiểm tra lỗi
        List<ConstraintViolation> errorList = validate(dto);
        if (errorList.isEmpty()) {
            // nếu không có lỗi
            dao.insert(dto);
            loadList();
        } else {
            // hiển thị lỗi
            view.showErrors(errorList);
        }

    }
        public void insertNoLoadList(Object[] values) {
        // tạo dto
        T dto = dao.createDto();
        // set value vào dtoS
        dto.setValue(values);
        // kiểm tra lỗi
        List<ConstraintViolation> errorList = validate(dto);
        if (errorList.isEmpty()) {
            // nếu không có lỗi
            dao.insert(dto);
            
        } else {
            // hiển thị lỗi
            view.showErrors(errorList);
        }

    }

    /**
     * *
     * Kiểm tra lỗi của dto
     *
     * @param dto đối tượng insert, udpate
     * @return Danh sách lỗi
     */
    public List<ConstraintViolation> validate(T dto) {
        Validator validator = new Validator();
        List<ConstraintViolation> validateResult = validator.validate(dto);
        return validateResult;
    }

    // viết hàm edit
    public void edit(Object[] values) {
        // tạo dto
        T dto = dao.createDto();
        // set value vào dto
        dto.setValue(values);
        // kiểm tra lỗi
        List<ConstraintViolation> errorList = validate(dto);
        if (errorList.isEmpty()) {
            // nếu không có lỗi
            dao.edit(dto);
            loadList();
        } else {
            // hiển thị lỗi
            view.showErrors(errorList);
        }
    }

    // viết hàm delete 
    
    public void delete(int id) {
        dao.delete(id);
        loadList();
    }

    /**
     * *
     * Lấy toàn bộ giá trị của đối tượng và đổ vào một mảng value
     *
     * @param id id của đối tượng
     * @return mảng chứa dữ liệu đổ vào
     */
    public Object[] getObjectById(int id) {
        T dto = dao.getById(id);
        if (dto != null) {
            return dto.getAllValues();
        }
        return null;
    }

    // đặt tên cho controller
    public abstract String getName();
}
