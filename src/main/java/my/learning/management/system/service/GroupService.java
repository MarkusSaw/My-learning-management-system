package my.learning.management.system.service;

import my.learning.management.system.dto.GroupResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupService {
    Page<GroupResponse> findAllGroups(Pageable pageable);
    GroupResponse findGroupById(Long id);
    GroupResponse create(GroupResponse groupResponse);
    GroupResponse update(Long id, GroupResponse groupResponse);
    void delete(Long id);
}
