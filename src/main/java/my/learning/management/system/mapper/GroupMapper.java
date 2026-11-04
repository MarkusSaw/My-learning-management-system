package my.learning.management.system.mapper;


import my.learning.management.system.dto.GroupResponse;
import my.learning.management.system.model.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupResponse toResponse(Group entity);
    List<GroupResponse> toResponseList(List<Group> entities);

    Group toGroup(GroupResponse response);
}
