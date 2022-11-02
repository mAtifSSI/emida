package com.emdia.employee.controller

import javassist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.server.ResponseStatusException

class ErrorMessageModel(
    var status: Int? = null,
    var message: String? = null
)

@ControllerAdvice
class AdviceController {
    @ExceptionHandler(NotFoundException ::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleItemNotFoundException(
        itemNotFoundException: NotFoundException
    ): ResponseEntity<ErrorMessageModel>? {
        return ResponseEntity
            .status(org.springframework.http.HttpStatus.NOT_FOUND)
            .body(ErrorMessageModel(
                org.springframework.http.HttpStatus.NOT_FOUND.value(),
                "Requested Resource does not exists."
            ))
    }

    @ExceptionHandler(ResponseStatusException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoSuchElementFoundException(
        exception: ResponseStatusException
    ): ResponseEntity<ErrorMessageModel>? {
        return ResponseEntity
            .status(org.springframework.http.HttpStatus.NOT_FOUND)
            .body(ErrorMessageModel(
                org.springframework.http.HttpStatus.NOT_FOUND.value(),
                exception.message
            ))
    }
}