package winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winter.dao.ChallengeDAO;
import winter.dto.Criteria;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * Created by lequan on 1/17/2017.
 */
@Transactional
@Service("challengeService")
public class ChallengeService
{
    @Autowired
    ChallengeDAO dao;

    public ArrayList get(int limit)
    {
        return dao.get(limit);
    }
}
