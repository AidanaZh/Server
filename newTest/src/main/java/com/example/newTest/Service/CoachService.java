package com.example.newTest.Service;


import com.example.newTest.entity.Coach;
import com.example.newTest.entity.CoachRegister;
import com.example.newTest.entity.User_info;
import com.example.newTest.repositories.CoachRepository;
import com.example.newTest.repositories.User_infoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    @Autowired
    public CoachRepository coachRepository;
    @Autowired
    User_infoRepository userInfoRepository;

    public Coach coachRegister(CoachRegister coachRegister) {
        User_info user_info = new User_info(null, coachRegister.getLogin(), coachRegister.getPassword(), "coach");
        User_info user_info2 = userInfoRepository.save(user_info);
        Coach coach = new Coach(null, coachRegister.getKod(), coachRegister.getName(), coachRegister.getSurname(), user_info2);
        return coachRepository.save(coach);
    }
}
