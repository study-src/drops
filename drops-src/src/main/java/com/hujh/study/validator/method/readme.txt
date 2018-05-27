方法级别的验证
首先注册 MethodValidationPostProcessor
<bean class="org.springframework.validation.beanvalidation.MethodValidationPostProcessor">  
    <!-- 可以引用自己的 validator 配置，在本文中（下面）可以找到 validator 的参考配置，如果不指定则系统使用默认的 -->
    <property name="validator" ref="validator"/>  
</bean>

或者：
@Bean
public MethodValidationPostProcessor methodValidationPostProcessor() {  
  return new MethodValidationPostProcessor();
}
