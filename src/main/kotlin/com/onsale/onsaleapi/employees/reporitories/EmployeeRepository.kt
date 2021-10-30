package com.onsale.onsaleapi.employees.reporitories

import com.onsale.onsaleapi.employees.entities.Employee
import com.onsale.onsaleapi.shared.types.ID
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository: IEmployeeRepository {
    override fun create(employee: Employee): Employee {
        // TODO: implement real saving
        return employee;
    }

    override fun getAll(): Array<Employee> {
        TODO("Not yet implemented")
    }

    override fun getById(id: ID): Employee? {
        TODO("Not yet implemented")
    }

    override fun update(id: ID): Employee {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: ID) {
        TODO("Not yet implemented")
    }
}