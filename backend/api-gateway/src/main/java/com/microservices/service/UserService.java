package com.microservices.service;

import com.microservices.dto.UserRequestDto;
import com.microservices.dto.UserResponseDto;
import com.microservices.model.User;
import com.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        // Validate email and DNI uniqueness
        if (userRepository.findByEmail(userRequestDto.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (userRepository.findByDNI(Integer.parseInt(userRequestDto.getDNI())) != null) {
            throw new IllegalArgumentException("DNI already exists");
        }

        // Create new user
        User user = new User();
        String[] nameParts = userRequestDto.getNyAP().split(" ");
        user.setFirstName(nameParts[0]);
        user.setLastName(nameParts.length > 1 ? nameParts[1] : "");
        user.setDNI(Integer.parseInt(userRequestDto.getDNI()));
        user.setEmail(userRequestDto.getEmail());
        user.setPhone(userRequestDto.getPhone());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setCVU(generateCVU());
        user.setAlias(generateAlias());

        // Save user to repository
        user = userRepository.save(user);

        // Create response DTO
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getUserId());
        userResponseDto.setNyAP(userRequestDto.getNyAP());
        userResponseDto.setDNI(userRequestDto.getDNI());
        userResponseDto.setEmail(userRequestDto.getEmail());
        userResponseDto.setPhone(userRequestDto.getPhone());
        userResponseDto.setCVU(user.getCVU());
        userResponseDto.setAlias(user.getAlias());

        return userResponseDto;
    }

    private String generateCVU() {
        Random random = new SecureRandom();
        StringBuilder cvu = new StringBuilder();
        for (int i = 0; i < 22; i++) {
            cvu.append(random.nextInt(10));
        }
        return cvu.toString();
    }

    private String generateAlias() {
        List<String> words = List.of("sunny", "river", "oak", "mountain", "sky", "forest", "cloud", "star", "moon", "ocean");
        Random random = new SecureRandom();
        return words.get(random.nextInt(words.size())) + "." +
               words.get(random.nextInt(words.size())) + "." +
               words.get(random.nextInt(words.size()));
    }
}
