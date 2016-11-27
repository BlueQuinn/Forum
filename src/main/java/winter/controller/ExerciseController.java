package winter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import winter.model.Exercise;

/**
 * Created by lequan on 11/20/2016.
 */
@Controller
@RequestMapping("/api/excercise")
public class ExerciseController extends RestfulController<Exercise>
{
}
