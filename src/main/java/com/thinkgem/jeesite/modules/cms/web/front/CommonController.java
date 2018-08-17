/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web.front;

import java.util.List;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.cms.entity.*;
import com.thinkgem.jeesite.modules.cms.entity.Process;
import com.thinkgem.jeesite.modules.cms.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 网站Controller
 *
 * @author ThinkGem
 * @version 2013-5-29
 */
@Controller
@RequestMapping(value = "${frontPath}")
public class CommonController extends BaseController {

    @Autowired
    private AdService adService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private MainProductService mainProductService;

    @Autowired
    private BusinessMovementService businessMovementService;

    @Autowired
    private ServiceAdvantageService serviceAdvantageService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private BusinessModelService businessModelService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private BusinessProductHeadService businessProductHeadService;

    @Autowired
    private ProductCaseService productCaseService;

    /**
     * 关于我们
     */
    @RequestMapping(value = "aboutUs", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        CompanyInfo companyInfo = new CompanyInfo();
        CompanyInfo param = new CompanyInfo();
        List<CompanyInfo> list = companyInfoService.findList(param);
        if (!list.isEmpty()) {
            companyInfo = list.get(0);
        }
        Ad adParam = new Ad();
        List<Ad> adList = adService.findList(adParam);
        Process processParam = new Process();
        List<Process> processList = processService.findList(processParam);
        ServiceAdvantage param1 = new ServiceAdvantage();
        List<ServiceAdvantage> serviceAdvantageList = serviceAdvantageService.findList(param1);
        model.addAttribute("serviceAdvantageList",serviceAdvantageList);
        model.addAttribute("ad", adList != null ? adList.get(0) : null);
        model.addAttribute("companyInfo", companyInfo);
        model.addAttribute("processList", processList);
        return "modules/cms/front/themes/pc/aboutUs";
    }

    /**
     * 公司首页
     *
     * @param
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String companyInfo(Model model) {
        CompanyInfo companyInfo = new CompanyInfo();
        CompanyInfo param = new CompanyInfo();
        List<CompanyInfo> list = companyInfoService.findList(param);
        if (!list.isEmpty()) {
            companyInfo = list.get(0);
        }
        Ad adParam = new Ad();
        adParam.setStatus("1");
        List<Ad> adList = adService.findList(adParam);

        Partner param1 = new Partner();
        List<Partner> partnerList = partnerService.findList(param1);
        model.addAttribute("partnerList", partnerList);
        model.addAttribute("adList", adList);
        model.addAttribute("companyInfo", companyInfo);
        return "modules/cms/front/themes/pc/index";
    }

    /**
     * 主打产品
     *
     * @param
     * @return
     */
    @RequestMapping(value = "business")
    public String business(Model model) {
        WebResponse<List<MainProduct>> webResponse = new WebResponse<List<MainProduct>>();
        MainProduct param = new MainProduct();
        List<MainProduct> list = mainProductService.findList(param);
        webResponse.setBody(list);
        return "modules/cms/front/themes/pc/business";
    }

    /**
     * 联系我们
     *
     * @param
     * @return
     */
    @RequestMapping(value = "contact")
    public String contact(Model model) {
        CompanyInfo companyInfo = new CompanyInfo();
        CompanyInfo param = new CompanyInfo();
        List<CompanyInfo> list = companyInfoService.findList(param);
        if (!list.isEmpty()) {
            companyInfo = list.get(0);
        }
        Ad adParam = new Ad();
        List<Ad> adList = adService.findList(adParam);
        model.addAttribute("ad", adList != null ? adList.get(0) : null);
        model.addAttribute("companyInfo",companyInfo);
        return "modules/cms/front/themes/pc/contact";
    }


