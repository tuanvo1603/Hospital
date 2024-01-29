package project.hospital.service;

import org.springframework.stereotype.Service;
import project.hospital.token.Token;

@Service
public class SessionService {

    public boolean isValid(Token token) {
        //to-do
        return true;
    }

    public void updateRecentActivity(Token token) {

    }
}
