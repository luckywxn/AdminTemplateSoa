package com.strongculture.service.service.common;

import org.springframework.web.bind.annotation.RequestParam;

public interface IdService {
    String createdUUID();
    String createdNumber();
    String createdValidCode();
    String encodeMd5(@RequestParam(value = "srcStr", required = true) String srcStr);
    String encodeDes(@RequestParam(value = "srcStr", required = true) String srcStr);
    String decodeDes(@RequestParam(value = "passStr", required = true) String passStr);

}
