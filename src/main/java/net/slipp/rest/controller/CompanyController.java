package net.slipp.rest.controller;

import net.slipp.rest.domain.Company;
import net.slipp.rest.repository.CompanyRepository;
import net.slipp.rest.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ihoneymon
 * Date: 13. 7. 22
 */
@Controller
@RequestMapping("/companies")
public class CompanyController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Inject
    private CompanyRepository companyRepository;
    @Inject
    private CompanyService companyService;


    @RequestMapping(value="/{company}", method= RequestMethod.GET)
    public String getCompany2(@PathVariable("company") Long companyId, ModelMap map) {
        Company company = companyService.findCompanyById(companyId);
        map.put("company", company);

        map.put("code", "200");
        map.put("message", "");
        map.put("data", company);

        return "jsonView";
    }

    @RequestMapping(value="/{company}", method= RequestMethod.GET)
    public String getCompany(@PathVariable("company") Company company, ModelMap map) {
        map.put("company", company);
        return "jsonView";
    }
}
