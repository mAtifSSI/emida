package com.emdia.employee.service

import com.emdia.employee.model.Employee
import com.emdia.employee.repository.EmployeeRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
//@Component
class EmployeeService(val accountClientService: AccountClientService,val employeeRepository: EmployeeRepository){

   // lateinit var accountClientService: AccountClientService;


      fun getItems(): String {

        //if(::accountClientService.isInitialized) {
            return accountClientService?.getItems()!!
      //  }
        //return null;
    }
   fun getAll(): List<Employee> = employeeRepository.findAll()
//
    fun getById(id: Long): Employee = employeeRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
//
   fun create(employee: Employee): Employee = employeeRepository.save(employee)
//
    fun remove(id: Long) {
       if (employeeRepository.existsById(id)) employeeRepository.deleteById(id)
       else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
//
   fun update(id: Long, employee: Employee): Employee {
        return if (employeeRepository.existsById(id)) {
            employee.id = id
            employeeRepository.save(employee)
       } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
   }
}