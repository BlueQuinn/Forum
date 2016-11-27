package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.model.Badge;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/badge")
public class BadgeController extends RestfulController<Badge>
{
}
