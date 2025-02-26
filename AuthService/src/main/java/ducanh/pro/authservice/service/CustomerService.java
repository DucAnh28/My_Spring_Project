package ducanh.pro.authservice.service;

import ducanh.pro.authservice.domain.user.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final AppUserRepo appUserRepo;

    
}
