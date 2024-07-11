package com.relatech.cachemanager.mapper;

import com.relatech.cachemanager.dto.UserCacheDTO;
import com.relatech.cachemanager.model.UserCache;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;

import java.util.List;

@Mapper(componentModel = "spring", mappingControl = DeepClone.class)
public interface UserCacheMapper {

    UserCacheDTO userCacheToUserCacheDTO(UserCache user);
    UserCache userCacheDTOToUserCache(UserCacheDTO userCacheDTO);

    List<UserCacheDTO> userCachesToUserCacheDTOs(List<UserCache> users);
    List<UserCache> userCacheDTOsToUserCaches(List<UserCacheDTO> userCacheDTOS);
}
