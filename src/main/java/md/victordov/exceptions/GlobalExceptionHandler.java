package md.victordov.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: vdovgaliuc
 * Date: 8/30/13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public
    @ResponseBody
    String handleBusinessException(Exception ex) {
        return "Error details";

    }
}