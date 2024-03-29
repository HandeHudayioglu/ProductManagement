package com.handehdy.northwind.business.abstracts;

import com.handehdy.northwind.core.entities.User;
import com.handehdy.northwind.core.utilities.results.DataResult;
import com.handehdy.northwind.core.utilities.results.Result;

public interface UserService {

    Result add(User user);
    DataResult<User> findByEmail(String email);
}
