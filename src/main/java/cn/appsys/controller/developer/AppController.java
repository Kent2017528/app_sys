package cn.appsys.controller.developer;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DataDictionary.DataDictionaryService;
import cn.appsys.service.developer.appCategory.AppCategoryService;
import cn.appsys.service.developer.appinfo.AppinfoService;
import cn.appsys.tools.Constants;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dev/flatform/app")
public class AppController {
    private Log logger = LogFactory.getLog(AppController.class);

    @Autowired
    private AppinfoService appinfoService;
    @Autowired
    DataDictionaryService dataDictionaryService;
    @Autowired
    AppCategoryService appCategoryService;
    @Value("${currentPageNo}")
    private String currentPageNo;
    @Value("${pageSize}")
    private String pageSize;

    @RequestMapping("/list")
    public String appList(@RequestParam(value = "pageIndex",required = false) String currentPageNo,
                          @RequestParam(value = "pageSize",required = false) String pageSize,
                          HttpSession session, Model model){
        this.currentPageNo=(currentPageNo==null||currentPageNo=="")?this.currentPageNo:currentPageNo;
        this.pageSize=(pageSize==null||pageSize=="")?this.pageSize:pageSize;

        DevUser devUser = (DevUser) session.getAttribute(Constants.DEV_USER_SESSION);
        Long id = devUser.getId();
        PageInfo<AppInfo> pageInfo = appinfoService.getAppList(id,
                Integer.parseInt(this.currentPageNo),
                Integer.parseInt(this.pageSize));

        List<DataDictionary> statusList = dataDictionaryService.getStatusList();
        List<DataDictionary> flatFormList = dataDictionaryService.getFlatFormList();
        List<AppCategory> categoryLevel1List = appCategoryService.getAppCategorys(null);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("statusList", statusList);
        model.addAttribute("flatFormList", flatFormList);
        model.addAttribute("categoryLevel1List", categoryLevel1List);

        return "developer/appinfolist";
    }

    @RequestMapping("/categorylevellist.json")
    @ResponseBody
    public String categoryLevelList(@RequestParam("pid") Long pId){
        logger.debug("getAppCategoryList pid ============ " + pId);
        List<AppCategory> appCategorys = appCategoryService.getAppCategorys(pId);
        String jsonString = JSON.toJSONString(appCategorys);
        logger.debug(jsonString);
        return jsonString;

    }
}
