package com.handehdy.northwind.api.controllers;
import com.handehdy.northwind.business.abstracts.UserService;
import com.handehdy.northwind.core.entities.User;
import com.handehdy.northwind.core.utilities.results.DataResult;
import com.handehdy.northwind.core.utilities.results.ErrorDataResult;
import com.handehdy.northwind.core.utilities.results.Result;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid  @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
