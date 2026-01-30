package dev.studyAI.User;

import dev.studyAI.History.HistoryMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel="spring", uses = {HistoryMapper.class})
public interface UserMapper {

    UserDTO map(UserModel userModel);
    UserModel map(UserDTO userDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserDTO dto, @MappingTarget UserModel entity);
}
