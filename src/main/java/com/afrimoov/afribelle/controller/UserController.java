package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.SearchCriteria;
import com.afrimoov.afribelle.dto.UserDto;
import com.afrimoov.afribelle.exceptions.NotFoundException;
import com.afrimoov.afribelle.service.IUserService;
import com.afrimoov.afribelle.utils.SearchCriteriaUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/utilisateurs")
@Slf4j
public class UserController {

    static String SEARCH_PARAM = "%s:*%s*,";

    @Autowired
    IUserService userService;

    @PostMapping(value = "/saveUtilisateur")
    public ResponseEntity<List<UserDto>> saveUtilisateur(@RequestBody List<UserDto> users) {
        return ResponseEntity.ok(userService.savesUsers(users));
    }

    @PutMapping(value = "/updateUtilisateur")
    public ResponseEntity<List<UserDto>> updateUtilisateur(@RequestBody List<UserDto> users) throws NotFoundException {
        return ResponseEntity.ok(userService.updatesUsers(users));
    }

    @DeleteMapping(value = "/deleteUtilisateur")
    public ResponseEntity<List<Long>> deleteUtilisateur(@RequestBody List<Long> users) {
        return ResponseEntity.ok(userService.deleteUsers(users));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAll( @RequestParam(name="page", required = false, defaultValue = "0") int page,
                                          @RequestParam(name="size", required = false, defaultValue = "50") int size) {
        final Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.getAll(pageable));
    }


    @GetMapping(value = "/getUtilisateurById")
    public ResponseEntity<UserDto> getById(@RequestParam(name = "id") Long id) throws NotFoundException {
        return ResponseEntity.ok(userService.findByUserId(id));
    }

    @GetMapping(value = "/searchUtilisateursByName")
    public ResponseEntity<Page<UserDto>> searchUserByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name="page", required = false, defaultValue = "0") int page,
            @RequestParam(name="size", required = false, defaultValue = "50") int size
    ) {
        String searchToken = String.format(SEARCH_PARAM, "name", name);
        return ResponseEntity.ok(findByCriterais(searchToken, page, size));
    }

    @GetMapping(value = "/searchByUniqueUserName")
    @ApiOperation(value = "find user by his unique username, will return user if found or create a new user if not found")
    public ResponseEntity<UserDto> findByUniqueUserName(@RequestParam(name = "userName") String userName) {
        return ResponseEntity.ok(userService.findByUserUniqueName(userName));
    }

    private Page<UserDto> findByCriterais(String searchToken, int page, int size) {
        final Pageable pageRequest = PageRequest.of(page, size);

        final List<SearchCriteria> criterias = SearchCriteriaUtils.build(searchToken);
        return userService.findByCriteria(criterias, pageRequest);
    }
}
