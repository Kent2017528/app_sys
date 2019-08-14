package cn.appsys.service.developer;


import cn.appsys.pojo.DevUser;

public interface DeveloperService {

   public DevUser doLogin(String devCode,String devPassword);
}
