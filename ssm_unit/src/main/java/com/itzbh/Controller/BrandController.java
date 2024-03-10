package com.itzbh.Controller;

import com.itzbh.domain.Brand;
import com.itzbh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @PostMapping
    public boolean insert(@RequestBody Brand brand) {
        return brandService.insert(brand);
    }
    @PutMapping
    public boolean update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }
    @DeleteMapping("/{id}")
    public boolean deletebyid(@PathVariable int id) {
       return brandService.deletebyid(id);
    }
    @DeleteMapping("/{ids}")
    public boolean deletebyids(@PathVariable int[] ids) {
       return brandService.deletebyids(ids);
    }
    @GetMapping("/{id}")
    public Brand selectbyid(@PathVariable int id) {
        return brandService.selectbyid(id);
    }

    @GetMapping
    public List<Brand> selectAll() {
        return brandService.selectAll();
    }
}
