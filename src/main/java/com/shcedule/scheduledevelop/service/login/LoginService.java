package com.shcedule.scheduledevelop.service.login;

import com.shcedule.scheduledevelop.common.config.PasswordEncoder;
import com.shcedule.scheduledevelop.common.entity.Member;
import com.shcedule.scheduledevelop.dto.login.LoginResponseDto;
import com.shcedule.scheduledevelop.repository.login.LoginRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDto login(String memberId,String password) {
        Optional<Member> byMemberId = loginRepository.findByMemberId(memberId);

        if(byMemberId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"아이디 또는 비밀번호가 잘못됐습니다");
        }

        Member member = byMemberId.get();

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "아이디 또는 비밀번호가 잘못됐습니다");
        }

        return new LoginResponseDto(member.getMemberId());
    }
}
