package be.technifutur.benjamiche.controller;

import be.technifutur.benjamiche.form.SandwichForm;
import be.technifutur.benjamiche.model.dto.SandwichDTO;
import be.technifutur.benjamiche.service.SandwichService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping("/all")
    public List<SandwichDTO> getAllSandwiches(){
        return sandwichService.getAll();
    }

    @GetMapping("/{id}")
    public SandwichDTO getOneSandwich(@PathVariable long id){
        return sandwichService.getOne(id);
    }

    @PostMapping("/create")
    public void createSandwich(@RequestBody @Valid SandwichForm form){
        sandwichService.createSandwich(form);

    }

}
