package com.travel.travelplan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.travel.travelplan.dto.JoinDTO;
import com.travel.travelplan.entity.User;
import com.travel.travelplan.repository.UserRepository;
@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 데이터를 DB에 넣기 위함
    public void joinProcess(JoinDTO joinDTO) {


        //db에 이미 동일한 username을 가진 회원이 존재하는지 검사해야함..
        boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());
        if(isUser){ //동일한 username이 있다면 return
            return;
        }

        User data = new User();

        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword())); //비밀번호 암호화
        data.setRole("ROLE_ADMIN"); // 일단 무조건 admin으로 해봄 나중에 변경예정


        userRepository.save(data);
    }
}