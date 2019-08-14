package cn.appsys.controller.developer;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DeveloperService;
import cn.appsys.tools.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevLoginController {

    private Log logger = LogFactory.getLog(DevLoginController.class);
    @Autowired
    private DeveloperService developerService;

    @RequestMapping(value="/login")
    public String login(){
        logger.debug("LoginController welcome AppInfoSystem develpor==================");
        return "devlogin";
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dologin(@RequestParam("devCode")String devCode,
                          @RequestParam("devPassword") String devPassword,
                          HttpSession session, HttpServletRequest request){

        DevUser devUser = developerService.doLogin(devCode, devPassword);
        if (null!=devUser){
            session.setAttribute(Constants.USER_SESSION,devUser);
            return "developer/main";
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确");
            return "devlogin";
        }
    }
}
