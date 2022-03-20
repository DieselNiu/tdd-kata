package yes.tdd.users.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import yes.tdd.users.application.*;
import yes.tdd.users.application.vo.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
    private @Resource FetchUserUseCase fetchUserUseCase;
    private @Resource RegisterUserUseCase registerUserUseCase;
    private @Resource FetchAllUsersUseCase fetchAllUsersUseCase;

    @GetMapping("/all")
    public UserOutputs fetchAllUsers() {
        return fetchAllUsersUseCase.execute();
    }

    @GetMapping("/{id}")
    public UserOutput fetchById(@PathVariable String id) {
        return fetchUserUseCase.execute(id);
    }

    @PostMapping
    public String register(@RequestBody UserInput user) {
        return registerUserUseCase.execute(user);
    }
}
