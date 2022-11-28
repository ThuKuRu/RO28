package service;

import entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface IDepartmentService {
    public List<Department> getListDepartment() throws SQLException;

    void creteDepartment(Department request) throws SQLException;

    void updateDepartment(Department request) throws SQLException;

    void deleteDepartment(Department request) throws SQLException;


}
