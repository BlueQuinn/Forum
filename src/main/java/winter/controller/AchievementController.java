package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.model.Achievement;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/achievement")
public class AchievementController extends RestfulController<Achievement>
{
}
