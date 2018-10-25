package com.ddfdesign.msanimals.feign;

import com.ddfdesign.msanimals.feign.dto.ClientDTO;
import com.ddfdesign.msanimals.feign.dto.SpecyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "clients-ms")
public interface IClient {
    @RequestMapping("/clientList")
    public List<ClientDTO> getAllClientsList();
}
