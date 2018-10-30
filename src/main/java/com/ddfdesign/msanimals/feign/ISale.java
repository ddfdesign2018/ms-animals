package com.ddfdesign.msanimals.feign;

import com.ddfdesign.msanimals.feign.dto.SaleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "sales-ms")
public interface ISale {
    @RequestMapping("/saleList")
    public List<SaleDTO> getAllSalesList();
}
