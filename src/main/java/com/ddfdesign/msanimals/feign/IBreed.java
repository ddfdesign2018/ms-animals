package com.ddfdesign.msanimals.feign;

import com.ddfdesign.msanimals.feign.dto.BreedDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "breeds-ms")
public interface IBreed {
    @RequestMapping("/breedList")
    public List<BreedDTO> getAllBreedsList();
}