package com.bysj.satoken.handle.exceptionhandler;


import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import com.bysj.satoken.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

@ApiIgnore
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public Response error(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return Response.error().message("输入的数据和已有的重复了");
    }

    @ExceptionHandler(TestException.class)
    @ResponseBody
    public Response test(TestException e) {
        e.printStackTrace();
        return Response.error().code(e.getCode()).message(e.getMsg());
    }


    @ExceptionHandler(UsernameNotFondException.class)
    @ResponseBody
    public Response usernameNotFond(UsernameNotFondException e) {
        return Response.error().code(e.getCode()).message(e.getMsg());
    }

    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public Response NotLoginException(NotLoginException e) {
        return Response.error().code(20003).message("账户没有登陆");
    }

    @ExceptionHandler(NotRoleException.class)
    @ResponseBody
    public Response NotRoleException(NotRoleException e) {
        return Response.error().code(20004).message("账户角色不匹配");
    }

    @ExceptionHandler(NotPermissionException.class)
    @ResponseBody
    public Response NotPermissionException(NotPermissionException e) {
        return Response.error().code(20005).message("账户没有权限");
    }

    @ExceptionHandler(SaTokenException.class)
    @ResponseBody
    public Response SaTokenException(SaTokenException e) {
        if (e instanceof NotPermissionException) {
            return Response.error().code(20005).message("账户没有权限");
        }else if (e instanceof NotRoleException){
            return Response.error().code(20004).message("账户角色不匹配");
        }else {
            return Response.error().code(20003).message("账户没有登陆");
        }
    }


    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
