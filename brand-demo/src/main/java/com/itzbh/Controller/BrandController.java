package com.itzbh.Controller;

import com.itzbh.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrandController {

    @RequestMapping("/deletebyid")
    @ResponseBody
    public String deletebyid(@RequestBody int id){
        BrandService brandService=new BrandService();
        try {
            brandService.deletebyid(id);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }
}
