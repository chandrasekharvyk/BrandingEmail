package com.mrll.manda.hackathon.q3.controller;

import com.mrll.manda.hackathon.q3.model.BrandingEmailResponse;
import com.mrll.manda.hackathon.q3.model.MessageSubstitutionParameters;
import com.mrll.manda.hackathon.q3.service.BrandingEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(value = "API for sending Branding Emails", tags = "Message Template")
@RestController
@RequestMapping(
        value = "/javelin/api/core/messagetemplate/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BrandingEmailController {
    private static final Logger LOG = LoggerFactory.getLogger(BrandingEmailController.class);

    private BrandingEmailService brandingEmailService;

    public BrandingEmailController(BrandingEmailService brandingEmailService) {

        this.brandingEmailService = brandingEmailService;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Javelin Authorization token",
                    dataType = "string", paramType = "header", defaultValue = "Bearer X")
    })
    @ApiOperation(value = "", notes = "Return email template for the messageTemplateType")
    @PostMapping("/{messageTemplateType}")
    public BrandingEmailResponse getEmailTemplate(@PathVariable String messageTemplateType, @RequestBody MessageSubstitutionParameters messageSubstitutionParameters) throws IOException,Exception {
        LOG.info("message=gettingMessageTemplate templateName={} to send Branding Email", messageTemplateType);
        return brandingEmailService.sendBrandingEmail(messageSubstitutionParameters.getMessageParameters(),messageTemplateType);
    }
}
