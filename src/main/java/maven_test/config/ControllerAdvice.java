package maven_test.config;

import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler
    public String ExceptionHandler(Exception e){
        e.printStackTrace();
        return "redirect:/error"; // 에러페이지로 이동
    }
}
