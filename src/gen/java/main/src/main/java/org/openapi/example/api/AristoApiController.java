package org.openapi.example.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-26T23:18:41.423035-05:00[America/New_York]")
@Controller
@RequestMapping("${openapi.aristoStopTransactions.base-path:}")
public class AristoApiController implements AristoApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AristoApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
