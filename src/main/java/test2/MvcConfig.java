//package test2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.LinkedList;
//
///**
// * @Package: test2
// * @ClassName: MvcConfig
// * @Author: 86150
// * @Description:
// * @Date: 2021/10/16 20:48
// */
//@Component
//public class MvcConfig implements WebMvcConfigurer {
//    @Autowired
//    private AuthorizationInterceptor authorizationInterceptor;
//    /***
//     * 拦截器配置
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationInterceptor).
//                addPathPatterns("/**").
//                excludePathPatterns("/user/login");
//
//        LinkedList linkedList = new LinkedList();
//        for (int i=0;i<linkedList.size();i++){
//
//        }
//    }
//
//
//}
