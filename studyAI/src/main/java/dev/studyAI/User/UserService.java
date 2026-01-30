package dev.studyAI.User;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO save(UserDTO userDTO) {
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public Set<UserDTO> all() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::map)
                .collect(Collectors.toSet());
    }

    public UserDTO findUser(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.map(userMapper::map)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserDTO alterUser(UserDTO userDTO, Long id) {
        UserModel updatingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        userMapper.updateUserFromDto(userDTO, updatingUser);
        return userMapper.map(userRepository.save(updatingUser));
    }

    public void deleteUser(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(id);
    }
}