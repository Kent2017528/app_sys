package cn.appsys.service.developer.devUser;



import cn.appsys.pojo.DevUser;



public interface DevUserService {

   public DevUser doLogin(String devCode,String devPassword);


}
