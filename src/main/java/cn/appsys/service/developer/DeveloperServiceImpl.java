package cn.appsys.service.developer;

import cn.appsys.dao.DevUserMapper;
import cn.appsys.pojo.DevUser;
import cn.appsys.pojo.DevUserExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    public DevUser doLogin(String devCode, String devPassword) {
        DevUserExample example=new DevUserExample();
        example.createCriteria().andDevCodeEqualTo(devCode);
        List<DevUser> list = devUserMapper.selectByExample(example);
        if (list.size()>0&&null!=list){
            DevUser devUser = list.get(0);
            if (devUser.getDevPassword().equals(devPassword)){
                return devUser;
            }
        }
        return null;
    }
}
