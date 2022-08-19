package net.armanit.bank.controller;

import lombok.extern.slf4j.Slf4j;
import net.armanit.bank.model.Branch;
import net.armanit.bank.model.Response;
import net.armanit.bank.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    BranchRepository branchRepository;

    @PostMapping("/create")
    public ResponseEntity<Response> createBranch(@RequestBody Branch branch) {
        branchRepository.save(branch);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response("200", "Branch created successfully."));
    }
}
