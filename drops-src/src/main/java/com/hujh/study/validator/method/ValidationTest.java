package com.hujh.study.validator.method;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.junit.Test;
 
 
public class ValidationTest {
 
    /**
     * 当前demo中所有的关于 都不再使用Bean Validation 1.0（JSR-303）旧标准，
     * 目前使用的是 Bean Validation 1.1（JSR-349）
     * 
     * 此方法是用来学习Validator的使用
     *              1、如何拿到Validator的hibernate实现
     *              2、如何拿到校验失败的相关信息
     *              3、User的字段tranDate上面使用了一个自定义注解（如果你需要自定义，可以参照这个）
     * User最终在这里是校验不通过的，因为要求了tranDate必须是大于或者今天
     * @throws ParseException
     */
    @Test
    public void defaultValidator() throws ParseException{
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        User user = new User("admin","123456",DateUtils.parseDate("2018-11-11", new String[] {"yyyy-MM-dd"}));
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for(ConstraintViolation<User> data:violations){
            System.out.println(data.getPropertyPath().toString() + ":" + data.getMessage());
        }
    }
 
    /**
     * 此方法和是对上面一个方法的补充，上面都是用的默认值
     * 而这里面拿到Validator的都是自己一个个指定相关配置，
     *              1、比如指定实现类HibernateValidator
     *              2、比如指定properties资源文件
     *              3、比如指定是否返回所有校验字段的异常信息（默认返回所有）
     */
    @Test
    public void hibernateValidator(){
        Validator validator = Validation.byProvider(HibernateValidator.class).configure()
                .messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("message/validate")))
                .failFast(false)
                .buildValidatorFactory().getValidator();
        User user = new User("adm#in","12345",new Date());
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for(ConstraintViolation<User> data:violations){
            System.out.println(data.getPropertyPath().toString() + ":" + data.getMessage());
        }
    }
 
    /**
     * 此方法是用来验证Bean Validation规范的新支持(方法级别验证)，这里验证方法中的参数是否符合规范
     * 注意：这里需要拿到的不再是Validator，而是ExecutableValidator
     * 如果方法中的参数是对象model类型，记得加@Valid 注解
     * @throws NoSuchMethodException
     */
//    @Test
//    public void validateParameters() throws NoSuchMethodException{
//        ExecutableValidator executableValidator = Validation.byProvider(HibernateValidator.class).configure()
//                .messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("message/validate")))
//                .failFast(false)
//                .buildValidatorFactory().getValidator().forExecutables();
//        UserValidator object = new UserValidator();
//        Method method = object.getClass().getMethod( "verify", new Class[]{User.class} );
//        Object[] parameterValues = {new User("adm#in","12345",new Date())};
//        Set<ConstraintViolation<UserValidator>> violations = executableValidator.validateParameters(
//                object,
//                method,
//                parameterValues
//        );
//        for(ConstraintViolation<UserValidator> data:violations){
//            System.out.println(data.getPropertyPath().toString() + ":" + data.getMessage());
//        }
//    }
// 
    /**
     * 此方法是用来验证Bean Validation规范的新支持(方法级别验证)，这里验证方法中的返回值是否符合规范
     * 这些写法在硬编码这里略显笨拙，但是一旦和切面一起使用将是一把利器，再也不用傻傻的在每个方法中去做校验了
     * 本项目已经做了相关示例，详细请见src/main/java中的【com.somnus.solo.support.aspect.ValidationAspect】
     * @throws NoSuchMethodException
     */
//    @Test
//    public void validateReturnValue() throws NoSuchMethodException{
//        ExecutableValidator executableValidator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();
//        UserValidator object = new UserValidator();
//        Method method = object.getClass().getMethod( "getUsers", new Class[]{} );
//        Object returnValue = object.getUsers();
//        Set<ConstraintViolation<UserValidator>> violations = executableValidator.validateReturnValue(
//                object,
//                method,
//                returnValue
//        );
//        for(ConstraintViolation<UserValidator> data:violations){
//            System.out.println(data.getPropertyPath().toString() + ":" + data.getMessage());
//        }
//    }
 
}