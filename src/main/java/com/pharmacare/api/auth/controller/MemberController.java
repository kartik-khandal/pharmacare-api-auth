package com.pharmacare.api.auth.controller;

import com.pharmacare.api.auth.response.ResponseData;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Demonstrates method-level authorization that can depend on both role and resource. */
@RestController
@RequestMapping("/api/members")
public class MemberController {

    @GetMapping("/{memberId}")
    // @P names the method parameter for the SpEL expression used by @PreAuthorize.
    @PreAuthorize(
            "hasAuthority('ADMIN') or @securityService.canReadMember(authentication, #memberId)"
    )
    public ResponseData<String> getMember(@PathVariable @P("memberId") Long memberId) {
        return new ResponseData<>(true, "Member " + memberId, "Member retrieved successfully");
    }
}
