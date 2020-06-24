package com.wf.common.config;

import com.wf.common.dto.Response;
import com.wf.common.dto.RetCode;
import com.wf.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ControllerAdvice + @ExceptionHandler 实现全局的 Controller 层的异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 处理所有校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Response response = new Response();
        response.setCode(RetCode.ERR_VALID_PARAM.getCode());
        response.setMsg(RetCode.ERR_VALID_PARAM.getMsg());
        response.setDesc(e.getMessage());
        return response;
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {BusinessException.class})
    @ResponseBody
    Response handleBusinessException(BusinessException e) {
        Response response = new Response();
        response.setCode(e.getRetCode().getCode());
        response.setMsg(e.getRetCode().getMsg());
        response.setDesc(e.getMessage());
        return response;
    }

    /**
     * 处理所有不受控异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseBody
    Response handleRuntimeException(RuntimeException e) {
        Response response = new Response();
        response.setCode(RetCode.EXCEPTION.getCode());
        response.setMsg(RetCode.EXCEPTION.getMsg());
        response.setDesc(e.getMessage());
        logger.info("RuntimeException", e);
        return response;
    }

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    Response handleException(Exception e) {
        Response response = new Response();
        response.setCode(RetCode.EXCEPTION.getCode());
        response.setMsg(RetCode.EXCEPTION.getMsg());
        response.setDesc(e.getMessage());
        logger.info("Exception", e);
        return response;
    }
}