    /**
     * 招聘信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "recruitment")
    public String businessMovement(Model model) {
        CompanyInfo companyInfo = new CompanyInfo();
        CompanyInfo param = new CompanyInfo();
        List<CompanyInfo> list = companyInfoService.findList(param);
        if (!list.isEmpty()) {
            companyInfo = list.get(0);
        }
        Position param1 = new Position();
        List<Position> positionList = positionService.findList(param1);
        Ad adParam = new Ad();
        List<Ad> adList = adService.findList(adParam);
        model.addAttribute("ad", adList != null ? adList.get(0) : null);
        model.addAttribute("companyInfo",companyInfo);
        model.addAttribute("positionList",positionList);
        return "modules/cms/front/themes/pc/recruitment";
    }

    /**
     * 服务优势
     *
     * @param
     * @return
     */
    @RequestMapping(value = "success")
    @ResponseBody
    public String success(Model model) {
        WebResponse<List<ServiceAdvantage>> webResponse = new WebResponse<List<ServiceAdvantage>>();
        ServiceAdvantage param = new ServiceAdvantage();
        List<ServiceAdvantage> serviceAdvantageList = serviceAdvantageService.findList(param);
        BusinessMovement param1 = new BusinessMovement();
        List<BusinessMovement> businessMovementList = businessMovementService.findList(param1);
        webResponse.setBody(serviceAdvantageList);
        return "modules/cms/front/themes/pc/successDemo";
    }

    /**
     * 服务流程
     *
     * @param
     * @return
     */
    @RequestMapping(value = "process")
    @ResponseBody
    public WebResponse<List<Process>> process() {
        WebResponse<List<Process>> webResponse = new WebResponse<List<Process>>();
        Process param = new Process();
        List<Process> processList = processService.findList(param);
        webResponse.setBody(processList);
        return webResponse;
    }


    /**
     * 经营模式
     *
     * @param
     * @return
     */
    @RequestMapping(value = "businessModel")
    @ResponseBody
    public WebResponse<List<BusinessModel>> businessModel() {
        WebResponse<List<BusinessModel>> webResponse = new WebResponse<List<BusinessModel>>();
        BusinessModel param = new BusinessModel();
        List<BusinessModel> businessModelList = businessModelService.findList(param);
        webResponse.setBody(businessModelList);
        return webResponse;
    }

    /**
     * 职位
     *
     * @param
     * @return
     */
    @RequestMapping(value = "position")
    @ResponseBody
    public WebResponse<List<Position>> position() {
        WebResponse<List<Position>> webResponse = new WebResponse<List<Position>>();
        Position param = new Position();
        List<Position> positionList = positionService.findList(param);
        webResponse.setBody(positionList);
        return webResponse;
    }

    /**
     * 经营产品
     *
     * @param
     * @return
     */
    @RequestMapping(value = "businessProduct")
    @ResponseBody
    public WebResponse<List<BusinessProductHead>> businessProduct() {
        WebResponse<List<BusinessProductHead>> webResponse = new WebResponse<List<BusinessProductHead>>();
        BusinessProductHead param = new BusinessProductHead();
        List<BusinessProductHead> businessProductHeadList = businessProductHeadService.findList(param);
        webResponse.setBody(businessProductHeadList);
        return webResponse;
    }

    /**
     * 产品案例
     *
     * @param
     * @return
     */
    @RequestMapping(value = "productCase")
    @ResponseBody
    public WebResponse<List<ProductCase>> productCase() {
        WebResponse<List<ProductCase>> webResponse = new WebResponse<List<ProductCase>>();
        ProductCase param = new ProductCase();
        List<ProductCase> productCaseList = productCaseService.findList(param);
        webResponse.setBody(productCaseList);
        return webResponse;
    }


    /**
     * 横幅广告
     *
     * @param
     * @return
     */
    @RequestMapping(value = "banner")
    @ResponseBody
    public WebResponse<Ad> banner() {
        WebResponse<Ad> webResponse = new WebResponse<Ad>();
        Ad param = new Ad();
        List<Ad> adList = adService.findList(param);
        if (!adList.isEmpty()) {
            webResponse.setBody(adList.get(0));
        }
        return webResponse;
    }
}
