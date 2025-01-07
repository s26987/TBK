package com.app.landingpage.headers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/headers")
public class HeaderController {

    private final HeaderService headerService;

    @Autowired
    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @GetMapping
    public List<Header> getAllHeaders() {
        return headerService.getAllHeaders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Header> getHeaderById(@PathVariable String id) {
        return headerService.getHeaderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Header createHeader(@RequestBody Header header) {
        return headerService.createHeader(header);
    }

    @PutMapping("/{id}")
    public Header updateHeader(@PathVariable String id, @RequestBody Header updatedHeader) {
        return headerService.updateHeader(id, updatedHeader);
    }

    @DeleteMapping("/{id}")
    public void deleteHeader(@PathVariable String id) {
        headerService.deleteHeader(id);
    }
}
