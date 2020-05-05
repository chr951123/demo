package com.tsune.vhr02.exception;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.tsune.vhr02.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if (e instanceof MySQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败！");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
}
