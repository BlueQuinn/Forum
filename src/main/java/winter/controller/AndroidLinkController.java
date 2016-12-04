package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lequan on 12/4/2016.
 */
@Controller
@RequestMapping("/.well-known/assetlinks.json")
public class AndroidLinkController
{
    @ResponseBody
    @GetMapping
    public String getAssetLinks()
    {
        return "[{\n" +
                "  \"relation\": [\"delegate_permission/common.handle_all_urls\"],\n" +
                "  \"target\": {\n" +
                "    \"namespace\": \"android_app\",\n" +
                "    \"package_name\": \"com.example.applink\",\n" +
                "    \"sha256_cert_fingerprints\":\n" +
                "    [\"14:6D:E9:83:C5:73:06:50:D8:EE:B9:95:2F:34:FC:64:16:A0:83:42:E6:1D:BE:A8:8A:04:96:B2:3F:CF:44:E5\"]\n" +
                "  }\n" +
                "}]";
    }
}
