package com.emdia.employee.controller

import com.emdia.employee.model.Employee
import com.emdia.employee.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class EmployeeController (private val employeeService: EmployeeService){

//    @Autowired
//    public lateinit var employeeService: EmployeeService;

    @GetMapping(value = ["/"])
    fun getAccount(): String? {
        return employeeService.getItems();
    }
    @GetMapping(value = ["/employees"])
    fun getAllEmployees() = employeeService.getAll()

    // Save Employee in DB
    @PostMapping(value = ["/employee"])
    fun savePlayer(@RequestBody employee: Employee): Employee = employeeService.create(employee)
//
//    // Update Employee
    @PutMapping(value = ["/employee/{id}"])
    fun updateEmployee(
            @PathVariable id: Long, @RequestBody employee: Employee
    ) = employeeService.update(id, employee)
//
//    // Find Emmployee by ID
   @GetMapping(value = ["/employee/{id}"])
    fun getEmployee(@PathVariable id: Long) = employeeService.getById(id)
//
//    // Delete Emmployee by ID
   @DeleteMapping(value = ["/employee/{id}"])
   fun deleteEmployee(@PathVariable id: Long) = employeeService.remove(id)
}