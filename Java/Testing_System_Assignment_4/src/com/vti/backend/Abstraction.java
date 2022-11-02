package com.vti.backend;

import com.vti.entity.Abstraction.Question1.Phone;
import com.vti.entity.Abstraction.Question1.VietnamesePhone;
import com.vti.entity.Abstraction.Question2_3.Employee;
import com.vti.entity.Abstraction.Question2_3.Manager;
import com.vti.entity.Abstraction.Question2_3.Waiter;

public class Abstraction {
    public void question1() {
        Phone phone = new VietnamesePhone();
        phone.insertContact("ThuKuRu", "0865456605");
        phone.removeContact("ThuKuRu");
        phone.updateContact("ThuKuRu", "0987847442");
        phone.searchContact("ThuKuRu");
    }

    public void question2_3() {
        Employee employee = new Employee("Nguyễn Thị Thu", 6.8);
        employee.displayInfo();

        Manager manager = new Manager("Trần Quốc Khánh", 8.6);
        manager.displayInfo();

        Waiter waiter = new Waiter("Trịnh Bá Hoàng", 5.6);
        waiter.displayInfo();
    }
}
