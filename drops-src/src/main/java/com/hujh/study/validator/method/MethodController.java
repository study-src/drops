package com.hujh.study.validator.method;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {
	
	@Autowired
	ValidatorTestService validatorTestService; // 里边有方法级别的验证
	
	/**
     * 测试方法级别的验证（如果验证失败，则会抛出异常 ConstraintViolationException）
     *
     * @param name
     * @param model
     * @return
     * @author SHANHY
     * @create  2016年4月17日
     */
    @RequestMapping("/test5")
    @ResponseBody
    public Model test5(String name, String password, Model model){
        try {
            String content = validatorTestService.getContent(name, password);
            model.addAttribute("name", content);
        } catch (ConstraintViolationException e) {
            addErrorMessage(model, e);
        }
        return model;
    }

    /**
     * 添加错误消息，建议将该方法提取为一个公共的方法使用。
     *
     * @param model
     * @param e
     * @author SHANHY
     * @create  2016年5月4日
     */
    protected void addErrorMessage(Model model, ConstraintViolationException e){
        Map<String, String> errorMsg = new HashMap<>();
        model.addAttribute("errorMsg", errorMsg);

        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            // 获得验证失败的类 constraintViolation.getLeafBean()
            // 获得验证失败的值 constraintViolation.getInvalidValue()
            // 获取参数值 constraintViolation.getExecutableParameters()
            // 获得返回值 constraintViolation.getExecutableReturnValue()
            errorMsg.put(constraintViolation.getLeafBean().getClass().getName() + "-" + constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
    }
    
    
    
    
    
}
