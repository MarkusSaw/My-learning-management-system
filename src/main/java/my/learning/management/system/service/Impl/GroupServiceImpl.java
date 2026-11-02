package my.learning.management.system.service.Impl;


import lombok.RequiredArgsConstructor;
import my.learning.management.system.dao.GroupRepository;
import my.learning.management.system.dto.GroupResponse;
import my.learning.management.system.exception.BadRequestException;
import my.learning.management.system.exception.NotFoundException;
import my.learning.management.system.mapper.GroupMapper;
import my.learning.management.system.model.Group;
import my.learning.management.system.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public Page<GroupResponse> findAllGroups(Pageable pageable) {
        return groupRepository.findAll(pageable).map(groupMapper::toResponse);
    }

    @Override
    public GroupResponse findGroupById(Long id) {
        return groupRepository.findById(id).map(groupMapper::toResponse).orElseThrow(() -> new NotFoundException(
                String.format("Группа с id %d не найдена", id)));
    }

    @Override
    @Transactional
    public GroupResponse create(GroupResponse groupResponse) {
        if (groupRepository.existsByTitle(groupResponse.getTitle())) {
            throw new BadRequestException(String.format("Группа с названием '%s' уже существует" , groupResponse.getTitle()));
        }
        Group group = groupMapper.toGroup(groupResponse);
        return groupMapper.toResponse(groupRepository.save(group));
    }

    @Override
    @Transactional
    public GroupResponse update(Long id, GroupResponse groupResponse) {
        Group existingGroup = groupRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Группа с id %d не найдена", id)));
        if (!existingGroup.getTitle().equals(groupResponse.getTitle())
                && groupRepository.existsByTitle(groupResponse.getTitle())) {
            throw new BadRequestException(String.format("Группа с названием '%s' уже существует", groupResponse.getTitle()));
        }
        Group group = groupMapper.toGroup(groupResponse);
        group.setId(id);
        return groupMapper.toResponse(groupRepository.save(group));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!groupRepository.existsById(id)) {
            throw new NotFoundException(String.format("Группа с id %d не найдена", id));
        }
        groupRepository.deleteById(id);
    }

}
