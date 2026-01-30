package dev.studyAI.User;

import dev.studyAI.History.HistoryDTO;
import dev.studyAI.History.HistoryMapper;
import dev.studyAI.History.HistoryModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T13:51:22-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public UserDTO map(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userModel.getId() );
        userDTO.setUserName( userModel.getUserName() );
        userDTO.setUserAge( userModel.getUserAge() );
        userDTO.setUserGmail( userModel.getUserGmail() );
        userDTO.setHistoryModelsSet( historyModelSetToHistoryDTOSet( userModel.getHistoryModelsSet() ) );

        return userDTO;
    }

    @Override
    public UserModel map(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userDTO.getId() );
        userModel.setUserName( userDTO.getUserName() );
        userModel.setUserAge( userDTO.getUserAge() );
        userModel.setUserGmail( userDTO.getUserGmail() );
        userModel.setHistoryModelsSet( historyDTOSetToHistoryModelSet( userDTO.getHistoryModelsSet() ) );

        return userModel;
    }

    @Override
    public void updateUserFromDto(UserDTO dto, UserModel entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getUserName() != null ) {
            entity.setUserName( dto.getUserName() );
        }
        if ( dto.getUserAge() != null ) {
            entity.setUserAge( dto.getUserAge() );
        }
        if ( dto.getUserGmail() != null ) {
            entity.setUserGmail( dto.getUserGmail() );
        }
        if ( entity.getHistoryModelsSet() != null ) {
            Set<HistoryModel> set = historyDTOSetToHistoryModelSet( dto.getHistoryModelsSet() );
            if ( set != null ) {
                entity.getHistoryModelsSet().clear();
                entity.getHistoryModelsSet().addAll( set );
            }
        }
        else {
            Set<HistoryModel> set = historyDTOSetToHistoryModelSet( dto.getHistoryModelsSet() );
            if ( set != null ) {
                entity.setHistoryModelsSet( set );
            }
        }
    }

    protected Set<HistoryDTO> historyModelSetToHistoryDTOSet(Set<HistoryModel> set) {
        if ( set == null ) {
            return null;
        }

        Set<HistoryDTO> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( HistoryModel historyModel : set ) {
            set1.add( historyMapper.map( historyModel ) );
        }

        return set1;
    }

    protected Set<HistoryModel> historyDTOSetToHistoryModelSet(Set<HistoryDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<HistoryModel> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( HistoryDTO historyDTO : set ) {
            set1.add( historyMapper.map( historyDTO ) );
        }

        return set1;
    }
}
