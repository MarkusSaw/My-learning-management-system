package my.learning.management.system.controller;


import lombok.RequiredArgsConstructor;
import my.learning.management.system.dto.GroupResponse;
import my.learning.management.system.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public Page<GroupResponse> getAllGroups(Pageable pageable) {
        return groupService.findAllGroups(pageable);
    }


    @GetMapping("/{id}")
    public GroupResponse getGroupById(@PathVariable Long id) {
        return groupService.findGroupById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupResponse create(@RequestBody GroupResponse groupResponse) {
        return groupService.create(groupResponse);
    }

    @PutMapping("/{id}")
    public GroupResponse update(@PathVariable Long id, @RequestBody GroupResponse groupResponse) {
        return groupService.update(id, groupResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }


}
