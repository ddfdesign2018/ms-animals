package com.ddfdesign.msanimals.feign;

import com.ddfdesign.msanimals.feign.dto.SpecyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "species-ms")
public interface ISpecy {
    @RequestMapping("/specyList")
    public List<SpecyDTO> getAllSpeciesList();
}